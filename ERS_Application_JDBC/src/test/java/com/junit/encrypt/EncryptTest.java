package com.junit.encrypt;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EncryptTest {

	@Test
	public void EncryptPassword() {
		assertEquals("should encrypt the password", "a/yY0qS3D6vAFuC6DFx27A==", com.p2.encrypt.EncryptPassword.encrypt("lbc1", "Clemson"));
	}
	
	@Test
	public void DecryptPassword() {
		assertEquals("should decrypt the password", "lbc1", com.p2.encrypt.EncryptPassword.decrypt("a/yY0qS3D6vAFuC6DFx27A==", "Clemson"));
	}	
}