package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ComputerPage extends Utility {
    public ComputerPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[normalize-space()='Computers']")
    WebElement computersText;

    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement desktopsText;
    @FindBy(xpath = "//div[@class='picture']//img[@title='Show details for Build your own computer']")
    WebElement buildComputerClick;

    public void verifyComputersText() {
        Reporter.log("Getting computers text: " + computersText.toString() + "<br>");
        verifyTestMethod("Computers", computersText, "Computers text is not displayed");
    }

    public void verifyDesktopsText() {
        Reporter.log("Getting desktops text: " + desktopsText.toString() + "<br>");
        verifyTestMethod("Desktops", desktopsText, "Desktops text is not displayed");
    }

    public void clickOnBuildYourOwnComputer() {
        Reporter.log("Clicking on build your own computer: " + buildComputerClick.toString() + "<br>");
        clickOnElement(buildComputerClick);
    }
}
