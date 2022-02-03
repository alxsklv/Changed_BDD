package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPageCMS {
    public WebDriver driver;

    By loginButtonCMS = By.xpath("//*[@type='submit']");
    By emailCMS = By.xpath("//label[@class='pure-material-textfield-outlined']//*[@name='email']");
    By passwordCMS = By.xpath("//label[@class='pure-material-textfield-outlined']//*[@name='password']");
    By alertMessage = By.xpath("//*[@class='resultlogin']/div");

    public loginPageCMS(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement loginButtonCMS() {
        return this.driver.findElement(loginButtonCMS);
    }

    public WebElement emailInputCMS() {
        return this.driver.findElement(emailCMS);
    }

    public WebElement passwordInputCMS() {
        return this.driver.findElement(passwordCMS);
    }
    
    public WebElement alertMessage() {
        return this.driver.findElement(alertMessage);
    }
}
