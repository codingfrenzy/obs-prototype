#!/bin/bash

cd /home/ubuntu/obsv-code/
apt-get -y install curl
#vmip=`curl -s checkip.dyndns.org | sed -e 's/.*Current IP Address: //' -e 's/<.*$//'`
vmip=$(curl -s https://api.ipify.org)

# Start Daemon Manager
java com/observability/monitoring/daemon/DaemonManager $vmip 8200 > DaemonManager 2>&1 &

# Start Redis
redis-server

# Start collectd
cd /home/ubuntu/
#echo "Hostname $vmip" >> collectd.conf
sh stop_collectd.sh
sh start_collectd.sh
