import java.util.Calendar;

public class Date {
	
	public static Date getToday() {
		   		//Maybe use calender class to get actual date? 
		   Calendar now = Calendar.getInstance();
		   
		   int d = now.get(Calendar.DAY_OF_MONTH);
		   int m = now.get(Calendar.MONTH);
		   int y = now.get(Calendar.YEAR);
		   
		   Date today = new Date(d,m+1,y);
		return today;	   
	   }
	public int day;
	public int month;
	
   public int year;

   public Date(int day, int month, int year)
   {
	   this.day=day;
	   this.month=month;
	   this.year = year;
   }
   
   public int getDay() {
	return day;
}
   
   public int getMonth() {
	return month;
}
  
   public int getYear() {
	return year;
}
  
	public boolean isAfterThan(Date other)
	   {
		   if(this.year > other.getYear())
		   {
			   return true;
			   
		   }
		   else if(this.year == other.getYear())
		   {
			   if(this.month > other.getMonth())
			   {
				   return true;
			   }
			   else if(this.month==other.getMonth())
			   {
				   if(this.day > other.getDay())
				   {
					   return true;
				   }
			   }
			   
		   }
		  return false;
	   }
	
	public boolean isBeforeThan(Date other)
	   {
		   if(this.isEqualsWith(other)==true) {
			   return false;
		   }
		   else if(this.isAfterThan(other)) {
			   return false;
		   }
		   else {
			   return true;
		   }
		   
	   }
	
	public boolean isEqualsWith(Date other)
	   {
	            if(this.day == other.getDay())
	            {
	            	if(this.month == other.getMonth())
	            	{
	            		if(this.year == other.getYear())
	            		{
	            			return true;
	            		}
	            	}
	            }
	            
	            return false;
	   }
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return " Day=" + day + ", month=" + month + ", year=" + year;
	}
	
	
	}
