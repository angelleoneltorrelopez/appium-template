package pom.android.apiDemosApp;

import auxiliary.config.AndroidMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * In this class are the elements and their actions of the MainList.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class MainList extends AndroidMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    AndroidDriver driver;

    public MainList(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }

    public void clickViewOption(){
        click(verticalScrollSearchText(driver, "Views"));
    }
}
