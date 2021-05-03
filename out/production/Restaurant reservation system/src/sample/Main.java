package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.setTitle("Restaurant System");
        primaryStage.setScene(new Scene(root, 863, 542));
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.show();
    }
    public static void main(String[] args) throws JAXBException {
        launch(args);
    }
}
