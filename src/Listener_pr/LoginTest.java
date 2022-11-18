package Listener_pr;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest 
{
    @Test()  //@Test(enabled=false) //by this we can control to not run this test case 
	public void LoginByEmail()
	{
		System.out.println("Login By Email");
		Assert.assertEquals("sharu", "shAru");//false
	}
	
	@Test
	public void LoginByFacebook()
	{
		System.out.println("Login By Facebook");
		Assert.assertEquals("sharu", "sHaru");//false
	}
	
	@Test
	public void LogeedIn()
	{
		int id=10,pwd=10;
		boolean isLogged=id==pwd;
		System.out.println("Login By Instagram");
		Assert.assertTrue(isLogged); // true
	}


}
