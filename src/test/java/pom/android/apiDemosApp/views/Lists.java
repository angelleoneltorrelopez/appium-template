package pom.android.apiDemosApp.views;

import auxiliary.config.AndroidMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * In this class are the elements and their actions of the Lists.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class Lists extends AndroidMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;

    AndroidDriver driver;

    public Lists(AndroidDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }
    public void clickSelectionModeOption(){
        click(verticalScrollSearchText(driver, "15. Selection Mode"));
    }
}
