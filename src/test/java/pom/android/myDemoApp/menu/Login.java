package pom.android.myDemoApp.menu;

import auxiliary.config.AndroidMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * In this class are the elements and their actions of the Login.
 * @author Angel Torre
 * @version 08/11/2022
 */
public class Login extends AndroidMethods {
    AjaxElementLocatorFactory ajaxElementLocatorFactory;
    AndroidDriver driver;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
    WebElement title;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"Username input field\"]")
    WebElement inputUsername;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"Password input field\"]")
    WebElement inputPassword;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Login button\"]/android.widget.TextView")
    WebElement buttonLogin;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"generic-error-message\"]/android.widget.TextView")
    WebElement errorCredentials;

    public Login(AndroidDriver driver){
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
