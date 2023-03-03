package test.android.apiDemosApp;

import auxiliary.config.TestBase;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import pom.android.apiDemosApp.MainList;
import pom.android.apiDemosApp.Views;
import pom.android.apiDemosApp.views.Buttons;

import static org.testng.Assert.assertEquals;

/**
 * In this class, I'll look at an example of a button click action.
 * @author Angel Torre
 * @version 13/10/2022
 */
public class button extends TestBase {
    MainList mainList;
    Views views;
    Buttons buttons;
    AndroidDriver driver;

    public void startPom(AndroidDriver driver){
        mainList = new MainList(driver);
        views = new Views(driver);
        buttons = new Buttons(driver);
    }

    @Test(priority = 1, description = "Using the Click a Button Action")
    public void testClickButton(){
        driver = androidDriver();
        startPom(driver);
        mainList.clickViewOption();
        views.clickButtonsOption();
        assertEquals(buttons.getTextButtonToggle(), "OFF");

        buttons.clickButtonToggle();
        assertEquals(buttons.getTextButtonToggle(), "ON");

        driver.quit();
    }
}
