package Login;

import Pages.Dashboard;
import Pages.login;
import Pages.web_link;
import config.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class TC03_Login_Invalid_Password {
    public WebDriver driver;
    public TC03_Login_Invalid_Password(){
        driver = Hooks.driver;
    }

    @Given("^user access website stockbit$")
    public void user_access_website_stockbit(){
        System.out.println("Call Website");
        web_link Web_link = new web_link(driver);
        Web_link.CallWebLink();
    }

    @When("^user login using valid email and invalid password$")
    public void user_login_using_valid_email_and_invalid_password(){
        Dashboard dashboard = new Dashboard(driver);
        dashboard.ToLoginPage();

        login Login = new login(driver);
        Login.FillUsername("lowfast.lowfast@gmail.com");
        Login.FillPassword("lowfastl");
        Login.ClickLogin();
    }

    @Then("^page show alert user cant login$")
    public void page_show_alert_user_cant_login() throws Throwable {
        login Login = new login(driver);
        Login.AssertWrongEmailPassword();

        Thread.sleep(3000);
        driver.quit();
    }
}
