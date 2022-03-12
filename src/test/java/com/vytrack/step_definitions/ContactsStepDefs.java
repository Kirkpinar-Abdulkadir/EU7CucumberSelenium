package com.vytrack.step_definitions;

import com.vytrack.pages.ContactInfoPage;
import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

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

    @When("the user clicks the {string} from contacts")
    public void the_user_clicks_the_from_contacts(String email) {
        BrowserUtils.waitFor(3);
        //BrowserUtils.waitForClickablility(new ContactsPage().getContactEmail(email),10);
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.getContactEmail(email).click();
    }

    @Then("the information should be same with database")
    public void the_information_should_be_same_with_database() {
        BrowserUtils.waitFor(2);
        //get info from UI
        ContactInfoPage contactInfoPage =new ContactInfoPage();
        String actulFullname = contactInfoPage.fullName.getText();
        String actulEmail = contactInfoPage.email.getText();
        String actulPhoneNumber = contactInfoPage.phone.getText();

        System.out.println("actulFullname = " + actulFullname);
        System.out.println("actulEmail = " + actulEmail);
        System.out.println("actulPhoneNumber = " + actulPhoneNumber);


        //get info from db
        String query = "select concat(first_name,' ',last_name)as \"fullname\",e.email,phone\n" +
                "from orocrm_contact a join orocrm_contact_email e\n" +
                "on a.id=e.owner_id join orocrm_contact_phone p\n" +
                "on e.owner_id=p.owner_id\n" +
                "where e.email='mbrackstone9@example.com'";
        DBUtils.createConnection();
        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        String expectedFullname = (String) rowMap.get("fullname");
        String expectedEmail = (String) rowMap.get("email");
        String expectedPhoneNumber = (String) rowMap.get("phone");

        System.out.println("expectedFullname = " + expectedFullname);
        System.out.println("expectedEmail = " + expectedEmail);
        System.out.println("expectedPhoneNumber = " + expectedPhoneNumber);

        DBUtils.destroy();

        //assert
        Assert.assertEquals(expectedFullname,actulFullname);
        Assert.assertEquals(expectedEmail,actulEmail);
        Assert.assertEquals(expectedPhoneNumber,actulPhoneNumber);
    }
}
