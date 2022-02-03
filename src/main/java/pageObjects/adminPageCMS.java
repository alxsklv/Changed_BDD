package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class adminPageCMS {
    public WebDriver driver;

    By cmsMenu = By.cssSelector("#drawerAccordion > div.drawer-menu > div > a:nth-child(12");
    By pagesSubmenu = By.cssSelector("#collapseCMS > nav > a:nth-child(1)");

    public adminPageCMS(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement cmsMenu() {
        return this.driver.findElement(cmsMenu);
    }

    public WebElement pagesSubmenu() {
        return this.driver.findElement(pagesSubmenu);
    }
}
