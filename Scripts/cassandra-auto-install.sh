cd
wget http://mirror.tcpdiag.net/apache/cassandra/2.0.15/apache-cassandra-2.0.15-bin.tar.gz
tar -xvf apache-cassandra-2.0.15-bin.tar.gz
sudo mkdir /var/lib/cassandra
sudo mkdir /var/log/cassandra
sudo chown -R $USER:$GROUP /var/log/cassandra
sudo chown -R $USER:$GROUP /var/lib/cassandra
cd
cd apache-cassandra-2.0.15/
sudo echo "export CASSANDRA_HOME=`pwd`" >> $HOME/.bashrc
. $HOME/.bashrc
sudo echo "export PATH=$PATH:$CASSANDRA_HOME/bin" >> $HOME/.bashrc
. $HOME/.bashrc
cd
echo "$CASSANDRA_HOME/bin/cassandra &" > start_cassandra.sh
echo "sudo pkill -f java" > stop_cassandra.sh