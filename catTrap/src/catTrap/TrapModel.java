package catTrap;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class TrapModel {

	public int length = 9;
	private int barriers = 4;
	public PlayPiece[][] grid = new PlayPiece[length][length];
	private Cat cat;
	private ArrayList<Barrier> barray = new ArrayList<Barrier>();
	
	TrapModel()
	{
		for(int i = 0; i < barriers; i++)
		{
			int row, column;
			Random randomNumberGenerator = new Random();
			row = randomNumberGenerator.nextInt(length);
			column = randomNumberGenerator.nextInt(length);
			Barrier barrier = new Barrier(this);
			barray.add(barrier);
			grid[row][column] = barrier;		
		}
		
		int index = (length / 2);
		cat = new Cat(this);
		grid[index][index] = cat;
		toConsole();
	}
		
	public boolean catAt(int row, int col)
	{
		if(cat.getCol() == col && cat.getRow() == row)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int catRow()
	{
		return cat.getRow();
	}
	
	public int catCol()
	{
		return cat.getCol();
	}
	
	public boolean barrierAt(int row, int col)
	{
		boolean barrierAt = false;
		for(int i = 0; i < barray.size(); i++)
		{
			if(barray.get(i).getCol() == col && barray.get(i).getRow() == row)
			{
			barrierAt = true;
			}
		}
		return barrierAt;
	}
	
	public void addBarrier(int row, int col)
	{
		Barrier barrier = new Barrier(this);
		barray.add(barrier);
		grid[row][col] = barrier;
	}
	
	public boolean humanWin() 
	{
		if(barrierAt(cat.getRow() + 1, cat.getCol()) && barrierAt(cat.getRow() - 1, cat.getCol()) &&
				barrierAt(cat.getRow(), cat.getCol() + 1) && barrierAt(cat.getRow(), cat.getCol() - 1))
		{
			return true;
		}
		return false;
	}
	
	public boolean catWin() 
	{
		for(int i = 0; i < length; i++)
		{
			if( catAt(length, i))
			{
				return true;
			}
		}
		return false;
	}
		
	public void updateCat()
	{
		cat.catMove();
	}
	public void toConsole() 
	{
		for(int i = 0 ; i < length; ++i)
		{
			for(int j = 0; j < length; ++j)
			{
				System.out.print( " | " + grid[i][j] + " | ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public String toString()
	{
		return "model";
		
	}
}
