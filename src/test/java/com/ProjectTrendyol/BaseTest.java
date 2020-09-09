package com.ProjectTrendyol;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void DriverUp(){ // WebDriver tanımlaması yaparak driveri ayağa kaldırma işlemi gerçekleştirildi.
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver=new ChromeDriver(options);
        driver.get("http://www.trendyol.com");

    }

    @After // Driverin kapatılması için kullanılan metod.
    public void DriverDown() {
        driver.quit();
    }
}
