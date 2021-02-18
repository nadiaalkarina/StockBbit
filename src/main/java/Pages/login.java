package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Driver;
import java.util.Iterator;
import java.util.Set;

public class login {
    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public login(WebDriver driver) {
        this.driver=driver;
    }

    //Method for fill username
    public void FillUsername(String UN){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(UN);
    }

    //Method for fill password
    public void FillPassword(String Pass){
        driver.findElement(By.id("password")).sendKeys(Pass);
    }

    //Method for click login button
    public void ClickLogin(){
        driver.findElement(By.id("loginbutton")).click();
    }

    //Method assert wrong email or password
    public void AssertWrongEmailPassword(){
        driver.getPageSource().contains("Username atau password salah. Mohon coba lagi.");
    }

    //Method click email for login
    public void AutoEmail(){
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app-react']/div[@id='main-wrapper']/div[4]/div[1]/div[3]/div[1]/form[1]/div[1]/input[1]"))).click();
//        Set<String> handles =driver.getWindowHandles();
//        Iterator<String> it = handles.iterator();
//        String child = it.next();
//        driver.switchTo().window(child);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'lowfast.lowfast@gmail.com')]"))).click();
    }

}
