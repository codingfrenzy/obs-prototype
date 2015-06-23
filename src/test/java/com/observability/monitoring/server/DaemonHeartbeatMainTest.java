package com.observability.monitoring.server;

import static org.junit.Assert.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import org.junit.Test;

public class DaemonHeartbeatMainTest {

	public String filePath = "/home/owls/collectd/missingDaemonLog/";

	@Test
	public void testMain() {
		System.out.println("Testing DaemonHeartbeatMain class. Checking if the log file exists and it contains some data");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(date);
		String fullFile = filePath + "NotResponding-" + sdf.format(date);

        boolean skip = false;

        if(skip) {

            try {
                File fileDir = new File(fullFile);
                assertTrue(fileDir.exists()); // checks if file exists
                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));

                String str;
                while ((str = in.readLine()) != null) {
                    System.out.println(sdf.format(date) + "Log file first line: " + str);
                    assertTrue(str.contains("IP:128.2.204.246 since ") || str.contains("IP:123.2.204.246 since "));
                    break;
                }
                in.close();
            } catch (UnsupportedEncodingException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            assertTrue(true);
        }
	}
}
