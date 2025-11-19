package TestCases;

import ProjectObjectModel.Base_Page_Object;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Base {

    WebDriver ram = new ChromeDriver();

    @BeforeTest
    public void Setup(){
        System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver.exe");
        ram.manage().window().maximize();
        ram.get("https://www.automationexercise.com/");
    }

    @Test
    public void FirstTest(){

       //Signup / Login
       ram.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();

       //New User Signup!
       ram.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("Neymar Junior");
       ram.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("neymar10@gmail.com");
       ram.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();

       //Enter Account Information
       ram.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
       ram.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("neymar123");
       ram.findElement(By.xpath("//*[@id=\"days\"]")).sendKeys("10");
       ram.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys("July");
       ram.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys("1990");

       //Address Information
       ram.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Neymar");
       ram.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Junior");
       ram.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("Santos");
       ram.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("Butwal");
       ram.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Lumbini");
       ram.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Butwal");
       ram.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("123456");
       ram.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys("9810101010");
       ram.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();

    }

    @Test
    public void Register_User(){
        //Taste Case 1: Register User

        Base_Page_Object basepage = new Base_Page_Object(ram);

        basepage.verify_homepage();
        basepage.click_on_header();
        basepage.verify_SignUp();
        basepage.enter_name("Neymar");
        basepage.enter_email("neymar29@gmail.com");
        basepage.click_on_signup();

        basepage.verify_account_information();
        basepage.select_gender();
        basepage.enter_password("neymar123");
        basepage.enter_day("10");
        basepage.enter_month("July");
        basepage.enter_year("1990");
        basepage.click_newsletter();
        basepage.click_option();

        basepage.enter_first_name("Neymar");
        basepage.enter_last_name("Junior");
        basepage.enter_company("Santos");
        basepage.enter_address("Butwal");
        basepage.enter_country("India");
        basepage.enter_state("Butwal");
        basepage.enter_city("Butwal");
        basepage.enter_zipcode("12345");
        basepage.enter_mobile_number("9811111111");
        basepage.click_on_create_account();
        basepage.verify_account_created();
        basepage.click_on_continue();
        basepage.verify_logged_in_as_username();

        /*basepage.click_on_delete_account();
        basepage.verify_account_deleted();
        basepage.click_on_continue_delete();
         */
    }

    @Test
    public void Login_User_with_correct_email_and_password(){
        //Test Case 2: Login User with correct email and password

        Base_Page_Object basepage = new Base_Page_Object(ram);

        basepage.verify_homepage();
        basepage.click_on_login();
        basepage.verify_login_to_your_account();
        basepage.enter_user_email("neymar20@gmail.com");
        basepage.enter_correct_password("neymar123");
        basepage.click_on_login_button();
        basepage.verify_logged_in_as_username();

        /*basepage.click_on_delete_account();
        basepage.verify_account_deleted();
        basepage.click_on_continue_delete();
        */
    }

    @Test
    public void Login_User_with_incorrect_email_and_password(){
        //Test Case 3: Login User with incorrect email and password

        Base_Page_Object basepage = new Base_Page_Object(ram);

        basepage.verify_homepage();
        basepage.click_on_login();
        basepage.verify_login_to_your_account();
        basepage.enter_incorrect_email("neymar1234@gmail.com");
        basepage.enter_incorrect_password("ram123");
        basepage.click_on_login_button();
        basepage.verify_incorrect_email_password();
    }

    @Test
    public void Logout_User(){
        //Test Case 4: Logout User

        Base_Page_Object basepage = new Base_Page_Object(ram);

        basepage.verify_homepage();
        basepage.click_on_login();
        basepage.verify_login_to_your_account();
        basepage.enter_user_email("neymar20@gmail.com");
        basepage.enter_correct_password("neymar123");
        basepage.click_on_login_button();
        basepage.verify_logged_in_as_username();
        basepage.click_on_logout();
        basepage.verify_login_to_your_account();
    }

    @Test
    public void Register_User_with_existing_email(){
        //Test Case 5: Register User with existing email

        Base_Page_Object basepage = new Base_Page_Object(ram);

        basepage.verify_homepage();
        basepage.click_on_header();
        basepage.verify_SignUp();
        basepage.enter_name("Neymar");
        basepage.enter_email("neymar11@gmail.com");
        basepage.click_on_signup();
        basepage.verify_email_exist();
    }

    @Test
    public void Contact_Us_Form(){
        //Test Case 6: Contact Us Form

        Base_Page_Object basepage = new Base_Page_Object(ram);

        basepage.verify_homepage();
        basepage.click_on_contact_us();
        basepage.verify_get_in_touch();
        basepage.input_name("Neymar");
        basepage.input_email("neymar11@gmail.com");
        basepage.enter_subject("About Product");
        basepage.enter_your_message("Product was good.");
        basepage.click_on_submit_button();
        basepage.alert();
        basepage.verify_success_message();
        basepage.click_on_home_button();
        basepage.verify_landed_to_home_page_successfully();
    }

    @Test
    public void  Verify_Test_Cases_Page(){
        //Test Case 7: Verify Test Cases Page

        Base_Page_Object basepage = new Base_Page_Object(ram);

       basepage.verify_homepage();
       basepage.click_on_taste_cases();
       basepage.verify_test_cases_page();
    }

    @Test
    public void  Verify_All_Products_and_product_detail_page(){
        //Test Case 8: Verify All Products and product detail page

        Base_Page_Object basepage = new Base_Page_Object(ram);

        basepage.verify_homepage();



        //Verify user is navigated to ALL PRODUCTS page successfully
        /* Click on 'Products' button
        ram.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
        String ActualProductPage = ram.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2")).getText();
        String ExpectedProductPage = "ALL PRODUCTS";
        //Assertion
        Assert.assertEquals(ActualProductPage,ExpectedProductPage);

        //Verify that detail detail is visible: product name, category, price, availability, condition, brand


*/
    }


    @AfterTest
    public void CloseBrowser(){
       // ram.close();
}


}
