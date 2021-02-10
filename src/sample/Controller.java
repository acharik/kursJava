package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Controller {

    @FXML
    private Button regButton;

    @FXML
    private PasswordField passField;

    @FXML
    private TextField loginField;

    @FXML
    private Button loginButton;
    @FXML
    void initialize(){
        regButton.setOnAction(event -> {
            //regButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Sign.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        loginButton.setOnAction(event ->{
            if(loginField.getText().equals("admin") && passField.getText().equals("1111")){
                regButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/AdminPanel.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
            FileLogin fileLogins = new FileLogin();
            try {
                fileLogins.fileLogin();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String login = null;
            String password = null;
            for (String element :fileLogins.getLogins()){
                if(element.equals(loginField.getText())){
                   login = element;
                }
            }
            for (String element: fileLogins.getPasswords()){
                if(element.equals(passField.getText())){
                password = element;
                }
            }
            if(login.equals(loginField.getText())&& password.equals(passField.getText())){
                regButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/AdminPanel.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
        });
    }


    public TextField getLoginField() {
        return loginField;
    }

    public void setLoginField(TextField loginField) {
        this.loginField = loginField;
    }
}