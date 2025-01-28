////package com.travomint;
////import java.io.IOException;
////import java.io.InputStream;
////import java.util.Collections;
////import java.util.List;
////import java.util.Map;
////
////import javax.mail.MessagingException;
////
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.chrome.ChromeDriver;
////
////import com.fasterxml.jackson.core.type.TypeReference;
////import com.fasterxml.jackson.databind.ObjectMapper;
////public class Travomint {
////    public static void main(String[] args) throws InterruptedException {
////    	
////        // Set the path to the ChromeDriver executable
////		System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
////		
////        // Initialize WebDriver
////        WebDriver driver = new ChromeDriver();
//////        FirstRoute.executeFirstRoute(driver,from, to);
////        
//////        try {
//////            // Read the JSON file from the package using classloader
//////            List<Map<String, String>> routes = parseRoutes("routes.json");
//////
//////            // Loop through each route and process
//////            for (Map<String, String> route : routes) {
//////                String from = route.get("from");
//////                String to = route.get("to");
//////                System.out.println("Processing route: From " + from + " To " + to);
//////                FirstRoute.executeFirstRoute(driver,from, to);
//////
//////                // Here you can call your route processing logic
//////                // FirstRoute.executeFirstRoute(driver, from, to); // Uncomment if applicable
//////            }
//////        } catch (Exception e) {
//////            System.err.println("Error reading or parsing routes.json: " + e.getMessage());
//////        }
//////        
//////    }
//////
//////    private static List<Map<String, String>> parseRoutes(String fileName) throws Exception {
//////        // Use ClassLoader to load the JSON file from the package
//////        InputStream inputStream = RouteExecutor.class.getClassLoader().getResourceAsStream(fileName);
//////        if (inputStream == null) {
//////            throw new IllegalArgumentException("File not found: " + fileName);
//////        }
//////
//////        // Parse JSON using Jackson
//////        ObjectMapper objectMapper = new ObjectMapper();
//////        return objectMapper.readValue(inputStream, new TypeReference<List<Map<String, String>>>() {});
//////        
//////        
//////
//////    }
//////}
////        
////        String fileName = "routes.json";
////        try (InputStream inputStream = Travomint.class.getClassLoader().getResourceAsStream(fileName)) {
////            if (inputStream == null) {
////                System.out.println("File not found: " + fileName);
////                return;
////            }
////
////            // Parse the JSON file into a list of routes
////            ObjectMapper objectMapper = new ObjectMapper();
////            List<Map<String, String>> routes = objectMapper.readValue(inputStream, new TypeReference<>() {});
////
//////            System.out.println("Original Routes:");
//////            printRoutes(routes);
////
////            // Shuffle the routes
////            Collections.shuffle(routes);
////
////            System.out.println("\nShuffled Routes:");
////            printRoutes(routes);
////
////            // Traverse and process each route
////            System.out.println("\nProcessing Shuffled Routes:");
////            for (Map<String, String> route : routes) {
////                String from = route.get("from");
////                String to = route.get("to");
////                System.out.println("Processing route: From " + from + " To " + to);
////                //FirstRoute.executeFirstRoute(driver,from, to);
////                DataVerification.executeVerifiedData(driver, from, to);
////                // Example: Execute some action for each route
////                processRoute(driver,from, to);
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
////
////    // Method to process a single route (placeholder for custom logic)
////    private static void processRoute(WebDriver driver, String from, String to) {
////        System.out.println("Executing logic for route from " + from + " to " + to);
////        // Add your custom route processing logic here
////    }
////    private static void searchWithNextRoute(WebDriver driver, List<Map<String, String>> routes) throws InterruptedException {
////        for (Map<String, String> route : routes) {
////            String nextFrom = route.get("from");
////            String nextTo = route.get("to");
////            System.out.println("Retrying with next route: From " + nextFrom + " To " + nextTo);
////            executeVerifiedData(driver, nextFrom, nextTo, routes);
////            break; // Process only the next route
////        }
////    }
////
////    // Utility method to print routes
////    private static void printRoutes(List<Map<String, String>> routes) {
////        for (Map<String, String> route : routes) {
////            System.out.println("From: " + route.get("from") + ", To: " + route.get("to"));
////        }
////    }
////}
////
//////public class Travomint {
//////
//////    public static void main(String[] args) throws InterruptedException, MessagingException {
//////        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//////
//////        WebDriver driver = new ChromeDriver();
//////
//////        String fileName = "routes.json";
//////        try (InputStream inputStream = Travomint.class.getClassLoader().getResourceAsStream(fileName)) {
//////            if (inputStream == null) {
//////                System.out.println("File not found: " + fileName);
//////                return;
//////            }
//////
//////            ObjectMapper objectMapper = new ObjectMapper();
//////            List<Map<String, String>> routes = objectMapper.readValue(inputStream, new TypeReference<>() {});
//////z
//////            Collections.shuffle(routes);
//////            System.out.println("\nShuffled Routes:");
//////            printRoutes(routes);
//////
//////            System.out.println("\nProcessing Shuffled Routes:");
//////            for (Map<String, String> route : routes) {
//////                String from = route.get("from");
//////                String to = route.get("to");
//////                System.out.println("Processing route: From " + from + " To " + to);
//////
//////                DataVerification.executeVerifiedData(driver, from, to, routes);
//////            }
//////        } catch (IOException e) {
//////            e.printStackTrace();
//////        }
//////    }
//////
//////    private static void printRoutes(List<Map<String, String>> routes) {
//////        for (Map<String, String> route : routes) {
//////            System.out.println("From: " + route.get("from") + ", To: " + route.get("to"));
//////        }
//////    }
//////}
//
//
//
//package com.travomint;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class Travomint {
//    public static void main(String[] args) throws InterruptedException {
//        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//
//        // Initialize WebDriver
//        WebDriver driver = new ChromeDriver();
//
//        String fileName = "routes.json";
//        try (InputStream inputStream = Travomint.class.getClassLoader().getResourceAsStream(fileName)) {
//            if (inputStream == null) {
//                System.err.println("File not found: " + fileName);
//                return;
//            }
//
//            // Parse the JSON file into a list of routes
//            ObjectMapper objectMapper = new ObjectMapper();
//            List<Map<String, String>> routes = objectMapper.readValue(inputStream, new TypeReference<>() {});
//
//            // Shuffle the routes
//            Collections.shuffle(routes);
//
//            System.out.println("Shuffled Routes:");
//            printRoutes(routes);
//
//            // Traverse and process each route
//            for (Map<String, String> route : routes) {
//                String from = route.get("from");
//                String to = route.get("to");
//
//                System.out.println("Processing route: From " + from + " To " + to);
//                try {
//                    // Execute the route processing logic
//                    DataVerification.executeVerifiedData(driver, from, to);
//                } catch (Exception e) {
//                    System.err.println("Error processing route from " + from + " to " + to + ": " + e.getMessage());
//                    // Optionally retry with the next route
//                    searchWithNextRoute(driver, routes);
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading or parsing routes.json: " + e.getMessage());
//        } finally {
//            // Clean up WebDriver
//            if (driver != null) {
//                driver.quit();
//            }
//        }
//    }
//
//    // Utility method to process the next route
//    private static void searchWithNextRoute(WebDriver driver, List<Map<String, String>> routes) throws InterruptedException {
//        for (Map<String, String> route : routes) {
//            String nextFrom = route.get("from");
//            String nextTo = route.get("to");
//            System.out.println("Retrying with next route: From " + nextFrom + " To " + nextTo);
//            try {
//                DataVerification.executeVerifiedData(driver, nextFrom, nextTo);
//                break; // Process only the next route
//            } catch (Exception e) {
//                System.err.println("Error retrying route from " + nextFrom + " to " + nextTo + ": " + e.getMessage());
//            }
//        }
//    }
//
//    // Utility method to print all routes
//    private static void printRoutes(List<Map<String, String>> routes) {
//        for (Map<String, String> route : routes) {
//            System.out.println("From: " + route.get("from") + ", To: " + route.get("to"));
//        }
//    }
//}

//package com.travomint;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class Travomint {
//    public static void main(String[] args) throws InterruptedException {
//        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//
//        // Initialize WebDriver
//        WebDriver driver = new ChromeDriver();
//
//        String fileName = "routes.json";
//        StringBuilder emailContent = new StringBuilder(); // Collect results here
//        emailContent.append("<html><body>");
//
//        try (InputStream inputStream = Travomint.class.getClassLoader().getResourceAsStream(fileName)) {
//            if (inputStream == null) {
//                System.err.println("File not found: " + fileName);
//                return;
//            }
//
//            // Parse the JSON file into a list of routes
//            ObjectMapper objectMapper = new ObjectMapper();
//            List<Map<String, String>> routes = objectMapper.readValue(inputStream, new TypeReference<>() {});
//
//            // Shuffle the routes
//            Collections.shuffle(routes);
//
//            System.out.println("Shuffled Routes:");
//            printRoutes(routes);
//
//            // Traverse and process each route
//            for (Map<String, String> route : routes) {
//                String from = route.get("from");
//                String to = route.get("to");
//
//                System.out.println("Processing route: From " + from + " To " + to);
//                try {
//                    // Execute the route processing logic and collect results
//                    String result = DataVerification.executeVerifiedData(driver, from, to);
//                    emailContent.append(result); // Append result to email content
//                } catch (Exception e) {
//                    System.err.println("Error processing route from " + from + " to " + to + ": " + e.getMessage());
//                    // Optionally retry with the next route
//                    //searchWithNextRoute(driver, routes);
//                    continue;
//                }
//            }
//
//            emailContent.append("</body></html>"); // Close HTML content
//        } catch (IOException e) {
//            System.err.println("Error reading or parsing routes.json: " + e.getMessage());
//        } finally {
//            // Clean up WebDriver
//            if (driver != null) {
//                driver.quit();
//            }
//
//            // Send the aggregated email
//            try {
//                DataVerification.sendEmail("snvaqc@gmail.com", "snvaqc@gmail.com", "snvaqc@gmail.com",
//                        "Automated Travomint.com Response for All Routes", emailContent.toString());
//            } catch (Exception e) {
//                System.err.println("Failed to send email: " + e.getMessage());
//            }
//        }
//    }
//
//    // Utility method to print all routes
//    private static void printRoutes(List<Map<String, String>> routes) {
//        for (Map<String, String> route : routes) {
//            System.out.println("From: " + route.get("from") + ", To: " + route.get("to"));
//        }
//    }
//}

package com.travomint;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Travomint {

	public static void main(String[] args) {
		// Initialize the scheduled executor service to run the task every hour
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		Runnable task = () -> {
			try {
				// Execute the flight search logic
				performFlightSearch();
			} catch (Exception e) {
				System.err.println("Error during scheduled task execution: " + e.getMessage());
			}
		};

		// Schedule the task with an initial delay of 0 and a period of 1 hour
		scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.HOURS);
	}

	public static void performFlightSearch() throws InterruptedException {
		// Set the path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();

		String fileName = "routes.json";
		StringBuilder emailContent = new StringBuilder(); // Collect results here
		emailContent.append("<html><body>");

		try (InputStream inputStream = Travomint.class.getClassLoader().getResourceAsStream(fileName)) {
			if (inputStream == null) {
				System.err.println("File not found: " + fileName);
				return;
			}

	        // Open the website and get its title
	        driver.get("https://www.travomint.com/");
	        String WebsiteTitle = driver.getTitle();
	        System.out.println("Website Title - " + WebsiteTitle);
	        System.out.println(" ");
	        
	     // Append the website title to the email content
	        emailContent
//	        .append("<h3>Website Title -> ")
	                    .append(WebsiteTitle)
	                    .append("</h3>");
	        
			// Parse the JSON file into a list of routes
			ObjectMapper objectMapper = new ObjectMapper();
			List<Map<String, String>> routes = objectMapper.readValue(inputStream, new TypeReference<>() {
			});

			// Shuffle the routes
			Collections.shuffle(routes);

			System.out.println("Shuffled Routes:");
			printRoutes(routes);
			

			
			int routeCounter = 1;

			// Traverse and process each route
			for (Map<String, String> route : routes) {
				String from = route.get("from");
				String to = route.get("to");

				System.out.println("Search for Route: " + routeCounter);
				System.out.println("Processing route: From " + from + " To " + to);
				System.out.println(" ");
				try {
					// Execute the route processing logic and collect results
//                    String result = DataVerification.executeVerifiedData(driver, from, to);
//                    emailContent.append(result); // Append result to email content
//                } catch (Exception e) {
//                    System.err.println("Error processing route from " + from + " to " + to + ": " + e.getMessage());
//                    continue;
//                }
//            }

					emailContent.append("<h3>Route ")
								.append(routeCounter)
								.append("</h3>")
								.append("<p>From: ")
								.append(from)
								.append(", To: ")
								.append(to)
								.append("</p>");
					
					routeCounter++;

					// Execute the route processing logic and collect results
					String result = DataVerification.executeVerifiedData(driver, from, to);
					
					emailContent.append(result); // Append result to email content
				} catch (Exception e) {
					System.err.println("Error processing route from " + from + " to " + to + ": " + e.getMessage());
					continue;
				}
			}
			// emailContent.append("<br><br>").append("<p>Best
			// Regards,</p>").append("<p>Testing Team</p>");
			
			emailContent.append("<p style='color: gray;'>Best Regards,<br>" + "<strong>Testing Team</strong></p>")
						.append("<a href='https://www.travomint.com' target='_blank' title='Visit Travomint Website'>")
						.append("<img src='https://www.travomint.com/Image/logo.png' alt='Testing Team' style='width:146px; height:30px;'>")
						.append("</a>");

//            .append("<p>Contact: developer@travomint.com</p>");
//	          "<p style='color: black;'>Automatic mail for flights<br>" +
//	          "<strong>Keshav</strong></p>"

			emailContent.append("</body></html>"); // Close HTML content

//            emailContent.append("</body></html>"); // Close HTML content
		} catch (IOException e) {
			System.err.println("Error reading or parsing routes.json: " + e.getMessage());
		} finally {
			// Clean up WebDriver
			if (driver != null) {
				driver.quit();
			}

			// Send the aggregated email
			try {
//				DataVerification.sendEmail("developer@travomint.com,testing@snva.com",
//						"alok@snva.com,prashant@snva.com,davemaan@travomint.com,yugdeep@snva.com", "keshav@snva.com",

				DataVerification.sendEmail("keshav@snva.com", "snvatesting@gmail.com", "snvaqc@gmail.com",
						"Automated Scheduled Flight Response - Travomint.com", emailContent.toString());
				System.out.println("Email sent successfully!");
			} catch (Exception e) {
				System.err.println("Failed to send email: " + e.getMessage());
			}
		}
	}

	// Utility method to print all routes
	private static void printRoutes(List<Map<String, String>> routes) {
		for (Map<String, String> route : routes) {
			System.out.println("From: " + route.get("from") + ", To: " + route.get("to"));
		}
	}
}
