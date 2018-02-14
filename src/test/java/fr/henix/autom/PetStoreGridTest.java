package fr.henix.autom;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PetStoreGridTest {

	WebDriver driver;
	
	@Before
	public void setUp() throws MalformedURLException {
//		String browserName = System.getProperty("browser").toLowerCase();
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");
		
		cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		
		driver = new RemoteWebDriver(new URL("http://192.168.1.100:4444/wd/hub"), cap);
		
//		FirefoxOptions opts = new FirefoxOptions().setProfile(new FirefoxProfile());
//		opts.addPreference("browser.tabs.remote.autostart", false);
//		
//		System.setProperty("webdriver.gecko.driver", "D:\\new_data_QUAN\\HENIX\\SQUASH_TA_FORMATION\\Formation\\Selenium Drivers\\geckodriver.exe");
//		driver = new FirefoxDriver(opts);
		driver.get("http://localhost:8180/jpetstore");
	}
	
	@Test
	public void test1() {
//		System.setProperty("webdriver.chrome.driver", "D:\\new_data_QUAN\\HENIX\\SQUASH_TA_FORMATION\\Formation\\Selenium Drivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		WebElement myButton = driver.findElement(By.linkText("Enter the Store"));
		myButton.click();
		
//		WebElement myElementToBeChecked = driver.findElement(By.linkText("Sign In"));
		
		WebElement myElementToBeChecked = driver.findElement(By.xpath(".//*[@id='SidebarContent']/a[2]/img"));
		System.out.println(myElementToBeChecked.getAttribute("src"));
		Assert.assertEquals("http://localhost:8180/jpetstore/images/dogs_icon.gif", myElementToBeChecked.getAttribute("src"));
	}
}
