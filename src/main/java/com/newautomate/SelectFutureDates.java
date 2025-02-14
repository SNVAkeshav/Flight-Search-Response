package com.newautomate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SelectFutureDates {
	public static void main(String[] args) throws InterruptedException {
		// Set up WebDriver
		System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.travomint.com/"); // Replace with actual site if different
		// Calendar selection

		WebElement Calender = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div"));
		Calender.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/div[1]/div/button[2]"))
				.click();
		Thread.sleep(3000);

		// Date selection

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/td[5]"))
				.click();
		System.out.println("From Date Successfully Selected.");

		WebElement date = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div/div[1]/div"));
		String departDate = date.getText();
		Thread.sleep(4000);

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[4]/div/div[2]/button"))
				.click();
		
		Thread.sleep(6000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.clear(); window.sessionStorage.clear();");
        driver.manage().deleteAllCookies();
        System.out.println("Website cache cleared successfully!");

        // Reload the page after clearing cache
        driver.navigate().refresh();

	}
}
