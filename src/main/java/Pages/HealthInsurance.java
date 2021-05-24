package Pages;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.TestBase;

public class HealthInsurance extends TestBase{
	public HealthInsurance() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
    By Insurance_products_xpath=  By.xpath("//a[text()='Insurance Products ']");
    By Insurance_menu_items_xpath=By.xpath("//cclink/div[4]/div[1]/div/ul/li[2]/div/div/div[2]/ul/li/a/span");
    protected static ArrayList<String> healthlist = new ArrayList<>();
	public void gethealthinsuranceproducts() throws FileNotFoundException {
	Actions a=new Actions(driver);
    WebElement w=driver.findElement(Insurance_products_xpath);
    a.moveToElement(w).perform();
    List<WebElement> menu=new ArrayList<WebElement>();
    menu=driver.findElements(Insurance_menu_items_xpath);
    for(WebElement e:menu) {
    	System.out.println(e.getText());
    	healthlist.add(e.getText());
    }
    

}
	public void teardown() {
		driver.quit();
	}
}