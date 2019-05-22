
public class SubscribedVehicle implements Vehicle {
	
	
	private String plate;
	private Subscription sub;
	
	public SubscribedVehicle(String plate) {
		this.plate = plate;
	}
	@Override
	public String getPlate() {
		// TODO Auto-generated method stub
		return plate;
	}

	@Override
	public Subscription getSubscription() {
		// TODO Auto-generated method stub
		return sub;
	}

	@Override
	public boolean isSpecial() {
		// TODO Auto-generated method stub
		return false;
	}
	public void setSubscrption(Subscription sub) {
		this.sub = sub;
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "SubscribedVehicle [plate=" + plate +"]";
	}
	
}
