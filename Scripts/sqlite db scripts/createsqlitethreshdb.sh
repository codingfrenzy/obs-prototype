sudo apt-get install sqlite3
cd
sudo mkdir sqlite-thresholddb
cd sqlite-thresholddb
sudo wget https://raw.githubusercontent.com/observability/obs-prototype/master/Scripts/sqlite%20db%20scripts/threshdbscript
sudo sqlite3 threshold.db < threshdbscript
sudo wget https://github.com/observability/obs-prototype/raw/master/changed-framework-files/restful-sqlite.tar.gz
sudo tar -xvf restful-sqlite.tar.gz
sudo rm restful-sqlite.tar.gz
sudo chmod 777 *
sudo chown -R `whoami`:`groups ubuntu | awk '{print $3}'` *
export currPath=`pwd`
cd restful-sqlite/
sudo sed -i "s|/home/owls/webservice/|$currPath/|g" settings.py
sudo apt-get install python-pip
sudo pip install tornado
export currPath=`pwd`
cd
echo "sudo python $currPath/web.py &" > start_thresholdWS.sh