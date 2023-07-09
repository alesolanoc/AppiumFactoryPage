package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mainPage {
    @FindBy(className = "android.widget.EditText")
    WebElement txt_search;
    AndroidDriver driver;
    public mainPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void enter_search(String searchCriteria){
        txt_search.sendKeys(searchCriteria);
    }

}
