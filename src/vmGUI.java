import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vmGUI extends JFrame {

	private JPanel contentPane;
	private JTextField moneyInTF;
	private JTextField moneyOutTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vmGUI frame = new vmGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vmGUI() {
		setResizable(false);
		setTitle("Vending Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Panel containing radio buttons
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Please select your items...", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(73, 119, 380, 137);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton energyDrinkRB = new JRadioButton("Energy Drinks");
		energyDrinkRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		energyDrinkRB.setBounds(16, 80, 109, 23);
		panel_1.add(energyDrinkRB);
		
		JRadioButton lrgChipsRB = new JRadioButton("Large Chips");
		lrgChipsRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		lrgChipsRB.setBounds(141, 80, 109, 23);
		panel_1.add(lrgChipsRB);
		
		JRadioButton iceCreamRB = new JRadioButton("Ice-cream");
		iceCreamRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		iceCreamRB.setBounds(265, 80, 109, 23);
		panel_1.add(iceCreamRB);
		
		JRadioButton smlChipsRB = new JRadioButton("Small Chips");
		smlChipsRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		smlChipsRB.setBounds(141, 24, 109, 23);
		panel_1.add(smlChipsRB);
		
		JRadioButton softDrinkRB = new JRadioButton("Soft Drinks");
		softDrinkRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		softDrinkRB.setBounds(16, 24, 109, 23);
		panel_1.add(softDrinkRB);
		
		JRadioButton candysRB = new JRadioButton("Candy's");
		candysRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		candysRB.setBounds(265, 24, 109, 23);
		panel_1.add(candysRB);
		
		JLabel sdPrice = new JLabel("R 0.00");
		sdPrice.setBounds(52, 54, 46, 14);
		panel_1.add(sdPrice);
		
		JLabel lcPrice = new JLabel("R 0.00");
		lcPrice.setBounds(173, 110, 46, 14);
		panel_1.add(lcPrice);
		
		JLabel scPrice = new JLabel("R 0.00");
		scPrice.setBounds(173, 54, 46, 14);
		panel_1.add(scPrice);
		
		JLabel cPrice = new JLabel("R 0.00");
		cPrice.setBounds(298, 54, 46, 14);
		panel_1.add(cPrice);
		
		JLabel icPrice = new JLabel("R 0.00");
		icPrice.setBounds(298, 110, 46, 14);
		panel_1.add(icPrice);
		
		JLabel edPrice = new JLabel("R 0.00");
		edPrice.setBounds(52, 110, 46, 14);
		panel_1.add(edPrice);
		
		JLabel lblNewLabel = new JLabel("VENDING MACHINE");
		lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 42));
		lblNewLabel.setBounds(73, 11, 380, 71);
		panel.add(lblNewLabel);
		
		// Action listener for "Purchase" button.
		JButton purchaseBTN = new JButton("Purchase");
		purchaseBTN.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		purchaseBTN.setBounds(73, 267, 89, 23);
		panel.add(purchaseBTN);
		
		// Action listener for "Cancel" button.
		// Button press closes application window.
		JButton cancelBTN = new JButton("Cancel");
		cancelBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cancelBTN.setBounds(364, 267, 89, 23);
		panel.add(cancelBTN);
		
		// Action listener for "Clear" button.
		// Button press clears all selected radio buttons and text fields.
		JButton clearBTN = new JButton("Clear");
		clearBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				softDrinkRB.setSelected(false);
				lrgChipsRB.setSelected(false);
				iceCreamRB.setSelected(false);
				smlChipsRB.setSelected(false);
				energyDrinkRB.setSelected(false);
				candysRB.setSelected(false);
				moneyInTF.setText(" ");
				moneyOutTF.setText(" ");
			}
		});
		clearBTN.setBounds(222, 267, 89, 23);
		panel.add(clearBTN);
		
		JLabel lblNewLabel_1 = new JLabel("Insert money here : R");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1.setBounds(73, 81, 135, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Change : R");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_2.setBounds(307, 84, 75, 20);
		panel.add(lblNewLabel_2);
		
		moneyInTF = new JTextField();
		moneyInTF.setBounds(206, 85, 75, 20);
		panel.add(moneyInTF);
		moneyInTF.setColumns(10);
		
		moneyOutTF = new JTextField();
		moneyOutTF.setEditable(false);
		moneyOutTF.setBounds(378, 85, 75, 20);
		panel.add(moneyOutTF);
		moneyOutTF.setColumns(10);
	}
}
