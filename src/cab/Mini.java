package cab;

public class Mini extends Car {
    Mini(String DriverName,String DriverPhoneNumber,String NumberPlate,int cost,String ModelName,String FuelType,int NumberOfSeats){
        super(DriverName,DriverPhoneNumber,NumberPlate,cost,ModelName,FuelType,NumberOfSeats);
    }

    public String DisplayDetails(int distance) {
        return "--- Mini Car Ride ---" + super.DisplayDetails(distance);
    }
}