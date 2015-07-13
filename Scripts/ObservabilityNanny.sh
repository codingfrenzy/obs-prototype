#!/bin/sh

while [ 1 ]
do
        check=`jps | grep MetricDatabaseHandler`
        if [ "$check" ]
        then
                echo "MetricDatabaseHandler is running"
        else
                echo "MetricDatabaseHandler down. Respawning."
                java com.observability.monitoring.server.MetricDatabaseHandler $
        fi

        check=`jps | grep DaemonHeartbeatMain`
        if [ "$check" ]
        then
                echo "DaemonHeartbeatMain is running"
        else
                echo "DaemonHeartbeatMain down. Respawning."
                java com.observability.monitoring.server. DaemonHeartbeatMain > MissingDaemon 2>1& $
        fi

        check=`jps | grep ModelHandler`
        if [ "$check" ]
        then
                echo "ModelHandler is running"
        else
                echo "ModelHandler down. Respawning."
                java com.observability.monitoring.server. ModelHandler 52.6.202.212 8101 > ModelHandler 2>1& $
        fi

        sleep 29
done