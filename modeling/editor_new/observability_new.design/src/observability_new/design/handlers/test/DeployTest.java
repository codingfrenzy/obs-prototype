package observability_new.design.handlers.test;

import static org.junit.Assert.*;
import observability_new.design.handlers.Deploy;

import org.junit.Test;

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
