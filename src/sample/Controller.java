package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Controller {
    @FXML
    private Label lblSignIn;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Label txtPasswordAlert;

    String getTxtUserName(String text) {
        return txtUserName.getText();
    }

    Restaurant restaurant = new Restaurant();
    Client client = new Client();
    JAXBContext jaxbContext;

    {
        try {
            jaxbContext = JAXBContext.newInstance(Restaurant.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            restaurant = (Restaurant) unmarshaller.unmarshal(new File("input.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void Login(javafx.event.ActionEvent actionEvent) throws Exception {

        Stage primaryStage = new Stage();
        if (txtUserName.getText().equals("") || txtPassword.getText().equals("")) {
            txtPasswordAlert.setText("Please enter all fields!");
        } else {
            for (User user : restaurant.getUsers().getUsers()) {
                if (txtUserName.getText() != user.getUsername() || txtPassword.getText() != user.getPassword()) {
                    txtPasswordAlert.setText("Please enter correct username or password!");
                }
            }
        }
        for (User user : restaurant.getUsers().getUsers()) {

            if (txtUserName.getText().equals(user.getUsername()) && txtPassword.getText().equals(user.getPassword())) {
                if (user.getRole().equals("Manager")) {

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Manager.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        managerScene managerScene = fxmlLoader.getController();
                        //clientController.setClientNameTxt(user.getName());
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));

                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    txtPasswordAlert.setText("");
                    txtUserName.setText("");
                    txtPassword.setText("");


                }
                if (user.getRole().equals("Client")) {

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        clientController clientController = fxmlLoader.getController();
                        clientController.setClientNameTxt(user.getName());
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));

                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    txtPasswordAlert.setText("");
                    txtUserName.setText("");
                    txtPassword.setText("");


                }
                if (user.getRole().equals("Cooker")) {

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Cooker.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        CookerScene cookerScene = fxmlLoader.getController();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));

                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    txtPasswordAlert.setText("");
                    txtUserName.setText("");
                    txtPassword.setText("");
                }
                if (user.getRole().equals("Waiter")) {

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Waiter.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        WaiterScene waiterScene = fxmlLoader.getController();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));

                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    txtPasswordAlert.setText("");
                    txtUserName.setText("");
                    txtPassword.setText("");
                }
            }
        }
    }
}