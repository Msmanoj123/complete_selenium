package TestNg;

import POMclasses.Demo1pom;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class T2 extends T1 {
    public Demo1pom pom;
    @Test(dataProvider = "data")
    void valid_Login(String ename,String pname)
    {
       pom = new Demo1pom(driver);
       pom.myaccount.click();
       pom.Login_1.click();
       pom.login(ename,pname);
        ExtentTest test = reports.startTest("login testcases");
        if (driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/account"))
        {
            test.log(LogStatus.PASS,test.getDescription()+"test passs");
        }
        else
        {
            test.log(LogStatus.FAIL,test.addBase64ScreenShot("screenshots/Screnshot"+System.currentTimeMillis()+".png"),test.getDescription()+"test fail");
        }
    }
    @DataProvider
    public Object[][] data()
    {
        return new Object[][]{{"deekshigowda@gmail.com","Deekshi"},{"manoj212@gmail.com","Msmanoj@202"},{"dfghj","dfghj"}};
    }
}
