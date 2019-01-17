package assignment3;
//this class implements the global interface and makes the instance of board and makes the move entered by the player
class board implements global {
	block[][] block;				//creates the instance of the block
	protected int state;			//state of the block whether empty, draw or win
	
	//default constructor 
	public board()
	{
		int k=1;
		state = EMPTY;
		
		//instance each and every block
		block = new block[3][3];
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				 block[i][j] = new block();
			}
		}
	}
	
	//check if any the block is empty or not returns true if empty and else return false
	public boolean isEmpty()
	{
		int count = 0;
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(block[i][j].getState() == 0)
					count++;
			}
		}
		if(count == 9)
			return true;
		else
			return false;
	}
	
	//checks for the win in a row
	public int checkRow(int row)
	{
		int i=row;
		if(block[i][0].getState() == block[i][1].getState() && block[i][1].getState() == block[i][2].getState())
		{
			return block[i][1].getState();
		}
		return 0;
	}
	
	//checks for the win in a column
	public int checkCol(int column)
	{
		int i=column;
		if(block[0][i].getState() == block[1][i].getState() && block[1][i].getState() == block[2][i].getState())
		{
			return block[1][i].getState();
		}
		return 0;
	}
	
	//checks for win in a diagonal
	public int checkDiagonal()
	{
		if(block[0][0].getState() == block[1][1].getState() && block[1][1].getState() == block[2][2].getState())
		{
			return block[1][1].getState();
		}
		else if(block[0][2].getState() == block[1][1].getState() && block[1][1].getState() == block[2][0].getState())
		{
			return block[1][1].getState();
		}
		return 0;
	}
	
	//checks for the draw
	public int checkDraw()
	{
		int count=0;
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(block[i][j].getState() != 0)
					count++;
			}
		}
		if(count == 9)
		{
			return 3;
		}
		return 0;
	}
	
	//displays the final board after the game is ended
	public void displayBoard()
	{
		for(int i=0; i<3; i++)
		{
			//System.out.print("| ");
			for(int j=0; j<3; j++)
			{
				char c = 'X';
				int s = block[i][j].getState();
				if(s == 0)
				{
					c= ' ';
				}
				else if(s==2)
				{
					c = 'O';
				}
				if(j==2)
				{
					System.out.println(c);
					break;
				}
				System.out.print(c+" | ");
			}
			if(i==2)break;
			System.out.println("---------");
		}
		
	}
	
	//displays the board for the player to play
	public void displayPlayerSectionBoard()
	{
		for(int i=0; i<3; i++)
		{
			//System.out.print("| ");
			for(int j=0; j<3; j++)
			{
				char c = 'X';
				int s = block[i][j].getState();
				if(s == 0)
				{
					c= Character.forDigit(3*i+j+1, 10);
				}
				else if(s==2)
				{
					c = 'O';
				}
				if(j==2)
				{
					System.out.println(c);
					break;
				}
				System.out.print(c+" | ");
			}
			if(i==2)break;
			System.out.println("---------");
		}
	}
	
	//makes the move as per the move entered and sets the state of that particular block to the state of the iser X or O
	public void makeMove(int move, int symbol)
	{
		if(move == 1)
			block[0][0].setState(symbol);
		else if(move == 2)
			block[0][1].setState(symbol);
		else if(move == 3)
			block[0][2].setState(symbol);
		else if(move == 4)
			block[1][0].setState(symbol);
		else if(move == 5)
			block[1][1].setState(symbol);
		else if(move == 6)
			block[1][2].setState(symbol);
		else if(move == 7)
			block[2][0].setState(symbol);
		else if(move == 8)
			block[2][1].setState(symbol);
		else if(move == 9)
			block[2][2].setState(symbol);
		//displayPlayerSectionBoard();	
	}
	
	//updates the state and tells if its  a win or a draw or keep playing
	public int updateState()
	{
		int k;
		//checks if there is a win in the column
		for(int i=0; i<3; i++)
		{
			k=checkCol(i);
			if(k!=0)
				return k;
		}
		
		//checks if there is a win in the row
		for(int i=0; i<3; i++)
		{
			k=checkRow(i);
			if(k!=0)
				return k;
		}
		
		//checks for the win in the diagonal
		k = checkDiagonal();
		if(k!=0)
			return k;
		k = checkDraw();
		if(k!=0)
			return k;
		return 0;
	}
	
	
}
