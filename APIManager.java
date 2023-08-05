package com.example.javafx_api.util;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class APIManager {

    // Replace with the proper endpoint and API key for the Cocktail DB API
    private static final String API_KEY = "1"; // Example API key
    private static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/search.php";

    public JSONObject searchCocktails(String cocktail, String apiKey) { // Rename to searchCocktails
        HttpResponse<JsonNode> response = Unirest.get(BASE_URL)
                .queryString("s", cocktail) // Query parameter for searching cocktails (check API documentation)
                .queryString("apiKey", apiKey != null ? apiKey : API_KEY) // Replace with the correct authentication method if needed
                .asJson();

        if (response.isSuccess()) {
            return response.getBody().getObject();
        } else {
            // Handle failure
            System.out.println("API request failed: " + response.getStatusText());
            System.out.println("Response Body: " + response.getBody());
            return null;
        }
    }
}
