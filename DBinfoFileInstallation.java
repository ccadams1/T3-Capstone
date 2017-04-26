import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;

public class DBinfoFileInstallation {
	//sets up variables
	private JFrame frame;
	private JTextField serverNameTextField;
	private JTextField portNumberTextField;
	private JTextField passwordTextField;
	private JTextField usernameTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBinfoFileInstallation window = new DBinfoFileInstallation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public DBinfoFileInstallation() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		//sets screen properties
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Database Information File Creation");
		
		//labels and textFields to get customer specific database information
		//also contains black panels for borders and vertical struts for visual appeal
		JLabel instructionsLbl = new JLabel("The following information is required to access your database.");
		instructionsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(instructionsLbl, BorderLayout.NORTH);
		
		JPanel leftBorderPanel = new JPanel();
		leftBorderPanel.setPreferredSize(new Dimension(20, 10));
		frame.getContentPane().add(leftBorderPanel, BorderLayout.WEST);
		
		JPanel rightBorderPanel = new JPanel();
		rightBorderPanel.setPreferredSize(new Dimension(20, 10));
		frame.getContentPane().add(rightBorderPanel, BorderLayout.EAST);
		
		JPanel buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		JPanel centerPanel = new JPanel();
		frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel serverNameLbl = new JLabel("Enter your database server name: ");
		centerPanel.add(serverNameLbl);
		
		JPanel panel_1 = new JPanel();
		centerPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		serverNameTextField = new JTextField();
		serverNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(serverNameTextField);
		serverNameTextField.setToolTipText("ex. yourserver.database.windows.net");
		serverNameTextField.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(15);
		panel_1.add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(15);
		panel_1.add(verticalStrut_1, BorderLayout.SOUTH);
		
		JLabel portNumberLbl = new JLabel("Enter your database port number:");
		centerPanel.add(portNumberLbl);
		
		JPanel panel_2 = new JPanel();
		centerPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		portNumberTextField = new JTextField();
		portNumberTextField.setToolTipText("ex. 1433");
		portNumberTextField.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(portNumberTextField);
		portNumberTextField.setColumns(10);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setPreferredSize(new Dimension(0, 15));
		verticalStrut_2.setMinimumSize(new Dimension(0, 15));
		panel_2.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalStrut_3.setMinimumSize(new Dimension(0, 15));
		verticalStrut_3.setPreferredSize(new Dimension(0, 15));
		panel_2.add(verticalStrut_3, BorderLayout.SOUTH);
		
		JLabel usernameLbl = new JLabel("Enter your database username:");
		centerPanel.add(usernameLbl);
		
		JPanel panel_3 = new JPanel();
		centerPanel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		usernameTextField = new JTextField();
		usernameTextField.setToolTipText("ex. user@yourserver");
		usernameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameTextField.setColumns(10);
		panel_3.add(usernameTextField);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		verticalStrut_4.setMinimumSize(new Dimension(0, 15));
		verticalStrut_4.setPreferredSize(new Dimension(0, 15));
		panel_3.add(verticalStrut_4, BorderLayout.NORTH);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		verticalStrut_5.setPreferredSize(new Dimension(0, 15));
		verticalStrut_5.setMinimumSize(new Dimension(0, 15));
		panel_3.add(verticalStrut_5, BorderLayout.SOUTH);
		
		JLabel passwordLbl = new JLabel("Enter your database password:");
		centerPanel.add(passwordLbl);
		
		JPanel panel_4 = new JPanel();
		centerPanel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		passwordTextField = new JTextField();
		passwordTextField.setToolTipText("ex. password");
		panel_4.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		verticalStrut_6.setMinimumSize(new Dimension(0, 15));
		verticalStrut_6.setPreferredSize(new Dimension(0, 15));
		panel_4.add(verticalStrut_6, BorderLayout.NORTH);
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		verticalStrut_7.setMinimumSize(new Dimension(0, 15));
		verticalStrut_7.setPreferredSize(new Dimension(0, 15));
		panel_4.add(verticalStrut_7, BorderLayout.SOUTH);
		

		//finish button to gather information and creates a text document
		JButton finishButton = new JButton("Finish");
		finishButton.setPreferredSize(new Dimension(100, 23));
		buttonPanel.add(finishButton);
		finishButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				try {
					getInformation();
					frame.dispose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	//gathers information and creates a text document
	public void getInformation() throws IOException
	{
		//gets textField information
		String server = serverNameTextField.getText().trim();
		String portNumber = portNumberTextField.getText().trim();
		String username = usernameTextField.getText().trim();
		String password = passwordTextField.getText().trim();
		
		//sets up bufferedWriter
		BufferedWriter writer = null;
		
		try{
			//locates lib folder on desktop
			File desktop = new File(System.getProperty("user.home"), "/Desktop");
			File databaseFile = new File(desktop, "/T3 Tracking and Inventory_lib/DatabaseInfo.txt");
			
			//creates file with necessary information
			writer = new BufferedWriter(new FileWriter(databaseFile));
			writer.write(server);
			writer.newLine();
			writer.write(portNumber);
			writer.newLine();
			writer.write(username);
			writer.newLine();
			writer.write(password);
		}catch(Exception e)
		{
			//default to desktop location
			File desktop = new File(System.getProperty("user.home"), "/Desktop");
			File databaseFile = new File(desktop, "DatabaseInfo.txt");
			
			//creates file with necessary information
			writer = new BufferedWriter(new FileWriter(databaseFile));
			writer.write(server);
			writer.newLine();
			writer.write(portNumber);
			writer.newLine();
			writer.write(username);
			writer.newLine();
			writer.write(password);
		}finally {
			try{
				writer.close();
			}catch(Exception e){
			}
		}
	}

}
