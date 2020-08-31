package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US03_HotelCreation {

    public US03_HotelCreation(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "menuHotels")
    public WebElement hotelManagementButton;

    @FindBy(linkText = "Hotel List")
    public WebElement hotelList;

    @FindBy(xpath = "//span[text()='List Of Hotels']")
    public WebElement listOfHotel;

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotelButton;

    @FindBy(id = "Code")
    public WebElement code;

    @FindBy(id = "Name")
    public WebElement name;

    @FindBy(id = "Address")
    public WebElement address;

    @FindBy(id = "Phone")
    public WebElement phone;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(xpath = "//label[@for='Email']")
    public WebElement errorEmail;

    @FindBy(id = "IDGroup")
    public WebElement idGroup;

    @FindBy(id = "btnSubmit")
    public WebElement saveButton;

    @FindBy(xpath = "//div[text()='Hotel was inserted successfully']")
    public WebElement saveSuccess;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement confirmOk;

    @FindBy(name = "Code")
    public WebElement codeBox;

    @FindBy(name = "Name")
    public WebElement nameBox;

    @FindBy(name = "Address")
    public WebElement addressBox;

    @FindBy(name = "Phone")
    public WebElement phoneBox;

    @FindBy(name = "Email")
    public WebElement emailBox;

    @FindBy(name = "lkpGroups")
    public WebElement idGroupBox;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//td[text()='222']")
    public WebElement codeCheck;

}
