package test.android.apiDemosApp;

import auxiliary.config.TestBase;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.android.apiDemosApp.MainList;
import pom.android.apiDemosApp.Views;
import pom.android.apiDemosApp.views.Lists;
import pom.android.apiDemosApp.views.lists.SelectionMode;

/**
 * In this class, I'll look at an example of the long click action.
 * @author Angel Torre
 * @version 13/10/2022
 */
public class longPress extends TestBase {
    MainList mainList;
    Views views;
    Lists lists;
    SelectionMode selectionMode;
    AndroidDriver driver;

    public void startPom(AndroidDriver driver){
        mainList = new MainList(driver);
        views = new Views(driver);
        lists = new Lists(driver);
        selectionMode = new SelectionMode(driver);
    }

    @Test(priority = 1 , description = "IP-264")
    public void testLongPress(){
        driver = androidDriver();
        startPom(driver);
        mainList.clickViewOption();
        views.clickListsOption();
        lists.clickSelectionModeOption();
        Assert.assertFalse(selectionMode.checkAcornOption());
        selectionMode.longPressAcornOption();
        Assert.assertTrue(selectionMode.checkAcornOption());

        driver.quit();
    }
}
