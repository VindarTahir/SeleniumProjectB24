package com.cybertek.tests.vytrack_project;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TS_VY_002 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://app.vytrack.com/user/login");

        String user = "johnjohn";
        String pass = "UserUser123";

        WebElement userField = driver.findElement(By.id("prependedInput"));
        WebElement passField = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[id='_submit']"));

        userField.sendKeys(user);
        Thread.sleep(1500);
        passField.sendKeys(pass);
        Thread.sleep(1500);
        loginButton.click();

        WebElement invalidPopUp = driver.findElement(By.xpath("//div[.='Invalid user name or password.']"));
        String invalidPopUpText = invalidPopUp.getText();
        String expPopUpText = "Invalid user name or password.";

        if (invalidPopUpText.equals(expPopUpText)){
            System.out.println("PASS: Invalid login");
        } else {
            System.out.println("FAIL: Login verification failed");
        }


    }

}
