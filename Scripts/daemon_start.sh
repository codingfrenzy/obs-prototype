#!/bin/bash

apt-get -y install curl
#vmip=`curl -s checkip.dyndns.org | sed -e 's/.*Current IP Address: //' -e 's/<.*$//'`
vmip=$(curl -s https://api.ipify.org)

# Get latest code and Start Daemon Manager
cd /home/ubuntu/obsv-code/com/observability/monitoring/daemon/
pkill -f DaemonManager
rm *
wget -q https://github.com/observability/obs-prototype/raw/master/src/main/java/com/observability/monitoring/daemon/DaemonManager.java
wget -q https://github.com/observability/obs-prototype/raw/master/src/main/java/com/observability/monitoring/daemon/DaemonHeartbeatClient.java
wget -q https://github.com/observability/obs-prototype/raw/master/src/main/java/com/observability/monitoring/daemon/IDaemonManagerServer.java
cd /home/ubuntu/obsv-code/
javac com/observability/monitoring/daemon/*.java
java com/observability/monitoring/daemon/DaemonManager $vmip 8200 > DaemonManager 2>&1 &

# Start the db
sh /home/ubuntu/redis_start.sh
sh /home/ubuntu/mongo_start.sh
sh /home/ubuntu/cassandra_start.sh
sh /home/ubuntu/postgre_start.sh

# Start collectd
cd /home/ubuntu/
#echo "Hostname $vmip" >> collectd.conf
sh stop_collectd.sh
sh start_collectd.sh

echo "SCRIPT ENDED SUCCESSFULLY!"
