package assignment3;
/**
 * 
 * @author SHIVANI PANSARA
 *This is the abstract player class that keeps the record of player information like name and symbol and also get the instance of board on which the game is being played
 */
public abstract class player {
	//class attributes
	board gameboard;
	protected String name;
	protected int symbol;
	
	//default constructor
	public player()
	{
		name = " ";
		symbol = 1;
	}
	
	//ooverloaded constructor
	public player(board gameboard, int symbol, String name)
	{
		this();	//invokes default constructor
		this.symbol = symbol;
		this.name = name;
		this.gameboard = gameboard;
	}
	
	//access method set the name and symbol
	public void setName(String name)
	{
		//condition to set the name
		if(name.length() != 0)
		{
			this.name = name;
		}
	}
	
	public void setSymbol(int symbol)
	{
		//condition to set the symbol
		if(this.symbol == symbol)
		{
			this.symbol = symbol;
		}
	}
	
	//access get methods to get the name and symbol
	public String getName()
	{
		return name;
	}
	
	public int getSymbol()
	{
		return symbol;
	}
	
	//abstract method that is to be applied to all the class that extends player
	protected abstract void play(board gameboard);
	public String toString()
	{
		return ""; 
	}
}
