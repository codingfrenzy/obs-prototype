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
import java.util.*;
import java.util.zip.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * IModelHandlerServer is the RMI interface for ModelHandler. Client should follow the sequence below to upload configuration files:<br>
 * 1. Begin uploading file<br>
 * 2. Upload file chunks<br>
 * 3. End file uploading<p>
 *
 * @author Ying (Joel) Gao
 *         <p/>
 *         History:<br>
 *         1. Created					Jun 22 2015<br>
 *         2. Modified					Jun 23 2015<br>
 */

public interface IModelHandlerServer extends Remote {

    /**
     * This class provides helper functions for file operations.
     */
    public class FileOperationHelper {
        // Buffer size for zip operation
        static final int BUFFER = 2048;

        /**
         * Get MD5 hash value of a file. The value is used to verify the integrity of the file after uploading.
         *
         * @param filePath file path
         * @return MD5 hash in string format
         */
        public static String getFileMD5(String filePath) {
            if (filePath == null)
                return null;
            // open filepath as a file
            File f = new File(filePath);
            if (f == null ||  // null
                    f.isDirectory() ||    // it's a directory
                    !f.exists() ||    // does not exist
                    !f.canRead()            // cannot read
                    ) {
                System.err.println("GetFile MD5 - Not a valid file.");
                return null;        // null for error
            }

            // Get MD5 of filePath
            MessageDigest md;
            try {
                // get digest method
                md = MessageDigest.getInstance("MD5");

                FileInputStream fis = new FileInputStream(f);

                try {
                    byte[] dataBytes = new byte[1024];

                    int nread = 0;
                    // calculate MD5
                    while ((nread = fis.read(dataBytes)) != -1) {
                        md.update(dataBytes, 0, nread);
                    }

                    byte[] mdbytes = md.digest();

                    // convert the byte to hex format
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < mdbytes.length; i++) {
                        sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
                    }
                    return sb.toString();
                } finally {
                    fis.close();
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;        // null for error
        }

        /**
         * Create a directory on file system
         *
         * @param dir name of the directory, can be absolute of relative.
         * @return true/false as operation result
         */
        public static boolean createDirectory(String dir) {
            File theDir = new File(dir);

            if (theDir.exists()) {//already there
                return true;
            }
            // if the directory does not exist, create it
            boolean result = false;
            try {
                result = theDir.mkdir();
            } catch (SecurityException se) {
                System.err.println("createDirectory - failed to create " + dir + "due to: " + se.toString());
            }

            return result;
        }

        /**
         * Delete a directory on file system
         *
         * @param directory directory file object
         * @return true/false as operation result
         */
        public static boolean deleteDirectoryContents(File directory) {
            if (!directory.exists()) {
                // doesn't exist
                return true;
            }
            boolean ret = false;
            try {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (int i = 0; i < files.length; i++) {
                        if (files[i].isDirectory()) {
                            // recursively delete all sub directories
                            deleteDirectoryContents(files[i]);
                        } else {
                            // delete the files
                            files[i].delete();
                        }
                    }
                }
                ret = true;
            } catch (Exception e) {
                e.printStackTrace();
                ret = false;
            }
            return ret;
        }

        /**
         * Unzip a zip file to a target directory
         *
         * @param zipfilePath     the file path of the zip file
         * @param targetDirectory the target directory of the output
         * @return equal or larger than 0 - number of files extracted<br>
         * -21 zip format not supported<br>
         * -22 zip file not valid<br>
         * -23 zip file cannot be read due to security reason
         * -24 cannot create target directory<br>
         */
        public static int unzipFile(String zipfilePath, String targetDirectory) {
            try {
                // create the directory
                if (!createDirectory(targetDirectory))
                    return -24;
                // file operations
                BufferedOutputStream dest = null;
                BufferedInputStream is = null;
                ZipEntry entry;
                ZipFile zipfile = new ZipFile(zipfilePath);
                Enumeration<? extends ZipEntry> e = zipfile.entries();
                int fileExtracted = 0;
                while (e.hasMoreElements()) {
                    entry = (ZipEntry) e.nextElement();
                    System.out.println("Extracting: " + entry);
                    is = new BufferedInputStream(zipfile.getInputStream(entry));
                    int count;
                    byte data[] = new byte[BUFFER];
                    FileOutputStream fos = new FileOutputStream(targetDirectory + "/" + entry.getName());
                    dest = new BufferedOutputStream(fos, BUFFER);
                    while ((count = is.read(data, 0, BUFFER)) != -1) {
                        dest.write(data, 0, count);
                    }
                    dest.flush();
                    dest.close();
                    is.close();
                    fileExtracted++;
                }
                zipfile.close();
                return fileExtracted;
            } catch (ZipException e1) {
                e1.printStackTrace();
                return -21;
            } catch (IOException e2) {
                e2.printStackTrace();
                return -22;
            } catch (SecurityException e3) {
                e3.printStackTrace();
                return -23;
            }
        }
    }

    /**
     * Begin the uploading process. Client should get true to continue.
     * <p/>
     * The zip file will be saved as 'target.zip' (don't have .zip in your target parameter).<br>
     * It will be unzipped to a folder named 'target' to extract all configuration files.
     *
     * @param target the target file and directory
     * @return true/false
     * @throws RemoteException connection error
     */
    public boolean beginFileUpload(String target) throws RemoteException;

    /**
     * Upload a file chunk.<br>
     * For big file, it must be divided into chunks and uploaded separately.<br>
     * Client can use different chunk size. Default chunk size is 512KB.
     *
     * @param buffer the byte array of the file chunk
     * @return true/false
     * @throws RemoteException connection error
     */
    public boolean uploadFileChunk(byte[] buffer) throws RemoteException;

    /**
     * End the file uploading process.<br>
     * Program will verify the MD5 of the received file against the parameter to ensure integrity.<p>
     * Program will unzip the file and propagate all configuration files to remote nodes.<br>
     * This method may take a long time in a large system.
     *
     * @param md5 MD5 hash value of the file in client system
     * @return the number of configuration files that are successfully transfered, negative for error<br>
     * -1 : file error<br>
     * -2 : MD5 checksum error<br>
     * -3 : unzipped directory error<br><br>
     * <p/>
     * -21 zip format not supported<br>
     * -22 zip file not valid<br>
     * -23 zip file cannot be read due to security reason
     * -24 cannot create target directory<br>
     * @throws RemoteException connection error
     */
    public int endFileUpload(String md5) throws RemoteException;

    /**
     * Deploy the uploaded configuration files with the name 'target'.<br>
     * If you have called endFileUpload, this method will be called automatically.<br>
     * You can call this method to deploy those already uploaded zip files.<br>
     * For example, v5 is uploaded and deployed in current system, but you want to roll back to v4, <br>
     * you can call this method directly (as long as v4 files are still persistent on disk).
     *
     * @param target the name of the uploaded configuration zip file
     * @return the number of configuration files that are successfully transfered, negative for error
     * @throws RemoteException connection error
     */
    public int deployModel(String target) throws RemoteException;

    public String viewCurrentModel() throws RemoteException;;

    public HashSet<String> viewFailedIP() throws RemoteException;;

    public int resendFailedModels(String target) throws RemoteException;;
}
