package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class clientController {
    @FXML
    private Label clientNameTxt;
    @FXML
    private TextField tableNumber;
    @FXML
    private TextField seatsNumber;
    @FXML
    private TextField txtArea;
    @FXML
    private Label tableNumberAlert;
    @FXML
    private TextField plateName;
    @FXML
    private TextField quantity;
    @FXML
    private Label menuAlert;
    @FXML
    private Label totalMoney;
    @FXML
    private Label lblClient;
    @FXML
    private Button showReservations;
    @FXML
    private Label doneMessage;

    private double quantity2;
    private String clientNameTxt2;
    private int flag;
    private int flag2;
    private int i=0;
    //  private int tableNumber2;

    private double totalPrice=0;
    public void creatingArrayList() {
        //Clients clients = new Clients();
        clients.setClients(new ArrayList<Client>());

    }
    Client client1 = new Client();

    //  Dishes dishes1=new Dishes();

    List<Dish> dishes1 = new ArrayList<Dish>();

    JAXBContext jaxbContext;
    Clients clients = new Clients();

    public double getQuantity2() {
        return quantity2;
    }

    {
        try {
            jaxbContext = JAXBContext.newInstance(Clients.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            clients = (Clients) unmarshaller.unmarshal(new File("Saved.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void setClientNameTxt(String clientNameTxt2) {
        this.clientNameTxt2 = clientNameTxt2;
        clientNameTxt.setText("Welcome "+clientNameTxt2+"!");
    }


    public void saveData(ActionEvent actionEvent) {

        if (tableNumber.getText().equals("") || seatsNumber.getText().equals("") || txtArea.getText().equals("")) {
            tableNumberAlert.setText("enter all fields!");

        } else if ((tableNumber.getText().equals("1") && seatsNumber.getText().equals("5") && txtArea.getText().equals("Non smoking"))
                || ((tableNumber.getText().equals("2") && seatsNumber.getText().equals("12") && txtArea.getText().equals("Non smoking"))
                || (tableNumber.getText().equals("3") && seatsNumber.getText().equals("12") && txtArea.getText().equals("Smoking"))
                || (tableNumber.getText().equals("4") && seatsNumber.getText().equals("4") && txtArea.getText().equals("Non smoking"))
                || (tableNumber.getText().equals("5") && seatsNumber.getText().equals("4") && txtArea.getText().equals("Smoking"))
                || (tableNumber.getText().equals("6") && seatsNumber.getText().equals("7") && txtArea.getText().equals("Smoking"))
                || (tableNumber.getText().equals("7") && seatsNumber.getText().equals("6") && txtArea.getText().equals("Smoking")))) {

            int i ;
            try {
                for (Client client : clients.getClients()) {

                    i=Integer.parseInt(tableNumber.getText());
                    if (i == client.getTable().getNumber()) {
                        flag=1;
                        tableNumberAlert.setText("sorry the table is already taken!");
                        /*tableNumber.setText("");
                        seatsNumber.setText("");
                        txtArea.setText("");*/
                    }else{
                        client1.setName(clientNameTxt2);
                        int a = Integer.parseInt(tableNumber.getText());
                        client1.getTable().setNumber(a);
                        int j = Integer.parseInt(seatsNumber.getText());
                        client1.getTable().setNumber_of_seats(j);
                        if (txtArea.getText().equals("Smoking"))
                            client1.getTable().setSmoking(true);
                        else {
                            client1.getTable().setSmoking(false);
                            client1.getTable().setReserved(true);
                            tableNumberAlert.setText("Table saved!");
                            totalMoney.setText("0");
                        }
                      }

                }
            }catch (Exception e){
                e.printStackTrace();
            }

            flag=0;
        }
        else {
            tableNumberAlert.setText("Please check data entered, Thank you!");
        }

    }

    public void addDish(ActionEvent actionEvent) {



        if(plateName.getText().equals("") || quantity.getText().equals("") || (tableNumber.getText().equals("") && seatsNumber.getText().equals("") && txtArea.getText().equals(""))){

            menuAlert.setText("Please Enter all fields");
        }
        else if(plateName.getText().equals("Greek Salad") && Integer.parseInt(quantity.getText())>0)
        {
            Dish dish = new Dish();
            quantity2=Double.parseDouble(quantity.getText());
            totalPrice=Double.parseDouble(totalMoney.getText())+((35+(35*0.1))*quantity2);
            totalMoney.setText(Double.toString(totalPrice));
            menuAlert.setText("Dish Added!");
            dish.setDishName("Greek Salad");
            dish.setType("Appetizer");
            dish.setPrice(35+(35*0.1));
            dish.setQuantity((int) quantity2);
            dishes1.add(dish);

        }
        else if(plateName.getText().equals("Fried Potatoes") && Integer.parseInt(quantity.getText())>0)
        {
            Dish dish1 = new Dish();
            quantity2=Double.parseDouble(quantity.getText());
            totalPrice=Double.parseDouble(totalMoney.getText())+((30+(30*0.1))*quantity2);
            totalMoney.setText(Double.toString(totalPrice));
            menuAlert.setText("Dish Added!");
            dish1.setDishName("Fried Potatoes");
            dish1.setType("Appetizer");
            dish1.setPrice(30+(30*0.1));
            dish1.setQuantity((int) quantity2);
            dishes1.add(dish1);

        }

        else if(plateName.getText().equals("Grilled Chicken") && Integer.parseInt(quantity.getText())>0)
        {
            Dish dish2 = new Dish();
            quantity2=Double.parseDouble(quantity.getText());
            totalPrice=Double.parseDouble(totalMoney.getText())+((70+(70*0.15))*quantity2);
            totalMoney.setText(Double.toString(totalPrice));
            menuAlert.setText("Dish Added!");
            dish2.setDishName("Grilled Chicken");
            dish2.setType("Main Course");
            dish2.setPrice(70+(70*0.15));
            dish2.setQuantity((int) quantity2);
            dishes1.add(dish2);
        }

        else if(plateName.getText().equals("Beef Steak") && Integer.parseInt(quantity.getText())>0)
        {
            Dish dish3 = new Dish();
            quantity2=Double.parseDouble(quantity.getText());
            totalPrice=Double.parseDouble(totalMoney.getText())+((80+(80*0.15))*quantity2);
            totalMoney.setText(Double.toString(totalPrice));
            menuAlert.setText("Dish Added!");
            dish3.setDishName("Beef Steak");
            dish3.setType("Main Course");
            dish3.setPrice(80+(80*0.15));
            dish3.setQuantity((int) quantity2);
            dishes1.add(dish3);
        }

        else if(plateName.getText().equals("Mushroom Soup") && Integer.parseInt(quantity.getText())>0)
        {
            Dish dish4 = new Dish();
            quantity2=Double.parseDouble(quantity.getText());
            totalPrice=Double.parseDouble(totalMoney.getText())+((60+(60*0.15))*quantity2);
            totalMoney.setText(Double.toString(totalPrice));
            menuAlert.setText("Dish Added!");
            dish4.setDishName("Mushroom Soup");
            dish4.setType("Main Course");
            dish4.setPrice(60+(60*0.15));
            dish4.setQuantity((int) quantity2);
            dishes1.add(dish4);
        }

        else if(plateName.getText().equals("Apple Pie") && Integer.parseInt(quantity.getText())>0)
        {
            Dish dish5 = new Dish();
            quantity2=Double.parseDouble(quantity.getText());
            totalPrice=Double.parseDouble(totalMoney.getText())+((50+(50*0.2))*quantity2);
            totalMoney.setText(Double.toString(totalPrice));
            menuAlert.setText("Dish Added!");
            dish5.setDishName("Apple Pie");
            dish5.setType("Desert");
            dish5.setPrice(50+(50*0.2));
            dish5.setQuantity((int) quantity2);
            dishes1.add(dish5);
        }

        else if(plateName.getText().equals("Molten Cake") && Integer.parseInt(quantity.getText())>0)
        {
            Dish dish6 = new Dish();
            quantity2=Double.parseDouble(quantity.getText());
            totalPrice=Double.parseDouble(totalMoney.getText())+((60+(60*0.2))*quantity2);
            totalMoney.setText(Double.toString(totalPrice));
            menuAlert.setText("Dish Added!");
            dish6.setDishName("Molten Cake");
            dish6.setType("Desert");
            dish6.setPrice(60+(60*0.2));
            dish6.setQuantity((int) quantity2);
            dishes1.add(dish6);

        }
        else{
            menuAlert.setText("Please check data entered, Thank you!");
        }
        quantity.setText("");
        plateName.setText("");
        client1.setMoney(totalPrice);
        client1.getDishes().setDishesInfo(dishes1);



    }

    public void saveAllData(ActionEvent actionEvent) {
        //making client orders
        if(tableNumber.getText().equals("")||seatsNumber.getText().equals("")||txtArea.getText().equals("")){
            menuAlert.setText("Please fill all the fields, Thank you!");
        }else {
            clients.getClients().add(client1);
            if (flag == 0) {
                JAXBContext jaxbContext = null;
                try {
                    jaxbContext = JAXBContext.newInstance(Clients.class);
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    //Marshal the clients list in file
                    jaxbMarshaller.marshal(clients, new File("Saved.xml"));
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                tableNumber.setText("");
                seatsNumber.setText("");
                txtArea.setText("");
                tableNumberAlert.setText("Saved!");
                // tableNumberAlert.setText(client1.table.info());
                doneMessage.setText("Thank you for your reservation.");
            }
        }
    }

    public void logout1(javafx.event.ActionEvent actionEvent) {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void mousePress(MouseEvent mouseEvent) {
        menuAlert.setText("");
    }
}