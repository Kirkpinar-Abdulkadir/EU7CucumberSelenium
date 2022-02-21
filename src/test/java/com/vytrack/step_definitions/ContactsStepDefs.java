package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactsStepDefs {


    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {

        //get the list of WebElements and convert them to list of string and assert
        BrowserUtils.waitFor(1);
        List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);
        Assert.assertEquals(menuOptions,actualOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);
    }
}
