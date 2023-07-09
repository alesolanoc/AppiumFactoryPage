package appium007;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;

public class Tests extends AppiumTest007 {
	@Test
	public void testOne() throws InterruptedException {
		String tittleText = "El desierto de Sal más grande del Mundo";
		String detailText = "Al suroeste de Bolivia, en el departamento de Potosí";
		
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
        Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '')]")).click();
        Thread.sleep(3000);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")));
		String detailText2 = driver.findElement(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")).getText();
		Assert.assertTrue(detailText2.contains(tittleText));
	}


	@Test
	public void testTwo() throws InterruptedException {
		String tittleText = "Pubs - Discotecas La Paz";
		String detailText = "Pubs - Discotecas La Paz";

		System.out.println("Verify that as user then I can go to details for the first suggestion that is being displayed in the grid");
		Thread.sleep(4000);
		driver.get("https://traveler.jalasoft.com/home");
		Thread.sleep(4000);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")));
		String detailTextfromCell = driver.findElement(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")).getText();
		Assert.assertTrue(detailTextfromCell.contains(tittleText));
		driver.findElement(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")).click();
		Thread.sleep(3000);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, '"+detailText+"')]")));
		String detailText1 = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '"+detailText+"')]")).getText();
		Assert.assertTrue(detailText.contains(detailText1));
        Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '')]")).click();
        Thread.sleep(3000);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")));
		String detailText2 = driver.findElement(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")).getText();
		Assert.assertTrue(detailText2.contains(tittleText));
	}

	@Test
	public void testTree() throws InterruptedException {
		String tittleText = "Pubs - Discotecas La Paz";
		String detailText = "Pubs - Discotecas La Paz";

		System.out.println("Verify that as user then I can go to details for the first suggestion that is being displayed in the grid after scroll down to the end");
		Thread.sleep(4000);
		driver.get("https://traveler.jalasoft.com/home");
		Thread.sleep(4000);
		Point locationY = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1)")).getLocation();
	//	Point locationY1 = driver.findElement(MobileBy.AndroidUIAutomator(detailText);
		Assert.assertEquals(locationY.y,153);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")));
		String detailTextfromCell = driver.findElement(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")).getText();
		Assert.assertTrue(detailTextfromCell.contains(tittleText));
		driver.findElement(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")).click();
		Thread.sleep(3000);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, '"+detailText+"')]")));
		String detailText1 = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '"+detailText+"')]")).getText();
		Assert.assertTrue(detailText.contains(detailText1));
        Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '')]")).click();
        Thread.sleep(3000);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")));
		String detailText2 = driver.findElement(By.xpath("//android.view.View[contains(@text, '"+tittleText+"')]")).getText();
		Assert.assertTrue(detailText2.contains(tittleText));
	}


}
