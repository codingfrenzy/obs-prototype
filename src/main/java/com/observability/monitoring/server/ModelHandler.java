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

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import com.observability.monitoring.daemon.IDaemonManagerServer;

/**
 * ModelHandler is the a RMI service. It has the following functionalities:<br>
 * 1. Communicate with model editor to get configuration files<br>
 * 2. Save & unzip the files on disk<br>
 * 3. Propagate them to remote nodes by communicating with daemon manager<p>
 * <p/>
 * Tests:<br>
 * Model handler:<br>
 * java com.obrvability.monitoring.server.ModelHandler 128.237.201.134 17680<br>
 * Daemon manager:<br>
 * sudo java com.observability.moniting.daemon.DaemonManager 45.55.197.112 17670<br>
 *
 * @author Ying (Joel) Gao
 *         <p/>
 *         History:<br>
 *         1. Created					Jun 22 2015<br>
 *         2. Modified					Jun 23 2015<br>
 */

public class ModelHandler extends UnicastRemoteObject implements IModelHandlerServer {

    /**
     * Auto generated serial version id
     */
    private static final long serialVersionUID = 510701247259432165L;

    private static final String DESCRIPTORFILE = "descriptors.zip";

    private static final int MAX_BLOCK_SIZE = 1024 * 512;

    // Local map to associate the block number with its siz
    private static ConcurrentHashMap<Integer, Integer> blockSize = new ConcurrentHashMap<Integer, Integer>();

    // File object for handling uploaded zip file
    private transient RandomAccessFile rafZip = null;

    // File target name
    private String targetName = null;
    
    /**
	 * Strong reference to the server so it will not be GCed.
	 */
    private static IModelHandlerServer imhs = null;

    private String daemonManagerDefaultPort = "8200";

    protected ModelHandler() throws RemoteException {
        super();
    }

    private ArrayList<String> ipList = null;

    private String dashboardURL = "http://45.55.197.112:8888/modelchange.db/modelchange/1";

    private String currentModelFilePath() {
        return getModelDirectory() + File.separatorChar + "current_model";
    }

    private String getModelDirectory() {
        String canonicalPath = null;
        try {
            canonicalPath = new File(".").getCanonicalPath();
            String combinedPath = canonicalPath + "/models/";
            //System.out.println(combinedPath);
            return combinedPath;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get the target directory by the target name
     *
     * @param target the target name
     * @return directory path, null for error
     */
    private String getTargetFileDirectory(String target) {
        String combinedPath = getModelDirectory() + target;
        //System.out.println(combinedPath);
        return combinedPath;
    }

    /**
     * Get the zip file path by the target name
     *
     * @param target the target name
     * @return file path, null for error
     */
    private String getTargetFilePath(String target) {
        String ret = getTargetFileDirectory(target);
        //return (ret == null) ? null : (ret + ".zip");
        return (ret + ".zip");
    }

    private String makeFileName(String target) {
        if (target.endsWith(".zip")) {
            target = target.substring(0, target.length() - 4);
        }

        String dirName = target;
        final String finalFileName = target;
        File dir = new File(getModelDirectory());

        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(finalFileName + "(_[0-9]*)*");
            }
        });

        int count = 0;
        if (files != null)
            count = files.length;

        if (count >= 1)
            dirName += "_" + count;

        return dirName;
    }

    /**
     * Get the path of the descriptor file
     *
     * @return descriptor file path
     */
    private String getDescriptorFilePath() {
        return getModelDirectory() + File.separatorChar + DESCRIPTORFILE;
    }

    /**
     * @see com.observability.monitoring.server.IModelHandlerServer
     */
    @Override
    public boolean beginFileUpload(String target) throws RemoteException {

        target = makeFileName(target);
        System.out.println(target);

        // check the file object
        if (rafZip != null) {
            try {
                rafZip.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            rafZip = null;
        }

        try {
            targetName = target;
            // save it with zip appendix
            // in sub folder models
            String combinedPath = getTargetFilePath(target);
            // make sure the path exist
            File targetFile = new File(combinedPath);
            File parent = targetFile.getParentFile();
            if (!parent.exists() && !parent.mkdirs()) {
                return false;
            }

            // 2. Open the file from the beginning
            rafZip = new RandomAccessFile(combinedPath, "rw");
            rafZip.setLength(0);// start from 0
            System.out.println("----------Begin file uploading with target name: " + target);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        return false;
    }

    /**
     * @see com.observability.monitoring.server.IModelHandlerServer
     */
    @Override
    public boolean uploadFileChunk(byte[] buffer) throws RemoteException {
        if (rafZip == null)
            return false;

        try {
            // write file
            rafZip.write(buffer);
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }
        return false;
    }

    /**
     * @see com.observability.monitoring.server.IModelHandlerServer
     */
    @Override
    public int endFileUpload(String md5) throws RemoteException {
        // 1. check file object
        if (rafZip == null || targetName == null)
            return -1;// file error
        // Now everything should be uploaded
        // close the file
        try {
            rafZip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        rafZip = null;
        // 2. check file md5
        String combinedPath = getTargetFilePath(targetName);
        //if (combinedPath == null) {
        //    return -1;
        //}
        String calcMD5 = FileOperationHelper.getFileMD5(combinedPath);
        if (!calcMD5.equals(md5)) {//MD5 checksum error
            return -2;
        }

        // 3. unzip the file into the corresponding folder
        String dir = getTargetFileDirectory(targetName);
        //if (dir == null) {
        //    return -1;
        //}
        // delete the directory contents if any
        FileOperationHelper.deleteDirectoryContents(new File(dir));

        // make sure the directory is created
        if (!FileOperationHelper.createDirectory(dir)) {
            return -3;
        }
        System.out.println("---File successfully uploaded, unzipping it to: " + dir);
        int unzipret = FileOperationHelper.unzipFile(combinedPath, dir);
        if (unzipret < 0) {//unzip error
            return unzipret;
        }
        System.out.println("---Done");
        // 4. deploy the model

        return deployModel(targetName);
    }

    private boolean propagateConfig(String rmtIP, String rmtPort, String confPath) {
        // 1. connect to daemon manager on remote node
        IDaemonManagerServer dmServer = null;
        try {
            dmServer = DaemonManagerClient.getServerInstance(rmtIP, rmtPort);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        if (dmServer == null) {
            System.out.println("ModelHandler - error - Cannot connect to server: " + rmtIP + " Port: " + rmtPort);
            return false;
        }
        boolean ret = false;
        try {
            // 1. Start modifying configuration
            ret = dmServer.startConfigurationModification();
            if (!ret) {//failed
                System.out.println("ModelHandler - Failed to start configuration modification to server: " + rmtIP + " Port: " + rmtPort);
                return false;
            }
            // 2. Modify the content
            // read in the whole file as a string
            String cfgData = new String(Files.readAllBytes(Paths.get(confPath)), "UTF-8");
            // Replace the whole file
            ret = dmServer.replaceWholeConfiguration(cfgData);
            if (!ret) {//failed
                System.out.println("ModelHandler - Failed to modify configuration on server: " + rmtIP + " Port: " + rmtPort);
                return false;
            }
            // 3. Stop configuration process
            ret = dmServer.stopConfigurationModification();
            if (!ret) {//failed
                System.out.println("ModelHandler - Failed to end configuration modification to server: " + rmtIP + " Port: " + rmtPort);
                return false;
            }
            return true;
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 2. send the whole configuration file
        return false;
    }

    /**
     * @see com.observability.monitoring.server.IModelHandlerServer
     */
    @Override
    public int deployModel(String target) throws RemoteException {

        //updating targetName for rollback function
        targetName = target;

        // directory
        String dir = getTargetFileDirectory(targetName);
        //if (dir == null) {
        //    return -1;
        //}
        // traverse through all configuration files
        File dirFile = new File(dir);
        if (!dirFile.isDirectory()) {
            return -3;
        }

        // get file list
        File[] files = dirFile.listFiles();
        if (files == null) {
            return -3;
        }

        System.out.println("--Saving Current model (" + targetName + ") to file.");
        // save current model name to a file
        try {
            // append to file
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(currentModelFilePath()), "UTF-8");
            BufferedWriter fbw = new BufferedWriter(writer);
            fbw.write(targetName);
            fbw.newLine();
            fbw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--Success saving current model (" + targetName + ") to file.");

        return deploySelectedFilesOnly(files, true);
    }

    private int deploySelectedFilesOnly(File[] files, boolean updateDaemonList) {
        System.out.println("---Start deploying configuration files of totally: " + files.length);
        // loop through file list
        int totalSent = 0;

        // File name pattern : xxx.xxx.xxx.xxx_nnnn_collectd.conf
        Pattern pattern = Pattern.compile("_");

        //Initialize array list of IPs
        ipList = new ArrayList<String>();
        ArrayList<String> failedIPList = new ArrayList<String>();

        for (int i = 0; i < files.length; i++) {
            if (files[i] != null && files[i].isFile()) {
                String fn = files[i].getName();
                String[] items = pattern.split(fn);

                if (items.length == 2)
                    items[1] = daemonManagerDefaultPort;

                ipList.add(items[0]);

                System.out.println("---Deploying " + (i + 1) + "/" + files.length + " - IP: " + items[0] + " Port: " + items[1]);
                // send the files
                String canonicalPath = null;
                try {
                    canonicalPath = files[i].getCanonicalPath();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    continue;
                }
                if (propagateConfig(items[0], items[1], canonicalPath)) {//sent ok
                    totalSent++;
                    System.out.println("---Successful");
                } else {
                    failedIPList.add(items[0]);
                    System.out.println("---Failed");
                }
            }
        }

        System.out.println("----------End deploying model, " + totalSent + " out of " + files.length + " were successful");

        if (updateDaemonList) {
            updateDashboard();
            ObservabilityCollectdFileOperations.updateIPList(ipList);
        }

        ObservabilityCollectdFileOperations.updateFailedPropogation(failedIPList);
        ipList = null;
        return totalSent;
    }

    @Override
    public String viewCurrentModel() throws RemoteException {
        System.out.println("Retrieving latest model");
        String currentModel = null;

        FileInputStream stream = null;
        String strLine;
        try {
            stream = new FileInputStream(currentModelFilePath());
            BufferedReader br1 = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

            while ((strLine = br1.readLine()) != null) {
                currentModel = strLine;
                break;
            }

            // Close the input stream
            br1.close();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currentModel;
    }

    @Override
    public ArrayList<String> viewAllModels() throws RemoteException {
        System.out.println("Retrieving all models in this system");
        ArrayList<String> models = new ArrayList<String>();
        String modeDir = getModelDirectory();

        File dir = new File(modeDir);
        String[] directories = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });

        if (directories != null)
            for (int i = 0; i < directories.length; i++) {
                models.add(directories[i]);

            }

        // sorting the models so that the newest comes first
        Collections.sort(models);
        return models;
    }

    @Override
    public HashSet<String> viewFailedIP() throws RemoteException {
        System.out.println("Retrieving failed daemon IPs");
        HashSet<String> ips = ObservabilityCollectdFileOperations.getFailedIPList();
        return ips;
    }

    @Override
    public HashSet<String> viewAllIP() throws RemoteException {
        System.out.println("Retrieving all IPs");
        HashSet<String> ips = ObservabilityCollectdFileOperations.getIPList();
        return ips;
    }

    @Override
    public int resendFailedModels(String target) throws RemoteException {
        //updating targetName for rollback function
        targetName = target;

        // directory
        String dir = getTargetFileDirectory(targetName);
        //if (dir == null) {
        //    return -1;
        //}
        // traverse through all configuration files
        File dirFile = new File(dir);
        if (!dirFile.isDirectory()) {
            return -3;
        }

        // get file list
        File[] files = dirFile.listFiles();
        if (files == null) {
            return -3;
        }

        HashSet<String> failedIPs = ObservabilityCollectdFileOperations.getFailedIPList();
        File[] failedFiles = new File[failedIPs.size()];
        int count = 0;

        for (int i = 0; i < files.length; i++) {
            if (files[i] != null && files[i].isFile()) {
                for (String ip : failedIPs) {
                    if (files[i].getAbsolutePath().contains(ip)) {
                        failedFiles[count++] = files[i];
                        break;
                    }

                }
            }
        }

        return deploySelectedFilesOnly(failedFiles, false);
    }

    private void updateDashboard() {
        System.out.println("Updating Dashboard");
        try {
            Long epoch = System.currentTimeMillis() / 1000;
            String rawData = "changed=true&timestamp=" + epoch;
            String curl = "curl -X POST --data " + rawData + " " + dashboardURL;
            Runtime.getRuntime().exec(curl);

        } catch (MalformedURLException e) {
            System.out.println("Error: URL is malformed. Could not update dashboard");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Success: Dashboard updated");
    }

    /**
     * Initialize the RMI service.
     *
     * @param rmiIP   Binding IP address
     * @param rmiPort Binding port
     */
    public static void initializeService(String rmiIP, String rmiPort) {
        try {
            //IModelHandlerServer imhs = new ModelHandler();
        	imhs = new ModelHandler();
            UnicastRemoteObject.unexportObject(imhs, true);
            IModelHandlerServer stub = (IModelHandlerServer) UnicastRemoteObject.exportObject(imhs, 0);

            int port = Integer.parseInt(rmiPort);
            //create the RMI registry if it doesn't exist.
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("ModelHandler", stub);
        } catch (RemoteException e) {
            System.out.println("ModelHandler - error - Failed to create the RMI registry " + e);
        }
    }

    /**
     * Main function
     *
     * @param args arguments - arg1: binding IP, arg2: binding port
     */
    public static void main(String[] args) {
        /*/ test
        ModelHandler server = new ModelHandler();
		try {
			server.beginFileUpload("v1");
			server.deployModel("v1");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return;
		// end test*/

        // Get IP & port from arguments
        if (args.length < 1) {
            System.out.println("DaemonManager - error - should be started with at least one parameter: IP. [Option Port can be added, otherwise default is 8101]");
            return;
        }

        String rmiIP = args[0];
        String rmiPort = "8101";
        if (args.length == 2) {
            rmiPort = args[1];
        }

        // Set to use IP v4
        System.setProperty("java.net.preferIPv4Stack", "true");
        System.setProperty("java.rmi.server.hostname", rmiIP);


        System.out.println("Starting Modeling Handler with IP: " + rmiIP + " & Port: " + rmiPort);
        initializeService(rmiIP, rmiPort);
    }


    public byte[] getDescriptorFiles(int blockNumber) throws RemoteException, IOException {
        File descFile = new File(getDescriptorFilePath());
        FileInputStream fIn = null;
        try {
            fIn = new FileInputStream(descFile);
            // skip blocksize bytes for the blocks before requested block
            for (int i = 1; i < blockNumber; i++) {
                long skipBytes = blockSize.get(i);
                if (fIn.skip(skipBytes) != skipBytes) {
                    fIn.close();
                    throw new IOException("Error reading file\n");
                }
                ;
            }
            byte[] bytes = new byte[blockSize.get(blockNumber)];
            if (fIn.read(bytes) == -1) {
                fIn.close();
                return new byte[0];
            }
            ;
            fIn.close();
            return bytes;
        } catch (IOException e) {
            if (fIn != null) {
                fIn.close();
            }
        }
        return new byte[0];
    }

    public int getDescFileNrOfBlocks() throws RemoteException {
        File descFile = new File(getDescriptorFilePath());
        int nrOfBlocks = 0;
        long fileSize = descFile.length();

        if (fileSize > MAX_BLOCK_SIZE) {
            while (fileSize > 0) {
                nrOfBlocks++;
                if (fileSize > MAX_BLOCK_SIZE) {
                    fileSize -= MAX_BLOCK_SIZE;
                    blockSize.put(nrOfBlocks, MAX_BLOCK_SIZE);
                } else {
                    blockSize.put(nrOfBlocks, (int) fileSize);
                    fileSize = 0;
                }
            }
        } else {
            // if the file is of size 0, it has no blocks.
            nrOfBlocks = fileSize == 0 ? 0 : 1;
            blockSize.put(nrOfBlocks, (int) fileSize);
        }

        return nrOfBlocks;

    }

    public String getDescFileMd5() throws RemoteException {
        return IModelHandlerServer.FileOperationHelper.getFileMD5(getDescriptorFilePath());
    }

}
