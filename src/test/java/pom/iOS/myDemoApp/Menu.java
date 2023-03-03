package pom.iOS.myDemoApp;

import auxiliary.config.IOSMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * In this class are the elements and their actions of the Menu.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class Menu extends IOSMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    IOSDriver driver;
    String webView = "**/XCUIElementTypeOther[`label == \"Webview\"`]";
    String QRCodeScanner  = "**/XCUIElementTypeOther[`label == \"QR Code Scanner\"`]";
    String geoLocation = "**/XCUIElementTypeOther[`label == \"Geo Location\"`]";
    String drawing = "**/XCUIElementTypeOther[`label == \"Drawing\"`]";
    String reportBug = "**/XCUIElementTypeOther[`label == \"Report A Bug\"`]";
    String about = "**/XCUIElementTypeOther[`label == \"About\"`]";
    String resetAppState = "**/XCUIElementTypeOther[`label == \"Reset App State\"`]";
    String faceID = "**/XCUIElementTypeOther[`label == \"FaceID\"`]";
    String logIn = "**/XCUIElementTypeOther[`label == \"Log In\"`]";
    String logOut = "**/XCUIElementTypeOther[`label == \"Log Out\"`]";
    String apiCalls = "**/XCUIElementTypeOther[`label == \"Api Calls\"`]";
    String sauceBotVideo = "**/XCUIElementTypeOther[`label == \"Sauce Bot Video\"`]";


    public Menu(IOSDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }
    public void clickWebView() {
        click(driver.findElement(AppiumBy.iOSClassChain(webView)));
    }

    public void clickQRCodeScanner(){
        click(driver.findElement(AppiumBy.iOSClassChain(QRCodeScanner)));
    }

    public void clickGeoLocation(){
        click(driver.findElement(AppiumBy.iOSClassChain(geoLocation)));
    }

    public void clickLogIn(){
        click(driver.findElement(AppiumBy.iOSClassChain(logIn)));
    }

    public void clickLogOut(){
        click(driver.findElement(AppiumBy.iOSClassChain(logOut)));
    }
}
