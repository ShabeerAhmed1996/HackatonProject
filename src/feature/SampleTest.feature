  @Test
  Feature: Test the URL using OWASP ZAP and selenium

    Scenario: Verify whether the URL is have any security flaws
      Given Launch the google-gruyere application in firefox browser
      When Login to the application using valid username and password
      And Verify whether user is successfully logged in to the application
      And User is adding new snippet in the application