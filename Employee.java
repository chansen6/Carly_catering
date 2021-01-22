public abstract class Employee
{

	// employee fields 
	private String employeeID;
	private String employeeLastName;
	private String employeeFirstName;
	protected double employeePay;
	protected String employeeJobTitle;

	//Getters
	public String getEmployeeID()
	{
		return employeeID;
	}

	public String getEmployeeLastName()
	{
		return employeeLastName;
	}

	public String getEmployeeFirstName()
	{
		return employeeFirstName;
	}

	public double getEmployeePay()
	{
		return employeePay;
	}

	public String getEmployeeJobTitle()
	{
		return employeeJobTitle;
	}

	//Setters
	public void setEmployeeID(String newEmployssID)
	{
		this.employeeID = newEmployssID;
	}

	public void setEmployeeLastName(String newEmployeeLastName)
	{
		this.employeeLastName = newEmployeeLastName;
	}

	public void setEmployeeFirstName (String newEmployeeFirstName)
	{
		this.employeeFirstName = newEmployeeFirstName;
	}

	//abstract functions
	public abstract void setEmployeePay (double newEmployeePay);

	public abstract void setEmployeeJobTitle();

}







