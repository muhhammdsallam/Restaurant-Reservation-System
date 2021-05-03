package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class WaiterScene {
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label11;
    @FXML
    private Label label21;
    @FXML
    private Label label111;
    @FXML
    private Label label211;
    @FXML
    private Label label1111;
    @FXML
    private Label label2111;
    @FXML
    private Label label11111;
    @FXML
    private Label label21111;
    @FXML
    private Label label111111;
    @FXML
    private Label label211111;
    @FXML
    private Label label1111111;
    @FXML
    private Label label2111111;
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

    public void printReservations2(ActionEvent actionEvent) {

        label1.setText("Not reserved");
        label2.setText("Not reserved");
        label11.setText("Not reserved");
        label21.setText("Not reserved");
        label111.setText("Not reserved");
        label211.setText("Not reserved");
        label1111.setText("Not reserved");
        label2111.setText("Not reserved");
        label11111.setText("Not reserved");
        label21111.setText("Not reserved");
        label111111.setText("Not reserved");
        label211111.setText("Not reserved");
        label1111111.setText("Not reserved");
        label2111111.setText("Not reserved");
        for (Client client : clients.getClients()) {

            int table1 =1,table2 =2,table3 =3,table4 =4,table5 =5,table6 =6,table7 =7;
            if(table1==client.getTable().getNumber()) {
                label1.setText(client.getName());
                label2.setText(client.getTable().info());
            }
            else if(table2==client.getTable().getNumber()) {
                label11.setText(client.getName());
                label21.setText(client.getTable().info());
            }
            else if(table3==client.getTable().getNumber()) {
                label111.setText(client.getName());
                label211.setText(client.getTable().info());
            }
            else if(table4==client.getTable().getNumber()) {
                label1111.setText(client.getName());
                label2111.setText(client.getTable().info());
            }
            else if(table5==client.getTable().getNumber()) {
                label11111.setText(client.getName());
                label21111.setText(client.getTable().info());
            }
            else if(table6==client.getTable().getNumber()) {
                label111111.setText(client.getName());
                label211111.setText(client.getTable().info());
            }
            else if(table7==client.getTable().getNumber()) {
                label1111111.setText(client.getName());
                label2111111.setText(client.getTable().info());
            }

        }
    }
    public void logout2(javafx.event.ActionEvent actionEvent) {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}