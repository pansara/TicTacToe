package assignment3;
//this class implements the global interface that keeps the track of each and every block to play
class block implements global{
	protected int state = EMPTY;			//initially the state of the block is empty
	
	//default constructor
	public block()
	{
		state = EMPTY;
	}
	
	//overloaded constructor that sets the state of each block as per that entered by the user
	public block(int state)
	{
		this();
		setState(state);
	}
	
	//sets the state of that particular block
	public void setState(int state)
	{
		//check if it is a valid state
		if(isValidState())
		{
			this.state = state;
		}
		else		//prints the error message
		{
			System.out.println("Invalid Move!!");
		}
	}
	
	//gets the state if the particular block
	public int getState()
	{
		return this.state;
	}
	
	//cj=kecks if it is a vlid state that is the particular block is empty to make a move by the user
	public boolean isValidState()
	{
		if(state == 0)
			return true;
		return false;
	}
	
	//toString 
	public String toString()
	{
		return state + "";
	}
}
