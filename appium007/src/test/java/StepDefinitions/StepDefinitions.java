package StepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.mainPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class StepDefinitions {
    AndroidDriver driver;
    String tittleText = "El desierto de Sal más grande del Mundo";
    String detailText = "Al suroeste de Bolivia, en el departamento de Potosí";
    mainPage mainP;
    @Given("browser is open")
    public void browser_is_open() throws MalformedURLException {
        System.out.println("ejecuto esto primero--------------------------");
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
    @When("user enters")
    public void user_enters() throws InterruptedException {
        System.out.println("ejecuto esto segundo--------------------------");
//        String tittleText = "El desierto de Sal más grande del Mundo";
//        String detailText = "Al suroeste de Bolivia, en el departamento de Potosí";

        System.out.println("Verify that as user then I can go to details for the first suggestion that is being displayed at top");
        Thread.sleep(4000);
        driver.get("https://traveler.jalasoft.com/home");
        Thread.sleep(4000);

        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")));
        String detailTextfromCell = driver.findElement(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")).getText();
        Assert.assertTrue(detailTextfromCell.contains(tittleText));
        driver.findElement(By.xpath("//android.view.View[contains(@text, tittleText)]")).click();
        Thread.sleep(3000);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, '"+detailText+"')]")));
        String detailText1 = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '"+detailText+"')]")).getText();
        Assert.assertTrue(detailText1.contains(detailText));

    }
    @Then("user is navigated to the app page")
    public void user_is_navigated_to_the_app_page() throws InterruptedException {
        System.out.println("ejecuto esto tercero--------------------------");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '')]")).click();
        Thread.sleep(3000);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")));
        String detailText2 = driver.findElement(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")).getText();
        Assert.assertTrue(detailText2.contains(tittleText));

    }

    @Then("go to google page")
    public void go_to_google_page() throws InterruptedException {
        mainP = new mainPage(driver);
        Thread.sleep(4000);
        driver.get("https://google.com");
        Thread.sleep(4000);
        mainP.enter_search("alejandro solano");

        Thread.sleep(2000);
    }
}
