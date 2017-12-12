package AppiumDemoGroup.SeleniumJava;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class LsNonComplianceTestClass {
	
	public AppiumDriver<IOSElement> driver;
	
	@Before
	public void setup() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", "11.2");
		capabilities.setCapability("deviceName", "iPad Air");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("app", "/Users/lantony/Documents/ManiAppiumFiles/LsCompMani.ipa");
		capabilities.setCapability("noReset", "true");
		
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void LsNonComplianceCreateNNC() throws InterruptedException
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
		IOSElement button = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Log In']"));
		button.click();
		button.click();
		
		// //XCUIElementTypeStaticText[@name='CREATE NON-COMPLIANCE']
		Thread.sleep(10000);
		IOSElement buttonCreate = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='CREATE NON-COMPLIANCE']"));
		buttonCreate.click();
		Thread.sleep(1000);
		// //XCUIElementTypeOther[@name=' Store # ']/XCUIElementTypeOther/XCUIElementTypeTextField
		// //XCUIElementTypeOther[@name='Search By Store # ']/XCUIElementTypeTextField
		// 72966
		IOSElement storenumText = driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Search By Store # ']/XCUIElementTypeTextField"));
		storenumText.sendKeys("72966");
		Thread.sleep(2000);
		//  //XCUIElementTypeStaticText[@name="72966"]
		// wait 10 sec
		IOSElement selectStore = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='72966']"));
		selectStore.click();
		selectStore.click();
		Thread.sleep(3000);
		// //XCUIElementTypeStaticText[@name="Next"]
		IOSElement next = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Next']"));
		next.click();
		Thread.sleep(1000);
		// //XCUIElementTypeStaticText[@name="Submit"]
		IOSElement submit = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Submit']"));
		submit.click();
		Thread.sleep(3000);
		
		driver.switchTo(). alert().accept();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	}
	
	/*
	@Test
	public void LsNonComplianceApproveNNC()
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
		IOSElement button = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Log In']"));
		button.click();
		button.click();
		
		
		// //XCUIElementTypeStaticText[@name="APPROVALS"]
		// (//XCUIElementTypeOther[contains(@name, 'NNC Approval >')])[2]
		// select first and from that element select
		// //XCUIElementTypeStaticText - first one NNC id
		// //XCUIElementTypeStaticText[@name="NNC Approval"]
		
		IOSElement approvalLink = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='APPROVALS']"));
		approvalLink.click();

		List<IOSElement> nncRow = driver.findElements(By.xpath("(//XCUIElementTypeOther[contains(@name, 'NNC Approval >')])[2]"));

		
		//List<MobileElement> columns = nncRow.findElements(By.xpath(".//*"));
		
		int a=2;
		a=a+2;
		          
		//// (//XCUIElementTypeStaticText[@name="NNC Approval"])[1]
		// 
		// 
		// 
		// 
		
		
		// //XCUIElementTypeStaticText[@name="CREATE NON-COMPLIANCE"]
		// 
		// 
		// 
		
	}
	
	
	*/

/*	
	# Run tests and generate .xml reports
	mvn test

	# Convert .xml reports into .html report, but without the CSS or images
	mvn surefire-report:report-only

	# Put the CSS and images where they need to be without the rest of the
	# time-consuming stuff
	mvn site -DgenerateReports=false
	
	go to target/site/surefire-report.html for the report.
	
	*/
}













