import java.awt.Color;
import java.awt.Panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class HelpPanel extends ResizablePanel{
	public HelpPanel()
	{
		//bounds should be set to (0, 0, 772, 476)
		this.setBounds(0, 0, 772, 476);
		this.setLayout(null);
				
		//sets up a panel for information placement
		Panel informationPanel = new Panel();
		informationPanel.setBounds(0, 0, 772, 178);
		this.add(informationPanel);		
		informationPanel.setLayout(null);
				
		//creates a scrolling text area
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 174, 772, 302);
		this.add(scrollPane);
				
		//creates text area to put in the scrollPane
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
	}
} 
