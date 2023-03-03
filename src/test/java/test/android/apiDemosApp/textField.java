package test.android.apiDemosApp;

import auxiliary.config.TestBase;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pom.android.apiDemosApp.MainList;
import pom.android.apiDemosApp.Views;
import pom.android.apiDemosApp.views.Buttons;
import pom.android.apiDemosApp.views.Lists;
import pom.android.apiDemosApp.views.TextFields;
import pom.android.apiDemosApp.views.lists.SelectionMode;

import static org.testng.Assert.assertEquals;

/**
 * In this class are the examples of the actions in a text field SendKey, GetText and clear.
 * @author Angel Torre
 * @version 13/10/2022
 */
public class textField extends TestBase {
    MainList mainList;
    Views views;
    Buttons buttons;
    TextFields textFields;
    Lists lists;
    SelectionMode selectionMode;
    AndroidDriver driver;

    public void startPom(AndroidDriver driver){
        mainList = new MainList(driver);
        views = new Views(driver);
        buttons = new Buttons(driver);
        textFields = new TextFields(driver);
        lists = new Lists(driver);
        selectionMode = new SelectionMode(driver);
    }

    @Test(priority = 1, description = "Write text in a TextField")
    public void testSendKeyTextField(){
        driver = androidDriver();
        startPom(driver);
        mainList.clickViewOption();
        views.clickTextFieldsOption();
        assertEquals(textFields.getTextTextField(), "hint text");
        textFields.sentTextTextField("Angel Torre");
        assertEquals(textFields.getTextTextField(), "Angel Torre");

        driver.quit();
    }

    @Test(priority = 2, description = "Get the text of a TextField")
    public void testGetTextTextField(){
        driver = androidDriver();
        startPom(driver);
        mainList.clickViewOption();
        views.clickTextFieldsOption();
        assertEquals(textFields.getTextTextField(), "hint text");
        textFields.sentTextTextField("Angel Torre");
        assertEquals(textFields.getTextTextField(), "Angel Torre");

        driver.quit();
    }

    @Test(priority = 3, description = "Clear text from a TextField")
    public void testClearTextTextField(){
        driver = androidDriver();
        startPom(driver);
        mainList.clickViewOption();
        views.clickTextFieldsOption();
        assertEquals(textFields.getTextTextField(), "hint text");
        textFields.sentTextTextField("Angel Torre");
        assertEquals(textFields.getTextTextField(), "Angel Torre");
        textFields.clearTextTextField();
        assertEquals(textFields.getTextTextField(), "hint text");

        driver.quit();
    }
}
