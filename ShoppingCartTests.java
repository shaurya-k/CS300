//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           (Shopping Cart)
// Files:           (ShoppingCartTests.java)
// Course:          (CS 300, Spring, 2019)
//
// Author:          (Shaurya Kethireddy)
// Email:           (skethireddy@wisc.edu)
// Lecturer's Name: (Gary Dahl)
//
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Arrays;

public class ShoppingCartTests {
	// Define final parameters
	public static int errors = 0;
	// a perfect-size two-dimensional array that stores the available items in
    // the market MARKET_ITEMS[i][0] refers to a String that represents the 
    //description of the item identified by index i MARKET_ITEMS[i][1] 
    //refers to a String that represents the unit price of the item
    // identified by index i in dollars.
	public static final String[][] MARKET_ITEMS = new String[][] {
			{ "Apple", "$1.59" }, { "Avocado", "$0.59" }, { "Banana", "$0.49" },
			{ "Beef", "$3.79" }, { "Blueberry", "$6.89" },
			{ "Broccoli", "$1.79" }, { "Butter", "$4.59" },
			{ "Carrot", "$1.19" }, { "Cereal", "$3.69" }, { "Cheese", "$3.49" },
			{ "Chicken", "$5.09" }, { "Chocolate", "$3.19" },
			{ "Cookie", "$9.5" }, { "Cucumber", "$0.79" }, { "Eggs", "$3.09" },
			{ "Grape", "$2.29" }, { "Ice Cream", "$5.39" }, { "Milk", "$2.09" },
			{ "Mushroom", "$1.79" }, { "Onion", "$0.79" },
			{ "Pepper", "$1.99" }, { "Pizza", "$11.5" }, { "Potato", "$0.69" },
			{ "Spinach", "$3.09" }, { "Tomato", "$1.79" } };
	/**
	 * checks if the item is being added right after the previous item.
	 * 
	 * @return false if item is not added to the right location
	 */

	public static boolean testLocationAfterIncrementation() {
		String[] cart = new String[20]; // shopping cart
		int count = 1;// the index where the item must be added
		ShoppingCart.add(1, cart, count);// calling the add function of
											// shoppingCart
		if (!cart[1].equals("Avocado")) {// checks if the item is added in the
											// right location
			System.out.println(
					"Error, The item is not added to the end of the cart ");
			errors++;
			return false;

		}
		return true;
	}

	/**
	 * checks if the add function recognizes that the cart is full when it
	 * exceeds cart capacity
	 * 
	 * @return false if not able to recognize that cart is full
	 */
	public static boolean testCapacityOverload() {
		String[] cart = new String[20];// shopping cart
		int count = 20;// number of items
		int output = ShoppingCart.add(1, cart, count);// calling the add
														// function of
														// shoppingCart
		if (output != 20) {// checks if the function recognizes that the cart is
							// full
			System.out.println(
					"Error, function deosnt recognise that the cart is full");
			errors++;
			return false;
		}
		return true;

	}
	/**
	 * checks if the occurrenceOf function recognizes that the cart has two of 
	 * the same elements
	 * 
	 * @return false if not able to recognize that cart has two same elements
	 */
	public static boolean testOccurencesOf() {
		String[] cart = new String[20];
		int count = 0;
		count = ShoppingCart.add(1, cart, count);// adding an item to the cart
		count = ShoppingCart.add(2, cart, count);// adding an item to the cart
		count = ShoppingCart.add(1, cart, count);// adding an item to the cart
		count = ShoppingCart.add(4, cart, count);// adding an item to the cart
		int occurence = ShoppingCart.occurrencesOf(1, cart, count);
			//calling the occurrencesOf method
		if (occurence != 2) {// checks if the number of occurrences of the item
								// is correctly returned
			System.out.println("Error the function incorrectly returned "
					+ occurence + "instead of 2");
			errors++;
			return false;
		}
		return true;
	}
	/**
	 * checks if the occurrenceOf function recognizes that the cart has zero of 
	 * the same elements
	 * 
	 * @return false if not able to recognize that cart has zero same elements
	 */
	public static boolean testZeroOcurrences() {
		String[] cart = new String[20];
		int count = 0;
		ShoppingCart.add(1, cart, count);// adding an item to the cart
		ShoppingCart.add(2, cart, count);// adding an item to the cart
		ShoppingCart.add(1, cart, count);// adding an item to the cart
		ShoppingCart.add(4, cart, count);// adding an item to the cart
		int occurence = ShoppingCart.occurrencesOf(5, cart, count);
		// calling the occurenceOf method
		if (occurence != 0) {// checks if the number of occurrences of the item
								// is correctly returned
			System.out.println("Error, the function returned " + occurence
					+ " instead of 0");
			errors++;
			return false;
		}
		return true;
	}
	/**
	 * checks if the remove function recognizes the item to remove and actually
	 * removes it
	 * 
	 * @return false if not able to remove the desired item 
	 */
	public static boolean testRemove() {
		String[] cart = new String[20];
		int count = 0;// Initializes the count
		count = ShoppingCart.add(1, cart, count);// adding an item to the cart
		count = ShoppingCart.add(2, cart, count);// adding an item to the cart
		count = ShoppingCart.add(0, cart, count);// adding an item to the cart
		count = ShoppingCart.add(4, cart, count);// adding an item to the cart
		count = ShoppingCart.remove("Avocado", cart, count);
		if (count != 3) {
			System.out.println("Error, incorrect count correct count");
			errors++;
			return false;
		} else if (Arrays.asList(cart).contains("Avocado")) {
			System.out.println("Error,the remove function doesnt remove "
					+ "an item");
			errors++;
			return false;
		}
		return true;
	}
	/**
	 * checks if the remove function recognizes that the cart has zero elements
	 * and won't be able to remove any elements
	 * 
	 * @return false if not able to recognize that cart has zero elements and 
	 * still tries to remove
	 */
	public static boolean testRemoveWhenCartEmpty() {
		String[] cart = new String[4];// Initializes the cart with a capacity of
										// 4
		int count = 0;// Initializes the count
		// ShoppingCart.add(1,cart,count);// adding an item to the cart
		// ShoppingCart.add(2,cart,count);// adding an item to the cart
		// ShoppingCart.add(1,cart,count);// adding an item to the cart
		// ShoppingCart.add(4,cart,count);// adding an item to the cart
		int numItems = ShoppingCart.remove("Avocado", cart, count);
		// calling the remove function
		if (numItems != 3 && cart[3] != null) {
			// checks if the last position of a full cart is changed to null
			System.out.println("Error, the count returned was incorrrect");
			errors++;
			return false;
		}
		return true;
	}

	/**
	 * Checks whether the total number of items within the cart is incremented
	 * after adding one item
	 * 
	 * @return true if the test passes without problems, false otherwise
	 */
	public static boolean testCountIncrementedAfterAddingOnlyOneItem() {
		boolean testPassed = true; // boolean local variable evaluated to true
									// if this test passed,
									// false otherwise
		String[] cart = new String[20]; // shopping cart
		int count = 0; // number of items present in the cart (initially the
						// cart is empty)

		// Add an item to the cart
		count = ShoppingCart.add(3, cart, count); // add an item of index 3 to
													// the cart
		// Check that count was incremented
		if (count != 1) {
			System.out.println(
					"Problem detected: After adding only one item to the cart, "
							+ "the cart count should be incremented. But, "
							+ "it was not the case.");
			testPassed = false;
			errors++;
		}
		return testPassed;
	}

	/**
	 * Checks whether add and OccurrencesOf return the correct output when only
	 * one item is added to the cart
	 * 
	 * @return true if test passed without problems, false otherwise
	 */
	public static boolean testAddAndOccurrencesOfForOnlyOneItem() {
		boolean testPassed = true; // evaluated to true if test passed without
									// problems, false otherwise
		// define the shopping cart as an over size array of elements of type
		// String
		// we can set an arbitrary capacity for the cart - for instance 10
		String[] cart = new String[10]; // shopping cart
		int count = 0; // number of items present in the cart (initially the
						// cart is empty)

		// check that OccurrencesOf returns 0 when called with an empty cart
		if (ShoppingCart.occurrencesOf(10, cart, count) != 0) {
			System.out.println(
					"Problem detected: Tried calling OccurrencesOf() method "
							+ "when the cart is empty. The result should be 0."
							+ " But, it "
							+ "was not.");
			errors++;
			testPassed = false;
		}

		// add one item to the cart
		count = ShoppingCart.add(0, cart, count); // add an item of index 0 to
													// the cart

		// check that OccurrencesOf("Apples", cart, count) returns 1 after
		// adding the item with key 0
		if (ShoppingCart.occurrencesOf(0, cart, count) != 1) {
			System.out.println(
					"Problem detected: After adding only one item with key 0 "
							+ "to the cart, "
							+ "OccurrencesOf to count how many of that item the"
							+ "cart contains should return 1. "
							+ "But, it was not the case.");
			errors++;
			testPassed = false;
		}

		return testPassed;
	}
		//calls all test methods and prints how many failed tests
	public static void main(String args[]) {
		testLocationAfterIncrementation();
		testCapacityOverload();
		testOccurencesOf();
		testZeroOcurrences();
		testRemove();
		testRemoveWhenCartEmpty();
		testCountIncrementedAfterAddingOnlyOneItem();
		testAddAndOccurrencesOfForOnlyOneItem();

		System.out.println("You failed " + errors + " tests");

	}

}
