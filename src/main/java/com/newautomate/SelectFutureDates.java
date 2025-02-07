package com.newautomate;

import org.openqa.selenium.By;
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

		// Click on the date picker to open the calendar
		driver.findElement(By.id("departure")).click(); // Update with actual datepicker ID or XPath
		Thread.sleep(2000); // Wait for calendar to open

        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define the format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        // Format the date and time
        String formattedDateTime = currentDateTime.format(formatter);

        // Print the current date and time
        System.out.println("Current Date and Time: " + formattedDateTime);
		// Get the current date
		LocalDate currentDate = LocalDate.now();
		System.out.println("currentDate "+ currentDate);
		int[] daysToAdd = { 5, 10, 15, 20 };

		for (int days : daysToAdd) {
			LocalDate futureDate = currentDate.plusDays(days);
			System.out.println("futureDate " + futureDate);
			int day = futureDate.getDayOfMonth(); // Extract day (e.g., 10, 15, etc.)
			System.out.println("day " + day);

			// Find the date in the calendar and click
			List<WebElement> dates = driver.findElements(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/td[6]")); // Update
				
			//System.out.println("dates " + dates);																																// XPath
			for (WebElement date : dates) {
				if (date.getText().equals(String.valueOf(day))) {
					date.click();
					System.out.println("Selected Date: " + futureDate);
					Thread.sleep(1000); // Small delay between selections
					break;
				}
			}
		}

		// Close browser
		//driver.quit();
	}
}
