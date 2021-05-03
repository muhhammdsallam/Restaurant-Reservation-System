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


public class CookerScene {
    @FXML
    private Label platetxt;
    @FXML
    private Label platetxt1;
    @FXML
    private Label platetxt2;
    @FXML
    private Label platetxt3;
    @FXML
    private Label platetxt4;
    @FXML
    private Label platetxt5;
    @FXML
    private Label platetxt6;
    @FXML
    private Label tabletxt;
    @FXML
    private Label tabletxt1;
    @FXML
    private Label tabletxt2;
    @FXML
    private Label tabletxt3;
    @FXML
    private Label tabletxt4;
    @FXML
    private Label tabletxt5;
    @FXML
    private Label tabletxt6;
    @FXML
    private Button showbtn;

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

    public void printReservations3(ActionEvent actionEvent) {
        String add;
        for (Client client : clients.getClients()) {
            add="";
            for(Dish dish: client.getDishes().getDishesInfo()){
                add += dish.printDishes();
            }
            if (client.getTable().getNumber() == 1) {
                tabletxt.setText(Integer.toString(client.getTable().getNumber()));
                platetxt.setText(add);
            } else if (client.getTable().getNumber() == 2) {
                tabletxt1.setText(Integer.toString(client.getTable().getNumber()));
                platetxt1.setText(add);
            } else if (client.getTable().getNumber() == 3) {
                tabletxt2.setText(Integer.toString(client.getTable().getNumber()));
                platetxt2.setText(add);
            } else if (client.getTable().getNumber() == 4) {
                tabletxt3.setText(Integer.toString(client.getTable().getNumber()));
                platetxt3.setText(add);
            } else if (client.getTable().getNumber() == 5) {
                tabletxt4.setText(Integer.toString(client.getTable().getNumber()));
                platetxt4.setText(add);
            } else if (client.getTable().getNumber() == 6) {
                tabletxt5.setText(Integer.toString(client.getTable().getNumber()));
                platetxt5.setText(add);
            } else if (client.getTable().getNumber() == 7) {
                tabletxt6.setText(Integer.toString(client.getTable().getNumber()));
                platetxt6.setText(add);
            }

        }
        // platetxt.setText(add);
        //showbtn.setDisable(true);
    }

    public void logout3 (javafx.event.ActionEvent actionEvent){
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }
}