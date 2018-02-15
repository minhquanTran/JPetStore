package fr.henix.autom;

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

public class PetStoreTest {

	WebDriver driver;
	
	@Before
	public void setUp() {
		System.out.println("here and there : " + System.getProperty("browser"));
		
//		FirefoxOptions opts = new FirefoxOptions().setProfile(new FirefoxProfile());
//		opts.addPreference("browser.tabs.remote.autostart", false);
//		
//		System.setProperty("webdriver.gecko.driver", "D:\\new_data_QUAN\\HENIX\\SQUASH_TA_FORMATION\\Formation\\Selenium_Drivers\\geckodriver.exe");
//		driver = new FirefoxDriver(opts);
//		driver.get("http://localhost:8180/jpetstore");
		
		System.setProperty("webdriver.chrome.driver", "D:\\new_data_QUAN\\HENIX\\SQUASH_TA_FORMATION\\Formation\\Selenium_Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1() {
				
		WebElement myButton = driver.findElement(By.linkText("Enter the Store"));
		myButton.click();
		
//		WebElement myElementToBeChecked = driver.findElement(By.linkText("Sign In"));
		
		WebElement myElementToBeChecked = driver.findElement(By.xpath(".//*[@id='SidebarContent']/a[2]/img"));
		System.out.println(myElementToBeChecked.getAttribute("src"));
		Assert.assertEquals("http://localhost:8180/jpetstore/images/dogs_icon.gif", myElementToBeChecked.getAttribute("src"));
	}
}
