
public class RegularVehicle implements Vehicle {
	
	private String plate;
	private Subscription sub;
	public RegularVehicle(String plate) {
		this.plate = plate;
	}

	
	@Override
	public String getPlate() {
		// TODO Auto-generated method stub
		return plate;
	}

	public Subscription getSub() {
		return sub;
	}
	
	@Override
	public Subscription getSubscription() {
		// TODO Auto-generated method stub
		return sub;
	}


	@Override
	public boolean isSpecial() {
		return false;
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}


	public void setSub(Subscription sub) {
		this.sub = sub;
	}


	@Override
	public String toString() {
		return "RegularVehicle [plate=" + plate + "]";
	}

}
