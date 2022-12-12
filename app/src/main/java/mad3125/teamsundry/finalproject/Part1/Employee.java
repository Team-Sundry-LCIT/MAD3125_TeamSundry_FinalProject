package mad3125.teamsundry.finalproject.Part1;
import mad3125.teamsundry.finalproject.Part2.Vehicle;
import mad3125.teamsundry.finalproject.Part3.EmployeeContract;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Employee implements Serializable {

    public static final int MAX_RATE = 100;
    public static final int MIN_RATE = 10;
    public static final int NO_OF_MONTHS = 12;
    public static final double TO_PERCENTAGE = 100.0;

    private int employeeID;
    private String name;
    private int birthYear;
    private int age;
    private double monthlyIncome;
    private int rate;

    private Vehicle vehicle;
    private EmployeeContract contract;

    public EmployeeContract getContract() {
        return contract;
    }

    public void setContract(EmployeeContract contract) {
        this.contract = contract;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract double getAnnualIncome();

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Employee(String name, int birthYear, int rate){
        this.name = name;
        this.birthYear = birthYear;
        if(rate < MIN_RATE){
            this.rate = MIN_RATE;
        }
        /*
        for else -> set rate as min value between 100 and passed argument.
        since rate shouldn't be more than 100.
         */
        else this.rate = (Math.min(rate, MAX_RATE));
    }
    public Employee(String name, int birthYear,int rate,Vehicle vehicle){
        this(name, birthYear, rate);
        this.vehicle = vehicle;
    }

    public Employee(String name, int birthYear,Vehicle vehicle){
        this(name,birthYear,MAX_RATE,vehicle);
    }



    /**
     * Print employee name and type
     */
    public void printData(){
        System.out.println("We have a new employee: " + getName() + ", a " + getClass().getSimpleName().toLowerCase() + "." );
    }

    /**
     * Calculate the current age
     * @return Age of the employee
     */
    public int calculateAge(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - getBirthYear();
    }

    /**
     * Print employee related details
     * @return All employee data
     */

    @Override
    public String toString() {
        return "Name: " + getName() + ", a " + getClass().getSimpleName() +
                "\nAge: "+ calculateAge() +
                "\n" +
                "\n"+ getVehicle() +
                "\n" +
                "\n" + "Occupation rate: " + getRate() + "%"
                ;
    }

    /**
     * Employee can be a permanent or temporary employee. He need to sign a contract. Base on the contract his salary calculated
     * and set the monthly income.
     * Print the contract detail we need a Contract object therefore we set contract object.
     * @param contract details related to the employee
     */

    public void signContract(EmployeeContract contract) {
        this.setMonthlyIncome(contract.accumulatedSalary());
        this.setContract(contract);
    }

    /**
     * This print employee contract details
     * @return Contract details of the employee
     */
    public String contractInfo() {
        return getName() + " is a " + getClass().getSimpleName().toLowerCase() +". ";
    }

    public static ArrayList<Employee> employeeList = new ArrayList<>();

}