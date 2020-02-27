package cst8284.asgt1.scheduler;

/*Course Name: CST8284_300
 * Student Name: Min Li
 * Class Name:  Scheduler
 * Date:  2019-9-25
 */

import java.util.Calendar;
import java.util.Scanner;



public class Scheduler {
	private static Scanner scan;
	private Appointment[] appointments;
	private int aptIndex;
	
	private static final int SAVE_APPOINTMENT = 1;
	private static final int DISPLAY_APPOINTMENT =2;
	private static final int DISPLAY_SCHEDULE= 3;
	private static final int EXIT =0;
	
	public Scheduler() {
	    scan = new Scanner(System.in);
	    appointments = new Appointment[200];
	}
	
	public void launch() {
	int k;
	    do {
	        k = displayMenu();
	        scan.nextLine();
	        executeMenuItem(k);
	        System.out.println();
	    }while(k!=0);
		executeMenuItem(k);
		}
	
	private int displayMenu() {
	
		System.out.format(
        	"Enter a selection from the following menu"+
      		"\n1. Save appointment"+
            "\n2. Get appointment"+
            "\n3. Display schedule"+
            "\n0.  Exit program\n");
		int mychoice = scan.nextInt();
        return(mychoice);
	}

	private void executeMenuItem(int choice) {
	    
	    switch (choice) {
        case SAVE_APPOINTMENT:
            saveAppointmentToArray(makeAppointmentFromUserInput());
            break;
        case DISPLAY_APPOINTMENT:
            displayAppointment();
            break;

        case DISPLAY_SCHEDULE:
            displaySchedule();
            break;

        case EXIT:
            System.out.println("Exiting Scheduler");
            System.exit(1);
            break;

        default:
            System.out.println("Bad Input Choice; Exiting\n");
            System.exit(1);
            break;
        }
	}
	
	private void displaySchedule() {
	    int dailyIndex = 0;
	    //declare an array of Type Appointment. 
	    Appointment[]  dailyAppointments = new Appointment[9];
      
        Calendar date = makeCalendarFromUserInput(true);
        for (int i = 0; i < aptIndex; i++) {
            Calendar apt = appointments[i].getAptDate();
            
            //match the input date
            if (date.get(Calendar.YEAR) == apt.get(Calendar.YEAR) && date.get(Calendar.MONTH) == apt.get(Calendar.MONTH)
                    && date.get(Calendar.DATE) == apt.get(Calendar.DATE)) {

                dailyAppointments[dailyIndex] = appointments[i];
                dailyIndex++;
            }
        }
        
        //loop hours in the day   range[8:00--17:00]
        for(int i =8; i< 17; i++) {
            boolean hasApt = false;
            for(int j = 0; j< dailyIndex; j++) {
                if(i == dailyAppointments[j].getAptDate().get(Calendar.HOUR_OF_DAY)) {
                    System.out.println(dailyAppointments[j]);
                    hasApt = true;
                }
              }          
            // inject non-appointed message.
            if(!hasApt) {
                System.out.println("No appointment scheduled between "+i+":00 and "+(i+1)+":00");
            }           
        }        
    }

    private void displayAppointment() {
	    boolean isempty = true;
        Calendar date = makeCalendarFromUserInput(true);
        String strtime = getResponseTo("Appointment Time:");
        int time = processTimeString(strtime);
        for (int i = 0; i < getAptIndex(); i++) {
            Calendar apt = appointments[i].getAptDate();
            
            //reference: https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
            
            if (date.get(Calendar.YEAR) == apt.get(Calendar.YEAR) && date.get(Calendar.MONTH) == apt.get(Calendar.MONTH)
                    && date.get(Calendar.DATE) == apt.get(Calendar.DATE)
                    && time== apt.get(Calendar.HOUR_OF_DAY)) {
                System.out.println(appointments[i]);
                isempty = false;
                break;
            }
        }
        if (isempty) {
            int t = time;
            System.out.println("No appointment scheduled between " + t + ":00 and " + (t + 1) + ":00");
        }        
    }

    private boolean saveAppointmentToArray(Appointment apointment) {
	    
	    if (apointment == null) {
	        System.out.println("Cannot save; an appointment at that time already\r\n" + "exists");
            return false;
    }
           
            appointments[aptIndex] = apointment;
            ++aptIndex;
            System.out.println("Appointment saved.");
            return true;
	}
	
	private String getResponseTo(String s) {
		System.out.print(s);
		return (scan.nextLine());		
	}
	
	private Appointment makeAppointmentFromUserInput() {
	       Appointment newApt = null;
	        String flName = getResponseTo("Enter Client Name (as FirstName LastName):");
	        TelephoneNumber phone = new TelephoneNumber(getResponseTo("Phone Number (e.g. 613-555-1212):"));
	        Calendar date = makeCalendarFromUserInput(true);
	        String strtime = getResponseTo("Appointment Time:");
	        int time = processTimeString(strtime);
	        Activity activity = new Activity(getResponseTo("Enter Activity:"));
	        boolean availble = true;
	        for (int i = 0; i < getAptIndex(); i++) {
	            Calendar apt = appointments[i].getAptDate();
	            if (date.get(Calendar.YEAR) == apt.get(Calendar.YEAR) && date.get(Calendar.MONTH) == apt.get(Calendar.MONTH)
	                    && date.get(Calendar.DATE) == apt.get(Calendar.DATE)) {
	                if (apt.get(Calendar.HOUR_OF_DAY) == time) {
	                    availble = false;
	                    break;
	                }
	            }
	        }
	        if (availble) {
	            date.set(Calendar.HOUR_OF_DAY, time);
	            newApt = new Appointment(date, flName, phone, activity);
	        } 
	        return newApt;    
	}
	
	private Calendar makeCalendarFromUserInput(boolean suppressHour) {
	    Calendar calendar = Calendar.getInstance();
        String date = getResponseTo("Appointment Date (entered as DDMMYYYY):");
        int year = Integer.parseInt(date.substring(4, 8));
        int month = Integer.parseInt(date.substring(2, 4)) - 1; // Month range [0--11] in calss Calendar
        int day = Integer.parseInt(date.substring(0, 2));
        calendar.set(year, month, day);
        if (suppressHour) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
        }
        return calendar;
	}
	
    private int processTimeString(String t) {
        int time = 0;
        String strtime = "";
        if (t.contains("m")) {
        	
        	//reference:https://www.w3docs.com/snippets/java/how-to-split-a-string-in-java.html
        	//reference:https://tecadmin.net/ternary-operator-in-java/
            strtime = t.contains(":")? t.split(":")[0]:t.split(" ")[0];
            time = t.contains("a")? Integer.parseInt(strtime) : Integer.parseInt(strtime) + 12;
        
        } else {
            strtime = t.contains(":")? t.split(":")[0]:t;
            time = Integer.parseInt(strtime);
        }
        return time;
    }

	private int getAptIndex() {
		return this.aptIndex;
	}
}