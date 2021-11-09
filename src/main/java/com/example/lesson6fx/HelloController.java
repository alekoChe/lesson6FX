package com.example.lesson6fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML // если не повесить эту аннотацию над private, то поле не будет видно в других классах
    private TextArea messageArea;
    @FXML
    private TextField messageField;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void clickSendButton(ActionEvent actionEvent) {
        final String message = messageField.getText();
        if (message.isEmpty()) {
            return;
        }
        messageArea.appendText(message + "\n");
        messageField.setText("");
        messageField.requestFocus(); // возвращает фокус на поле
    }

    public void deleteText(ActionEvent actionEvent) {
        messageArea.setText("");
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}