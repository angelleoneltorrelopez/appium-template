package test.android.myDemoApp;

import auxiliary.config.TestBase;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.android.myDemoApp.Catalog;
import pom.android.myDemoApp.Menu;
import pom.android.myDemoApp.NavBar;

import java.util.concurrent.TimeUnit;

/**
 * In this class are the tests for the login of the application.
 * @author Angel Torre
 * @version 25/10/2022
 */
public class Login extends TestBase {
    AndroidDriver driver;
    NavBar navBar;
    Menu menu;
    pom.android.myDemoApp.menu.Login login;

    Catalog catalog;
    public void startPom(AndroidDriver driver){
        navBar = new NavBar(driver);
        menu = new Menu(driver);
        login = new pom.android.myDemoApp.menu.Login(driver);
        catalog = new Catalog(driver);
    }

    @Test(priority = 1, description = "Verify login")
    public void testCheckLogin(){
        driver = androidDriver();
        startPom(driver);

        navBar.clickMenu();
        menu.clickLogOut();
        menu.clickLogOutAccept();
        menu.clickLogOutAccept();
        login.sendTextInputUsername("bob@example.com");
        login.sendTextInputPassword("10203040");
        login.clickLoginButton();
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception e) {
        }
        Assert.assertEquals(catalog.getTitle(), "Checkout");
        driver.quit();
    }

    @Test(priority = 2, description = "Check failed login")
    public void testCheckFailedLogin(){
        driver = androidDriver();
        startPom(driver);

        navBar.clickMenu();
        menu.clickLogOut();
        menu.clickLogOutAccept();
        menu.clickLogOutAccept();
        login.sendTextInputUsername("bob@example.com");
        login.sendTextInputPassword("1020304022222222");
        login.clickLoginButton();
        Assert.assertEquals(login.getTitle(), "Login");
        Assert.assertEquals(login.getErrorCredentialsMessage(), "Provided credentials do not match any user in this service.");
        driver.quit();
    }
}
