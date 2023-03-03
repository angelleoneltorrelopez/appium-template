package pom.iOS.myDemoApp;

import auxiliary.config.IOSMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * In this class are the elements and their actions of the NavBar.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class NavBar extends IOSMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    IOSDriver driver;
    String menu = "**/XCUIElementTypeButton[`label == \"Menu, tab, 3 of 3\"`]";
    String card  = "**/XCUIElementTypeButton[`label == \"0\"`]";
    String catalog = "**/XCUIElementTypeButton[`label == \"Catalog, tab, 1 of 3\"`]";

    public NavBar(IOSDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }
    public void clickMenu(){
        click(driver.findElement(AppiumBy.iOSClassChain(menu)));
    }

    public void clickCard(){
        click(driver.findElement(AppiumBy.iOSClassChain(card)));
    }

    public void clickCatalog(){
        click(driver.findElement(AppiumBy.iOSClassChain(catalog)));
    }
}
