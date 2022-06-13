package application;

/*
 * @author Yasser, Yuhan
 * @version 2022/6/11
 * 
 * 
 */

public class Food {

	// Instance variables

	private String name;
	private int calories;
	private int protein;
	private int carbohydrate; // check spelling
	private int fat;

	/**
	 * This is the constructor of food. It reads the array that contains the food
	 * data in array form and writes it in its private variables.
	 * 
	 * @param arr
	 */

	public Food(Object[] arr) {

		// loads food info by the name that was searched in database

		this.name = (String) arr[0];
		this.protein = (int) arr[1];
		this.carbohydrate = (int) arr[2];
		this.fat = (int) arr[3];
		this.calories = (int) arr[4];

	}

	/**
	 * get the name of the food
	 * 
	 * @return food name
	 */
	public String getName() {

		return name;

	}

	/**
	 * get the the calories of the food
	 * 
	 * @return calories amount of food
	 */

	public int getCalories() {

		return calories;

	}

	/**
	 * get the protein of the food
	 * 
	 * @return protein amount of food
	 */

	public int getProtein() {
		return this.protein;
	}

	/**
	 * get the fat of the food
	 * 
	 * @return get fat amount of food
	 */

	public int getFat() {
		return this.fat;
	}

	/**
	 * get carbs of the food
	 * 
	 * @return carbs amount of food
	 */

	public int getCarbohydrates() {
		return this.carbohydrate;
	}

}
