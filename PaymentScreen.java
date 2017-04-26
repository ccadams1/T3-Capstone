import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class PaymentScreen extends JDialog {
	//initiates variables
	private final JPanel contentPanel = new JPanel();
	private static Connection connect = null;
	private Customer thisCustomer = new Customer();
	private static Inventory inventory = new Inventory();
	private Employee currentUser = new Employee();
	private ArrayList<CheckoutItemPanel> panelList = new ArrayList<CheckoutItemPanel>();
	private double totalValue;
	private long time;

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
	 * @param panelList 
	 * @param panel_2 
	 * @param totalValue 
	 */
	public PaymentScreen(ArrayList<Object> data, ArrayList<CheckoutItemPanel> panelList, POSPanel posPanel, Customer cus, String total, double totalValue, JDialog parent, long time) {
		//initiates variables and get database data
		PaymentScreen.connect = (Connection) data.get(0);
		PaymentScreen.inventory = (Inventory) data.get(3);
		this.currentUser = (Employee) data.get(6);
		this.panelList = panelList;
		this.thisCustomer = cus;
		this.totalValue = totalValue;
		this.time = time;
		
		//sets dialog properties
		setAlwaysOnTop (true);
		setLocationRelativeTo(null);
		setVisible(true);
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 400, 275);
		this.setTitle("Payment");
		getContentPane().setLayout(null);
		
		//customer info label
		JLabel lblCustomerInformation = new JLabel("Customer info:");
		lblCustomerInformation.setBounds(22, 11, 114, 14);
		getContentPane().add(lblCustomerInformation);
		
		//displays customer id
		JLabel lblCustomerId = new JLabel(cus.getID());
		lblCustomerId.setBounds(146, 11, 48, 14);
		getContentPane().add(lblCustomerId);
		
		//displays customer name
		JLabel lblCustomerName = new JLabel(cus.getFName()+ " " + cus.getLName());
		lblCustomerName.setBounds(204, 11, 136, 14);
		getContentPane().add(lblCustomerName);
		
		//displays customer address
		JLabel lblCustomerAddress = new JLabel(cus.getStAdress1());
		lblCustomerAddress.setBounds(146, 33, 139, 14);
		getContentPane().add(lblCustomerAddress);
		
		//displays customer address
		JLabel lblCustomerCityState = new JLabel(cus.getCity()+ ", " + cus.getState() + " " + cus.getZipCode());
		lblCustomerCityState.setBounds(146, 55, 139, 14);
		getContentPane().add(lblCustomerCityState);
		
		//displays customer phone number
		JLabel lblCustomerPhone = new JLabel("Phone: " + cus.getPhone1());
		lblCustomerPhone.setBounds(146, 77, 139, 14);
		getContentPane().add(lblCustomerPhone);
		
		//payment amount label
		JLabel lblPaymentAmount = new JLabel("Payment Amount: ");
		lblPaymentAmount.setBounds(22, 107, 114, 14);
		getContentPane().add(lblPaymentAmount);
		
		//displays total
		JLabel lblAmount = new JLabel(total);
		lblAmount.setBounds(146, 107, 99, 14);
		getContentPane().add(lblAmount);
		
		//button for cash payment
		JButton btnCashPayment = new JButton("Cash Payment");
		btnCashPayment.setBounds(146, 153, 123, 23);
		getContentPane().add(btnCashPayment);
		btnCashPayment.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//activates invoice method
				invoice("CASH");
				posPanel.setVisible(false);
				posPanel.setVisible(true);
				//closes this screen and previous screen
				parent.dispose();
				dispose();
			}
		});
		
		//button for credit payment
		JButton btnCreditPayment = new JButton("Credit Payment");
		btnCreditPayment.setEnabled(false);
		btnCreditPayment.setToolTipText("Disabled due to lack of credit card scanner");
		btnCreditPayment.setBounds(146, 187, 123, 23);
		btnCreditPayment.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//activates invoice method
				invoice("CREDIT");
				posPanel.setVisible(false);
				posPanel.setVisible(true);
				//closes this screen and previous screen
				parent.dispose();
				dispose();
			}
		});
		getContentPane().add(btnCreditPayment);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	
	//goes through procedures for a new retail transaction, selling the specific items and their ammounts, and 
	//set a new invoice to the sale
	protected void invoice(String paymentType) 
	{
		int transaction = callAddRetailTransactionProcedure(connect, thisCustomer, currentUser, time);
		//goes through each item beging sold
		for(CheckoutItemPanel panel : panelList)
		{
			callAddRetailTranItemProcedure(connect, transaction, panel.getItemID(), panel.getQuantity(), panel.getTotal());
			System.out.println("Tran:"+transaction+"\tItemID:"+panel.getItemID()+"\tItemQuant:"+panel.getQuantity()
				+"\tTotal:"+panel.getTotal());
			inventory.get(inventory.findItemByName(panel.getItemName())).sellItem(panel.getQuantity());
			callEditItemProcedure(connect, inventory.get(inventory.findItemByName(panel.getItemName())));
		}
		callAddInvoiceProcedure(connect, transaction, paymentType, totalValue);
	}
	
	//creates new retail transaction
	protected int callAddRetailTransactionProcedure(Connection connect, Customer customer, Employee user, long time){
		Date date = new Date(time);
		CallableStatement stmt = null;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspAddRetailTransaction(?,?,?,?,?)}");
			
			//set the parameters
			stmt.registerOutParameter(1, Types.INTEGER);
			stmt.setDate(2, date);
			stmt.setInt(3, Integer.parseInt(customer.getID()));
			stmt.setInt(4, user.getIntUserID());
			stmt.registerOutParameter(5, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add a retail transaction");
			stmt.executeUpdate();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			int rtnID = stmt.getInt(1);
			String response = stmt.getString(5);
			System.out.println(response);
			
			return rtnID;
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return -1;
	}
	
	//sells each item
	protected void callAddRetailTranItemProcedure(Connection connect, int rtnID, int itemID, int quantity, double cost){
		CallableStatement stmt = null;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspAddRetailTranItem(?,?,?,?,?)}");
			
			//set the parameters
			stmt.setInt(1, rtnID);
			stmt.setInt(2, itemID);
			stmt.setInt(3, quantity);
			stmt.setDouble(4, cost);
			stmt.registerOutParameter(5, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add a retail transaction item");
			stmt.executeUpdate();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(5);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	
	//sets invoice for the item
	protected void callAddInvoiceProcedure(Connection connect, int rtnID, String paymentType, double total){
		CallableStatement stmt = null;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspAddInvoice(?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.registerOutParameter(1, Types.INTEGER);
			stmt.setInt(2, rtnID);
			stmt.setInt(3, 0);
			stmt.setString(4, paymentType);
			stmt.setDouble(5, total);
			stmt.registerOutParameter(6, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to add invoice");
			stmt.executeUpdate();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			int invoiceNumber = stmt.getInt(1);
			String response = stmt.getString(6);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	
	//edits the items in the database
	protected void callEditItemProcedure(Connection connect, Item temp){
		CallableStatement stmt = null;
		
		try{
			//Prepare the stored procedure call
			stmt = connect.prepareCall("{call dbo.uspEditInventory(?,?,?,?,?,?,?,?,?,?)}");
			
			//set the parameters
			stmt.setInt(1, Integer.parseInt(temp.getId()));
			stmt.setString(2, null);
			stmt.setString(3, temp.getName());
			stmt.setString(4, temp.getDescription());
			stmt.setInt(5, temp.getQuantity());
			stmt.setInt(6, temp.getParStock());
			stmt.setDouble(7, temp.getPrice());
			stmt.setInt(8, temp.getSupplierID());
			stmt.setInt(9, /*temp.isRemoved()*/0);
			stmt.registerOutParameter(10, Types.VARCHAR);
			
			//call stored procedure
			System.out.println("Calling stored procedure to edit item");
			stmt.executeUpdate();
			System.out.println("Finished calling procedure");
			
			//Get the response message of the OUT parameter
			String response = stmt.getString(10);
			System.out.println(response);
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
}
