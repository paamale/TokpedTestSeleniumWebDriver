package com.juaracoding.selenium.pages;

import com.juaracoding.selenium.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {
    private WebDriver driver;

    public SearchProduct() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header-main-wrapper\"]/div[2]/div[2]/div/div/div/div/input")
    WebElement searchItem;

    @FindBy(xpath = "//p[@class='css-1hhh2ha-unf-heading e1qvo2ff8']")
    WebElement txtTotalProduct;

    @FindBy(xpath = "//div[normalize-space()='dbE TWS10 V2 High Fidelity TWS Bluetooth Earphone ENC Microphone']")
    WebElement product;



    public void setSearchItem() {
        searchItem.sendKeys("earphone" + Keys.ENTER);
    }

    public void clickProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", product);
    }
    public String getTextTotalItem() {return txtTotalProduct.getText();}

    public String getTextProduct() {return product.getText();}

}
