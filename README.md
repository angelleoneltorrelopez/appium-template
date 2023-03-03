<p align="center">
  <a href="https://appium.io/"><img src="https://appium.io/img/appium-logo-sauce-white.png" width="300" height="100"/>
</a>
<a href="https://www.ingenieriazeros.com/">
<img src="https://1.bp.blogspot.com/-Q_GalsLLP0A/YYoUh73-MuI/AAAAAAAAMNc/OB4AIcWjB-UWJDKgH3c-kd0Syqt92lI-ACNcBGAsYHQ/s320/IMG_1169.PNG" 
width="150" height="150"></a>
</p>

# Description
This project is an automation test designed to demonstrate the use of the Appium tool to perform automated tests on 
Android, Iphone and API mobile applications. In this project, we use TestNG as a framework, Selenium and Appium to 
automate the interaction with a test app.

# Requirement
- Maven 3.8.6
- Java 11
- [Nodejs] ^18.12.1
- NPM ^8.19.2
- [Appium] 1.22.3
- [Appium inspector]
- Apple account (for iOS devices)
- Xcode (for iOS devices)

[Nodejs]: https://nodejs.org/en/
[Appium]: https://appium.io/
[app-debug.apk]: https://github.com/appium/appium/raw/1.x/sample-code/apps/ApiDemos-debug.apk
[Appium inspector]: https://github.com/appium/appium-inspector

## Dependencies used
| Name       | Version |
|------------|---------|
| [Selenium] | 4.8.1   |
| [Testng]   | 7.7.1   |
| [Appium]   | 8.3.0   |

[Selenium]: https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.4.0
[Testng]: https://mvnrepository.com/artifact/org.testng/testng
[Appium]: https://mvnrepository.com/artifact/io.appium/java-client

# supported devices
- Android
- Iphone

# Instalation
To install, follow the steps below:

1. Clone the repository from GitHub:
    ```bash
    git clone git@github.com:angelleoneltorrelopez/appium-practice.git
    ```
2. Install the project dependencies using the package manager:
    ```bash
    mvn install
    ```
   
# Use
To use the software, follow the steps below:

## Run test suite
Default Chrome browser
```bash
mvn clean verify
```

# Contact
If you have questions or comments about this project, please contact me at angelleoneltorrelopez@gmail.com.
Thank you for using this software!

adb shell dumpsys window | findstr mCurrentFocus