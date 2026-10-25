package cse213.midtermsolnautumn24creditcard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreditCardView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Credit Card");
        stage.setScene(scene);
        stage.show();
    }
}
