/**
 * Creates the criteria for the Priority object and creates variables for the different
 * Priority Queues needed for each region. Contains the methods to insert and remove data
 * based on the queues contents.
 * 
 * @author Michael Moser
 * @version 10/13/2017
 *
 */
public class Priority {
		
		private int maxSize = 50;
		
		private State[] southP;
		private int southNums;
		private int sFront;
		
		private State[] westP;
		private int westNums;
		private int wFront;
		
		private State[] midwestP;
		private int midwestNums;
		private int mwFront;
		
		/**
		 * Constructor for the Priority object. Includes the 3 priority objects
		 * for the 3 different regions. Creates variables for each region queue.
		 */
		public Priority()
		{
		southP = new State[maxSize];
		southNums = 0;
		sFront = 0;
		westP = new State[maxSize];
		westNums = 0;
		wFront = 0;
		midwestP = new State[maxSize];
		midwestNums = 0;
		mwFront = 0;
		
		}
		
		/**
		 * Allows for inserting State objects in the south region from the stack.
		 * The order the objects are placed in the Queue is based on the priority of
		 * population, the higher the population state objects will be first in the queue.
		 * 
		 * @param item is a state object that is passed to compare the population to the stack
		 */
		public void insertSouth(State item){
			if (southNums == 0){
				southP[southNums++] = item;
			}
			else{
				int i;
				for (i = southNums - 1; i >= 0; i--){
					if (item.getPop() > southP[i].getPop())
						southP[i+1] = southP[i];
					else
						break;
				}
				southP[i+1] = item;
				southNums++;
			}
		}
		
		/**
		 * Allows for inserting State objects in the west region from the stack.
		 * The order the objects are placed in the Queue is based on the priority of
		 * population, the higher the population state objects will be first in the queue.
		 * 
		 * @param item is a state object that is passed to compare the population to the stack
		 */
		public void insertWest(State item){
			if (westNums == 0){
				westP[westNums++] = item;
			}
			else{
				int i;
				for (i = westNums - 1; i >= 0; i--){
					if (item.getPop() > westP[i].getPop())
						westP[i+1] = westP[i];
					else
						break;
				}
				westP[i+1] = item;
				westNums++;
			}
		}
		
		/**
		 * Allows for inserting State objects in the midwest region from the stack.
		 * The order the objects are placed in the Queue is based on the priority of
		 * population, the higher the population state objects will be first in the queue.
		 * 
		 * @param item is a state object that is passed to compare the population to the stack
		 */
		public void insertMidwest(State item){
			if (midwestNums == 0){
				midwestP[midwestNums++] = item;
			}
			else{
				int i;
				for (i = midwestNums - 1; i >= 0; i--){
					if (item.getPop() > midwestP[i].getPop())
						midwestP[i+1] = midwestP[i];
					else
						break;
				}
				midwestP[i+1] = item;
				midwestNums++;
			}
		}
		
		/**
		 * Switch case used to display a header line detailing which queue is being displayed
		 * if the queue is full. If the queue is not full, it will call the appropriate insert
		 * method for the region to fill the queue. Uses the State item to get the region name
		 * of the object to be used in the Switch case statement.
		 * 
		 * @param item State object to use the getRegion method to place objects in correct queues
		 */
		public void insert(State item)
		{
			String region = item.getRegion();
			
			switch (region)
			{
			case "South":
				if (isFull())
				{
					System.out.println("Priority Queue " + region + " is full.");
					break;
				}
				else
				{
					insertSouth(item);
	                break;
				}
			case "West":
				if (isFull())
				{
					System.out.println("Priority Queue " + region + " is full.");
					break;
				}
				else
				{
					insertWest(item);
	                break;
				}
			case "Midwest":
				if (isFull())
				{
					System.out.println("Priority Queue " + region + " is full.");
					break;
				}
				else
				{
					insertMidwest(item);
	                break;
				}
			}
		} 
		
		/**
		 * Removes the objects in the south priority queue and reinserts them into the
		 * "stackStates" stack by pushing the objects into the stack from the queue.
		 * 
		 * @return the south priority queue with updated numbers of objects
		 */
		public State removeSouth(){
			Project2.stackStates.push(southP[sFront++]);
			return southP[southNums];
		}
		
		/**
		 * Removes the objects in the west priority queue and reinserts them into the
		 * "stackStates" stack by pushing the objects into the stack from the queue.
		 * 
		 * @return the west priority queue with updated numbers of objects
		 */
		public State removeWest(){
			Project2.stackStates.push(westP[wFront++]);
			return westP[westNums];
		}
		
		/**
		 * Removes the objects in the midwest priority queue and reinserts them into the
		 * "stackStates" stack by pushing the objects into the stack from the queue.
		 * 
		 * @return the midwest priority queue with updated numbers of objects
		 */
		public State removeMidwest(){
			Project2.stackStates.push(midwestP[mwFront++]);
			return midwestP[midwestNums];
		}
		
		/**
		 * Prints the correct regions priority queues content's by calling the toString()
		 * method from the State class. After all the states are printed from each queue,
		 * they are removed by using the remove method for that region.
		 */
		public void printQueue(){
			if(isEmpty()==true)
				System.out.println("The Queue is empty");
			else
				System.out.println("\nSouth Priority Queue Contents:\n");
			System.out.println("State Name\t State Capital\t State Abbreviation\t Population\t Region\t\t    US House Seats");
			System.out.println("----------------------------------------------------------------------------------------------------------");
				for(int i = 0; i < southNums; i++){
					System.out.println(southP[i].toString());
					removeSouth();
				}
				System.out.println("\nWest Priority Queue Contents: \n");
				System.out.println("State Name\t State Capital\t State Abbreviation\t Population\t Region\t\t    US House Seats");
				System.out.println("----------------------------------------------------------------------------------------------------------");
				for(int i = 0; i < westNums; i++){
					System.out.println(westP[i].toString());
					removeWest();
				}
				System.out.println("\nMidwest Priority Queue Contents:\n");
				System.out.println("State Name\t State Capital\t State Abbreviation\t Population\t Region\t\t    US House Seats");
				System.out.println("----------------------------------------------------------------------------------------------------------");
				for(int i = 0; i < midwestNums; i++){
					System.out.println(midwestP[i].toString());
					removeMidwest();
				}
		}
		
		/**
		 * Checks to see if the count of the elements in the priority queues are equal
		 * to 0 for each of the regions.
		 * @return the number of elements in each region's queue equivalent to 0
		 */
		public boolean isEmpty(){
			return (southNums == 0 || westNums == 0 || midwestNums == 0);
		}
		
		/**
		 * Checks to see if the count of the elements in the priority queues are equal
		 * to the max number of elements for each of the regions.
		 * @return the number of elements in each region's queue equivalent to the max size
		 */
		public boolean isFull(){
			return (southNums == maxSize || westNums == maxSize || midwestNums == maxSize);
		}
		
}