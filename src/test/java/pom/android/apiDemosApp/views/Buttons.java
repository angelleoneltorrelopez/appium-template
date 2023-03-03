package pom.android.apiDemosApp.views;

import auxiliary.config.AndroidMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * In this class are the elements and their actions of the Buttons.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class Buttons extends AndroidMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    @FindBy(id = "io.appium.android.apis:id/button_toggle")
    WebElement buttonToggle;
    AndroidDriver driver;

    public Buttons(AndroidDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }

    public String getTextButtonToggle(){
        return getText(buttonToggle);
    }

    public void clickButtonToggle(){
        click(buttonToggle);
    }
}
