package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }// body olmayadabilir.

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[@href='#']")
    public WebElement optionLink;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "//button[contains(@class,'dropdown-toggle ')]")
    public WebElement viewPerPage;

    @FindBy(xpath = "//label[contains(.,'Total')]")
    public WebElement totalRecordElm;

    @FindBy(xpath = "//a[@data-size='100']")
    public WebElement record100;

    @FindBy(xpath = "//button[contains(@class,'dropdown-toggle ')]/span")
    public WebElement viewPerPageDropdown;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> rowNumber;

    @FindBy(xpath = "//input[@data-role]")
    public List<WebElement> checkBoxes;

    @FindBy(xpath = "//div[@class='btn-group dropdown']//input")
    public WebElement selectAllCheckboxes;

    @FindBy(xpath = "//td[.='Testers meeting']/..//a[@class='dropdown-toggle']")
    public WebElement tridot;

    @FindBy(xpath = "(//li[@class='launcher-item']/a[contains(@class,'action')])[1]")
    public WebElement viewElement;

    @FindBy(xpath = "//div[contains(@class,'attribute-row')]")
    public List<WebElement> eventDetailElm;

    public List<String> expectedList = Arrays.asList("Title " +
                    "Testers meeting", "Description This is a a weekly testers meeting",
            "Start Nov 27, 2019, 9:30 AM", "End Nov 27, 2019, 10:30 AM", "All-Day Event No", "Organizer John Doe", "Call Via Hangout No");

    public int numberOfEvents() throws InterruptedException {
        int totalRecord = Integer.parseInt(totalRecordElm.getText().substring(9,11));
        if(totalRecord>25){
            viewPerPageDropdown.click();
            record100.click();
            Thread.sleep(2000);

        }
        return totalRecord;
    }

    public List<String> eventDetailsVerify(){
        List<String> actualList = new ArrayList<>();

        for (WebElement element : eventDetailElm) {
            actualList.add(element.getText());
        }
        return actualList;
    }

}
