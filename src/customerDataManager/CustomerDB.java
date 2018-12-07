package customerDataManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDB {

	// Variables created for the database connection.
	static Connection conn = null;
	static String URL = "jdbc:mysql://localhost:3306/mma?useSSL=false";
	static String username = "user";
	static String password = "sesame";

	//Creates an ArrayList of Objects from the customer database and returns it to the main method.
	public static ArrayList<Customer> getCustomers() throws Exception {
		ArrayList<Customer> array = new ArrayList<>();
		PreparedStatement statement = null;
		try {
			conn = (Connection) DriverManager.getConnection(URL, username, password);
			statement = (PreparedStatement) conn.prepareStatement("SELECT * FROM customer");

			ResultSet result = statement.executeQuery();
			System.out.println("CUSTOMER LIST");

			// Loop that adds the Query Results to a result set
			while (result.next()) {

				// Instance Variables set to get values from result set to insert into ArrayList
				// objects
				String firstName = result.getString("first_Name");
				String lastName = result.getString("last_Name");
				String email = result.getString("email");

				// Creates and initializes customer objects and fields.
				Customer x = new Customer(email, firstName, lastName);

				// Adds the customer object to the ArrayList
				array.add(x);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			statement.close();
			conn.close();

		}

		return array;

	}

	// Deletes a customer out of the database by searching for them by their email.
	public static void deleteCustomerByEmail(String email) throws Exception {
		PreparedStatement pst = null;
		String first = "mike", last = "stipe";
		try {
			conn = (Connection) DriverManager.getConnection(URL, username, password);

			pst = (PreparedStatement) conn.prepareStatement("DELETE FROM customer WHERE email =?");
			pst.setString(1, email);
			pst.executeUpdate();

			System.out.printf("\n%s %s was deleted from the database.\n\n", first, last);
		} catch (Exception e) {
			System.out.println(e);
		}
		pst.close();
		conn.close();

	}

	//Adds a customer to the database that the customer enters.
	public static Customer AddCustomer(String first, String last, String email) throws Exception {

		Customer c = new Customer(first, last, email);
		PreparedStatement pst = null;
		try {
			conn = (Connection) DriverManager.getConnection(URL, username, password);

			pst = (PreparedStatement) conn
					.prepareStatement("INSERT INTO customer (email,first_Name,last_Name) VALUES(?,?,?)");
			pst.setString(1, email);
			pst.setString(2, first);
			pst.setString(3, last);
			pst.executeUpdate();

			System.out.printf("\n%s %s was added to the database.\n\n", first, last);
		} catch (Exception e) {
			System.out.println(e);
		}
		pst.close();
		conn.close();

		return c;
	}

}
