public class Bartender extends Employee
{
	//override for abstract class, set job pay $14/hour or less
	@Override
	public void setEmployeePay (double newEmployeePay)
	{
		//handles max and min options, if below min set to min, if above max set max, otherwise use entered value
		if( newEmployeePay < 8)
		{
			System.out.println("This below the min wage for this position, pay is set to min ($8)");

			//if pay input is below min, default to $8/hr
			this.employeePay = 8;	
		}

		else if(newEmployeePay >14)
		{
			System.out.println("This exceeds the max pay for this position, pay is set to max ($14)");

			//if max pay input exceeds default to $14/hr
			this.employeePay = 14;			
		}
		
		else
		{
			this.employeePay = newEmployeePay;
		}
	}

	//override for abstract class, sets job title to bartender
	@Override
	public void setEmployeeJobTitle()
	{
		this.employeeJobTitle = "bartender";

	}
}