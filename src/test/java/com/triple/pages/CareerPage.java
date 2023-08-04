package com.triple.pages;

import com.triple.utilities.BrowserUtils;
import com.triple.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CareerPage extends BasePage{

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-lg'])[2]")
    public WebElement applyForThisJob;
    @FindBy(css = "#file")
    public WebElement addResumeBtn;
    @FindBy(xpath = "//div[contains(text(),'resume')]")
    public WebElement addingResumeMessage;
    @FindBy(xpath = "//input[@name='linkedin_profile']")
    public WebElement inputLinkedin;
    @FindBy(xpath = "//input[@class='form-check-input ']")
    public WebElement privacyNotive;
    @FindBy(xpath = "//a[contains(.,'SUBMIT')]")
    public WebElement submitBtn;
    @FindBy(id = "linkQuestion_2985704")
    public WebElement english;
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successfullySubmitMessage;

    public void goToTheJob(String job){
        WebElement element = Driver.get().findElement(By.xpath("//h5[.='" + job + "']"));
        BrowserUtils.clickWithJS(element);
    }
    public void addResume(){
        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/SeymaDalkiranCam.pdf";
        String resumePath=projectPath+"/"+filePath;
        addResumeBtn.sendKeys(resumePath);
    }
    public void addCoverLetter(String coverLetter,String englishLevel){
        Actions actions=new Actions(Driver.get());
        actions.click(inputLinkedin)
                .sendKeys(""+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB+coverLetter+Keys.TAB+Keys.TAB+Keys.TAB+Keys.TAB).perform();

        Select select=new Select(english);
        select.selectByIndex(Integer.parseInt(englishLevel));
        select.getFirstSelectedOption().click();
    }
    public void validateSubmitMessage(String message){
        BrowserUtils.waitForVisibility(successfullySubmitMessage,5);
        Assert.assertTrue(successfullySubmitMessage.getText().contains(message));
    }
}
