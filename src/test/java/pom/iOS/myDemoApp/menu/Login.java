package pom.iOS.myDemoApp.menu;

import auxiliary.config.IOSMethods;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * In this class are the elements and their actions of the Login.
 * @author Angel Torre
 * @version 07/11/2022
 */
public class Login extends IOSMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    IOSDriver driver;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Login\"]")
    WebElement title; //= "**/XCUIElementTypeStaticText[`label == \"Login\"`]";

    @FindBy(xpath = "//XCUIElementTypeTextField[@name=\"Username input field\"]")
    WebElement inputUsername;  //= "**/XCUIElementTypeTextField[`name == \"Username input field\"`]";

    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"Password input field\"]")
    WebElement inputPassword; //= "**/XCUIElementTypeSecureTextField[`name == \"Password input field\"`]";

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"Login button\"]")
    WebElement buttonLogin; //= "**/XCUIElementTypeOther[`label == \"Login\"`][3]";

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Provided credentials do not match any user in this service.\"]")
    WebElement errorCredentials; //= "**/XCUIElementTypeStaticText[`label == \"Provided credentials do not match any user in this service.\"`]";

    public Login(IOSDriver driver){
        this.driver = driver;
        ajaxElementLocatorFactory = new AjaxElementLocatorFactory(this.driver,10);
        PageFactory.initElements(ajaxElementLocatorFactory, this);
    }
    public String getTitle(){
        return getText(title);
    }

    public void sendTextInputUsername(String username){
        sendKeys(inputUsername, username);
    }

    public void sendTextInputPassword(String password){
        sendKeys(inputPassword, password);
    }

    public void clickLoginButton(){
        click(buttonLogin);
    }

    public String getErrorCredentialsMessage(){
        return getText(errorCredentials);
    }
}
