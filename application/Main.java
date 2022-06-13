package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * @author yuhanchiang
 * @version 2022/6/8 This is the main function
 */
public class Main extends Application {
	@Override
	/**
	 * This function is the starter, it will direct the user to login page to log in
	 * or create an account
	 * 
	 */
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
