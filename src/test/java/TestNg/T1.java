package TestNg;

import com.relevantcodes.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class T1 {
    public ExtentReports reports;
    public WebDriver driver;
    public Properties prop;
    public pomTestNG pom;
    public WebDriverWait wait;
    @BeforeClass
    public void reports() throws IOException {
        reports=new ExtentReports("reports/yourstore.html");
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/propertiesfiles/config.properties");
        prop.load(fis);
    }
    @BeforeMethod
    public void Test_setup()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ch = new ChromeOptions();
        ch.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ch);
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        pom = new pomTestNG(driver);
         wait = new WebDriverWait(driver, Duration.ofMinutes(2));
    }
    @Test(enabled = false)
    void generating_src_of_brands()
    {
        int count = driver.findElements(By.cssSelector("#carousel0:nth-child(1)>div>div>img")).size();
        for (int i=0 ; i<count;i++)
        {
            String src = driver.findElements(By.cssSelector("#carousel0:nth-child(1)>div>div>img")).get(i).getAttribute("src");
            System.out.println(src);
        }
    }
    @AfterMethod
    public void Test_teardown()
    {
        driver.quit();
    }
    @AfterClass
    public void flush_reports()
    {
        reports.flush();
    }
}
