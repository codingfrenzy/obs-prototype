#!/bin/bash

# Put below commands in /etc/rc.local:
# cd /home/ubuntu/
# rm -f /home/ubuntu/daemon_start.sh
# wget -q https://github.com/observability/obs-prototype/raw/master/Scripts/daemon_start.sh
# sh /home/ubuntu/daemon_start.sh redis

# install curl
apt-get -y install curl
#vmip=`curl -s checkip.dyndns.org | sed -e 's/.*Current IP Address: //' -e 's/<.*$//'`
vmip=$(curl -s https://api.ipify.org)

# Update the epoch time
apt-get -y install ntpdate
ntpdate -s ntp.ubuntu.com

# Get latest code and Start Daemon Manager
cd /home/ubuntu/obsv-code/com/observability/monitoring/daemon/
pkill -f DaemonManager
rm -f *
wget -q https://github.com/observability/obs-prototype/raw/master/src/main/java/com/observability/monitoring/daemon/DaemonManager.java
wget -q https://github.com/observability/obs-prototype/raw/master/src/main/java/com/observability/monitoring/daemon/DaemonHeartbeatClient.java
wget -q https://github.com/observability/obs-prototype/raw/master/src/main/java/com/observability/monitoring/daemon/IDaemonManagerServer.java

# Start DaemonManager
cd /home/ubuntu/obsv-code/
javac com/observability/monitoring/daemon/*.java
java com/observability/monitoring/daemon/DaemonManager $vmip 8200 > DaemonManager 2>&1 &

# Start the db
cd /home/ubuntu/
db=$1
if [ $db = "redis" ]; then
        echo "redis"
else if [ $db = "cassandra" ]; then
        echo "cassandra"  
else if [ $db = "postgre" ]; then
        echo "postgre"
else if [ $db = "mongo" ]; then
        echo "mongo"
fi
fi
fi
fi

rm -f /home/ubuntu/${db}_start.sh
wget -q https://github.com/observability/obs-prototype/raw/master/Scripts/${db}_start.sh
sh /home/ubuntu/${db}_start.sh

# Start collectd
cd /home/ubuntu/
#echo "Hostname $vmip" >> collectd.conf
sh stop_collectd.sh
sh start_collectd.sh

echo "SCRIPT ENDED SUCCESSFULLY!"
