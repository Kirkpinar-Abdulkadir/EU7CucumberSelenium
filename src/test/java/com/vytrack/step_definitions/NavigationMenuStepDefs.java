package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationMenuStepDefs {

    @When("the user navigates to Fleet, Vehicles")
    public void the_user_navigates_to_Fleet_Vehicles() {
        System.out.println("the user navigates to Fleet, Vehicles");
    }

    @Then("the title should be Vehicles")
    public void the_title_should_be_Vehicles() {
        System.out.println("Expected and actual titles are matching");
    }

    @When("the user navigates to Marketing, Campaigns")
    public void the_user_navigates_to_Marketing_Campaigns() {
        System.out.println("the user navigates to Marketing, Campaigns");
    }

    @Then("the title should be Campaigns")
    public void the_title_should_be_Campaigns() {
        System.out.println("Expected and actual titles are matching");
    }

    @When("the user navigates to Activities, Calendar Events")
    public void the_user_navigates_to_Activities_Calendar_Events() {
        System.out.println("the user navigates to Activities, Calendar Events");
    }

    @Then("the title should be Calendar Events")
    public void the_title_should_be_Calendar_Events() {
        System.out.println("Expected and actual titles are matching");
    }

    @When("the user navigates to {string} {string}")
    public void theUserNavigatesTo(String tab, String module) {
        new DashboardPage().navigateToModule(tab, module);
    }

    @Then("default page number should be {int}")
    public void defaultPageNumberShouldBe(int actualPageNumber) {

        ContactsPage contactsPage = new ContactsPage();
        BrowserUtils.waitForVisibility(contactsPage.pageNumber,10);
        int expectedPageNumber = Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));

        Assert.assertEquals(expectedPageNumber,actualPageNumber);
    }
}
