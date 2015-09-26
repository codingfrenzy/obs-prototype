sudo chown -R `whoami`:`groups ubuntu | awk '{print $3}'` grafana-auto-install.sh
cd
sudo apt-get update
sudo apt-get install graphite-web graphite-carbon

# Choose No at the 'Configuring graphite-carbon' prompt

cd /etc/graphite/
sudo rm local_settings.py
sudo wget https://raw.githubusercontent.com/observability/obs-prototype/master/config-files/graphite-config/local_settings.py
cd /etc/carbon/
sudo rm storage-schemas.conf
sudo wget https://raw.githubusercontent.com/observability/obs-prototype/master/config-files/graphite-config/storage-schemas.conf
sudo graphite-manage syncdb

# enter user and password for graphite

sudo chown -R _graphite:_graphite /var/lib/graphite/
sudo chmod 777 -R /var/lib/graphite/whisper/
sudo perl -pi -e 's/CARBON_CACHE_ENABLED=false/CARBON_CACHE_ENABLED=true/g' /etc/default/graphite-carbon
sudo perl -pi -e 's/ENABLE_LOGROTATION = False/ENABLE_LOGROTATION = True/g' /etc/carbon/carbon.conf
sudo sed -i "s|MAX_CREATES_PER_MINUTE = 50|MAX_CREATES_PER_MINUTE = 800000|" /etc/carbon/carbon.conf

sudo apt-get install apache2 libapache2-mod-wsgi
sudo a2dissite 000-default
sudo cp /usr/share/graphite-web/apache2-graphite.conf /etc/apache2/sites-available
sudo a2ensite apache2-graphite

# GRAFANA installation:

cd
sudo wget https://storage.googleapis.com/golang/go1.4.2.linux-amd64.tar.gz
sudo tar -C /usr/local -xzf go1.4.2.linux-amd64.tar.gz
sudo mkdir go
sudo chmod 777 go/
sudo echo "export PATH=$PATH:/usr/local/go/bin" >> $HOME/.bashrc
sudo echo "export GOPATH=$HOME/go" >> $HOME/.bashrc
. $HOME/.bashrc
cd go/
sudo wget https://github.com/observability/obs-prototype/raw/master/changed-framework-files/grafana/grafana-part-00 https://github.com/observability/obs-prototype/raw/master/changed-framework-files/grafana/grafana-part-01 https://github.com/observability/obs-prototype/raw/master/changed-framework-files/grafana/grafana-part-02 https://github.com/observability/obs-prototype/raw/master/changed-framework-files/grafana/grafana-part-03
cat grafana-part-0* > grafana.tar.gz
sudo rm grafana-part-0*
sudo tar -xvf grafana.tar.gz
sudo rm grafana.tar.gz
cd
echo 'sudo service apache2 start;sudo service carbon-cache start;cd $GOPATH/src/github.com/grafana/grafana/;./grafana &' > start_grafana.sh
echo 'sudo service apache2 stop;sudo service carbon-cache stop;sudo pkill -f grafana' > stop_grafana.sh
ln -s $GOPATH/src/github.com/grafana/grafana/public/app/components/settings.js $HOME/grafana-config.js