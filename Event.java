class Event
{
	// event fields 
	public final static double HIGH_GUEST_PRICE = 35.00;
	public final static double LOW_GUEST_PRICE = 32.00;  
	public final static int LARGE_EVENT = 50;
	public final static int EVENT_NUM_LENGTH = 4;
	private String eventNumber;
	private int guests;
	private double pricePerGuest;
	private double priceForEvent;
	private String contactPhone;
	//add event types
	private int eventType;
	private String eventTypes[]={"wedding","baptism","birthday","corporate","other"};

	// Default constructor
	public Event()
	{
		//sets event number to A000, and guest to 0
		this("A000", 0);
	}
	// overload constructor accepts two parameters, event number and guests
	public Event(String num, int guests)
	{
		setEventNumber(num);
		setGuests(guests);
	}

	// sets event number
	public void setEventNumber(String num)
	{
		//sets formating to be in specific from
		boolean numOk = true;
		if(num.length() != EVENT_NUM_LENGTH || !Character.isLetter(num.charAt(0)) || !Character.isDigit(num.charAt(1)) || !Character.isDigit(num.charAt(2)) || !Character.isDigit(num.charAt(3))) 
			eventNumber = "A000";      
		else
			eventNumber = num.toUpperCase();
	}

	// gets guest
	public void setGuests(int gsts)
	{
		guests = gsts;
		//if large event use certain price
		if(isLargeEvent())
		{
			pricePerGuest = LOW_GUEST_PRICE;
			priceForEvent = guests * LOW_GUEST_PRICE;
		}
		else
		{
			pricePerGuest = HIGH_GUEST_PRICE;
			priceForEvent = guests * HIGH_GUEST_PRICE;
		}
	}

	//getters 
	public String getEventNumber()
	{
		return eventNumber;
	}
	public int getGuests()
	{
		return guests;
	}
	public double getPriceForEvent()
	{
		return priceForEvent;
	}
	public double getPricePerGuest()
	{
		return pricePerGuest;
	}
	public String getContactPhone()
	{
		//formats phone nuumber
		String phone;
		phone = "(" + contactPhone.substring(0, 3) + ") " +
				contactPhone.substring(3, 6) + "-" +
				contactPhone.substring(6, 10);
		return phone;
	}

	//setters
	public void setContactPhone(String phone)
	{
		// Ensure phone number is correct formating
		final int VALID_LEN = 10;
		final String INVALID_PHONE = "0000000000";
		contactPhone = "";
		int len = phone.length();
		for(int x = 0; x < len; ++x)
		{
			if(Character.isDigit(phone.charAt(x)))
				contactPhone += phone.charAt(x);
		}
		if(contactPhone.length() != VALID_LEN)
			contactPhone = INVALID_PHONE;
	}

	//checks to see event is large or not
	public boolean isLargeEvent()
	{
		boolean isLarge = false;
		if(guests >= LARGE_EVENT)
			isLarge = true;
		return isLarge;
	}

	//gets event type and returns based off string arr ay

	public String getEventType()
	{
		return eventTypes[eventType];	   
	}

	//sets evnet type 
	public void setEventType(int n)
	{
		if(n<0 || n>eventTypes.length-1)
			eventType = eventTypes.length-1;

		else
			eventType = n;	   

	}
}
