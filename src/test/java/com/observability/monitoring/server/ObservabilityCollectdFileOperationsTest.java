package com.observability.monitoring.server;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class ObservabilityCollectdFileOperationsTest {

	String collectdPath = "/opt/collectd/";
	String collectdConf = "etc/collectd.conf";
	String emptyCollectConf = "etc/emptyCollectd.conf";
	String wrongCollectdPath = "opt/";
	String collectdConfMissingValues = "etc/sampleCollectd.conf";
	String wrongFile = "xyz";
	
    String aggregationLog = "log/aggregation";

	int faultTolTimeWindow = 10;
	int interval = 10;
	
	int invalidFaultTolTimeWindow = -1;
	int invalidInterval = -1;
	
	HashMap<String, String> aggConfigurations = null;
	HashMap<String, String> invalidAggConfigurations1 = null;
	HashMap<String, String> invalidAggConfigurations2 = null;
	HashMap<String, String> nullAggConfigurations = null;

	String validFaultTolTimeWindow = "60";
	//String invalidNegFaultTolTimeWindow = "-1";
	//String invalidStrFaultTolTimeWindow = "a";

	byte[] byteIn = null;
	
	ByteArrayInputStream in = null;
	
	@Before
	public void setUp() throws Exception {
		aggConfigurations = new HashMap<String, String>();
		aggConfigurations.put("plugin", "cpu");
		aggConfigurations.put("calculatenum", "true");
		aggConfigurations.put("calculatesum", "false");
		aggConfigurations.put("calculateaverage", "fasle");
		aggConfigurations.put("calculateminimum", "false");
		aggConfigurations.put("calculatemaximum", "false");
		aggConfigurations.put("calculatestddev", "false");
		aggConfigurations.put("host", "test");
		aggConfigurations.put("plugininstance", "test");
		aggConfigurations.put("type", "test");
		aggConfigurations.put("typeinstance", "test");
		aggConfigurations.put("groupby", "test");

		invalidAggConfigurations1 = new HashMap<String, String>();
		invalidAggConfigurations1.put("plugin", "cpu");
		invalidAggConfigurations1.put("calculatenum", "false");
		invalidAggConfigurations1.put("calculatesum", "false");
		invalidAggConfigurations1.put("calculateaverage", "fasle");
		invalidAggConfigurations1.put("calculateminimum", "false");
		invalidAggConfigurations1.put("calculatemaximum", "false");
		invalidAggConfigurations1.put("calculatestddev", "false");
		
		invalidAggConfigurations2 = new HashMap<String, String>();
		invalidAggConfigurations2.put("calculatenum", "true");
		invalidAggConfigurations2.put("calculatesum", "false");
		invalidAggConfigurations2.put("calculateaverage", "fasle");
		invalidAggConfigurations2.put("calculateminimum", "false");
		invalidAggConfigurations2.put("calculatemaximum", "false");
		invalidAggConfigurations2.put("calculatestddev", "false");
		
		nullAggConfigurations = new HashMap<String, String>();


	}

	
	@Test
	public void testUpdateIPList() {
		ArrayList<String> ipList = new ArrayList<String>();
		for(int i = 1 ; i < 6 ; i++)
			ipList.add("1.1.1." + i);
		ObservabilityCollectdFileOperations.updateIPList(ipList);
	}
	
	@Test
	public void testUpdateIPListAssert() {
		ArrayList<String> ipList = new ArrayList<String>();
		for(int i = 1 ; i < 4 ; i++)
			ipList.add("1.1.1." + i);
		ObservabilityCollectdFileOperations.updateIPList(ipList);
		ArrayList<String> list = new ArrayList<String>();
		  list.add("1.1.1.1");
		  list.add("1.1.1.2"); 
		  list.add("1.1.1.3");
		  StringWriter stringWriter = new StringWriter();
		  PrintWriter out = new PrintWriter(stringWriter);
		  try {
		    for (int i = 0; i < list.size(); i++) {
		      out.println(list.get(i).toString());
		    }
		  } finally {
		    out.close();
		  }
		  assertEquals("1.1.1.1\n1.1.1.2\n1.1.1.3\n", stringWriter.toString()); 
	}

	@Test
	public void testUpdateFailedPropogation() {
		ArrayList<String> ipList = new ArrayList<String>();
		for(int i = 1 ; i < 6 ; i++)
			ipList.add("1.1.1." + i);
		ObservabilityCollectdFileOperations.updateFailedPropogation(ipList);
	}

	@Test
	public void testGetIPList() {
		assertNotNull(ObservabilityCollectdFileOperations.getIPList());
	}

	@Test
	public void testGetFailedIPList() {
		HashSet<String> ipl = ObservabilityCollectdFileOperations.getFailedIPList();
		System.out.println(ipl.toString());
	}

	@Test
	public void testLogMessageAssertTrue(){
		try {
			 
		      File file = new File(collectdPath + aggregationLog+"-" + ObservabilityCollectdFileOperations.getTodayDate());
	 
		      if (file.createNewFile()){
		  		assertTrue(ObservabilityCollectdFileOperations.logMessage(collectdPath + aggregationLog, "Testing"));
		      }else{
		  		assertFalse(ObservabilityCollectdFileOperations.logMessage(collectdPath + aggregationLog, "Testing"));
		      }
	 
	    	} catch (IOException e) {
		      e.printStackTrace();
		}
	}
	

	@Test
	public void testGetMissingDaemonConf(){
		String collectdPath = "/opt/collectd/";
		String collectdConf = "etc/collectd.conf";
		assertNotNull(ObservabilityCollectdFileOperations.getMissingDaemonConf());
	}
	
	@Test
	public void testCheckAccess(){
		assertTrue(ObservabilityCollectdFileOperations.checkAccess());
	}
	
	@Test
	public void testGetMissingDaemonNotCollectingLogPath(){
		assertNotNull(ObservabilityCollectdFileOperations.getMissingDaemonNotCollectingLogPath());
	}
	
	@Test
	public void testGetMissingDaemonNotRespondingLogPath(){
		assertNotNull(ObservabilityCollectdFileOperations.getMissingDaemonNotRespondingLogPath());
	}
	
	@Test
	public void testLogMessageAggregation() {
		ObservabilityCollectdFileOperations.logMessageAggregation("test Aggregation");
	}

	@Test
	public void testLogMessageMissingDaemonNotCollecting() {
		ObservabilityCollectdFileOperations.logMessageMissingDaemonNotCollecting("test DaemonNotCollecting");
	}

	@Test
	public void testLogMessageMissingDaemonNotResponding() {
		ObservabilityCollectdFileOperations.logMessageMissingDaemonNotResponding("test DaemonNotResponding");
	}

	@Test
	public void testLogMessageDBHandler() {
		ObservabilityCollectdFileOperations.logMessageDBHandler("test DBHandler");
	}

	@Test
	public void testLogMessageModelDataHandler() {
		ObservabilityCollectdFileOperations.logMessageModelDataHandler("test ModelDataHandler");
	}

	@Test
	public void testGetTodayDate() {
		String dt = ObservabilityCollectdFileOperations.getTodayDate();
		System.out.println(dt);
	}

	@Test
	public void testLastModifiedCollectdConf() {
		long lm = ObservabilityCollectdFileOperations.lastModifiedCollectdConf();
		System.out.println("Last modified collectd conf time: " + lm);
	}

	@Test
	public void testLastModifiedDaemonIP() {
		long lm = ObservabilityCollectdFileOperations.lastModifiedDaemonIP();
		System.out.println("Last modified daemon ip time: " + lm);
	}

	@Test
	public void testLogMessage(){
		assertFalse(ObservabilityCollectdFileOperations.logMessage("/Desktop/", "Testing"));
	}
	
	
	/////////////////////////////////////////////////////////////////////////
	@Test
	public void testGetIntervalConfEmptyFileTrue() throws FileNotFoundException, IOException{
		assertTrue(ObservabilityCollectdFileOperations.getIntervalConf(collectdPath+emptyCollectConf) == 0);
	}
	
	@Test
	public void testGetIntervalConfEmptyFileFalse() throws FileNotFoundException, IOException{
		assertFalse(ObservabilityCollectdFileOperations.getIntervalConf(collectdPath+emptyCollectConf) == 30);
	}
	
	@Test
	public void testGetIntervalConfWrongPathTrue() throws FileNotFoundException, IOException {
		assertTrue(ObservabilityCollectdFileOperations.getIntervalConf(wrongCollectdPath+collectdConf) == 0);
	}
	
	@Test
	public void testGetIntervalConfWrongPathFalse() throws FileNotFoundException, IOException {
		assertFalse(ObservabilityCollectdFileOperations.getIntervalConf(wrongCollectdPath+collectdConf) == 30);
	}
	
	@Test
	public void testGetIntervalConfMinus() throws FileNotFoundException, IOException {
		assertFalse(ObservabilityCollectdFileOperations.getIntervalConf(collectdPath+collectdConf) == -1);
	
	}
	
	@Test
	public void testGetIntervalConfNotNull() throws FileNotFoundException, IOException {
		String str = null;
		str = String.valueOf(ObservabilityCollectdFileOperations.getIntervalConf(collectdPath+collectdConf));
		assertNotNull(str);
	}
	
	@Test
	public void testGetIntervalConfWrongPath() throws FileNotFoundException, IOException {
		String str = null;
		str = String.valueOf(ObservabilityCollectdFileOperations.getIntervalConf(wrongCollectdPath+collectdConf));
		assertNotNull(str);
	}
	
	
	@Test
	public void testGetIntervalConfCommentedNotNull() throws FileNotFoundException, IOException {
		String str = null;
		str = String.valueOf(ObservabilityCollectdFileOperations.getIntervalConf(collectdPath+collectdConfMissingValues));
		assertNotNull(str);
	}
	
	
	
	@Test
	public void testGetAggConfWrongPath() throws IOException{
		assertNull(ObservabilityCollectdFileOperations.getAggConf(wrongCollectdPath+collectdConf));
	}
	
	@Test
	public void testGetAggConfMissingAggConfig() throws IOException{
		assertNull(ObservabilityCollectdFileOperations.getAggConf(wrongCollectdPath+collectdConfMissingValues));
	}
	
	@Test
	public void testGetAggConfEmptyFile() throws IOException{
		assertNull(ObservabilityCollectdFileOperations.getAggConf(wrongCollectdPath+emptyCollectConf));
	}
	
	@Test
	public void testGetAggConfWrongFile() throws IOException{
		assertNull(ObservabilityCollectdFileOperations.getAggConf(collectdPath+wrongFile));
	}
	
	@Test
	public void testGetAggConf() throws IOException{
		assertNotNull(ObservabilityCollectdFileOperations.getAggConf(collectdPath+collectdConf));
	}
	
	//setConfigurations(int faultTolTimeWindow, int faultTolTimeWindow, HashMap<String, String> aggConfigurations
	@Test
	public void testSetConfigurationsCorrectParameters(){
		assertNotNull(ObservabilityCollectdFileOperations.setConfigurations(faultTolTimeWindow, interval, aggConfigurations));
	}
	
	@Test
	public void testSetConfigurationsInvalidFaultTolTimeWindow(){
		assertNotNull(ObservabilityCollectdFileOperations.setConfigurations(invalidFaultTolTimeWindow, interval, aggConfigurations));
	}
	
	@Test
	public void testSetConfigurationsInvalidInterval(){
		assertNotNull(ObservabilityCollectdFileOperations.setConfigurations(faultTolTimeWindow, invalidInterval, aggConfigurations));
	}
	
	@Test
	public void testSetConfigurationsInvalidAggConfigurations1(){
		assertNull(ObservabilityCollectdFileOperations.setConfigurations(faultTolTimeWindow, interval, invalidAggConfigurations1));
	}
	
	@Test
	public void testSetConfigurationsInvalidAggConfigurations2(){
		assertNull(ObservabilityCollectdFileOperations.setConfigurations(faultTolTimeWindow, interval, invalidAggConfigurations2));
	}
	
	@Test
	public void testSetConfigurationsInvalidFI(){
		assertNotNull(ObservabilityCollectdFileOperations.setConfigurations(invalidFaultTolTimeWindow, invalidInterval, aggConfigurations));
	}
	
	@Test
	public void testSetConfigurationsInvalidFA1(){
		assertNull(ObservabilityCollectdFileOperations.setConfigurations(invalidFaultTolTimeWindow, interval, invalidAggConfigurations1));
	}
	
	@Test
	public void testSetConfigurationsInvalidFA2(){
		assertNull(ObservabilityCollectdFileOperations.setConfigurations(invalidFaultTolTimeWindow, interval, invalidAggConfigurations2));
	}
	
	@Test
	public void testSetConfigurationsInvalidIA1(){
		assertNull(ObservabilityCollectdFileOperations.setConfigurations(faultTolTimeWindow, invalidInterval, invalidAggConfigurations1));
	}
	
	@Test
	public void testSetConfigurationsInvalidIA2(){
		assertNull(ObservabilityCollectdFileOperations.setConfigurations(faultTolTimeWindow, invalidInterval, invalidAggConfigurations2));
	}
	
	@Test
	public void testSetConfigurationsNullA(){
		assertNull(ObservabilityCollectdFileOperations.setConfigurations(faultTolTimeWindow, invalidInterval, nullAggConfigurations));
	}
	
	@Test
	public final void testReadConfigurationFileValidF() throws IOException{
		byteIn = validFaultTolTimeWindow.getBytes(Charset.forName("UTF-8"));
		in = new ByteArrayInputStream(byteIn); 
		System.setIn(in);
		assertNotNull(ObservabilityCollectdFileOperations.readConfigurationFile());
		in.close();
	}
	


	
	@Test
	public void testMain() {
		/*
		String []args = new String[1];
		args[0] = "1.2.3.4";
		ObservabilityCollectdFileOperations.main(args);
		*/
	}

}
