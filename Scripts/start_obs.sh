cd /home/ubuntu/obsv-code/
apt-get -y install curl
vmip=`curl -s checkip.dyndns.org | sed -e 's/.*Current IP Address: //' -e 's/<.*$//'`
java com/observability/monitoring/daemon/DaemonManager $vmip 8200 > DaemonManager 2>&1 &
cd /home/ubuntu/
sh stop_collectd.sh
sh start_collectd.sh
