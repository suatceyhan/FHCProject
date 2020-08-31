package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.US01_LoginPage;
import pages.US05_ReservationCreation;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class US05_ReservationCreationStepDefs {

    US05_ReservationCreation us05_reservationCreation=new US05_ReservationCreation();
    @Given("ROOM RESERVATIONS page must be accessible")
    public void room_RESERVATIONS_page_must_be_accessible() {
        us05_reservationCreation.hotelManagementButton.click();
        us05_reservationCreation.roomReservation.click();
        Assert.assertTrue(us05_reservationCreation.listOfReservationTitle.isDisplayed());
    }

    @Given("ADD ROOM RESERVATION must be executable")
    public void add_ROOM_RESERVATION_must_be_executable()
    {
        //method1 - to verify if addReservationButton is displayed.
        Assert.assertTrue(us05_reservationCreation.addReservationButton.isDisplayed());

        //method2
        boolean present=false;
        try {
            Driver.getDriver().findElement(By.xpath("//a[@href='/admin/RoomReservationAdmin/Create']"));
            present = true;
        }
        catch (NoSuchElementException e) {
            present = false;
        }
        Assert.assertTrue(present);

        //method3 - ternary
        System.out.println(Driver.getDriver().findElements( By.xpath("//a[@href='/admin/RoomReservationAdmin/Create']")).size() != 0 ? true : false);

        us05_reservationCreation.addReservationButton.sendKeys(Keys.ENTER);
        //us05_reservationCreation.addReservationButton.sendKeys(Keys.RETURN);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("/html/body/div[3]/div[2]/div/div[3]/div/div/div[1]/div[1]"),"Create Hotelroomreservatıon"));
        Assert.assertTrue(isTrue);


    }

    @Given("User enters valid datas at Create Hotelroomreservation")
    public void user_enters_valid_datas_at_Create_Hotelroomreservation() throws InterruptedException //thread.sleep(); ten dolayı exception var
    {
        Select idUserSelect=new Select(us05_reservationCreation.idUser);
        idUserSelect.selectByIndex(1);
        Select idHotelRoomSelect=new Select(us05_reservationCreation.idHotelRoom);
        idHotelRoomSelect.selectByIndex(5);
        us05_reservationCreation.price.sendKeys("500");
        us05_reservationCreation.dateStart.sendKeys("01/01/2022");
        us05_reservationCreation.dateEnd.sendKeys("02/01/2022");
        us05_reservationCreation.adultAmount.sendKeys("2");
        us05_reservationCreation.childrenAmount.sendKeys("3");
        us05_reservationCreation.surname.sendKeys("DUMAN");
        us05_reservationCreation.phone.sendKeys("1234567890");
        us05_reservationCreation.email.sendKeys("email@email.com");
        us05_reservationCreation.notes.sendKeys("sea view");
        us05_reservationCreation.isApproved.click();
        us05_reservationCreation.isPaid.click();
        us05_reservationCreation.saveButton.submit();
        Thread.sleep(5000);
        //Assert.assertTrue(fhcRezervasyonPage.successMessage.isDisplayed());  //1.
        String message = us05_reservationCreation.successMessage.getText();
        Assert.assertTrue(message.equals("RoomReservation was inserted successfully"));  //2.
        //System.out.println(Driver.getDriver().switchTo().alert().getText());//alert mesajı //3. (error veriyor)
    }

    @Given("Alert Box must be accessible")
    public void alert_Box_must_be_accessible()
    {
        //method1
        //Driver.getDriver().switchTo().alert().accept();//alertteki ok tusunu clicklemek icin(error veriyor)
        //method2
        Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("/html/body/div[3]/div[2]/div/div[3]/div/div/div[1]/div[1]"),"Create Hotelroomreservatıon"));
        Assert.assertTrue(isTrue);
    }

    @Given("Clear invalid data")
    public void clear_invalid_data(){
        US05_ReservationCreation us05_reservationCreation=new US05_ReservationCreation();
        us05_reservationCreation.price.clear();
        us05_reservationCreation.adultAmount.clear();
        us05_reservationCreation.childrenAmount.clear();
        us05_reservationCreation.surname.clear();
        us05_reservationCreation.phone.clear();
        us05_reservationCreation.email.clear();
        us05_reservationCreation.notes.clear();
        us05_reservationCreation.isApproved.isSelected();
        us05_reservationCreation.isPaid.isSelected();
    }

    @Given("User enters invalid datas at Create Hotelroomreservation")
    public void user_enters_invalid_datas_at_Create_Hotelroomreservation()
    {
        US05_ReservationCreation us05_reservationCreation=new US05_ReservationCreation();//clearDatas() method exists in Hooks Class
        //us05_reservationCreation.clearDatas();//verileri sildim
        Select idUserSelect=new Select(us05_reservationCreation.idUser);
        idUserSelect.selectByIndex(1);
        Select idHotelRoomSelect=new Select(us05_reservationCreation.idHotelRoom);
        idHotelRoomSelect.selectByIndex(5);
        us05_reservationCreation.price.sendKeys("500");
        us05_reservationCreation.dateStart.sendKeys(Keys.ENTER+"01/01/2022");
        us05_reservationCreation.dateEnd.sendKeys(Keys.ENTER+"02/01/2022");
        us05_reservationCreation.adultAmount.sendKeys("2");
        us05_reservationCreation.childrenAmount.sendKeys("3");
        us05_reservationCreation.surname.sendKeys("DUMAN");
        us05_reservationCreation.phone.sendKeys("123456789");
        us05_reservationCreation.email.sendKeys("");
        us05_reservationCreation.notes.sendKeys("sea view");
        us05_reservationCreation.isApproved.isSelected();//click de olur
        us05_reservationCreation.isPaid.isSelected();
        us05_reservationCreation.saveButton.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("LIST OF RESERVATION must be accessible")
    public void list_OF_RESERVATION_must_be_accessible() throws InterruptedException {
        //Driver.getDriver().navigate().to(ConfigurationReader.getProp("fhcReservationTable"));
        us05_reservationCreation.hotelManagementButton.click();
        us05_reservationCreation.roomReservation.click();
        us05_reservationCreation.emailSearchBox.sendKeys("email@email.com");
        us05_reservationCreation.searchButton.click();
        Thread.sleep(5000);
        Assert.assertEquals(us05_reservationCreation.registeredEmail.getText(),"email@email.com");
    }
}
