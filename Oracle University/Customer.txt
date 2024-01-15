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
public class Customer {

    private String name;
    private String size;
    private Clothing[] items;

    public Customer(String name, int measurement) {
        this.name = name;
        setSize(measurement);
    }
    public Customer(String name) {
        this.name = name;
    }

    public Customer() {
        this.name = "";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public void setSize(int measurement) {
        switch (measurement) {
            case 1:
            case 2:
            case 3:
                setSize("S");
                break;
            case 4:
            case 5:
            case 6:
                setSize("M");
                break;
            case 7:
            case 8:
            case 9:
                setSize("L");
                break;
            default:
                setSize("XL");
        }
    }
    public void addItems(Clothing[] items) {
        this.items = items;
    }
    public Clothing[] getItems() {
        return this.items;
    }
    public double getTotalClothingCost(int priceLimit) {
        double total = 0.0;
        System.out.println("Purchasing clothing in correct size ...");
        for (Clothing item : getItems()) {
            if (getSize().equals(item.getSize())) {
                System.out.println(item);
                total += item.getPrice();
            }
            if (total > priceLimit) {break;}
        }
        return total;
    }
    public double averagePrice(String sizeCheck) {
        double total = 0.0;
        int i = 0;
        for (Clothing item : getItems()) {
            if (item.getSize().equals(sizeCheck)) {
                total += item.getPrice();
                i++;
            }
        }
        if (i >0) {
            return (total/i);
        }else {
            return total;
        }
    }
}
