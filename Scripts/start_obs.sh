#!/bin/bash

cd /home/ubuntu/obsv-code/
#vmip=`curl -s checkip.dyndns.org | sed -e 's/.*Current IP Address: //' -e 's/<.*$//'`
vmip=$(curl -s https://api.ipify.org)

java com/observability/monitoring/daemon/DaemonManager $vmip 8200 > DaemonManager 2>&1 &
cd /home/ubuntu/
#echo "Hostname $vmip" >> collectd.conf
sh stop_collectd.sh
sh start_collectd.sh
