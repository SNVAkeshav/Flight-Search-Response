package com.travomint;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class RouteExecutor {
    public static void main(String[] args) {
        try {
            // Read the JSON file from the package using classloader
            List<Map<String, String>> routes = parseRoutes("routes.json");

            // Loop through each route and process
            for (Map<String, String> route : routes) {
                String from = route.get("from");
                String to = route.get("to");
                System.out.println("Processing route: From " + from + " To " + to);

                // Here you can call your route processing logic
                // FirstRoute.executeFirstRoute(driver, from, to); // Uncomment if applicable
            }
        } catch (Exception e) {
            System.err.println("Error reading or parsing routes.json: " + e.getMessage());
        }
    }

    private static List<Map<String, String>> parseRoutes(String fileName) throws Exception {
        // Use ClassLoader to load the JSON file from the package
        InputStream inputStream = RouteExecutor.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }

        // Parse JSON using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputStream, new TypeReference<List<Map<String, String>>>() {});
    }
}
