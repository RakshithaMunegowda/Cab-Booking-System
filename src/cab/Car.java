package cab;

public class Car extends Cab {
    private String ModelName;
    String FuelType;
    int NumberOfSeats;

    String getModelName() {
        return ModelName;
    }
    void setModelName(String ModelName) {
        this.ModelName=ModelName;
    }

    Car(String DriverName,String DriverPhoneNumber,String NumberPlate,int cost,String ModelName,String FuelType,int NumberOfSeats){
        super(DriverName,DriverPhoneNumber,NumberPlate,cost);
        this.setModelName(ModelName);
        this.FuelType=FuelType;
        this.NumberOfSeats=NumberOfSeats;
    }
    public String DisplayDetails(int distance) {
        int fare = cost * distance;
        return "\n--- Car Ride Details ---\n"
                + "Driver: " + getDriverName() + "\n"
                + "Contact: " + getDriverPhoneNumber() + "\n"
                + "Vehicle No: " + NumberPlate + "\n"
                + "Model: " + ModelName + "\n"
                + "Fuel Type: " + FuelType + "\n"
                + "Seats: " + NumberOfSeats + "\n"
                + "Distance: " + distance + " km\n"
                + "Fare: ₹" + fare + "\n";
    }
}
