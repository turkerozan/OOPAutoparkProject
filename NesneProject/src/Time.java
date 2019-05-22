
public class Time {
	private int hour;
	private int minute;
	
	public Time() {
		// TODO Auto-generated constructor stub
	}
	
	public Time(int hour, int minute) {
		this.hour = hour; this.minute=minute;
	}

	public int getDifference(Time other) {
		Time tmp = this;
		
		if(tmp.getMinute()< other.getMinute()) {
			tmp.setHour(tmp.getHour() - 1);
			tmp.setMinute(tmp.getMinute() + 60);
		}
		return (Math.abs((tmp.getHour()-other.getHour())*60 + (tmp.getMinute() - other.getMinute())));
		
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}

	@Override
	public String toString() {
		return "hour=" + hour + ", minute=" + minute;
	}
}
