package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author yuhanchiang, Yasser
 * @version 2022/6/11
 *
 */

public class DbConnection {
	/**
	 * This method returns the connection link to the local database
	 * 
	 * @return connection link
	 */
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:javaDatabaseTutorials.db"); // connecting to our database
			System.out.println("Connected!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e + "");
		}

		return con;
	}
}