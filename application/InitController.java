package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InitController {

	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	TextField firstName;

	@FXML
	TextField lastName;

	@FXML
	TextField email;

	@FXML
	TextField password;

	@FXML
	Label sysMessage;

	private String strfirstname = "0";
	private String strlastname = "0";
	private String stremail = "0";
	private String strpassword = "0";

	/**
	 * After the user entered all the data and entered submit button, this will
	 * write the imput data into database and create a new user
	 * 
	 * @param event
	 * @throws IOException
	 */

	public void submit(ActionEvent event) throws IOException {
		strfirstname = firstName.getText();
		strlastname = lastName.getText();
		stremail = email.getText();
		strpassword = password.getText();
		try {
			Connector local = new Connector();
			local.insert(this.strfirstname, this.strlastname, this.stremail, this.strpassword);
		} catch (Exception e) {
			sysMessage.setText("Please fill out all of it");
		}

		FXMLLoader loader = new FXMLLoader(getClass().getResource("UserMainPage.fxml"));
		root = loader.load();

		UserMainPageController usercontroller = loader.getController();
		usercontroller.displayName(strfirstname);
		usercontroller.displayFood();

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

}
