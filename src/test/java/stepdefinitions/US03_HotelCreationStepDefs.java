package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;
import pages.US03_HotelCreation;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class US03_HotelCreationStepDefs {

    US03_HotelCreation us03_hotelCreation = new US03_HotelCreation();

    @Given("Navigate to Hotel List")
    public void navigate_to_hotel_list() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        us03_hotelCreation.hotelManagementButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        us03_hotelCreation.hotelList.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @And("Hotel List must be accessible")
    public void hotel_list_must_be_accessible() {
        us03_hotelCreation.listOfHotel.isDisplayed();
    }

    @And("Add Hotel must be executable")
    public void add_hotel_must_be_executable() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        us03_hotelCreation.addHotelButton.click();
    }

    @And("Unsuccesful registration with invalid data")
    public void unsuccesful_registration_with_invalid_data() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        us03_hotelCreation.code.sendKeys("222");
        us03_hotelCreation.name.sendKeys("aaa");
        us03_hotelCreation.address.sendKeys("dddd");
        us03_hotelCreation.phone.sendKeys("456456");
        Select selectIDG = new Select(us03_hotelCreation.idGroup);
        selectIDG.selectByIndex(1);
        us03_hotelCreation.saveButton.submit();
        us03_hotelCreation.errorEmail.isDisplayed();
    }

    @And("Clear unsuccesful data")
    public void clear_unsuccesful_data() {
        us03_hotelCreation.code.clear();
        us03_hotelCreation.name.clear();
        us03_hotelCreation.address.clear();
        us03_hotelCreation.phone.clear();
        us03_hotelCreation.email.clear();
        Select selectIDG = new Select(us03_hotelCreation.idGroup);
        selectIDG.selectByIndex(0);
    }

    @And("Succesful registration with valid data")
    public void succesful_registration_with_valid_data() {
        us03_hotelCreation.code.sendKeys("222");
        us03_hotelCreation.name.sendKeys("aaa");
        us03_hotelCreation.address.sendKeys("dddd");
        us03_hotelCreation.phone.sendKeys("456456");
        us03_hotelCreation.email.sendKeys("email@email.com");
        Select selectIDG = new Select(us03_hotelCreation.idGroup);
        selectIDG.selectByIndex(1);
        us03_hotelCreation.saveButton.submit();
        us03_hotelCreation.saveSuccess.isDisplayed();
        us03_hotelCreation.confirmOk.click();
    }

    @Then("Check registered data on Hotel List")
    public void check_registered_data_on_hotel_list() {
        us03_hotelCreation.codeBox.sendKeys("222");
        us03_hotelCreation.nameBox.sendKeys("aaa");
        us03_hotelCreation.addressBox.sendKeys("dddd");
        us03_hotelCreation.phoneBox.sendKeys("456456");
        us03_hotelCreation.emailBox.sendKeys("email@email.com");
        Select selectIDG = new Select(us03_hotelCreation.idGroupBox);
        selectIDG.selectByIndex(1);
        us03_hotelCreation.searchButton.click();
        us03_hotelCreation.codeCheck.equals("222");
    }
}
