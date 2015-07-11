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
        sleep 29
done