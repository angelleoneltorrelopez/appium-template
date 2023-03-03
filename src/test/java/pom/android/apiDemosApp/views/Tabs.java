package pom.android.apiDemosApp.views;

import auxiliary.config.AndroidMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

/**
 * In this class are the elements and their actions of the Tabs.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class Tabs extends AndroidMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    @FindBy(className = "android.widget.LinearLayout")
    List<WebElement> tabs;
    AndroidDriver driver;

    public Tabs(AndroidDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }

    public void clickScrollable(){
        click(verticalScrollSearchText(driver, "5. Scrollable"));
    }

    public  void leftSwipe(){
        swipeElement(driver, tabs.get(2), Direction.LEFT);
    }
}
