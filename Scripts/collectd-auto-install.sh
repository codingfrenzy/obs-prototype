cd
wget https://collectd.org/files/collectd-5.5.0.tar.gz
tar -xvf collectd-5.5.0.tar.gz
sudo apt-get update
sudo apt-get install build-essential
sudo apt-get install openjdk-7-jdk
sudo aptitude install libcurl4-openssl-dev
sudo echo "export JAVA_HOME=/usr/lib/jvm/java-1.7.0-openjdk-amd64" >> $HOME/.bashrc
. $HOME/.bashrc
cd
sudo rm collectd-5.5.0.tar.gz
cd collectd-5.5.0/
sudo ./configure --enable-redis --enable-postgresql --with-libcredis=/usr/include --with-java=$JAVA_HOME --enable-write_http
sudo make install
sudo chmod 777 -R /opt/collectd/
sudo chmod o-w -R /opt/collectd/

# here code can be added to replace collectd.conf file in /opt/collectd/etc by downloading from Git

cd
wget https://raw.githubusercontent.com/observability/obs-prototype/master/config-files/collectd.sh
echo "sudo /opt/collectd/sbin/collectd" > start_collectd.sh
echo "sudo pkill -f collectd" > stop_collectd.sh
ln -s /opt/collectd/etc/collectd.conf collectd.conf
sudo mkdir collectd
cd collectd
sudo mkdir log
sudo mkdir csv
cd
sudo chmod 777 -R collectd
sudo mkdir /opt/collectd/java-dep
sudo cp $HOME/collectd-5.5.0/bindings/java/.libs/generic-jmx.jar /opt/collectd/java-dep/
sudo cp $HOME/collectd-5.5.0/bindings/java/.libs/collectd-api.jar /opt/collectd/java-dep/