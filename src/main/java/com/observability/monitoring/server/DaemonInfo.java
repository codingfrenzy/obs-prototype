//**************************************************************************************************//
/* Observability Project
 * Copyright 2015 Master of Software Engineering team: Laila Alhmound, Ying (Joel) Gao, Caglayan Gem, Rajat Kapoor, Prasanth Nair, Varun Saravagi
 * Copyright 2015 Institute for Software Research | School of Computer Science | Carnegie Mellon University
 * Copyright 2015 Software Engineering Institute
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses/>.
 */
//**************************************************************************************************//

 package com.observability.monitoring.server;

/**
 * DaemonInfo is a class to hold the information of each daemons.<br>
 * @author Prasanth Nair
 */
public class DaemonInfo {

    /**
     * IP of daemon
     */
    String ip;
    /**
     * epoch of the heartbeat of the daemon
     */
    String epoch;
    /**
     * the status of the collectd measurement collectiom
     */
    boolean metricStatus;

    /**
     * Default constructor
     * @param ip
     * @param epoch
     * @param metricStatus
     */
    public DaemonInfo(String ip, String epoch, boolean metricStatus) {
        this.ip = ip;
        this.epoch = epoch;
        this.metricStatus = metricStatus;
    }

    /**
     * Helper method to display the values of the current object.
     * @return
     */
    public String toString() {
        return ip + " : " + epoch + " : " + metricStatus;
    }

}
