package Bojan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends Base {
    public Login(WebDriver webDriver) {
        super(webDriver);
    }

    public void start() {
        webDriver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
    }

    public boolean Loaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).isDisplayed();
    }

    public void Login(String user, String password) throws InterruptedException {
        webDriver.findElement(By.id("username")).clear();
        webDriver.findElement(By.id("username")).sendKeys(user);
        Thread.sleep(5000);
        webDriver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(5000);
        webDriver.findElement(By.className("btn__primary--large")).click();
        Thread.sleep(5000);
    }

    public String PassError() {
        WebElement errorPage = webDriver.findElement(By.id("error-for-password"));
        return errorPage.getText();
    }
    public String UserError() {
        WebElement errorPage = webDriver.findElement(By.id("error-for-username"));
        return errorPage.getText();
    }

    public String LoginComplete() throws InterruptedException {
        Thread.sleep(5000);
       // var url=new String("https://www.linkedin.com/feed/?trk=guest_homepage-basic_nav-header-signin");
        System.out.println(webDriver.getCurrentUrl());
        return webDriver.getCurrentUrl();

    }
}
