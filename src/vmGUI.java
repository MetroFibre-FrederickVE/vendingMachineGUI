// Library Imports.
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

/* Main Class that extends the JFrame and creates the 
   elements on the frame. */
public class vmGUI extends JFrame {

	
	// Assign variable names frame elements. 
	private JPanel contentPane;
	private JTextField moneyInTF;
	private JTextField moneyOutTF;
	private JTextField softDrinkTF;
	private JTextField smlChipsTF;
	private JTextField candyTF;
	private JTextField iceCreamTF;
	private JTextField lrgChipsTF;
	private JTextField energyDrinkTF;
	private JTextField totalTF;

	// Creates new format for float values to round of to 2 decimal places.
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	// Initiates main method of class.
	public static void main(String[] args) throws FileNotFoundException, IOException { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vmGUI frame = new vmGUI();
					frame.setVisible(true);
					// Generates welcome message.
					JOptionPane.showMessageDialog(null, "Welcome to the vending machine. Please make your selection, enter your money and checkout / pay.", "Welcome Message.", JOptionPane.PLAIN_MESSAGE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public vmGUI() throws FileNotFoundException, IOException {
		
		// Creates and customizes the JFrame's position values.
		setResizable(false);
		setTitle("Vending Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		setLocationRelativeTo(null);  // *** this will center your app ***
		
		
		// Reads data from CSV to a list.
		List<List<String>> records = new ArrayList<>();
		// Accesses file from path.
		try (BufferedReader br = new BufferedReader(new FileReader("data/stockList.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	// Splits data at occurance of ","
		        String[] values = line.split(",");
		        records.add(Arrays.asList(values));
		    }
		}
		
		
		// Creates integer array to act as click counter
		int[] sdClick = {0};
		int[] edClick = {0};
		int[] scClick = {0};
		int[] lcClick = {0};
		int[] caClick = {0};
		int[] icClick = {0};
		
		// Creates List to hold records found from CSV file
		List<String> sdData = records.get(0); // Number represents line number within CSV
		List<String> edData = records.get(1);
		List<String> scData = records.get(2);
		List<String> lcData = records.get(3);
		List<String> icData = records.get(4);
		List<String> caData = records.get(5);
		
		// Creates main panel containing.
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Creates panel containing item buttons.
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Please select your items...", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 70, 524, 212);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel sdPrice = new JLabel("Prices : R");
		sdPrice.setBounds(30, 75, 62, 14);
		panel_1.add(sdPrice);
		
		JLabel lcPrice = new JLabel("Prices : R");
		lcPrice.setBounds(206, 172, 60, 14);
		panel_1.add(lcPrice);
		
		JLabel scPrice = new JLabel("Prices : R");
		scPrice.setBounds(206, 78, 60, 14);
		panel_1.add(scPrice);
		
		JLabel cPrice = new JLabel("Prices : R");
		cPrice.setBounds(388, 72, 67, 14);
		panel_1.add(cPrice);
		
		JLabel icPrice = new JLabel("Prices : R");
		icPrice.setBounds(388, 166, 67, 14);
		panel_1.add(icPrice);
		
		JLabel edPrice = new JLabel("Prices : R");
		edPrice.setBounds(30, 169, 62, 14);
		panel_1.add(edPrice);
		
		softDrinkTF = new JTextField();
		softDrinkTF.setEditable(false);
		softDrinkTF.setBounds(96, 72, 40, 20);
		panel_1.add(softDrinkTF);
		softDrinkTF.setColumns(10);
		
		smlChipsTF = new JTextField();
		smlChipsTF.setEditable(false);
		smlChipsTF.setColumns(10);
		smlChipsTF.setBounds(270, 75, 40, 20);
		panel_1.add(smlChipsTF);
		
		candyTF = new JTextField();
		candyTF.setEditable(false);
		candyTF.setColumns(10);
		candyTF.setBounds(459, 69, 40, 20);
		panel_1.add(candyTF);
		
		iceCreamTF = new JTextField();
		iceCreamTF.setEditable(false);
		iceCreamTF.setColumns(10);
		iceCreamTF.setBounds(459, 163, 40, 20);
		panel_1.add(iceCreamTF);
		
		lrgChipsTF = new JTextField();
		lrgChipsTF.setEditable(false);
		lrgChipsTF.setColumns(10);
		lrgChipsTF.setBounds(270, 169, 40, 20);
		panel_1.add(lrgChipsTF);
		
		energyDrinkTF = new JTextField();
		energyDrinkTF.setEditable(false);
		energyDrinkTF.setColumns(10);
		energyDrinkTF.setBounds(96, 166, 40, 20);
		panel_1.add(energyDrinkTF);
		
		JLabel lblNewLabel = new JLabel("VENDING MACHINE");
		lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 42));
		lblNewLabel.setBounds(73, 11, 380, 71);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Insert money here : ");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(364, 289, 170, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Change : ");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(364, 402, 75, 20);
		panel.add(lblNewLabel_2);
		
		
		// Input validation
		// Restricts user to only entering float numbers (0 - 9 & ".") 
		moneyInTF = new JTextField();
		moneyInTF.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
	
			      char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') || 
			    		  (c == '.') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			      }
			    }
			  });
				    
		moneyInTF.setBounds(374, 315, 79, 20);
		panel.add(moneyInTF);
		moneyInTF.setColumns(10);
		
		moneyOutTF = new JTextField();
		moneyOutTF.setEditable(false);
		moneyOutTF.setBounds(374, 434, 79, 20);
		panel.add(moneyOutTF);
		moneyOutTF.setColumns(10);
		
		JTextArea purchaseTA = new JTextArea();
		purchaseTA.setLineWrap(true);
		purchaseTA.setFont(new Font("Arial", Font.BOLD, 13));
		purchaseTA.setWrapStyleWord(true);
		purchaseTA.setText("   Selected items for Purchase : \r\n\r\n");
		purchaseTA.setEditable(false);
		purchaseTA.setBounds(42, 292, 295, 161);
		panel.add(purchaseTA);
		
		// Creates button and adds event handler
		JButton sdBT = new JButton("Soft Drinks");
		sdBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Adds the amount of selected items on every button press.
				float sdTemp = Float.parseFloat(sdData.get(1));
				sdClick[0] += sdTemp;
				// Then displays data in text area.
				purchaseTA.append("Item : " + sdData.get(0) + " - Price : R " + sdData.get(1) + "\n");
			}
		});
		sdBT.setBounds(20, 22, 136, 42);
		panel_1.add(sdBT);
		
		// Creates button and adds event handler
		JButton scBT = new JButton("Small Chips");
		scBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Adds the amount of selected items on every button press.
				float scTemp = Float.parseFloat(scData.get(1));
				scClick[0] += scTemp;
				// Then displays data in text area.
				purchaseTA.append("Item : " + scData.get(0) + " - Price : R " + scData.get(1) + "\n");
			}
		});
		scBT.setBounds(196, 22, 136, 42);
		panel_1.add(scBT);
		
		// Creates button and adds event handler
		JButton caBT = new JButton("Candy's");
		caBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Adds the amount of selected items on every button press.
				float caTemp = Float.parseFloat(caData.get(1));
				caClick[0] += caTemp;
				// Then displays data in text area.
				purchaseTA.append("Item : " + caData.get(0) + " - Price : R " + caData.get(1) + "\n");	
			}
		});
		caBT.setBounds(378, 22, 136, 42);
		panel_1.add(caBT);
		
		// Creates button and adds event handler
		JButton edBT = new JButton("Energy Drinks");
		edBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Adds the amount of selected items on every button press.
				float edTemp = Float.parseFloat(edData.get(1));
				edClick[0] += edTemp;
				// Then displays data in text area.
				purchaseTA.append("Item : " + edData.get(0) + " - Price : R " + edData.get(1) + "\n");
			}
		});
		edBT.setBounds(20, 116, 136, 42);
		panel_1.add(edBT);
		
		// Creates button and adds event handler
		JButton lcBT = new JButton("Large Chips");
		lcBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Adds the amount of selected items on every button press.
				float lcTemp = Float.parseFloat(lcData.get(1));
				lcClick[0] += lcTemp;
				// Then displays data in text area.
				purchaseTA.append("Item : " + lcData.get(0) + " - Price : R " + lcData.get(1) + "\n");	
			}
		});
		lcBT.setBounds(196, 116, 136, 42);
		panel_1.add(lcBT);
		
		// Creates button and adds event handler
		JButton icBT = new JButton("Ice-cream");
		icBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Adds the amount of selected items on every button press.
				float icTemp = Float.parseFloat(icData.get(1));
				icClick[0] += icTemp;
				// Then displays data in text area.
				purchaseTA.append("Item : " + icData.get(0) + " - Price : R " + icData.get(1) + "\n");
			}
		});
		icBT.setBounds(378, 116, 136, 42);
		panel_1.add(icBT);
		
		
		// Action listener for "Purchase" button.
		// Displays thank you message and and exits program.					
		JButton purchaseBTN = new JButton("Pay");
		purchaseBTN.setVisible(false);
		purchaseBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Thank you for your purchase & please call again.\n Press Ok to exit the program.", "Thank you!", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		purchaseBTN.setBounds(73, 465, 89, 35);
		panel.add(purchaseBTN);
		
		
		// Action listener for "Cancel" button.
		// Button press closes application window.
		JButton cancelBTN = new JButton("Cancel");
		cancelBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		cancelBTN.setBounds(364, 465, 89, 35);
		panel.add(cancelBTN);
		
		
        // Creates Checkout button and adds event handler.
        JButton checkoutBTN = new JButton("Check-out");
        checkoutBTN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		// Sets visibility of buttons on click.
        		purchaseBTN.setVisible(true);
        		checkoutBTN.setVisible(false);
        		
        		// Sets variable values equal to monetary value of item form CSV.
        		float softDrinkPrice = sdClick[0];
        		float energyDrinkPrice = edClick[0];
        		float smlChipsPrice = scClick[0];
        		float lrgChipsPrice = lcClick[0];
        		float candysPrice = caClick[0];
        		float iceCreamPrice = icClick[0];
        		
        		// Adds all item values together.
        		float tempTotal = softDrinkPrice 
        				+ energyDrinkPrice
        				+ smlChipsPrice
        				+ lrgChipsPrice
        				+ candysPrice
        				+ iceCreamPrice;
        		
				float total = 0 ;
				float moneyIn = (float) 0.00;
				
				// Checks if user entered any money.
				// If not, a warning message is displayed.
				if (moneyInTF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Please enter your money before checking out.\n You need to enter at least R" + df.format(tempTotal), "No money entered!", JOptionPane.WARNING_MESSAGE);
				} else {
					// Else, sets variable value equal to amount entered.
					moneyIn = Float.parseFloat(moneyInTF.getText());
				}
				
				// Checks is total amount of items selected is larger than 0.
				if (tempTotal > 0) {
					// Calls formatter to set decimal value after rounding.
					df.setRoundingMode(RoundingMode.HALF_EVEN);
					totalTF.setText(df.format(tempTotal));
					total = tempTotal ;
				} else {
					// Else, an error message is displayed.
					JOptionPane.showMessageDialog(rootPane, "Error");
				}
				
				// Checks if user entered enough money for purchase.
				if (moneyIn < 0 || moneyIn < total) {
					// Displays error message and resets "Checkout" process.
					JOptionPane.showMessageDialog(rootPane, "Not enough money entered.", "Error!", JOptionPane.ERROR_MESSAGE);
					purchaseBTN.setVisible(false);
					checkoutBTN.setVisible(true);
				} else {
					// Else, calculates users change amount and displays.
					Double input = (double) (moneyIn - total);
					moneyOutTF.setText(df.format(input));
				}
        	}
        });
        checkoutBTN.setVisible(true);
        checkoutBTN.setBounds(52, 465, 120, 35);
        panel.add(checkoutBTN);
		
        
		// Action listener for "Clear" button.
		// Button press clears all selected items and text fields.
		JButton clearBTN = new JButton("Restart");
		clearBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				purchaseTA.setText("Selected items for Purchase : \r\n\r\n");
				
				// Resets all Counter array values.
				sdClick[0] = 0;
				edClick[0] = 0;
				scClick[0] = 0;
				lcClick[0] = 0;
				caClick[0] = 0;
				icClick[0] = 0;
				
				// Displays blank values to text fields.
				moneyInTF.setText(" ");
				moneyOutTF.setText(" ");
				totalTF.setText(" ");
				
				// Changes visibility of buttons and sets editability.
        		purchaseBTN.setVisible(false);
        		checkoutBTN.setVisible(true);
        		moneyInTF.setEditable(true);
			}
		});
		clearBTN.setBounds(222, 465, 89, 35);
		panel.add(clearBTN);
		
		
        // Change text field values to money values from CSV
        softDrinkTF.setText(sdData.get(1));
        energyDrinkTF.setText(edData.get(1));
        smlChipsTF.setText(scData.get(1));
        lrgChipsTF.setText(lcData.get(1));
        candyTF.setText(caData.get(1));
        iceCreamTF.setText(icData.get(1));
        
        
        totalTF = new JTextField();
        totalTF.setEditable(false);
        totalTF.setBounds(374, 371, 79, 20);
        panel.add(totalTF);
        totalTF.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Total Amount : ");
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel_3.setBounds(364, 346, 97, 14);
        panel.add(lblNewLabel_3);
        
        JLabel lblR = new JLabel("R ");
        lblR.setBounds(364, 317, 12, 16);
        panel.add(lblR);
        
        JLabel label = new JLabel("R ");
        label.setBounds(364, 373, 12, 16);
        panel.add(label);
        
        JLabel label_1 = new JLabel("R ");
        label_1.setBounds(364, 436, 12, 16);
        panel.add(label_1); 
	}
}



