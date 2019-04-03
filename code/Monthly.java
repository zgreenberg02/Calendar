package appointments;

import java.util.Calendar;

public class Monthly extends Appointment {

	public Monthly(String description, Calendar date) {
		super(description, date);
	}
	
	public boolean occursOn(int year, int month, int day) {

		if (year > super.getDate().get(Calendar.YEAR) && day == super.getDate().get(Calendar.DAY_OF_MONTH ) ) {
			System.out.println(year + " "  + month);	
			return true;
			
		}else if( month >= super.getDate().get(Calendar.MONTH) && year == super.getDate().get(Calendar.YEAR) && day == super.getDate().get(Calendar.DAY_OF_MONTH) ) {
			return true;
		}

		return false;

	}
	public String getType() {
		
		return "Monthly";
	}

}
