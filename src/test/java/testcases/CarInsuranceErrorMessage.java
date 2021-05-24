package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.CarInsurancePage;
import base.TestBase;
import util.ReadExcel;

public class CarInsuranceErrorMessage extends TestBase{

	public CarInsuranceErrorMessage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	CarInsurancePage car = new CarInsurancePage();
	 String userDir = System.getProperty("user.dir");
    String filePath = userDir + "\\src\\test\\java\\resources\\CarInsurance.xlsx";
	
	@BeforeClass
	public void setup()throws Exception {
		invokeBrowser();
		driver.navigate().to("https://www.policybazaar.com/");
		
	}	 
	
	@Test(priority=1)
	public void clickcarbutton() {
		logger = report.createTest("Car Insurance Test");
		logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Clicking Car Icon");
		car.carbutton();
		
	}
	@Test(priority=2)
	public void proceed() {
		car.clickandproceed();
		logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Clicking Proceed Button");
		
	}
	
    @Test(priority=3)
    public void city() {
    	car.selectcity();
    	logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Selecting the city");
		
    }
    @Test(priority=4)
    public void carbrand() throws InterruptedException {
    	car.selectcarbrand();
    	logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Selecting the carbrand");
    }
    @Test(priority=5)
    public void carmodel() {
    	car.selectmodel();
    	logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Selecting the carmodel");

    }
    @Test(priority=6)
    public void type() {
    	car.cartype();
    	logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Selecting the cartype");
    }
    @Test(priority=7)
    public void varient() {
    	car.selectCarVariant();
    	logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Selecting the carvarient");
    }
    @Test(priority=8)
    public void year() {
    	car.selectYear();
    	logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Selecting the year");
    }
    @Test(priority=9)
    public void filldetails() {
    	ReadExcel re = new ReadExcel();
    	try {
			car.fillName(re.readexcel(0, filePath, 0));
			car.fillEmail(re.readexcel(0, filePath, 1));
			car.fillPhone(re.readexcel(0, filePath, 3));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Filling the details");
    }
    @Test(priority=10)
    public void screenshot(){
    	try {
			car.takescreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Taking the scrrenshot");
    }
    
    @Test(priority=11)
    public void close() {
    	car.closebrowser();
    	logger.log(Status.PASS, "TestCase Passed");
		logger.log(Status.INFO, "Closing the browser");
    }
    
}

