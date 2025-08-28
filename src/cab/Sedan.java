package cab;

public class Sedan extends Car {
    Sedan(String DriverName,String DriverPhoneNumber,String NumberPlate,int cost,String ModelName,String FuelType,int NumberOfSeats){
        super(DriverName,DriverPhoneNumber,NumberPlate,cost,ModelName,FuelType,NumberOfSeats);
    }

    public String DisplayDetails(int distance) {
        return "--- Sedan Car Ride ---" + super.DisplayDetails(distance);
    }
}