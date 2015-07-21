#!/bin/sh

# This script is used on the load generator server to generate packets and send them to collected server. Make sure you create the directory sca_test_suite.out

# Laila Alhmoud
# 7/15/2015


echo “Starting Scalability test 1“ >> sca_test_suite.out
date +%s >> sca_test_suite.out
/opt/collectd/bin/collectd-tg -n 30 -H 1 -p 1 -i 30.0 -d 172.31.52.117  >> sca_test_suite.out
date +%s >> sca_test_suite.out
echo “Ended Scalability tests 1“ >> sca_test_suite.out
echo “ “
echo “##############################################”
echo “ “
sleep 300


echo “Starting Scalability test 2“ >> sca_test_suite.out
date +%s >> sca_test_suite.out
/opt/collectd/bin/collectd-tg -n 15000 -H 500 –p 1 -i 30.0 -d 172.31.52.117  >> sca_test_suite.out
date +%s >> sca_test_suite.out
echo “Ended Scalability tests 2“ >> sca_test_suite.out
echo “ “
echo “##############################################”
echo “ “
sleep 300

echo “Starting Scalability test 3“ >> sca_test_suite.out
date +%s >> sca_test_suite.out
/opt/collectd/bin/collectd-tg -n 30000 -H 1000 –p 1 -i 30.0 -d 172.31.52.117  >> sca_test_suite.out
date +%s >> sca_test_suite.out
echo “Ended Scalability tests 3“ >> sca_test_suite.out
echo “ “
echo “##############################################”
echo “ “
sleep 300

echo “Starting Scalability test 4“ >> sca_test_suite.out
date +%s >> sca_test_suite.out
/opt/collectd/bin/collectd-tg -n 75000 -H 2500 –p 1 -i 30.0 -d 172.31.52.117  >> sca_test_suite.out
date +%s >> sca_test_suite.out
echo “Ended Scalability tests 4“ >> sca_test_suite.out
echo “ “
echo “##############################################”
echo “ “
sleep 300

echo “Starting Scalability test 5“ >> sca_test_suite.out
date +%s >> sca_test_suite.out
/opt/collectd/bin/collectd-tg -n 150000 -H 5000 –p 1 -i 30.0 -d 172.31.52.117  >> sca_test_suite.out
date +%s >> sca_test_suite.out
echo “Ended Scalability tests 5” >> sca_test_suite.out
echo “ “
echo “##############################################”
echo “ “
sleep 300

echo “Starting Scalability test 6“ >> sca_test_suite.out
date +%s >> sca_test_suite.out
/opt/collectd/bin/collectd-tg -n 225000 -H 7500 –p 1 -i 30.0 -d 172.31.52.117  >> sca_test_suite.out
date +%s >> sca_test_suite.out
echo “Ended Scalability tests 6“ >> sca_test_suite.out
echo “ “
echo “##############################################”
echo “ “
sleep 300

echo “Starting Scalability test 7“ >> sca_test_suite.out
date +%s >> sca_test_suite.out
/opt/collectd/bin/collectd-tg -n 300000 -H 10000 –p 1 -i 30.0 -d 172.31.52.117  >> sca_test_suite.out
date +%s >> sca_test_suite.out
echo “Ended Scalability tests 7“ >> sca_test_suite.out
echo “ “
echo “##############################################”
echo “ “
sleep 300

echo “Starting Scalability test 8“ >> sca_test_suite.out
date +%s >> sca_test_suite.out
/opt/collectd/bin/collectd-tg -n 300000 -H 10000 -p 5 -i 30.0 -d 172.31.52.117  >> sca_test_suite.out
date +%s >> sca_test_suite.out
echo “Ended Scalability tests 8“ >> sca_test_suite.out
echo “ “
echo “##############################################”
echo “ “
sleep 300

echo “Starting Scalability test 9“ >> sca_test_suite.out
date +%s >> sca_test_suite.out
/opt/collectd/bin/collectd-tg -n 300000 -H 10000 -p 10 -i 30.0 -d 172.31.52.117  >> sca_test_suite.out
date +%s >> sca_test_suite.out
echo “Ended Scalability tests 9“ >> sca_test_suite.out
echo “ “
echo “##############################################”
echo “ “
sleep 300

echo “Starting Scalability test 10“ >> sca_test_suite.out
date +%s >> sca_test_suite.out
/opt/collectd/bin/collectd-tg -n 300000 -H 10000 -p 15 -i 30.0 -d 172.31.52.117  >> sca_test_suite.out
date +%s >> sca_test_suite.out
echo “Ended Scalability tests 10“ >> sca_test_suite.out
echo “ “
echo “##############################################”
echo “ “
sleep 300

echo “Starting Scalability test 11“ >> sca_test_suite.out
date +%s >> sca_test_suite.out
/opt/collectd/bin/collectd-tg -n 500000 -H 10000 -p 15 -i 30.0 -d 172.31.52.117  >> sca_test_suite.out
date +%s >> sca_test_suite.out
echo “Ended Scalability tests 11“ >> sca_test_suite.out
echo “ “
echo “##############################################”
echo “ “
sleep 300

echo “Starting Scalability test 12“ >> sca_test_suite.out
date +%s >> sca_test_suite.out
/opt/collectd/bin/collectd-tg -n 3000000 -H 10000 -p 15 -i 30.0 -d 172.31.52.117  >> sca_test_suite.out
date +%s >> sca_test_suite.out
echo “Ended Scalability tests 12“ >> sca_test_suite.out
echo “ “
echo “##############################################”
echo “ “

echo "TEST SUITE ENDED"

