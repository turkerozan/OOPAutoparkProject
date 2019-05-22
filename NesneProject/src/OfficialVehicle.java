
public class OfficialVehicle implements Vehicle{
	
	private String plate;
	private Subscription sub;
	public OfficialVehicle(String plate) {
		this.plate = plate;
	}
	
	@Override
	public String getPlate() {
		// TODO Auto-generated method stub
		return plate;
	}

	@Override
	public Subscription getSubscription() {
		return sub;
	}
	@Override
	public boolean isSpecial() {
	
		return true;
	}
	public void setSubscription(Subscription s) {
		this.sub = s;
	}

	@Override
	public String toString() {
		return "OfficialVehicle [plate=" + plate + "]";
	}

}
