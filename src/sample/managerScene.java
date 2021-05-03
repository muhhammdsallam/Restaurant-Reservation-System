package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class managerScene {
    @FXML
    private Label cn1;
    @FXML
    private Label cn2;
    @FXML
    private Label cn3;
    @FXML
    private Label cn4;
    @FXML
    private Label cn5;
    @FXML
    private Label cn6;
    @FXML
    private Label cn7;
    @FXML
    private Label tn1;
    @FXML
    private Label tn2;
    @FXML
    private Label tn3;
    @FXML
    private Label tn4;
    @FXML
    private Label tn5;
    @FXML
    private Label tn6;
    @FXML
    private Label tn7;
    @FXML
    private Label op1;
    @FXML
    private Label op2;
    @FXML
    private Label op3;
    @FXML
    private Label op4;
    @FXML
    private Label op5;
    @FXML
    private Label op6;
    @FXML
    private Label op7;
    @FXML
    private Label mp1;
    @FXML
    private Label mp2;
    @FXML
    private Label mp3;
    @FXML
    private Label mp4;
    @FXML
    private Label mp5;
    @FXML
    private Label mp6;
    @FXML
    private Label mp7;
    @FXML
    private Label totalMoneyPaid;
    @FXML
    private Button showReservations;
    private double total;

    JAXBContext jaxbContext;

    Clients clients = new Clients();

    {
        try {
            jaxbContext = JAXBContext.newInstance(Clients.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            clients = (Clients) unmarshaller.unmarshal(new File("Saved.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void printReservations(ActionEvent actionEvent) {
        op1.setText("");
        op2.setText("");
        op3.setText("");
        op4.setText("");
        op5.setText("");
        op6.setText("");
        op7.setText("");
        String add;
        for (Client client : clients.getClients()) {
            add="";
            for(Dish dish: client.getDishes().getDishesInfo()){
                add += dish.printDishes();
            }
            if (client.getTable().getNumber() == 1) {
                cn1.setText(client.getName());
                tn1.setText(Integer.toString(client.getTable().getNumber()));
                mp1.setText(Double.toString(client.getMoney()));
                op1.setText(add);
            } else if (client.getTable().getNumber() == 2) {
                cn2.setText(client.getName());
                tn2.setText(Integer.toString(client.getTable().getNumber()));
                mp2.setText(Double.toString(client.getMoney()));
                op2.setText(add);
            } else if (client.getTable().getNumber() == 3) {
                cn3.setText(client.getName());
                tn3.setText(Integer.toString(client.getTable().getNumber()));
                mp3.setText(Double.toString(client.getMoney()));
                op3.setText(add);
            } else if (client.getTable().getNumber() == 4) {
                cn4.setText(client.getName());
                tn4.setText(Integer.toString(client.getTable().getNumber()));
                mp4.setText(Double.toString(client.getMoney()));
                op4.setText(add);
            } else if (client.getTable().getNumber() == 5) {
                cn5.setText(client.getName());
                tn5.setText(Integer.toString(client.getTable().getNumber()));
                mp5.setText(Double.toString(client.getMoney()));
                op5.setText(add);
            } else if (client.getTable().getNumber() == 6) {
                cn6.setText(client.getName());
                tn6.setText(Integer.toString(client.getTable().getNumber()));
                mp6.setText(Double.toString(client.getMoney()));
                op6.setText(add);
            } else if (client.getTable().getNumber() == 7) {
                cn7.setText(client.getName());
                tn7.setText(Integer.toString(client.getTable().getNumber()));
                mp7.setText(Double.toString(client.getMoney()));
                op7.setText(add);
            }
            total+=client.getMoney();
        }
        totalMoneyPaid.setText("Total money earned by the restaurant today= "+Double.toString(total)+"$");
        showReservations.setDisable(true);
    }
    public void logout (javafx.event.ActionEvent actionEvent){
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }
}