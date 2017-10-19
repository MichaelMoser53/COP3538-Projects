import java.io.*;
import java.util.*;

/**
* COP 3538: Project 1 – Array Searches and Sorts
* <p>
* Class contains the main method to run the program. Class creates the stateArr
* variable to hold all the State objects. The class creates a new file to pull in the
* state information to be parsed and assigned to the array. Input required in the main
* method to output results based on the user's options.
*
* @author Michael Moser
* @version 9/17/2017
*/
public class Project1 {
	
	static State[] stateArr = new State[50];
	File file = new File("States1.csv");

	/**
	* Executes the program by reading the CSV files and storing the info into the
	* stateArr as State objects. Switch case statements used for the user's input
	* to execute each option. Try/Catch block used for input validation for incorrect
	* inputs that are not defined within the switch statement by prompting the user to
	* enter a valid input.
	* <p>
	* Main method will continue running until the option 6 is given to quit the application.
	* Each case calls another method to perform a specific task that used the stateArr variable.
	*
	* @param args to initialize the main method
	* @return None
	*/
	public static void main(String[] args) {
		
		Project1 p = new Project1();
		p.readCsv();
		
		System.out.println("COP 3538 Project 1\nStudent: Michael Moser\n");
		System.out.println("States1.csv has been read\n50 State objects were created\n");
		
		boolean quit = false;
		while(!quit){
		try{
		
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		
			
			System.out.println("1. Print a state report\n2. Sort by State name\n3. Sort by Population\n4. Sort by Region\n5. Find and print a given state\n6. Quit");
			System.out.print("Enter your choice: ");
			
			int choice = userInput.nextInt();
		switch (choice){
		case 1:
			System.out.println("");
			p.printAllStates(stateArr);
			break;
		
		case 2:
			System.out.println("");
			p.sortNames(stateArr);
			break;
			
		case 3:
			System.out.println("");
			p.sortPop(stateArr);
			break;
			
		case 4:
			System.out.println("");
			p.sortRegion(stateArr);
			break;
			
		case 5:
			System.out.println("");
			p.searchStates(stateArr);
			break;
			
		case 6:
			System.out.println("\nApplication closing...\nHave a good day!");
			quit = true;
			return;
			
		default:
			System.out.println("\nInvalid Choice, enter 1-6\n");
			break;
		}
		
		
		}catch(InputMismatchException e){
			System.out.println("\nInvalid Choice, enter 1-6\n");
		}
		}
		
		
	}

	/**
	* Creates a scanner object for the input file used for parsing to obtain
	* the state information. Skips the first line of the CSV file to skip title
	* headings and pull in actual state information to be stored as a State object.
	* Information is pulled in one line at a time and split by the "," char. This allows
	* for each separate piece of information to be assigned to a variable as the for
	* loop cycles through each state filling each element of the array.
	*
	* @param None
	* @return None
	*/
	public void readCsv(){
		try{
			Scanner inputFile = new Scanner(file);
			inputFile.nextLine();
			inputFile.useDelimiter(",|\r\n");
			
				
			while (inputFile.hasNext()) {
				
				for (int i=0; i<stateArr.length; i++){
					
				String entireState = inputFile.nextLine();
				String[] data = entireState.split(",");
				String stateName = data[0];
				String capital = data[1];
				String abbr = data[2];
				int pop = Integer.parseInt(data[3]);
				String region = data[4];
				int seats = Integer.parseInt(data[5]);
				stateArr[i] = new State(stateName, capital, abbr, pop, region, seats);
				
				}
			}
			inputFile.close();
			
			
			
	}
		
		catch (FileNotFoundException e){
			System.out.println("Invalid file, please try again.");
		}
		
	}
	
	/**
	* When method is called, the stateArr array contents are all displayed in the
	* current order of the elements. This method includes the title line to label
	* the state info in it's formatted condition. toString method called to display
	* the formatted info from the variables.
	*
	* @param stateArr array passed to use the contents of the State objects
	* @return None
	*/
	public void printAllStates(State[] stateArr){
		
		System.out.println("State Name\t State Capital\t State Abbreviation\t Population\t Region\t\t    US House Seats");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<stateArr.length;i++){
			System.out.println(stateArr[i].toString());
		}
		System.out.println("");
	}
	
	/**
	* The method sorts the stateArr array by the stateName variable of each object.
	* The sorting method used is bubble sort to sort the array in alphabetical order.
	*
	* @param stateArr array passed to use the contents of the State objects
	* @return None
	*/
	public void sortNames(State[] stateArr){
		
		for (int i = 0; i < stateArr.length-1; i++) {
			for (int j = stateArr.length-1; j > i; j--) {
				if (stateArr[j].getStateName().compareTo(stateArr[j-1].getStateName())<0) {
					State temp = stateArr[j];
					stateArr[j] = stateArr[j-1];
					stateArr[j-1] = temp;
					}
				}
			}
		
		System.out.println("States were sorted by Name\n");
		
    }
	
	/**
	* This method sorts the stateArr array by the population value of each State
	* object. Population is sorted using a selection sort to be placed in ascending order.
	*
	* @param stateArr array passed to use the contents of the State objects
	* @return None
	*/
	public void sortPop(State[] stateArr){

		int lowest;
		for(int outer=0; outer<stateArr.length -1; outer++) {
			lowest = outer;
				for(int inner=outer+1; inner<stateArr.length; inner++) {
					if(stateArr[inner].getPop() < stateArr[lowest].getPop()) {
						lowest = inner;
					}
				}	
				if(lowest != outer) {
					State temp = stateArr[lowest];
					stateArr[lowest] = stateArr[outer];
					stateArr[outer] = temp;
				}
			}
			
		
		System.out.println("States were sorted by Population\n");
		
	}
	
	/**
	* This method sorts the stateArr array by the region variable of each of the
	* State objects. Region is sorted using an insertion sort and placed in ascending order.
	*
	* @param stateArr array passed to use the contents of the State objects
	* @return None
	*/
	public void sortRegion(State[] stateArr){

		int in, out;
			for(out=1; out<stateArr.length; out++) {
				State temp = stateArr[out];
				in = out;
			while (in>0 && stateArr[in-1].getRegion().compareTo(temp.getRegion())>0) {
				stateArr[in] = stateArr[in-1];
				in--;
			}
			stateArr[in] = temp;
		}
		System.out.println("States were sorted by Region\n");
	}
	
	/**
	* This method searches the stateArr array by a user input by comparing a user
	* entered string to the stateName variable to display all the info of a specific
	* state. If a match is found, the formatted contents of the state will be displayed
	* in a string format. If no match is found, it will display an error message and
	* return back to the main menu.
	*
	* @param stateArr array passed to use the contents of the State objects
	* @return None
	*/
	public void searchStates(State[] stateArr){
    
	@SuppressWarnings("resource")
	Scanner searchInput = new Scanner(System.in);
       
       System.out.print("Enter the State Name: ");
       String key = searchInput.next();
       System.out.println("Sequential search\n");
       
       int i;
       boolean found = false;

       for (i = 0; i < stateArr.length; i++)
       {
              if (key.equals(stateArr[i].getStateName()))
             {
                      found = true;
                      if (found)
                      {
                    	String s1 = String.format("%-20s", stateArr[i].getStateName());
                  		String s2 = String.format("%-20s", stateArr[i].getCapital());
                  		String s3 = String.format("%-20s", stateArr[i].getAbbr());
                  		String s4 = String.format("%,-20d", stateArr[i].getPop());
                  		String s5 = String.format("%-20s", stateArr[i].getRegion());
                  		String s6 = String.format("%-20d", stateArr[i].getSeats());
                            System.out.print("State Name:\t\t" + s1);
                            System.out.println("\nCapital City:\t\t" + s2);
                            System.out.println("State Abbr:\t\t" + s3);
                            System.out.println("State Population:\t" + s4);
                            System.out.println("Region:\t\t\t" + s5);
                            System.out.println("US House Seats:\t\t" + s6 + "\n");
                      }
                      
                  }
                      
              }
       if (found == false)
       {
             System.out.println(key + " is not a valid state.\n");
       }
        }
		
}

