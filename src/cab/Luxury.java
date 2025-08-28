package cab;

public class Luxury extends Car {
    Luxury(String DriverName,String DriverPhoneNumber,String NumberPlate,int cost,String ModelName,String FuelType,int NumberOfSeats){
        super(DriverName,DriverPhoneNumber,NumberPlate,cost,ModelName,FuelType,NumberOfSeats);
    }

    public String DisplayDetails(int distance) {
        return "--- Luxury Car Ride ---" + super.DisplayDetails(distance);
    }
}