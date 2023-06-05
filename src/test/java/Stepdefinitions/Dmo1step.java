package Stepdefinitions;

import POMclasses.Demo1pom;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Dmo1step {
    public WebDriver driver;
    public Demo1pom pom;
    public Properties prop;
    public WebDriverWait wait;
    @Given("open the browser and enter the url{string}")
    public void open_the_browser_and_enter_the_url(String url) throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ch = new ChromeOptions();
        ch.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ch);
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        pom = new Demo1pom(driver);
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/propertiesfiles/config.properties");
        prop.load(fis);
    }
    @When("user click on my account and click on register")
    public void user_click_on_my_account_and_click_on_register() {
        wait.until(ExpectedConditions.visibilityOf(pom.myaccount)).click();
        pom.actions();
    }
    @When("enter the valid data for all the fields")
    public void enter_the_valid_data_for_all_the_fields() {
        wait.until(ExpectedConditions.visibilityOf(pom.fname));
        pom.fname.sendKeys(prop.getProperty("fname"));
        pom.lname.sendKeys(prop.getProperty("lname"));
        pom.email.sendKeys(prop.getProperty("email"));
        pom.phonenumber.sendKeys(prop.getProperty("phnum"));
        pom.password.sendKeys(prop.getProperty("password"));
        pom.confpassword.sendKeys(prop.getProperty("conpassword"));
    }
    @When("click on subscribe checkbox and select privacy-policy checkbox and continue")
    public void click_on_subscribe_checkbox_and_select_privacy_policy_checkbox_and_continue() {
        pom.yescheckbox.click();
        pom.privacycheckbox.click();
        pom.cont.click();
    }
    @Then("check account is created")
    public void check_account_is_created() {
        Assert.assertEquals("Your Account Has Been Created!",pom.text.getText());
        driver.quit();
    }
    @Then("check the error msg is displayed")
    public void check_the_error_msg_is_displayed() {
        pom.error();
        driver.quit();
    }
    @When("user click on my account and click on login")
    public void user_click_on_my_account_and_click_on_login() {
        pom.myaccount.click();
        pom.Login_1.click();
    }
    @When("^enter the email address (.*) and password (.*)$")
    public void enter_the_email_address_deekshigowda_gmail_com_and_password_deekshi(String e,String p) {
        wait.until(ExpectedConditions.visibilityOf(pom.email_1));
        pom.login(e,p);
    }
    @Then("Title should be {string}")
    public void title_should_be(String title) {
       Assert.assertEquals(title,driver.getTitle());
       driver.quit();
    }
    @Then("error msg should be display {string}")
    public void error_msg_should_be_display(String error) {
        Assert.assertEquals(error,pom.un_pwd_error.getText());
        driver.quit();
    }
    @When("user click on tablets")
    public void user_click_on_tablets() {
        pom.tablets.click();
    }
    @When("add item into cart")
    public void add_item_into_cart() {
        pom.add_to_cart.click();
        pom.cartbutton.click();
        wait.until(ExpectedConditions.visibilityOf(pom.checkout)).click();
    }
    @Then("check the item in the cart")
    public void check_the_item_in_the_cart() {
        pom.validate();
    }
}