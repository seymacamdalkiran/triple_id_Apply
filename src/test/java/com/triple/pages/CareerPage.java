package com.triple.pages;


import com.triple.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CareerPage extends BasePage{

    @FindBy(xpath = "//a[@class='btn btn-primary btn-lg']")
    public WebElement applyForThisJob;

    @FindBy(css = "#file")
    public WebElement addResumeBtn;

    @FindBy(xpath = "//input[@name='linkedin_profile']")
    public WebElement inputLinkedin;
    @FindBy(id = "checkbox_7615914")
    public WebElement privacyNotive;
    @FindBy(xpath = "//a[contains(.,'SUBMIT')]")
    public WebElement submitBtn;

    public void goToTheJob(String job){
        Driver.get().findElement(By.xpath("//h5[.='"+job+"']")).click();
    }
    public void addResume(){
        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/SeymaDalkiranCam.pdf";
        String resumePath=projectPath+"/"+filePath;
        addResumeBtn.sendKeys(resumePath);
    }
    public void fillTheApplicationRequirements(String linkedin, String fullname, String email, String phone, String company, String coverletter, String experienceYear, String englishLevel){
        Actions actions=new Actions(Driver.get());
        actions.click(inputLinkedin)
                .sendKeys(linkedin + Keys.TAB)
                .sendKeys(fullname + Keys.TAB)
                .sendKeys(email + Keys.TAB)
                .sendKeys(phone + Keys.TAB)
                .sendKeys(company + Keys.TAB)
                .sendKeys(coverletter + Keys.TAB)
                .sendKeys(experienceYear + Keys.TAB)
                .sendKeys(englishLevel).perform();
    }
}
