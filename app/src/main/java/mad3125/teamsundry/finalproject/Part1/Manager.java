package mad3125.teamsundry.finalproject.Part1;


import mad3125.teamsundry.finalproject.Part2.Vehicle;

public class Manager extends Employee {
    private int travelDays;
    private int clients;

    private static final int gainFactorClient = 500;
    private static final int gainFactorTravel = 100;



    public int getTravelDays() {
        return travelDays;
    }

    public void setTravelDays(int travelDays) {
        this.travelDays = travelDays;
    }

    public int getClients() {
        return clients;
    }

    public void setClients(int clients) {
        this.clients = clients;
    }

    public Manager(String name, int birthYear, int travelDays, int clients) {
        this(name,birthYear,travelDays,clients,MAX_RATE,null);
    }

    public Manager(String name, int birthYear, int travelDays, int clients, Vehicle vehicle) {
        this(name,birthYear,travelDays,clients,MAX_RATE,vehicle);
    }

    public Manager(String name, int birthYear, int travelDays, int clients, int rate, Vehicle vehicle) {
        super(name, birthYear, rate, vehicle);
        this.travelDays = travelDays;
        this.clients = clients;
        printData();
    }

    /**
     * Calculate the manager annual income
     * @return Annual income in double
     */
    @Override
    public double getAnnualIncome() {
        double baseYearlyIncome = (getMonthlyIncome() * NO_OF_MONTHS) * getRate()/TO_PERCENTAGE;
        double clientBonus = gainFactorClient * getClients();
        double expenditure = gainFactorTravel * getTravelDays();
        return baseYearlyIncome + clientBonus + expenditure;
    }

    /**
     * Print manager related data
     * @return Manager data in String format
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n" +
                "Annual income: $" + getAnnualIncome() +
                "\n" +
                "Travelled " + getTravelDays() + " days" +
                "\n" +
                "Has brought " + getClients() + " news clients.";
    }
}
