package TestCases;


import ProjectObjectModel.Automation_Test_Store_Object;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class Automation_Test_Store_Base {

    WebDriver webDriver = new ChromeDriver();

    @BeforeTest
    public void Setup(){
        System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver.exe");
        webDriver.manage().window().maximize();
        webDriver.get("https://automationteststore.com/");
    }

    @Test
    public void Register_user(){
        //Test Case 1: Register User

       Automation_Test_Store_Object basepage = new Automation_Test_Store_Object(webDriver);


       basepage.verify_homepage();
       basepage.click_on_header();
       basepage.verify_account_login();
       basepage.verify_Register();
       basepage.click_on_continue();
       basepage.verify_create_account();
       basepage.enter_first_name("Hari");
       basepage.enter_last_name("Hamal");
       basepage.enter_email("hari1@gmail.com");
       basepage.enter_telephone("9812345678");

       basepage.enter_company("Apple");
       basepage.enter_address("Butwal");
       basepage.enter_city("Butwal");
       basepage.enter_state("Lumbini");
       basepage.enter_zipcode("123456");
       basepage.enter_country("Nepal");

       basepage.enter_login_name("HariHamal");
       basepage.enter_password("hari123");
       basepage.enter_confirm_password("hari123");
       basepage.select_subscribe();
       basepage.select_privacy_policy();
       basepage.click_continue();
    }

    @Test
    public void Login_user_with_correct_login_name_and_password(){
        //Test Case 2 : Login user with correct login name and password

        Automation_Test_Store_Object basepage = new Automation_Test_Store_Object(webDriver);

        basepage.verify_homepage();
        basepage.click_on_header();
        basepage.verify_account_login();
        basepage.verify_returning_customer();
        basepage.enter_correct_loginname("RamThapa");
        basepage.enter_correct_password("ramthapa123");
        basepage.click_on_login();
    }

    @Test
    public void Welcome_back_username(){
        //Test Case 3 : Verify Welcome back username

        Automation_Test_Store_Object basepage = new Automation_Test_Store_Object(webDriver);

        basepage.verify_homepage();
        basepage.click_on_header();
        basepage.verify_account_login();
        basepage.verify_returning_customer();
        basepage.enter_correct_loginname("RamThapa");
        basepage.enter_correct_password("ramthapa123");
        basepage.click_on_login();
        basepage.verify_welcomeback();


    }

    @Test
    public void Login_user_with_incorrect_login_name_and_password(){
        //Test Case 4 : Login user with incorrect login name and password

        Automation_Test_Store_Object basepage = new Automation_Test_Store_Object(webDriver);

        basepage.verify_homepage();
        basepage.click_on_header();
        basepage.verify_account_login();
        basepage.verify_returning_customer();
        basepage.enter_incorrect_loginname("ramThapa");
        basepage.enter_incorrect_password("RAMTHAPA123");
        basepage.click_on_login();
    }

    @Test
    public void Logout_user(){
        //Test Case 5: Logout User

        Automation_Test_Store_Object basepage = new Automation_Test_Store_Object(webDriver);

        basepage.verify_homepage();
        basepage.click_on_header();
        basepage.verify_account_login();
        basepage.verify_returning_customer();
        basepage.enter_correct_loginname("RamThapa");
        basepage.enter_correct_password("ramthapa123");
        basepage.click_on_login();
        basepage.verify_my_account();
        basepage.click_on_logout();
        basepage.verify_account_logout();
        basepage.click_logout_continue();

    }

    @Test
    public void Register_user_with_existing_email(){

        //Test Case 6: Register User with existing email

        Automation_Test_Store_Object basepage = new Automation_Test_Store_Object(webDriver);
        basepage.verify_homepage();
        basepage.click_on_header();
        basepage.verify_account_login();
        basepage.verify_Register();
        basepage.click_on_continue();
        basepage.verify_create_account();
        basepage.enter_first_name("Ram");
        basepage.enter_last_name("Hamal");
        basepage.enter_email("ram22@gmail.com");
        basepage.enter_telephone("9812345678");

        basepage.enter_company("Apple");
        basepage.enter_address("Butwal");
        basepage.enter_city("Butwal");
        basepage.enter_state("Lumbini");
        basepage.enter_zipcode("123456");
        basepage.enter_country("Nepal");

        basepage.enter_login_name("RamHamal");
        basepage.enter_password("ramhamal123");
        basepage.enter_confirm_password("ramhamal123");
        basepage.select_subscribe();
        basepage.select_privacy_policy();
        basepage.click_continue();

        basepage.verify_email_exist();
    }

    @Test
    public void Add_products_in_cart(){

        //Test Case 7: Add Products in Cart

        Automation_Test_Store_Object basepage = new Automation_Test_Store_Object(webDriver);

        basepage.verify_homepage();
        basepage.click_on_header();
        basepage.verify_account_login();
        basepage.verify_returning_customer();
        basepage.enter_correct_loginname("RamThapa");
        basepage.enter_correct_password("ramthapa123");
        basepage.click_on_login();

        basepage.click_on_specials();
        basepage.click_on_list();
        basepage.click_on_view();
        basepage.click_on_add_to_cart();
        basepage.click_on_continue_shopping();
    }

    @Test
    public void Remove_product_from_cart(){

        //Test Case 8: Remove Products From Cart

        Automation_Test_Store_Object basepage = new Automation_Test_Store_Object(webDriver);


        basepage.verify_homepage();
        basepage.click_on_header();
        basepage.verify_account_login();
        basepage.verify_returning_customer();
        basepage.enter_correct_loginname("RamThapa");
        basepage.enter_correct_password("ramthapa123");
        basepage.click_on_login();

        basepage.click_on_specials();
        basepage.click_on_list();
        basepage.click_on_view();
        basepage.click_on_add_to_cart();
        basepage.click_on_continue_shopping();

        basepage.click_on_cart();
        basepage.verify_shopping_cart();
        basepage.click_on_delete_button();
        basepage.verify_shopping_cart();
        basepage.click_on_continue_button();
    }

    @Test
    public void Place_order() {

        //Test Case 9: Place order: Login before Checkout

        Automation_Test_Store_Object basepage = new Automation_Test_Store_Object(webDriver);

        basepage.verify_homepage();
        basepage.click_on_header();
        basepage.verify_account_login();
        basepage.verify_returning_customer();
        basepage.enter_correct_loginname("RamThapa");
        basepage.enter_correct_password("ramthapa123");
        basepage.click_on_login();

        basepage.click_on_specials();
        basepage.click_on_list();
        basepage.click_on_view();
        basepage.click_on_add_to_cart();
        basepage.click_on_continue_shopping();

        basepage.click_on_checkout();
        basepage.verify_checkout_confirmation();
        basepage.click_on_confirm_order();
        basepage.click_continue_button();
    }

    @Test
    public void Contact_Us_Form(){

        //Test Case 10: Contact us form

        Automation_Test_Store_Object basepage = new Automation_Test_Store_Object(webDriver);

        basepage.verify_homepage();
        basepage.click_contact_us();
        basepage.verify_contact_us();
        basepage.enter_fname("Ram");
        basepage.enter_email_address("ram17@gmail.com");
        basepage.enter_enquiry("About product brand");
        basepage.click_submit_button();
        basepage.click_continue_contact_us();
    }
    


   /* @AfterTest
    public void CloseBrowser(){
        webDriver.close();
    }*/
}
