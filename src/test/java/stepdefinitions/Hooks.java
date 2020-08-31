package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Hooks {

    LoginPage loginPage = new LoginPage();

    @Before(value = "@fhcproject and not @userstory01")
    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProp("fhc_login_url"));
        loginPage.username.sendKeys(ConfigurationReader.getProp("validUsername"));
        loginPage.password.sendKeys(ConfigurationReader.getProp("validPassword"));
        loginPage.loginButton.submit();
    }

    @After
    public void tearDown(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if(scenario.isFailed()){
         //  scenario.embed(screenshot,"image/png");
        }
        //Driver.closeDriver();
    }
}
