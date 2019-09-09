package com.junit.DAOImpl;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.p2.user.User;
import com.p2.user.UserDAOImpl;

public class UserTest {
	
	User u = new User("lbcarson1", "a/yY0qS3D6vAFuC6DFx27A==", "Barton", "Carson", "themainman@gmail.com", "EMPLOYEE");
	UserDAOImpl udi = new UserDAOImpl();
	
	@Test
	public void selectUserByUsernameAnPassword() {
		assertEquals("should return the created user", null, udi.selectUserByUsernameAndPassword("lbcarson1", "a/yY0qS3D6vAFuC6DFx27A=="));
	}
}