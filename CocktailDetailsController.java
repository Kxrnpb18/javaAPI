package com.example.javafx_api.controller;

import com.example.javafx_api.model.Cocktail; // Update to use the Cocktail class
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

public class CocktailDetailsController { // Rename to CocktailDetailsController

    @FXML
    private Label nameLabel; // Rename to nameLabel

    @FXML
    private Label sourceLabel;

    @FXML
    private Label instructionsLabel; // Rename to instructionsLabel

    @FXML
    private ImageView cocktailImageView; // Rename to cocktailImageView

    private Cocktail cocktail; // Rename to cocktail

    public void setCocktail(Cocktail cocktail) { // Rename to setCocktail
        this.cocktail = cocktail;
        nameLabel.setText("Name: " + cocktail.getName()); // Update to getName
        sourceLabel.setText("Source: " + cocktail.getSource());
        instructionsLabel.setText("Instructions: " + cocktail.getInstructions()); // Update to getInstructions
        cocktailImageView.setImage(new Image(cocktail.getImage())); // Update to cocktail.getImage
    }

    public void backButtonAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
