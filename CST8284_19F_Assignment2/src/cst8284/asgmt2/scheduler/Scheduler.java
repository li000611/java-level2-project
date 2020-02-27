package cst8284.asgmt2.scheduler;
/*Course Name: CST8284_302
 * Student Name: Min Li
 * Class Name:  Scheduler
 * Date:  2019-10-26
 */

import java.util.Scanner;

import cst8284.asgmt2.employee.Employee;
import cst8284.asgmt2.scheduler.Appointment;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class Scheduler {

	private static Scanner scan = new Scanner(System.in);
	private ArrayList<Appointment> appointments;
	private Employee employee;

	private static final int SAVE_APPOINTMENT = 1;
	private static final int DELETE_APPOINTMENT = 2;
	private static final int CHANGE_APPOINTMENT = 3;
	private static final int DISPLAY_APPOINTMENT = 4;
	private static final int DISPLAY_SCHEDULE = 5;
	private static final int SAVE_APPOINTMENTS_TO_FILE = 6;
	private static final int LOAD_APPOINTMENTS_FROM_FILE = 7;
	private static final int EXIT = 0;

	public Scheduler(Employee emp) {
		this.appointments = new ArrayList<Appointment>();
		setEmployee(emp);
	}

	public void launch() {
		System.out.println("Scheduling appointment for " + getEmployee().getName());
		int choice = 0;
		do {
			choice = displayMenu();
			executeMenuItem(choice);
		} while (choice != EXIT);
	}

	private void setEmployee(Employee emp) {
		this.employee = emp;
	}

	private Employee getEmployee() {
		return employee;
	}

	private int displayMenu() {
		System.out.println("Enter a selection from the following menu:");
		System.out.println(SAVE_APPOINTMENT + ". Save appointment\n" + DELETE_APPOINTMENT + ". Remove appointment\n"
				+ CHANGE_APPOINTMENT + ". Change appointment\n" + DISPLAY_APPOINTMENT + ". Get appointment\n"
				+ DISPLAY_SCHEDULE + ". Display schedule\n" + SAVE_APPOINTMENTS_TO_FILE
				+ ". Backup appointments to file\n" + LOAD_APPOINTMENTS_FROM_FILE + ". Load appointments from file\n"
				+ EXIT + ". Exit program");
		int ch = scan.nextInt();
		scan.nextLine(); // 'eat' the next line in the buffer
		System.out.println();
		return ch;
	}

	private void executeMenuItem(int choice) {
		switch (choice) {
		case SAVE_APPOINTMENT:
			saveAppointment(makeAppointmentFromUserInput());
			break;
		case DELETE_APPOINTMENT:
			deleteAppointment(makeCalendarFromUserInput(false));
			break;
		case CHANGE_APPOINTMENT:
			changeAppointment(makeCalendarFromUserInput(false));
			break;
		case DISPLAY_APPOINTMENT:
			displayAppointment(makeCalendarFromUserInput(false));
			break;
		case DISPLAY_SCHEDULE:
			displayDaySchedule(makeCalendarFromUserInput(true));
			break;
		case SAVE_APPOINTMENTS_TO_FILE:
			saveAppointmentsToFile(getAppointments(), "CurrentAppointment.apts");
			break;
		case LOAD_APPOINTMENTS_FROM_FILE:
			loadAppointmentsFromFile(getAppointments(), "CurrentAppointment.apts");
			break;
		case EXIT:
			System.out.println("Exiting Scheduler\n\n");
			break;
		default:
			System.out.println("Invalid choice: try again. (Select " + EXIT + " to exit.)\n");
		}
		System.out.println(); // add blank line after each output
	}

	private boolean saveAppointment(Appointment apt) {
		// apt.getActivityType(); 
		Calendar cal = apt.getCalendar(); // Check that the appointment does not already exist
		if (findAppointment(apt.getAptDate()) == null) { // Time slot available, okay to add appointment
			getAppointments().add(apt);
			System.out.println("Appointment saved.");
			return true;
		} // else time slot taken, need to make another choice
		System.out.println("Cannot save; an appointment at that time already exists");
		return false;
	}

	private boolean deleteAppointment(Calendar cal) {
		Appointment apt=findAppointment(cal);
		if (apt != null) {
			System.out.println(findAppointment(cal).toString());
			System.out.println("Enter 'Yes' to delete this appointment ");
			String ans = scan.nextLine();
			if (ans.trim().equalsIgnoreCase("Yes")) {
				if (appointments.remove(apt)) {
					System.out.println("Appointment deleted");
					return true;
				}
			} else {
				System.out.println("Appointment is not deleted");
				
				return false;
			}
		} else {
			System.out.println("Appointment does not exist.");
			return false;
		}
		return true;
	}

	private boolean changeAppointment(Calendar cal) {
		Appointment apt=findAppointment(cal);
		if (apt != null) {
			System.out.println(apt.toString());
			System.out.println("Enter 'Yes' to change the date and time of this appointment");
			String ans = scan.nextLine();
			if (ans.equalsIgnoreCase("Yes")) {
				System.out.println("Enter new date and time");
				apt.setAptDate(makeCalendarFromUserInput(false));
				System.out.println("Appointment re-booked");
				return true;
			} else {
				System.out.println("Appointment is not changed");
				return false;
			}
		} else {
			System.out.println("Appointment does not exist.");
			return false;
		}
	}

	private void displayAppointment(Calendar cal) {
		Appointment apt = findAppointment(cal);
		int hr = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println((apt != null) ? "\n" + apt.toString() + "\n" : // Output the appointment as a string to the
																			// console, otherwise...
				"No appointment scheduled between " + hr + ":00 and " + (hr + 1) + ":00");
	}

	private void displayDaySchedule(Calendar cal) {
		for (int hrCtr = 8; hrCtr < 17; hrCtr++) {
			cal.set(Calendar.HOUR_OF_DAY, hrCtr);
			displayAppointment(cal);
		}
	}

	private static boolean saveAppointmentsToFile(ArrayList<Appointment> apts, String saveFile) {
		try {
			FileOutputStream fout = new FileOutputStream(saveFile);
			ObjectOutputStream oos = new ObjectOutputStream(fout);

			oos.writeObject(apts);
			oos.close();
			System.out.println("Appointment data saved to CurrentAppointments.apts");
			return true;
		} catch (FileNotFoundException ex) {
			System.out.println("File not found; check the path for file" + saveFile);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private static boolean loadAppointmentsFromFile(ArrayList<Appointment> apts, String sourceFile) {
		try {
			FileInputStream fis = new FileInputStream(sourceFile);
			ObjectInputStream oos = new ObjectInputStream(fis);

			apts.addAll((ArrayList<Appointment>) (oos.readObject()));

			oos.close();
            System.out.println("Appointments successfully loaded from " + sourceFile);
            
		} catch (Exception ex) {
			System.out.println("ArrayList of appointments has been loaded from file");
			return false;
		}
		return true;
	}

	private static String getResponseTo(String s) {
		System.out.print(s);
		return (scan.nextLine());
	}

	private Appointment makeAppointmentFromUserInput() {
		String fullName = getResponseTo("Enter Client Name (as FirstName LastName): ");
		String phoneNumber = getResponseTo("Phone Number (e.g. 613-555-1212): ");
		TelephoneNumber phone = new TelephoneNumber(phoneNumber);
		Calendar cal = makeCalendarFromUserInput(false);
		String description = getResponseTo("Enter Activity: ");
		Activity act = new Activity();
		act.setDescription(description);
		act.setCategory(getEmployee().getActivityType());
		return (new Appointment(cal, fullName, phone, act));
	}

	private static Calendar makeCalendarFromUserInput(boolean suppressHour) {
		Calendar cal = Calendar.getInstance();
		int hour = 0;

		cal.clear();
		String date = getResponseTo("Appointment Date (entered as DDMMYYYY): ");
		int day = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(2, 4)) - 1; // offset by one to account for zero-based month in
																// Calendar
		int year = Integer.parseInt(date.substring(4, 8));

		if (!suppressHour) {
			String time = getResponseTo("Appointment Time: ");
			hour = processTimeString(time);
		}

		cal.set(year, month, day, hour, 0);
		return (cal);
	}

	private static int processTimeString(String t) {
		int hour = 0;
		t = t.trim();
		if (t.contains(":"))
			hour = Integer.parseInt(t.split(":")[0]);
		else if (t.contains(" "))
			hour = Integer.parseInt(t.split(" ")[0]);
		else
			hour = Integer.parseInt(t);
		return ((hour < 8) ? hour + 12 : hour);
	}

	private Appointment findAppointment(Calendar cal) {
		// findAppointment()is to find the same Appointment time that saved through
		// Calendar
		for (Appointment apt : getAppointments()) {
			// To compare the appointment date and time with Calendar class.
			if (cal.equals(apt.getAptDate())) {
				return apt;
			}
		}
		// getAppointments();
		return null;
	}

	private ArrayList<Appointment> getAppointments() {
		return appointments;
	}

}