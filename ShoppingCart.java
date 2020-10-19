//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           (Shopping Cart)
// Files:           (ShoppingCart.java)
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
import java.util.Scanner;

public class ShoppingCart {
    // Define final parameters
    private static final int CART_CAPACITY = 20; // shopping cart max capacity
    private static final double TAX_RATE = 0.05; // sales tax

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
     * adds the item with the given identifier index at the end of the cart
     *
     * @param index of the item within the marketItems array
     * @param cart shopping cart
     * @param count number of items present within the cart before this add 
     * method is called
     * @return the number of items present in the cart after the item with 
     * identifier index is added 
     */

    public static int add(int index, String[] cart, int count) {
        if (count >= CART_CAPACITY) {// checks if the the cart is full
            System.out.println(
                    "WARNING: The cart is full. You cannot add any new item.");
            return count;
        }
        cart[count] = MARKET_ITEMS[index][0];// adding the item to the cart
        count++;
        return count;
    }

    /**
	 * adds the item with the given identifier index at the end of the cart
	 * 
	 * @param index of the item within the marketItems array
	 * @param cart shopping cart
	 * @param count number of items present within the cart before this add 
	 * method is called
	 * @return the number of occurrences of 
	 */

    public static int occurrencesOf(int itemIndex, String[] cart, int count) {
        int occurrence = 0;// keeps track of the number of occurrences
        if(!Arrays.asList(cart).contains(MARKET_ITEMS[itemIndex][0])) {
            System.out.println("WARNING: " + MARKET_ITEMS[itemIndex][0] + 
            		" not found in the shopping cart.");
        }
        for (int i = 0; count > i; i++) {// loops through the cart
            if (cart[i].equals(MARKET_ITEMS[itemIndex][0])) {
                    //checks for the occurrence of the item
                occurrence++;// increments the number of occurrences
            }
        }
        return occurrence;
    }

    /**
	 * removes the first (only one) occurrence of itemToRemove if found and
	 * returns
	 * 
	 * @param itemToRemove string which the function matches with the cart items
	 * @param cart shopping cart
	 * @param count number of items within the cart before this method is called
	 * @return the number of items present in the cart after remove operation is
	 * completed either successfully or not
	 */

    public static int remove(String itemToRemove, String[] cart, int count) {
        int variable = 0;
        if (cart.length == 0) {
            System.out.println("WARNING: cart is empty");
            return 0;
        }
        for (int i = 0; count > i; i++) {// loops through the cart
            if (cart[i].equals(itemToRemove)){//checks if element equals string
                variable++;

            }
        }

        if (variable == 0) {
            System.out.println("WARNING: " + itemToRemove
                    + " not found in the shopping cart.");
            return count;
        }
        for (int i = 0; count > i; i++) {
            if (cart[i].equals(itemToRemove)) {// checks for the itemToRemove
                cart[i] = cart[count - 1];// swaps the itemToRemove with the
                                            // last element
                cart[count - 1] = null;// makes last element null
                count--;
                return count;
            }
            // returns the original number of items
        }
        return count;
    }

    /**
	 * finds the price of each present item in the cart and adds it to the 
	 * sub total price
	 * 
	 * @param cart shopping cart
	 * @param count number of items within the cart before method is called
	 * @return the total value (cost) of the cart without tax in $ (double) 
	 */

    public static double getSubTotalPrice(String[] cart, int count) {
        double subTotalPrice = 0;// intializes subTotalPrice
        for (int i = 0; count > i; i++) {// loops through the shopping cart
            for (int j = 0; MARKET_ITEMS.length > j; j++) {
                    //loops through the market_items arrya
                if (cart[i].equals(MARKET_ITEMS[j][0])) {// finds the item
                    String price = MARKET_ITEMS[j][1].substring(1,
                            MARKET_ITEMS[j][1].length());
                    subTotalPrice = subTotalPrice + Double.parseDouble(price); 
                    //adds price of item to subTotalPrice
                }
            }
        }
        return subTotalPrice;
    }

    /**
	 * prints the Market catalog (item identifiers, description, and unit
	 * prices)
	 * 
	 * @print the first two formatting lines, then the index number with its 
	 * correlating item name and price
	 */

    public static void printMarketCatalog() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Item id"+"\t\t"+"Description"+"    \t "+"Price");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        for (int i = 0; i < MARKET_ITEMS.length; i++) {
            System.out.println(i + "\t\t" + MARKET_ITEMS[i][0] + "    \t "
                    + MARKET_ITEMS[i][1]);
            // print name of item and price with correct formatting
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    }

    /**
	 * displays the cart content (items separated by commas)
	 * 
	 * @param cart shopping cart
	 * @param count number of items present within the cart before method called
	 * @print the cart content and print new line after 
	 */

    public static void displayCartContent(String[] cart, int count) {
        System.out.print("Cart Content: ");
        for (int i = 0; i < count; i++) {// iterate through
            System.out.print(cart[i] + ", ");// print item name with comma
        }
        System.out.println("");
    }

    /**
	 * prints the command prompt every time it is called
	 * 
	 * @print command prompt 
	 */

    public static void printCommandPrompt() {
        System.out.println("\nCOMMAND MENU:\n"
            + " [P] print the market catalog\n"
            + " [A <index>] add one occurrence of an item to the cart given "
            + "its identifier\n"
            + " [C] checkout\n" + " [D] display the cart content\n"
            + " [O <index>] number of occurrences of an item in the cart given "
            + "its identifier\n"
            + " [R <index>] remove one occurrence of an item from the cart "
            + "given its identifier\n"
            + " [Q]uit the application\n");
    }
    /**
     * adds all the above functions and runs the shopping cart program
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);// initialize new scanner
        int count = 0;
        String[] cart = new String[CART_CAPACITY];
        System.out.println(
            "=============   Welcome to the Shopping Cart App   =============");
        System.out.println("");
        // printCommandPrompt();
        // System.out.print("ENTER COMMAND: ");
        String response = ""; // initialize new string
        while (!response.equals("q")) {
            printCommandPrompt(); // call the function
            System.out.print("ENTER COMMAND: ");
            response = scnr.next(); // assign response with next char
            response = response.toLowerCase(); // switches to lower case
            if (response.equals("p")) {
                printMarketCatalog();

            } else if (response.equals("a")) {
                int index = scnr.nextInt();
                count = add(index, cart, count);
                //System.out.println(count);

            } else if (response.equals("c")) {
                double beforeTax = getSubTotalPrice(cart, count);
                    //calling for subTotalPrice
                double tax = (getSubTotalPrice(cart, count) * TAX_RATE);
                //calling for tax value
                                                                        
                System.out.print("#items: " + count + " Subtotal: $" + beforeTax
                        + " Tax: $");
                System.out.printf("%.2f", tax);// format the tax value
                System.out.print(" TOTAL: $");
                System.out.printf("%.2f", (beforeTax + tax)); 
                //format the total dollar value
                System.out.println("");

            } else if (response.equals("d")) {
                displayCartContent(cart, count); //calls displayCartContent
            } else if (response.equals("o")) {
                int index = scnr.nextInt();
                System.out.println("The number of occurrences of "
                        + MARKET_ITEMS[index][0] + " (id #" + index + ") is: "
                        + occurrencesOf(index, cart, count));
            } else if (response.equals("r")) {
                int index = scnr.nextInt();
                count = remove(MARKET_ITEMS[index][0], cart, count);

            }
        }
        System.out.println(
            "=============  Thank you for using this App!!!!!  =============");
        scnr.close(); //closing the scanner object
    }
}
