package pom.android.myDemoApp;

import auxiliary.config.AndroidMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * In this class are the elements and their actions of the NavBar.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class NavBar extends AndroidMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    AndroidDriver driver;
    String menu = "//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView";
    String card  = "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView";

    public NavBar(AndroidDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }
    public void clickMenu(){
        click(driver.findElement(AppiumBy.xpath(menu)));
    }

    public void clickCard(){
        click(driver.findElement(AppiumBy.xpath(card)));
    }
}
