import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Dialog.ModalityType;

public class CheckoutButtonScreen extends JDialog{

	private JFrame frame;
	private JTextField customerIDTextField;
	public static CustomerList customers;
	private static Customer thisCustomer = null;
	
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
	 */
	public CheckoutButtonScreen(ArrayList<Object> data){
		initialize(data);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Object> data) {
		this.setAlwaysOnTop (true);
		this.setSize(400,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setModal(true);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Checkout");
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		customers = (CustomerList) data.get(2);
		
		this.setBounds(100, 100, 450, 450);
		getContentPane().setLayout(null);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setBounds(22, 24, 123, 29);
		getContentPane().add(lblSubtotal);
		
		JLabel lblDiscounts = new JLabel("Discounts:");
		lblDiscounts.setBounds(22, 61, 123, 29);
		getContentPane().add(lblDiscounts);
		
		JLabel lblTaxes = new JLabel("Taxes:");
		lblTaxes.setBounds(22, 94, 123, 29);
		getContentPane().add(lblTaxes);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(22, 133, 123, 29);
		getContentPane().add(lblTotal);
		
		JLabel lblSubtotalvalue = new JLabel("subtotalValue");
		lblSubtotalvalue.setBounds(159, 24, 104, 29);
		getContentPane().add(lblSubtotalvalue);
		
		JLabel lblDiscountvalue = new JLabel("discountValue");
		lblDiscountvalue.setBounds(159, 61, 104, 29);
		getContentPane().add(lblDiscountvalue);
		
		JLabel lblTaxvalue = new JLabel("taxValue");
		lblTaxvalue.setBounds(159, 94, 104, 29);
		getContentPane().add(lblTaxvalue);
		
		JLabel lblTotalvalue = new JLabel("TotalValue");
		lblTotalvalue.setBounds(159, 133, 104, 29);
		getContentPane().add(lblTotalvalue);
		
		JLabel lblSearchCustomer = new JLabel("Search Customer ID:");
		lblSearchCustomer.setBounds(22, 179, 241, 29);
		getContentPane().add(lblSearchCustomer);
		
		customerIDTextField = new JTextField();
		customerIDTextField.setBounds(32, 218, 143, 35);
		getContentPane().add(customerIDTextField);
		customerIDTextField.setColumns(10);
		
		JLabel lblCustomerId = new JLabel("OR");
		lblCustomerId.setBounds(84, 274, 40, 29);
		getContentPane().add(lblCustomerId);
		
		JButton btnCreateNewCustomer = new JButton("Create new Customer");
		btnCreateNewCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateNewCustomer.setBounds(205, 270, 205, 37);
		btnCreateNewCustomer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCustomer(thisCustomer);
			}
		});
		getContentPane().add(btnCreateNewCustomer);
		
		JButton btnSearchCustomer = new JButton("Search Customer");
		btnSearchCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearchCustomer.setBounds(205, 217, 205, 37);
		btnSearchCustomer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int x = 0; x < customers.size(); x++)
				{
					if(customers.getCustomer(x).getID().equals(customerIDTextField.getText().trim()))
					{
						thisCustomer = customers.getCustomer(x);
					}
				}
			}
		});
		getContentPane().add(btnSearchCustomer);
		
		((Object) thisCustomer).addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
		        if(thisCustomer!=null)
		        {
		        	new PaymentScreen(data);
		        }
	        }  
		});
}
