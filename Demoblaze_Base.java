package TestCases;



import ProjectObjectModel.Demoblaze_Object;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Demoblaze_Base {

    WebDriver webDriver = new ChromeDriver();

    @BeforeTest
    public void Setup(){
        System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver.exe");
        webDriver.manage().window().maximize();
        webDriver.get("https://demoblaze.com/index.html");
    }

    @Test
    public void Signup(){
        //Test Case 1: Signup User

        Demoblaze_Object basepage = new Demoblaze_Object(webDriver);


        basepage.verify_homepage();
        basepage.verify_signup();
        basepage.click_on_signup();
        basepage.enter_signup_username("Ram");
        basepage.enter_signup_password("ram123");
        basepage.click_on_signup_button();








    }
}
