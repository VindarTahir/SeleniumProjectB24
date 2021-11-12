package com.cybertek.tests.vytrack_project;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TS_VY_001 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://app.vytrack.com/user/login");

        String user = "salesmanager101";
        String pass = "UserUser123";

        WebElement userField = driver.findElement(By.id("prependedInput"));
        WebElement passField = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[id='_submit']"));

        userField.sendKeys(user);
        Thread.sleep(1500);
        passField.sendKeys(pass);
        Thread.sleep(1500);
        loginButton.click();

        WebElement actualHomePage = driver.findElement(By.cssSelector("a[title='Fleet Management']"));
        String actualHomePageText = actualHomePage.getText();
        String expectedHomePage = "Fleet Management";
        Thread.sleep(1500);

        if (actualHomePageText.equals(expectedHomePage)){
            System.out.println("PASS: Login Successful");
        } else {
            System.out.println("FAIL: Login Not Successful");
        }


    }

}
