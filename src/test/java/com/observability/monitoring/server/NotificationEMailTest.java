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

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

/**
 * Unit test for com.observability.monitoring.server.NotificationEMail.
 * <p>
 * @author Ying (Joel) Gao
 * <p>
 * History:<br>
 * 1. Created					Jun 07 2015<br>
 *
 */
public class NotificationEMailTest {

	/**
	 * Test method for {@link com.observability.monitoring.server.NotificationEMail#sendEMail(java.util.List, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSendEMail() {
		NotificationEMail sm = new NotificationEMail();
		List<String> recipients = new ArrayList<String>();
		recipients.add("joelyinggao@gmail.com");
		
		boolean ret = sm.sendEMail(recipients, "Test", "This is a testing email.", false);
		Assert.assertTrue(ret);
	}

	/**
	 * Test method for {@link com.observability.monitoring.server.NotificationEMail#sendEMail(java.util.List, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSendEMailMultiple() {
		NotificationEMail sm = new NotificationEMail();
		List<String> recipients = new ArrayList<String>();
		recipients.add("joelyinggao@gmail.com");
		recipients.add("observabilityalert@gmail.com");
		
		boolean ret = sm.sendEMail(recipients, "Test", "This is a testing email.", false);
		Assert.assertTrue(ret);
	}
	
	/**
	 * Test method for {@link com.observability.monitoring.server.NotificationEMail#sendEMail(java.util.List, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSendEMailNullRecipient() {
		NotificationEMail sm = new NotificationEMail();
		List<String> recipients = new ArrayList<String>();
		//recipients.add("joelyinggao@gmail.com");
		//recipients.add("observabilityalert@gmail.com");
		
		boolean ret = sm.sendEMail(recipients, "Test", "This is a testing email.", false);
		Assert.assertFalse(ret);
	}
	
	@Test
	public void testSendEMailNullRecipient1() {
		NotificationEMail sm = new NotificationEMail();
		List<String> recipients = new ArrayList<String>();
		recipients.add(null);
		recipients.add("");
		
		boolean ret = sm.sendEMail(recipients, "Test", "This is a testing email.", false);
		Assert.assertFalse(ret);
	}
	
	
	/**
	 * Test method for {@link com.observability.monitoring.server.NotificationEMail#sendEMail(java.util.List, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSendEMailHTML() {
		NotificationEMail sm = new NotificationEMail();
		List<String> recipients = new ArrayList<String>();
		recipients.add("joelyinggao@gmail.com");
		recipients.add("observabilityalert@gmail.com");
		
		boolean ret = sm.sendEMail(recipients, "Test", "<h1>This is a <br>testing email.</h1>", true);
		Assert.assertTrue(ret);
	}
	
	@Test
	public void testinitRecipients() {
		NotificationEMail sm = new NotificationEMail();
		List<String> rs = sm.initRecipients();
		assertNotNull(rs);
		System.out.println(sm.toString());
	}
	
	@Test 
	public void testmakeNotRespondingEmailBody() {
		NotificationEMail sm = new NotificationEMail();
		ArrayList<String> ips = new ArrayList<String>();
		ArrayList<String> dateTime = new ArrayList<String>();
		ips.add("1.2.3.4");
		dateTime.add("FooBar");
		String s1 = sm.makeNotRespondingEmailBody(ips, dateTime);
		assertNotNull(s1);
		System.out.println(s1);
	}
	
	@Test 
	public void testmakeNotCollectingEmailBody() {
		NotificationEMail sm = new NotificationEMail();
		ArrayList<String> ips = new ArrayList<String>();
		ArrayList<String> dateTime = new ArrayList<String>();
		ips.add("1.2.3.4");
		dateTime.add("FooBar");
		String s1 = sm.makeNotCollectingEmailBody(ips, dateTime);
		assertNotNull(s1);
		System.out.println(s1);
	}
}
