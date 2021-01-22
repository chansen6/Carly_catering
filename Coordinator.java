public class Coordinator extends Employee
{
	//override for abstract class, set job pay $20/hour or less
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

		else if(newEmployeePay >20)
		{
			System.out.println("This exceeds the max pay for this position, pay is set to max ($20)");

			//if max pay input exceeds default to $20/hr
			this.employeePay = 20;
		}
		
		else
		{
			this.employeePay = newEmployeePay;
		}
	}

	//override for abstract class, sets job title to coordinator	
	@Override
	public void setEmployeeJobTitle()
	{
		this.employeeJobTitle = "coordinator";

	}

}