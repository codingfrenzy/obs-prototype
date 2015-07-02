package com.observability.modeling.design.handlers.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.observability.modeling.design.handlers.Deploy;

public class DeployTest {

	@Test
	public void testDeployFile() {
		String ip = "128.237.201.134";
		String port = "17680";
		String target = "/home/vsaravag/git/obs-prototype/modeling/third/ModelingFinal/conf.zip";
		try {
			Deploy.deployFile(ip, port, target);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
