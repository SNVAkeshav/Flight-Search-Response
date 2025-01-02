package com.travomint;

import java.time.Duration;
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
	
	public static String executeVerifiedData(WebDriver driver, String from, String to) throws InterruptedException {
		
		try {
            // Open the Travomint website for the first route
        	
            System.out.println("Open the Travomint URL for different route");
            driver.get("https://www.travomint.com/");
            
            // Maximize the browser window
            
            System.out.println("Maximize the current window");
            driver.manage().window().maximize();
            
            // Print the title of the website
            
            String title = driver.getTitle();
            System.out.println("The title of the Website is: " + title);
            
            // First Route
            
            driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[2]")).click();
            //driver.findElement(By.id("from")).sendKeys("BLR");
            driver.findElement(By.id("from")).sendKeys(from);
            Thread.sleep(2000);
            
            // From widget selection
            
            driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[3]/div/div[1]")).click();
            WebElement C1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/span"));
            String text1 = C1.getText();
            System.out.println("Widget -> From : " + text1);
            
            // To Destination
            
            driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[1]")).click();
            //driver.findElement(By.name("to")).sendKeys("DEL");
            driver.findElement(By.name("to")).sendKeys(to);
            Thread.sleep(2000);
            
            // To widget selection
            
            driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[1]/div[1]")).click();
            
            // Calendar selection
            
            WebElement Calender = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div"));
            Calender.click();
            Thread.sleep(2000);	
            driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/div[1]/div/button[2]")).click();
            Thread.sleep(3000);
            
            // Date selection
            
            driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/div[2]/table/tbody/tr[5]/td[3]")).click();
            System.out.println("From Date Successfully Selected.");
            
            WebElement date = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div/div[1]/div"));
            String CalenderWidget = date.getText();
            
            // From Widget xpath using comparison
            
            WebElement fromW = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[1]/span"));
            String toWidget = fromW.getText();
            System.out.println("Widget -> To : " + toWidget);
            
            // Travelers & class
            
            WebElement travelerW = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[4]/div/div[1]/div"));
            String travelWidget = travelerW.getText();
            
            // Search Button Clicked
            
            Thread.sleep(4000);
            long startTime = System.currentTimeMillis();

            driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[4]/div/div[2]/button")).click();
            Thread.sleep(3000);
            
            // To Modified Search
            
            WebElement C2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[1]/div[1]/div[1]/span"));
            String text2 = C2.getText();
            System.out.println("Listing -> From : " + text2);
            
            // Compare the two route texts
            
            if (text1.equals(text2)) {
                System.out.println("Widget and Listing From are same  " + "[" + text1 + "].");
            } else {
                System.out.println("Widget and Listing From are not same.  ");
            }
            
            // Modified From Destination
            
            WebElement fromM = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[2]/div/div[1]/span"));
            String FromDestination = fromM.getText();
            System.out.println("Listing page To Destination :" + FromDestination);
            
            if (toWidget.equals(FromDestination)) {
                System.out.println("Widget and Listing To are same   " + "[" + FromDestination + "].");
            } else {
                System.out.println("Widget and Listing To are not same.  ");
            }
            
            // Date of Departure Date
            
            WebElement CalenderM = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[3]/div/div[1]/div/div[1]/div"));
            String CalenderModified = CalenderM.getText();
            
            if (CalenderWidget.equals(CalenderModified)) {
                System.out.println("Widget and Listing Date are same   " + CalenderWidget + "---------------------- " + CalenderModified);
            } 
            else {
                System.out.println("Date is not same ");
            }
            
         // Traveler & Class
            
            WebElement TravelersM = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[3]/div[4]/div/div[1]/div"));
            String travelerModified = TravelersM.getText();
            System.out.println(travelerModified);
            
            if (travelWidget.equals(travelerModified)) {
                System.out.println("Traveler is matched: " + travelerModified);
            } else {
            	 System.out.println("Traveler is not Matched");
            }
            
            
            // Wait for results to load
            
            //Thread.sleep(20000);
            
            // Flight availability check
            
            String totalShowing = "No results";
            
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement Show = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div[2]/div[2]/div[3]")));
                totalShowing = Show.getText();
                
                if (totalShowing.isEmpty()) {
                    System.out.println("No flights found.");
                } 
                else {
                    System.out.println(totalShowing);
                }
            }
            catch (NoSuchElementException e) {
                System.out.println("Flight not found.");
                totalShowing = "Flight not found"; // Setting a default value when flight isn't found
                
//        		driver.switchTo().newWindow(WindowType.TAB);
//        		//SecondRoute.executeSecondRoute(driver, from, to);
//        		DataVerification.executeVerifiedData(driver, from, to);
            } 
            catch (TimeoutException e) {
                System.out.println("Element not found within the specified timeout.");
                totalShowing = "Flight not found"; // Timeout occurred, set the default message
                
//        		driver.switchTo().newWindow(WindowType.TAB);
//        		//SecondRoute.executeSecondRoute(driver, from, to);
//        		DataVerification.executeVerifiedData(driver, from, to);



            }
            long endTime = System.currentTimeMillis();
            double searchTime = (endTime - startTime)/1000.0;
            System.out.println(searchTime);

            
            // Create Result object and populate it with values
            
            Result result = new Result();
            result.setTitle(title);
            result.setText1(text1);
            result.setFromWidget(toWidget);
            result.setCalenderWidget(CalenderWidget);
            result.setTravelerWidget(travelWidget);
            result.setText2(text2);
            result.setFromDestination(FromDestination);
            result.setTotalShowing(totalShowing);
            result.setCalenderModified(CalenderModified);
            result.settravelerModified(travelerModified);
            result.setsearchTime(searchTime);
            
            // Print the result
            
            System.out.println("---------------------------------");
            System.out.println(result.toString());
            
            
            // Send email with the result details....................................................................................................................................
            
            return result.toString();
        } finally {
            // Close the browser after the task
           // driver.quit();
        	System.out.println("Searched successfully.");
        }
	    

    }

    // Method to send an email using SMTP
    
    public static void sendEmail(String to, String cc, String bcc, String subject, String body) throws MessagingException {
        final String from = "keshav@snva.com";
        final String password = "your-password"; // Replace with your email password or use environment variables
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
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
        message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));
        message.setSubject(subject);
        //message.setText(body);
        message.setContent(body, "text/html");
        // Send the email
        Transport.send(message);
        System.out.println("Email sent successfully to these emails: " + to + ", " + cc + ", " + bcc);
	}
}
