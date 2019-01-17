package assignment3;

import java.util.Random;

class AIPlayer2 extends player{
	protected int move;
	public AIPlayer2(board gameboard, int symbol, String name)
	{
		super(gameboard, symbol, name);
	}
	
	protected void play(board gameboard)
	{
		Random r = new Random();
		//move = r.nextInt(9)+1;
		/*while(!isValid())
		{
			move = r.nextInt(9)+1;
		}*/
		//move = checkDefense();
		if((move = checkWin())!=0 && isValid())
		{
			System.out.println("Winning move");
			gameboard.makeMove(checkWin(), symbol);
		}
		else if((move = checkDefense())!=0 && isValid())
		{
			System.out.println("Playing in Defense");
			gameboard.makeMove(checkDefense(), symbol);
		}
		else
		{
			move = r.nextInt(9)+1;
			while(!isValid())
			{
				move = r.nextInt(9)+1;
			}
			System.out.println("Random move");
			gameboard.makeMove(move, symbol);
		}
	}
	
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
	
	public int checkDefense()
	{
		if(gameboard.block[1][1].getState()==1)
		{
			if(gameboard.block[0][0].getState()==1)
				return 9;
			else if(gameboard.block[2][2].getState()==1)
				return 1;
			else if(gameboard.block[2][0].getState()==1)
				return 3;
			else if(gameboard.block[0][2].getState()==1)
				return 7;
		}
		if(gameboard.block[0][1].getState()==1)
		{
			if(gameboard.block[0][0].getState()==1)
				return 3;
			else if(gameboard.block[0][2].getState()==1)
				return 1;
			else if(gameboard.block[1][1].getState()==1)
				return 8;
			else if(gameboard.block[2][1].getState()==1)
				return 5;
		}
		if(gameboard.block[1][0].getState()==1)
		{
			if(gameboard.block[0][0].getState()==1)
				return 7;
			else if(gameboard.block[2][0].getState()==1)
				return 1;
			else if(gameboard.block[1][1].getState()==1)
				return 6;
			else if(gameboard.block[1][2].getState()==1)
				return 5;
		}
		if(gameboard.block[2][1].getState()==1)
		{
			if(gameboard.block[2][0].getState()==1)
				return 9;
			else if(gameboard.block[2][2].getState()==1)
				return 7;
			else if(gameboard.block[1][1].getState()==1)
				return 2;
			else if(gameboard.block[0][1].getState()==1)
				return 5;
		}
		if(gameboard.block[1][2].getState()==1)
		{
			if(gameboard.block[0][1].getState()==1)
				return 9;
			else if(gameboard.block[2][2].getState()==1)
				return 3;
			else if(gameboard.block[1][1].getState()==1)
				return 4;
			else if(gameboard.block[1][0].getState()==1)
				return 5;
		}
		return 0;
	}
	
	public int checkWin()
	{
		if(gameboard.block[1][1].getState()==2)
		{
			if(gameboard.block[0][0].getState()==2)
				return 9;
			else if(gameboard.block[2][2].getState()==2)
				return 1;
			else if(gameboard.block[2][0].getState()==2)
				return 3;
			else if(gameboard.block[0][2].getState()==2)
				return 7;
		}
		if(gameboard.block[0][1].getState()==2)
		{
			if(gameboard.block[0][0].getState()==2)
				return 3;
			else if(gameboard.block[0][2].getState()==2)
				return 1;
			else if(gameboard.block[1][1].getState()==2)
				return 8;
			else if(gameboard.block[2][1].getState()==2)
				return 5;
		}
		if(gameboard.block[1][0].getState()==2)
		{
			if(gameboard.block[0][0].getState()==2)
				return 7;
			else if(gameboard.block[2][0].getState()==2)
				return 1;
			else if(gameboard.block[1][1].getState()==2)
				return 6;
			else if(gameboard.block[1][2].getState()==2)
				return 5;
		}
		if(gameboard.block[2][1].getState()==2)
		{
			if(gameboard.block[2][0].getState()==2)
				return 9;
			else if(gameboard.block[2][2].getState()==2)
				return 7;
			else if(gameboard.block[1][1].getState()==2)
				return 2;
			else if(gameboard.block[0][1].getState()==2)
				return 5;
		}
		if(gameboard.block[1][2].getState()==2)
		{
			if(gameboard.block[0][1].getState()==2)
				return 9;
			else if(gameboard.block[2][2].getState()==2)
				return 3;
			else if(gameboard.block[1][1].getState()==2)
				return 4;
			else if(gameboard.block[1][0].getState()==2)
				return 5;
		}
		return 0;
	}
}
