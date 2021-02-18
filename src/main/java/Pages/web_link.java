package Pages;

import org.openqa.selenium.WebDriver;

public class web_link {
    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public web_link(WebDriver driver) {
        this.driver=driver;
    }

    //Method for call website link
    public void CallWebLink(){
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://stockbit.com/");
    }
}
