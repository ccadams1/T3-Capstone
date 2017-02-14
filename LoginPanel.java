import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	
	private JPanel formPanel, submitPanel;
	private JLabel uNameLabel, pWordLabel;
	private JTextField uNameInput, pWordInput;
	private JButton submit;
	
	public LoginPanel(){
		super();
		setLayout(new GridLayout(2, 1));
		
		// Initialize formPanel
		formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(2,2));
		
		// Create labels and textFields for formPanel
		uNameLabel = new JLabel("Username:");
		pWordLabel = new JLabel("Password:");
		uNameInput = new JTextField();
		pWordInput = new JTextField();
		
		// Add labels and textFields to formPanel
		formPanel.add(uNameLabel);
		formPanel.add(uNameInput);
		formPanel.add(pWordLabel);
		formPanel.add(pWordInput);
		

		// Create submit panel with button
		submitPanel = new JPanel();
		submit = new JButton("Submit");
		submitPanel.add(submit);
		
		// Add panels to create LoginPanel
		add(formPanel);
		add(submitPanel);
		
		setSize(800, 600);
	}
}
