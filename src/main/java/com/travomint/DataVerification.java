package com.travomint;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataVerification {

	@SuppressWarnings("unused")
	public static String executeVerifiedData(WebDriver driver, String from, String to) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		try {

			// Maximize the browser window  
			
			

			System.out.println("Maximize the current window");
			driver.manage().window().maximize();
			System.out.println(" ");

			// Open the Travomint website for the first route

			System.out.println("Open the Travomint URL");
			driver.get("https://www.travomint.com/");

			// Print the title of the website

			String title = driver.getTitle();
			System.out.println("The title of the Website is: " + title);

			Thread.sleep(3000);

			WebElement clickOnCurrency = driver
					.findElement(By.xpath("/html/body/div[1]/div/header/nav/div/ul/li[3]/div[2]/button/div/div"));
			clickOnCurrency.click();

			Thread.sleep(2000);

			WebElement selectCurrency = driver.findElement(
					By.xpath("/html/body/div[1]/div/header/nav/div/ul/li[3]/div[2]/div/div/div/div[1]/button/span"));
			String curr = selectCurrency.getText();
			System.out.println("Available currency: " + curr);
			String availableCurrencyOnWidget = curr.replaceAll(curr, "INR");

			System.out.println("Currency after modification: " + availableCurrencyOnWidget);
			selectCurrency.click();

//            String currencyText = curr.trim();
//            String convertedCurrency = "";
//            if (currencyText.contains("₹")) {
//                convertedCurrency = currencyText.replace("₹ Indian Rupee", "INR").trim();
//            }
//
//            String expectedCurrency = "INR";
//            if (convertedCurrency.equalsIgnoreCase(expectedCurrency)) {
//                System.out.println("The currency has been correctly converted to INR.");
//            } else {
//                System.out.println("The currency is incorrect. Expected: INR, but found: " + convertedCurrency);
//            }
//
//            System.out.println("Home Page Selected Currency: " + convertedCurrency);
//            
//            Thread.sleep(3000);
//          

			// Trip type selection

			WebElement tripType = driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[1]/label[1]/span[2]"));
			String tripSelection = tripType.getText();
			System.out.println("Current selected trip type is: " + tripSelection);

			Thread.sleep(2000);

			// First Route

			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[2]"))
					.click();
			// driver.findElement(By.id("from")).sendKeys("BLR");
			driver.findElement(By.id("from")).sendKeys(from);
			Thread.sleep(2000);

			// From widget selection

			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[3]/div/div[1]"))
					.click();
//            WebElement C1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/span"));
//            String text1 = C1.getText();

			WebElement f1 = driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/span"));
			String fWidget = f1.getText();
			System.out.println("Actual data: " + fWidget);
			String fromWidget = fWidget.replace(",", "");
			System.out.println("After trim from is: " + fromWidget);
			// System.out.println("Widget -> From : " + text1);

			// To Destination

			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[1]"))
					.click();
			// driver.findElement(By.name("to")).sendKeys("DEL");
			driver.findElement(By.name("to")).sendKeys(to);
			Thread.sleep(2000);

			// To widget selection using xpath

			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[1]/div[1]"))
					.click();
//            WebElement fromW = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[1]/span"));
//            String toWidget = fromW.getText();

			WebElement t1 = driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[2]/span"));
			String tWidget = t1.getText();
			System.out.println("Actual to section " + tWidget);
			String toWidget = tWidget.replaceAll(",", "");
			System.out.println("After trim : " + toWidget);

			// System.out.println("Widget -> To : " + toWidget);

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
			String CalenderWidget = date.getText();

			// From Widget xpath using comparison

			// Travelers & class

			WebElement travelerW = driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[4]/div/div[1]/div"));
			String travelWidgett = travelerW.getText();
			String travelWidgettt = travelWidgett.replace("Traveler(s) & Class", "");
			String travelWidget = travelWidgettt.replace("Traveler", "Traveler,");
			System.out.println("Widget travelers: " + travelWidget);

			// Search Button Clicked

			Thread.sleep(4000);

			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[4]/div/div[2]/button"))
					.click();
			long startTime = System.currentTimeMillis();
			Thread.sleep(3000);

			// From on listing page

//             WebElement C2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[1]/div[1]/div[1]/span"));
//            String text2 = C2.getText();
//            System.out.println("Listing -> From : " + text2);

			WebElement f2 = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[1]/div[1]/div[2]/span"));
			String fListing = f2.getText();
			System.out.println("Actual from on Listing: " + fListing);
			String fromOnListing = fListing.replace(",", "");
			System.out.println("New from on listing after replaceing: " + fromOnListing);

			// Trip type on Listing page

			WebElement tripTypeListing = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div[2]/label/span"));
			String listingTripType = tripTypeListing.getText();
			System.out.println("Selected trip type on listing page from widget: " + listingTripType);

			// Currency on Listing page

			WebElement listingCurrency = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div/header/div/nav/div[2]/b"));
			String currencyOnListing = listingCurrency.getText();
			System.out.println("Curreny visible on listing page: " + currencyOnListing);

			// Comparing currency

			Map<String, String> currencyMapping = new HashMap<>();
			currencyMapping.put("₹ Indian Rupee", "INR");
			String comparingCurrency = currencyMapping.getOrDefault(curr, curr);
			if (comparingCurrency.equals(currencyOnListing)) {
				System.out.println("Currency are now equal!");
			} else {
				System.out.println("Currency are different.");
			}
			System.out.println("Updated currecny on widget: " + comparingCurrency);
			System.out.println("Currecny on Listing: " + currencyOnListing);

			// Compare the two route texts

			if (fromWidget.equals(fromOnListing)) {
				System.out.println(
						"Widget and Listing From are same  " + "[" + fromWidget + "], " + "[" + fromOnListing + "]");
			} else {
				System.out.println("Widget and Listing From are not same.  ");
			}

			// TO on listing page

//            WebElement fromM = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[2]/div/div[1]/span"));
//            String FromDestination = fromM.getText();
//            System.out.println("Listing page To Destination :" + FromDestination);

			WebElement t2 = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[2]/div/div[2]/span"));
			String toListing = t2.getText();
			System.out.println("Actual To on listing page: " + toListing);
			String toOnListingPage = toListing.replace(",", "");
			System.out.println("TO on listing after modify: " + toOnListingPage);

			if (toWidget.equals(toOnListingPage)) {
				System.out.println(
						"Widget and Listing To are same   " + "[" + toWidget + "], " + "[" + toOnListingPage + "]");
			} else {
				System.out.println("Widget and Listing To are not same.  ");
			}

			// Date of Departure Date

			WebElement CalenderM = driver.findElement(
					By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[3]/div/div[1]/div/div[1]/div"));
			String CalenderModified = CalenderM.getText();

			if (CalenderWidget.equals(CalenderModified)) {
				System.out.println("Widget and Listing Date are same   " + CalenderWidget + " " + CalenderModified);
			} else {
				System.out.println("Date is not same ");
			}

			// Traveler & Class

			WebElement TravelersM = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[4]/div/div[1]/div"));
			String travelerModifiedd = TravelersM.getText();
			String travelerModifieddd = travelerModifiedd.replace("Traveler(s) & Class", "");
			String travelerModified = travelerModifieddd.replace("Traveler", "Traveler,");

			System.out.println("Travelers on listing: " + travelerModified);

			if (travelWidget.equals(travelerModified)) {
				System.out.println("Traveler is matched: " + travelerModified);
			} else {
				System.out.println("Traveler is not Matched");
			}

			// Wait for results to load

			// Thread.sleep(20000);

			// Flight availability check

			String airlinespriceSymbol = "";
			String firstPriceShowing = "";
			try {
				// Wait until the filter for airlines is visible and retrieve its text
				WebElement filterAirlines = wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div[1]/div[2]/div/aside/div/div[5]/div")));

				String flightFilter = filterAirlines.getText(); // Trim any extra spaces
				airlinespriceSymbol = flightFilter.replace("₹", "INR"); // Replace ₹ with INR

				// Wait for the first price element to be visible and retrieve its text
				WebElement firstPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/html/body/div[1]/div/div/div/div[3]/div/div/div[2]/div[6]/div[1]/div/div/div[3]/div[1]/div/span[1]")));
				String firstShow = firstPrice.getText();
				firstPriceShowing = firstShow.replace("₹", "INR"); // Trim spaces here too

			} catch (NoSuchElementException | TimeoutException e) {
				// Catch the NoSuchElementException and TimeoutException
				System.out.println("Flight not found: " + e.getMessage());
			} catch (Exception e) {
				// Catch any other unexpected exceptions and log them
				System.out.println("An unexpected error occurred: " + e.getMessage());
			}

			// Print outside the try-catch block
			if (!airlinespriceSymbol.isEmpty()) {
				if (airlinespriceSymbol.contains("INR")) {
					System.out.println("The currency has been successfully converted to INR: " + airlinespriceSymbol);
				} else {
					System.out.println("The currency was not in INR format, found: " + airlinespriceSymbol);
				}
			} else {
				System.out.println("Currency information is not available.");
			}
			if (!firstPriceShowing.isEmpty()) {
				System.out.println("First Airline Price: " + firstPriceShowing);
			} else {
				System.out.println("First Airline Price is not available.");
			}

			String totalShowing = "No results";

			try {
				// WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement Show = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div[2]/div[5]/div")));
				totalShowing = Show.getText();

				if (totalShowing.isEmpty()) {
					System.out.println("No flights found.");
				} else {
					System.out.println(totalShowing);
				}
			} catch (NoSuchElementException e) {
				System.out.println("Flight not found.");
				totalShowing = "Flight not found"; // Setting a default value when flight isn't found

//        		driver.switchTo().newWindow(WindowType.TAB);
//        		//SecondRoute.executeSecondRoute(driver, from, to);
//        		DataVerification.executeVerifiedData(driver, from, to);
			} catch (TimeoutException e) {
				System.out.println("Element not found within the specified timeout.");
				totalShowing = "Flight not found"; // Timeout occurred, set the default message

//        		driver.switchTo().newWindow(WindowType.TAB);
//        		//SecondRoute.executeSecondRoute(driver, from, to);
//        		DataVerification.executeVerifiedData(driver, from, to);

			}
			long endTime = System.currentTimeMillis();
			double searchTimee = (endTime - startTime) / 1000.0;
			String searchTime = String.format("%.2f", searchTimee);
			System.out.println("Flight Search Time: " + searchTime);

			WebElement fareAlert = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/button[2]")));
			System.out.println("fare alert pop up removed successfully. ");

			// Create Result object and called all the values
			Result result = new Result();
//            result.setTitle(title);
			result.setAvailableCurrencyOnWidget(availableCurrencyOnWidget);
			result.setTripSelection(tripSelection);
			result.setFromWidget(fromWidget);
			result.setTOWidget(toWidget);
			result.setCalenderWidget(CalenderWidget);
			result.setTravelerWidget(travelWidget);
			result.setCurrencyOnListing(currencyOnListing);
			result.setListingTripType(listingTripType);
			result.setFromOnListing(fromOnListing);
			result.setToOnListingPage(toOnListingPage);
			result.setTotalShowing(totalShowing);
			result.setCalenderModified(CalenderModified);
			result.settravelerModified(travelerModified);
			result.setAirlinespriceSymbol(airlinespriceSymbol);
			result.setFirstPriceShowing(firstPriceShowing);
			result.setsearchTime(searchTime);
			return result.toString();

		} finally {
			// Close the browser after the task
			// driver.quit();
			System.out.println("---------------------------Route Searched successfully.---------------------------");
		}

	}

	// Method to send an email using SMTP

	public static void sendEmail(String to, String cc, String bcc, String subject, String body)
			throws MessagingException, UnsupportedEncodingException {
		final String from = "automation@travomint.com";
		final String password = "Travomint@1234"; // Replace with your email password or use environment variables
		if (from == null || password == null) {
			System.err.println("Email credentials are missing.");
			return;
		}
		String host = "smtp.gmail.com";
		int port = 587;

		// Set up the SMTP server properties

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// Create a session with authentication

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		// Create the email message

		Message message = new MimeMessage(session);
		String fromName = "Automated Report"; // Custom display name
		message.setFrom(new InternetAddress(from, fromName));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
		message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));
		message.setSubject(subject);
		// message.setText(body);
		message.setContent(body, "text/html");
		// Send the email
		Transport.send(message);
		System.out.println("Email sent successfully to these emails: " + to + ", " + cc + ", " + bcc);
	}
}
