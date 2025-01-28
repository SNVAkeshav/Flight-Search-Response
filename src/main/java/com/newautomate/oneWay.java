package com.newautomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class oneWay {

    public static void main(String[] args) {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Maximize the current window
        driver.manage().window().maximize();
        
        // Open the Travomint URL
        driver.get("https://www.travomint.com/");
        
        // Locate the date picker element (You may need to update this xpath to match the exact element for date selection)
        WebElement dateField = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div"));  // Example XPath (update with the correct one)

        // Set the date in dd/mm/yyyy format
        String date = "28/01/2025"; // Example date
        
        // Send the date to the date input field
        dateField.sendKeys(date);

        // Optionally, you can verify that the correct date was set by getting the value of the input field
        String selectedDate = dateField.getAttribute("value");
        System.out.println("Selected Date: " + selectedDate);
    }
}
