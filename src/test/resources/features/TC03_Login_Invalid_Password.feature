Feature: Login
  Scenario: TC03_Login_Invalid_Password
    Given user access website stockbit
    When user login using valid email and invalid password
    Then page show alert user cant login