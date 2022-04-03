package com.konasl.mbl.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DatePicker {
    public static void selectStartDate(WebDriver driver, String element) throws InterruptedException{
        driver.findElement(By.id(element)).click();
        Thread.sleep(1000);
        driver.findElement(By.className("ngb-dp-navigation-chevron")).click();
        List<WebElement> dates = driver.findElements(By.className("btn-light"));
        dates.get(0).click();
        Thread.sleep(1000);
    }


    public static void selectEndDate(WebDriver driver, String element) throws InterruptedException{
        driver.findElement(By.id("createdTo")).click();
        Thread.sleep(1000);
        List<WebElement> dates = driver.findElements(By.className("btn-light"));
        dates.get(0).click();
        Thread.sleep(1000);
    }

}
