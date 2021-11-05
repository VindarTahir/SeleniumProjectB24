package com.cybertek.tests.project;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC01 {

    public static void main(String[] args) throws InterruptedException {

        String url = "https://login.nextbasecrm.com/";

        // Setting up driver
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // Opening url page
        driver.get(url);

        String user = "helpdesk1@cybertekschool.com";
        String pass = "UserUser";


        // Finding the element for the login search field
        WebElement loginInput = driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));

        // Finding the element for the password search field
        WebElement passInput = driver.findElement(By.cssSelector("input[name='USER_PASSWORD']"));

        // Inputting our user into user field
        loginInput.sendKeys(user);
        Thread.sleep(1500);

        // Inputting our password into password field
        passInput.sendKeys(pass);
        Thread.sleep(1500);

        // Finding login button element
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In']"));
        loginButton.click();

        // Finding element on the homepage that shows we have logged in
        WebElement verifyUser = driver.findElement(By.cssSelector("span[id='user-name']"));

        // Expected user
        String expUser = user;

        // Actual user
        String actUser = verifyUser.getText();

        // Login verification
        if (actUser.equals(expUser)){
            System.out.println("PASS: User successfully logged in");
        } else {
            System.out.println("FAIL: User not logged in");
        }

        driver.quit();

    }

}
