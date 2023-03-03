package test.android.apiDemosApp;

import auxiliary.config.TestBase;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.android.apiDemosApp.MainList;
import pom.android.apiDemosApp.Views;
import pom.android.apiDemosApp.views.Lists;
import pom.android.apiDemosApp.views.Switches;

/**
 * In this class, I will see an example of checking the status of a switch.
 * @author Angel Torre
 * @version 13/10/2022
 */
public class switches extends TestBase {
    MainList mainList;
    Views views;
    Lists lists;
    Switches switches;
    AndroidDriver driver;

    public void startPom(AndroidDriver driver){
        mainList = new MainList(driver);
        views = new Views(driver);
        lists = new Lists(driver);
        switches = new Switches(driver);
    }

    @Test(priority = 1, description = "IP-264")
    public void testSendKeyTextField(){
        driver = androidDriver();
        startPom(driver);
        mainList.clickViewOption();
        views.clickSwitchOption();

        Assert.assertFalse(switches.checkSwitch());
        switches.clickSwitch();
        Assert.assertTrue(switches.checkSwitch());

        driver.quit();
    }
}
