import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class NotificationWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel, ackPane;
	private JScrollPane scroll;
	private JTextPane textPane;
	private JButton acknowledge;
	
	public NotificationWindow(){
		super("Notifications");
		
		// Initialize panel components
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		textPane = new JTextPane();
		scroll = new JScrollPane();
		acknowledge = new JButton("OK");
		ackPane = new JPanel();
		
		// Set acknowledge button size
		Dimension dim = ackPane.getPreferredSize();
		dim.height = 50;
		ackPane.setPreferredSize(dim);
		
		// Add panel components
		scroll.add(textPane);
		ackPane.add(acknowledge);
		contentPanel.add(scroll, BorderLayout.CENTER);
		contentPanel.add(ackPane, BorderLayout.SOUTH);
		add(contentPanel);
			
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
