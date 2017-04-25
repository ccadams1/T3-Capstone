import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Dialog.ModalityType;

public class CheckoutButtonScreen extends JDialog{
	private JFrame frame;
	private JTextField customerIDTextField;
	public static CustomerList customers;
	public static Customer thisCustomer = null;
	public String total = "";
	public long time;
	
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckoutButtonScreen window = new CheckoutButtonScreen();	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the application.
	 * @param panel_2 
	 * @param totalValue 
	 */
	public CheckoutButtonScreen(ArrayList<Object> data, ArrayList<String> checkoutData, POSPanel posPanel, ArrayList<CheckoutItemPanel> panelList, double totalValue){
		initialize(data, checkoutData, panelList, posPanel, totalValue);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param panel_2 
	 */
	private void initialize(ArrayList<Object> data, ArrayList<String> checkoutData, ArrayList<CheckoutItemPanel> panelList, POSPanel posPanel, double totalValue) {
		Date date = new Date();
		
		JDialog cBS = new JDialog();
		cBS.setAlwaysOnTop (true);
		cBS.setSize(400,600);
		cBS.setLocationRelativeTo(null);
		cBS.setVisible(true);
		cBS.setModal(true);
		cBS.setModalityType(ModalityType.DOCUMENT_MODAL);
		cBS.setTitle("Checkout");
		cBS.getContentPane().setLayout(null);
		cBS.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		customers = (CustomerList) data.get(1);

		cBS.setBounds(100, 100, 450, 450);
		getContentPane().setLayout(null);

		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setBounds(22, 24, 123, 29);
		cBS.add(lblSubtotal);
		
		JLabel lblDiscounts = new JLabel("Discounts:");
		lblDiscounts.setBounds(22, 61, 123, 29);
		cBS.add(lblDiscounts);
		
		JLabel lblTaxes = new JLabel("Taxes:");
		lblTaxes.setBounds(22, 94, 123, 29);
		cBS.add(lblTaxes);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(22, 133, 123, 29);
		cBS.add(lblTotal);
		
		JLabel lblSubtotalvalue = new JLabel(checkoutData.get(0));
		lblSubtotalvalue.setBounds(159, 24, 104, 29);
		cBS.add(lblSubtotalvalue);
		
		JLabel lblDiscountvalue = new JLabel(checkoutData.get(1));
		lblDiscountvalue.setBounds(159, 61, 104, 29);
		cBS.add(lblDiscountvalue);
		
		JLabel lblTaxvalue = new JLabel(checkoutData.get(2));
		lblTaxvalue.setBounds(159, 94, 104, 29);
		cBS.add(lblTaxvalue);
		
		JLabel lblTotalvalue = new JLabel(checkoutData.get(3));
		total = checkoutData.get(3);
		lblTotalvalue.setBounds(159, 133, 104, 29);
		cBS.add(lblTotalvalue);
		
		JLabel lblSearchCustomer = new JLabel("Search Customer ID:");
		lblSearchCustomer.setBounds(22, 179, 241, 29);
		cBS.add(lblSearchCustomer);

		customerIDTextField = new JTextField();
		customerIDTextField.setBounds(32, 218, 143, 35);
		cBS.add(customerIDTextField);
		customerIDTextField.setColumns(10);

		JLabel lblCustomerId = new JLabel("OR");
		lblCustomerId.setBounds(84, 274, 40, 29);
		cBS.add(lblCustomerId);
		
		JLabel lblThisCustomer = new JLabel("No customer selected");
		lblThisCustomer.setBounds(22, 324, 241, 29);
		cBS.add(lblThisCustomer);
		
		JButton btnCreateNewCustomer = new JButton("Create new Customer");
		btnCreateNewCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateNewCustomer.setBounds(205, 270, 205, 37);
		btnCreateNewCustomer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCustomerScreen(data, thisCustomer, lblThisCustomer);
			}
		});
		cBS.add(btnCreateNewCustomer);
		
		JButton btnSearchCustomer = new JButton("Search Customer");
		btnSearchCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearchCustomer.setBounds(205, 217, 205, 37);
		btnSearchCustomer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				thisCustomer = null;
				lblThisCustomer.setText("No customer selected");
				for(int x = 0; x < customers.size(); x++)
				{
					if(customers.getCustomer(x).getID().equals(customerIDTextField.getText().trim()))
					{
						thisCustomer = customers.getCustomer(x);
						lblThisCustomer.setText("Customer: " + thisCustomer.getID() + " " + thisCustomer.getFName() 
							+ " " + thisCustomer.getLName());
					}
				}
				if(thisCustomer == null)
				{
					setWarningMsg("No Customer found");
				}
			}
		});
		cBS.add(btnSearchCustomer);
		
		JButton btnPayment = new JButton("Pay");
		btnPayment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPayment.setBounds(205, 324, 205, 37);
		btnPayment.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(thisCustomer!=null)
				{
					setThisCustomer(data, panelList, posPanel, thisCustomer, total, totalValue, cBS, date.getTime());
				}
				else
				{
					setWarningMsg("No customer is selected.");
				}
			}
		});
		cBS.add(btnPayment);
	}
	
	public void setThisCustomer(ArrayList<Object> data, ArrayList<CheckoutItemPanel> panelList, POSPanel posPanel, Customer cus, String total, double totalValue, JDialog cBS, long time)
	{
		new PaymentScreen(data, panelList, posPanel, cus, total, totalValue, cBS, time);
	}
	
	public void setWarningMsg(String text){
	    JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
	    JDialog dialog = optionPane.createDialog("Error");
	    dialog.setAlwaysOnTop(true);
	    dialog.setVisible(true);
	}
}