package auxiliary.config;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

/**
 * Class with the most used methods.
 * @author Angel Torre
 * @version 18/11/2022
 */
public class IOSMethods {

    /**
     * Method that resets its value if the element is an input element.
     * @param element
     */
    public void clear(WebElement element) {
        try {
            element.clear();
        } catch (Exception Error) {
            Error.printStackTrace();
        }
    }

    /**
     * Method that performs the action of clicking on an element.
     * @param element
     * @return if clicked, it returns true, and if not, it returns false.
     */
    public Boolean click(WebElement element) {
        try {
            element.click();
            return true;
        } catch (Exception Error) {
            Error.printStackTrace();
            return false;
        }
    }

    /**
     * Method to get the visible (that is, not hidden by CSS) text of this element, including any sub-elements.
     * @param element
     * @return The visible text of this element.
     */
    public String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception Error) {
            Error.printStackTrace();
            return "There is an exception Error";
        }
    }

    /**
     * Method that checks if the "checked" attribute is active.
     * @param element
     * @return Checked returns true and unchecked returns false.
     */
    public boolean isChecked(WebElement element) {
        try{
            return element.getAttribute("checked").equals("true");
        } catch (Exception Error){
            Error.printStackTrace();
            return false;
        }
    }

    /**
     * Method that waits for an element to be clickable.
     * @param driver
     * @param element
     * @param timeOut Waiting time in seconds.
     * @return If it's clickable, it returns true and if it's not clickable, it returns false.
     */
    public Boolean isClickable(IOSDriver driver, WebElement element, int timeOut) {
        try {
            waiter(driver, timeOut).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception Error) {
            Error.printStackTrace();
            return false;
        }
    }

    /**
     * Method that waits for the element to become visible.
     * @param driver
     * @param element
     * @param timeOut Waiting time in seconds.
     * @return If it is visible it returns true and if it is not visible it returns false.
     */
    public Boolean isDisplayed(IOSDriver driver, WebElement element, int timeOut) {
        try {
            waiter(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception Error) {
            Error.printStackTrace();
            return false;
        }
    }

    /**
     * Method that makes a long click.
     * @param driver
     * @param element
     */
    public void longPress(IOSDriver driver, WebElement element) {
        new TouchAction<>(driver)
                .longPress(longPressOptions().withElement(element(element)).withDuration(Duration.ofMillis(10000)))
                .release()
                .perform();
    }

    /**
     * Method to simulate writing to an element, which can set its value.
     * @param element
     * @param text Character sequence to send to the element.
     * @return
     */
    public Boolean sendKeys(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            return true;
        } catch (Exception Error) {
            Error.printStackTrace();
            return false;
        }
    }

    /**
     * Method that scrolls the screen.
     * @param driver
     * @param direction Direction. (UP, DOWN, LEFT, RIGHT).
     */
    public void swipeScreen(IOSDriver driver, Direction direction) {
        System.out.println("mobileSwipeScreenIOS(): direction: '" + direction + "'"); // always log your actions

        // Animation default time:
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms
        final HashMap<String, String> scrollObject = new HashMap<String, String>();

        switch (direction) {
            case DOWN: // from up to down (! differs from mobile:scroll)
                scrollObject.put("direction", "down");
                break;
            case UP: // from down to up  (! differs from mobile:scroll)
                scrollObject.put("direction", "up");
                break;
            case LEFT: // from right to left  (! differs from mobile:scroll)
                scrollObject.put("direction", "left");
                break;
            case RIGHT: // from left to right  (! differs from mobile:scroll)
                scrollObject.put("direction", "right");
                break;
            default:
                throw new IllegalArgumentException("mobileSwipeScreenIOS(): direction: '" + direction + "' NOT supported");
        }
        try {
            driver.executeScript("mobile:swipe", scrollObject);
            Thread.sleep(ANIMATION_TIME); // always allow swipe action to complete
        } catch (Exception e) {
            System.err.println("mobileSwipeScreenIOS(): FAILED\n" + e.getMessage());
            return;
        }
    }

    private WebDriverWait waiter(IOSDriver driver, int timeOut) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOut));
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}
