package com.ProjectTrendyol;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {  // Değişken tanımlamaları yapılarak metodların içine çağırılmaları sağlandı.
    public WebDriver driver;
    public Actions builder;
    public WebDriverWait wait;

    public BasePage(WebDriver driver,WebDriverWait wait){
        this.driver = driver;
        this.wait =wait;
        this.builder = new Actions(driver);
    }
    public void waitSeconds(int second){  //İşlem sırasında bekleme için kullanılan metod. 1 saniyelik zaman dilimi kullanıldı.
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void SendAndClick(By by, String text){  // Yazım ve tıklama işlemleri için pratik oluşturuldu. Özellikle textboxların doldurulması için hazırlandı.
        WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated((by)));
        element.clear();
        element.sendKeys(text);
    }
    public void clickBy(By by){ // Tıklama işleminin gerçekleştiği metod.
        WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable((by)));
        element.click();
    }


}
