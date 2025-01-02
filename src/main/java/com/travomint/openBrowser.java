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
import org.openqa.selenium.chrome.ChromeDriver;

public class openBrowser {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Open the travomint URL for 1st route");
		
		//First route 
		
		driver.get("https://www.travomint.com/");
		//Maximize current window
		System.out.println("Maximize the currect window");
		driver.manage().window().maximize();
	 	//Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println("The title of the wensite is "+title);
		
//		//Second Route
//		
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.travomint.com/");
//		
//		//Third route
//		
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.travomint.com/");
//		
//		//Fourth route
//		
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.travomint.com/");
//		
//		//Fifth route
//		
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.travomint.com/");
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[2]")).click();
		driver.findElement(By.id("from")).sendKeys("BLR");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[3]/div/div[1]")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[1]")).click();
		driver.findElement(By.name("to")).sendKeys("DEL");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[3]/div/div[1]/div[1]")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/div[2]/table/tbody/tr[5]/td[7]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[4]/div/div[2]/button")).click();
		
		Thread.sleep(3000);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("keshav@snva.com", "");
            }
        });
        
        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("keshav@snva.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("prashant@snva.com"));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("sanket.mishra@snva.com"));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("prashant@snva.com"));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("testing@snva.com"));
            message.setSubject("Route 1 Searched Successfully");
            message.setText("Travoint is working fine!");

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}

}
