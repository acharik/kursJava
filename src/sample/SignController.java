package sample;


import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passField;

    @FXML
    private TextField mailField;

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginField1;

    @FXML
    private TextField nameField;

    @FXML
    void initialize() {
        loginButton.setOnAction(event -> {
            Reader read = null;
            try {
                read = new FileReader("C:\\Users\\artic\\IdeaProjects\\untitled13\\file.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int data = 0;
            try {
                data = read.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String str = "";
            try {
                while (data != -1) {
                    char value = (char) data;
                    str += value;
                    data = read.read();
                    System.out.print(value);
                }

                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\artic\\IdeaProjects\\untitled13\\file.txt"));

                writer.write(str);
                    if (isEmail(mailField.getText())){
                writer.write("\n");
                writer.write("login:");
                writer.write(loginField1.getText());
                        writer.write("\n");
                        writer.write("password:");
                writer.write(passField.getText());
                        writer.write("\n");
                        writer.write("mail:");
                writer.write(mailField.getText());
                        writer.write("\n");
                        writer.write("name:");
                writer.write(nameField.getText());}
                 else{
                            System.out.println("\n" + "лох мыло введи");
                        }
                writer.close();

            }catch (IOException e){
                e.printStackTrace();
            }finally {

                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                    loginButton.getScene().getWindow().hide();
                   /* FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/sample.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();*/
        });


    }
    public boolean isEmail(String s) {
        return s.matches("^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");
    }
}
