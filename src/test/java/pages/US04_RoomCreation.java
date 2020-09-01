package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US04_RoomCreation {

    public US04_RoomCreation(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "(//span[@class='title'])[1]")
    public WebElement systemManagement;

    @FindBy(xpath = "//div[@class='page-content-wrapper']")
    public WebElement sideBar;

    @FindBy(id = "menuHotels")
    public WebElement hotelManagementLink;

    @FindBy(partialLinkText = "Hotel Rooms")
    //@FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoomsLink;

    //@FindBy(xpath = "//span[@class='hidden-480']")
    @FindBy(xpath = "//span[text()='Add Hotelroom ']")
    public WebElement addHotelRoomButton;

    @FindBy(className ="//a[@href='#']" )
    public WebElement listOfHoptelrooms;

    @FindBy(id = "IDHotel")
    public WebElement IDHotel;

    @FindBy(id = "Code")
    public WebElement codeBox;

    @FindBy(id = "Name")
    public WebElement nameBox;

    @FindBy(id = "Location")
    public WebElement locationBox;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement descriptionArea;


    @FindBy(id = "IDGroupRoomType")
    public WebElement roomType;

    @FindBy(id = "MaxAdultCount")
    public WebElement maxAdultCount;

    @FindBy(id = "MaxChildCount")
    public WebElement maxChildCount;

    @FindBy(id = "IsAvailable")
    public WebElement approved;

    @FindBy(id = "btnSubmit")
    public WebElement saveButton;

    @FindBy(className = "bootbox-body")
    //@FindBy(xpath = "//div[text()='HotelRoom was inserted successfully']")
    public  WebElement textMessage;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement okButton;

    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement hotelRoomListText;



    @FindBy(xpath ="(//input[@class='form-control form-filter input-sm'])[1]")
    public  WebElement idBox;

    @FindBy(id = "lkpHotels")
    public WebElement idHotelSelect;


    @FindBy(xpath ="(//input[@class='form-control form-filter input-sm'])[2]")
    public  WebElement codeBox2;

    @FindBy(xpath ="(//input[@class='form-control form-filter input-sm'])[3]")
    public  WebElement nameBox2;

    @FindBy(xpath ="(//input[@class='form-control form-filter input-sm'])[4]")
    public  WebElement locationBox2;

    @FindBy(xpath ="(//input[@class='form-control form-filter input-sm'])[5]")
    public  WebElement priceBox;

    @FindBy(id = "lkpGroupRoomTypes")
    public WebElement idGroupRoomType;

    @FindBy(xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
    public WebElement search;
}
