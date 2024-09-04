import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name , int id){
        this.name = name;
        this.id = id;
    }

    // using encapsulation for security purpose , not providing acces of name and id directly using getname and getiD instead

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    // create abstract method for calculating salary
    public abstract double calculateSalary();

    // using polymorphism
    @Override
    public String toString() {
        return "Employee[name = " + name + " , id = " + id + "salary = " + calculateSalary() + "]";
    }
}

class fullTimeEmployee extends Employee{

    private double monthlySalary;

    public fullTimeEmployee(String name , int id , double monthlySalary){
        super(name ,id); // parent class ka constructor run krne ke liye super class use ki jati h
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary(){ // overriding abstact class abstract method to give it body
        return monthlySalary;
    }
}

class partTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public partTimeEmployee(String name , int id , int hoursWorked , double hourlyRate){
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}


class payrollSystem{
    private static ArrayList<Employee> employeeList;

    // create a list to store employees
    public payrollSystem(){
        employeeList = new ArrayList<>();
    }

    // add employee into the list
    public static void addEmployees(Employee employee){
        employeeList.add(employee);
    }

    // remove employee from list using user id
    public static void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }

    public static void displayEmployees(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        payrollSystem PayrollSys = new payrollSystem();
        fullTimeEmployee emp1 = new fullTimeEmployee("vikas" , 221048 , 15000);
        partTimeEmployee emp2 = new partTimeEmployee("rohit" , 245876 , 48 , 100);

        payrollSystem.addEmployees(emp1);
        payrollSystem.addEmployees(emp2);

        System.out.println("Initial Employee details: ");
        payrollSystem.displayEmployees();

        // removing employee
        payrollSystem.removeEmployee(221048);
        // remaining employees
        System.out.println("Remaining Employee: ");
        payrollSystem.displayEmployees();
    }
}