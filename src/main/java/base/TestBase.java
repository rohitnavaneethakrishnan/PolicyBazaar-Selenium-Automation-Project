package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import util.ExtentReportManager;




public class TestBase {
	static Properties prop;
	private static final Logger logBase = LogManager
			.getLogger(base.TestBase.class);


     public ExtentReports report= ExtentReportManager.getReportInstance();
      public ExtentTest logger;
	public static WebDriver driver;
	
	public TestBase()throws Exception {
		try {
			String userDir=System.getProperty("user.dir");
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					userDir + "\\src\\main\\java\\config\\config.properties");
			
			//loading properties file
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public static void  invokeBrowser() throws MalformedURLException {
		
		
		try {
		String browsername = prop.getProperty("browser");
		String hubURL = prop.getProperty("hubURL");
		
		if(browsername.equalsIgnoreCase("Chrome")) {
    	
		  // define capabilities 
  		  ChromeOptions chromeOptions = new ChromeOptions();
		  chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		  chromeOptions.setCapability(CapabilityType.BROWSER_NAME,
		  chromeOptions.getBrowserName());
		  chromeOptions.setCapability(CapabilityType.VERSION,
		  chromeOptions.getVersion());
		 
		  chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
                  UnexpectedAlertBehaviour.IGNORE);
				
  		
  		// Instantiate a Remote web driver
  		driver = new RemoteWebDriver(new URL(hubURL),chromeOptions);
  		
  		
  	}
  	
  	else if (browsername.equalsIgnoreCase("Firefox")){
		
			DesiredCapabilities cap= DesiredCapabilities.firefox();
			cap.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
			cap.setPlatform(Platform.WINDOWS);
			
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.merge(cap);
			
			// Instantiate a Remote web driver
  		driver = new RemoteWebDriver(new URL(hubURL),firefoxOptions);
  		
  	}
		/*
		 * if(browsername.equalsIgnoreCase("Chrome")) {
		 * System.setProperty("webdriver.chrome.driver",
		 * ".\\Drivers\\chromedriver.exe"); driver=new ChromeDriver(); } else
		 * if(browsername.equalsIgnoreCase("Firefox")) {
		 * System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		 * FirefoxOptions options = new FirefoxOptions(); driver = new FirefoxDriver();
		 * }
		 */
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		/*
		String nodeurl_forChrome=" http://192.168.137.1:4444/wd/hub";
		DesiredCapabilities cap= DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		
		driver=new RemoteWebDriver(new URL(nodeurl_forChrome),cap);
		//String nodeurl_forChrome=" http://192.168.137.1:4444/wd/hub";
		//ChromeOptions cap = new ChromeOptions(); 
		//cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
		               //   UnexpectedAlertBehaviour.IGNORE);

		//driver = new RemoteWebDriver(new URL(nodeurl_forChrome),cap);
		/*
		                  String nodeurl_forFirefox=" http://192.168.137.1:4444/wd/hub";
		          		DesiredCapabilities cap= DesiredCapabilities.firefox();
		          		cap.setBrowserName("firefox");
		          		cap.setPlatform(Platform.WINDOWS);
		          		driver=new RemoteWebDriver(new URL(nodeurl_forFirefox),cap);
		     		                  
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		*/
		
    }
		
	@AfterMethod
	public void flushReports()throws Exception {
	report.flush();
	}

   
}
