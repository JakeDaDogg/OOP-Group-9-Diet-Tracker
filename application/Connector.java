package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * 
 * @author yuhanchiang, Yasser
 * @version 2022/6/11
 * 
 *
 */

public class Connector {
	/**
	 * This is a loader to initialize user data by getting the text from the
	 * interface
	 * 
	 * @param firstName
	 * @param secondName
	 * @param email
	 * @param password
	 */

	public void insert(String firstName, String secondName, String email, String password) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO users(firstName, secondName, email, password, breakfast, lunch, dinner, snacks, protein, carbohydrate, calorie, fat) VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ";
			ps = con.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, secondName);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, "Food: ");
			ps.setString(6, "Food: ");
			ps.setString(7, "Food: ");
			ps.setString(8, "Food: ");
			ps.setInt(9, 0);
			ps.setInt(10, 0);
			ps.setInt(11, 0);
			ps.setInt(12, 0);
			ps.execute();
			System.out.println("Data has been inserted!");
		} catch (SQLException e) {
			System.out.println(e.toString());
			// always remember to close database connections
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		// readAllData;
		// readSpecificRow();
		// updating database = updateFirstName();
	}

	/**
	 * This returns the data of user in an array
	 * 
	 * @param firstname
	 * @return
	 */

	public Object[] readUser(String firstname) {
		// lets read specific row on the database
		Object[] arr = new Object[12];
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "Select * from users where firstName = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, firstname);
			rs = ps.executeQuery();

			// we are reading one row, so no need to loop
			arr[0] = rs.getString(1); // change String to this.variable
			arr[1] = rs.getString(2);
			arr[2] = rs.getString(3);
			arr[3] = rs.getString(4);
			arr[4] = rs.getString(5);
			arr[5] = rs.getString(6);
			arr[6] = rs.getString(7);
			arr[7] = rs.getString(8);
			arr[8] = rs.getInt(9);
			arr[9] = rs.getInt(10);
			arr[10] = rs.getInt(11);
			arr[11] = rs.getInt(12);

			System.out.println(Arrays.toString(arr));

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			// close connections
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}

		}
		return arr;
	}

	/**
	 * This reads the food data searched by the user and returns the food data in
	 * array form
	 * 
	 * @param argument
	 * @return an array that contains the food data
	 */

	public Object[] readFood(String argument) {
		Object[] arr = new Object[5];
		// lets read specific row on the database
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "Select * from nutritionFacts where foodName = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, argument);
			rs = ps.executeQuery();

			// we are reading one row, so no need to loop
			arr[0] = rs.getString(1);
			arr[1] = (int) rs.getInt(2); // change String to this.variable
			arr[2] = (int) rs.getInt(3);
			arr[3] = (int) rs.getInt(4);
			arr[4] = (int) rs.getInt(5);

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			// close connections
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}

		}
		return arr;
	}

}