import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Bojan.Login;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
public class LoginTest181115 {
    private WebDriver webDriver;


    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "E:\\Bojan\\Materijali za na fakultet\\Shesti Semestar\\Softverski kvalitet i testiranje\\Laboratoriski\\Lab3\\Lab3_181115\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
        return new ChromeDriver();
    }

    @BeforeTest
    public void start(){
        webDriver = getDriver();
    }

    @Test
    public void shouldOpen() throws InterruptedException {
        Login PageLogin = new Login(webDriver);
        PageLogin.start();
        assertTrue(PageLogin.Loaded());
    }
   // Test 1
    @Test
    public void InvalidUserLogin() throws InterruptedException {
        Login PageLogin = new Login(webDriver);
        PageLogin.start();
        assertTrue(PageLogin.Loaded());
        PageLogin.Login("Proba", "testPassword");
        String errorMessage = PageLogin.UserError();
        assertEquals(errorMessage, "Please enter a valid username");
        System.out.println(errorMessage);
    }

    @Test
    public void InvalidPassLogin() throws InterruptedException {
        Login PageLogin = new Login(webDriver);
        PageLogin.start();
        assertTrue(PageLogin.Loaded());
        PageLogin.Login("Jj8536721@gmail.com", "GresenPassword");
        String errorMessage = PageLogin.PassError();

        System.out.println(errorMessage);
        // Poradi toa shto poraka koja shto ja ispraka LinkedIn e razlicno vo zavisnost od toa kolku pati kje se obides
        // da vnese password implementirav da se proveruvaat dvete poraki i da bide ili ednoto ili drugoto
        assertTrue(errorMessage.equals("That’s not the right password. Forgot password?")||
                errorMessage.equals("That's not the right password. Try again or\n" + "sign in with a one-time link"));
        //assertEquals(errorMessage, "That’s not the right password. Forgot password?");
       // assertEquals(errorMessage, "That's not the right password. Try again or\n" + "sign in with a one-time link");

    }
    // Test 2
    @Test
    public void EmptyUserLogin() throws InterruptedException {
        Login PageLogin = new Login(webDriver);
        PageLogin.start();
        assertTrue(PageLogin.Loaded());
        PageLogin.Login("", "testPassword");
        String errorMessage = PageLogin.UserError();
        assertEquals(errorMessage, "Please enter an email address or phone number");
        System.out.println(errorMessage);
    }
   // Test 3
    @Test
    public void RedirectToProfile() throws  InterruptedException{
        Login PageLogin = new Login(webDriver);
        PageLogin.start();
        assertTrue(PageLogin.Loaded());
        PageLogin.Login("Jj8536721@gmail.com", "testPassword");
        assertEquals(PageLogin.LoginComplete(),"https://www.linkedin.com/feed/?trk=guest_homepage-basic_nav-header-signin");
    }


    @AfterTest
    public void kraj() {
        webDriver.quit();
    }
}
