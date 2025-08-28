package cab;

public class AutoRikshaw extends Cab {
    private String ModelName;

    String getModelName() {
        return ModelName;
    }
    void setModelName(String ModelName) {
        this.ModelName=ModelName;
    }

    AutoRikshaw(String DriverName,String DriverPhoneNumber,String NumberPlate,int cost,String ModelName){
        super(DriverName,DriverPhoneNumber,NumberPlate,cost);
        this.setModelName(ModelName);
    }

    public String DisplayDetails(int distance) {
        int fare = cost * distance;
        return "\n--- AutoRickshaw Ride Details ---\n"
                + "Driver: " + getDriverName() + "\n"
                + "Contact: " + getDriverPhoneNumber() + "\n"
                + "Vehicle No: " + NumberPlate + "\n"
                + "Model: " + ModelName + "\n"
                + "Distance: " + distance + " km\n"
                + "Fare: ₹" + fare + "\n";
    }
}