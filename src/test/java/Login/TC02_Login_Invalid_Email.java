package Login;

import Pages.Dashboard;
import Pages.login;
import Pages.web_link;
import config.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class TC02_Login_Invalid_Email {
    public WebDriver driver;
    public TC02_Login_Invalid_Email(){
        driver = Hooks.driver;
    }

    @Given("^user access website link$")
    public void user_access_website_link() throws Throwable {
        System.out.println("Call Website");
        web_link Web_link = new web_link(driver);
        Web_link.CallWebLink();
    }

    @When("^user login using invalid email and valid password$")
    public void user_login_using_invalid_email_and_valid_password() throws Throwable {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.ToLoginPage();

        login Login = new login(driver);
        Login.FillUsername("lowfast@gmail.com");
        Login.FillPassword("lowfastlowfast");
        Login.ClickLogin();
    }

    @Then("^page show alert cant login$")
    public void page_show_alert_cant_login() throws Throwable {
        login Login = new login(driver);
        Login.AssertWrongEmailPassword();

        Thread.sleep(3000);
        driver.quit();
    }
}
