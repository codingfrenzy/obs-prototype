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

import java.io.File;

public class ConfigurationReader {
    /**
     * Filepath string where the log will be stored.
     */
    String filePath = "/home/owls/collectd.conf";


    public static String getValue(String keyName){
        return "";
    }

    public static String getWholeTag(String tagName){
        return "";
    }

    public static long lastModified(){
        File file = new File(filePath);
        long lastModified = file.lastModified() / 1000;
        return lastModified;
    }

    public static void main(String[] args) {
        System.out.println(ConfigurationReader.lastModified());
    }
}

