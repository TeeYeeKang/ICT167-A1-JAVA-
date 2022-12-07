//Title     : FT MUR T221 ICT167 C – Assignment 1 (Client class)
//Author    : Tee Yee Kang
//Date      : 26/Jun/2021
//File Name : FTC-34315323-Assignment 01
//Purpose  	:This program is to allowed all the users (customers) to enter and 
//			 store their name and coin amount into the system and then 
//    		 perform some different tasks provided by the system.
//			 2 input values required for the MoneyChange objects - String name of customer, int coin amount
//			 coin amount must be between 5-200 and divisible by 5

import java.util.*;

/**
 * @author      TeeYeeKang    yeekang88 @ gmail.com
 * @version     1.1          
 */
public class Client {
	static Scanner input = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		//display student information
		studentInfo();
		
		//ask for user's choice
		//hand code or hard code
		System.out.println("Read user input - 0");
		System.out.println("Hard code input - 1");
		System.out.print("Enter your choice : ");
		int choice = input.nextInt();

		//loop until user entered a valid choice
		while((choice <0) || (choice >1)) {
			System.out.print("Invalid choice !! Enter choice again : ");
			choice = input.nextInt();
		}
		
		//declare MoneyChange array size
		MoneyChange[] changeArrayList = new MoneyChange[50];
		
		if(choice == 0) {
			//hand code
			readValue(changeArrayList);
		}else {
			/**
			 * Hard coded value for MoneyChange class
			 * <p>         
			 */
			changeArrayList = new MoneyChange[9];
			//create and store objects into MoneyChange array
			MoneyChange change01 = new MoneyChange("A", 100);
			changeArrayList[0] = change01;
			MoneyChange change02 = new MoneyChange("B", 55);
			changeArrayList[1] = change02;
			MoneyChange change03 = new MoneyChange("C", 45);
			changeArrayList[2] = change03;
			MoneyChange change04 = new MoneyChange("D", 55);
			changeArrayList[3] = change04;
			MoneyChange change05 = new MoneyChange("E", 15);
			changeArrayList[4] = change05;
			MoneyChange change06 = new MoneyChange("F", 25);
			changeArrayList[5] = change06;
			MoneyChange change07 = new MoneyChange("G", 10);
			changeArrayList[6] = change07;
			MoneyChange change08 = new MoneyChange("I", 60);
			changeArrayList[7] = change08;
			MoneyChange change09 = new MoneyChange("J", 95);
			changeArrayList[8] = change09;
		}
		
		//display all elements in array (object)
		printAllMoneyChangeObject(changeArrayList);
		
		//menu 
		process(changeArrayList);
		
	}//end of main class
	
	
	//student info method
	/**
	* This method is used display the student information      
	** <p>
	* Precondition - Nil.<br>
	* Postcondition - Display student information.
	* </p>
	*/
	public static void studentInfo() {
		System.out.println("Name				: Tee Yee kang" );
		System.out.println("StudentNo			: 34315323" );
		System.out.println("Mode Of Enrolment		: Full Time" );
		System.out.println("Tutor 				: Aaron Yeo" );
		System.out.println("Tutorial Attendence Day		: Friday" );
		System.out.println("Tutorial Attendence Time	: 1030-1230" );
		System.out.println("----------------------------------------------\n" );
	}//end of method
	
	//print all MoneyChange objects by calling display() method
	/**
	* This method is used to display all MoneyChange objects inside MoneyChange array      
	** <p>
	* Precondition - Pass in a MoneyChange array.<br>
	* Postcondition - Display the name and coin amount of all MoneyChange object.
	* </p>
	* @param array An array of type MoneyChange
	*/
	private static void printAllMoneyChangeObject(MoneyChange[] array) {
		System.out.println("\n----------All MoneyChange Objects----------");
		//use for loop to display all objects
		for(int idx=0;idx<array.length;idx++) {
			MoneyChange currentChange = array[idx];
			if(currentChange!=null) {
				currentChange.display();
			}
		}
	}//end of method
	
	//find for same name MoneyChange object and add passed in coin amount 
	//OR create a new MoneyChange object by calling the addNewChangeObject() method
	/**
	* This method is used to add coin amount to existing MoneyChange object or create a new MoneyChange, no null values are allowed.      
	** <p>
	* Precondition - Pass in a MoneyChange array, String name and a coin amount with positive int value.<br>
	* Postcondition - Calling addNewChangeObject method to created new object or updated the coin amount of existing MoneyChange object.
	* </p>
	* @param changeArray An array of type MoneyChange
	* @param nameToAdd Name of String type and to be added into the MoneyChange array
	* @param amountToAdd Coin amount with int value and to be added into the MoneyChange array
	*/
	public static void addNewChange(MoneyChange[] changeArray, String nameToAdd,int amountToAdd) {
				
		boolean found = false;
						
		for(int i=0;i<changeArray.length;i++) {
			MoneyChange currentChange = changeArray[i];
			if(currentChange!=null) {
				//get the existing name of MoneyChange object
				String currentName = currentChange.getName();
				//compare is name to add is same as existing name
				if(currentName.equals(nameToAdd)) {
					currentChange.addCoinChangeAmount(amountToAdd); //add the coin amount is same name
					found = true;
				}
			}
		}
				
		if(found) {
			System.out.println("Amount added to the name");
		}else {
			//if not same name found, create a new MoneyChange object
			MoneyChange newChangeObject = new MoneyChange(nameToAdd, amountToAdd);
			addNewMoneyChangeObject(changeArray,newChangeObject);
		}
	}//end of method
	
	//create and store new MoneyChange object into available array slot
	/**
	* A private method to create a new MoneyChange array and store it into the MoneyChange array.      
	** <p>
	* Precondition - Pass in a MoneyChange array and a MoneyChange object.<br>
	* Postcondition - For loop will search through the array and find for an empty slot to store new MomeyChange object.<br>
	* 				   After stored, found become true. 
	* </p>
	* @param changeArray An array of type MoneyChange
	* @param nameToAdd Name of String type and to be added into the MoneyChange array
	* @param amountToAdd Coin amount with int value and to be added into the MoneyChange array
	*/
	private static void addNewMoneyChangeObject(MoneyChange[] changeArray, MoneyChange change) {
				
		boolean found = false;
				
		//look for a null slot and add the new change object in
		for(int i=0;i<changeArray.length;i++) {
			MoneyChange currentChange = changeArray[i];
			if(currentChange==null) {
				changeArray[i] = change;
				found = true;
				break;
			}
		}
				
		if(found) {
			System.out.println("New change object created");
		}else {
			System.out.println("No empty slots found");
		}
	}//end of method
	
	//read values of MoneyChange object from user
	//keep asking and stop by user's option (Y/N)
	/**
	* This method is used to read values from user in order to create MoneyChange object              
	** <p>
	* Precondition - Pass in an array of type of MoneyChange.<br>
	* Postcondition - All existing or newly created MoneyChange objects will be store into the MoneyChange array.<br>
	* </p>
	* @param array An array of type MoneyChange
	*/
	public static void readValue(MoneyChange[] array) {
		
		System.out.println("\nEnter name and coin amount to create at least 9 MoneyChange object ");
		
		for(int idx = 0; idx < array.length; idx ++) {
			//prompt for name
			System.out.print("\nPlease enter the name of the person: ");
			String name = input.next();
			
			//prompt for coin amount
			System.out.print("Please enter the coin value for the person:");
			int coin = input.nextInt();
				
			//check for valid coin amount
			//prompt for coin amount again if not valid
			while(!MoneyChange.checkCoinValue(coin)) {
				System.out.println("\nThe coin value must be between 5-200 and divisible by 5");
				System.out.print("Please enter the coin value again: ");
				coin = input.nextInt();
			}
			//create object
			addNewChange(array, name, coin);
			
			//ask user option to continue or stop executing
			System.out.print("\nDo you want to continue ?? Y/N : ");
			char opt = input.next().charAt(0);
			opt = Character.toUpperCase(opt);
			
			if (opt == 'N'){
				System.out.println("You have stop reading object !!");
				break;
			}
		}//end of for loop
	}//end of method	
	
	//option 1
	//Enter a name and display change to be given for each denomination
	//prompt user enter a name to display
	/**
	* This method is for option 1 - Ask user for the name to display coin denominaiton.      
	** <p>
	* Precondition - Nil<br>
	* Postcondition - Return the name enter by user. 
	* </p>
	* @return name Return the name with String type entered by user
	*/
	public static String getNameToDisplay() {
		String name = "";
		System.out.print("\nEnter a name to display his/her coin amount: ");
		name = input.next();
			
		return name;
		
	}//end of method
		
	//find the index of name entered by user
	/**
	* This method is for option 1 - Find the index of name entered by user previously.      
	** <p>
	* Precondition - Pass in a MoneyChange array<br>
	* Postcondition - Search for same name and return the index of the name. If no same found return the initial index value.
	* </p>
	* @param array An array with type MoneyChange
	* @return index Return the index of name entered by user or -1 is no same name found
	*/
	public static int getIndexOfName(MoneyChange[] array) {
		
		int index = -1;
		
		//get the name entered by user 
		String name01 = getNameToDisplay();
		
		//find for same name
		for(int idx = 0; idx < array.length; idx++) { 
			if(array[idx] != null) {
				if(name01.equalsIgnoreCase(array[idx].getName())) { //ignore case
					index = idx;
					break;
				}
			}
		}
		return index;
		
	}//end of method
		
	//option 1 - display the coin change denomination for particular name
	/**
	* This method is the controller of getNameToDisplay and getIndexOfName methods in order to find the coin denomination of particular name.      
	** <p>
	* Precondition - Pass in a MoneyChange array<br>
	* Postcondition - Display the coin denomination of particular name of MoneyChange object
	* </p>
	* @param array An array of type MoneyChange.
	*/
	public static void option1(MoneyChange[] array) {
		
		//get index of name
		int idx = getIndexOfName(array);
		
		if(idx < 0) {
			System.out.println("\nName not found!!");
		}else {
			MoneyChange.displayChange(array[idx]);
		}
	}//end of method
		
	//bubble sort array - ascending order
	/**
	* This method is to sort the passed in array in ascending order by using bubbleSort method.     
	** <p>
	* Precondition - Pass in a MoneyChange array<br>
	* Postcondition - The passed in array has been sorted in ascending order.
	* </p>
	* @param array An array of type MoneyChange.
	*/
	public static void bubbleSort(MoneyChange[] array){
		
		boolean swap = true;
		
		while (swap) {
			swap = false;
			for (int i = 1; i < array.length; i++) {
				if(array[i] !=null) {
					if (array[i - 1].getCoinAmount() > array[i].getCoinAmount()) {
						// swap the numbers
						MoneyChange temp = array[i - 1];
						array[i - 1] = array[i];
						array[i] = temp;
						swap = true;	
					}
				}
			}
		}
	}//end of method
	
	//option 2 - find smallest coin amount and display its coin denomination
	/**
	* This method is for option 2 - display the smallest coin amount among the MoneyChange objects.     
	** <p>
	* Precondition - Pass in a MoneyChange array<br>
	* Postcondition - Display the coin denomination with smallest coin amount.
	* </p>
	* @param array An array of type MoneyChange.
	*/
	public static void findSmallest(MoneyChange[] array) {
		
		//sort array in ascending order first
		bubbleSort(array);
		
		//after sorted, index 0 will be the smallest
		System.out.println("\nCustomer " + array[0].getName() + " has the smallest coin amount");
		System.out.println("The smallest coin amount is : " + array[0].getCoinAmount());
		//display coin denomination
		MoneyChange.displayChange(array[0]);	
		
	}//end of method
	
	//option 3 - find largest coin amount and display its coin denomination
	/**
	* This method is for option 3 - find and display the largest coin amount among the MoneyChange objects.     
	** <p>
	* Precondition - Pass in a MoneyChange array<br>
	* Postcondition - Find and display the coin denomination with largest coin amount.
	* </p>
	* @param array An array of type MoneyChange.
	*/
	public static void findLargest(MoneyChange[] array) {
		
		//sort array in ascending order
		bubbleSort(array);
		
		//set largest to 0 first
		int maxIndex = 0;
		
		//search for largest
		for(int idx = 1; idx<array.length;idx++) {
			if(array[idx]!=null) {
				if(array[maxIndex].getCoinAmount() < array[idx].getCoinAmount()) {
					maxIndex = idx;
				}
			}
		}
		
		//display output
		System.out.println("\nCustomer " + array[maxIndex].getName() + " has the largest coin amount");
		System.out.println("The largest coin amount is : " + array[maxIndex].getCoinAmount());
		MoneyChange.displayChange(array[maxIndex]);	
		
	}//end of method
	
	//option 4 - find largest coin denomination
	/**
	* This method is to find and display the largest coin denomination    
	** <p>
	* Precondition - Pass in MoneyChange array<br>
	* Postcondition - Calculate all total of all coin denomination and display the largest coin denomination
	* </p>
	* @param array An array with type MoneyChange
	*/
	public static void getMaxDenomination(MoneyChange[] array) {
		
		//declare array size
		//change is to store getChange()
		//total is to store the running total coin denomination
		int[] change = new int[6];
		int[] total = new int[6];
		
		for(int outer=0; outer<array.length; outer++) {
			if(array[outer] != null) {
				change = array[outer].getChange();
				//store running total coin denomination	 
				for(int inner=0; inner < 6; inner++) {
					total[inner]+=change[inner];
				}
			}
		}
		
		//find largest
		//set max to array index 0 first
		int maxIndex = 0;
		//find index of largest coin denomination
		for(int idx=1; idx<total.length;idx++) {
			if(total[maxIndex] < total[idx]) {
				maxIndex = idx;
			}
		}
		
		//display output for largest coin denomination 
		for(int idx=0;idx<total.length;idx++) {
			//if there are more than 1 largest coin denomination
			if(total[maxIndex] == total[idx]) {
				maxIndex = idx;
				//display output
				largestCoinOutput(total, maxIndex);				
			}
		}
		
	}//end of method
	
	//output for each largest coin denomination
	/**
	* This method is for the output/description for largest coin denomination   
	** <p>
	* Precondition - Pass in an int type array and the index (int type) of largest coin denomination array<br>
	* Postcondition - Print out particular output of largest coin denomination base on passed in arguments
	* </p>
	* @param total An array of int type
	* @param maxIndex The index (int type) of largest coin denomination array
	*/
	public static void largestCoinOutput(int[] total, int maxIndex) {
		
		//display output
		//switch the index-maxIndex
		System.out.println("\nThe largest number of coin denomination is:");
		switch(maxIndex) {
			case 0: System.out.println("2 dollar");
					System.out.println("The total number of 2 dollar is: " + total[0]);
					break;
			case 1: System.out.println("1 dollar");
					System.out.println("The total number of 1 dollar is: " + total[1]);
					break;
			case 2: System.out.println("50 cent");
					System.out.println("The total number of 50 cent is: " + total[2]);
					break;
			case 3: System.out.println("20 cent");
					System.out.println("The total number of 20 cent is: " + total[3]);
					break;
			case 4: System.out.println("10 cent");
					System.out.println("The total number of 10 cent is: " + total[4]);
					break;
			case 5: System.out.println("5 cent");
					System.out.println("The total number of 5 cent is: " + total[5]);
					break;
		}
	}//end of method
	
	//display menu and prompt for user choice
	/**
	* This method is to display the menu and ask for user's choice.     
	** <p>
	* Precondition - Nil<br>
	* Postcondition - Prompt user to enter a choice and return user's choice.
	* </p>
	* @return Return user's choice
	* @throws Exception Choice must be numeric value and between 1-5
	*/
	public static int menu() throws Exception{
		System.out.println("\n---------< Menu ----------");
		System.out.println("[1] - Enter a name and display change to be given for each denomination");
		System.out.println("[2] - Find the name with the smallest amount and display change to be \n      given for each denomination");
		System.out.println("[3] - Find the name with the largest amount and display change to be \n      given for each denomination");
		System.out.println("[4] - Calculate and display the largest number of coin denomination, \n      and the total number of the coin");
		System.out.println("[5] - Exit program! ");
		System.out.print("\nEnter your choice : ");
		int choice = Integer.parseInt(input.next());
		return choice;
		
	}//end of method
	
	//Main controller that call all 4 options/tasks base on user's choice
	/**
	* This method is the main controller which call and execute method/task according to user's choice     
	** <p>
	* Precondition - Pass in MoneyChange array<br>
	* Postcondition - Perform the task/method selected by user.
	* </p>
	* @param array An array with type MoneyChange
	*/
	public static void process(MoneyChange[] array){
		int option = 0;
		do
		{
			try{
				option = menu();
				switch(option)
				{
				case 1 : option1(array);
						 break;
				case 2 : findSmallest(array);
						 break;
				case 3 : findLargest(array);
						 break;
				case 4 : getMaxDenomination(array);
						 break;
				case 5 : System.out.println("\nThank you Bye!!");
						 break;
				default : System.out.println("\nInvalid option!");
				}
			}catch (Exception e) //if user enter non-numerical value
			{
				System.out.println("\nUse a numerical value !");
			}
		}while (option != 5);
		
	}//end of method
	
}//end of client class



