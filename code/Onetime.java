package appointments;

import java.util.Calendar;

public class Onetime extends Appointment {

	public Onetime(String description, Calendar date) {
		super(description, date);

	}
	public String getType() {
		
		return "Onetime";
	}
	
	
}
