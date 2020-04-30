package lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class lab9 {
	
	static ArrayList<String> items = new ArrayList<>(); //declare arraylist for item
	static ArrayList<Double> prices = new ArrayList<>();//declare arraylist for price
	
	private static Scanner kbd = new Scanner(System.in);
	public static void main(String[]args) {
	
	
		addItemToCart(groceryMap());
		printReciept(items,prices);
		System.out.println("Average price per item in the order was : " + average(prices));
		System.out.println("The index of the lowest cost item is: " + lowestIndex(prices));
		System.out.println("The index of the highest cost item is: " + highestIndex(prices));
	}
	
	//prints the header and menu options in a formatted manner
	private static void printMenu(HashMap<String,Double> grocery) {
		
		System.out.println("Item" + "          " + "Price");
		System.out.println("===================");
		for (Entry<String, Double> entry : grocery.entrySet()) {
			Double value = entry.getValue();
			
			System.out.printf("%-15s%-12s\n", entry.getKey(), value);	
		}	
	}
	
	
	//put grocery items in Map (String whateverTheItem, Double whateverTheCost)
	//return the populated Map
	private static HashMap<String,Double> groceryMap() {
		HashMap<String,Double> groceryItems = new HashMap<>();
		groceryItems.put("apple", 0.99);
		groceryItems.put("banana", 0.59);
		groceryItems.put("cauliflower", 1.59);
		groceryItems.put("dragonfruit", 2.19);
		groceryItems.put("Elderberry", 1.79);
		groceryItems.put("figs", 2.09);
		groceryItems.put("grapefruit", 1.99);
		groceryItems.put("honeydew", 3.49);
		
		return groceryItems;
	}
	//If the item the user inputed exists, then add it to the receipt lists
	//if the item doesn't exist, all the user to loop back through to try again
	private static void addItemToCart(HashMap<String,Double> grocery) {
		do {
		printMenu(groceryMap());
		System.out.println("What item would you like to order?: ");
		String userInput = kbd.next();
		
		/*THIS WOULDVE BEEN EASIER
		String item = userInput;
		Double price = grocery.get(userInput);
		*/
		
		boolean isValid = false;
		for (Entry<String, Double> entry : grocery.entrySet()) {
			if(userInput.equalsIgnoreCase(entry.getKey())){
				System.out.println("Adding " + entry.getKey() + " to cart at $" + entry.getValue());
				items.add(entry.getKey());
				prices.add(entry.getValue());
				isValid = true;
				break;
			}
		}
			if(!isValid){
				System.out.println("Sorry, we don't have those in stock. Try again!");
			}	
	}while(ValidatorHelper.getYesNo(kbd, "Would you like to order anything else?" ));
	}
	
	
	//places the parallel ArrayLists storing the "purchased" items and costs into a Map
	//Loops through the map to print the key (item) and value(cost) in a formated manner
	private static void printReciept(ArrayList<String> items, ArrayList<Double> price) {
		System.out.println("Thank you for your order!\nHere is what you got:");
		HashMap<String, Double> recieptMap = new HashMap<>();
		for (int i = 0; i < items.size(); i++) {
			String key = items.get(i);
			Double value = price.get(i);
			recieptMap.put(key, value);
		}
		
		for (Entry<String, Double> entry : recieptMap.entrySet()) {
			System.out.printf("%-15s%-12s\n", entry.getKey(), entry.getValue());	
		}	
		}
	
	
	//loop through the ArrayList summing the price, then dividing by size of the list
	//returns the average cost
	private static double average(ArrayList<Double> price) {
		double totalCost = 0;
		for (Double prices : price) {
			totalCost += prices;
		}
		System.out.println("\nYour total is: $" + totalCost);
		return totalCost/price.size();
	}
	
	
	
	//finds the index of the lowest price item in the ArrayList
	//returns the index 
	private static int lowestIndex(ArrayList<Double> price) {
		int index;
		double min = 4.0;
		for(Double prices : price) {
			if(prices < min) {
				min = prices;
			}
		}
		index = price.indexOf(min);
		return index;	
	}
	
	//finds the index of the highest price item in the ArrayList
	//returns the index
	private static int highestIndex(ArrayList<Double> price) {
		int index;
		double max = 0;
		for(Double prices : price) {
			if(prices > max) {
				max = prices;
			}
		}
		index = price.indexOf(max);
		return index;	
	}
	}
