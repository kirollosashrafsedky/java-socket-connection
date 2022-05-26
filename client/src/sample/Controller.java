package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;

public class Controller {

    @FXML
    private Button btnSend;
    @FXML
    private Button btnLogin;

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
}
