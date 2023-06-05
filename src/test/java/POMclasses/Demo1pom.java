package POMclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demo1pom {
    public  WebDriver driver;
    public Demo1pom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//a[@href='https://tutorialsninja.com/demo/index.php?route=account/account' and @class='dropdown-toggle']")
    public WebElement myaccount;
    @FindBy(xpath="//a[.='Register']")
    public WebElement register;
    @FindBy(css = "#input-firstname")
    public WebElement fname;
    @FindBy(css = "#input-lastname")
    public WebElement lname;
    @FindBy(css = "#input-email")
    public WebElement email;
    @FindBy(css = "#input-telephone")
    public WebElement phonenumber;
    @FindBy(css = "#input-password")
    public WebElement password;
    @FindBy(css = "#input-confirm")
    public WebElement confpassword;
    @FindBy(xpath = "//label[normalize-space()='Yes']")
    public WebElement yescheckbox;
    @FindBy(xpath = "//input[@name='agree']")
    public WebElement privacycheckbox;
    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement cont;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    public WebElement text;
    @FindBy(css = ".alert.alert-danger.alert-dismissible")
    public WebElement mainerror;
public void actions()
{
    Actions actions = new Actions(driver);
    actions.moveToElement(register).click().build().perform();
}
public void error()
{
    int count = driver.findElements(By.cssSelector(".text-danger")).size();
    for (int i=0;i<count;i++)
    {
        String error = driver.findElements(By.cssSelector(".text-danger")).get(i).getText();
        System.out.println(error);
    }
}
    @FindBy(xpath = "//a[.='Login']")
    public WebElement Login_1;
    @FindBy(css = "#input-email")
    public WebElement email_1;
    @FindBy(css = "#input-password")
    public WebElement password_1;
    @FindBy(xpath = "//input[@value='Login']")
    public WebElement Login_2;
    public void login(String email,String password)
    {
        email_1.sendKeys(email);
        password_1.sendKeys(password);
        Login_2.click();
    }
    @FindBy(css = ".alert.alert-danger.alert-dismissible")
    public WebElement un_pwd_error;
    @FindBy(xpath = "//a[.='Tablets']")
    public WebElement tablets;
    @FindBy(xpath = "//span[.='Add to Cart']")
    public WebElement add_to_cart;
    @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    public WebElement cartbutton;
    @FindBy(xpath = "//strong[normalize-space()='Checkout']")
    public WebElement checkout;

    public void validate()
    {
        String src = driver.findElement(By.xpath("(//img[@title='Samsung Galaxy Tab 10.1'])[2]")).getAttribute("src");
        if (src.equals("https://tutorialsninja.com/demo/image/cache/catalog/demo/samsung_tab_1-47x47.jpg"))
        {
            System.out.println("test pass");
        }
        else
        {
            System.out.println("test fail");
        }
    }
}
