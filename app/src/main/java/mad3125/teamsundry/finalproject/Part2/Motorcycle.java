package mad3125.teamsundry.finalproject.Part2;
public class Motorcycle extends Vehicle {
    private boolean sideCar;

    public Motorcycle(String make, String plate, String color, String category, boolean sideCar) {
        super(make, plate, color, category);
        this.sideCar = sideCar;
    }

    public boolean getSideCar() {
        return sideCar;
    }

    public void setSideCar(boolean sideCar) {
        this.sideCar = sideCar;
    }

    /**
     * Overrides method and
     * @return the Motorcycle class description in String format
     */
    @Override
    public String toString() {

        String description =
                "\n- " + (getSideCar() ? "With" : "Without") + " sidecar";

        return super.toString() + description;
    }
}
