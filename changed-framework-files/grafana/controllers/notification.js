define([
        'angular',
        'lodash',
        'jquery',
        'config',
    ],
function (angular) {

    "use strict";

var notfapp=angular.module('grafana.controllers');
notfapp.controller('thresholdCtrl', function($scope,$http,$timeout) {
    $scope.thIntrvl = 30000;
    $scope.interval = 30;
    (function retrieveThresholds() {
        $http.get("http://localhost:8888/threshold.db/thresholds/")
            .success(function (response) {
                $scope.thresholds = response;
                $timeout(retrieveThresholds, $scope.thIntrvl);
            })
    })();

    $scope.changeThreshInterval = function(interval){
        if(interval>0) {
            $scope.thIntrvl = interval * 1000;
        }
    };

    $scope.removeRow = function(id){

        $http.delete("http://localhost:8888/threshold.db/thresholds/"+id)
            .success(function (response) {
                var index = -1;
                var threshArr = eval( $scope.thresholds );
                for( var i = 0; i < threshArr.length; i++ ) {
                    if( threshArr[i].id === id ) {
                        index = i;
                        break;
                    }
                }
                if( index === -1 ) {
                    alert( "Something's not right.." );
                }
                $scope.thresholds.splice( index, 1 );
            });
    };

    $scope.removeAllThresholds = function(){
        var threshArr = eval( $scope.thresholds );

        for( var i = 0; i < threshArr.length; i++ ) {
            $http.delete("http://localhost:8888/threshold.db/thresholds/"+threshArr[i].id)
                .success(function (response) {
                    $scope.thresholds.shift();
                });
        }
    };

    $scope.setStyle = function(type){
        if(type === 'OKAY')
            return {color : "green"}
        else if(type === 'WARNING')
            return {color : "orange"}
        else if(type === 'FAILURE')
            return {color : "red"}
        else
            return ""
    };
});
});
