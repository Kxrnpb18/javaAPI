package com.example.javafx_api;

import com.example.javafx_api.view.CocktailView; // Update to use CocktailView
import javafx.application.Application;

public class App {

    public static void main(String[] args) {
        Application.launch(CocktailView.class, args); // Update to launch CocktailView
    }
}
