Feature: Apply for a job

  Background:
    Given The user should go to the home page
    Then The user should validate the correct page

    Scenario: Apply feature
      Given The user should go to the "CAREERS" page
      When The user should go to the new tab
      And The user should click the "Test Engineer" text
      And The user should click the apply for this job button
      And The user should add resume
      And The user should "","Seyma Dalkiran", "camdalkiran@gmail.com","05051302666","Seller Flash","","2","Intermediate"
      And The user should select the privacy notive
      And The user should submit application
      Then The user should see "" validate message