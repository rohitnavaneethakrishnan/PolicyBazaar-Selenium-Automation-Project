package Pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.TestBase;



public class CarInsurancePage extends TestBase{
	public CarInsurancePage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	//By carIcon = By.xpath("/html/body/cclink/main/div[2]/section/div[4]/a/div[1]/i");
	By carIcon = By.xpath("//div[@class='prd-icon add short']/i[@class='icon-bg car-insurance']");
	By clickproceedbutton = By.className("btn-proceed");
	By place = By.xpath("//*[@id='spn1']");
	By rto = By.xpath("//*[@id='section1']/ul/li[1]/span");
	By carname = By.className("maruti");
	By model = By.xpath("//*[@id=\"modelScroll\"]/li[1]/span");
	By fuelType = By.xpath("//*[@id='Petrol']");
	By variant = By.xpath("//*[@id='variantScroll']/li[1]/span");
	By year = By.xpath("//*[@id='dvRegYear']/ul/div/li[17]");
	By name = By.id("name");
	By email = By.id("email");
	By mobileNo = By.id("mobileNo");
	By viewPrice = By.xpath("//*[@id=\"btnLeadDetails\"]");
	By errormsg = By.xpath("//*[@id=\"dvVariant\"]/div[2]/div[1]/div[3]/div[2]");
	
    public void carbutton() {
    	driver.findElement(carIcon).click();
    }
    //click on proceed button.
    public void clickandproceed() {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.findElement(clickproceedbutton).click();
    }
    public void selectcity() {
    	driver.findElement(place).click();
    	driver.findElement(rto).click();
    }
    public void selectcarbrand() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.findElement(carname).click();
    }
    public void selectmodel() {
    	
    	driver.findElement(model).click();
    }
    public void cartype() {
    	driver.findElement(fuelType).click();
    }
    public void selectCarVariant() {
		driver.findElement(variant).click();
	}

	/*
	 * Selecting year
	 */
	public void selectYear() {
		driver.findElement(year).click();
	}

	/*
	 * Entering name
	 */
	public void fillName(String uname) {
		
		driver.findElement(name).clear();
		driver.findElement(name).sendKeys(uname);
	}
	
	/*
	 * Entering email
	 */
	public void fillEmail(String uemail) {
		
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(uemail);
	}
	
	/*
	 * Entering phone number
	 */
	public void fillPhone(String phone) {
		driver.findElement(mobileNo).clear();
		driver.findElement(mobileNo).sendKeys(phone);
		driver.findElement(viewPrice).click();
	}
	public void takescreenshot() throws IOException {
		TakesScreenshot scrnShot = ((TakesScreenshot)driver);
		File src = scrnShot.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshot\\PolicyBazaar" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(src, dest);
		
		System.out.println(driver.findElement(errormsg).getText());
	}
	
	public void closebrowser() {
		driver.quit();
	}
	
}
