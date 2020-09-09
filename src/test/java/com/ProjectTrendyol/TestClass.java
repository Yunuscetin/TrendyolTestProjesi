package com.ProjectTrendyol;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.List;
import java.util.Random;

public class TestClass extends BaseTest {

    BasePage bp;


    @Test
    public void Test() throws InterruptedException { // Popup kapatılması ve giriş işlemi için kullanılan metod.

        Thread.sleep(5000);
        bp.clickBy(By.className("fancybox-close"));
        bp.clickBy(By.id("accountBtn"));
        //a[@class='fancybox-item fancybox-close']//
    }

    @Test
    public void LogIn() {  // LogIn olma sırasında gerçekleşecek işlemler için kullanılan metod.

        Assert.assertTrue(bp.driver.getTitle().equals("En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da"));
        bp.clickBy(By.cssSelector("i[class='icon navigation-icon-user']"));
        bp.SendAndClick(By.id("email"), "yunus_5959@windowslive.com");
        bp.SendAndClick(By.id("password"), "yunus1706");
        bp.clickBy(By.id("loginSubmit"));
        //Assert.assertEquals(element("yunus_5959@windowslive.com", userName);

    }

    @Test
    public void Search() { // Senaryo üzerinde arama yapılması için oluşturulan metod.

        bp.SendAndClick(By.className("search-box"), "Bilgisayar");
        bp.clickBy(By.className("search-icon"));
    }

    @Test
    public void Random() {  //Ürünlerin arasından rastgele birinin seçilmesi için oluşturulan metod.
        Random r = new Random();
        int a = r.nextInt(20);
        WebElement elem = bp.driver.findElement(By.className("prdct-cntnr-wrppr"));
        List<WebElement> urunler = elem.findElements(By.className("p-card-wrppr"));
        for (int i = 0; i < urunler.size(); i++) {
            if (i == a) {
                WebElement urunSec = urunler.get(i);
                urunSec.click();
            }
        }

    }

    @Test
    public void AddBasket() {  //Ürünün sepete eklenmesi amacıyla oluşturulan metod.
        String itemPrice = bp.driver.findElement(By.className("prc-dsc")).getText();
        bp.clickBy(By.className("add-to-bs-tx"));//ürün eklendi.
        String itemPriceBasket = bp.driver.findElement(By.className("pb-basket-item-price")).getText();
        Assert.assertEquals(itemPrice, itemPriceBasket);
    }

    @Test
    public void AddMoreBasket() { // Ürün sayısını arttırmak için kullanılan metod.
        bp.clickBy(By.className("ty-numeric-counter-button"));
        String piece = bp.driver.findElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[1]/div/input")).getText();
        Assert.assertTrue(bp.driver.equals("2"));

    }

    @Test
    public void DeleteItem() { // Ürün sayısını azaltmak için kullanılan metod.
        bp.clickBy(By.className("i-trash"));
        String piece = bp.driver.findElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[1]/div/input")).getText();
        Assert.assertTrue(bp.driver.equals("0")); //Sepetin boş olması için 0'a eşitlendi.
    }


}
