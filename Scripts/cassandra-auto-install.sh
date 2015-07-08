cd
wget http://mirrors.gigenet.com/apache/cassandra/2.0.16/apache-cassandra-2.0.16-bin.tar.gz
tar -xvf apache-cassandra-2.0.16-bin.tar.gz
sudo mkdir /var/lib/cassandra
sudo mkdir /var/log/cassandra
sudo mkdir /var/lib/cassandra/data
sudo chmod 777 -R /var/log/cassandra
sudo chmod 777 -R /var/lib/cassandra
cd
cd apache-cassandra-2.0.16/
sudo echo "export CASSANDRA_HOME=`pwd`" >> $HOME/.bashrc
. $HOME/.bashrc
sudo echo "export PATH=$PATH:$CASSANDRA_HOME/bin" >> $HOME/.bashrc
. $HOME/.bashrc
cd
echo "$CASSANDRA_HOME/bin/cassandra &" > start_cassandra.sh
echo "sudo pkill -f java" > stop_cassandra.sh