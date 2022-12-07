//Title     : FT MUR T221 ICT167 C – Assignment 1 (MoneyChange class)
//Author    : Tee Yee Kang
//Date      : 26/Jun/2021
//File Name : FTC-34315323-Assignment 01
//Purpose  	:This program is to allowed all the users (customers) to enter and 
//			 store their name and coin amount into the system and then 
//    		 perform some different tasks provided by the system.
//	   		 2 input values required for the MoneyChange objects - String name of customer, int coin amount
//			 coin amount must be between 5-200 and divisible by 5


import java.util.Scanner;

/**
 * @author      TeeYeeKang    yeekang88 @ gmail.com
 * @version     1.1          
 */

public class MoneyChange {
	static Scanner input = new Scanner(System.in);

	//instance variables
	/**
	 * The String name
	 */
	private String name;
	/**
	 * The int coinChangeAmount
	 */
	private int coinChangeAmount;
	
	//default constructor
	/**
	 * Default Constructor of MoneyChange class                          
	 * <p>
	 * This class is used to represent the default value of String name and int coinChangeAmount 
	 * </p>
	 * Precondition - Nil  <br>
	 * Postcondition - A MoneyChange object is created with the default value of name and coinChangeAmount   
	 */
	public MoneyChange() {
		name = "None";
		coinChangeAmount = 0;
	}
	
	//constructor with 2 parameters
	//created an object with a String name and int coinChangeAmount
	//coinChangeAmount must be valid (true), else set to default value
	/**
	 * Constructor of MoneyChange class                          
	 * <p>
	 * This class is used to represent a String with name and int with coinChangeAmount
	 * </p>
	 * Precondition - The value of name and coinChangeAmount must be a String and positive int value respectively and cannot be null.<br>
	 * Postcondition - A MoneyChange object is created with the value of name and coinChangeAmount
	 * @param  name Name of MoneyChange object
	 * @param  coinChangeAmount Coin amount of MoneyChange object      
	 */
	public MoneyChange(String name, int coinChangeAmount) {
		this.name = name;
		if(checkCoinValue(coinChangeAmount)) {
			this.coinChangeAmount = coinChangeAmount;
		}
	}

	//Accessor method
	/**
	 * This method is used to get the name of the MoneyChange object                        
	 * <p>
	 * Precondition: Name is initialised at the Constructor <br>
	 * Postcondition: The name of the MoneyChange object is returned.
	 * </p>   
	 * @return name Return the MoneyChange object name      
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method is used to set the name of the MoneyChange object                        
	 * <p>
	 * Precondition: Take in a name of MoneyChange object with String value and cannot be null <br>
	 * Postcondition: The name of the MoneyChange object is set.
	 * </p>   
	 * @param name Name of MoneyChange object      
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method is used to get the coinChangeAmount of the MoneyChange object                        
	 * <p>
	 * Precondition: coinChangeAmount is initialised at the Constructor <br>
	 * Postcondition: The coinChangeAmount of the MoneyChange object is returned.
	 * </p>   
	 * @return coinChangeAmount Return the MoneyChange object coin coin change amount      
	 */
	public int getCoinAmount() {
		return coinChangeAmount;
	}
	
	/**
	 * This method is used to set the coinChangeAmount of the MoneyChange object                        
	 * <p>
	 * Precondition: Pass in coinChangeAmount of MoneyChange object with int value between 5-200 and divisible by 5 <br>
	 * Postcondition: The coinChangeAmount of the MoneyChange object is set if it is valid coinChangeAmount else set to 0 (default value).
	 * </p>   
	 * @param coinChangeAmount Coin amount of MoneyChange object      
	 */
	public void setCoinAmount(int coinChangeAmount) {
		//check for valid coinChangeAmount - true
		//if not valid - set to default value 0
		if(checkCoinValue(coinChangeAmount)) {
			this.coinChangeAmount = coinChangeAmount;
		}
	}
	
	//check for valid coin amount - return true if valid else false
	/**
	 * A method to check for valid coin amount of the MoneyChange object entered by user                  
	 ** <p>
	 * Precondition - The passed in coin amount must be between 5 to 200 and divisible by 5. <br>
	 * Postcondition - Boolean valid will become true if coin amount is valid and return the boolean valid.
	 * </p>
	 * @param  amount with int data type
	 * @return valid true if valid coin amount else false
	 */
	public static boolean checkCoinValue(int amount) {
		boolean valid = false;
		
		if((amount >= 5) && (amount <= 200) && (amount % 5 == 0)) {
			valid = true;
		}
		return valid;
	}
	
	//calculate coin change denomination for MoneyChange object
	/**
	 * This method is used to find the coins change denomination of the MoneyChange object and store in an int array                  
	 ** <p>
	 * Precondition - Nil <br>
	 * Postcondition - After completed the calculation, return the changeToReturn array.
	 * </p>
	 * @return changeToReturn-array Return the number of each coin denomination
	 */
	public int[] getChange(){
		//create an array to store the coin denomination
		int[] changeToReturn = new int[6];
		//running ballance
		int tempCoinAmount = coinChangeAmount;
		
		changeToReturn[0] = 0;//no of $2 
		changeToReturn[1] = 0;//no of $1 
		changeToReturn[2] = 0;//no of 50 cents
		changeToReturn[3] = 0;//no of 20 cents
		changeToReturn[4] = 0;//no of 10 cents
		changeToReturn[5] = 0;//no of 5 cents
		
		while((double) tempCoinAmount >= 200) {
			//balace minus 200
			tempCoinAmount -= 200;
			//coin denomination increase by 1 each time
			changeToReturn[0] ++;
		}
	
		while((double) tempCoinAmount >= 100) {
			tempCoinAmount -= 100;
			changeToReturn[1] ++;
		}
		
		while((double) tempCoinAmount >= 50) {
			tempCoinAmount -= 50;
			changeToReturn[2] ++;
		}
		
		while((double) tempCoinAmount >= 20 ) {
			tempCoinAmount -= 20;
			changeToReturn[3] ++;
		}
		
		while((double) tempCoinAmount >= 10) {
			tempCoinAmount -= 10;
			changeToReturn[4] ++;
		}
		
		while((double) tempCoinAmount >= 5) {
			tempCoinAmount -= 5;
			changeToReturn[5] ++;
		}
		return changeToReturn;
	}
	
	//description/output of each coin denomination 
	/**
	 * This method is used to display the description/output of different coin denomination.               
	 ** <p>
	 * Precondition - Take in an array of int type and index with positive int value.<br>
	 * Postcondition - Display the output of each coin denomination including the amount of each coin denomination
	 * </p>
	 * @param array An array with int type
	 * @param index A number with int value
	 */
	public static void coinDenominationDescription(int[] array, int index){
		switch(index) {
		case 0: System.out.println("$2       : " + array[0]);
			break;
		case 1: System.out.println("$1       : " + array[1]);
			break;
		case 2: System.out.println("50 cents : " + array[2]);
			break;
		case 3: System.out.println("20 cents : " + array[3]);
			break;
		case 4: System.out.println("10 cents : " + array[4]);
			break;
		case 5: System.out.println("5 cents  : " + array[5]);
			break;
		}
	}	
	
	//display final output of each coin change denomination
	/**
	 * This method is used as a controller for methods getChange and coinDenominationDescription              
	 ** <p>
	 * Precondition - Passed in a MoneyChange object.<br>
	 * Postcondition - All coin change denomination with a value greater than 0 will be displayed
	 * </p>
	 * @param ch MoneyChange object
	 */
	public static void displayChange(MoneyChange ch) {
		//declare array size
		int	[] change = new int[6];
		//call getChange method and store in array change
		change = ch.getChange();
		System.out.println("========< Change >======== ");
		for(int idx = 0; idx < change.length;idx++) {
			//print the coin denomination with value only
			if(change[idx] > 0) {
				coinDenominationDescription(change, idx);
			}
		}
		System.out.println("========================== ");
	}
		
	//add passed in coin amount to the existing coin amount
	/**
	 * This method is used to add coin amount            
	 ** <p>
	 * Precondition - The coin amount must be positive int value and cannot be null.<br>
	 * Postcondition - The balance increase by the coin amount passed in.
	 * </p>
	 * @param coinChangeAmountToAdd Coin amount with int value
	 */
	public void addCoinChangeAmount(int coinChangeAmountToAdd) {
		this.coinChangeAmount += coinChangeAmountToAdd;
	}
		
	//Display the output of MoneyChange object including name and coinChangeAmount
	/**
	* This method is to display the name and coin amount of MoneyChange object     
	** <p>
	* Precondition - Nil<br>
	* Postcondition - Display output of MoneyChange object.
	* </p>
	*/
	public void display() {
		System.out.println("Name:"+name);
		System.out.println("CoinChangeAmount:"+coinChangeAmount);
	}
	
	//testing purpose
	public static void main(String[] args) {
		//create MoneyChange object
		MoneyChange change01 = new MoneyChange();
		
		Scanner input = new Scanner(System.in);
		char ch = 'Y';
		
		do {
			System.out.print("Please enter the name of the person: ");
			change01.setName(input.next()); //set name
			
			System.out.print("\nPlease enter the coin value for the person(range 5 to 200, multiple of 5):");
			int coin = input.nextInt();//get coin input
			
			//check for valid coin amount
			if(!checkCoinValue(coin)) {
				System.out.println("\nIncorrect coin value. Must be in the range 5 to 200, and multiple of 5.");
			}
			//set coin amount
			change01.setCoinAmount(coin);
			
			//ask user whether to continue or stop
			System.out.println("\nDo you wish to continue (Y/N)");
			char option = input.next().charAt(0);
			ch = Character.toUpperCase(option);
			
			if(ch == 'N') {
				System.out.println("You quit the program! !");
			}
		}while(ch == 'Y');
		
	}//end of main 	
	
	
}//end of MoneyChange class
