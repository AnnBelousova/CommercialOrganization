package data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business.Customer;
import business.Product;
import business.Province;

public class DataIO {
	
private Connection conn = null;
	
	public DataIO() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String dbURL = "jdbc:oracle:thin:@calvin.humber.ca:1521:grok";
		String userName = "N01419012";
		String pwd = "oracle";
		conn = DriverManager.getConnection(dbURL, userName, pwd);
	}
	
	public int checkTableCust() throws SQLException {
		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rst = dbm.getTables(null, null, "CUSTOMER", null);
		int ch = 0;
		if(rst.next()) {
			ch = 1;
		}else{
			ch = 0;
		}
		return ch;
	}
	
	public int checkTableProd() throws SQLException {
		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet rst = dbm.getTables(null, null, "PRODUCT", null);
		int ch = 0;
		if(rst.next()) {
			ch = 1;
		}else{
			ch = 0;
		}
		return ch;
	}
	
	
	public void createTableCustomer() throws SQLException {		
		String sqlStm = "Create Table Customer (\n" + 
				"CUST_ID int PRIMARY KEY, \n" + 
				"CUST_FIRST varchar (30) not null, \n" +
				"CUST_LAST varchar (30) not null, \n" +
				"CUST_PHONE varchar (10), \n" +
				"CUST_EMAIL varchar (30) not null, \n" +
				"CUST_STREET varchar (50), \n" +
				"CUST_CITY varchar (30), \n" +
				"CUST_PROVINCE varchar (20), \n" +
				"CUST_POSTALCODE varchar (6) \n )"; 
		Statement stm = conn.createStatement();
		stm.execute(sqlStm);
		stm.close();
	}
	
	
	public void insertCustomer(Customer customer) throws SQLException {
		String sqlStm = "Insert into Customer values ( " +
				customer.getCustomerId() + ", '" +
				customer.getFirstName() + "', '" + 
				customer.getLastName() + "', '" + 
				customer.getPhone() + "', '" +
				customer.getEmail() + "', '" +
				customer.getStreet() + "', '" +
				customer.getCity() + "', '" +
				customer.getProvince() + "', '" +
				customer.getPostalCode() + "')";		
		Statement stm = conn.createStatement();
		stm.execute(sqlStm);
		stm.close();	
	}
	
	
	public ArrayList<Customer> displayCustomersF(String nameF) throws SQLException{
		String sqlStm = "Select * From Customer Where " + 
				"CUST_FIRST='" + nameF + "'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlStm);
		ArrayList<Customer> customers = new ArrayList<Customer>();
		while(rst.next()) {
			Customer customer  = new Customer();
			customer.setCustomerId(rst.getInt(1));
			customer.setFirstName(rst.getString(2));
			customer.setLastName(rst.getString(3));
			customer.setPhone(rst.getString(4));
			customer.setEmail(rst.getString(5));
			customer.setStreet(rst.getString(6));
			customer.setCity(rst.getString(7));
			customer.setProvince(rst.getString(8));
			customer.setPostalCode(rst.getString(9));
			customers.add(customer);
		}
		rst.close();
		stm.close();
		return customers;			
	}
	
	
	public ArrayList<Customer> displayCustomersL(String nameL) throws SQLException{
		String sqlStm = "Select * From Customer Where " +  
				"CUST_LAST='" + nameL + "'";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlStm);
		ArrayList<Customer> customers = new ArrayList<Customer>();
		while(rst.next()) {
			Customer customer  = new Customer();
			customer.setCustomerId(rst.getInt(1));
			customer.setFirstName(rst.getString(2));
			customer.setLastName(rst.getString(3));
			customer.setPhone(rst.getString(4));
			customer.setEmail(rst.getString(5));
			customer.setStreet(rst.getString(6));
			customer.setCity(rst.getString(7));
			customer.setProvince(rst.getString(8));
			customer.setPostalCode(rst.getString(9));
			customers.add(customer);
		}
		rst.close();
		stm.close();
		return customers;			
	}
	
	
	public int lastRow() throws SQLException{
		int numb = 0;	
		String sqlStm  = "Select Max(CUST_ID) From Customer";
		Statement stm = conn.createStatement();		
		ResultSet rst = stm.executeQuery(sqlStm);
		while(rst.next()) {
			numb = rst.getInt(1);	
		}
		rst.close();
		stm.close();
		return numb;
	}
	
	
	public String[] findRow(int numb) throws SQLException{
		String sqlStm = "Select * From Customer Where CUST_ID = " + numb;
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlStm);
		String [] customerNew = new String[9];
		while(rst.next()) {
			customerNew[0] = Integer.toString(rst.getInt(1));
			customerNew[1] = rst.getString(2);
			customerNew[2] = rst.getString(3);
			customerNew[3] = rst.getString(4);
			customerNew[4] = rst.getString(5);
			customerNew[5] = rst.getString(6);
			customerNew[6] = rst.getString(7);
			customerNew[7] = rst.getString(8);
			customerNew[8] = rst.getString(9);
		}
		rst.close();
		stm.close();
		return customerNew;	
	}

	public void updateRecord(Customer customer, int custId) throws SQLException {		
		String sqlStm =
				"Update customer set " +
				"CUST_FIRST = '" + customer.getFirstName() + "', " + 
				"CUST_LAST = '" + customer.getLastName() + "', " + 
				"CUST_PHONE = '" + customer.getPhone() + "', " + 
				"CUST_EMAIL = '" + customer.getEmail() + "', " + 
				"CUST_STREET = '" + customer.getStreet() + "', " + 
				"CUST_CITY = '" + customer.getCity() + "', " + 
				"CUST_PROVINCE = '" + customer.getProvince() + "', " + 
				"CUST_POSTALCODE = '" + customer.getPostalCode() + "' " + 
				"WHERE CUST_ID = " + custId + " ";
		Statement stm = conn.createStatement();
		stm.execute(sqlStm);
		stm.close();
	}
	
	
	public ArrayList<Province> getProvince() throws SQLException{
		String sqlStm = "Select * from Province";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlStm);
		ArrayList<Province> provinces = new ArrayList<Province>();	
		while(rst.next()) {
			Province province  = new Province();
			province.setName(rst.getString(1));
			provinces.add(province);
		}
		rst.close();
		stm.close();
		return provinces;
	}
	
	public void createTableProduct() throws SQLException {
		String sqlStm = "Create Table Product (\n" + 
				"PROD_ID int PRIMARY KEY, \n" + 
				"PROD_NAME varchar (30) not null, \n" +
				"PROD_PRICE number (8,2) not null \n )";
		Statement stm = conn.createStatement();
		stm.execute(sqlStm);
		stm.close();
	}
	
	public void insertProduct(Product product) throws SQLException {
		String sqlStm = "Insert into Product values ( " +
				product.getProductId() + ", '" +
				product.getProductName() + "', " + 
				product.getListPrice() + ")" ;		
		Statement stm = conn.createStatement();
		stm.execute(sqlStm);
		stm.close();	
	}
	
	public int lastRowProd() throws SQLException{
		int numb = 0;	
		String sqlStm  = "Select Max(PROD_ID) From Product";
		Statement stm = conn.createStatement();		
		ResultSet rst = stm.executeQuery(sqlStm);
		while(rst.next()) {
			numb = rst.getInt(1);	
		}
		rst.close();
		stm.close();
		return numb;
		}
	
	public void updateRecordProd(Product product, int prodId) throws SQLException {		
		String sqlStm =
				"Update Product set " +
				"PROD_NAME = '" + product.getProductName() + "', " + 
				"PROD_PRICE = " + product.getListPrice() + " " +  
				"WHERE PROD_ID = " + prodId + " ";
		Statement stm = conn.createStatement();
		stm.execute(sqlStm);
		stm.close();
	}
	
	public ArrayList<Product> displayProductsName(String name) throws SQLException{
		String sqlStm = "Select * From Product Where " + 
				"PROD_NAME like '%" + name +  "%' order by PROD_ID";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlStm);
		ArrayList<Product> products = new ArrayList<Product>();
		while(rst.next()) {
			Product product  = new Product();
			product.setProductId(rst.getInt(1));
			product.setProductName(rst.getString(2));
			product.setListPrice(rst.getDouble(3));
			products.add(product);
		}
		rst.close();
		stm.close();
		return products;			
	}
	
	public ArrayList<Product> displayProductsId(int prodId) throws SQLException{
		String sqlStm = "Select * From Product Where " + 
				"PROD_ID = " + prodId +  " ";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlStm);
		ArrayList<Product> products = new ArrayList<Product>();
		while(rst.next()) {
			Product product  = new Product();
			product.setProductId(rst.getInt(1));
			product.setProductName(rst.getString(2));
			product.setListPrice(rst.getDouble(3));
			products.add(product);
		}
		rst.close();
		stm.close();
		return products;			
	}
	
	public ArrayList<Product> displayProductsMinMax(int min, int max) throws SQLException{
		String sqlStm = "Select * From Product Where " + 
				"PROD_PRICE BETWEEN " + min +  " AND " + max + " order by PROD_ID";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlStm);
		ArrayList<Product> products = new ArrayList<Product>();
		while(rst.next()) {
			Product product  = new Product();
			product.setProductId(rst.getInt(1));
			product.setProductName(rst.getString(2));
			product.setListPrice(rst.getDouble(3));
			products.add(product);
		}
		rst.close();
		stm.close();
		return products;			
	}
}
