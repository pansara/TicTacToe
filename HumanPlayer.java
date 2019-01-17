package assignment3;
/*
 * This is the HumanPlyaer class that extends player and implements the global interface that is used to play if the human is playing
 */
import java.util.Scanner;

class HumanPlayer extends player implements global{
	//move that player whants to play
	protected int move;
	public HumanPlayer(board gameboard, int symbol, String name)
	{
		//invokes the parent class overloaded constructor
		super(gameboard, symbol, name);
	}
	Scanner sc = new Scanner(System.in);
	
	//abstract method that makes the play
	protected void play(board gameboard)
	{
		//asks the user to enter the move
		System.out.println("Make a move (1-9):");
		move = sc.nextInt();
		
		//checks whether the move is valid or not
		while(!isValid())
		{
			System.out.println("Invalid Move!! Try Again");
			System.out.println("Make a move (1-9):");
			move = sc.nextInt();
		}
		//makes the move on the instance of the board
		gameboard.makeMove(move, symbol);
	}
	
	/**
	 * this method checks the entered move is valid or not
	 * @return true if valid and false otherwise
	 */
	public boolean isValid()
	{
		int k = 0;
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if((3*i+j+1) == move)
				{
					if(gameboard.block[i][j].getState() == 0)
					{
						k++;
						break;
					}
				}
			}
		}
		if(k==0)
			return false;
		else
			return true;
	}
}
