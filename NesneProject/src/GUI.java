import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;


public class GUI {

	private static AutoPark autopark;
	/**
	 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmPleaseCreateAutopark.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JFrame frmPleaseCreateAutopark;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField d1;
	private JTextField m1;
	private JTextField y1;
	private JTextField d2;
	private JTextField m2;
	private JTextField y2;
	private JTextField plateS;
	public JTextPane textPane_1;
	private JTextField textField_2;

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPleaseCreateAutopark = new JFrame();
		frmPleaseCreateAutopark.setTitle("Please Create Autopark First");
		frmPleaseCreateAutopark.setBounds(100, 100, 801, 618);
		frmPleaseCreateAutopark.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPleaseCreateAutopark.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 11, 284, 114);
		frmPleaseCreateAutopark.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 46, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblOtoparkOlustur = new JLabel("AUTOPARK");
		lblOtoparkOlustur.setBounds(91, 11, 86, 14);
		panel.add(lblOtoparkOlustur);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(134, 46, 86, 20);
		panel.add(textField_1);
		
		JLabel lblHourlyFee = new JLabel("Hourly Fee");
		lblHourlyFee.setBounds(28, 30, 68, 14);
		panel.add(lblHourlyFee);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(144, 30, 64, 14);
		panel.add(lblCapacity);
		
		JButton btnOlustur = new JButton("Create");
		btnOlustur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				autopark = new AutoPark(Double.parseDouble(textField.getText()),Integer.parseInt(textField_1.getText()));
				frmPleaseCreateAutopark.setTitle(autopark.toString());
				
			}
		});
		btnOlustur.setBounds(69, 80, 89, 23);
		panel.add(btnOlustur);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel_1.setBounds(10, 136, 753, 380);
		frmPleaseCreateAutopark.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		d1 = new JTextField();
		d1.setBounds(60, 46, 86, 20);
		panel_1.add(d1);
		d1.setColumns(10);
		
		m1 = new JTextField();
		m1.setBounds(60, 77, 86, 20);
		panel_1.add(m1);
		m1.setColumns(10);
		
		y1 = new JTextField();
		y1.setBounds(60, 108, 86, 20);
		panel_1.add(y1);
		y1.setColumns(10);
		
		d2 = new JTextField();
		d2.setBounds(177, 46, 86, 20);
		panel_1.add(d2);
		d2.setColumns(10);
		
		m2 = new JTextField();
		m2.setBounds(177, 77, 86, 20);
		panel_1.add(m2);
		m2.setColumns(10);
		
		y2 = new JTextField();
		y2.setBounds(177, 108, 86, 20);
		panel_1.add(y2);
		y2.setColumns(10);
		
		plateS = new JTextField();
		plateS.setBounds(60, 139, 86, 20);
		panel_1.add(plateS);
		plateS.setColumns(10);
		
		JLabel lblDay = new JLabel("day");
		lblDay.setBounds(4, 49, 46, 14);
		panel_1.add(lblDay);
		
		JLabel lblMonth = new JLabel("month");
		lblMonth.setBounds(4, 80, 46, 14);
		panel_1.add(lblMonth);
		
		JLabel lblYear = new JLabel("year");
		lblYear.setBounds(4, 111, 46, 14);
		panel_1.add(lblYear);
		
		JLabel lblCreateSubscription = new JLabel("Create Subscription");
		lblCreateSubscription.setBounds(95, 11, 114, 14);
		panel_1.add(lblCreateSubscription);
		
		JButton btnCreate = new JButton("Subscribe");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSub(plateS.getText().toString(), Integer.parseInt(d1.getText()), Integer.parseInt(m1.getText()), Integer.parseInt(y1.getText()), Integer.parseInt(d1.getText()), Integer.parseInt(m1.getText()), Integer.parseInt(y1.getText()));
				frmPleaseCreateAutopark.setTitle(autopark.toString());
				textPane_1.setText("Vehicle has been subscribed");
				
			}

			private void addSub(String text, int parseInt, int parseInt2, int parseInt3, int parseInt4,
					int parseInt5, int parseInt6) {
				boolean result = true;
				
				Date begin = new Date(parseInt,parseInt2,parseInt3);
				Date end = new Date(parseInt4,parseInt5,parseInt6);
				
				Subscription newsubsc = new Subscription(begin, end, text);
				SubscribedVehicle vehicle = newsubsc.getVehicle();
				vehicle.setSubscrption(newsubsc);
				result = autopark.addVehicle(vehicle);
				frmPleaseCreateAutopark.setTitle(autopark.toString());
				
				
			}
		});
		btnCreate.setBounds(51, 174, 98, 23);
		panel_1.add(btnCreate);
		
		JLabel lblPlate = new JLabel("plate");
		lblPlate.setBounds(4, 142, 46, 14);
		panel_1.add(lblPlate);
		
		JButton btnGoster = new JButton("Show");
		btnGoster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubscribedVehicle  vehicle= null;
				vehicle = autopark.searchVehicle(plateS.getText().toString());
				
				if(vehicle == null) {
					textPane_1.setText("No vehicle with given plate has been found");
				}else {
					Subscription subsc = vehicle.getSubscription();
					textPane_1.setText(subsc.toString()); 
				}
				
				frmPleaseCreateAutopark.setTitle(autopark.toString());
			}
		});
		btnGoster.setBounds(174, 174, 89, 23);
		panel_1.add(btnGoster);
		
		textPane_1 = new JTextPane();
		textPane_1.setBounds(318, 11, 412, 358);
		panel_1.add(textPane_1);
		
		JLabel lblFrom = new JLabel("from");
		lblFrom.setBounds(83, 31, 46, 14);
		panel_1.add(lblFrom);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setBounds(195, 31, 46, 14);
		panel_1.add(lblTo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(316, 136, 447, 208);
		frmPleaseCreateAutopark.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 11, 427, 186);
		panel_2.add(textPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBounds(10, 527, 753, 41);
		frmPleaseCreateAutopark.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(68, 11, 89, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEntervehicle = new JLabel("Vehicle");
		lblEntervehicle.setBounds(10, 14, 71, 14);
		panel_3.add(lblEntervehicle);
		
		JCheckBox chckbxOfficial = new JCheckBox("Official");
		chckbxOfficial.setBounds(184, 10, 77, 23);
		panel_3.add(chckbxOfficial);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = true;

				int hour;
				int min;	
				Time now = new Time();
				java.util.Date date = new java.util.Date();   // given date
				Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
				calendar.setTime(date);   // assigns calendar to given date 
				hour = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
				min = calendar.get(Calendar.MINUTE);
				now.setHour(hour);
				now.setMinute(min);
			autopark.vehicleEnters(textField_2.getText(), now, chckbxOfficial.isSelected());
			textPane_1.setText(autopark.getStatus());
			frmPleaseCreateAutopark.setTitle(autopark.toString());
			}
		});
		btnEnter.setBounds(272, 10, 71, 23);
		panel_3.add(btnEnter);
		
		JButton vehicleExit = new JButton("Exit");
		vehicleExit.setBounds(353, 10, 89, 23);
		panel_3.add(vehicleExit);
		
		JButton btnParkRecords = new JButton("Show Park Status");
		btnParkRecords.setBounds(457, 10, 168, 23);
		panel_3.add(btnParkRecords);
		btnParkRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i =0 ;
				boolean found = false;
				while(i<autopark.getParkRecords().length) {
					if(autopark.getParkRecords()[i].getVehicle().getPlate().equalsIgnoreCase(textField_2.getText())) {
						textPane_1.setText(autopark.getParkRecords()[i].toString());
						 found = true;
					}
					i++;
				}
				if(found == true) {
					textPane_1.setText("Park is empty");
				}
				
			}
		});
		vehicleExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int hour;
				int min;	
				Time now = new Time();
				java.util.Date date = new java.util.Date();   // given date
				Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
				calendar.setTime(date);   // assigns calendar to given date 
				hour = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
				min = calendar.get(Calendar.MINUTE);
				now.setHour(hour);
				now.setMinute(min);
				double income = autopark.getIncomeDaily();
				boolean tf = autopark.vehicleExits(textField_2.getText(), now);
				if(tf==true) {
					textPane_1.setText("Vehicle : " + textField_2.getText() + "exit operation has been done succesfully\n" + "Charged : " + (autopark.getIncomeDaily() -income) + "\n " +
				
							autopark.toString());
			
				}
				else {
					textPane_1.setText("Error has been occured, check vehicle plate");
				}
				frmPleaseCreateAutopark.setTitle(autopark.toString());
				
			}
		});
		
		JButton btnShowParklist = new JButton("Show ParkList");
		btnShowParklist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_1.setText(autopark.ShowParks());
				frmPleaseCreateAutopark.setTitle(autopark.toString());
			}
		});
		btnShowParklist.setBounds(598, 102, 165, 23);
		frmPleaseCreateAutopark.getContentPane().add(btnShowParklist);
		
		JButton btnSubscriptions = new JButton("Show Subscription List");
		btnSubscriptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "Subscriptions:\n";
				int i;
				for (i=0; i<autopark.getSubscribedVehicles().length;i++) {
					SubscribedVehicle vehicle = autopark.getSubscribedVehicles()[i];
					if(vehicle !=null) {
						Subscription sc = vehicle.getSubscription();
						result = result + sc.toString();
						result = result + "\n";
					}
					
					
				}
				textPane_1.setText(result);
				frmPleaseCreateAutopark.setTitle(autopark.toString());
			}
		});
		btnSubscriptions.setBounds(316, 102, 185, 23);
		frmPleaseCreateAutopark.getContentPane().add(btnSubscriptions);
	}
}
