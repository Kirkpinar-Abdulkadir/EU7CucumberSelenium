package com.vytrack.step_definitions;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard",actualTitle);
    }

    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() {
        new LoginPage().loginAsSSalesManager();
    }

    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() {
        new LoginPage().loginAsStoreManager();
    }

    @When("the user logs in using {string} and {string}")
    public void theUserLogsInUsingAnd(String username , String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @And("the title contains {string}")
    public void theTitleContains(String expectedTitle) {

        System.out.println("expectedTitle = " + expectedTitle);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
    }

    @Given("the user logged in as {string}")
    public void theUserLoggedInAs(String usertype) {
       Driver.get().get(ConfigurationReader.get("url"));
       String username = usertype.toLowerCase().replace(" ","") + "_username";
       String password = usertype.toLowerCase().replace(" ","") + "_password";
       LoginPage loginPage = new LoginPage();
       loginPage.loginWithUsertype(username,password);
    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userInfo) {
        //use map information to login and also verify firstname and lastname
        new LoginPage().login(userInfo.get("username"),userInfo.get("password"));

        /*String expectedName = userInfo.get("firstname");
        String expectedLastName = userInfo.get("lastname");

        String[] fullName = new DashboardPage().userName.getText().split(" ");
        String actualName = fullName[0];
        String actualLastName = fullName[1];
        Assert.assertEquals(expectedName,actualName);
        Assert.assertEquals(expectedLastName,actualLastName);*/

        String actualName = new DashboardPage().getUserName();
        String expectedName = userInfo.get("firstname") + " " + userInfo.get("lastname");
        Assert.assertEquals(expectedName,actualName);

    }

}
