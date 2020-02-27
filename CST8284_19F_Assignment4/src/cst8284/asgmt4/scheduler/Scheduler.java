/* 
 * File name: Scheduler.java
 * Author:Min Li 
 * Course: CST8284_302_OOP
 * Assignment:4
 * Date: 2019-12-04
 * Professor: Dave Houtman
 * Purpose: This class provides save, remove, change, find, backup, and load appointments, display schedule those functions, and provide a menu to let user choose.
 */
package cst8284.asgmt4.scheduler;



import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import cst8284.asgmt4.employee.Employee;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Scheduler {

	private static Scanner scan = new Scanner(System.in);
	private ArrayList<Appointment> appointments = new ArrayList<>();
	private Employee employee;
	private static final Toolkit tk = Toolkit.getDefaultToolkit();
	private static final Dimension screenSize = tk.getScreenSize();
	private static final JTextArea scrollText = new JTextArea();
	private JFrame frame;
	private JFrame appointmentFrame;
	private JTextField fullName;
	private JTextField phoneNumber;
	private JTextField appointmentDate;
	private JTextField appointmentTime;
	private JTextField activityDescription;
	private JComboBox category;
	private Appointment editingAppointment;

	
	public Scheduler(Employee emp) {
		
		setEmployee(emp);
	}

	private void setEmployee(Employee emp) {
		this.employee = emp;
	}

	public void launch() {
		loadFrame();
	}
	
	private void loadFrame() {
		frame = new JFrame("Scheduling appointments for Dr. Andrews");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loadAppointmentsFromFile("CurrentAppointments.apts", getAppointments());

		int screenX = (int) screenSize.getWidth() / 2;
		int screenY = (int) (7 * screenSize.getHeight() / 8);

			frame.add(getWestPanel(), BorderLayout.WEST);
			frame.add(getCenterPanel(scrollText, screenY), BorderLayout.CENTER);
			frame.setPreferredSize(new Dimension(screenX, screenY));

			frame.pack();
			frame.setVisible(true);		
	}
	
	    private void loadAppointmentFrame() {
    	appointmentFrame = new JFrame();
    	appointmentFrame.setTitle("Get,set,change or delete an appointment");
        JLabel lblFName = new JLabel("Enter Client Name(as FirstName LastName:");
        fullName = new JTextField(200);
        lblFName.setLabelFor(fullName);
 
        JLabel lblPhone = new JLabel("PhoneNumber(e.g.613-555-1212:");
        phoneNumber = new JTextField(200);
        lblPhone.setLabelFor(phoneNumber);
        
        JLabel lblDate = new JLabel("Appointment Date(entered as DDMMYYYY):");
        appointmentDate = new JTextField(200);
        lblDate.setLabelFor(appointmentDate);
        
        JLabel lblTime = new JLabel("Apppointment Time:");
        appointmentTime = new JTextField(200);
        lblTime.setLabelFor(appointmentTime);
        
        JLabel lblDescription = new JLabel("Activity Description");
        activityDescription = new JTextField(200);
        lblDescription.setLabelFor(activityDescription);   
 
        JPanel panel = new JPanel();
        panel.setLayout(new SpringLayout());
 
        category  = new JComboBox(this.employee.getActivityType().toArray());
        
        panel.add(lblFName);
        panel.add(fullName);
        panel.add(lblPhone);
        panel.add(phoneNumber);
        panel.add(lblDate);
        panel.add(appointmentDate);
        panel.add(lblTime);
        panel.add(appointmentTime);
        panel.add(lblDescription);
        panel.add(activityDescription);
        panel.add(category);
     
        
        JButton findAppointment = new JButton("Find");
        JButton changeAppointment = new JButton("Change");
        JButton deleteAppointment = new JButton("Delete");
        JButton save = new JButton("Save");
        JButton exit = new JButton("Exit");
        
        findAppointment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					findAppointment();	
				} catch (BadAppointmentDataException ex) {
					showDialog(frame, "Error. Message: " + ex.getMessage() + "Description:" + ex.getDescription());
					}
			}
		});
        
        save.addActionListener( new ActionListener() {	
          	
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				saveAppointment(makeAppointment());
				showDialog(frame, "Saved appointmemt successfully");
				}catch(BadAppointmentDataException ex) {
					showDialog(frame, "Error. Message: " + ex.getMessage() + "Description:" + ex.getDescription());
				}
			}
		});
        
        exit.addActionListener( new ActionListener() {	
          	
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				appointmentFrame.dispose();
				}catch(BadAppointmentDataException ex) {
					showDialog(frame, "Error. Message: " + ex.getMessage() + "Description:" + ex.getDescription());
				}
			}
		});
        
        deleteAppointment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				if(editingAppointment!=null) {
					getAppointments().remove(editingAppointment);				
					showDialog(appointmentFrame, "Deleted.");
					}else {
						showDialog(frame, "Please find this appointment first.");					
					}
				}catch(BadAppointmentDataException ex) {
					showDialog(frame, "Error. Message: " + ex.getMessage() + "Description:" + ex.getDescription());
				}
			}      
		});
        
        
        changeAppointment.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				changeAppointment();
				}catch(BadAppointmentDataException ex) {
					showDialog(frame, "Error. Message: " + ex.getMessage() + "Description:" + ex.getDescription());
				}
			}

			private void changeAppointment() {
				if(editingAppointment!=null) {
				String name= fullName.getText();
				String phone= phoneNumber.getText();
				String date=appointmentDate.getText();
				String time=appointmentTime.getText();
				String act=activityDescription.getText();
				String actType = (String) category.getSelectedItem(); 
				
				Calendar cal = makeCalendar(date,time);
				Activity ac = new Activity();
				ac.setDescription(act);
				ac.setCategory(actType);				
				editingAppointment.setActivity(ac);
				editingAppointment.setFirstName(name.split(" ")[0]);
				editingAppointment.setLastName(name.split(" ")[1]);
				editingAppointment.setPhone(new TelephoneNumber(phone) );
				editingAppointment.setCalendar(cal);
				showDialog(appointmentFrame, "Changed.");
				}else {
					showDialog(frame, "Please find an appointment first.");					
				}				
			}
		});
              
        panel.add(findAppointment);
        panel.add(changeAppointment);
        panel.add(deleteAppointment);
        panel.add(save);
     
        SpringUtilities.makeCompactGrid(panel,
                7, 2,  //rows, cols
                6, 6,  //initX, initY
                6, 6); //xPad, yPad
         appointmentFrame.setSize(800, 700);
         appointmentFrame.getContentPane().add(panel);
         appointmentFrame.setVisible(true);
	}
	
	    
	private Appointment makeAppointment() {
		String name= fullName.getText();
		String phone= phoneNumber.getText();
		String date=appointmentDate.getText();
		String time=appointmentTime.getText();
		String act=activityDescription.getText();
		String actType = (String) category.getSelectedItem(); 
		
		Calendar cal = makeCalendar(date,time);
		Activity ac = new Activity();
		ac.setDescription(act);
		ac.setCategory(actType);
		return new Appointment(cal, name, new TelephoneNumber(phone), ac);
	}
	
	
	private void findAppointment() {
		
		String date=appointmentDate.getText();
		String time=appointmentTime.getText();
		Calendar cal = makeCalendar(date,time);
		Appointment apt =findAppointment(cal);
		if(apt==null) {
			showDialog(appointmentFrame, "No appointment found.");
		}
		else {
			showDialog(frame, apt.toString());
		fullName.setText(apt.getFirstName()+" "+apt.getLastName());
		phoneNumber.setText(apt.getPhone().getAreaCode()+"-"+apt.getPhone().getPrefix()+"-"+apt.getPhone().getLineNumber());
		appointmentDate.setText(apt.getCalendar().get(Calendar.DAY_OF_MONTH)+""+(apt.getCalendar().get(Calendar.MONTH)+1)+""+apt.getCalendar().get(Calendar.YEAR)+"");
		appointmentTime.setText(apt.getCalendar().get(Calendar.HOUR_OF_DAY)+"");
		activityDescription.setText(apt.getActivity().getDescription());			
			editingAppointment=apt;
		}     
	}
	
	private static Calendar makeCalendar(String date,String time) {
		Calendar cal = Calendar.getInstance();
		int hour = 0;
		cal.clear();
		int day = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(2, 4)) - 1; // offset by one to account for zero-based month in
																// Calendar
		int year = Integer.parseInt(date.substring(4, 8));

		if (time!=null&&!time.isEmpty()) {
			hour = processTimeString(time);
		}
		cal.set(year, month, day, hour, 0);
		return (cal);
	}

	/*
	 * private void reloadJTextArea() { StringBuilder sBuilder = new
	 * StringBuilder(); for(Appointment a: getAppointments()) {
	 * sBuilder.append(a.toString()+"\n"); }
	 * scrollText.setText(sBuilder.toString());
	 * 
	 * }
	 */

	public JPanel getCenterPanel(JTextArea jta, int height) {
		JScrollPane centerPane = new JScrollPane(jta);
		centerPane.setPreferredSize(new Dimension(400, 7 * height / 8));
		JPanel jp = new JPanel();
		jp.add(centerPane);
		return jp;
	}

	public JPanel getWestPanel() {
		JPanel controlPanel = new JPanel(new GridLayout(6, 1));
		JPanel westPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.weighty = 1;
	
		 controlPanel.add(setWestPanelBtns("    Save Appointment",new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					loadAppointmentFrame();					
				}
			}));
		 
		 
		 controlPanel.add(setWestPanelBtns("   Display Appointment ", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame diplayappointmentFrame = new JFrame();
					diplayappointmentFrame.getContentPane().setLayout(new FlowLayout());
					diplayappointmentFrame.setTitle("Please enter the appointment date");
					
					JTextField displayAppointmentDate = new JTextField("Appointment Date(entered as DDMMYYYY):", 70);
					JTextField displayAppointmentTime = new JTextField("Please enter appointment Time:", 70);
					diplayappointmentFrame.getContentPane().add(displayAppointmentDate);
					diplayappointmentFrame.getContentPane().add(displayAppointmentTime);
					JButton btn = new JButton("OK");
					diplayappointmentFrame.getContentPane().add(btn);
					btn.addActionListener(event -> {
						Calendar cal = makeCalendar(displayAppointmentDate.getText(),displayAppointmentTime.getText());
						Appointment apt = findAppointment(cal);
						JOptionPane.showMessageDialog(null, apt.toString(), "Info", 1);
						diplayappointmentFrame.dispose();
					});				
					diplayappointmentFrame.pack();
					diplayappointmentFrame.setVisible(true);			
				}
			}));		 
	
		 controlPanel.add(setWestPanelBtns("      Display Schedule ", new ActionListener() {		
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame diplayscheduleFrame = new JFrame();
					diplayscheduleFrame.getContentPane().setLayout(new FlowLayout());
					diplayscheduleFrame.setTitle("Please enter the appointment date");
			        JTextField innerAppointmentDate = new JTextField("Appointment Date(entered as DDMMYYYY):", 70);

			        diplayscheduleFrame.getContentPane().add(innerAppointmentDate);
			        JButton btn = new JButton("OK");
			        diplayscheduleFrame.getContentPane().add(btn);
			        btn.addActionListener(event -> {
			        	scrollText.setText(displayDaySchedule(makeCalendar(innerAppointmentDate.getText(),null)));
			        	diplayscheduleFrame.dispose();
			        });
			        
			        diplayscheduleFrame.pack();
			        diplayscheduleFrame.setVisible(true);
					//reloadJTextArea();
				}
			}));
		 
		 
		 controlPanel.add(setWestPanelBtns("      Save Appointments to File ",new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					saveAppointmentsToFile(getAppointments(), "CurrentAppointments.apts");
					showDialog(frame,"Saved data successfully");
				}
			}));
		 
		 
		 controlPanel.add(setWestPanelBtns("      Loaded Appointments from File ", new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					loadAppointmentsFromFile("CurrentAppointments.apts", getAppointments());
					showDialog(frame,"Load data successfully");
				}
			}));
		 
		 
		 controlPanel.add(setWestPanelBtns("      Exit  ",  new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 frame.dispose();
			}
		}));
		
		 westPanel.add(controlPanel, gbc);
		return westPanel;
	}
	
	private void showDialog(Frame frame, String msg) {
		JOptionPane.showMessageDialog(frame, msg);
	}

	private JButton setWestPanelBtns(String btnLabel, ActionListener act) {
		final Font font = new Font("SansSerif", Font.PLAIN, 20);
		JButton btn = new JButton(btnLabel);
		btn.setFont(font);
		btn.addActionListener(act);
		return btn;
	}


	private static String getResponseTo(String s) {
		System.out.print(s);
		return (scan.nextLine());
	}

	/*
	 * private Appointment makeAppointmentFromUserInput() { try { String fullName =
	 * getResponseTo("Enter Client Name (as FirstName LastName): "); String
	 * phoneNumber = getResponseTo("Phone Number (e.g. 613-555-1212): "); Calendar
	 * cal = makeCalendarFromUserInput(false); String activity =
	 * getResponseTo("Enter Activity: "); // Activity act = new Activity(activity,
	 * getEmployee().getActivityType()); Activity act = null; TelephoneNumber phone
	 * = new TelephoneNumber(phoneNumber); return (new Appointment(cal, fullName,
	 * phone, act)); } catch (BadAppointmentDataException ex) {
	 * System.out.println(ex.getMessage()); return null; } }
	 */

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
		for (Appointment apt : getAppointments()) {
			if(cal.get(Calendar.YEAR)==apt.getCalendar().get(Calendar.YEAR)
					&&cal.get(Calendar.MONTH)==apt.getCalendar().get(Calendar.MONTH)
					&&cal.get(Calendar.DAY_OF_MONTH)==apt.getCalendar().get(Calendar.DAY_OF_MONTH)
					&&cal.get(Calendar.HOUR)==apt.getCalendar().get(Calendar.HOUR)) {			
			return apt;	
		}
		}return null;
	}
	
	private boolean saveAppointment(Appointment apt) {
	
		if (apt != null) {	
			Calendar cal = apt.getCalendar(); // Check that the appointment does not already exist
			if (findAppointment(cal) == null) { // Time slot available, okay to add appointment
				appointments.add(apt);
				return true;
			} // else time slot taken, need to make another choice
		}
		return false;
	}

	/*
	 * private boolean deleteAppointment(Calendar cal) {
	 * 
	 * // if (displayAppointment(cal)) { // display existing appointment on this
	 * date/time // String okToChange =
	 * getResponseTo("\nEnter 'Yes' to delete this appointment"); // if
	 * (okToChange.trim().equals("Yes")) { // okay to proceed with change/deletion?
	 * // getAppointments().remove(findAppointment(cal)); //
	 * System.out.println("Appointment deleted"); // return true; // } else //
	 * System.out.println("Request cancelled"); // } return false; // Appointment
	 * didn't exist at the date/time specified }
	 * 
	 * private boolean changeAppointment(Calendar cal) {
	 * 
	 * // if (displayAppointment(cal)) { // display existing appointment on this
	 * date/time // String okToChange =
	 * getResponseTo("\nEnter 'Yes' to change the date and time of this appointment "
	 * ); // if (okToChange.trim().equals("Yes")) { //
	 * System.out.println("Enter new date and time"); // Calendar newCal =
	 * makeCalendarFromUserInput(false); // get new date/time // if
	 * (findAppointment(newCal) == null) { // appointment time not already taken //
	 * findAppointment(cal).setCalendar(newCal); // set new date/time in appointment
	 * // System.out.println("Appointment re-booked\n"); // return true; // new
	 * appointment time set // } else //
	 * System.out.println("That time is already booked for an appointment\n"); // }
	 * else // System.out.println("Request cancelled"); // } return false; //
	 * Appointment does not exist, was unavailable, or cancelled }
	 */
	private String displayAppointment(Calendar cal) {
		Appointment apt = findAppointment(cal);
		int hr = cal.get(Calendar.HOUR_OF_DAY);
		return (apt != null) ? "\n\n" + apt.toString() + "\n" : // Output the appointment as a string to the
																			// console, otherwise...
				"No appointment scheduled between " + hr + ":00 and " + (hr + 1) + ":00\n";
	}

	private String displayDaySchedule(Calendar cal) {
		String cummulative = new String();
		for (int hrCtr = 8; hrCtr < 17; hrCtr++) {
			cal.set(Calendar.HOUR_OF_DAY, hrCtr);
			cummulative += displayAppointment(cal) + "\n";
		}
		return cummulative;
	}

	private static boolean saveAppointmentsToFile(ArrayList<Appointment> apts, String saveFile) {
		try (FileOutputStream fos = new FileOutputStream(saveFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			for (Appointment apt : apts)
				oos.writeObject(apt);
			//System.out.println("Appointment data saved to " + saveFile);
			return true;
		} catch (IOException e) {
			System.out.println("Failed to load appointments from " + saveFile);
			return false;
		}
	}

	private static boolean loadAppointmentsFromFile(String sourceFile, ArrayList<Appointment> apts) {
		apts.clear(); // remove all existing appointments from the ArrayList before loading from file
		try (FileInputStream fis = new FileInputStream(sourceFile);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			while (true)
				apts.add((Appointment) ois.readObject());
		} catch (EOFException ex) {
			//System.out.println("Appointments successfully loaded from " + sourceFile);
			return true;
		} catch (IOException | ClassNotFoundException e) {
			return false;
		}
	}

	private ArrayList<Appointment> getAppointments() {
		return appointments;
	}

}
