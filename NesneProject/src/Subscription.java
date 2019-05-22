public class Subscription {
	public Date begin;
	public Date end;
	public SubscribedVehicle vehicle;
	
  public Subscription(Date begin, Date end, String plate)
  {
	  this.end = end;
	  this.begin = begin;
	  this.vehicle = new SubscribedVehicle(plate);
      //use plate to create vehicle
  }
  
  
  public Date getBegin() {
	return begin;
}


public Date getEnd() {
	return end;
}


public SubscribedVehicle getVehicle() {
	return vehicle;
}


public boolean isValid()
  {
	  if(Date.getToday().isBeforeThan(end) ||  Date.getToday().isEqualsWith(end)) {
		  if((Date.getToday().isAfterThan(begin)) || (Date.getToday().isEqualsWith(begin))) {
			  return true;
		  }
	  }
	  return false;
  }


public void setBegin(Date begin) {
	this.begin = begin;
}


public void setEnd(Date end) {
	this.end = end;
}


public void setVehicle(SubscribedVehicle vehicle) {
	this.vehicle = vehicle;
}


@Override
public String toString() {
	return "Subscription Vehicle Plate " + vehicle.getPlate() + "\n"
			+ "Begin=" + begin.toString() + ", End=" + end.toString() + "\n";
}

}