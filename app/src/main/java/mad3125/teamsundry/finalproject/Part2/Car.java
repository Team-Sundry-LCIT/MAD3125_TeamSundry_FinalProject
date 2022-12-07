package mad3125.teamsundry.finalproject.Part2;

public class Car extends Vehicle {

    private String gear;
    private String type;
    /**
    * All getters and Setters
    */
    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    /**
     * Constructor to pass super class data and the subclass data
     */
    public Car(String make, String plate, String color, String category, String gear, String type) {
        super(make, plate, color, category);
        this.gear = gear;
        this.type = type;
    }

    /**
     * Overrides method and
     * @return the Car class description in String format
    */
    @Override
    public String toString() {
        String description =
                "\n\t- Gear Type: " + getGear() +
                "\n\t- Type: " + getType() ;

        return super.toString() + description;
    }
}
