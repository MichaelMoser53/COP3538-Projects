/**
 * Creates the criteria for the Stack object and contains method to access/use data
 * in the created "stackStates" stack. Allows for pushing and popping data into the
 * stack and printing the contents.
 * 
 * @author Michael Moser
 * @version 10/13/2017
 *
 */
public class Stack {
	
	private int maxSize;
	private State[] stackStates;
	private int top;
	protected Priority stateP = new Priority();

	/**
	 * Constructor for the Stack class to create an object of this type.
	 * Method does not return any value.
	 * 
	 * @param s takes an integer for the size of the Stack
	 */
	public Stack(int s)
	{
		maxSize = s;
		stackStates = new State[maxSize];
		top = -1;
	}
	
	/**
	 * Allows for "pushing" new state objects into the Stack which increments
	 * the top of the stack for each insert.
	 * 
	 * @param j takes a State object that will be pushed
	 */
	public void push(State j)
	{
		stackStates[++top] = j;
	}
	
	/**
	 * Allows for "popping" a state object already on the stack and removing it.
	 * Decrements the top of the stack after a object has been popped off.
	 * 
	 * @return The stack after a State object has been removed and top decremented
	 */
	public State pop()
	{
		return stackStates[top--];
	}
	
	/**
	 * Allows user to view the top of the stack showing the last object that was
	 * put into the stack.
	 * 
	 * @return The stack "stackStates" most recent value in the stack(top)
	 */
	public State peek()
	{
		return stackStates[top];
	}
	
	/**
	 * Allows for checking if the stack has no contents in it.
	 * 
	 * @return Compares if the top is -1 to see if nothing is in the stack
	 */
	public boolean isEmpty()
	{
		return (top == -1);
	}
	
	/**
	 * Checks to see if the stack is full and cannot add anymore objects.
	 * Compares the maxSize-1 to the top of the stack.
	 * 
	 * @return Compares top to maxSize of the stack to see if more contents can be added
	 */
	public boolean isFull()
	{
		return (top == maxSize-1);
	}
	
	/**
	 * Allows for printing the contents of the stack. Checks if the stack is empty
	 * and proceeds to print each object in the stack if it contains objects.
	 * After printing the current object, the pop() method is called to remove
	 * the state object from the stack.
	 * 
	 */
	public void printStack()
	{
		if(isEmpty()==true)
			System.out.println("The stack is empty");
		else
			for(int i = stackStates.length; i > 0; i--){
				System.out.println(stackStates[i-1].toString());
				stateP.insert(pop());
			}
		
	}

}
