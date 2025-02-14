package com.travomint;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class openBrowser {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Open the travomint URL for 1st route");

		// First route

		driver.get("https://us.travomint.com/");
		
		String title = driver.getTitle();
		System.out.println("The website title is: " + title);
		
		Thread.sleep(3000);
		
		WebElement clickOnCurrency = driver
				.findElement(By.xpath("/html/body/div[1]/div/header/nav/div/ul/li[2]/div[2]/button/div/div"));
		clickOnCurrency.click();
		
		Thread.sleep(2000);
		
		WebElement selectCurrency = driver.findElement(
				By.xpath("/html/body/div[1]/div/header/nav/div/ul/li[2]/div[2]/div/div/div/div/button/span/span"));
		String curr = selectCurrency.getText();
		System.out.println("Available currency: " + curr);
		String availableCurrencyOnWidget = curr.replace("$", "USD");
		System.out.println("Currency after modification: " + availableCurrencyOnWidget);
		selectCurrency.click();
	}

}
