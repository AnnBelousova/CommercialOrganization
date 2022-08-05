package data;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

public class Validator {

	// txtFirstName from CustomerGUI
	public static boolean isFirstName(JTextComponent c, String title ) {
		if (c.getText().length() == 0) {
			showMessage1(c, title + " is a requared field. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	private static void showMessage1(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "First Name Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}
	
// txtLastName from CustomerGUI
	public static boolean isLastName(JTextComponent c, String title ) {
		if (c.getText().length() == 0) {
			showMessage2(c, title + " is a requared field. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	private static void showMessage2(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "Last Name Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}
	
//txtPhone from CustomerGUI
	public static boolean isPhone(JTextComponent c, String title ) {
		if (c.getText().length() == 0) {
			showMessage3(c, title + " is a requared field. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	private static void showMessage3(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "Phone Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}	
	
// txtEmail from CustomerGUI
	
	public static boolean isEmail(JTextComponent c, String title ) {
		if (c.getText().length() == 0) {
			showMessage4(c, title + " is a requared field. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	private static void showMessage4(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "Email Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}
	
// txtStreet from CustomerGUI
	
	public static boolean isStreet(JTextComponent c, String title ) {
		if (c.getText().length() == 0) {
			showMessage5(c, title + " is a requared field. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	private static void showMessage5(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "Street Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}
	
// txtCity from CustomerGUI
	
	public static boolean isCity(JTextComponent c, String title ) {
		if (c.getText().length() == 0) {
			showMessage6(c, title + " is a requared field. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	private static void showMessage6(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "City Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}
	
// cmbProvince from CustomerGUI
	
	public static boolean isProvince(JTextComponent c, String title ) {
		if (c.getText().length() == 0) {
			showMessage7(c, title + " is a requared field. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	private static void showMessage7(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "Province Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}
	
// txtPostalCode from CustomerGUI

	public static boolean isPostalCode(JTextComponent c, String title ) {
		if (c.getText().length() == 0) {
			showMessage8(c, title + " is a requared field. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	private static void showMessage8(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "PostalCode Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}
	
	// txtProductName from ProductGUI

	public static boolean isProductName(JTextComponent c, String title ) {
			if (c.getText().length() == 0) {
				showMessage9(c, title + " is a requared field. \nPlease re-enter.");
				c.requestFocusInWindow();
				return false;
			}
			return true;
		}
	private static void showMessage9(JTextComponent c, String message) {
			JOptionPane.showMessageDialog(c, message, "Product Name Invalid Entry", JOptionPane.ERROR_MESSAGE);
		}	
		
		// txtPrice from ProductGUI

	public static boolean isPrice(JTextComponent c, String title ) {
			if (c.getText().length() == 0) {
				showMessage10(c, title + " is a requared field. \nPlease re-enter.");
				c.requestFocusInWindow();
				return false;
			}
			return true;
			}
	private static void showMessage10(JTextComponent c, String message) {
			JOptionPane.showMessageDialog(c, message, "Price Name Invalid Entry", JOptionPane.ERROR_MESSAGE);
			}	
	
	// txtMIN from ProductGUI

	public static boolean isMin(JTextComponent cMin, String title ) {
		if (cMin.getText().length() == 0) {
			showMessage11(cMin, title + " is a requared field. \nPlease re-enter.");
			cMin.requestFocusInWindow();
			return false;
		}
		return true;
		}
	private static void showMessage11(JTextComponent cMin, String message) {
		JOptionPane.showMessageDialog(cMin, message, "Price Min invalid Entry", JOptionPane.ERROR_MESSAGE);
		}	
	
	// txtMAX from ProductGUI

	public static boolean isMax(JTextComponent cMax, String title ) {
		if (cMax.getText().length() == 0) {
			showMessage12(cMax, title + " is a requared field. \nPlease re-enter.");
			cMax.requestFocusInWindow();
			return false;
		}
		return true;
		}
	private static void showMessage12(JTextComponent cMax, String message) {
		JOptionPane.showMessageDialog(cMax, message, "Price Max invalid Entry", JOptionPane.ERROR_MESSAGE);
		}	
	
	// txtProductId from ProductGUI

	public static boolean isProductId(JTextComponent c, String title ) {
		if (c.getText().length() != 0) {
			showMessage13(c, title + " MUST be Empty. \nPlease clear it.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
		}
	private static void showMessage13(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "ProductID MUST BE EMPTY", JOptionPane.ERROR_MESSAGE);
		}	
	

	// txtProductId from ProductGUI UPLOAD

	public static boolean isNotProductId(JTextComponent c, String title ) {
		if (c.getText().length() == 0) {
			showMessage14(c, title + " is a requared field. \nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
		}
	private static void showMessage14(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "ProductID is invalid or empty", JOptionPane.ERROR_MESSAGE);
		}	
	
	
	// txtCustID from CustomerGUI Save

	public static boolean isCustID(JTextComponent c, String title ) {
		if (c.getText().length() != 0) {
			showMessage15(c, title + " Must be Empty. \nPlease clean it.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
		}
	private static void showMessage15(JTextComponent c, String message) {
		JOptionPane.showMessageDialog(c, message, "CustID must be empty", JOptionPane.ERROR_MESSAGE);
		}
 
	
// txtCustID from CustomerGUI First - if the record is 1 

	public static boolean isCustIDIsNull(JTextComponent cFirst, String title ) {
		if (cFirst.getText().length() == 0) {
			showMessage16(cFirst, title + " is not present in database \n Please insert information.");
			cFirst.requestFocusInWindow();
			return false;
		}
		return true;
		}
	private static void showMessage16(JTextComponent cFirst, String message) {
		JOptionPane.showMessageDialog(cFirst, message, "The record is not present in Database", JOptionPane.ERROR_MESSAGE);
		}
	
}