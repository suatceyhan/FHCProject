package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US01_LoginPage  {

    public US01_LoginPage( )
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "UserName")
    public WebElement username;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id ="btnSubmit")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Try again please']")
    public WebElement error_mesaj;
}
