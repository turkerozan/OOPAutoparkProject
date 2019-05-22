public class AutoPark {
	
	private SubscribedVehicle[] subscribedVehicles;
	private ParkRecord[] parkRecords;	
    //Parktaki araclar vehicleArray dizisinde tutulur
	private double hourlyFee;
	private double incomeDaily;
	private int capacity;
	private String status = "";
	public AutoPark(double hourlyFee, int capacity)
	{
		this.hourlyFee = hourlyFee;
		this.capacity = capacity;
		subscribedVehicles = new SubscribedVehicle[100];
		parkRecords = new ParkRecord[200];
	}
    
	public boolean addVehicle(SubscribedVehicle s1)//Adds vehicle to subscribedVehicles
	{
		
		if(searchVehicle(s1.getPlate())==null) {
				int i = 0;
			while((i<subscribedVehicles.length)&&subscribedVehicles[i]!=null ) {
					i++;
				}
				if(subscribedVehicles.length == i) {
					 enlargeVehicleArray();
					 subscribedVehicles[i] = s1;
					 return true;
				}else {
					subscribedVehicles[i] = s1;
					return true;
			}
			
		}
	return false;
				
	}
	
	
	private void enlargeVehicleArray()
	{
		SubscribedVehicle[] subscribedVehicles = new SubscribedVehicle[this.subscribedVehicles.length + 1];
		System.arraycopy(this.subscribedVehicles,0,subscribedVehicles,0,this.subscribedVehicles.length);
		this.subscribedVehicles = subscribedVehicles;
		
	}
	public int getCapacity() {
		return capacity;
	}
	
	public double getHourlyFee() {
		return hourlyFee;
	}
	
	public double getIncomeDaily() {
		return incomeDaily;
	}
	
	public ParkRecord[] getParkRecords() {
		return parkRecords;
	}
	public int getParkRecordsSize()
	{
		int i = 0;
		while(parkRecords[i]!=null)
		{
			i++;
		}
		
		return i;
	}
	public String getStatus() {
		return status;
	}
	public SubscribedVehicle[] getSubscribedVehicles() {
		return subscribedVehicles;
	}

	public boolean isParked(String plate)
	{
		int i = 0;
		for(i = 0; i<parkIndis();i++) {
			if(parkRecords[i].getVehicle().getPlate().equalsIgnoreCase(plate)) {
				return true;
			}
		}
		return false;
	}

	public int parkIndis() {
		int i = 0;
		while(parkRecords[i]!=null) {
			i++;
		}
		return i;
	}
	public void saveToRecords(ParkRecord p) {
		parkRecords[getParkRecordsSize()]=p;
	}
	public SubscribedVehicle searchVehicle(String plate)
	{
		int i;
		
		for(i=0;i < subscribedVehicles.length; i++)
		{
			if(subscribedVehicles[i]!=null) {
				if(subscribedVehicles[i].getPlate().equalsIgnoreCase(plate) ){
					return subscribedVehicles[i];
				}
			}
			
		}
		
		return null;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setHourlyFee(double hourlyFee) {
		this.hourlyFee = hourlyFee;
	}

	public void setIncomeDaily(double incomeDaily) {
		this.incomeDaily = incomeDaily;
	}

	public void setParkRecords(ParkRecord[] parkRecords) {
		this.parkRecords = parkRecords;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSubscribedVehicles(SubscribedVehicle[] subscribedVehicles) {
		this.subscribedVehicles = subscribedVehicles;
	}

	public String ShowParks() {
		String result = "";
		for(int i = 0; i < getParkRecordsSize() ; i++) {
			result = result + parkRecords[i].toString();
		}
		return result;
	}

	

	@Override
	public String toString() {
		return "AutoPark : " + " hourlyFee=" + hourlyFee
				+ ", incomeDaily=" + incomeDaily + ", capacity=" + capacity;
	}

	public boolean vehicleEnters(String plate, Time enter, boolean isOfficial)
	{
		String result = "";
		Vehicle comingVehicle = null;
		ParkRecord newparking = null;
		
			if(!isParked(plate)) {
				comingVehicle = searchVehicle(plate);
				if(comingVehicle == null) {
					if(isOfficial)	comingVehicle = new OfficialVehicle(plate);
					else comingVehicle = new RegularVehicle(plate);
				} 
				
				if(capacity >=1) {
					newparking = new ParkRecord(enter,comingVehicle);
					saveToRecords( newparking);
					capacity--;
					result = "Vehicle " + plate + " is parked at " + enter.toString();
				}else {
					result = "Park is Full. Not parking..";
				}
			}else {
				result = "Vehicle is already parked";
			}
			status = result;
		return true;
	}

	public boolean vehicleExits(String plate, Time exit)
	{
		Vehicle v1 = null;
		String stat = "";
		int r = 0;
		int deletion = -1;
		for(int i = 0; i<getParkRecordsSize();i++) {
			if(parkRecords[i].getVehicle().getPlate().equalsIgnoreCase(plate)) {
				parkRecords[i].setExitTime(exit);
				deletion = i;
			}
		}
		
		
		if(isParked(plate)) {
			v1 = searchVehicle(plate);
			if(v1 == null) {
				
				v1 = parkRecords[deletion].getVehicle();
				if(v1.isSpecial()) {
				}
				else {
					r = 1;
				}
				
			} else {
				if(v1.getSubscription().isValid()) {
				}
				else {
					r = 1;	
				}
			}
			if(r==1) {
				incomeDaily = incomeDaily + Math.floor(parkRecords[deletion].getParkingDuration()/60)*hourlyFee;
			}
			
				int i = 0;
			for ( i=deletion; i<(parkRecords.length-1); i++) {
				parkRecords[i] = parkRecords[i+1];
			}
			parkRecords[i]=null;
			
			capacity++;
			return true;
		} else {
			stat = "WARN! The Vehicle " + plate + " is not parked!";
		}
		System.out.println(stat);
	return false;
	}



	
	
	
}
