#!/bin/bash
startme() {
    sudo /opt/collectd/sbin/collectd
}

stopme() {
    sudo pkill -f "collectd" 
    
}

case "$1" in 
    start)   startme ;;
    stop)    stopme ;;
    restart) stopme; startme ;;
    *) echo "usage: $0 start|stop|restart" >&2
       exit 1
       ;;
esac