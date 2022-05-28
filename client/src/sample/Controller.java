package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.simple.JSONObject;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField fname;
    @FXML
    private TextField mname;
    @FXML
    private TextField lname;
    @FXML
    private TextField uname;
    @FXML
    private TextField pass;
    @FXML
    private TextField passv;
    @FXML
    private TextField blnc;
    @FXML
    private TextField textField;
    @FXML
    private TextField userField;
    @FXML
    private TextField passField;

    @FXML
    private TextArea textArea;

    @FXML
    void btnSend_Handler(){

        // sending json
        SocketClient socketClient = SocketClient.getInstance();
        JSONObject json = new JSONObject();
        json.put("data", textField.getText());
        String dist = "test-data";
        JSONObject serverResponse = socketClient.socketSendReceiveJSON(json, dist);
        textArea.appendText("Client: " + textField.getText() + "\n");
        textArea.appendText("Server: " + serverResponse.get("data") + "\n");
    }

    @FXML
    void btnLogin_Handler(){

        // sending json
        SocketClient socketClient = SocketClient.getInstance();
        JSONObject json = new JSONObject();
        json.put("user", userField.getText());
        json.put("pass", passField.getText());
        String dist = "login";
        JSONObject serverResponse = socketClient.socketSendReceiveJSON(json, dist);
        if(serverResponse.get("access").equals("Granted")){
            textArea.appendText("Access granted" + "\n");
        }else{
            textArea.appendText("Wrong credentials" + "\n");
        }
    }

    @FXML
    void btnCreateAcc_Handler(){

        // sending json
        SocketClient socketClient = SocketClient.getInstance();
        JSONObject json = new JSONObject();
        json.put("fname", fname.getText());
        json.put("mname", mname.getText());
        json.put("lname", lname.getText());
        json.put("uname", uname.getText());
        json.put("pass", pass.getText());
        json.put("passv", passv.getText());
        json.put("blnc", blnc.getText());
        String dist = "sign-up";
        JSONObject serverResponse = socketClient.socketSendReceiveJSON(json, dist);
        if(serverResponse.get("create").equals("Ok")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setContentText("Your account is created successfully!");
            alert.showAndWait();
        }else if(serverResponse.get("create").equals("Choose Another")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setContentText("Username is already in use!");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setContentText("Verification password does not match the entered one!");
            alert.showAndWait();
        }
    }

    @FXML
    void switchToSignUpPage(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("signUpScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToLoginPage(javafx.event.ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
