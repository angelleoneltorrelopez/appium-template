package pom.iOS.myDemoApp;

import auxiliary.config.IOSMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * In this class are the elements and their actions of the Catalog.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class Catalog extends IOSMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    IOSDriver driver;
    String title = "**/XCUIElementTypeStaticText[`label == \"Products\"`]";
    String product  = "**/XCUIElementTypeOther[`label == \"Sauce Labs Onesie\"`]";

    public Catalog(IOSDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }
    public String getTitle() {
        return getText(driver.findElement(AppiumBy.iOSClassChain(title)));
    }

    public String getProductName(){
        return getText(driver.findElement(AppiumBy.iOSClassChain(product)));
    }
}
