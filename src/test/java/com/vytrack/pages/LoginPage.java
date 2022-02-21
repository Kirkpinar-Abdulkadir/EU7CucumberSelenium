package com.vytrack.pages;


import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    //driver.findElement(By.name("_username"));
    @FindAll({ //gives us option to use multiple locators,
            // if at least one of them is matching it will find the web element
            @FindBy(id = "prependedInput"),
            @FindBy(name ="_username")
    })
    public WebElement usernameInput;

    //driver.findElement(By.id("prependedInput2"));
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    //driver.findElement(By.id("_submit"));
    @FindBy(id = "_submit")
    public WebElement loginBtn;

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsStoreManager(){
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsDriver(){
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsSSalesManager(){
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginWithUsertype(String usertype, String usertypePass){
        String username = ConfigurationReader.get(usertype);
        String password = ConfigurationReader.get(usertypePass);

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

}
