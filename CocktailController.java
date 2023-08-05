package com.example.javafx_api.controller;

import com.example.javafx_api.view.CocktailDetailsView; // Make sure to update the view class
import com.example.javafx_api.model.Cocktail; // Make sure to update the model class
import com.example.javafx_api.util.APIManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class CocktailController { // Rename to CocktailController

    @FXML
    private ListView<Cocktail> cocktailListView; // Rename to cocktailListView

    @FXML
    private TextField searchField;

    @FXML
    private Label cocktailsFoundLabel; // Rename to cocktailsFoundLabel

    private final APIManager apiManager = new APIManager();

    public void searchCocktails(ActionEvent event) {
        String cocktailQuery = searchField.getText();

        JSONObject jsonObject = apiManager.searchCocktails(cocktailQuery, "1");
        if (jsonObject == null) {
            System.out.println("API response was null");
            cocktailsFoundLabel.setText("No cocktails found.");
            return;
        }

        // Check if "drinks" is not null before processing
        if (jsonObject.has("drinks") && !jsonObject.isNull("drinks")) {
            JSONArray cocktailsArray = jsonObject.getJSONArray("drinks");

            cocktailListView.getItems().clear();

            for (int i = 0; i < cocktailsArray.length(); i++) {
                JSONObject cocktailJson = cocktailsArray.getJSONObject(i);
                Cocktail cocktail = new Cocktail(
                        cocktailJson.getString("strDrink"),
                        cocktailJson.getString("strDrinkThumb"),
                        cocktailJson.getString("strAlcoholic"),
                        cocktailJson.getString("strInstructions"),
                        cocktailJson.getString("strGlass")
                );
                cocktailListView.getItems().add(cocktail);
            }

            cocktailsFoundLabel.setText("Cocktails found: " + cocktailsArray.length());
        } else {
            System.out.println("No drinks found in the API response");
            cocktailsFoundLabel.setText("No cocktails found.");
        }

    }

    public void showCocktailDetails(Cocktail cocktail) { // Rename to showCocktailDetails
        CocktailDetailsView cocktailDetailsView = new CocktailDetailsView(); // Update view
        cocktailDetailsView.showView(cocktail);
    }

    @FXML
    public void getCocktailDetails(MouseEvent event) { // Rename to getCocktailDetails
        Cocktail selectedCocktail = cocktailListView.getSelectionModel().getSelectedItem(); // Update variable
        if (selectedCocktail != null) {
            showCocktailDetails(selectedCocktail);
        }
    }
}
