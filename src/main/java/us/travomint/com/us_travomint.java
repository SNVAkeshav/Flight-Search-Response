package us.travomint.com;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class us_travomint {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                performFlightSearch();
            } catch (Exception e) {
                System.err.println("Error during scheduled task execution: " + e.getMessage());
            }
        };

        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.HOURS);
    }

    public static void performFlightSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String fileName = "routesUsTravomint.json";
        StringBuilder emailContent = new StringBuilder("<html><body>");
        StringBuilder failedRoutesContent = new StringBuilder("<html><body>");
        boolean hasFailures = false;

        try (InputStream inputStream = us_travomint.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                System.err.println("File not found: " + fileName);
                return;
            }

            driver.get("https://www.travomint.com/");
            String websiteTitle = driver.getTitle();
            System.out.println("Website Title - " + websiteTitle);
            
//    		LocalDate currentDate = LocalDate.now();
//    		System.out.println("currentDate "+ currentDate);
    		LocalDateTime currentDateTime = LocalDateTime.now();

            // Define the format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            // Format the date and time
            String formattedDateTime = currentDateTime.format(formatter);

            // Print the current date and time
            System.out.println("Current Date and Time: " + formattedDateTime);
    		
            emailContent
            			.append("<h3>")
            			.append(websiteTitle)
            			.append("</h3>")
            			.append("</br>")
            			.append("<p>Route Search Date & Time: ")
            			.append(formattedDateTime);
            			

            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, String>> routes = objectMapper.readValue(inputStream, new TypeReference<>() {});
            Collections.shuffle(routes);
            System.out.println("Shuffled Routes:");
            printRoutes(routes);
            Random random = new Random();
            int routeCounter = 1;

            for (Map<String, String> route : routes) {
                String from = route.get("from");
                String to = route.get("to");
                System.out.println(" ");
                System.out.println("Search for Route: " + routeCounter);
                System.out.println("Processing route: From " + from + " To " + to);
                System.out.println(" ");
                try {
                    String processName;
                    String result;

                    if (random.nextBoolean()) {
                        processName = "One Way";
                        result = DataVerification.executeVerifiedData(driver, from, to);
                    } else {
                        processName = "Round Trip";
                        result = InternationalRoundTrip.executeVerifiedInternationalRoundTrip(driver, from, to);
                    }

                    emailContent
                    			.append("<h3>Route ")
                    			.append(routeCounter)
                    			.append("</h3>")
                                .append("<p>Process: <strong>")
                                .append(processName)
                                .append("</strong></p>")
                                .append("<p>From: ")
                                .append(from)
                                .append(", To: ")
                                .append(to)
                                .append("</p>")
                                .append(result);

                    if (result.contains("Flight not found")){
                        hasFailures = true;
                        failedRoutesContent
                        					.append("<h3>Route ")
                        					.append(routeCounter)
                        					.append("</h3>")
                        					.append("<p>Process: <strong>")
                        					.append(processName)
                        					.append("</strong></p>")
                        					.append("<p>From: ")
                        					.append(from)
                        					.append(", To: ")
                        					.append(to)
                        					.append("</p>")
                        					.append(result);
                    }

                    routeCounter++;
                } catch (Exception e) {
                    System.err.println("Error processing route from " + from + " to " + to + ": " + e.getMessage());
                }
            }

            emailContent.append("<p style='color: gray;'>Best Regards,<br><strong>Testing Team</strong></p>")
                        .append("<a href='https://www.travomint.com' target='_blank'>")
                        .append("<img src='https://www.travomint.com/Image/logo.png' alt='Testing Team' style='width:146px; height:30px;'></a>")
                        .append("</body></html>");
            
            failedRoutesContent.append("<p style='color: gray;'>Best Regards,<br><strong>Testing Team</strong></p>")
            				   .append("<a href='https://www.travomint.com' target='_blank'>")
            				   .append("<img src='https://www.travomint.com/Image/logo.png' alt='Testing Team' style='width:146px; height:30px;'></a>")
            				   .append("</body></html>");

        } catch (IOException e) {
            System.err.println("Error reading or parsing routes.json: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }

            try {
                InternationalRoundTrip.sendEmail("keshav@snva.com", "snvatesting@gmail.com,sanket.mishra@snva.com", "snvaqc@gmail.com",
                        "Automated Scheduled Flight Response - Travomint.com", emailContent.toString());
                System.out.println("Email sent successfully!");

                if (hasFailures) {
                    InternationalRoundTrip.sendEmail("keshav@snva.com", "snvatesting@gmail.com,sanket.mishra@snva.com", "snvaqc@gmail.com",
                            "⚠️ Attention !!! Some Processes Failed", failedRoutesContent.toString());
                    System.out.println("Failure alert email sent!");
                }
            } catch (Exception e) {
                System.err.println("Failed to send email: " + e.getMessage());
            }
        }
    }

    private static void printRoutes(List<Map<String, String>> routes) {
        for (Map<String, String> route : routes) {
            System.out.println("From: " + route.get("from") + ", To: " + route.get("to"));
        }
    }
}
