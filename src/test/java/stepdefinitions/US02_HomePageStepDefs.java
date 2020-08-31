package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.US02_HomePage;

public class US02_HomePageStepDefs {

    US02_HomePage us02_homePage = new US02_HomePage();

    @Given("System Management must be accesible")
    public void system_Management_must_be_accesible() {
        Assert.assertTrue(us02_homePage.systemManagement.isDisplayed());
    }

    @And("Hotel Management must be accesible")
    public void hotel_Management_must_be_accesible() {
        us02_homePage.hotelManagement.click();
        Assert.assertTrue(us02_homePage.hotelList.isDisplayed());
        Assert.assertTrue(us02_homePage.hotelRooms.isDisplayed());
        Assert.assertTrue(us02_homePage.roomReservation.isDisplayed());
    }

    @And("Hotel List must be accesible")
    public void hotel_List_must_be_accesible() {
        us02_homePage.hotelList.click();
        Assert.assertTrue(us02_homePage.listOfHotelTitle.isDisplayed());
    }

    @And("Hotel Rooms must be accesible")
    public void hotel_Rooms_must_be_accesible() {
        us02_homePage.hotelRooms.click();
        Assert.assertTrue(us02_homePage.listOfHotelRoomTitle.isDisplayed());

    }

    @Then("Room Reservations must be accesible")
    public void room_Reservations_must_be_accesible() {
        us02_homePage.roomReservation.click();
        Assert.assertTrue(us02_homePage.listOfReservationTitle.isDisplayed());
    }
}