public class DinnerEvent extends Event
{
	//int variables for choice
	private int entree;
	private int sideOne;
	private int sideTwo;
	private int dessert;


	// fields for linking choice and array
	private String entreeString;
	private String sideOneString;
	private String sideTwoString;
	private String dessertString;

	//arrays with the choices 
	private final String entreeArray[]={"steak", "chicken", "fish"};
	private final String sideArray[]={"mashed potatoes", "corn", "salad"};
	private final String dessertArray[]={"cake", "brownie", "ice cream"};

	//array for employees
	Employee workers[] = new Employee[15];

	//constructor with 5 arguments per instructions
	public DinnerEvent(String eventNum, int numGuest, int entreeChoice, int sideOneChoice, int sideTwoChoice, int dessertChoice)
	{
		//calls constructor from super class
		super(eventNum, numGuest);

		//sets choices by the arguments
		setEntree(entreeChoice);
		setSideOne(sideOneChoice);
		setSideTwo(sideTwoChoice);
		setDessert(dessertChoice);	

		// uses the int choices to set the strings from the arrays
		setStrings();

	}


	//getter and setters
	public void setEntree(int entreeChoice)
	{
		this.entree = entreeChoice;
	}

	public int getEntree()
	{
		return this.entree;

	}

	public void setSideOne(int sideOneChoice)
	{
		this.sideOne = sideOneChoice;
	}

	public int getSideOne()
	{
		return this.sideOne;

	}

	public void setSideTwo(int sideTwoChoice)
	{
		this.sideTwo = sideTwoChoice;
	}

	public int getSideTwo()
	{
		return this.sideTwo;

	}

	public void setDessert(int dessertChoice)
	{
		this.dessert = dessertChoice;
	}

	public int getDessert()
	{
		return this.dessert;

	}

	//function that sets the string based on choice from the appropriate array
	public void setStrings()
	{
		this.entreeString = entreeArray[entree-1];
		this.sideOneString = sideArray[sideOne-1];
		this.sideTwoString = sideArray[sideTwo-1];
		this.dessertString = dessertArray[dessert-1];	    
	}

	// displays the objects menu
	public  String getMenu()

	{       
		return "1) "+ entreeString + "\n 2) "+  sideOneString+ " \n 3) "+  sideTwoString +  "\n 4) " +  dessertString +"\n";

	}

	//gets workers
	public Employee[] getWorkers()
	{
		return workers;
	}

	//sets workers
	public void setWorkers ( Employee[] staff)
	{
		this.workers = staff;
	}
}	