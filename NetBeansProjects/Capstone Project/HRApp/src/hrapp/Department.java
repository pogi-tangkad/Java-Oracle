package hrapp;

/**
 *
 * pogi-tangkad on gitHub
 */
public class Department {

    private String name;
    private Employee[] empArr = new Employee[10];
    private double salary = 0.0;
    private int empCount = 0;
    private final static int EMP_MAX = 10;

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, Employee[] empArr) {
        this.name = name;
        if (empArr.length <= EMP_MAX) {
            this.empArr = empArr;
        } else {
            System.out.println("Number of employees in list exceeds maximum of " + EMP_MAX);
        }
        for (Employee emp : empArr) {
            this.salary += emp.getSalary();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee[] getEmpArr() {
        return empArr;
    }

    public void setEmpArr(Employee[] empArr) {
        this.empArr = empArr;
    }

    public int getEmpCount() {
        return empCount;
    }

    public void setEmpCount(int empCount) {
        this.empCount = empCount;
    }

    public void addEmplloyee(Employee emp) {
        if (this.empCount < EMP_MAX) {
            empArr[getNumberOfEmployees()] = emp;
            this.salary += emp.getSalary();
            empCount++;
        } else {
            System.out.println("Max Employees Reached for: " + this.name);
        }
    }

    public void listEmployees() {
        for (int i = 0; i < this.empCount; i++) {
            System.out.println(empArr[i]);
        }
    }

    public int getNumberOfEmployees() {
        return this.empCount;
    }

    public Employee isEmployeeID(int idNum) {
        for (int i = 0; i < this.empCount; i++) {
            if (empArr[i].getIDNum() == idNum) {
                return empArr[i];
            }
        }
        return null;
    }

    public double totalSalary() {
        return this.salary;
    }

    public double averageSalary() {
        if (getNumberOfEmployees() > 0) {
            return (totalSalary() / getNumberOfEmployees());
        } else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return "Department: " + getName()
                + "\nNumber of Employees: " + this.empCount;
    }

}
