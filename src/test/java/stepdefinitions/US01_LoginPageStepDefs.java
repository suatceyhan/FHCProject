package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.US01_LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US01_LoginPageStepDefs  {

    US01_LoginPage us01_loginPage=new US01_LoginPage();

    @Given("Environment must be accesable")
    public void environment_must_be_accesable() {
        Driver.getDriver().get(ConfigurationReader.getProp("fhc_login_url"));
        Assert.assertEquals(Driver.getDriver().getTitle(),"Fhctrip - Log in");
    }

    @And("Invalid username invalid password should not acces")
    public void invalid_username_invalid_password_should_not_acces() {
        us01_loginPage.username.sendKeys("managerrrr");
        us01_loginPage.password.sendKeys("Man1ager22!");
        us01_loginPage.loginButton.click();
        Assert.assertTrue(us01_loginPage.error_mesaj.isDisplayed());
        cleanTextboxes();
    }

    @And("Valid username invalid password should not acces")
    public void valid_username_invalid_password_should_not_acces() {
        us01_loginPage.username.sendKeys("manager2");
        us01_loginPage.password.sendKeys("Man12ager2!");
        us01_loginPage.loginButton.click();
        Assert.assertTrue(us01_loginPage.error_mesaj.isDisplayed());
        cleanTextboxes();
    }

    @And("inValid username valid password should not acces")
    public void invalid_username_valid_password_should_not_acces() {
        us01_loginPage.username.sendKeys("manager");
        us01_loginPage.password.sendKeys("Man1ager2!");
        us01_loginPage.loginButton.click();
        Assert.assertTrue(us01_loginPage.error_mesaj.getText().contains("Try again please"));
        cleanTextboxes();
    }

    @Then("Valid username valid password should acces succesfully")
    public void valid_username_valid_password_should_acces_succesfully() {
        us01_loginPage.username.sendKeys("manager2");
        us01_loginPage.password.sendKeys("Man1ager2!");
        us01_loginPage.loginButton.click();
        Assert.assertEquals(Driver.getDriver().getTitle(),"Admin - ListOfUsers");//Admin - ListOfUsers
    }

    public void cleanTextboxes()
    {
        us01_loginPage.username.clear();
        us01_loginPage.password.clear();
    }
}
