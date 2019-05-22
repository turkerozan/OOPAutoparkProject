
public class ParkRecord {
	private Time enterTime;
	private Time exitTime;
	private Vehicle vehicle;
	
	public ParkRecord(Time enterTime) {
		this.enterTime = enterTime;
	}
	public ParkRecord(Time enterTime,Vehicle vehicle) {
		this.enterTime = enterTime;
		this.vehicle = vehicle;
	}
	public Time getEnterTime() {
		return enterTime;
	}
	public Time getExitTime() {
		return exitTime;
	}
	public int getParkingDuration() {
		return exitTime.getDifference(enterTime);
			
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setExitTime(Time exitTime) {
		this.exitTime = exitTime;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	@Override
	public String toString() {
		return "ParkRecord \n Vehicle =" + vehicle.toString() + "\n" + "enterTime=" + enterTime + ", exitTime=" + exitTime + "\n";
	}
}
