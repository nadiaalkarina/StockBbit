package Login;

import Pages.Dashboard;
import Pages.login;
import Pages.web_link;
import config.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.rmi.runtime.Log;

public class TC01_Login_Valid {
    public WebDriver driver;
    public TC01_Login_Valid()
    {
        driver = Hooks.driver;
    }

    @Given("^user access website$")
    public void user_access_website() {
        System.out.println("Call Website");
        web_link Web_link = new web_link(driver);
        Web_link.CallWebLink();
    }


    @When("^user login using valid data$")
    public void user_login_using_valid_data() {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.ToLoginPage();

        login Login = new login(driver);
        Login.FillUsername("lowfast.lowfast@gmail.com");
        Login.FillPassword("lowfastlowfast");
        Login.ClickLogin();
    }

    @Then("^user logging in$")
    public void user_logging_in() throws Throwable {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.AssertLoginSuccess();

        Thread.sleep(3000);
        driver.quit();
    }
}
