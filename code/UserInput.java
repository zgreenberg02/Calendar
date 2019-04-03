package appointments;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.*;

public class UserInput {

	static ArrayList<Appointment> appointments = new ArrayList<>();

	public static void main(String[] args) {

		boolean loop = true;

		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");




		appointments.add(new Monthly("testing",  new GregorianCalendar(2018,11,1) ) );
		appointments.add(new Daily("school",  new GregorianCalendar(2018,10,1) ) );



		while(loop) {
			System.out.println("Enter what you want to do: add check save load or exit");
			String choice = in.next();
			if(choice.equals("exit")) {
				loop = false;
			}else if(choice.equals("add")) {
				System.out.println("enter the following seperating by spaces: type; Daily, Monthly, or Onetime; description; and date int the format of MM DD YYYY");
				add(in.next(), in.next(), new GregorianCalendar(in.nextInt(), in.nextInt()-1, in.nextInt()) );

			}else if(choice.equals("check")) {

				System.out.println("enter the day you would like to check in the format of MM DD YYYY");
				int month = in.nextInt();
				int day = in.nextInt();
				int year = in.nextInt();
				for(Appointment a : appointments){
					if(a.occursOn(year,month - 1,day) ) {

						System.out.println("description: " + a.getDescription() );
					}

				}

			}else if(choice.equals("save")){
				System.out.println("enter the description and date (in the format of MM DD YYYY) of the appointment you would like to save, and the name of the file you would like to save it to.");
				String de = in.next();
				int m = in.nextInt() -1;
				int d = in.nextInt() ;
				int y = in.nextInt() ;

				for(Appointment a : appointments){
					if(a.getDescription().equals(de) && a.occursOn(m ,d,y ) ) {
						FileWriter fileWriter;
						try {
							fileWriter = new FileWriter(in.next());
							BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
							bufferedWriter.write(a.getType());
							bufferedWriter.newLine();
							bufferedWriter.write(a.getDescription());
							bufferedWriter.newLine();
							bufferedWriter.write("" + a.getDate().get(Calendar.MONTH));
							bufferedWriter.newLine();
							bufferedWriter.write("" + a.getDate().get(Calendar.DAY_OF_MONTH));
							bufferedWriter.newLine();
							bufferedWriter.write("" + a.getDate().get(Calendar.YEAR));
							bufferedWriter.close();

						} catch (IOException e) {
							e.printStackTrace();
						}

					}

				}


			}else if (choice.equals("load")){

				System.out.println("Enter the file name");
				FileReader fileReader;
				BufferedReader bufferedReader;
				try {
					fileReader = new FileReader(in.next());
					bufferedReader = new BufferedReader(fileReader);
					add(bufferedReader.readLine(), bufferedReader.readLine(), new GregorianCalendar( Integer.parseInt(bufferedReader.readLine()), Integer.parseInt(bufferedReader.readLine()) , Integer.parseInt(bufferedReader.readLine()) ) ) ;
					bufferedReader.close();
				}catch(IOException e ){

					e.printStackTrace();
				}



			}else {
				System.out.println("Enter a valid option");
			}

		}

	}



	public static void add (String type, String description, Calendar date) {

		if(type.equals("Daily")) {
			appointments.add(new Daily(description, date) );
		}else if(type.equals("Monthly")) {
			appointments.add(new Monthly(description, date) );
		}else if(type.equals("Onetime")) {
			appointments.add(new Onetime(description, date) );
		}else {
			appointments.add(new Appointment(description, date) );
		}

	}

}
