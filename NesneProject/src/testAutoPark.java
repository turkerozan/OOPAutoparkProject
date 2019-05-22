import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testAutoPark {

	@Test
	void test() {
		
		Date d1 = new Date(13,2, 2019);
		Date d2 = new Date(13,6, 2022);
		boolean b = d1.isAfterThan(d2);
		assertEquals(false,b);
		
		b = d1.isBeforeThan(d2);
		assertEquals(true,b);
		
		Time t1 = new Time(13,30);
		Time t2 = new Time(15,20);
		int result = t1.getDifference(t2);
		assertEquals(result,110);
		
		d1.setYear(2010);
		d2.setYear(2022);
		Subscription s1 = new Subscription(d1,d2,"34sa45");
		
		assertEquals(true,s1.isValid());
		
		assertEquals("34sa45",s1.getVehicle().getPlate());
		
		AutoPark ap = new AutoPark(100,100);
		ap.addVehicle(s1.getVehicle());
		assertEquals(s1,s1);
		//ap.getVehicleArray().add(s1.getVehicle());
		Vehicle v = s1.getVehicle();
		assertEquals("34sa45",s1.getVehicle().getPlate());
	}
}
