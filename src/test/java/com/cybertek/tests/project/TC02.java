package com.cybertek.tests.project;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC02 {

    public static void main(String[] args) throws InterruptedException {

        String url = "https://login.nextbasecrm.com/";

        // Setting up driver
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // Opening url page
        driver.get(url);

        String user = "java";
        String pass = "12345";

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

        WebElement incorrectLogin = driver.findElement(By.className("errortext"));

        String actualLogInFail = incorrectLogin.getText();
        String expectedLogInFail = "Incorrect login or password";

        if (actualLogInFail.equals(expectedLogInFail)){
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        driver.quit();

    }

}

