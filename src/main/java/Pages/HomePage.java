package Pages;

import org.openqa.selenium.By;

import base.TestBase;

public class HomePage extends TestBase{
	
	
	public HomePage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	By insuranceProd = By.xpath("//a[text()=\"Insurance Products \"]");
	By travelInsurance = By.cssSelector("div.ruby-menu-demo-header  li.ruby-menu-mega  div:nth-child(4) > ul > li:nth-child(1) > a");
    public void clickTravelInsurance() {
		
    driver.findElement(insuranceProd).click();
	driver.findElement(travelInsurance).click();
		
		
	}
	
}
