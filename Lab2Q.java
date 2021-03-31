import java.util.Date;
import java.util.ArrayList;
//import java.io;
import java.util.Arrays;
import java.util.Random;

public class Lab2Q
{
	
	public static int[][] board = new int[8][8];
	public static int countOfQueens = 0;
	
	public static void set()
	{
		set(new int[8][8], 0, 0);
	}
	
	public static void set(int[][] newBoard, int x0, int y0)
	{
		int[][] old = new int[8][8];
		for(int k = 0; k < 8; k++)
		{
			for(int l = 0; l < 8; l++)
			{
				old[k][l] = newBoard[k][l];
			}
		}
		
		if(countOfQueens < 8)
		{
			for(int j = y0; j < 8; j++)
			{
				if(board[x0][j] == 0)
					{
						countOfQueens++;
						board[x0][j] += 1000;
						for(int k = 0; k < 8; k++)
						{
							if(board[x0][k] != 1000)
							{
								board[x0][k]++; 
							}
						}
						for(int k = 0; k < 8; k++)
						{
							if(board[k][j] != 1000)
							{
								board[k][j]++; 
							}
						}
						for(int k = x0, l = j; k < 8 && l < 8;)
						{
							if(board[k][l] != 1000)
							{
								board[k][l]++; 
							}
							k++;
							l++;
						}
						for(int k = x0, l = j; k >= 0 && l < 8;)
						{
							if(board[k][l] != 1000)
							{
								board[k][l]++; 
							}
							k--;
							l++;
						}
						for(int k = x0, l = j; k < 8 && l >= 0;)
						{
							if(board[k][l] != 1000)
							{
								board[k][l]++; 
							}
							k++;
							l--;
						}
						for(int k = x0, l = j; k >= 0 && l >= 0;)
						{
							if(board[k][l] != 1000)
							{
								board[k][l]++; 
							}
							k--;
							l--;
						}
						
						set(board, x0, j);
						if(countOfQueens < 8)
						{
							for(int k = 0; k < 8; k++)
							{
								for(int l = 0; l < 8; l++)
								{
									board[k][l] = old[k][l];
								}
							}
							countOfQueens--;
						}
					}
			}
			
			for(int i = x0+1; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(board[i][j] == 0)
					{
						countOfQueens++;
						board[i][j] += 1000;
						for(int k = 0; k < 8; k++)
						{
							if(board[i][k] != 1000)
							{
								board[i][k]++; 
							}
						}
						for(int k = 0; k < 8; k++)
						{
							if(board[k][j] != 1000)
							{
								board[k][j]++; 
							}
						}
						for(int k = i, l = j; k < 8 && l < 8;)
						{
							if(board[k][l] != 1000)
							{
								board[k][l]++; 
							}
							k++;
							l++;
						}
						for(int k = i, l = j; k >= 0 && l < 8;)
						{
							if(board[k][l] != 1000)
							{
								board[k][l]++; 
							}
							k--;
							l++;
						}
						for(int k = i, l = j; k < 8 && l >= 0;)
						{
							if(board[k][l] != 1000)
							{
								board[k][l]++; 
							}
							k++;
							l--;
						}
						for(int k = i, l = j; k >= 0 && l >= 0;)
						{
							if(board[k][l] != 1000)
							{
								board[k][l]++; 
							}
							k--;
							l--;
						}
						
						set(board.clone(), i, j);
						if(countOfQueens < 8)
						{
							for(int k = 0; k < 8; k++)
							{
								for(int l = 0; l < 8; l++)
								{
									board[k][l] = old[k][l];
								}
							}
							countOfQueens--;
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		
		set();
		System.out.println(Arrays.deepToString(board));
	}
	
}