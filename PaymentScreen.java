import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class PaymentScreen extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static Connection connect = null;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			PaymentScreen dialog = new PaymentScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 * @param checkoutData 
	 * @param data 
	 */
	public PaymentScreen(ArrayList<Object> data, ArrayList<String> checkoutData, Customer cus, String total, JDialog parent) {
		connect = (Connection) data.get(0);
		
		setAlwaysOnTop (true);
		setLocationRelativeTo(null);
		setVisible(true);
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 400, 275);
		this.setTitle("Payment");
		getContentPane().setLayout(null);
		
		JLabel lblCustomerInformation = new JLabel("Customer info:");
		lblCustomerInformation.setBounds(22, 11, 114, 14);
		getContentPane().add(lblCustomerInformation);
		
		JLabel lblCustomerId = new JLabel(cus.getID());
		lblCustomerId.setBounds(146, 11, 48, 14);
		getContentPane().add(lblCustomerId);
		
		JLabel lblCustomerName = new JLabel(cus.getFName()+ " " + cus.getLName());
		lblCustomerName.setBounds(204, 11, 136, 14);
		getContentPane().add(lblCustomerName);
		
		JLabel lblCustomerAddress = new JLabel(cus.getStAdress1());
		lblCustomerAddress.setBounds(146, 33, 139, 14);
		getContentPane().add(lblCustomerAddress);
		
		JLabel lblCustomerCityState = new JLabel(cus.getCity()+ ", " + cus.getState() + " " + cus.getZipCode());
		lblCustomerCityState.setBounds(146, 55, 139, 14);
		getContentPane().add(lblCustomerCityState);
		
		JLabel lblCustomerPhone = new JLabel("Phone: " + cus.getPhone1());
		lblCustomerPhone.setBounds(146, 77, 139, 14);
		getContentPane().add(lblCustomerPhone);
		
		JLabel lblPaymentAmount = new JLabel("Payment Amount: ");
		lblPaymentAmount.setBounds(22, 107, 114, 14);
		getContentPane().add(lblPaymentAmount);
		
		JLabel lblAmount = new JLabel(total);
		lblAmount.setBounds(146, 107, 99, 14);
		getContentPane().add(lblAmount);
		
		JButton button = new JButton("Cash Payment");
		button.setBounds(146, 153, 123, 23);
		getContentPane().add(button);
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				invoice(connect);
				parent.dispose();
				dispose();
			}
		});
		
		JButton btnCreditPayment = new JButton("Credit Payment");
		btnCreditPayment.setEnabled(false);
		btnCreditPayment.setToolTipText("Disabled due to lack of credit card scanner");
		btnCreditPayment.setBounds(146, 187, 123, 23);
		getContentPane().add(btnCreditPayment);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	
	protected void invoice(Connection connect) 
	{
		Statement stmt = null;
		
		String query = "Insert into invoice (RTN_id, invoice_total, payment_type, ivc_open) "
				+ "values ('" + /*id?*/ ""+ "', " + /*total?*/ ""+ ", '"  + /*paymentType?*/ ""+ "', " 
				+ "'Paid')";
		
		try{
			//Prepare the stored procedure call
			stmt = connect.createStatement();
			
			//call stored procedure
			System.out.println("Calling stored procedure for invoice sale");
			stmt.execute(query);
			System.out.println("Finished calling procedure");
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
}
