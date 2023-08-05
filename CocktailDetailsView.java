package com.example.javafx_api.view;

import com.example.javafx_api.controller.CocktailDetailsController; // Update to use CocktailDetailsController
import com.example.javafx_api.model.Cocktail; // Update to use the Cocktail class
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CocktailDetailsView { // Rename to CocktailDetailsView
    public void showView(Cocktail cocktail) { // Update parameter to Cocktail
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/javafx_api/CocktailDetailsView.fxml")); // Update to CocktailDetailsView.fxml
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        CocktailDetailsController controller = loader.getController(); // Update to CocktailDetailsController
        controller.setCocktail(cocktail); // Update to setCocktail

        Stage stage = new Stage();
        stage.setTitle(cocktail.getName()); // Update to getName
        stage.getIcons().add(new Image("file:resources/images/icon.png"));
        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }
}
