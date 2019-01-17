package assignment3;

import java.util.Random;
import java.util.Scanner;

//this class extends the board class and implements the global interface that starts the game with coin toss and maintains the turn of the player
class game extends board implements global {
	board board;		//creates the instance of board
	player pX;			//instance if player X
	player pO;			//instance if player O
	player currentPlayer;		//the player who is currently playing
	
	//default constructor that instantiates the board
	public game()
	{
		board = new board();
	}
	Scanner sc = new Scanner(System.in);
	Scanner s = new Scanner(System.in);
	
	//choice and to choose vs Human of vs Computer
	int choice;
	String name;
	
	//to keepplaying until the game is over or won by any player
	boolean keepplaying = true;
	int toss, r;
	
	//method to start the game
	public void start() {
		//loop to get th choice and run till the valid choice is not made
		while(choice != 1 && choice != 2)
		{
			System.out.println("Make a choice\n1. Human Player\t2. AIPlayer");
			choice = sc.nextInt();
			
			//if vs Human than asks the user to enter names
			if(choice == 1)
			{
				System.out.println("Enter name of Player1:");
				name = s.nextLine();
				//invokes the overloaded constructor of the player class and sets the details
 				pX = new HumanPlayer(board, 1, name);
				//pX.setName(name);
				//pX.setSymbol(1);
				System.out.println("Enter name of Player2:");
				name = s.nextLine();
				pO = new HumanPlayer(board, 2, name);
				//pX.setName(name);
				//pX.setSymbol(2);
			}
			else if(choice == 2)
			{
				System.out.println("Enter your name:");
				name = s.nextLine();
				pX = new HumanPlayer(board, 1, name);
				pO = new AIPlayer2(board, 2, "COMPUTER");		//if vs computer
			}
			else
			{
				//if invalid choice entered
				System.out.println("Invalid input!!\nTRY AGAIN :(");
			}
		}
		
		//makes a random toss
		Random r = new Random();
		toss = r.nextInt(2);
		int c;
		
		//chooses the current player according to the toss
		if(toss == 1)
		{
			currentPlayer = pX;
		}
		else
		{
			currentPlayer = pO;
		}
		
		System.out.println("Player "+currentPlayer.getName()+" wins the toss\nPlayer "+currentPlayer.getName()+" plays");
		board.displayPlayerSectionBoard();			//display the board to play
		while(keepplaying == true)		//keep playing util its a draw or a win
		{
			currentPlayer.play(board);			//passes the board to the player to play
			//this if-else changes the turns of the player
			if(currentPlayer.getSymbol() == 1)	
			{
				currentPlayer = pO;
			}
			else
			{
				currentPlayer = pX;
			}
			c = board.updateState();				//updates the state of the board to win, draw or still play
			if(c == 1)
			{
				System.out.println(pX.getName()+" Wins");
				break;
			}
			else if(c == 2)
			{
				System.out.println(pO.getName()+" Wins");
				break;
			}
			else if(c == 3)
			{
				System.out.println("Game is a DRAW");
				break;
			}
			System.out.println(currentPlayer.getName()+" plays");
			board.displayPlayerSectionBoard();				//display the board
		}
		board.displayBoard();			//displays the final board after the final result
	}
}
