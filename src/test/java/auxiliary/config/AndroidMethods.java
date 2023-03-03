package auxiliary.config;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

/**
 * Class with the most used methods.
 * @author Angel Torre
 * @version 18/11/2022
 */
public class AndroidMethods {

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
    public Boolean isClickable(AndroidDriver driver, WebElement element, int timeOut) {
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
    public Boolean isDisplayed(AndroidDriver driver, WebElement element, int timeOut) {
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
    public void longPress(AndroidDriver driver, WebElement element) {

        new TouchAction(driver)
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
     * Method that makes a slide to an element.
     * @param driver
     * @param element
     * @param direction Direction. (UP, DOWN, LEFT, RIGHT).
     */
    public void swipeElement(AndroidDriver driver, WebElement element, Direction direction) {
        System.out.println("swipeElementAndroid(): direction: '" + direction + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder;
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Rectangle rect = element.getRect();
        // sometimes it is needed to configure edgeBorders
        // you can also improve borders to have vertical/horizontal
        // or left/right/up/down border variables
        edgeBorder = 0;

        switch (direction) {
            case DOWN: // from up to down
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                break;
            case UP: // from down to up
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                break;
            case LEFT: // from right to left
                pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + edgeBorder,
                        rect.y + rect.height / 2);
                break;
            case RIGHT: // from left to right
                pointOptionStart = PointOption.point(rect.x + edgeBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder,
                        rect.y + rect.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): direction: '" + direction + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    /**
     * Method that scrolls to find the element with the sent text.
     * @param driver
     * @param text Visible text to search.
     * @return Element.
     */
    public WebElement verticalScrollSearchText(AndroidDriver driver, String text) {
        return driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
    }

    private WebDriverWait waiter(AndroidDriver driver, int timeOut) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOut));
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}
