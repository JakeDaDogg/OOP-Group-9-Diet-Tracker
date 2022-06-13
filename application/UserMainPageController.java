package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class UserMainPageController {

	private Stage stage;
	private Scene scene;
	private Parent root;

	public String breakfastlist;
	public String lunchlist;
	public String dinnerlist;
	public String snacklist;
	public String sumProtein;
	public String sumCalories;
	public String sumCarbs;
	public String sumFat;

	@FXML
	Label nameLabel;

	@FXML
	Label breakfast;

	@FXML
	Label lunch;

	@FXML
	Label dinner;

	@FXML
	Label snacks;

	@FXML
	Label calories;

	@FXML
	Label protein;

	@FXML
	Label carbohydrates;

	@FXML
	Label fat;

	private String firstName;
	private User myuser;

	public void displayName(String username) {

		nameLabel.setText("Hello: " + username); // hello ronnie
		this.firstName = username;
		// System.out.println("display name: " + firstName);
	}

	public void displayFood() {

		// creates a user class by searching for firstname
		Connector local = new Connector();
		Object[] arr = local.readUser(firstName);
		myuser = new User(arr);
		// reads breakfast, lunch, dinner, and snack
		breakfastlist = myuser.getbreakfast();
		lunchlist = myuser.getlunch();
		dinnerlist = myuser.getdinner();
		snacklist = myuser.getsnack();
		sumCalories = Integer.toString(myuser.getCalories());
		sumCarbs = Integer.toString(myuser.getCarbohydrates());
		sumProtein = Integer.toString(myuser.getProtein());
		sumFat = Integer.toString(myuser.getFat());

		// set Text to the following variables
		breakfast.setText(breakfastlist);
		lunch.setText(lunchlist);
		dinner.setText(dinnerlist);
		snacks.setText(snacklist);
		protein.setText(sumProtein);
		calories.setText(sumCalories);
		carbohydrates.setText(sumCarbs);
		fat.setText(sumFat);
	}

	public void toSearch(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("Search4Food.fxml"));
		root = loader.load();

		// bug searcher is null

		FoodController searcher = loader.getController();
		searcher.HelloUser(firstName);

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public void toExit(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
		root = loader.load();
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
