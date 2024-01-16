package hrapp;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * pogi-tangkad on gitHub
 */
public class Employee {

    private int idNum;
    private String name;
    private double salary = 0.0;
    private NumberFormat nfUSD = NumberFormat.getCurrencyInstance(Locale.US);

    public Employee(int idNum, String name) {
        this.idNum = idNum;
        this.name = name;
    }

    public Employee(int idNum, String name, double salary) {
        this.idNum = idNum;
        this.name = name;
        this.salary = salary;
    }

    public int getIDNum() {
        return idNum;
    }

    public void setIDNum(int idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee: " + getIDNum() + ", " + getName() + ", " + nfUSD.format(getSalary());
    }

}
