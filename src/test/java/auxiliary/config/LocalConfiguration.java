package auxiliary.config;

/**
 * Class with the capabilities configuration variables.
 * @author Angel Torre
 * @version 18/11/2022
 */
public class LocalConfiguration {
    public static class AndroidCapabilities {

        /**
         * The absolute local path or remote http URL.
         */
        public final static String app = "app/Android-MyDemoAppRN.1.3.0.build-244.apk";

        /**
         * Activity name for the Android activity you want to launch from your package.
         */
        public final static String appActivity = ".ApiDemos";

        /**
         * Java package of the Android app you want to run.
         */
        public final static String appPackage = "io.appium.android.apis";

        /**
         * The kind of mobile device or emulator to use.
         */
        public final static String deviceName = "emulator-5554";

        /**
         * Mobile OS version.
         */
        public final static String platformVersion = "11";

        /**
         * Unique device identifier of the connected physical device.
         */
        public final static String udId = "emulator-5554";
    }

    public static class IOSCapabilities {

        /**
         * The absolute local path or remote http URL.
         */
        public final static String app = "app/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip";

        /**
         * Bundle ID of the app under test.
         */
        public final static String bundleId = "com.apple.Health";

        /**
         * The kind of mobile device or emulator to use.
         */
        public final static String deviceName = "iPhone 13";

        /**
         * Mobile OS version.
         */
        public final static String platformVersion = "15.2";

        /**
         * Unique device identifier of the connected physical device.
         */
        public final static String udId = "DC3C38F7-BCD8-4753-84D2-0FDDEE05D830";

        /**
         * Unique identifier for the Apple account organization.
         */
        public final static String xcodeOrgId = "HURZ6CC95B";
    }

    public static class KobitonCapabilities {
        public final static String kobitonServerUrl = "https://angeltorre:e56548c1-274d-4f3e-9528-577872eabda8@api.kobiton.com/wd/hub";
        public final static String sessionName = "Automation test session";
        public final static String sessionDescription = "Description";
        public final static boolean captureScreenshots = false;
        public final static String app = "<APP_URL> o <App ID example kobiton-store:v223145>";
        public final static int groupId = 513;
        public final static String deviceGroup = "KOBITON";
        public final static String kobitonDeviceName = "Galaxy A10e";
        public final static String kobitonPlatformVersion = "10";
        public final static String kobitonPlatformName = "Android";
    }
}
