package com.triple.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BrowserUtils {

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }
    public static void changeWindowTab(){
        String currentWindow = Driver.get().getWindowHandle();
        Set<String> allWindows = Driver.get().getWindowHandles();
        for (String allWindow : allWindows) {
            if(!currentWindow.equals(allWindow)){
                Driver.get().switchTo().window(allWindow);
            }
        }
    }
    public static void scrollDown(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.get();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);" );
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        //WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        //WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            //WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(20));
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        //    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        //WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
