package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class BuildYourOwnComputerPage extends Utility {
    public BuildYourOwnComputerPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "product_attribute_1")
    WebElement selectProcessor;
    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement selectRam;
    WebElement verifyPrice;
    @FindBy(xpath = "//button[@id='add-to-cart-button-1']")
    WebElement addCartButton;
    @FindBy(xpath = "//p[text()='The product has been added to your ']")
    WebElement addedToCartMessage;
    @FindBy(xpath = "//span[@class='close']")
    WebElement closeTab;

    public void setSelectProcessor(String processor) {
        Reporter.log("Selecting processor: " + processor + " from " + selectProcessor.toString() + "<br>");
        selectByVisibleTextFromDropDown(selectProcessor, processor);
    }

    public void setSelectRam(String ram) {
        Reporter.log("Selecting RAM: " + ram + " from " + selectRam.toString() + "<br>");
        selectByVisibleTextFromDropDown(selectRam, ram);
    }

    public void clickOnHdd(String hdd) {
        Reporter.log("Selecting hdd: " + hdd.toString() + "<br>");
        clickOnElement(By.xpath("//label[contains(text(),'"+hdd+"')]"));
    }

    public void clickOnOS(String os) {
        Reporter.log("Selecting os: " + os.toString() + "<br>");
        clickOnElement(By.xpath("//label[contains(text(),'" + os + "')]"));
    }

    public void setSelectSoftware(String software) {
        Reporter.log("Selecting software : " + software.toString() + "<br>");


        if (software == "Microsoft Office [+$50.00]") {
            doubleClickOnElement(By.xpath("//label[contains(text(),'" + software + "')]"));
        } else {
            clickOnElement(By.xpath("//label[contains(text(),'" + software + "')]"));
        }
    }

    public void clickOnAddToCart() {
        Reporter.log("Clicking add to cart: " + addCartButton.toString() + "<br>");
        clickOnElement(addCartButton);
    }

    public void verifyMessageProductsAddedToShoppingCart() {
        String expText = "The product has been added to your shopping cart";
        String actText = getTextFromElement(addedToCartMessage);
        Assert.assertEquals(expText, actText, "Product added to cart message not displayed");
    }

}
