package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US02_HomePage
{
    public US02_HomePage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "menuYonetim")
    public WebElement systemManagement;

    @FindBy(id = "menuHotels")
    public WebElement hotelManagement;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelList;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRooms;

    @FindBy(partialLinkText = "Room reservations")
    public WebElement roomReservation;

    @FindBy(xpath = "//span[text()='List Of Hotels']")
    public WebElement listOfHotelTitle;

    @FindBy(xpath = "//span[text()='List Of Hotelrooms']")
    public WebElement listOfHotelRoomTitle;

    @FindBy(xpath = "//span[text()='List Of Reservations']")
    public WebElement listOfReservationTitle;


}
