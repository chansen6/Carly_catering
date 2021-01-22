import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.FlowLayout;

//extend JFrame class to inherit needed traits for frame
//implement listeners to update information based on user input
public class JCarlysCatering extends JFrame implements ItemListener, ActionListener {
	
	//variable for price per guest
	final int PRICE_PER_GUEST = 35;

	//create variable for price
	double price = 0;

	//variable to count number of selected options
	int numSelected = 0;

	//string variables for manipulating need output
	String mainCourse = "";
	String sides = "";
	String dessert = "";
	String output;

	//create flow layout for the frame
	FlowLayout layout = new FlowLayout();

	//create text field for the guests
	JTextField numberOfGuests = new JTextField(10);
	
	//create button
	JButton button = new JButton("Submit");

	//create labels for the window
	JLabel title = new JLabel("Welcome to Carly's Cattering!");	

	JLabel guestsLabel = new JLabel("Please Enter Number of Guests:");
	JLabel mainCourseLabel = new JLabel("Select a Main Course Options:");
	JLabel sideLabel = new JLabel("Select Upto Two Side Dish Options:");
	JLabel dessertLabel= new JLabel("Select a Dessert Option:");
	JLabel total = new JLabel("Total = $0");
	
	//Create check boxes for the main course choices and set to false, to be unchecked when program is initially ran
	JCheckBox filet = new JCheckBox("Filet Mignon",false);
	JCheckBox chicken = new JCheckBox("Chicken Cordon Bleu",false);
	JCheckBox salmon = new JCheckBox("Smoked Salmon",false);
	JCheckBox duck = new JCheckBox("Peking Duck",false);

	//create check boxes for the side dishes and set to false, to be unchecked when the program is initially ran
	JCheckBox salad = new JCheckBox("Salad",false);
	JCheckBox corn = new JCheckBox("Corn",false);
	JCheckBox potato = new JCheckBox("Mashed Potato",false);
	JCheckBox rice = new JCheckBox("Rice",false);

	//create check boxes for the dessert choices and set to false, to be unchecked when the program is initially ran	
	JCheckBox cake = new JCheckBox("Red Velvet Cake",false);
	JCheckBox brownie = new JCheckBox("Brownie",false);
	JCheckBox icecream = new JCheckBox("Icecream",false);

	//Font object to change font of title
	Font font = new Font("Calibri", Font.BOLD, 40);
	
	//constructor
	public JCarlysCatering(){

		//use super class constructor and pass text for window name
		super("Catering Menu");

		//set close options and layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(layout);
		
		//create button group since only one can be selected for the main courses and desserts and add check boxes to each group
		ButtonGroup mainCoursesGroup = new ButtonGroup();

		mainCoursesGroup.add(filet);
		mainCoursesGroup.add(chicken);
		mainCoursesGroup.add(salmon);
		mainCoursesGroup.add(duck);

		ButtonGroup dessertGroup = new ButtonGroup();

		dessertGroup.add(cake);
		dessertGroup.add(brownie);
		dessertGroup.add(icecream);

		//add title label and change font
		add(title);
		title.setFont(font);
		
		//add guest label and text field
		add(guestsLabel);
		add(numberOfGuests);
		
		//add button
		add(button);

		//add main course label and check boxes
		add(mainCourseLabel);
		add(filet);
		add(chicken);
		add(salmon);
		add(duck);

		//add side label and check boxes
		add(sideLabel);
		add(salad);
		add(corn);
		add(potato);
		add(rice);

		//add dessert label and check boxes
		add(dessertLabel);
		add(cake);
		add(brownie);
		add(icecream);
		
		//add labels for total and menu
		add(total);

		//add listeners for text field, button and check boxes
		numberOfGuests.addActionListener(this);
		button.addActionListener(this);
		filet.addItemListener(this);
		chicken.addItemListener(this);
		salmon.addItemListener(this);
		duck.addItemListener(this);
		salad.addItemListener(this);
		corn.addItemListener(this);
		potato.addItemListener(this);
		rice.addItemListener(this);
		cake.addItemListener(this);
		brownie.addItemListener(this);
		icecream.addItemListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub

		//object to get actions
		Object source = e.getSource();

		//if the action is the number of guests or button press
		if(source == numberOfGuests || source == button){

			//try and catch to ensure only integers are entered
			try{				
				//parse string to int; sets price to be number of guest times the price per guest ($35)
				price = Integer.parseInt(numberOfGuests.getText())*PRICE_PER_GUEST;
			}
			catch(Exception exc)
			{
				//if exception is thrown, non integers are entered set price to 0 and the text field to 0
				price = 0;
				numberOfGuests.setText("0");
			}

			//update output string and set the text label in the form to it
			output = "Total Price = $" + price + " Menu includes: " +  mainCourse + sides  + dessert;
			total.setText(output);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent check){
		// TODO Auto-generated method stub	

		//object to get actions
		Object source = check.getSource();

		//variable to see if the item has been selected or deselected
		int select = check.getStateChange();

		//if an item has been selected handles main course side dishes and dessert, sets strings appropriately
		if(select == ItemEvent.SELECTED) {		

			if(source == filet)
				mainCourse = "Filet Mignon, ";

			else if(source == chicken)
				mainCourse = "Chicken Cordon Blue, ";

			else if(source == salmon)
				mainCourse = "Smoke Salmon, ";

			else if(source == duck)
				mainCourse = "Peking Duck, ";
		}
		if(select == ItemEvent.SELECTED)
		{
			if(source == cake)
				dessert = "Red Velvet Cake ";

			else if(source == brownie)
				dessert = "Brownie ";

			else if(source == icecream)
				dessert = "Icecream ";
		}
		//since you can have two side dishes check to see if any are selected since they are not part of a group.	
		if(source == salad || source == corn || source == potato || source == rice)
		{
			//if selected increment the counter by one else take one way from the counter
			if(select == ItemEvent.SELECTED)
				++numSelected;

			else {
				--numSelected;
				//sets sides string to blank
				sides = "";
			}

			//if the number of sides is equal or less than two set string with selected sides.
			if(numSelected <= 2)

			{
				if(salad.isSelected())
					sides += "Salad, ";

				if(corn.isSelected())
					sides += "Corn, ";

				if(potato.isSelected())
					sides += "Mashed Potatoes, ";

				if(rice.isSelected())
					sides += "Rice, ";
			}

			//if more than two sides are selected uncheck all the side dish boxes
			else
			{
				salad.setSelected(false);
				corn.setSelected(false);
				potato.setSelected(false);
				rice.setSelected(false);
			}
		}

		//try catch to ensure number of guest entry is integers
		try{
			//set price according the number of guests
			price = Integer.parseInt(numberOfGuests.getText())*PRICE_PER_GUEST;
		}

		//if exception is thrown set price and guests to 0

		catch(Exception e)
		{
			price = 0;
			numberOfGuests.setText("0");
		}

		//update output field
		output = "Total = $" + price + " "+"Menu includes: " +  mainCourse +  sides +  dessert;
		total.setText(output);
	}

	//main function to create frame and run program
	public static void main(String[] args)

	{
		//create object Carly's Frame
		JCarlysCatering frame = new JCarlysCatering();

		//set size and visibility		
		frame.setSize(600,300);
		frame.setVisible(true);

	}

}