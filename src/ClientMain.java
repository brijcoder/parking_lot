
public class ClientMain {

	public static void main(String[] args) {
		ParkingLot parkingLot = new ParkingLot(2, 2, 2);
		
		Vehicle truck = new Vehicle(VehicleType.TRUCK);
		//Vehicle car = new Vehicle(VehicleType.CAR);
		Vehicle car = new Vehicle(VehicleType.CAR);
		parkingLot.parkVehicle(car);
		parkingLot.parkVehicle(truck);
		parkingLot.unParkVehicle(truck);
		parkingLot.unParkVehicle(truck);
	}
}


// make it at least 3-4 floor and return parking spot. 
// add location in this and mark the parking point. 
//
//
