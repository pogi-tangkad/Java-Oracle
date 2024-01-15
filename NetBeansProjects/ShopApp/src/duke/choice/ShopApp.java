/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duke.choice;
import java.util.Arrays;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author opc
 */
public class ShopApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Duke Choice Shop!");
        
        System.out.println(Clothing.MIN_PRICE + ", " + Clothing.TAX_RATE);
        
        // Create Customer #1
        Customer c1 = new Customer("Pinky", 3);
        
        // Create Customer #2
        Customer c2 = new Customer();
        c2.setName("Steve");
        
        // Create 4 items
        Clothing item1 = new Clothing(
                "Blue Jacket",
                "M",
                20.9);
        Clothing item2 = new Clothing(
                "Orange T-Shirt",
                "S",
                10.5);
        Clothing item3 = new Clothing(
                "Green Scarf",
                "S",
                5.0);
        Clothing item4 = new Clothing(
                "Blue T-Shirt",
                "S",
                10.5);
        
        // Create array that holds all the items
        c1.addItems(new Clothing[] {item1, item2, item3, item4});
        
        // Call goShopping method for Customer #1 to return purchased items and total cost + tax
        System.out.println("Customer: " + c1.getName() +
                                        ", size: " + c1.getSize() + 
                                        ", total with tax is: " + c1.getTotalClothingCost(15));
        
        System.out.println("The average price of 'S' clothes is: " + c1.averagePrice("S"));
        
        for (Clothing item : c1.getItems()) {
            System.out.println("Item: " + item);
        }
        System.out.println("-----------------------------------------");
        Arrays.sort(c1.getItems());
        for (Clothing item : c1.getItems()) {
            System.out.println("Item: " + item);
        }        
        
        try {
            ItemList list = new ItemList(c1.getItems());
            
            Routing routing = Routing.builder().get("/items", list).build();
            
            ServerConfiguration config = ServerConfiguration.builder()
                    .bindAddress(InetAddress.getLocalHost())
                    .port(8888).build();
            
            WebServer ws = WebServer.create(config, routing);
            ws.start();
            
        }catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        
    }
}
//https://github.com/oustudent1/helidon_support/blob/main/Helidon.zip