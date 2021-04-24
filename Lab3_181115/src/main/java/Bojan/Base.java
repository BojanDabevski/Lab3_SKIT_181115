package Bojan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    public final WebDriverWait wait;
    protected  WebDriver webDriver;


    public Base(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 5);
    }
}
