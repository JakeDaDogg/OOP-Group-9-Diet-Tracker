package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FoodController {

	private Stage stage;
	private Scene scene;
	private Parent root;

	public String add2;

	@FXML
	TextField arg;

	@FXML
	Label calories;

	@FXML
	Label protein;

	@FXML
	Label carbohydrates;

	@FXML
	Label fat;

	@FXML
	Label message;

	@FXML
	Label hello;

	private Food myfood;
	private User myuser;

	private boolean add = false;
	public String firstname;

	// methods

	/**
	 * This method accepts the username and displays on Food page
	 * 
	 * @param firstName
	 */

	public void HelloUser(String firstName) {
		this.firstname = firstName;
		hello.setText("Hello! " + firstName + ", please search for a food: ");
		Connector local = new Connector();
		Object[] arr = local.readUser(firstName);
		myuser = new User(arr);
	}

	/**
	 * When search button is printed, this function will start the event of
	 * searching food
	 */

	public void search() {
		// return food properties

		String request = null;
		request = arg.getText();
		System.out.println(request);
		add = false;

		try {
			// search for food via JDBC
			if (request == null | request == " ") {
				message.setText("please enter valid food");
				add = false;
			} else { // valid to add
				//
				Connector local = new Connector();
				Object[] arr = local.readFood(request);
				myfood = new Food(arr);
				//
				calories.setText("Calories: " + myfood.getCalories());
				fat.setText("Fat: " + myfood.getFat());
				protein.setText("Protein: " + myfood.getProtein());
				carbohydrates.setText("Carbohydrates: " + myfood.getCarbohydrates());
				message.setText("valid");
				add = true;
				arg.setText(null);
			}

		} catch (Exception e) {
			message.setText("Not in database");
			add = false;
		}

		// return system message

	}

	// connect to JDBC, add to database

	/**
	 * This function adds the selected food to breakfast
	 */

	public void add2breakfast() {

		if (add == true) {
			message.setText("Added to breakfast!");

			// add food to jdbc user log
			Connection con = DbConnection.connect();
			PreparedStatement ps = null;

			Connector local = new Connector();
			Object[] arr = local.readUser(firstname);
			myuser = new User(arr);

			String newstr = myuser.getbreakfast() + " " + myfood.getName();
			int protein = myuser.getProtein() + myfood.getProtein();
			int carbs = myuser.getCarbohydrates() + myfood.getCarbohydrates();
			int fat = myuser.getFat() + myfood.getFat();
			int cals = myuser.getCalories() + myfood.getCalories();

			try {
				// change list
				String sql = "UPDATE users set breakfast = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setString(1, newstr);
				ps.setString(2, firstname);
				ps.execute();

				// change protein
				sql = "UPDATE users set protein = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, protein);
				ps.setString(2, firstname);
				ps.execute();

				// change carb
				sql = "UPDATE users set carbohydrate = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, carbs);
				ps.setString(2, firstname);
				ps.execute();

				// change fat
				sql = "UPDATE users set fat = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, fat);
				ps.setString(2, firstname);
				ps.execute();

				// change fat
				sql = "UPDATE users set calorie = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, cals);
				ps.setString(2, firstname);
				ps.execute();

				System.out.println("Data has been updated");
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}

			// updates the data to user's log by using user's data
		} else {
			message.setText("Please search for valid food");
		}

		add = false;

	}

	/**
	 * This function adds the selected food to lunch after button is pressed
	 */

	public void add2lunch() {

		if (add == true) {
			message.setText("Added to Lunch!");

			// add food to jdbc user log
			Connection con = DbConnection.connect();
			PreparedStatement ps = null;

			Connector local = new Connector();
			Object[] arr = local.readUser(firstname);
			myuser = new User(arr);

			String newstr = myuser.getlunch() + " " + myfood.getName();
			int protein = myuser.getProtein() + myfood.getProtein();
			int carbs = myuser.getCarbohydrates() + myfood.getCarbohydrates();
			int fat = myuser.getFat() + myfood.getFat();
			int cals = myuser.getCalories() + myfood.getCalories();

			try {
				// change list
				String sql = "UPDATE users set lunch = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setString(1, newstr);
				ps.setString(2, firstname);
				ps.execute();

				// change protein
				sql = "UPDATE users set protein = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, protein);
				ps.setString(2, firstname);
				ps.execute();

				// change carb
				sql = "UPDATE users set carbohydrate = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, carbs);
				ps.setString(2, firstname);
				ps.execute();

				// change fat
				sql = "UPDATE users set fat = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, fat);
				ps.setString(2, firstname);
				ps.execute();

				// change fat
				sql = "UPDATE users set calorie = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, cals);
				ps.setString(2, firstname);
				ps.execute();

				System.out.println("Data has been updated");
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}

		} else {
			message.setText("Please search for valid food");
		}

		add = false;

	}

	/**
	 * This function adds the selected food to dinner after button is pressed
	 */

	public void add2dinner() {
		if (add == true) {
			message.setText("Added to dinner!");

			// add food to jdbc user log
			Connection con = DbConnection.connect();
			PreparedStatement ps = null;

			Connector local = new Connector();
			Object[] arr = local.readUser(firstname);
			myuser = new User(arr);

			String newstr = myuser.getdinner() + " " + myfood.getName();
			int protein = myuser.getProtein() + myfood.getProtein();
			int carbs = myuser.getCarbohydrates() + myfood.getCarbohydrates();
			int fat = myuser.getFat() + myfood.getFat();
			int cals = myuser.getCalories() + myfood.getCalories();

			try {
				// change list
				String sql = "UPDATE users set dinner = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setString(1, newstr);
				ps.setString(2, firstname);
				ps.execute();

				// change protein
				sql = "UPDATE users set protein = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, protein);
				ps.setString(2, firstname);
				ps.execute();

				// change carb
				sql = "UPDATE users set carbohydrate = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, carbs);
				ps.setString(2, firstname);
				ps.execute();

				// change fat
				sql = "UPDATE users set fat = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, fat);
				ps.setString(2, firstname);
				ps.execute();

				// change fat
				sql = "UPDATE users set calorie = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, cals);
				ps.setString(2, firstname);
				ps.execute();

				System.out.println("Data has been updated");
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}
		} else {
			message.setText("Please search for valid food");
		}

		add = false;

	}

	/**
	 * This function adds the selected food to snack after button is pressed
	 */

	public void add2snacks() {

		if (add == true) {
			message.setText("Added to snack!");

			// add food to jdbc user log
			Connection con = DbConnection.connect();
			PreparedStatement ps = null;

			Connector local = new Connector();
			Object[] arr = local.readUser(firstname);
			myuser = new User(arr);

			String newstr = myuser.getsnack() + " " + myfood.getName();
			int protein = myuser.getProtein() + myfood.getProtein();
			int carbs = myuser.getCarbohydrates() + myfood.getCarbohydrates();
			int fat = myuser.getFat() + myfood.getFat();
			int cals = myuser.getCalories() + myfood.getCalories();

			try {
				// change list
				String sql = "UPDATE users set snacks = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setString(1, newstr);
				ps.setString(2, firstname);
				ps.execute();

				// change protein
				sql = "UPDATE users set protein = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, protein);
				ps.setString(2, firstname);
				ps.execute();

				// change carb
				sql = "UPDATE users set carbohydrate = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, carbs);
				ps.setString(2, firstname);
				ps.execute();

				// change fat
				sql = "UPDATE users set fat = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, fat);
				ps.setString(2, firstname);
				ps.execute();

				// change fat
				sql = "UPDATE users set calorie = ? WHERE firstName = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, cals);
				ps.setString(2, firstname);
				ps.execute();

				System.out.println("Data has been updated");
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}

		} else {
			message.setText("Please search for valid food");
		}

		add = false;

	}

	/**
	 * When press exit, this method will be evoked and the user will be directed
	 * back to the user main page
	 * 
	 * @param event
	 * @throws IOException
	 */

	public void exit(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("UserMainPage.fxml"));
		root = loader.load();

		UserMainPageController usercontroller = loader.getController();
		// display the name from the database
		usercontroller.displayName(firstname);
		usercontroller.displayFood();

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

}
