package pom.android.myDemoApp;

import auxiliary.config.AndroidMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * In this class are the elements and their actions of the Catalog.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class Catalog extends AndroidMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    AndroidDriver driver;
    String title = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView";
    String product  = "(//android.widget.TextView[@content-desc=\"store item text\"])[3]";

    public Catalog(AndroidDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }
    public String getTitle(){
        return getText(driver.findElement(AppiumBy.xpath(title)));
    }

    public String getProductName(){
        return getText(driver.findElement(AppiumBy.xpath(product)));
    }
}
