package us.travomint.com;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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


public class oneWay {

	public static String verifiedOneWay(WebDriver driver, String from, String to) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		try {
			System.out.println("One Way");
			System.out.println("Maximize the currnet window. ");
			driver.manage().window().maximize();
			System.out.println("");

			// Open us.travomint URL
			System.out.println("Opening travomint US url: ");
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

			// Trip type selection

			WebElement tripType = driver.findElement(By
					.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div[1]/div[2]/div[2]/div[1]/label[1]"));
			tripType.click();
			String tripSelection = tripType.getText();
			System.out.println("Current selected trip type is: " + tripSelection);

			Thread.sleep(2000);

			// From Route

			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[1]"))
					.click();
			driver.findElement(By.id("from")).sendKeys(from);
			Thread.sleep(2000);

			// Select from
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[3]/div/div"))
					.click();

			// From AITA code

			WebElement f1 = driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[2]/span"));
			String fWidget = f1.getText();
			System.out.println("Actual data: " + fWidget);
			String fromWidget = fWidget.replace(",", "");
			System.out.println("After trim from is: " + fromWidget);

			// To Destination

			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div"))
					.click();
			driver.findElement(By.name("to")).sendKeys(to);
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[1]"))
					.click();

			WebElement t1 = driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/span"));
			String tWidget = t1.getText();
			System.out.println("Actual to section " + tWidget);
			String toWidget = tWidget.replaceAll(",", "");
			System.out.println("After trim : " + toWidget);

			// Calendar selection

			WebElement Calender = driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div"));
			Calender.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/div[1]/div/button[2]"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/td[2]"))
					.click();
			System.out.println("From Date Successfully Selected.");

			WebElement date = driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div/div[1]/div"));
			String departDate = date.getText();

			// Travelers & class

			WebElement travelerW = driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[4]/div/div[1]/div"));
			String travelWidgett = travelerW.getText();
			String travelWidgettt = travelWidgett.replace("Traveller(s) & Class", "");
			String travelerAndClassOnWidget = travelWidgettt.replace("Traveller", "Traveller,");
			System.out.println("Widget travelers: " + travelerAndClassOnWidget);
			Thread.sleep(4000);

			// Click on search button
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[4]/div/div[2]/button"))
					.click();
			long startTime = System.currentTimeMillis();
			Thread.sleep(3000);

			// Result on lisitng page

			// Trip type on Listing page

			WebElement tripTypeListing = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div[2]/label/span"));
			String listingTripType = tripTypeListing.getText();
			System.out.println("Selected trip type on listing page from widget: " + listingTripType);

			// From
			WebElement f2 = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[1]/div[1]/div[2]/span"));
			String fListing = f2.getText();
			System.out.println("Actual from on Listing: " + fListing);
			String fromOnListing = fListing.replace(",", "");
			System.out.println("New from on listing after replaceing: " + fromOnListing);

			// To
			WebElement t2 = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[2]/div/div[2]/span"));
			String toListing = t2.getText();
			System.out.println("Actual To on listing page: " + toListing);
			String toOnListingPage = toListing.replace(",", "");
			System.out.println("TO on listing after modify: " + toOnListingPage);

			// Currency on Listing page

			WebElement listingCurrency = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div/header/div[2]/nav/div[2]/b"));
			String currencyOnListing = listingCurrency.getText();

			System.out.println("Curreny visible on listing page: " + currencyOnListing);

			// Comparing currency

			Map<String, String> currencyMapping = new HashMap<>();
			currencyMapping.put("$ United States Dollar", "USD");
			String comparingCurrency = currencyMapping.getOrDefault(curr, curr);
			if (comparingCurrency.equals(currencyOnListing)) {
				System.out.println("Currency are now equal!");
			} else {
				System.out.println("Currency are different.");
			}
			System.out.println("Updated currecny on widget: " + comparingCurrency);
			System.out.println("Currecny on Listing: " + currencyOnListing);

			// Compare from (Widget and Listing)

			if (fromWidget.equals(fromOnListing)) {
				System.out.println(
						"Widget and Listing From are same  " + "[" + fromWidget + "], " + "[" + fromOnListing + "]");
			} else {
				System.out.println("Widget and Listing From are not same.  ");
			}

			// Compare To (Widget and Listing)
			if (toWidget.equals(toOnListingPage)) {
				System.out.println(
						"Widget and Listing To are same   " + "[" + toWidget + "], " + "[" + toOnListingPage + "]");
			} else {
				System.out.println("Widget and Listing To are not same.  ");
			}

			// Date of Departure Date

			WebElement CalenderM = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[3]/div/div[1]/div/div[1]/div"));
			String departDateOnListing = CalenderM.getText();

			if (departDate.equals(departDateOnListing)) {
				System.out.println("Widget and Listing Date are same   " + departDate + " " + departDateOnListing);
			} else {
				System.out.println("Date is not same ");
			}

			// Traveler & Class

			WebElement TravelersM = driver
					.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[4]/div/div[1]/div"));
			String travelerModifiedd = TravelersM.getText();
			String travelerModifieddd = travelerModifiedd.replace("Traveller(s) & Class", "");
			String travelerAndClassOnListing = travelerModifieddd.replace("Traveller", "Traveller,");
			System.out.println("Travelers on listing: " + travelerAndClassOnListing);

			if (travelerAndClassOnWidget.equals(travelerAndClassOnListing)) {
				System.out.println("Traveler is matched: " + travelerAndClassOnListing);
			} else {
				System.out.println("Traveler is not Matched");
			}

			String availableAirlinesOnListing = "";
			String returnDateWidget = "NA";
			String returnDateOnListing = "NA";
			try {
				WebElement Show = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("/html/body/div[1]/div/div/div/section/div/div/div[1]/div/div[2]/aside/div/div[2]")));
				String flightFilter = Show.getText();

				if (flightFilter.isEmpty()) {
					System.out.println("No flights found.");
				} else {
					System.out.println("availableAirlinesOnListing " + flightFilter);

					availableAirlinesOnListing = flightFilter.replace("$", "USD");
					String[] arr = flightFilter.split(" ");
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
						availableAirlinesOnListing = entry.getValue();
						System.out.println("availableAirlinesOnListing: " + availableAirlinesOnListing);
					}
				}
			} catch (NoSuchElementException e) {
				System.out.println("Flight not found.");

				availableAirlinesOnListing = "NA";
			} catch (TimeoutException e) {
				System.out.println("Element not found within the specified timeout.");
				availableAirlinesOnListing = "NA";
			}

			long endTime = System.currentTimeMillis();
			double searchTimee = (endTime - startTime) / 1000.0;
			String searchTime = String.format("%.2f", searchTimee);
			System.out.println("Flight Search Time: " + searchTime);
			
			Result result = new Result();
			result.setAvailableCurrencyOnWidget(availableCurrencyOnWidget);
			result.setTripSelection(tripSelection);
			result.setFromWidget(fromWidget);
			result.setTOWidget(toWidget);
			result.setDepartDate(departDate);
			result.setReturnDateWidget(returnDateWidget);
			result.setTravelerAndClassOnWidget(travelerAndClassOnWidget);
			result.setCurrencyOnListing(currencyOnListing);
			result.setListingTripType(listingTripType);
			result.setFromOnListing(fromOnListing);
			result.setToOnListingPage(toOnListingPage);
			result.setDepartDateOnListing(departDateOnListing);
			result.setReturnDateOnListing(returnDateOnListing);
			result.setTravelerAndClassOnListing(travelerAndClassOnListing);
			result.setAvailableAirlinesOnListing(availableAirlinesOnListing);
			result.setsearchTime(searchTime);
			return result.toString();
			
		} finally {
			
			System.out.println("---------------------------Route Searched successfully.---------------------------");
		}

	}

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
		String fromName = "us.travomint.com report"; // Custom display name
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
