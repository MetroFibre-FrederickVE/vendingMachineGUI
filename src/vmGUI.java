import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class vmGUI extends JFrame {

	private JPanel contentPane;
	private JTextField moneyInTF;
	private JTextField moneyOutTF;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		
		List<Stock> items = readitemsFromCSV("data/stockList.csv");

        // let's print all the person read from CSV file
        for (Stock b : items) {
            System.out.println(b);
        }
        
	}
	
	private static List<Stock> readitemsFromCSV(String fileName) {
        List<Stock> items = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                Stock item = createItem(attributes);

                // adding Stock into ArrayList
                items.add(item);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return items;
    }

    private static Stock createItem(String[] metadata) {
        String name = metadata[0];
        int price = Integer.parseInt(metadata[1]);
        String author = metadata[2];

        // create and return Stock of this metadata
        return new Stock(name, price, author);
    }

	/**
	 * Create the frame.
	 */
	public vmGUI() {
		setResizable(false);
		setTitle("Vending Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 550);
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
		panel_1.setBounds(10, 119, 524, 212);
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
		
		JButton btnNewButton = new JButton("Soft Drinks");
		btnNewButton.setBounds(20, 22, 136, 42);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Small Chips");
		btnNewButton_1.setBounds(196, 22, 136, 42);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Candy's");
		btnNewButton_2.setBounds(378, 22, 136, 42);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Energy Drinks");
		btnNewButton_3.setBounds(20, 116, 136, 42);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Large Chips");
		btnNewButton_4.setBounds(196, 116, 136, 42);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Ice-cream");
		btnNewButton_5.setBounds(378, 116, 136, 42);
		panel_1.add(btnNewButton_5);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(96, 72, 40, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(270, 75, 40, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(459, 69, 40, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(459, 163, 40, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(270, 169, 40, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(96, 166, 40, 20);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel = new JLabel("VENDING MACHINE");
		lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 42));
		lblNewLabel.setBounds(73, 11, 380, 71);
		panel.add(lblNewLabel);
		
		// Action listener for "Purchase" button.
		// Button press checks money amount against purchase price.
		JButton purchaseBTN = new JButton("Purchase");
		purchaseBTN.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				double softDrinkPrice = 12.00;
				double energyDrinkPrice = 20.00;
				double smlChipsPrice = 14.00;
				double lrgChipsPrice = 25.00;
				double candysPrice = 8.00;
				double iceCreamPrice = 11.00;
				
				double moneyIn = 0.00;
				
				moneyIn = Double.parseDouble(moneyInTF.getText());
				/*
				if (softDrinkRB.isSelected()) {
					moneyIn = moneyIn - softDrinkPrice;
				} else if (energyDrinkRB.isSelected()) {
					moneyIn = moneyIn - energyDrinkPrice;
				} else if (candysRB.isSelected()) {
					moneyIn = moneyIn - candysPrice;
				} else if (smlChipsRB.isSelected()) {
					moneyIn = moneyIn - smlChipsPrice;
				} else if (lrgChipsRB.isSelected()) {
					moneyIn = moneyIn - lrgChipsPrice;
				} else if (iceCreamRB.isSelected()) {
					moneyIn = moneyIn - iceCreamPrice;
				}
				*/
				if (moneyIn < 0) {
					JOptionPane.showMessageDialog(rootPane, "Not enough money.");
				} else {
					moneyOutTF.setText(Double.toString(moneyIn));
				}
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
		
		// Action listener for "Clear" button.
		// Button press clears all selected radio buttons and text fields.
		JButton clearBTN = new JButton("Clear");
		clearBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				softDrinkRB.setSelected(false);
				lrgChipsRB.setSelected(false);
				iceCreamRB.setSelected(false);
				smlChipsRB.setSelected(false);
				energyDrinkRB.setSelected(false);
				candysRB.setSelected(false);
				*/
				moneyInTF.setText(" ");
				moneyOutTF.setText(" ");
			}
		});
		clearBTN.setBounds(222, 465, 89, 35);
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
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(265, 329, 188, 125);
		panel.add(textArea);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(73, 329, 188, 125);
		panel.add(textPane);
	}

}

class Stock {
    private String name;
    private int price;
    private String author;

    public Stock(String name, int price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // CSV Test output
    @Override
    public String toString() {
        return "Stock [name=" + name + ", price=" + price + ", stockcount=" + author
                + "]";
    }

}


