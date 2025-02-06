package com.travomint;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.ArrayList;
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

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InternationalRoundTrip {
	@SuppressWarnings({ "unused" })
	public static String executeVerifiedInternationalRoundTrip(WebDriver driver, String from, String to)
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
			
			
			// Handling currency selection
			WebElement clickOnCurrency = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/header/nav/div/ul/li[3]/div[2]/button/div/div")));
			clickOnCurrency.click();
			WebElement selectCurrency = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/header/nav/div/ul/li[3]/div[2]/div/div/div/div[1]/button/span")));
			String curr = selectCurrency.getText();
			System.out.println("Available currency: " + curr);
			String availableCurrencyOnWidget = "INR"; // Assuming INR is the desired currency
			System.out.println("Currency after modification: " + availableCurrencyOnWidget);
			selectCurrency.click();
			
			
			// Select round-trip option
			WebElement tripType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[1]/label[2]/span[2]")));
			tripType.click();
			String tripSelection = tripType.getText();
			System.out.println("Current selected trip type is: " + tripSelection);
			
			
			// From location
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
			WebElement f1 = driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/span"));
			String fWidget = f1.getText();
			System.out.println("Actual data: " + fWidget);
			String fromWidget = fWidget.replace(",", "");
			System.out.println("After trim from is: " + fromWidget);
			
			
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
			// WebElement fromW =
			// driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[1]/span"));
			// String toWidget = fromW.getText();
			WebElement t1 = driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[2]/span"));
			String tWidget = t1.getText();
			System.out.println("Actual to section " + tWidget);
			String toWidget = tWidget.replaceAll(",", "");
			System.out.println("After trim : " + toWidget);
			
			
			WebElement DepartClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div")));
			DepartClick.click();
			Thread.sleep(2000);
			WebElement SideArrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/div[2]/div/button[2]")));
			SideArrow.click();
			Thread.sleep(2000);
			WebElement DateselectDepart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/div[3]/table/tbody/tr[2]/td[2]")));
			DateselectDepart.click();
			Thread.sleep(2000);
			WebElement DateSelectReturn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/div[3]/table/tbody/tr[3]/td[4]")));
			DateSelectReturn.click();
			Thread.sleep(2000);
//                  GetData DepartDate and Return date 
			WebElement Departdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div/div[1]/div")));
			String departDate = Departdate.getText();
			System.out.println(departDate);
			WebElement ReturnDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[2]/div/div[1]/div")));
			String returnDateWidget = ReturnDate.getText();
			System.out.println(returnDateWidget);
//                    Traveler & class 
			WebElement TravelersWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[4]/div/div[1]/div")));
			
			String travelWidgett = TravelersWidget.getText();
			String travelWidgettt = travelWidgett.replace("Traveler(s) & Class", "");
			String travelerAndClassOnWidget = travelWidgettt.replace("Traveler", "Traveler,");
			System.out.println("Widget travelers: " + travelerAndClassOnWidget);
			
			Thread.sleep(3000);
			// Wait for the search button to be visible and click it
			WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[4]/div/div[2]/button")));
			searchButton.click();
			Thread.sleep(2000);
			long startTime = System.currentTimeMillis();
			WebElement FromListing = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[1]/div[1]/div[2]/span")));
			String fromListing = FromListing.getText();
			System.out.println("From Listing Result :" + fromListing);
			System.out.println("Actual data (from): " + fWidget);
			String fromOnListing = fromListing.replace(",", "");
			System.out.println("After trim: " + fromOnListing);
			WebElement ToListing = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[2]/div/div[2]/span")));
			String toListing = ToListing.getText();
			System.out.println("To Listing Result :" + toListing);
			String toOnListingPage = toListing.replace(",", "");
			System.out.println("After trim: " + toOnListingPage);
			WebElement DepartDatelisting = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[3]/div/div[1]/div/div[1]/div")));
			String departDateOnListing = DepartDatelisting.getText();
			System.out.println("Departure date on Listing :" + departDateOnListing);
			WebElement ReturnDateListing = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[3]/div/div[2]/div/div[1]/div")));
			String returnDateOnListing = ReturnDateListing.getText();
			System.out.println("Return Date Listing :" + returnDateOnListing);
			
			
			WebElement Travelers_and_Class = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[4]/div/div[1]/div")));
			String travelerModifiedd = Travelers_and_Class.getText();
			String travelerModifieddd = travelerModifiedd.replace("Traveler(s) & Class", "");
			String travelerAndClassOnListing = travelerModifieddd.replace("Traveler", "Traveler,");
			System.out.println("Travelers on listing: " + travelerAndClassOnListing);

			
//                    Trip Type on Listing page 
			WebElement TripTypeListing = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div[3]/label/span")));
			String listingTripType = TripTypeListing.getText();
//                   Trip Type compare Home & listing 
			if (tripSelection.equals(listingTripType)) {
				System.out.println("Trip Type Matched :" + listingTripType);
			} else {
				System.err.print("Trip type not matched ");
			}
//                    Currency get on Listing page 
			WebElement CurrencyListing = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/header/div/nav/div[2]/b")));
			String currencyOnListing = CurrencyListing.getText();
//                    System.out.println(currencyListing);
//                      Compared Currency Home and Listing 
			if (availableCurrencyOnWidget.equals(currencyOnListing)) {
				System.out.println("Currency matched home and Listing");
			} else {
				System.err.println("currency not matched");
			}
//                     Compare FromWidget and FromListing
			if (fromWidget.equals(fromOnListing)) {
				System.out.println(
						"Widget and Listing From are same " + "[" + fromWidget + "], " + "[" + fromOnListing + "]");
			} else {
				System.err.println("Widget and Listing From are not same. ");
			}
//                      Compare to ToWiget and ToListing 
			if (toWidget.equals(toOnListingPage)) {
				System.out.println(
						"Widget and Listing To are Same " + "[" + toWidget + "], " + "[" + toOnListingPage + "]");
			} else {
				System.err.println("Widget and Listing From are not same. ");
			}
//                    Compared Depart date widget and Listing page 
			if (departDate.equals(departDateOnListing)) {
				System.out.println("Depart Date is Matched " + departDateOnListing);
			} else {
				System.err.println(" Depart Date is not matched");
			}
			if (returnDateWidget.equals(returnDateOnListing)) {
				System.out.println("Return Date is matched :" + returnDateOnListing);
			} else {
				System.err.println("Return Date is not Matched");
			}
//                  Traveler and class compared Widget  and listing    
			if (travelerAndClassOnWidget.equals(travelerAndClassOnListing)) {
				System.out.print("Travelers and class matched widget and listing :" + travelerAndClassOnListing);
			} else {
				System.err.println("Travelers and class not matched");
			}
//                  
			String x_INTER_DXB = "DXB";
			String x_INTER_NYC = "NYC";
			String departShowing = "Flight not found";
			String returnShowing = "Flight not found";
			String availableAirlinesOnListing = "";
			
			
			// Debugging: Print the values of fromOnListing and toOnListingPage
			System.out.println("fromOnListing: " + fromOnListing);
			System.out.println("toOnListingPage: " + toOnListingPage);
			if (x_INTER_DXB.equals(fromOnListing) || x_INTER_DXB.equals(toOnListingPage)
					|| x_INTER_NYC.equals(fromOnListing) || x_INTER_NYC.equals(toOnListingPage)) {
				try {
					// Using a more general XPath or other locator strategies
					WebElement flights_international = wait
							.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
									"#__next > div > div > div > div.oneway-flres.position-relative.pb-0 > div > div > div > div.col-xl-7.col-12 > div.flex.justify-between.items-center.w-full.showingResultTextListing > div")));
					 returnShowing = flights_international.getText();
					 if (returnShowing.isEmpty()) {
							System.out.println("Flight not found");
						} else {
					System.out.println("flightsxinternational: " + returnShowing);

					WebElement AvailableAirlines = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"/html/body/div[1]/div/div/div/div[3]/div/div/div/div[1]/div[2]/div/aside/div/div[5]/div")));

					String availableAirlines = AvailableAirlines.getText();
					
					availableAirlinesOnListing = availableAirlines.replace("₹", "INR"); // Replace ₹ with INR
			        String[] arr = availableAirlinesOnListing.split(" ");
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
			            System.out.println("availableAirlineOnListingWithCurrency" + availableAirlinesOnListing);
			        }
						}
					
				} catch (TimeoutException e) {
//                  System.err.println("Timeout waiting for international flight element. " + e.getMessage());
					returnShowing = "Flight not found";
					availableAirlinesOnListing = "NA";
				} catch (NoSuchElementException e) {
					returnShowing = "Flight not found";
					availableAirlinesOnListing = "NA";
					System.err.println("Flight  not found. " + e.getMessage());
				}
			} else {
				try {
					WebElement domesticDepart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"/html/body/div[1]/div/div/div/div[3]/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/span")));
					 departShowing = domesticDepart.getText();
					 if (departShowing.isEmpty() || (returnShowing.isEmpty())) {
							System.out.println("No flights found.");
						} else {
					WebElement domesticReturn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"/html/body/div[1]/div/div/div/div[3]/div/div/div/div[2]/div[2]/div/div[3]/div[1]/div/div/div/span")));
					 returnShowing = domesticReturn.getText();
					if (departShowing != null && returnShowing != null) {
						System.out.println("Depart flights Showing : " + departShowing);
						System.out.println("Return flights Showing : " + returnShowing);
					}
					WebElement AvailableAirlines = wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div[1]/div/div/div[6]/div[2]")));

					String availableAirlines = AvailableAirlines.getText();
					availableAirlinesOnListing = availableAirlines.replace("₹", "INR"); // Replace ₹ with INR
			        String[] arr = availableAirlinesOnListing.split(" ");
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
			            System.out.println("availableAirlineOnListingWithCurrency" + availableAirlinesOnListing);
			        }
						}
					
				} catch (TimeoutException e) {
					departShowing = "Flight not found";
					returnShowing = "Flight not found";
					availableAirlinesOnListing = "NA";
					System.err.println("Flight Not Found");
				} catch (NoSuchElementException e) {
					departShowing = "Flight not found";
					returnShowing = "Flight not found";
					availableAirlinesOnListing = "NA";
					System.err.println("Domestic flight element not found.");
				}
			}
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
			result.setDepartDate(departDate);
			result.setReturnDateWidget(returnDateWidget);
			result.setTravelerAndClassOnWidget(travelerAndClassOnWidget);
			result.setCurrencyOnListing(currencyOnListing);
			result.setListingTripType(listingTripType);
			result.setFromOnListing(fromOnListing);
			result.setToOnListingPage(toOnListingPage);
			result.setDepartShowing(departShowing);
			result.setReturnShowing(returnShowing);
			result.setDepartDateOnListing(departDateOnListing);
			result.setReturnDateOnListing(returnDateOnListing);
			result.setTravelerAndClassOnListing(travelerAndClassOnListing);
			result.setAvailableAirlinesOnListing(availableAirlinesOnListing);
//			result.setFirstPriceShowing(firstPriceShowing);
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
