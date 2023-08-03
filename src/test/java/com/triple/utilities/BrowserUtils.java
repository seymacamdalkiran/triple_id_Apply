package com.triple.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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

}
