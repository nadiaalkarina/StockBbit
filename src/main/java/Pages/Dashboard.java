package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {
        WebDriver driver;

        //Constructor that will be automatically called as soon as the object of the class is created
        public Dashboard(WebDriver driver) {
            this.driver=driver;
        }

        //Method generate to login page
        public void ToLoginPage(){
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-ldn"))).click();
        }

        //Method wait profile
        public void AssertLoginSuccess(){
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("popavatar"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-popover-title")));
        }

}
