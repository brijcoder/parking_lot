import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	
	List<CompactSpot> compactSpotList = new ArrayList<>();
	List<LargeSpot> largeSpotList = new ArrayList<>();
	List<BikeSpot> bikeSpotList = new ArrayList<>();
	
	int freeCompactSpot;
	int freeLargeSpot;
	int freeBikeSpot;
	
	public ParkingLot(int freeCompactSpot, int freeLargeSpot, int freeBikeSpot) {
		this.freeCompactSpot = freeCompactSpot;
		this.freeLargeSpot = freeLargeSpot;
		this.freeBikeSpot = freeBikeSpot;
	}
	
	
	// Park vehicle
	public void parkVehicle(Vehicle vehicle) {
		System.out.println("We are about to find perfect place for your vehicle tpe "+vehicle.getVehicleType());
		if(vehicle.getVehicleType().equals(VehicleType.TRUCK)) {
			if(freeLargeSpot > 0) {
				parkYourLargeVehicle(vehicle);
			}
			else
				System.out.println("Sorry we are not able to find place for you vehicle!!");
		}else if(vehicle.getVehicleType().equals(VehicleType.CAR)) {
			if(freeCompactSpot > 0)
				parkYourCompactVehicle(vehicle);
			else if(freeLargeSpot > 0)
				parkYourLargeVehicle(vehicle);
			else 
				System.out.println("Sorry we are not able to find place for you vehicle!!");
			
		}else if(vehicle.getVehicleType().equals(VehicleType.BIKE)) {
			if(freeBikeSpot > 0 )
				parkYourBike(vehicle);
			else if(freeCompactSpot > 0)
				parkYourCompactVehicle(vehicle);
			else if(freeLargeSpot > 0)
				parkYourLargeVehicle(vehicle);
			else 
				System.out.println("Sorry we are not able to find place for you vehicle!!");
		}
		
	}


	 void parkYourLargeVehicle(Vehicle vehicle) {
		LargeSpot largeSpot = new LargeSpot(ParkingSpotType.LARGE);
		largeSpot.setFree(false);
		largeSpot.setVehicle(vehicle);
		vehicle.setParkingSpot(largeSpot);
		
		
		largeSpotList.add(largeSpot);
		System.out.println("We have succesfully parked your vehicle "+vehicle.getVehicleType()+" vehicle!!");
		freeLargeSpot--;
		
	}
	
	void parkYourBike(Vehicle vehicle) {
		BikeSpot bikeSpot = new BikeSpot(ParkingSpotType.BIKE);
		bikeSpot.setFree(false);
		vehicle.setParkingSpot(bikeSpot);
		bikeSpot.setVehicle(vehicle);
		
		bikeSpotList.add(bikeSpot);
		System.out.println("We have succesfully parked your vehicle "+vehicle.getVehicleType()+" vehicle!!");
		freeBikeSpot--;
	}
	
	public void parkYourCompactVehicle(Vehicle vehicle) {
		CompactSpot compactSpot = new CompactSpot(ParkingSpotType.COMPACT);
		compactSpot.setFree(false);
		vehicle.setParkingSpot(compactSpot);
		compactSpot.setVehicle(vehicle);
		
		compactSpotList.add(compactSpot);
		System.out.println("We have succesfully parked your vehicle "+vehicle.getVehicleType()+" vehicle!!");
		freeCompactSpot--;
	}
	public void unParkVehicle(Vehicle vehicle) {
		System.out.println("Unparking is initiated of your "+vehicle.getVehicleType()+" vehicle!!");
		ParkingSpot parkingSpot = vehicle.getParkingSpot();
		parkingSpot.setFree(true);
		
		if(vehicle.getVehicleType().equals(VehicleType.TRUCK)) {
			if(largeSpotList.remove(parkingSpot)) {
				System.out.println("We have successfully removed your Vehicle !!");
				freeLargeSpot++;
			}
			else 
				System.out.println("You dont have vehicle parked in this parking lot!!");
		}
		else if(vehicle.getVehicleType().equals(VehicleType.CAR)) {
			if(compactSpotList.remove(parkingSpot)) {
				System.out.println("We have successfully removed your Vehicle !!");
				freeCompactSpot++;
			}
			else 
				System.out.println("You dont have vehicle parked in this parking lot!!");
		}
		else if(vehicle.getVehicleType().equals(VehicleType.BIKE)) {
			if(bikeSpotList.remove(parkingSpot)) {
				System.out.println("We have successfully removed your Vehicle !!");
				freeBikeSpot++;
			}
			else 
				System.out.println("You dont have vehicle parked in this parking lot!!");
		}
	}
		
}
