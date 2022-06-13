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

public class LoginPageController {

	@FXML
	TextField nameTextField;

	@FXML
	TextField pwdTextField;

	@FXML
	Label sysMessage;

	private Stage stage;
	private Scene scene;
	private Parent root;

	/**
	 * When pressed the login button, the user can login if the data is identical to
	 * a user in database
	 * 
	 * @param event
	 * @throws IOException
	 */

	public void toLogin(ActionEvent event) throws IOException {

		String username = nameTextField.getText();

		String password = pwdTextField.getText();

		Connector local = new Connector();
		Object[] arr = local.readUser(username);

		User user = new User(arr);

		if (username.equals(user.getFirstname()) && password.equals(user.getpassword()) == true) {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("UserMainPage.fxml"));
			root = loader.load();

			UserMainPageController usercontroller = loader.getController();
			usercontroller.displayName(username);
			usercontroller.displayFood();

			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} else {
			sysMessage.setText("Please enter correct account or password");
		}

	}

	/**
	 * When the user wants to create a new account, he/she can press this button and
	 * will be directed to the initialization page
	 * 
	 * @param event
	 * @throws IOException
	 */

	public void toUserInitialization(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("UserInitialization.fxml"));
		root = loader.load();

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

}
