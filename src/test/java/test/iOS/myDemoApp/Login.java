package test.iOS.myDemoApp;

import auxiliary.config.TestBase;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.iOS.myDemoApp.Catalog;
import pom.iOS.myDemoApp.Menu;
import pom.iOS.myDemoApp.NavBar;

/**
 * In this class are the tests for the login of the application.
 * @author Angel Torre
 * @version 25/10/2022
 */
public class Login extends TestBase {
    IOSDriver driver;
    NavBar navBar;
    Menu menu;
    pom.iOS.myDemoApp.menu.Login login;

    Catalog catalog;
    public void startPom(IOSDriver driver){
        navBar = new NavBar(driver);
        menu = new Menu(driver);
        login = new pom.iOS.myDemoApp.menu.Login(driver);
        catalog = new Catalog(driver);
    }

    @Test(priority = 1, description = "Verify login")
    public void testCheckLogin(){
        driver = iOSDriver();
        startPom(driver);

        navBar.clickMenu();
        menu.clickLogIn();
        login.sendTextInputUsername("bob@example.com");
        login.sendTextInputPassword("10203040");
        login.clickLoginButton();
        Assert.assertEquals(catalog.getTitle(), "Products");
        driver.quit();
    }

    @Test(priority = 2, description = "Check failed login")
    public void testCheckFailedLogin(){
        driver = iOSDriver();
        startPom(driver);

        navBar.clickMenu();
        menu.clickLogIn();
        login.sendTextInputUsername("bob@example.com");
        login.sendTextInputPassword("1020304022222222");
        login.clickLoginButton();
        Assert.assertEquals(login.getTitle(), "Login");
        Assert.assertEquals(login.getErrorCredentialsMessage(), "Provided credentials do not match any user in this service.");
        driver.quit();
    }
}
