package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement registerLink;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logoutLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computersTab;
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']")
    WebElement desktopUnderComputers;


    public void clickOnLoginLink() {
        Reporter.log("Clicking on login link : " + loginLink.toString() + "<br>");
        clickOnElement(loginLink);
    }

    public void clickOnRegisterLink() {
        Reporter.log("Clicking on register link " + registerLink.toString() + "<br>");
        clickOnElement(registerLink);
        //CustomListeners.test.log(Status.PASS, "Clicking on register link ");
    }

    public void clickOnLogOutLink() {
        Reporter.log("Clicking on logout link : " + logoutLink.toString() + "<br>");
        clickOnElement(logoutLink);
    }

    public void verifyLogoutLinkIsDisplayedAfterLogin() {
        Reporter.log("Getting logout Link text : " + logoutLink.toString() + "<br>");
        verifyTestMethod("Logout", logoutLink, "Logout link is not displayed after successful login");
    }

    public void verifyLogInLinkIsDisplayedAfterLogout() {
        Reporter.log("Getting login Link text : " + loginLink.toString() + "<br>");
        verifyTestMethod("Login", loginLink, "Login link is not displayed after user logout");
    }

    public void clickOnComputersTab() {
        clickOnElement(computersTab);
    }

    public void mouseHoverAndClickOnDesktopUnderComputers() {
        Reporter.log("MouseHover on Computer link : " + computersTab.toString() + "<br>");
        mouseHoverToElement(computersTab);
        Reporter.log("MouseHover and click on Desktop link : " + desktopUnderComputers.toString() + "<br>");
        mouseHoverToElementAndClick(desktopUnderComputers);
    }


}
