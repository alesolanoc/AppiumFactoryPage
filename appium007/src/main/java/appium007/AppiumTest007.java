// test with xpath , contains and ' when sending string values
package appium007;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class AppiumTest007 {
	AndroidDriver driver;
	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("automationName", "Appium");
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "R9WN20QXNLJ");
		caps.setCapability("platformVersion", "10.0");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.android.chrome");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.google.android.apps.chrome.Main");

		//		caps.setCapability("chromedriverExecutable","C:\\Users\\aleja\\Downloads\\chromedriver_win32\\chromedriver.exe");
		caps.setCapability("chromedriverExecutable","C:/Users/aleja/Downloads/chromedriver_win32/chromedriver.exe");
		caps.setCapability("noReset", true);
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AndroidDriver(url,caps);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
