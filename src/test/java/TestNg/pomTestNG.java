package TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomTestNG {
    public WebDriver driver;
    public pomTestNG(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
@FindBy(xpath="(//span[contains(text(),'Add to Cart')])")
    public WebElement addcart;
}