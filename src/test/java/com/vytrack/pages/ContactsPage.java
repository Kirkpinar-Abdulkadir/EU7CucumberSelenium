package com.vytrack.pages;


import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage{

    public String givenEmail = "mbrackstone9@example.com";
    public String xpathFirstname = "//td[contains(.,'"+givenEmail+"')]/../td[2]";
    public String xpathLastname = "//td[contains(.,'"+givenEmail+"')]/../td[3]";
    public String xpathEmail = "//td[contains(.,'"+givenEmail+"')]/../td[4]";
    public String xpathPhone = "//td[contains(.,'"+givenEmail+"')]/../td[5]";


    @FindBy(xpath = "//h1[@class='user-name']")
    public WebElement fullname;

    @FindBy(xpath = "//a[@class='email']")
    public WebElement email;

    @FindBy(xpath = "//a[@class='phone']")
    public WebElement phone;

    @FindBy(css=".input-widget")
    public WebElement pageNumber;

    public String expectedFullName(){
        String firstName = Driver.get().findElement(By.xpath(xpathFirstname)).getText();
        String lastName = Driver.get().findElement(By.xpath(xpathLastname)).getText();
        return firstName + " " + lastName;
    }
    public String expectedPhoneNumber(){
        return Driver.get().findElement(By.xpath(xpathPhone)).getText();
    }
    public String expectedEmail(){
        return Driver.get().findElement(By.xpath(xpathEmail)).getText();
    }

//=========================JAMAL'S SOLUTIONS PART==================================

    //since we are extending BasePage we do not need explicit constructor for this class

    /*@FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
    public WebElement email;*/

    public WebElement getContactEmail(String email){
        String xpath ="//td[contains(text(),'"+email+"')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));
    }



}
