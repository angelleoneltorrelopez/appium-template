package pom.android.myDemoApp;

import auxiliary.config.AndroidMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * In this class are the elements and their actions of the Menu.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class Menu extends AndroidMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    AndroidDriver driver;
    String catalog = "//android.view.ViewGroup[@content-desc=\"menu item catalog\"]/android.widget.TextView";
    String webView = "";
    String QRCodeScanner  = "";
    String geoLocation = "";
    String drawing = "";
    String reportBug = "";
    String about = "";
    String resetAppState = "";
    String faceID = "";
    String logIn = "//android.view.ViewGroup[@content-desc=\"menu item log in\"]/android.widget.TextView";
    String logOut = "//android.view.ViewGroup[@content-desc=\"menu item log out\"]/android.widget.TextView";
    String apiCalls = "";
    String sauceBotVideo = "";


    public Menu(AndroidDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }

    public void clickCatalog(){
        click(driver.findElement(AppiumBy.xpath(catalog)));
    }

    public void clickWebView(){
        click(driver.findElement(AppiumBy.xpath(webView)));
    }

    public void clickQRCodeScanner(){
        click(driver.findElement(AppiumBy.xpath(QRCodeScanner)));
    }

    public void clickGeoLocation(){
        click(driver.findElement(AppiumBy.xpath(geoLocation)));
    }

    public void clickLogIn(){
        click(driver.findElement(AppiumBy.xpath(logIn)));
    }

    public void clickLogOut(){
        verticalScrollSearchText(driver, "Log Out");
        click(driver.findElement(AppiumBy.xpath(logOut)));
    }

    public void clickLogOutAccept(){
        click(driver.findElement(AppiumBy.id("android:id/button1")));
    }
}
