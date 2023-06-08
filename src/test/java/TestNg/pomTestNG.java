package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class pomTestNG  {
    public WebDriver driver;
    public Properties prop;
    public WebDriverWait wait;

    public pomTestNG(WebDriver driver, WebDriverWait wait) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/propertiesfiles/config.properties");
        prop.load(fis);
        this.wait=wait;
    }
    @FindBy(xpath="//a[.='Desktops']")
    public WebElement desktops;
    @FindBy(xpath="//a[.='Show AllDesktops']")
    public WebElement alldesktops;
    @FindBy(css=".button-group>button:nth-child(2)")
    public WebElement wishlist;
    @FindBy(css="#top-links>ul>li:nth-child(3)")
    public WebElement wishlistcart;
    @FindBy(css = "#input-email")
    public WebElement email_1;
    @FindBy(css = "#input-password")
    public WebElement password_1;
    @FindBy(xpath = "//input[@value='Login']")
    public WebElement Login_2;
    public void validate() throws InterruptedException {
        int count = driver.findElements(By.cssSelector(".caption>h4>a")).size();
        System.out.println(count);
        for (int i=0;i<count;i++)
        {
            String product = driver.findElements(By.cssSelector(".caption>h4>a")).get(i).getText();
            if (product.equals("Canon EOS 5D"))
            {
                 String myproduct = driver.findElements(By.cssSelector(".caption>h4>a")).get(i).getText();
                wishlist.click();
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOf(wishlistcart)).click();
        email_1.sendKeys(prop.getProperty("email"));
        password_1.sendKeys(prop.getProperty("password"));
        Login_2.click();
        int wcount = driver.findElements(By.xpath("(//tbody//tr//td[2]//a)")).size();
        for (int j=1 ;j<=wcount;j++)
        {
            String myproduct2 = driver.findElement(By.xpath("(//tbody//tr//td[2]//a)[" + j + "]")).getText();
            if (myproduct2.equals("Canon EOS 5D"))
            {
                System.out.println("testcase pass");
                break;
            }
            else
            {
                System.out.println("testcase fail");
            }
        }
    }
}