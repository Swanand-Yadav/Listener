package extentReports;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateExtentReport 
{
	ExtentSparkReporter reporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void startReport() throws IOException
	{
		reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\index.html");
		reporter.config().setReportName("Web Automation Results");//Name of the report
		reporter.config().setDocumentTitle("Test Results"); //Title of report
		reporter.config().setTheme(Theme.DARK);
		reporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		extent=new ExtentReports();
		extent.attachReporter(reporter); //It will attach above report with extent report 
		
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Tester Name", "Swanand Yadav");
	}
	
	@Test
	public void demoReportPass()
	{
		test=extent.createTest("demoreportPass");
		Assert.assertTrue(true);
		test.log(Status.PASS, "Assert pass as condition true");
	}
	
	@Test
	public void demoReportFail()
	{
		test=extent.createTest("demoreportFail");
		Assert.assertTrue(false);
		test.log(Status.FAIL, "Assert fail as condition false");
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getThrowable());
		}
		extent.removeTest(test);
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush(); //It will clear the memory
	}
}
