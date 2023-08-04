Feature: Apply for a job

  Background:
    Given The user should go to the home page
    Then The user should validate the correct page
@apply
    Scenario: Apply feature
      Given The user should go to the "CAREERS" page
      When The user should go to the new tab
      And The user should click the "Test Engineer" text
      And The user should click the apply for this job button
      And The user should add resume
      And The user should add "https://github.com/seymacamdalkiran/triple_id_Apply", "3" on the cover letter
      And The user should select the privacy notive
      And The user should submit application
      Then The user should see "Application submitted" validate message