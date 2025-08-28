package cab;

public class Cab {
    private String DriverName;
    private String DriverPhoneNumber;
    String NumberPlate;
    int cost; // cost per km

    String getDriverName() {
        return DriverName;
    }
    String getDriverPhoneNumber() {
        return DriverPhoneNumber;
    }
    void setDriverName(String DriverName) {
        this.DriverName=DriverName;
    }
    void setDriverPhoneNumber(String DriverPhoneNumber) {
        this.DriverPhoneNumber=DriverPhoneNumber;
    }

    Cab(String DriverName,String DriverPhoneNumber,String NumberPlate,int cost){
        this.setDriverName(DriverName);
        this.setDriverPhoneNumber(DriverPhoneNumber);
        this.NumberPlate=NumberPlate;
        this.cost=cost;  // cost per km
    }

    // ✅ Calculate fare based on distance
    int calculateFare(int distance) {
        return cost * distance;
    }
}