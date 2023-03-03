package auxiliary.config;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Driver capabilities configuration class.
 * @author Angel Torre
 * @version 18/11/2022
 */
public class DriverCapabilities {

    /**
     * AndroidCapabilities settings.
     * @return AndroidDriver capabilities.
     */
    public static DesiredCapabilities android(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", LocalConfiguration.AndroidCapabilities.deviceName);
        desiredCapabilities.setCapability("udid", LocalConfiguration.AndroidCapabilities.udId);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", LocalConfiguration.AndroidCapabilities.platformVersion);
        desiredCapabilities.setCapability("app", LocalConfiguration.AndroidCapabilities.app);
        //desiredCapabilities.setCapability("appPackage", LocalConfiguration.AndroidCapabilities.appPackage);
        //desiredCapabilities.setCapability("appActivity", LocalConfiguration.AndroidCapabilities.appActivity);
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("noReset", "true");
        return desiredCapabilities;
    }

    /**
     * iOSCapabilities settings.
     * @return IOSDriver capabilities.
     */
    public static DesiredCapabilities iOS(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", LocalConfiguration.IOSCapabilities.deviceName);
        desiredCapabilities.setCapability("udid", LocalConfiguration.IOSCapabilities.udId);
        desiredCapabilities.setCapability("platformName", "IOS");
        desiredCapabilities.setCapability("platformVersion", LocalConfiguration.IOSCapabilities.platformVersion);
        desiredCapabilities.setCapability("app", LocalConfiguration.IOSCapabilities.app);
        //desiredCapabilities.setCapability("bundleId", LocalConfiguration.IOSCapabilities.bundleId);
        //desiredCapabilities.setCapability("xcodeOrgId", LocalConfiguration.IOSCapabilities.xcodeOrgId);
        //desiredCapabilities.setCapability("xcodeSigningId", "iPhone Developer");
        desiredCapabilities.setCapability("automationName", "XCUITest");
        return desiredCapabilities;
    }

    public static DesiredCapabilities kobiton(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("sessionName", LocalConfiguration.KobitonCapabilities.sessionName);
        desiredCapabilities.setCapability("sessionDescription", LocalConfiguration.KobitonCapabilities.sessionDescription);
        desiredCapabilities.setCapability("captureScreenshots", LocalConfiguration.KobitonCapabilities.captureScreenshots);
        desiredCapabilities.setCapability("app", LocalConfiguration.KobitonCapabilities.app);
        desiredCapabilities.setCapability("groupId", LocalConfiguration.KobitonCapabilities.groupId);
        desiredCapabilities.setCapability("deviceGroup", LocalConfiguration.KobitonCapabilities.deviceGroup);
        desiredCapabilities.setCapability("deviceName", LocalConfiguration.KobitonCapabilities.kobitonDeviceName);
        desiredCapabilities.setCapability("platformVersion", LocalConfiguration.KobitonCapabilities.kobitonPlatformVersion);
        desiredCapabilities.setCapability("platformName", LocalConfiguration.KobitonCapabilities.kobitonPlatformName);
        return desiredCapabilities;
    }
}
