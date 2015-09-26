define([
        'angular',
        'lodash',
        'jquery',
        'config',
    ],
function (angular, lodash, _, config) {

    "use strict";

    var modelchngapp = angular.module('grafana.controllers');

    modelchngapp.controller("modelchngCtrl", function ($scope, $http, $timeout) {
        $scope.modelchange = "false";

        if(getCookie("closedAt") == "")
            $scope.popupClosedAt = 0;
        else
            $scope.popupClosedAt = getCookie("closedAt");

        (function retrieveItems() {
            $http.get("http://"+ config.serverIp + ":8888/modelchange.db/modelchange/1")
                .success(function (response) {
                    if((response.timestamp > $scope.popupClosedAt || $scope.popupClosedAt == 0) && response.changed == "true") {
                        $scope.modelchange = "true";
                    }
                    else{
                        $scope.modelchange = "false";
                    }
                    $timeout(retrieveItems, 5000);
                })
        })();

        $scope.popupclosed = function(){
            var epoch = Math.floor(new Date().getTime()/1000);
            setCookie("closedAt",epoch,30);
            $scope.modelchange = "false";
            $scope.popupClosedAt = epoch;
        };
    });
});

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
    }
    return "";
}
