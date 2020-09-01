package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US06_UserListCreation;
import utilities.Driver;

import javax.swing.*;
import java.nio.channels.SelectableChannel;

public class US06_UserListCreationStepDefs {

    US06_UserListCreation uspage06 = new US06_UserListCreation();

    @Given("user go to page")
    public void user_go_to_page() {
        //Driver.getDriver().get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2Fadmin%2FuserAdmin%2FCreate");
        //uspage06.loginUserName.sendKeys("manager2");
        //uspage06.loginpassword.sendKeys("Man1ager2!");
        //uspage06.loginbutton.click();
    }

    @Given("USER LIST page must be accessible.")
    public void user_LIST_page_must_be_accessible() {
        // uspage06.managementTitle.click();
        //uspage06.userlist.click();
    }

    @Given("ADD USER button must be executable")
    public void add_USER_button_must_be_executable() {
        Assert.assertTrue(uspage06.addUserButton.isDisplayed());
    }

    @Given("An User can not be added if all required datas is not entered validly.")
    public void an_User_can_not_be_added_if_all_required_datas_is_not_entered_validly() throws InterruptedException {
        uspage06.addUserButton.click();
        uspage06.userName.sendKeys("Emre");
        uspage06.password.sendKeys("Ppasword");
        uspage06.email.sendKeys("abc@gmail.com");
        uspage06.fullName.sendKeys("Emry ");
        uspage06.phone.sendKeys("123456");
        uspage06.ssn.sendKeys("123456");
        uspage06.driverLicense.sendKeys("9876798767987");
        Select country = new Select(uspage06.country);
        country.selectByVisibleText("United States");
        Select state = new Select(uspage06.state);
        state.selectByIndex(1);
        uspage06.address.sendKeys("141 isligton avenue");
        uspage06.birthdate.sendKeys("01/01/2020");
        uspage06.workingSector.sendKeys("IT");
        Select role = new Select(uspage06.role);
        role.selectByIndex(1);
        uspage06.yesButton.click();
        uspage06.saveButton.click();
        uspage06.userName.clear();
        uspage06.password.clear();
        uspage06.email.clear();
        uspage06.fullName.clear();
        uspage06.phone.clear();
        uspage06.ssn.clear();
        uspage06.driverLicense.clear();
        uspage06.address.clear();
        uspage06.birthdate.clear();
        uspage06.workingSector.clear();
    }

    @Given("An User can be added if all required datas entered validly.")
    public void an_User_can_be_added_if_all_required_datas_entered_validly() throws InterruptedException {
        // uspage06.userListButton.click();
        //  uspage06.addUserButton.click();
        uspage06.userName.sendKeys("Emredmn");
        uspage06.password.sendKeys("Ppasword123*!");
        uspage06.email.sendKeys("abc@gmail.com");
        uspage06.fullName.sendKeys("Emry Duman");
        uspage06.phone.sendKeys("1234567555");
        uspage06.ssn.sendKeys("123456789");
        uspage06.driverLicense.sendKeys("9876798767987");
        Select country = new Select(uspage06.country);
        country.selectByVisibleText("United States");
        Select state = new Select(uspage06.state);
        state.selectByIndex(1);
        uspage06.address.sendKeys("141 isligton avenue");
        uspage06.birthdate.sendKeys("01/01/2020");
        uspage06.workingSector.sendKeys("IT");
        Select role = new Select(uspage06.role);
        role.selectByIndex(1);
        uspage06.yesButton.click();
        uspage06.saveButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(uspage06.successMessage.getText(),"User was inserted successfully");
    }

    @Given("Check if the Alert Box works.")
    public void check_if_the_Alert_Box_works() {
        uspage06.okButton.click();
    }

    public void scrollDownByJS(){
        JavascriptExecutor jsExecutor =((JavascriptExecutor)Driver.getDriver());
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Given("Check if added users can be displayed on User List Table.")
    public void check_if_added_users_can_be_displayed_on_User_List_Table() throws InterruptedException {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(3000);
        uspage06.userListButton.click();
        Thread.sleep(3000);
        uspage06.searchEmail.sendKeys("abc@gmail.com");
        uspage06.searchButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(uspage06.searchName.getText().equals("emreeree"));
    }
}

