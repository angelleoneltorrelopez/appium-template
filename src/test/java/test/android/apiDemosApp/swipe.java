package test.android.apiDemosApp;

import auxiliary.config.TestBase;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pom.android.apiDemosApp.MainList;
import pom.android.apiDemosApp.Views;
import pom.android.apiDemosApp.views.Tabs;

/**
 * In this class, I'll see an example of the swipe action.
 * @author Angel Torre
 * @version 13/10/2022
 */
public class swipe extends TestBase {
    MainList mainList;
    Views views;
    Tabs tabs;
    AndroidDriver driver;

    public void startPom(AndroidDriver driver){
        mainList = new MainList(driver);
        views = new Views(driver);
        tabs = new Tabs(driver);
    }

    @Test(priority = 1, description = "Write text in a TextField")
    public void testSendKeyTextField(){
        driver = androidDriver();
        startPom(driver);
        mainList.clickViewOption();
        views.clickTabsOption();
        tabs.clickScrollable();
        tabs.leftSwipe();

        driver.quit();
    }
}
