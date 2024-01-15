/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duke.choice;

/**
 *
 * @author opc
 */
public class Clothing implements Comparable<Clothing> {

    private String description,
            size = "M";
    private double price;
    public final static double MIN_PRICE = 10.0;
    public final static double TAX_RATE = 0.2;

    public Clothing(String des, String size, double price) {
        this.description = des;
        this.size = size;
        setPrice(price);
    }
    public Clothing(){
        setPrice(0.0);
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return this.price * (1 + TAX_RATE);
    }

    public void setPrice(double price) {
        this.price = (price >= MIN_PRICE) ? price : MIN_PRICE;
    }
    
    @Override
    public String toString() {
        return getDescription() + "," + getSize() + "," + this.price;
    }
   
    @Override
    public int compareTo(Clothing cl) {
        return getDescription().compareTo(cl.getDescription());
    }

}
