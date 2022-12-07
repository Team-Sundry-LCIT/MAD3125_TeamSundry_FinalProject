package mad3125.teamsundry.finalproject.Part3;

public class Temporary implements EmployeeContract  {
    private double hourlySalary;
    private int accumulatedHours;

    public Temporary(int hourlySalary, int accumulatedHours) {
        this.hourlySalary = hourlySalary;
        this.accumulatedHours = accumulatedHours;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public int getAccumulatedHours() {
        return accumulatedHours;
    }

    public void setAccumulatedHours(int accumulatedHours) {
        this.accumulatedHours = accumulatedHours;
    }

    /**
     * Calculate the accumulated salary
     * @return accumulated salary in double
     */
    @Override
    public double accumulatedSalary() {
        return hourlySalary * accumulatedHours;
    }

    /**
     * @Overrride method return the Temporary class description in String format
     */
    @Override
    public String toString() {
        return "he is a temporary employee with " + getHourlySalary() +
                " hourly salary and he has worked for " + getAccumulatedHours() +
                " hours";
    }
}
