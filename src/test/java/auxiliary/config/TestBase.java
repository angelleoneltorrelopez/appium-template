package auxiliary.config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * In this class the server is installed and the controller to be used is configured.
 * @author Angel Torre
 * @version 18/11/2022
 */
public class TestBase {
    private static AppiumDriverLocalService service;
    DesiredCapabilities capabilities;

    /**
     * Method that starts the Android driver with its capabilities.
     * @return AndroidDriver.
     */
    public AndroidDriver androidDriver() {
        capabilities = DriverCapabilities.android();
        AndroidDriver driver = new AndroidDriver(getServiceUrl(), capabilities);
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        return driver;
    }

    /**
     * Method that starts the IOS driver with its capabilities.
     * @return IOSDriver.
     */
    public IOSDriver iOSDriver() {
        capabilities = DriverCapabilities.iOS();
        IOSDriver driver = new IOSDriver(getServiceUrl(), capabilities);
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        return driver;
    }

    /**
     * Method that starts the Appium driver with its capabilities.
     * @return AppiumDriver
     */
    public AppiumDriver appiumDriver() {
        capabilities = DriverCapabilities.iOS();
        AppiumDriver driver = new AppiumDriver(getServiceUrl(), capabilities);
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        return driver;
    }

    public AppiumDriver kobitonDriver() throws MalformedURLException {
        capabilities = DriverCapabilities.kobiton();
        AppiumDriver driver = new IOSDriver(new URL(LocalConfiguration.KobitonCapabilities.kobitonServerUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        return driver;
    }

    /**
     * Method that initializes and starts the appium server at the beginning of the suite.
     */
    @BeforeSuite()
    public void globalSetup () {
        AppiumServiceBuilder serverBuilder = new AppiumServiceBuilder();
        serverBuilder.usingAnyFreePort();
        serverBuilder.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/");
        serverBuilder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        service = AppiumDriverLocalService.buildService(serverBuilder);
        service.start();
    }

    /**
     * Method that close the appium server at the end of the suite.
     */
    @AfterSuite()
    public void globalTearDown () {
        if (service != null) {
            service.stop();
        }
    }

    /**
     * Method to get the Appium server URL.
     * @return Appium server URL
     */
    public URL getServiceUrl () {
        return service.getUrl();
    }
}
