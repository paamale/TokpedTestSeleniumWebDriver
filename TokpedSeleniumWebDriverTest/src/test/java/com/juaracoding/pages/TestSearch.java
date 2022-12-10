package com.juaracoding.pages;

import com.juaracoding.selenium.drivers.DriverSingleton;
import com.juaracoding.selenium.pages.SearchProduct;
import com.juaracoding.selenium.utils.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSearch {

    public static WebDriver driver;

    private SearchProduct searchProduct;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @BeforeMethod
    public void pageObject() {
        searchProduct = new SearchProduct();
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void testSearchProduct() {
        delay(Constants.DETIK);
        searchProduct.setSearchItem();
        delay(Constants.DETIK);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        Assert.assertEquals(searchProduct.getTextProduct(), "dbE TWS10 V2 High Fidelity TWS Bluetooth Earphone ENC Microphone");
        System.out.println("Choose product : dbE TWS10 V2 High Fidelity TWS Bluetooth Earphone ENC Microphone");
    }

    @Test
    public void testTotalProduct() {
        delay(Constants.DETIK);
        searchProduct.clickProduct();
        Assert.assertEquals(searchProduct.getTextTotalItem(), "Stok Total: 25");
        System.out.println("Stok Total: 25");
    }

    //Menampilkan 1 - 60 barang dari total 5.1jt+ untuk

    static void delay(int detik) {
        try {
            Thread.sleep(1000 * detik);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
