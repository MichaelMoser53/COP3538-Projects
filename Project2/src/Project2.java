import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

/**
 * COP 3538: Project 2 - Stacks and Priority Queues
 * <p>
 * Contains main method that will read the "States2.csv" file automatically and pull the State objects
 * into the "stackStates" stack. From the stack, the contents will be displayed from the top and will be "popped" out
 * into the different Priority Queues based on the population size for each region. Each of the queues will
 * be displayed and removed at the end and the program will close.
 * 
 * @author Michael Moser
 * @version 10/13/2017
 *
 */
public class Project2 {
	
	static State[] stateArr = new State[50];
	static File file = new File("States2.csv");
	static Stack stackStates = new Stack(33);

	/**
	 * Method creates an instance of a "Project2" object to call methods. Starts out by
	 * printing the class information and the file name of the csv that was read. Calls
	 * the function to read the csv file and fills the stack after. The next method that is
	 * called is to print the queues from the stack and reprints the stack contents at the end
	 * after they were removed from the priority queues.
	 * 
	 * @param args to initialize the main method
	 */
	public static void main(String[] args) {
		Project2 p = new Project2();
		
		System.out.println("COP3538 Project 2\nInstructor: Xudong Liu\nStudent: Michael Moser\n");
		System.out.println("Stacks and Priority Queues\nThe file '" + file +"' has been read\n" );
		
		p.readCsv();
		p.fillPrintStack(stateArr);
		stackStates.stateP.printQueue();
		
		System.out.println("\nStack Contents:\n");
		System.out.println("State Name\t State Capital\t State Abbreviation\t Population\t Region\t\t    US House Seats");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		stackStates.printStack();
		
		

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
	 * Method will fill the stack "stackStates" by using the compareTo() method with
	 * the region of each state in the "stateArr" array to South, West, or Midwest and pushes
	 * them onto the stack. After the entire array has been searched and all the appropriate
	 * states were pulled with the correct regions, a header print line will show the column
	 * headings of each value of the object. The printStack() method will be called on the
	 * "stackStates" stack to display all the contents containing the 3 regions.
	 * 
	 * @param stateArr is passed to access the state objects that were created from the csv file
	 */
	public void fillPrintStack (State[] stateArr){
		
		for(int i=0; i<stateArr.length; i++){
			
			if (stateArr[i].getRegion().compareTo("South")==0){
				stackStates.push(stateArr[i]);
			}
			if (stateArr[i].getRegion().compareTo("West")==0){
				stackStates.push(stateArr[i]);
			}
			if (stateArr[i].getRegion().compareTo("Midwest")==0){
				stackStates.push(stateArr[i]);
			}
				}
		System.out.println("There were 33 state records put onto the stack\n\nStack Contents:\n");
		System.out.println("State Name\t State Capital\t State Abbreviation\t Population\t Region\t\t    US House Seats");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		stackStates.printStack();
		
	}
	
}
