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

package com.observability.client;

import com.observability.monitoring.server.IModelHandlerServer;


import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Deploy is the client program of the ModelHandler. It connects with the server
 * using RMI and transfers the generated configuration files to the server.
 *
 * @author vsaravag
 *         <p/>
 *         History <br>
 *         1. Create			June 23 2015 <br>
 */
public class ModelVersioning {

    private static String rmiIP = null;

    private static String rmiPort = null;

    private static IModelHandlerServer svr = null;
    //maximum size of a block for file transfer
    private static int MAX_BLOCK_SIZE = 1024 * 512;

    public static void main(String[] args) {
        String rmiIP = "52.6.202.212";
        String rmiPort = "8101";
        String input;
        Scanner in = new Scanner(System.in, "UTF-8");

        System.out.println("Welcome to Observability");

        System.out.print("Enter IP of Observability Main Server (default - " + rmiIP + "): ");
        input = in.nextLine();
        if (!input.equals("")) {
            rmiIP = input;
        }

        System.out.print("Enter Port of Observability Main Server (default - " + rmiPort + "): ");
        input = in.nextLine();
        if (!input.equals("")) {
            rmiPort = input;
        }

        try {
            ModelVersioning.connectRMI(rmiIP, rmiPort);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        boolean exit = false;
        int option, rollback;
        do {
            System.out.println("Choose your option:");
            System.out.println("1. View currently deployed model name.");
            System.out.println("2. View all daemons.");
            System.out.println("3. View IPs of daemons that failed to receive currently deployed model.");
            System.out.println("4. Resend configuration files to those unsuccessfully deployed daemons.");
            System.out.println("5. View all models.");
            System.out.println("6. Propogate a previous model.");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            option = in.nextInt();
            ArrayList<String> models;

            try {
                initIpPort(rmiIP, rmiPort);
                switch (option) {
                    case 1:
                        System.out.println("Currently deployed model: " + viewCurrentModel());
                        break;
                    case 2:
                        System.out.println("All daemon IPs are:\n" + viewAllIPs());
                        break;
                    case 3:
                        System.out.println("Failed IPs are:\n" + viewFailedIPs());
                        break;
                    case 4:
                        System.out.println("Resending to failed IPs");
                        resendFailedDaemons();
                        break;
                    case 5:
                        System.out.println("The models in the server are:");
                        models = viewAllModels();
                        for (int i = 0; i < models.size(); i++) {
                            System.out.println(models.get(i));
                        }
                        break;
                    case 6:
                        System.out.println("Enter the id of the model to rollback to (0 to cancel):");
                        models = viewAllModels();
                        for (int i = 0; i < models.size(); i++) {
                            System.out.println((i + 1) + ": " + models.get(i));
                        }
                        rollback = in.nextInt();

                        //cancel
                        if (rollback == 0)
                            break;

                        rollback--;
                        rollbackModel(models.get(rollback));
                        break;
                    case 0:
                    default:
                        exit = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("------");
            System.out.println();
        } while (!exit);

    }

    public static void initIpPort(String ip, String port) throws Exception {
        rmiIP = ip;
        rmiPort = port;
    }

    public static ArrayList<String> viewAllModels() throws Exception {
        if (svr == null) {
            connectRMI(rmiIP, rmiPort);
        }

        return svr.viewAllModels();
    }

    public static String viewCurrentModel() throws Exception {
        if (svr == null) {
            connectRMI(rmiIP, rmiPort);
        }

        return svr.viewCurrentModel();
    }

    public static String viewFailedIPs() throws Exception {
        if (svr == null) {
            connectRMI(rmiIP, rmiPort);
        }

        HashSet<String> ipList = svr.viewFailedIP();
        StringBuilder op = new StringBuilder();
        for (String ip : ipList) {
            op.append(ip + "\n");
        }
        if (op.length() == 0)
            return "No failed IPs! Hurray!";
        else
            return op.toString();
    }

    public static String viewAllIPs() throws Exception {
        if (svr == null) {
            connectRMI(rmiIP, rmiPort);
        }

        HashSet<String> ipList = svr.viewAllIP();
        StringBuilder op = new StringBuilder();
        for (String ip : ipList) {
            op.append(ip + "\n");
        }
        return op.toString();
    }

    public static void rollbackModel(String modelName) throws Exception {
        if (svr == null) {
            connectRMI(rmiIP, rmiPort);
        }

        System.out.println("Rolling back model to: " + modelName);
        int uploadStatus = svr.deployModel(modelName);
        if (uploadStatus < 0) {
            switch (uploadStatus) {
                case -1:
                    throw new RuntimeException("Error in zip file");
                case -2:
                    throw new RuntimeException("There has been an error in MD5 verification");
                case -3:
                    throw new RuntimeException("There has been an error on server");
                case -21:
                    throw new RuntimeException("The zip format is not supported");
                case -22:
                    throw new RuntimeException("The zip file is not valid");
                case -23:
                    throw new RuntimeException("The zip file cannot be read due to security reasons");
                case -24:
                    throw new RuntimeException("Target directory cannot be created");
            }
        } else {
            System.out.println("Model deploy attempt completed.");
        }
    }

    public static void resendFailedDaemons() throws Exception {
        if (svr == null) {
            connectRMI(rmiIP, rmiPort);
        }

        String currentModel = svr.viewCurrentModel();
        System.out.println("Re-deploying model " + currentModel + " to failed IPs.");
        int uploadStatus = svr.resendFailedModels(currentModel);
        if (uploadStatus < 0) {
            switch (uploadStatus) {
                case -1:
                    throw new RuntimeException("Error in zip file");
                case -2:
                    throw new RuntimeException("There has been an error in MD5 verification");
                case -3:
                    throw new RuntimeException("There has been an error on server");
                case -21:
                    throw new RuntimeException("The zip format is not supported");
                case -22:
                    throw new RuntimeException("The zip file is not valid");
                case -23:
                    throw new RuntimeException("The zip file cannot be read due to security reasons");
                case -24:
                    throw new RuntimeException("Target directory cannot be created");
            }
        } else {
            System.out.println("Model deploy attempt completed.");
        }
    }

    private static void connectRMI(String ip, String port) throws Exception {
        System.out.println("Connecting to server RMI...");

        try {
            svr = (IModelHandlerServer) Naming.lookup(String.format(
                    "//%s:%s/ModelHandler", ip, port));
        } catch (RemoteException e) {
            throw e;
            //throw new RemoteException("Failed to connect to the server (" + ip + ":" + port + ")");
        } catch (NotBoundException e) {
            throw new NotBoundException("Failed to connect to the server (" + ip + ":" + port + ")");
        } catch (MalformedURLException e) {
            throw new MalformedURLException("Please check Ip and Port provided");
        }

        if (svr == null) {
            throw new RuntimeException("Failed to bind with the server. Please check if the server is up and running");
        }
    }
}
