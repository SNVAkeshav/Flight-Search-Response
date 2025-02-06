package com.travomint;

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

public class RoundTripVerification {
	public static String executeVerifiedDataRoundTrip(WebDriver driver, String from, String to)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		try {
			// Maximize the browser window
			System.out.println("Maximize the current window");
			driver.manage().window().maximize();
			System.out.println(" ");
			// Open the Travomint website
			System.out.println("Open the Travomint URL");
			driver.get("https://www.travomint.com/");
			System.out.println("The title of the Website is: " + driver.getTitle());

			Thread.sleep(3000);

			// Handling currency selection
			WebElement clickOnCurrency = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/header/nav/div/ul/li[3]/div[2]/button/div/div")));
			clickOnCurrency.click();

			Thread.sleep(2000);

			WebElement selectCurrency = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/header/nav/div/ul/li[3]/div[2]/div/div/div/div[1]/button/span")));
			String curr = selectCurrency.getText();
			System.out.println("Available currency: " + curr);
			String availableCurrencyOnWidget = curr.replaceAll(curr, "INR"); // Assuming INR is the desired currency

			System.out.println("Currency after modification: " + availableCurrencyOnWidget);
			selectCurrency.click();

			// Select round-trip option
			WebElement tripType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[1]/label[2]/span[2]")));
			tripType.click();
			String tripSelection = tripType.getText();

			System.out.println("Current selected trip type is: " + tripSelection);
			Thread.sleep(2000);

			// From location
			WebElement fromField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[2]")));
			fromField.click();
			driver.findElement(By.id("from")).sendKeys(from);
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[3]/div/div[1]"))
					.click();

			// Wait for the 'From' widget element and process data
			WebElement f1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/span")));
			String fWidget = f1.getText();
			System.out.println("Actual data (from): " + fWidget);
			String fromWidget = fWidget.replace(",", "");
			System.out.println("After trim: " + fromWidget);

			// To Destination
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[1]"))
					.click();
			// driver.findElement(By.name("to")).sendKeys("DEL");
			driver.findElement(By.name("to")).sendKeys(to);
			Thread.sleep(2000);

			// To widget selection

			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[1]/div[1]"))
					.click();
			// Wait for the 'To' widget element and process data

			WebElement t1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[2]/span")));
			String tWidget = t1.getText();
			System.out.println("Actual data (to): " + tWidget);
			String toWidget = tWidget.replace(",", "");
			System.out.println("After trim: " + toWidget);

			// Calendar Selection

			WebElement Calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div")));
			Calendar.click();
			Thread.sleep(2000);
			WebElement SideArrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/div[2]/div/button[2]")));
			SideArrow.click();
			Thread.sleep(3000);

			// Date selection

			WebElement DateselectDepart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/div[3]/table/tbody/tr[2]/td[2]")));
			DateselectDepart.click();

			Thread.sleep(2000);

			WebElement DateSelectReturn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/div[3]/table/tbody/tr[3]/td[4]")));
			DateSelectReturn.click();

			Thread.sleep(2000);

//        GetData DepartDate and Return date 
			WebElement departDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div/div[1]/div")));
			String departDatewidget = departDate.getText();
			System.out.println("departDatewidget " + departDatewidget);

			WebElement returnDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div[1]/div")));
			String returnDatewidget = returnDate.getText();
			System.out.println("returnDatewidget " + returnDatewidget);

//        Traveler & class 
			WebElement TravelersWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[4]/div/div[1]/div/div[1]/div")));
			String travelWidgett = TravelersWidget.getText();
			String travelWidgettt = travelWidgett.replace("Traveler(s) & Class", "");
			String travelWidget = travelWidgettt.replace("Traveler", "Traveler,");
			System.out.println("Widget travelers: " + travelWidget);
			Thread.sleep(4000);
			
			
			// Wait for the search button to be visible and click it
			WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[4]/div/div[2]/button")));
			searchButton.click();
			
			long startTime = System.currentTimeMillis();
			
//From on listing
			WebElement FromListing = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[1]/div[1]/div[2]/span")));
			String fromListing = FromListing.getText();
			System.out.println("From Listing Result :" + fromListing);
		
			String fromOnListing = fromListing.replace(",", "");
			System.out.println("After trim: " + fromOnListing);
	
			//To On listing
			
			WebElement ToListing = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[2]/div/div[2]/span")));
			String toListing = ToListing.getText();
			System.out.println("To Listing Result :" + toListing);
			String toOnListingPage = toListing.replace(",", "");
			System.out.println("After trim: " + toOnListingPage);

			WebElement DepartDatelisting = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[3]/div/div[1]/div/div[1]/div")));
			String departDateListing = DepartDatelisting.getText();
			System.out.println("Departure date on Listing :" + departDateListing);

			WebElement ReturnDateListing = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[3]/div/div[2]/div/div[1]/div")));
			String returnDateListing = ReturnDateListing.getText();
			System.out.println("Return Date Listing :" + returnDateListing);

			WebElement Travelers_and_Class = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[4]/div/div[1]/div/div[1]/div")));
			String travelerModifiedd = Travelers_and_Class.getText();
			String travelerModifieddd = travelerModifiedd.replace("Traveler(s) & Class", "");
			String travelerModified = travelerModifieddd.replace("Traveler", "Traveler,");

			System.out.println("Travelers on listing: " + travelerModified);

//          Trip Type on Listing page 
			WebElement TripTypeListing = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div[3]/label/span")));
			String listingTripType = TripTypeListing.getText();
			System.out.println("Selected trip type on listing: " + listingTripType);
//         Trip Type compare Home & listing 

			if (tripSelection.equals(listingTripType)) {

				System.out.println("Trip Type Matched :" + listingTripType);
			} else {

				System.err.print("Trip type not matched ");
			}

//          Currency get on Listing page 
			WebElement CurrencyListing = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/header/div/nav/div[2]/b")));
			String currencyOnListing = CurrencyListing.getText();
          System.out.println("Currecny visible on listing page: " + currencyOnListing);

//            Compared Currency Home and Listing 
//			if (availableCurrencyOnWidget.equals(currencyOnListing)) {
//				System.out.println("Currency matched home and Listing");
//			} else {
//				System.err.println("currency not matched");
//			}

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
//            

//           Compare FromWidget and FromListing

			if (fromWidget.equals(fromOnListing)) {
				System.out.println(
						"Widget and Listing From are same " + "[" + fromWidget + "], " + "[" + fromOnListing + "]");
			} else {
				System.err.println("Widget and Listing From are not same. ");
			}

//            Compare to ToWiget and ToListing 

			if (toWidget.equals(toOnListingPage)) {
				System.out.println(
						"Widget and Listing To are Same " + "[" + toWidget + "], " + "[" + toOnListingPage + "]");
			} else {
				System.err.println("Widget and Listing From are not same. ");
			}

//          Compared Depart date widget and Listing page 

			if (departDatewidget.equals(departDateListing)) {
				System.out.println("Depart Date is Matched " + departDateListing);
			} else {
				System.err.println(" Depart Date is not matched");
			}

			if (returnDatewidget.equals(returnDateListing)) {
				System.out.println("Return Date is matched :" + returnDateListing);
			} else {
				System.err.println("Return Date is not Matched");
			}

//        Traveler and class compared Widget  and listing    

			if (travelWidget.equals(travelerModified)) {
				System.out.print("Travelers and class matched widget and listing :" + travelerModified);
			} else {
				System.err.println("Travelers and class not matched");
			}

			String departFlightshow = "";
			String returnFlightshow = "";
			String airlinespriceSymbol = "";
			try {

				WebElement DepartflightShow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/html/body/div[1]/div/div/div/div[3]/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/span")));
				departFlightshow = DepartflightShow.getText();
				System.out.println("Departure Flight Showing  :" + departFlightshow);

				WebElement ReturnFlightShow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"/html/body/div[1]/div/div/div/div[3]/div/div/div/div[2]/div[2]/div/div[3]/div[1]/div/div/div/span")));
				returnFlightshow = ReturnFlightShow.getText();
				System.out.println("Return Flight Showing  :" + returnFlightshow);

				WebElement AvailableAirlines = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div[1]/div/div/div/div[6]/div[2]")));

				String flightFilter = AvailableAirlines.getText(); // Trim any extra spaces
				airlinespriceSymbol = flightFilter.replace("₹", "INR"); // Replace ₹ with INR
				String[] arr = airlinespriceSymbol.split(" ");
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

			} catch (NoSuchElementException | TimeoutException e) {
				// Catch the NoSuchElementException and TimeoutException
				System.out.println("Flight not found: ");
				departFlightshow = "Flight not found";
				returnFlightshow = "Flight not found";
				airlinespriceSymbol = "NA";
			} catch (Exception e) {
				// Catch any other unexpected exceptions and log them
				System.out.println("An unexpected error occurred: ");
				departFlightshow = "Flight not found";
				returnFlightshow = "Flight not found";
				airlinespriceSymbol = "NA";
			}

//            Return Flight showing listing

//       API response  Search Time

			long endTime = System.currentTimeMillis();
			double searchTimes = (endTime - startTime) / 1000.0;
			String searchTime = String.format("%.2f", searchTimes);
			System.out.println("Flight Search Time: " + searchTime + " sec");

			Result result = new Result();
//          result.setTitle(title);
			result.setAvailableCurrencyOnWidget(availableCurrencyOnWidget);
			result.setTripSelection(tripSelection);
			result.setFromWidget(fromWidget);
			result.setTOWidget(toWidget);
			result.setDepartDatewidget(departDatewidget);
			result.setDepartDatewidget(returnDatewidget);
			result.setTravelerWidget(travelWidget);
			result.setCurrencyOnListing(currencyOnListing);
			result.setListingTripType(listingTripType);
			result.setFromOnListing(fromOnListing);
			result.setToOnListingPage(toOnListingPage);
			result.setDepartFlightshow(departFlightshow);
			result.setReturnFlightshow(returnFlightshow);
			result.setDepartDateListing(departDateListing);
			result.setReturnDateListing(returnDateListing);
			result.settravelerModified(travelerModified);
			// result.setTravelersListing(travelersListing);
			result.setAirlinespriceSymbol(airlinespriceSymbol);
//			result.setFirstPriceShowing(firstPriceShowing);
			result.setsearchTime(searchTime);
			return result.toString();

		} finally {
			System.out.println("---------------------------Route Searched successfully.---------------------------");

			// return "Round trip verification completed successfully.";

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
