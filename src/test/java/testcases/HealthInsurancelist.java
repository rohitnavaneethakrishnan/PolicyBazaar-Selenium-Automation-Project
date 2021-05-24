package testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HealthInsurance;
import base.TestBase;

public class HealthInsurancelist extends TestBase{

	public HealthInsurancelist() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	HealthInsurance health = new HealthInsurance();
	@BeforeClass
	public void setup()throws Exception {
		invokeBrowser();
		driver.navigate().to("https://www.policybazaar.com/");
		logger = report.createTest("Health Insurance Test");
		logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Clicking Insurance link");
	}	 
	@Test(priority=1)
	public void gethealthmenu() throws FileNotFoundException {
		health.gethealthinsuranceproducts();
		logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Getting Product List");
	}
	@Test(priority=2)
	public void close() {
		health.teardown();
		logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Clsoing Driver");
	}

}
