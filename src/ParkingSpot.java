
public class ParkingSpot {
	private ParkingSpotType type;
	private Vehicle vehicle;
	private Boolean free;
	
	public ParkingSpot(ParkingSpotType parkingSpotType) {
		this.type = parkingSpotType;
	}
	
	
	
	//Getters and setters 
	public ParkingSpotType getType() {
		return type;
	}
	public void setType(ParkingSpotType type) {
		this.type = type;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Boolean getFree() {
		return free;
	}
	public void setFree(Boolean free) {
		this.free = free;
	} 
	
}
