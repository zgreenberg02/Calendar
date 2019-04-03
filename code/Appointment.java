package appointments;


import java.util.Calendar;

public class Appointment {
	private String description;
	private Calendar date;

	
	public Appointment(String description, Calendar date ){
		 this.description = description;
		 this.date = date ;
	}
	
	public boolean occursOn(int year, int month, int day) {
		
		if(year == date.get(Calendar.YEAR) && month == date.get(Calendar.MONTH)  && day == date.get(Calendar.DAY_OF_MONTH) ) {
			
			return true;
		}
		
		return false;
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	public String getType() {
		
		return "";
	}
	
	
	
	
	
}
