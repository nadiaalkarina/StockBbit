package Login;

import Pages.Dashboard;
import Pages.login;
import Pages.web_link;
import config.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class TC04_Login_Auto_Registered_Email {
    public WebDriver driver;
    public TC04_Login_Auto_Registered_Email()
    {
        driver = Hooks.driver;
    }

    @Given("^user access website TC04$")
    public void user_access_website_TC04() {
        System.out.println("Call Website");
        web_link Web_link = new web_link(driver);
        Web_link.CallWebLink();
    }


    @When("^user login using automatic click registered email$")
    public void user_login_using_automatic_click_registered_email(){
        Dashboard dashboard = new Dashboard(driver);
        dashboard.ToLoginPage();

        login Login = new login(driver);
        Login.AutoEmail();
    }

    @Then("^user can login$")
    public void user_can_login() throws Throwable {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.AssertLoginSuccess();

        Thread.sleep(3000);
        driver.quit();
    }
}
