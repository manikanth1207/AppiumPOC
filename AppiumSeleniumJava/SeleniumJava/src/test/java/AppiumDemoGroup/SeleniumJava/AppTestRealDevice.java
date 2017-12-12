package AppiumDemoGroup.SeleniumJava;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.HideKeyboardStrategy;


public class AppTestRealDevice {
	
	public AppiumDriver<IOSElement> driver;
	
	@Before
	public void setup() throws MalformedURLException {
		
		/*{
			  "platformName": "iOS",
			  "platformVersion": "11.0.3",
			  "deviceName": "Mani iPhone",
			  "app": "/Users/lantony/Documents/test1/Starbucks.app",
			  "noReset": true,
			  "udid": "64c7b9ac82e486119ef905a65881eaf987a77840"
			}*/
		//64c7b9ac82e486119ef905a65881eaf987a77840
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", "11.0.3");
		capabilities.setCapability("deviceName", "Mani iPhone");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("app", "/Users/lantony/Documents/test1/Starbucks.app");
		capabilities.setCapability("udid", "64c7b9ac82e486119ef905a65881eaf987a77840");
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("xcodeSigningId", "iPhone Developer");
		capabilities.setCapability("xcodeOrgId", "277P9WWF47");
		//capabilities.setCapability("automationName", "XCUITest");
		
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//"agentPath": "/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent/WebDriverAgent.xcodeproj",
		  //"bootstrapPath": "/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent"

	}
	
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void lsComplianceSampleTest()
	{
		IOSElement userIdText = driver.findElement(By.xpath("//XCUIElementTypeTextField[@value='Network ID']"));
		userIdText.sendKeys("lantony");
		//(//XCUIElementTypeOther[@name="Starbucks Licensed Stores Non-Compliance App WELCOME Network ID Network Password Log In "])[2]/XCUIElementTypeTextField
		//Network ID
		////XCUIElementTypeOther[@name="Network Password "]/XCUIElementTypeSecureTextField
		//Network Password
		//Log In
		IOSElement passwordText = driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Network Password ']/XCUIElementTypeSecureTextField"));
		passwordText.sendKeys("test@888");
		driver.findElementByName("WELCOME").click();
		//XCUIElementTypeStaticText[@name="WELCOME"]
		IOSElement button = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Log In']"));
		button.click();
		//button.click();
	}
}











