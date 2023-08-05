module com.example.javafx_api {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires unirest.java;

    opens com.example.javafx_api to javafx.fxml;
    exports com.example.javafx_api;
    exports com.example.javafx_api.util;
    opens com.example.javafx_api.util to javafx.fxml;
    opens com.example.javafx_api.view to javafx.graphics, javafx.fxml;
    opens com.example.javafx_api.controller to javafx.fxml;
}