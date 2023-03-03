package pom.android.apiDemosApp;

import auxiliary.config.AndroidMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * In this class are the elements and their actions of the Views.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class Views extends AndroidMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;

    AndroidDriver driver;

    public Views(AndroidDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }
    public void clickButtonsOption(){
        WebElement element = verticalScrollSearchText(driver, "Buttons");
        click(element);
    }

    public void clickTextFieldsOption(){
        click(verticalScrollSearchText(driver, "TextFields"));
    }

    public void clickListsOption(){
        click(verticalScrollSearchText(driver, "Lists"));
    }

    public void clickSwitchOption(){
        click(verticalScrollSearchText(driver, "Switches"));
    }

    public void clickTabsOption(){
        click(verticalScrollSearchText(driver, "Tabs"));
    }
}
