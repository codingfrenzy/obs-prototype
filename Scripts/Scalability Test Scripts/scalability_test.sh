#!/bin/sh

# This script is used on collected server to save metrics data. Make sure to create the directory: output


# Laila Alhmoud
# 7/7/2015


while true
do 

temp_cpu="`top -b -n1 | grep "Cpu(s)" | awk '{print $2 , $4 , $6 , $8 , $10 , $12 , $14 , $16}'`"
echo $temp_cpu | sed -e "s/^/$(date +%s) /" >> ~/output/output_cpu.txt 

temp_ram="`free -m`"
echo $temp_ram | sed -e "s/^/$(date +%s) /" >> ~/output/output_ram.txt

temp_disk="`df -k . |grep xvda1`"
echo $temp_disk | sed -e "s/^/$(date +%s) /" >> ~/output/output_disk.txt

temp_intraf="`ifstat -wan 1 1`"
echo $temp_intraf | sed -e "s/^/$(date +%s) /" >> ~/output/output_intraf.txt

temp_repacket="`cat /sys/class/net/eth0/statistics/rx_packets`"
echo $temp_repacket | sed -e "s/^/$(date +%s) /" >> ~/output/output_repacket.txt

temp_trpacket="`cat /sys/class/net/eth0/statistics/tx_packets`"
echo $temp_trpacket | sed -e "s/^/$(date +%s) /" >> ~/output/output_trpacket.txt

temp_erpacket="`netstat -s  |grep -i "packet receive errors"`"
echo $temp_erpacket | sed -e "s/^/$(date +%s) /" >> ~/output/output_erpacket.txt

sleep 1
done
