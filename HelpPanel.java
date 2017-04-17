import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class HelpPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int startLine, lastLine, numLines;
	// private JTextArea textArea;

	public HelpPanel() {

		// bounds should be set to (0, 0, 772, 476)
		this.setBounds(0, 0, 772, 476);
		this.setLayout(null);

		// creates a scrolling text area
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 174, 772, 302);
		this.add(scrollPane);

		// creates text area to put in the scrollPane
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel tableOfContentsPanel = new JPanel();
		tableOfContentsPanel.setBounds(0, 0, 772, 178);
		tableOfContentsPanel.setBorder(new TitledBorder(null, "Help Contents", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.PLAIN, 18), null));
		this.add(tableOfContentsPanel);
		tableOfContentsPanel.setLayout(null);

		ButtonGroup tableOfContentsGroup = new ButtonGroup();

		JRadioButton rdbtnMainScreen = new JRadioButton("Main Screen");
		rdbtnMainScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnMainScreen.setBounds(14, 22, 204, 19);
		tableOfContentsPanel.add(rdbtnMainScreen);
		tableOfContentsGroup.add(rdbtnMainScreen);

		rdbtnMainScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startLine = 66;
				lastLine = 71;
				numLines = lastLine - startLine;
				updateDisplay(textArea);
			}
		});
		
		JRadioButton rdbtnPosSalesScreen = new JRadioButton("POS Sales Screen");
		rdbtnPosSalesScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnPosSalesScreen.setBounds(14, 44, 204, 19);
		tableOfContentsPanel.add(rdbtnPosSalesScreen);
		tableOfContentsGroup.add(rdbtnPosSalesScreen);

		rdbtnPosSalesScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startLine = 75;
				lastLine = 82;
				numLines = lastLine - startLine;
				updateDisplay(textArea);
			}
		});
		
		JRadioButton rdbtnCashoutScreen = new JRadioButton("Checkout Screen");
		rdbtnCashoutScreen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnCashoutScreen.setBounds(14, 66, 204, 19);
		tableOfContentsPanel.add(rdbtnCashoutScreen);
		tableOfContentsGroup.add(rdbtnCashoutScreen);

		rdbtnCashoutScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startLine = 85;
				lastLine = 89;
				numLines = lastLine - startLine;
				updateDisplay(textArea);
			}
		});
		
		
		JRadioButton rdbtnInventoryScreen = new JRadioButton("Inventory Screen");
		rdbtnInventoryScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnInventoryScreen.setBounds(14, 88, 204, 19);
		tableOfContentsPanel.add(rdbtnInventoryScreen);
		tableOfContentsGroup.add(rdbtnInventoryScreen);

		rdbtnInventoryScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startLine = 92;
				lastLine = 114;
				numLines = lastLine - startLine;
				updateDisplay(textArea);
			}
		});

		JRadioButton rdbtnAddItemButton = new JRadioButton("Add Item Button");
		rdbtnAddItemButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnAddItemButton.setBounds(14, 110, 204, 19);
		tableOfContentsPanel.add(rdbtnAddItemButton);
		tableOfContentsGroup.add(rdbtnAddItemButton);

		rdbtnAddItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startLine = 92;
				lastLine = 100;
				numLines = lastLine - startLine;
				updateDisplay(textArea);
			}
		});

		JRadioButton rdbtnEditItemButton = new JRadioButton("Edit Item Button");
		rdbtnEditItemButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnEditItemButton.setBounds(14, 132, 204, 19);
		tableOfContentsPanel.add(rdbtnEditItemButton);
		tableOfContentsGroup.add(rdbtnEditItemButton);

		rdbtnEditItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startLine = 103;
				lastLine = 107;
				numLines = lastLine - startLine;
				updateDisplay(textArea);
			}
		});

		JRadioButton rdbtnDeleteItemButton = new JRadioButton("Delete Item Button");
		rdbtnDeleteItemButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnDeleteItemButton.setBounds(14, 154, 204, 19);
		tableOfContentsPanel.add(rdbtnDeleteItemButton);
		tableOfContentsGroup.add(rdbtnDeleteItemButton);

		rdbtnDeleteItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startLine = 110;
				lastLine = 114;
				numLines = lastLine - startLine;
				updateDisplay(textArea);
			}
		});

		JRadioButton rdbtnSearchScreen = new JRadioButton("Search Screen");
		rdbtnSearchScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnSearchScreen.setBounds(400, 22, 204, 19);
		tableOfContentsPanel.add(rdbtnSearchScreen);
		tableOfContentsGroup.add(rdbtnSearchScreen);

		rdbtnSearchScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startLine = 117;
				lastLine = 144;
				numLines = lastLine - startLine;
				updateDisplay(textArea);
			}
		});

		JRadioButton rdbtnCustomerSearch = new JRadioButton("Inventory Search");
		rdbtnCustomerSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnCustomerSearch.setBounds(400, 44, 183, 19);
		tableOfContentsPanel.add(rdbtnCustomerSearch);
		tableOfContentsGroup.add(rdbtnCustomerSearch);

		rdbtnCustomerSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startLine = 117;
				lastLine = 124;
				numLines = lastLine - startLine;
				updateDisplay(textArea);
			}
		});

		JRadioButton rdbtnInventorySearch = new JRadioButton("Supplier Search");
		rdbtnInventorySearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnInventorySearch.setBounds(400, 66, 183, 19);
		tableOfContentsPanel.add(rdbtnInventorySearch);
		tableOfContentsGroup.add(rdbtnInventorySearch);

		rdbtnInventorySearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startLine = 127;
				lastLine = 134;
				numLines = lastLine - startLine;
				updateDisplay(textArea);
			}
		});

		JRadioButton rdbtnSupplierSearch = new JRadioButton("Customer Search");
		rdbtnSupplierSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnSupplierSearch.setBounds(400, 88, 183, 19);
		tableOfContentsPanel.add(rdbtnSupplierSearch);
		tableOfContentsGroup.add(rdbtnSupplierSearch);

		rdbtnSupplierSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startLine = 137;
				lastLine = 144;
				numLines = lastLine - startLine;
				updateDisplay(textArea);
			}
		});

		JRadioButton rdbtnReportsScreen = new JRadioButton("Reports Screen");
		rdbtnReportsScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnReportsScreen.setBounds(400, 110, 183, 19);
		tableOfContentsPanel.add(rdbtnReportsScreen);
		tableOfContentsGroup.add(rdbtnReportsScreen);

		rdbtnReportsScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startLine = 148;
				lastLine = 157;
				numLines = lastLine - startLine;
				updateDisplay(textArea);
			}
		});
		
		JRadioButton rdbtnHelpScreen = new JRadioButton("Help Screen");
		rdbtnHelpScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnHelpScreen.setBounds(400, 132, 183, 19);
		tableOfContentsPanel.add(rdbtnHelpScreen);
		tableOfContentsGroup.add(rdbtnHelpScreen);

		rdbtnHelpScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startLine = 160;
				lastLine = 166;
				numLines = lastLine - startLine;
				updateDisplay(textArea);
			}
		});


		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(387, 11, 2, 176);
		tableOfContentsPanel.add(separator_1);


		// Initialize text for ScrollPane
		startLine = 0;
		numLines = 50;
		updateDisplay(textArea);
	}

	private void updateDisplay(JTextArea text) {
		// Set as actionListener to determine which lines of help file to
		// display
		FileReader reader = null;
		BufferedReader br = null;
		try {
			File helpDoc = new File("src/userManual.txt");
			reader = new FileReader(helpDoc);
			br = new BufferedReader(reader);
			for (int i = 1; i < startLine; i++) {
				br.readLine();
			}
			String linesIWant = "";
			for (int i = -1; i < numLines; i++) {
				linesIWant += br.readLine() + "\n";
			}
			text.setText(linesIWant);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
