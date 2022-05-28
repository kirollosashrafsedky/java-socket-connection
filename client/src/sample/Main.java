package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        // open socket connection
        SocketClient.initConnection(5000);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop(){
        // close socket connection
        System.out.println("Closing connection");
        SocketClient socketClient = SocketClient.getInstance();
        socketClient.closeConnection();

    }
}
