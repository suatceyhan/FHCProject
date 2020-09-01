package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US04_RoomCreation;
import utilities.Driver;

public class US04_RoomCreationStepDefs {
    US04_RoomCreation us04_roomCreation=new US04_RoomCreation();
    Actions actions=new Actions(Driver.getDriver());

    @Given("Check that the Hotel Rooms link works")
    public void check_that_the_Hotel_Rooms_link_works() {

        us04_roomCreation.hotelManagementLink.click();
        us04_roomCreation.hotelRoomsLink.click();

    }

    @Given("Check that the Add Hotelroom button works")
    public void check_that_the_Add_Hotelroom_button_works() throws InterruptedException {

        Thread.sleep(5000);
        us04_roomCreation.addHotelRoomButton.click();

    }

    @Given("When all the information is entered and the save button is pressed, the message has been saved successfully.")
    public void when_all_the_information_is_entered_and_the_save_button_is_pressed_the_message_has_been_saved_successfully() throws InterruptedException {

        Thread.sleep(3000);
        Select select=new Select(us04_roomCreation.IDHotel);
        select.selectByIndex(2);
        us04_roomCreation.codeBox.sendKeys("123322");
        us04_roomCreation.nameBox.sendKeys("olimpos2");
        us04_roomCreation.locationBox.sendKeys("greek");
        us04_roomCreation.descriptionArea.sendKeys("greek`te bir otel");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        Driver.getDriver().manage().window().maximize();
        WebElement price= Driver.getDriver().findElement(By.id("Price"));
        WebElement source =Driver.getDriver().findElement(By.xpath("//li[@data-id='300']"));
        actions.dragAndDrop(source,price).perform();
        Select select1=new Select(us04_roomCreation.roomType);
        select1.selectByIndex(9);
        us04_roomCreation.maxAdultCount.sendKeys("2");
        us04_roomCreation.maxChildCount.sendKeys("4");
        us04_roomCreation.approved.click();
        us04_roomCreation.saveButton.click();
        Thread.sleep(5000);
        String textSuccesfully=us04_roomCreation.textMessage.getText();
        Assert.assertEquals(textSuccesfully,"HotelRoom was inserted successfully");
        us04_roomCreation.okButton.click();


    }

    @And("When the information to be entered is not entered, it is seen that it does not register when the save button is pressed.")
    public void when_the_information_to_be_entered_is_not_entered_it_is_seen_that_it_does_not_register_when_the_save_button_is_pressed() throws InterruptedException {

        Select select=new Select(us04_roomCreation.IDHotel);
        select.selectByIndex(2);
        us04_roomCreation.codeBox.sendKeys("123322");
        us04_roomCreation.nameBox.sendKeys("olimpos2");
        us04_roomCreation.locationBox.clear();
        us04_roomCreation.locationBox.sendKeys("greek");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us04_roomCreation.descriptionArea.clear();
        us04_roomCreation.descriptionArea.sendKeys("greek`te bir otel");
        Driver.getDriver().manage().window().maximize();
        WebElement price= Driver.getDriver().findElement(By.id("Price"));
        WebElement source =Driver.getDriver().findElement(By.xpath("//li[@data-id='300']"));
        actions.dragAndDrop(source,price).perform();
        Thread.sleep(3000);
        Select select1=new Select(us04_roomCreation.roomType);
        select1.selectByIndex(9);
        us04_roomCreation.maxAdultCount.sendKeys("2");
        us04_roomCreation.maxChildCount.sendKeys("4");
        us04_roomCreation.approved.click();
        us04_roomCreation.saveButton.click();
        Thread.sleep(5000);
        String textSuccesfully=us04_roomCreation.textMessage.getText();
        Assert.assertEquals(textSuccesfully,"HotelRoom was inserted successfully");
        us04_roomCreation.okButton.click();

    }
    @Then("Verify that the entered information is displayed in the Hotel Rooms list")
    public void verify_that_the_entered_information_is_displayed_in_the_hotel_rooms_list() throws InterruptedException {
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(5000);
        us04_roomCreation.hotelRoomsLink.click();
        String hotelRoomText= us04_roomCreation.hotelRoomListText.getText();
        Assert.assertEquals(hotelRoomText,"LIST OF HOTELROOMS");
        us04_roomCreation.idBox.sendKeys("18");
        Select select=new Select(us04_roomCreation.idHotelSelect);
        select.selectByIndex(2);
        us04_roomCreation.codeBox2.sendKeys("123321");
        us04_roomCreation.nameBox2.sendKeys("olimpos");
        us04_roomCreation.locationBox2.sendKeys("greek");
        us04_roomCreation.priceBox.sendKeys("300");
        Select select1=new Select(us04_roomCreation.idGroupRoomType);
        select1.selectByIndex(9);
        us04_roomCreation.search.click();

    }
}
