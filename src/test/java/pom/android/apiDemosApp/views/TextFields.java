package pom.android.apiDemosApp.views;

import auxiliary.config.AndroidMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * In this class are the elements and their actions of the TextFields.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class TextFields extends AndroidMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    @FindBy(id = "io.appium.android.apis:id/edit")
    WebElement textField;
    AndroidDriver driver;

    public TextFields(AndroidDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }

    public String getTextTextField(){
       return getText(textField);
    }

    public void sentTextTextField(String text){
        sendKeys(textField, text);
    }

    public void clearTextTextField(){
        clear(textField);
    }
}
