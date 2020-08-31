package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US06_UserListCreation {
    public US06_UserListCreation(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement userlist;
    @FindBy(xpath = "//span[@class='title']")
    public WebElement managementTitle;
    @FindBy(xpath = "//a[@href='/admin/UserAdmin']")
    public WebElement userListButton;
    @FindBy(xpath = "//i[@class='fa fa-plus']")
    public WebElement addUserButton;
    @FindBy(id = "UserName")
    public WebElement userName;
    @FindBy(id = "txtPassword")
    public WebElement password;
    @FindBy(id = "Email")
    public WebElement email;
    @FindBy(id = "NameSurname")
    public WebElement fullName;
    @FindBy(id = "PhoneNo")
    public WebElement phone;
    @FindBy(id = "SSN")
    public WebElement ssn;
    @FindBy(id = "DrivingLicense")
    public WebElement driverLicense;
    @FindBy(id = "IDCountry")
    public WebElement country;
    @FindBy(id = "IDState")
    public WebElement state;
    @FindBy(id = "Address")
    public WebElement address;
    @FindBy(id = "BirthDate")
    public WebElement birthdate;
    @FindBy(id = "WorkingSector")
    public WebElement workingSector;
    @FindBy(id = "IDRole")
    public WebElement role;
    @FindBy(id = "Approved")
    public WebElement yesButton;
    @FindBy(id = "btnSubmit")
    public WebElement saveButton;
    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement successMessage;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement okButton;
    @FindBy(xpath = "(//input[@class='form-control form-filter input-sm'])[3]")
    public WebElement mailsearch;
    @FindBy(xpath = "//div[@class=\"alert alert-danger display-hide\"]")
    public WebElement failMessage;

    @FindBy(xpath = "//input[@name='Email']")
    public WebElement searchEmail;
    @FindBy(xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement searchButton;

    @FindBy(xpath = "//td[@class='sorting_1']")
    public WebElement searchName;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement okMessage;




}
