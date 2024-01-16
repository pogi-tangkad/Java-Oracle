package hrapp;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * pogi-tangkad on gitHub
 */
public class HRApp {

    public static void main(String[] args) {

        NumberFormat nfUSD = NumberFormat.getCurrencyInstance(Locale.US);

        System.out.println("HR App Starts");

        Department dep1 = new Department("Education");

        Employee emp1 = new Employee(101, "Ann", 1234.56);
        Employee emp2 = new Employee(102, "Bob", 1200.34);
        Employee emp3 = new Employee(103, "Ray", 1122.33);
        Employee emp4 = new Employee(104, "Deb", 2415.85);
        Employee emp5 = new Employee(105, "Allen", 1673.45);
        /*
        Employee emp6 = new Employee(106, "Dirk", 12563.54);
        Employee emp7 = new Employee(107, "Ted", 1234.56);
        Employee emp8 = new Employee(108, "Sue", 1200.34);
        Employee emp9 = new Employee(109, "Jane", 1122.33);
        Employee emp10 = new Employee(110, "Liz", 1234.56);
        Employee emp11 = new Employee(111, "Alice", 1200.34);
        Employee emp12 = new Employee(112, "Roy", 1122.33);
         */
        Employee[] empArr1 = {emp1, emp2, emp3, emp4, emp5};//, emp6, emp7, emp8, emp9, emp10, emp11, emp12,};
        for (Employee emp : empArr1) {
            dep1.addEmplloyee(emp);
        }
        System.out.println(dep1);
        dep1.listEmployees();
        //System.out.println(dep1.isEmployeeID(2));
        System.out.println("Total salary of " + dep1.getName()
                + " is: " + nfUSD.format(dep1.totalSalary()));
        System.out.println("Average salary of " + dep1.getName()
                + " is: " + nfUSD.format(dep1.averageSalary()));
    }
}
