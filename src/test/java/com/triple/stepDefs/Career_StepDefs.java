package com.triple.stepDefs;

import com.triple.pages.CareerPage;
import com.triple.utilities.BrowserUtils;
import com.triple.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class Career_StepDefs {
    CareerPage careerPage = new CareerPage();


    @Given("The user should go to the home page")
    public void the_user_should_go_to_the_home_page() {
        Driver.get().get("url");
    }
    @Then("The user should validate the correct page")
    public void the_user_should_validate_the_correct_page() {
        Assert.assertTrue(careerPage.logo.isDisplayed());
    }
    @Given("The user should go to the {string} page")
    public void the_user_should_go_to_the_page(String module) {
        careerPage.goToTheModule(module);
    }
    @When("The user should go to the new tab")
    public void the_user_should_go_to_the_new_tab() {
        BrowserUtils.changeWindowTab();
    }
    @When("The user should click the {string} text")
    public void the_user_should_click_the_text(String job) {
        careerPage.goToTheJob(job);
    }
    @When("The user should click the apply for this job button")
    public void the_user_should_click_the_apply_for_this_job_button() {
        careerPage.applyForThisJob.click();
    }
    @When("The user should add resume")
    public void the_user_should_add_resume() {
        careerPage.addResume();
    }
    @When("The user should {string},{string}, {string},{string},{string},{string},{string},{string}")
    public void the_user_should(String linkedin, String fullname, String email, String phone, String company, String coverletter, String experienceYear, String englishLevel) {
        careerPage.fillTheApplicationRequirements(linkedin, fullname, email, phone, company, coverletter, experienceYear, englishLevel);
    }
    @When("The user should select the privacy notive")
    public void the_user_should_select_the_privacy_notive() {
        careerPage.privacyNotive.click();
    }
    @When("The user should submit application")
    public void the_user_should_submit_application() {
        careerPage.submitBtn.click();
    }
    @Then("The user should see {string} validate message")
    public void the_user_should_see_validate_message(String message) {

    }


}
