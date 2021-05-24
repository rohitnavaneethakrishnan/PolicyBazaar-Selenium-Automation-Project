package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;


import base.TestBase;

public class TravelInsurancePage extends TestBase{
	public TravelInsurancePage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}


	protected static ArrayList<String> travelInsuranceProviderNames = new ArrayList<String>();
     protected static ArrayList<String> travelInsurancePrice = new ArrayList<String>();
	By student = By.xpath("//*[@id=\"topForm\"]/section/div[2]/article/ul/li[3]/a");
	
	By Destination=By.xpath("//*[@id='destination-autocomplete']");
	By AgeTraveller1=By.xpath("//*[@id='memage1']");
	By	traveller2=By.xpath("//*[@id='memage2']");
	By startdate = By.xpath("//*[@id=\"startdate\"]");
    By proceed = By.xpath("//*[@id=\"proceedStepOne\"]");
    By salutation=By.xpath("//*[@id='travelgender']");
    By	SelectMr= By.xpath("//*[@id='travelgender']/option[2]");
    By entername = By.id("travelname");
    By mobile = By.id("travelmobile");
    By email = By.id("travelemail");
    By proceeds = By.xpath("//*[@id=\"topForm\"]/section/div[2]/div[2]/div[1]/div[2]/div/a[2]");
    By sortDropDownBox = By.className("sort_select");
    By insuranceProvider = By.xpath("//div[@class='main_quotes blank_si']//div[contains(@class, 'Logo ')]");
	By productPrice = By.xpath("//button[contains(@class, 'secondary_button card_btn')]");
	/*1
	 * Clicking student tab
	 */
	public boolean clickStudent() {
		driver.findElement(student).click();
		return true;
	}

	/*
	 * Entering student details in form
	 */
	public void Destination(String Destinations) {
		
    driver.findElement(Destination).sendKeys(Destinations,Keys.ENTER);
    
		

	}
	public void traveller(String age1,String age2) {
		driver.findElement(AgeTraveller1).sendKeys(age1,Keys.ENTER);
		driver.findElement(traveller2).sendKeys(age2,Keys.ENTER);
	}
	 public  String GetDateAfter(int noOfDays)
		{
			DateFormat date = new SimpleDateFormat("dd"); 
			
			//To fetch the current date using calendar class
			Calendar c = Calendar.getInstance(); 
			
			//To add noOfdays to current date 
			c.add(Calendar.DATE, noOfDays);	
			
			//returns the date format with n noOfdays from current date 
			return date.format(c.getTime());   
			
		}
	 public void startdate() throws InterruptedException {
		 /*
		 WebDriverWait wait  = new WebDriverWait(driver,200);
		 driver.findElement(startdate).click();
		 String startdate= GetDateAfter(5);
		 String enddate = GetDateAfter(6);
		 By tripStartDate = By.xpath("//td[text()='"+startdate+"']");
		 By tripEndDate = By.xpath("//td[text()='"+enddate+"']");
				
			// Select trip start date of next month
			driver.findElements(tripStartDate).get(1).click();
			driver.findElements(tripEndDate).get(1).click();
			
			//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			// Select trip end date of next month
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"navigatorType\\\"]/body/div[9]/div[2]/div[1]/table/tbody/tr[5]/td[5]")));
			//driver.findElement(By.xpath("//*[@id=\"navigatorType\"]/body/div[9]/div[2]/div[1]/table/tbody/tr[5]/td[5]")).click();
			*/
			
			// Click Proceed button to get quote
			
			// page load timeout for redirected web page
			
			By startDate = By.cssSelector("td.today.start-date.end-date.available");
			By endDate = By.cssSelector("td.active.start-date.active.end-date.available");
			By tripStartDateTextBox = By.id("startdate");
			By tripEndDateTextBox = By.id("enddate");
			// Select trip start date as today
			driver.findElement(tripStartDateTextBox).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			(new WebDriverWait(driver,20)).until(ExpectedConditions.elementToBeClickable(startDate)).click();
			
			// Select trip end date as tomorrow
			driver.findElement(tripEndDateTextBox).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			(new WebDriverWait(driver,20)).until(ExpectedConditions.elementToBeClickable(endDate)).click();
			 
			
		}
			
		 
	 
	
	 public void clickproceed() {
		 driver.findElement(proceed).click();
		 
	 }
	 public void filldetails(String name,String mobileno,String emailId) {
		 WebDriverWait wait = new WebDriverWait(driver,2000);
			
			// Wait till the element is not visible.
			wait.until(ExpectedConditions. visibilityOfElementLocated(salutation));
			Select select = new Select(driver.findElement(salutation));
			select.selectByVisibleText("Mr.");
			driver.findElement(entername).sendKeys(name);
			driver.findElement(mobile).sendKeys(mobileno);
			driver.findElement(email).sendKeys(emailId);
			//click get free quote button
			((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('proceedButton travelproceed')[0].click();");
	 }
	 public void sortinsurance() {
		 WebDriverWait wait = new WebDriverWait(driver,2000);
			
			// Wait till the element is not visible.
			wait.until(ExpectedConditions.presenceOfElementLocated(sortDropDownBox));
		Select sc = new Select (driver.findElement(sortDropDownBox));
		// sort by low to high price
		sc.selectByIndex(1);
	 }
	 public void getProductDetails() {
		 List<WebElement> insuranceProviderList = driver.findElements(insuranceProvider).subList(0, 3);
		 List<WebElement> productPriceList = driver.findElements(productPrice).subList(0, 3);
		 for(WebElement travelinsuranceProviderName: insuranceProviderList) {
				
				// Retrieved from class attribute value By replacing Logo String and added to ArrayList
				travelInsuranceProviderNames.add(travelinsuranceProviderName.getAttribute("class").replace("Logo ", ""));
				
			}
			
			System.out.println();
			for(WebElement price: productPriceList) {
				
				// Price is retrieved and added to ArrayList
				travelInsurancePrice.add(price.getText().substring(1));
				
		
			}
			System.out.println(travelInsuranceProviderNames);
			System.out.println(travelInsurancePrice);
	 }
	 public void teardown() {
		 driver.quit();
	 }
}
