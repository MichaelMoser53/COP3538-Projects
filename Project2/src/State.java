/**
* Creates the criteria for the State objects that includes the get and set methods
* for each variable. Class includes all private variables for better security by accessing
* the variables only through the getters.
*
* @author Michael Moser
* @version 9/17/2017
*/
public class State {
	 
	private String stateName;
	private String capital;
	private String abbr;
	private int pop;
	private String region;
	private int seats;

	/**
	* Constructs the State object by assigning the variables of the object when the CSV file
	* is parsed and constructed into a State object. No input values.
	*
	* @param stateName entered in from the CSV file as the name of the State object.
	* @param capital entered in from the CSV file as the capital city of the State object.
	* @param abbr entered in from the CSV file as the abbreviation of the State object.
	* @param pop entered in from the CSV file as the population integer of the State object.
	* @param region entered in from the CSV file as the location of the region of the State object.
	* @param seats entered in from the CSV file as the US House Seats integer of the State object.
	* @return no return value.
	*/
	public State(String stateName, String capital, String abbr, int pop, String region, int seats){
		this.stateName = stateName;
		this.capital = capital;
		this.abbr = abbr;
		this.pop = pop;
		this.region = region;
		this.seats = seats;
	}

	/**
	* Getter for the stateName variable. Allows for accessing the value of the variable
	* through other methods that need to reference the name of the state.
	*
	* @param None
	* @return returns the name of the state as a string
	*/
	public String getStateName() {
		return stateName;
	}

	/**
	* Setter for the stateName variable. Allows for assigning the stateName string
	* to a value of the object.
	*
	* @param name of the state to assign to the stateName variable
	* @return None
	*/
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	* Getter for capital variable. Allows for accessing the capital variable for other methods
	* that need to reference the variable.
	*
	* @param None
	* @return returns the capital of the State object as a string
	*/
	public String getCapital() {
		return capital;
	}

	/**
	* Setter for the capital variable. Allows for assigning the capital variable to a value
	* of a string.
	*
	* @param capital of the state to be assigned to the capital variable in the State object
	* @return None
	*/
	public void setCapital(String capital) {
		this.capital = capital;
	}

	/**
	* Getter for the abbr variable. Allows for accessing the abbreviation of the state for any
	* other methods that need it for a reference.
	*
	* @param None
	* @return abbreviation of the state for the State object
	*/
	public String getAbbr() {
		return abbr;
	}

	/**
	* Setter for the abbr variable. Allows for the abreviation of the state to be
	* assigned a string value.
	*
	* @param abbr for the abbreviation string of the State object
	* @return None
	*/
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	/**
	* Getter for the pop variable. Allows for the population of the State object
	* to be referenced in other methods.
	*
	* @param None
	* @return population integer of the State object
	*/
	public int getPop() {
		return pop;
	}

	/**
	* Setter for the pop variable. Allows for the population of the State object
	* to be assigned to a integer value.
	*
	* @param pop for the population integer of the State object
	* @return None
	*/
	public void setPop(int pop) {
		this.pop = pop;
	}

	/**
	* Getter for the region variable. Allows for the region of the State object
	* to be referenced in other methods.
	*
	* @param None
	* @return region of the State object as a string
	*/
	public String getRegion() {
		return region;
	}

	/**
	* Setter for the region variable. Allows for the region variable of the State object
	* to be assigned a string value.
	*
	* @param region of the State object
	* @return None
	*/
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	* Getter for the seats variable. Allows for the US House Seats integer to be
	* referenced in other methods.
	*
	* @param None
	* @return integer of the seats variable for the US House Seats
	*/
	public int getSeats() {
		return seats;
	}

	/**
	* Setter for the seats variable. Allows for the seats variable to be assigned an integer
	* value of the US House Seats from the CSV file.
	*
	* @param seats integer for the US House Seats value
	* @return None
	*/
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	/**
	* Method to display all the variables of the State object in a string format.
	* All strings are formatted for a clean look to display for the user. Can be called in
	* other methods to display all the info for a object in the stateArr variable that holds
	* all the State objects.
	*
	* @param None
	* @return All values of the State object added together in a String value to be displayed to the user
	*/
	@Override
	public String toString(){
		String s1 = String.format("%-20s", getStateName());
		String s2 = String.format("%-20s", getCapital());
		String s3 = String.format("%-17s", getAbbr());
		String s4 = String.format("%,-17d", getPop());
		String s5 = String.format("%-25s", getRegion());
		String s6 = String.format("%d", getSeats());
		
		String allStrings = s1+s2+s3+s4+s5+s6;
		return allStrings;
		
	}

	
	
}