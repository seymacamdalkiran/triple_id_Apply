package com.triple.pages;

import com.triple.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a[@class='logo-link w-nav-brand w--current']")
    public WebElement logo;


    public void goToTheModule(String module){
        Driver.get().findElement(By.xpath("//a[.='"+module+"']")).click();
    }
}
