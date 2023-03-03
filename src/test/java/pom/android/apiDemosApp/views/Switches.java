package pom.android.apiDemosApp.views;

import auxiliary.config.AndroidMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * In this class are the elements and their actions of the Switches.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class Switches extends AndroidMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    AndroidDriver driver;

    public Switches(AndroidDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }

    public boolean checkSwitch(){
        WebElement element = driver.findElement(By.xpath("//android.widget.Switch[@content-desc=\"Standard switch\"]"));
        return isChecked(element);
    }

    public void clickSwitch(){
        WebElement element = driver.findElement(By.xpath("//android.widget.Switch[@content-desc=\"Standard switch\"]"));
        click(element);
    }
}
