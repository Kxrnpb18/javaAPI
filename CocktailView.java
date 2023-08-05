package com.example.javafx_api.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CocktailView extends Application { // Rename to CocktailView
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/javafx_api/CocktailView.fxml")); // Update to CocktailView.fxml
        primaryStage.setTitle("Cocktail Search"); // Update title to "Cocktail Search"
        primaryStage.getIcons().add(new Image("file:resources/images/icon.png"));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
