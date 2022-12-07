package mad3125.teamsundry.finalproject.Part1;


import mad3125.teamsundry.finalproject.Part2.Vehicle;

public class Tester extends Employee{

    private int bugs;
    private static final int gainFactorError = 10;

    public int getBugs() {
        return bugs;
    }

    public void setBugs(int bugs) {
        this.bugs = bugs;
    }

    public Tester(String name, int birthYear, int bugs, int rate){
        this(name,birthYear,bugs,rate,null);
    }
    public Tester(String name, int birthYear, int bugs, int rate, Vehicle vehicle){
        super(name,birthYear,rate,vehicle);
        this.bugs = bugs;
        printData();
    }

    /**
     * Calculate the manager annual income
     * @return Annual income in double
     */
    @Override
    public double getAnnualIncome() {
        double baseYearlyIncome = (getMonthlyIncome() * NO_OF_MONTHS) * getRate()/TO_PERCENTAGE;
        double bonus = gainFactorError * getBugs();
        return baseYearlyIncome + bonus;
    }
    /**
     * Print tester related data
     * @return Tester data in String format
     */
    @Override
    public String toString() {
        return super.toString() +
                " and corrected " + getBugs() + " bugs." +
                "\nHis/Her estimated annual income is " + getAnnualIncome();
    }
}
