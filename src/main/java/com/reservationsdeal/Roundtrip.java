package com.reservationsdeal;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Roundtrip {
	@SuppressWarnings("unused")
	public static String executeRoundData(WebDriver driver, String from, String to) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			System.out.println("Round Trip");
			driver.manage().window().maximize();
			// Open the Reservationsdeal.com Website
			driver.get("https://www.reservationsdeal.com/");

			// Print the title of the website
			String title = driver.getTitle();
			System.out.println("The title of the website is " + title);
			
           Thread.sleep(3000);;
//			Select Currency 
			WebElement selectCurrency = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/nav/div/div[3]/div/button/img")));
			selectCurrency.click();

			Thread.sleep(2000);
			js.executeScript("window.scrollBy(5, 900);");
			WebElement currency = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/div/nav/div/div[3]/div/ul/li[1]/div/div")));
			currency.click();
			String curr = currency.getText();
			String availableCurrencyOnWidget = curr.replaceAll(curr, "USD");
			System.out.println("Currency " + availableCurrencyOnWidget);
			Thread.sleep(3000);

			// Wait for and select Round-way trip type

			WebElement Roundtrip = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/form/div/div/div/div/div[1]/label[1]")));
			js.executeScript("arguments[0].click();", Roundtrip);


			String tripType = Roundtrip.getText();

			System.out.println("Trip type selected: " + tripType);

			Thread.sleep(3000);
			// Select "From" destination
			WebElement fromInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[4]/div[2]/div/div[2]/div/form/div/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/input")));
			fromInput.click();
			fromInput.sendKeys(from);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[4]/div[2]/div/div[2]/div/form/div/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/ul/li/div[1]")))
					.click();

			System.out.println("From Destination Input");

			// Select "To" destination
			WebElement toInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[4]/div[2]/div/div[2]/div/form/div/div/div/div/div[2]/div[1]/div[3]/div/div/div/input")));
			toInput.click();
			toInput.sendKeys(to);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"/html/body/div[4]/div[2]/div/div[2]/div/form/div/div/div/div/div[2]/div[1]/div[3]/div/div/div/ul/li[1]/div[1]")))
					.click();

			System.out.println("To Destination Input");

			// Calendar Select (Travel Date)
			WebElement datePicker = wait.until(ExpectedConditions.elementToBeClickable(By.name("departDate")));
			datePicker.click();

			js.executeScript("window.scrollBy(0, 180);");
			Thread.sleep(1000);

			List<String> xpaths = Arrays.asList("/html/body/section[7]/div/div[2]/section[2]/div[3]/div[22]",
					"/html/body/section[7]/div/div[2]/section[2]/div[3]/div[23]",
					"/html/body/section[7]/div/div[2]/section[2]/div[3]/div[24]",
					"/html/body/section[7]/div/div[2]/section[2]/div[3]/div[26]",
					"/html/body/section[7]/div/div[2]/section[2]/div[3]/div[28]");
			Collections.shuffle(xpaths);

			for (String xpath : xpaths) {
				try {
					WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
					dateElement.click();

					// List of possible return dates (XPaths)
					List<String> xpathsr = Arrays.asList("/html/body/section[7]/div/div[2]/section[2]/div[3]/div[29]",
							"/html/body/section[7]/div/div[2]/section[2]/div[3]/div[30]",
							"/html/body/section[7]/div/div[2]/section[2]/div[3]/div[31]",
							"/html/body/section[7]/div/div[2]/section[2]/div[3]/div[32]"

					);
					Collections.shuffle(xpathsr);

					for (String xpath1 : xpathsr) {
						try {
							WebElement returnDate = wait
									.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath1)));
							returnDate.click();
							break;
						} catch (Exception e) {
							System.out.println("Return date not found or clickable: " + xpath1);
						}
					}
					break;
				} catch (Exception e) {
					System.out.println("Departure date not found or clickable: " + xpath);
				}
			}

			// Scroll down

			js.executeScript("window.scrollBy(4, 380);");

			// After clicking the "Done" button
			WebElement Done = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/form/div/div/div/div"))));
			js.executeScript("arguments[0].click();", Done);

			System.out.println("Clicked Banner");

			// Fetch From and To destinations, and Travel Date for validation
			WebElement fromCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[4]/div[2]/div/div[2]/div/form/div/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/input")));
			String fromWidget = fromCheck.getAttribute("value");
			System.out.println(fromWidget);

			WebElement toCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[4]/div[2]/div/div[2]/div/form/div/div/div/div/div[2]/div[1]/div[3]/div/div/div/input")));
			String toWidget = toCheck.getAttribute("value");
			System.out.println(toWidget);

			WebElement dateCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[4]/div[2]/div/div[2]/div/form/div/div/div/div/div[2]/div[2]/div[1]/div/input")));
			String departDate = dateCheck.getAttribute("value");
			System.out.println(departDate);

			WebElement ReturnDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[4]/div[2]/div/div[2]/div/form/div/div/div/div/div[2]/div[2]/div[2]/div/div/input")));
			String returnDateWidget = ReturnDate.getAttribute("value");
			System.out.println(returnDateWidget);

			WebElement travelers = wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("/html/body/div[4]/div[2]/div/div[2]/div/form/div/div/div/div/div[2]/div[3]/div/div[1]/p")));
			String travelerAndClassOnWidget = travelers.getText();
			System.out.println("Travellers and Class : " + travelerAndClassOnWidget);

			// Click the "Search" button
			WebElement searchbutton = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/form/div/div/div/div/div[2]/div[4]/button")));
			js.executeScript("arguments[0].click();", searchbutton);

			long startTime = System.currentTimeMillis();

			// Wait for a while to observe the result
			Thread.sleep(5000);

//	      Available currency on listing page:

			WebElement selectCurrencyListing = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div[1]/div/div/nav/div/div[3]/div/button/span")));
			selectCurrencyListing.click();
			Thread.sleep(2000);
			WebElement currencyonlisting = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div[1]/div/div/nav/div/div[3]/div/ul/li[1]/div/div")));
			String currencylisting = currencyonlisting.getText();
			String currencyOnListing = currencylisting.replace(currencylisting, "USD");
			currencyonlisting.click();
			System.out.println("Currency " + currencyOnListing);

			WebElement RoundWayListing = driver
					.findElement(By.xpath("/html/body/main/div[2]/form/div/div[2]/div[1]/div/label[1]/span"));
			String tripTypeOnListing = RoundWayListing.getText();

			// Compare the From route input to listing
			WebElement ListingFrom = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/main/div[2]/form/div/div[2]/div[2]/div[1]/div/input")));
			String fromOnListing = ListingFrom.getAttribute("value");

			if (fromWidget.equals(fromOnListing)) {
				System.out.println("From Route is same  " + "[" + fromOnListing + "]");
			} else {
				System.out.println("Not the Same Route  ");
			}

			// Compare the to route input and listing
			WebElement ListingTo = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/main/div[2]/form/div/div[2]/div[2]/div[2]/div/input")));
			String toOnListingPage = ListingTo.getAttribute("value");

			if (toWidget.equals(toOnListingPage)) {
				System.out.println("To Route is same  " + "[" + toOnListingPage + "]");
			} else {
				System.out.println("Not the Same Route  ");
			}

//          Compare to travel date input to Listing
			WebElement DateListing = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/main/div[2]/form/div/div[2]/div[3]/div[1]/div[1]/div/input")));
			String departDateOnListing = DateListing.getAttribute("value");

			if (departDate.equals(departDateOnListing)) {
				System.out.println("Travel date is same  " + "[" + departDateOnListing + "]");
			} else {
				System.out.println("Travel date is not same  ");
			}

			WebElement ReturnDateListing = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/main/div[2]/form/div/div[2]/div[3]/div[1]/div[2]/div/div/input")));
			String returnDateOnListing = ReturnDateListing.getAttribute("Value");

//   Compare Traveller's & class Home and Listing 
			WebElement Travelers = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/main/div[2]/form/div/div[2]/div[3]/div[1]/div[3]/div/div/div/div[1]/p")));
			String travelerAndClassOnListing = Travelers.getText();
			System.out.println(travelerAndClassOnListing);
			if (travelerAndClassOnWidget.equals(travelerAndClassOnListing)) {
				System.out.println("Travellers and Class Matched ");
			} else {
				System.out.println("Travellers and class not Matched ");
			}

			String availableAirlines = "No results";
			try {
				WebElement Show = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("/html/body/main/div[3]/div/div[1]/div[2]/div/div[2]/div[6]/div/div[2]")));
				availableAirlines = Show.getText();

				if (availableAirlines.isEmpty()) {
					System.out.println("No flights found in case of no flights search result found.");
				} else {
					if (availableAirlines.endsWith("Show More")) {
						availableAirlines = availableAirlines.substring(0, availableAirlines.lastIndexOf("Show More"))
								.trim();
						System.out.println("availableAirlines before trimming: " + availableAirlines);
						String[] arr = availableAirlines.split(" ");
						List<String> newArr = new ArrayList<>();
						for (String word : arr) {
							newArr.add(word.replace(",", ""));
						}
						int term = 1;
						Map<Integer, String> obj = new HashMap<>();
						for (String word : newArr) {
							if (obj.containsKey(term)) {
								obj.put(term, obj.get(term) + " " + word);
							} else {
								obj.put(term, word);
							}
							try {
								Double.parseDouble(word); // Parse to check if it's a number
								term++;
							} catch (NumberFormatException e) {
								// Do nothing if it's not a number
							}
						}
						for (Map.Entry<Integer, String> entry : obj.entrySet()) {
							availableAirlines = entry.getValue();
							System.out.println("availableAirlinesOnListing: " + availableAirlines);
						}
					}
				}
			} catch (NoSuchElementException e) {
				// Handle the case where the element is not found
				System.out.println("Flight listing not found, proceeding to the next case.");
				availableAirlines = "Flight not found"; // Or set it to a default value, depending on your next case.
			} catch (TimeoutException e) {
				// Handle timeout if the element is not found within the given wait time
				System.out.println("Timeout: Flight listing not found, proceeding to the next case.");
				availableAirlines = "Flight not found"; // Or set it to a default value, depending on your next case.
			}

			long endTime = System.currentTimeMillis();
			double searchTimee = (endTime - startTime) / 1000.0;
			String searchTime = String.format("%.2f", searchTimee);
			System.out.println("Flight Search Time: " + searchTime);

			Results result = new Results();
			result.setAvailableCurrencyOnWidget(availableCurrencyOnWidget);
			result.setTripSelection(tripType);
			result.setFromWidget(fromWidget);
			result.setTOWidget(toWidget);
			result.setDepartDate(departDate);
			result.setReturnDateWidget(returnDateWidget);
			result.setTravelerAndClassOnWidget(travelerAndClassOnWidget);
			result.setCurrencyOnListing(currencyOnListing);
			result.setListingTripType(tripTypeOnListing);
			result.setFromOnListing(fromOnListing);
			result.setToOnListingPage(toOnListingPage);
			result.setDepartDateOnListing(departDateOnListing);
			result.setReturnDateOnListing(returnDateOnListing);
			result.setTravelerAndClassOnListing(travelerAndClassOnListing);
			result.setAvailableAirlinesOnListing(availableAirlines);
			result.setSearchTime(searchTime);
			return result.toString();

		} finally {
			// Close the browser after the task
			// driver.quit();
			System.out.println(
					"---------------------------Reservationsdeal  Searched successfully.---------------------------");
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
