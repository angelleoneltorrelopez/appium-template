package pom.android.apiDemosApp.views.lists;

import auxiliary.config.AndroidMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

/**
 * In this class are the elements and their actions of the SelectionMode.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class SelectionMode extends AndroidMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    AndroidDriver driver;

    public SelectionMode(AndroidDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }
    public void longPressAcornOption(){
        List<WebElement> list = driver.findElements(By.className("android.widget.CheckedTextView"));
        longPress(driver, list.get(5));
    }

    public boolean checkAcornOption(){
        List<WebElement> list = driver.findElements(By.className("android.widget.CheckedTextView"));
        return isChecked(list.get(5));
    }
}
