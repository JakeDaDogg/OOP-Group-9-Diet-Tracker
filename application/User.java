package application;

/**
 * 
 * @author yuhanchiang, Yasser
 * @version 2022/6/11
 */

public class User {

	// user data
	private String firstname;
	private String lastname;
	private String password;
	private String email;

	// log of food
	private String breakfastlog;
	private String lunchlog;
	private String dinnerlog;
	private String snacklog;

	// statistics
	private int sumCalories;
	private int sumProtein;
	private int sumCarbohydrates;
	private int sumFat;

	/**
	 * This is the construtor of the user class, it accepts an array that contains a
	 * certain user info, which is loaded by the Connector class
	 * 
	 * @param arr
	 */
	public User(Object[] arr) {

		// connect to JDBC and write values to login

		// search for username

		this.firstname = (String) arr[0];// command to get password
		this.lastname = (String) arr[1];
		this.email = (String) arr[2];
		this.password = (String) arr[3];
		this.breakfastlog = (String) arr[4];
		this.lunchlog = (String) arr[5];
		this.dinnerlog = (String) arr[6];
		this.snacklog = (String) arr[7];
		this.sumProtein = (int) arr[8];
		this.sumCarbohydrates = (int) arr[9];
		this.sumFat = (int) arr[10];
		this.sumCalories = (int) arr[11];

	}

	/**
	 * This method returns the first name of the user
	 * 
	 * @return firstname
	 */
	public String getFirstname() {
		String firstname;
		firstname = this.firstname;
		System.out.println(firstname);
		return firstname;
	}

	/**
	 * This method returns the email of the user
	 * 
	 * @return email
	 */
	public String getEmail() {
		String email;
		email = this.email;
		return email;
	}

	/**
	 * This method returns the password of the user
	 * 
	 * @return password
	 */
	public String getpassword() {
		String pwd;
		pwd = this.password;
		System.out.println(pwd);
		return pwd;
	}

	/**
	 * This method returns the breakfast list in the user's log
	 * 
	 * @return string
	 */
	public String getbreakfast() {
		String breakfast;
		breakfast = this.breakfastlog;
		System.out.println(breakfast);
		return breakfast;
	}

	/**
	 * This method returns the lunch list of the user's log
	 * 
	 * @return string
	 */
	public String getlunch() {
		String lunch;
		lunch = this.lunchlog;
		System.out.println(lunch);
		return lunch;
	}

	/**
	 * This methods return the dinner list of the user's log
	 * 
	 * @return string
	 */
	public String getdinner() {
		String dinner;
		dinner = this.dinnerlog;
		System.out.println(dinner);
		return dinner;
	}

	/**
	 * This methods return the snack list of the user's log
	 * 
	 * @return string
	 */
	public String getsnack() {
		String snacks;
		snacks = this.snacklog;
		System.out.println(snacks);
		return snacks;
	}

	/**
	 * This methods return the protein amount of the user's log
	 * 
	 * @return string
	 */
	public int getProtein() {
		int protein;
		protein = this.sumProtein;
		return protein;
	}

	/**
	 * This methods return the carbohydrate amount of the user's log
	 * 
	 * @return string
	 */
	public int getCarbohydrates() {
		int carbs;
		carbs = this.sumCarbohydrates;
		return carbs;
	}

	/**
	 * This methods return the fat amount of the user's log
	 * 
	 * @return string
	 */
	public int getFat() {
		int fat;
		fat = this.sumFat;
		return fat;
	}

	/**
	 * This methods return the calorie amount of the user's log
	 * 
	 * @return string
	 */
	public int getCalories() {
		int cal;
		cal = this.sumCalories;
		return cal;
	}

}
