# To download this script:
# wget https://raw.githubusercontent.com/observability/obs-prototype/master/Scripts/obsv-code-setup-daemon.sh

cd /home/ubuntu
sudo apt-get update
sudo apt-get -y install git
git clone https://github.com/observability/obs-prototype.git
mkdir obsv-code
cd obs-prototype/
mv src/main/java/com /home/ubuntu/obsv-code/
cd /home/ubuntu/obsv-code/
javac com/observability/monitoring/daemon/*.java
wget -q https://github.com/observability/obs-prototype/raw/master/libs/junit-4.11.jar
wget -q https://github.com/observability/obs-prototype/raw/master/libs/mail-1.4.7.jar
cd ..
sudo rm -r obs-prototype
ln -s obsv-code/com/observability/monitoring/daemon/ obs
echo "osbv-code folder is setup"
echo "obs shortcut to the .java folder is setup"
