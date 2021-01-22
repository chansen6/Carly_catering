import java.util.Scanner;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
public class StaffDinnerEventAndCreateFile
{
	public static void main(String[] args)
	{
		// variables to figure out workers
		int waitstaff;
		int bartender;

		//create dinner event object array with parameters
		DinnerEvent[] event = new DinnerEvent[3];
		
		for (int i = 0; i < event.length; i++) {
			// array to pass to dinner event class
			Employee[] workers= new Employee[15];
			
			event[i] = new DinnerEvent(userEventNumber(),userGuests(),userEntree(),userSideOne(),userSideTwo(),userDessert());

			System.out.println("Enter information for Event\n");

			//set event fields based on instructions		
			event[i].setContactPhone(userPhone());

			//sets number of waitstaff
			waitstaff = event[i].getGuests()/10 +1;

			//set counter to keep adding to array
			int counter = 0;
			for (; counter < waitstaff; counter++)
			{
				workers[counter] = userWaitstaff();//get waitstaff
			}
			
			//set number of bartenders
			bartender = event[i].getGuests()/25 +1;

			for (; counter < waitstaff + bartender; counter++)
			{
				workers[counter] = userBartender();// get bartender
			}
			workers[counter] = userCoordinator();// get coordinator

			event[i].setWorkers(workers); // pass array to object	
			counter++;

			displayDetails(event[i], counter); // display details

		}
		// call toFile function to write event info array to file
		toFile(event);
		
	}


	//changed name of functions from get to user to avoid confusion of 
	//getters from event class since users is providing info

	//gets event type from user
	public static int userEventType()
	{
		int num;
		Scanner input = new Scanner(System.in);

		System.out.print("Enter event Type >> ");
		num = input.nextInt();

		return num;
	}

	//gets event number from user
	public static String userEventNumber()
	{
		String num;
		Scanner input = new Scanner(System.in);

		System.out.print("Enter event number >> ");
		num = input.nextLine();

		return num;
	}

	// gets number of guest from user
	public static int userGuests()
	{
		int guests = 0;
		final int MIN_GUESTS = 5; // min guest is 5
		final int MAX_GUESTS = 100; // max guest is 100
		boolean error;// flag for error in data type entry
		Scanner input = new Scanner(System.in);

		// do while loop to check if error is present
		do
		{
			error = false;// sets flag to false, there is no error yet

			//try catch statement to handle error if a non integer was entered
			try 
			{			
				//asks users for number of guests
				System.out.print("Enter number of guests >> ");
				guests = input.nextInt();

				// loops and asks user until guest is a valid number
				while (guests < MIN_GUESTS || guests > MAX_GUESTS)
				{
					System.out.println("The number of guests must be between " +
							MIN_GUESTS + " and " + MAX_GUESTS);
					System.out.print("Please renter >> ");
					guests = input.nextInt();
				}
				input.nextLine();
			} 

			catch (Exception e) {
				// TODO: handle exception
				// prints out error that integers were not entered
				System.out.println("ERROR: PLEASE ONLY ENTER INTEGER(S)");

				//sets flag to true since error was detected and will need to loop again
				error = true;

				//waits for new input from user 
				input.nextLine();
			}
		}
		while(error); // loops if error has been detected

		return guests; // returns number of guests
	}

	//get users entree for each object
	public static int userEntree()
	{
		int choice = 0;
		final int MIN_CHOICE = 1;// min choice is 1
		final int MAX_CHOICE = 3;// max choice is 3
		boolean error;// flag for error in data type entry
		Scanner input = new Scanner(System.in);

		// do while loop to check if error is present
		do
		{
			error = false;// sets flag to false, there is no error yet

			//try catch statement to handle error if a non integer was entered
			try 
			{			
				//asks users for entree
				System.out.print("Please select an entree >> ");
				choice = input.nextInt();

				// loops and asks user until entree is a valid number
				while (choice < MIN_CHOICE || choice > MAX_CHOICE)
				{
					System.out.println("Please only enter between " +
							MIN_CHOICE + " and " + MAX_CHOICE);
					System.out.print("Please renter >> ");
					choice = input.nextInt();
				}
				input.nextLine();
			} 

			catch (Exception e) {
				// TODO: handle exception
				// prints out error that integers were not entered
				System.out.println("ERROR: PLEASE ONLY ENTER INTEGER(S)");

				//sets flag to true since error was detected and will need to loop again
				error = true;

				//waits for new input from user 
				input.nextLine();
			}
		}
		while(error); // loops if error has been detected

		return choice;
	}

	//get users sideone for each object
	public static int userSideOne()
	{
		int choice = 0;
		final int MIN_CHOICE = 1;// min choice is 1
		final int MAX_CHOICE = 3;// max choice is 3
		boolean error;// flag for error in data type entry
		Scanner input = new Scanner(System.in);

		// do while loop to check if error is present
		do
		{
			error = false;// sets flag to false, there is no error yet

			//try catch statement to handle error if a non integer was entered
			try 
			{			
				//asks users for side one
				System.out.print("Please select side one >> ");
				choice = input.nextInt();

				// loops and asks user until side is a valid number
				while (choice < MIN_CHOICE || choice > MAX_CHOICE)
				{
					System.out.println("Please only enter between " +
							MIN_CHOICE + " and " + MAX_CHOICE);
					System.out.print("Please renter >> ");
					choice = input.nextInt();
				}
				input.nextLine();
			} 

			catch (Exception e) {
				// TODO: handle exception
				// prints out error that integers were not entered
				System.out.println("ERROR: PLEASE ONLY ENTER INTEGER(S)");

				//sets flag to true since error was detected and will need to loop again
				error = true;

				//waits for new input from user 
				input.nextLine();
			}
		}
		while(error); // loops if error has been detected

		return choice;
	}

	//get users sidetwo for each object
	public static int userSideTwo()
	{
		int choice = 0;
		final int MIN_CHOICE = 1;// min choice is 1
		final int MAX_CHOICE = 3;// max choice is 3
		boolean error;// flag for error in data type entry
		Scanner input = new Scanner(System.in);

		// do while loop to check if error is present
		do
		{
			error = false;// sets flag to false, there is no error yet

			//try catch statement to handle error if a non integer was entered
			try 
			{			
				//asks users for side two
				System.out.print("Please select side two >> ");
				choice = input.nextInt();

				// loops and asks user until side is a valid number
				while (choice < MIN_CHOICE || choice > MAX_CHOICE)
				{
					System.out.println("Please only enter between " +
							MIN_CHOICE + " and " + MAX_CHOICE);
					System.out.print("Please renter >> ");
					choice = input.nextInt();
				}
				input.nextLine();
			} 

			catch (Exception e) {
				// TODO: handle exception
				// prints out error that integers were not entered
				System.out.println("ERROR: PLEASE ONLY ENTER INTEGER(S)");

				//sets flag to true since error was detected and will need to loop again
				error = true;

				//waits for new input from user 
				input.nextLine();
			}
		}
		while(error); // loops if error has been detected

		return choice;
	}

	// get users dessert for dessert
	public static int userDessert()
	{
		int choice = 0;
		final int MIN_CHOICE = 1;// min choice is 1
		final int MAX_CHOICE = 3;// max choice is 3
		boolean error;// flag for error in data type entry
		Scanner input = new Scanner(System.in);

		// do while loop to check if error is present
		do
		{
			error = false;// sets flag to false, there is no error yet

			//try catch statement to handle error if a non integer was entered
			try 
			{			
				//asks users for dessert
				System.out.print("Please select a dessert >> ");
				choice = input.nextInt();

				// loops and asks user until dessert is a valid number
				while (choice < MIN_CHOICE || choice > MAX_CHOICE)
				{
					System.out.println("Please only enter between " +
							MIN_CHOICE + " and " + MAX_CHOICE);
					System.out.print("Please renter >> ");
					choice = input.nextInt();
				}
				input.nextLine();
			} 

			catch (Exception e) {
				// TODO: handle exception
				// prints out error that integers were not entered
				System.out.println("ERROR: PLEASE ONLY ENTER INTEGER(S)");

				//sets flag to true since error was detected and will need to loop again
				error = true;

				//waits for new input from user 
				input.nextLine();
			}
		}
		while(error); // loops if error has been detected

		return choice;
	}

	//gets user phone number
	public static String userPhone()
	{
		String phone;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter contact phone number >> ");
		phone = input.nextLine();
		return phone;
	}

	// get waitstaff info from user
	public static Waitstaff userWaitstaff()
	{
		Scanner input = new Scanner(System.in);
		Waitstaff waitstaff= new Waitstaff();
		boolean error; //flag for looping error handling

		// enter ID
		System.out.print("Enter employeeID for waitstaff >> ");
		waitstaff.setEmployeeID(input.nextLine());

		//enter first name
		System.out.print("Enter first name >> ");
		waitstaff.setEmployeeFirstName(input.nextLine());

		//enter last name
		System.out.print("Enter last name >> ");
		waitstaff.setEmployeeLastName(input.nextLine());
		
		//enter pay
		do {
			error = false;
			System.out.print("Enter pay >> ");
			try {
				waitstaff.setEmployeePay(input.nextDouble());

			} catch (Exception e) {
				// prints out error that integers were not entered
				System.out.println("ERROR: PLEASE ONLY ENTER NUMBERS");
				error = true;
				input.nextLine();
			}
		}while(error);
		// sets job title per class function
		waitstaff.setEmployeeJobTitle();

		//returns object of waitstaff with info populated by user
		return waitstaff;
	}

	//get Bartender information from user
	public static Bartender userBartender()
	{
		Scanner input = new Scanner(System.in);
		Bartender bartender= new Bartender();
		boolean error; // flag for looping error handling

		//enter ID
		System.out.print("Enter employeeID for bartender >> ");
		bartender.setEmployeeID(input.nextLine());


		// enter First name
		System.out.print("Enter first name >> ");
		bartender.setEmployeeFirstName(input.nextLine());


		//enter last name
		System.out.print("Enter last name >> ");
		bartender.setEmployeeLastName(input.nextLine());

		//enter pay
		do {
			error = false;
			System.out.print("Enter pay >> ");
			try {
				bartender.setEmployeePay(input.nextDouble());

			} catch (Exception e) {
				// prints out error that integers were not entered
				System.out.println("ERROR: PLEASE ONLY ENTER NUMBERS");
				error = true;
				input.nextLine();
			}
		}while(error);


		//set job title per class function
		bartender.setEmployeeJobTitle();

		//returns object of bartender with info populated by user
		return bartender;
	}

	//get Coordinator information from user
	public static Coordinator userCoordinator()
	{
		Scanner input = new Scanner(System.in);
		Coordinator coordinator= new Coordinator();
		boolean error; //flag for looping error handling

		//enter ID
		System.out.print("Enter employeeID for coordinator >> ");
		coordinator.setEmployeeID(input.nextLine());

		//Enter first name
		System.out.print("Enter first name >> ");
		coordinator.setEmployeeFirstName(input.nextLine());

		//enter last name
		System.out.print("Enter last name >> ");
		coordinator.setEmployeeLastName(input.nextLine());

		//enter pay
		do {
			error = false;
			System.out.print("Enter pay >> ");
			try {
				coordinator.setEmployeePay(input.nextDouble());

			} catch (Exception e) {
				// prints out error that integers were not entered
				System.out.println("ERROR: PLEASE ONLY ENTER NUMBERS");
				error = true;
				input.nextLine();
			}
		}while(error);
		//sets job title per class function
		coordinator.setEmployeeJobTitle();

		//returns object of coordinator with info populated by user
		return coordinator;
	}


	// display details with staff info
	public static void displayDetails(DinnerEvent e, int count)
	{
		// creates worker array to  from dinner event object (e)	
		Employee[] workers = new Employee[15];

		// populate array from dinner event object
		workers = e.getWorkers();

		// prints event info
		System.out.println("\nEvent #" + e.getEventNumber());
		System.out.println("The price for an event with " + e.getGuests() +
				" guests at $" + e.getPricePerGuest() + " per guest is $" + e.getPriceForEvent());

		// prints contact info
		System.out.println("Contact phone number is: " + e.getContactPhone());

		// shows the menu choices
		System.out.println("The menu includes " + e.getMenu());

		// Iterate through array and print out information
		System.out.println("\nThe staff includes:");
		for(int i = 0; i < count; i++)
			System.out.println(workers[i].getEmployeeID() + " " + workers[i].getEmployeeFirstName() + " " + workers[i].getEmployeeLastName() + " " + workers[i].getEmployeePay() + " " + workers[i].getEmployeeJobTitle() );
		
		//white space in output
		System.out.println();
	}
	
	//function to export data to text file to a user defined location and name
	public static void toFile(DinnerEvent[] event)
	{
		// get path and file name from user, since if program runs another computer path may not exist.
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter File Location and Name: ");
		String userPath = input.nextLine();
		
		// set file path from user
		Path file = Paths.get(userPath);
		
		// variables for file output
		OutputStream output;
		BufferedWriter writer;
		
		// variables for formating the file
		String header = "Event Data: \n";
		String cols = "Event Number, Event Type, Number of Guests, Price of Event \n";
		String store;
		String comma = ", ";
		
		//try catch block to see if file can be created and written to. If not throw error then display Java error to diagnose issue.
		try
		{
			// create file and writer
			output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
			writer = new BufferedWriter(new OutputStreamWriter(output));
			
			//write header and column info for file
			writer.write(header, 0, header.length());
			writer.write(cols, 0, cols.length());
			
					
			//loop through event array and write selected data to file
			for (int i = 0; i < event.length; i++)			
			{
				// create string from event object array to store into file
				store = event[i].getEventNumber() + comma + event[i].getEventType() + comma + event[i].getGuests() + comma + "$" + event[i].getPriceForEvent();
				
				//write string to file
				writer.write(store, 0, store.length());
				
				//make new line for next array element
				writer.newLine();							
			}
			
			//close writer and output
			writer.close();
			output.close();
						
		} catch (Exception e) 
		{
			// TODO: handle exception			
			System.out.println("ERROR: " + e);
		}		
		
	}
}
