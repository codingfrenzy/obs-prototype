# Run this script by: sh grafana-auto-install.sh
# Do not use : sudo sh grafana-auto-install.sh as that will fail GO commands
cd
sudo apt-get update
sudo apt-get install graphite-web graphite-carbon

# Choose No at the 'Configuring graphite-carbon' prompt

cd /etc/graphite/
sudo rm local_settings.py
sudo wget https://raw.githubusercontent.com/observability/obs-prototype/master/config-files/graphite-config/local_settings.py
sudo graphite-manage syncdb

# keep user as root and enter password as graphite

sudo perl -pi -e 's/CARBON_CACHE_ENABLED=false/CARBON_CACHE_ENABLED=true/g' /etc/default/graphite-carbon
sudo perl -pi -e 's/ENABLE_LOGROTATION = False/ENABLE_LOGROTATION = True/g' /etc/carbon/carbon.conf

sudo apt-get install apache2 libapache2-mod-wsgi
sudo a2dissite 000-default
sudo cp /usr/share/graphite-web/apache2-graphite.conf /etc/apache2/sites-available
sudo a2ensite apache2-graphite

# use sudo service carbon-cache start to start graphite

# GRAFANA installation:

cd
wget https://storage.googleapis.com/golang/go1.4.2.linux-amd64.tar.gz
sudo tar -C /usr/local -xzf go1.4.2.linux-amd64.tar.gz
sudo mkdir go
sudo chmod 777 go/
sudo echo "export PATH=$PATH:/usr/local/go/bin" >> $HOME/.bashrc
sudo echo "export GOPATH=$HOME/go" >> $HOME/.bashrc
. $HOME/.bashrc
echo This will take some time..
/usr/local/go/bin/go get github.com/grafana/grafana
cd $GOPATH/src/github.com/grafana/grafana
/usr/local/go/bin/go run build.go setup
$GOPATH/bin/godep restore
/usr/local/go/bin/go build .
cd
wget http://nodejs.org/dist/v0.12.0/node-v0.12.0.tar.gz
tar -xvf node-v0.12.0.tar.gz
cd node-v0.12.0/
./configure 
make
sudo make install
. $HOME/.bashrc
cd $GOPATH/src/github.com/grafana/grafana
sudo rm -rf node_modules
sudo npm install
sudo npm install -g grunt-cli
sudo grunt
cd
echo 'sudo service apache2 start;sudo service carbon-cache start;cd $GOPATH/src/github.com/grafana/grafana/;./grafana &' > start_grafana.sh
echo 'sudo service apache2 stop;sudo service carbon-cache stop;sudo pkill -f grafana' > stop_grafana.sh