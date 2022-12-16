package catTrap;

import java.util.ArrayList;
import java.util.Random;

/**
 * Lead Author(s): 
 * @author Pablo Wells
 * @author 
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * <<add more references here>>
 *  
 * Version/date: 12/16/2022
 * 
 * Responsibilities of class: Contains data of game pieces and determines game status
 * 
 */

public class TrapModel {

	private int length;
	private int barriers;
	public PlayPiece[][] grid;
	private Cat cat;
	private ArrayList<Barrier> barray = new ArrayList<Barrier>();
	private int prevCat;
	
	/**
	 * Constructor
	 * @param length This sets the length of the grid
	 * @param barriers This sets the number of barriers in the grid
	 */
	TrapModel(int length, int barriers)
	{
		this.length = length;
		this.barriers = barriers;
		
		grid = new PlayPiece[this.length][this.length];
		
		for(int i = 0; i < barriers; i++)
		{
			int row, column;
			Random randomNumberGenerator = new Random();
			row = randomNumberGenerator.nextInt(this.length);
			column = randomNumberGenerator.nextInt(this.length);
			Barrier barrier = new Barrier(this);
			barray.add(barrier);
			grid[row][column] = barrier;		
		}
		
		int index = (this.length / 2);
		cat = new Cat(this);
		grid[index][index] = cat;
//		toConsole();
	}
	
	/**
	 * Returns length
	 * @return length of the grid
	 */
	public int getLength()
	{
		return length;
	}
	
	/**
	 * Checks if cat is in a row and column
	 * @param row This is used to check the row
	 * @param col This is used to check the column
	 * @return boolean whether or not cat is there
	 */
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
	
	/**
	 * Returns row where cat is at
	 * @return cat.getRow() This is the cats row
	 */
	public int catRow()
	{
		return cat.getRow();
	}
		
	/**
	 * Returns column where cat is at
	 * @return cat.getCol() This is the cats column
	 */
	public int catCol()
	{
		return cat.getCol();
	}
	
	/**
	 * Sets the previous cats direction
	 * @param move This is the previous cats location
	 */
	public void setPreviousCat(int move)
	{
		this.prevCat = move;
	}
	
	/**
	 * returns cats direction
	 * @return prevCat This is where the cat previously was
	 */
	public int getPreviousCat()
	{
		return prevCat;
	}
		
	/**
	 * Checks if their is a barrier
	 * @param row This is the row a potential barrier is at
	 * @param col This is the column a potential barrier is at
	 * @return barrierAt This is a boolean that is true/false depending on if a barrier is found
	 */
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
	
	/**
	 * Adds a barrier to the grid
	 * @param row This is the row where the barrier is added
	 * @param col This is the column where the barriers is added
	 */
	public void addBarrier(int row, int col)
	{
		Barrier barrier = new Barrier(this);
		barray.add(barrier);
		grid[row][col] = barrier;
	}
	
	/**
	 * Checks if human has surrounded the cat with barriers
	 * @return boolean This is if the player has won or not
	 */
	public boolean humanWin() 
	{
		if(barrierAt(cat.getRow() + 1, cat.getCol()) && barrierAt(cat.getRow() - 1, cat.getCol()) &&
				barrierAt(cat.getRow(), cat.getCol() + 1) && barrierAt(cat.getRow(), cat.getCol() - 1))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if cat has reached the edges
	 * @return boolean This is if the cat has won or not
	 */
	public boolean catWin() 
	{
		boolean catWin = false;
		
		for(int i = 0; i < length; i++)
		{
			if(catAt(length - 1, i) || catAt(i, length - 1) || catAt(i, 0) || catAt(0, i))
			{
				catWin = true;
			}
		}
		return catWin;
	}
	
	/**
	 * Updates the cat movement on grid
	 */
	public void updateCat()
	{
		cat.catMove();
	}
	
//	Used for debugging
//	public void toConsole() 
//	{
//		for(int i = 0 ; i < length; ++i)
//		{
//			for(int j = 0; j < length; ++j)
//			{
//				System.out.print( " | " + grid[i][j] + " | ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
//	
//	public String toString()
//	{
//		return "model";
//		
//	}
}
