package Listener_pr;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class listener extends TestListenerAdapter
{
	// Below all are predefined methods
	public void onTestStart(ITestResult tr)
	{ 
		System.out.println("Test started");
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		System.out.println("Test passed");
	}
	
	public void onTestFailure(ITestResult tr)
	{
		System.out.println("Test failed");
		//System.out.println(tr.getThrowable());
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		System.out.println("Test skipped");
	}
	
	
}
