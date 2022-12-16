package catTrap;

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
 * Responsibilities of class: Contains cat data and cat behavior
 * 
 */

public class Cat extends PlayPiece {

	private int row;
	private int column;
	private TrapModel model;
	
	/**
	 * Constructor for cat
	 * @param model This passes the model to the cat
	 */
	Cat(TrapModel model) 
	{
		this.model = model;

	}
	
	/**
	 *  Find the cats current row 
	 */
	@Override
	public int getRow() 
	{
		for(int i = 0 ; i < model.getLength(); i++)
		{
			for(int j = 0; j < model.getLength(); j++)
			{
				if(model.grid[i][j] == this) 
				{
					row = i;
				}
			}
		}
		return row;
	}

	/**
	 * Finds the cats current column
	 */
	@Override
	public int getCol() 
	{
		for(int i = 0 ; i < model.getLength(); i++)
		{
			for(int j = 0; j < model.getLength(); j++)
			{
				if(model.grid[i][j] == this) 
				{
					column = j;
				}
			}
		}
		return column;
	}

	/**
	 * Cats AI
	 */
	public void catMove()
	{
		//if subtracted row, use positive
		//if subtracted column, use positive
		Cat tempCat = (Cat) model.grid[getRow()][getCol()];
		model.grid[getRow()][getCol()] = null;
		boolean catThinking = true;
		
		while(catThinking)
		{
			Random randomNumberGenerator = new Random();
			int ponderSquare = randomNumberGenerator.nextInt(5);
			switch(ponderSquare)
			{
				case 0:
					if(!model.barrierAt(getRow() + 1, getCol()))
					{
						model.grid[getRow() + 1][getCol()] = tempCat;
						model.setPreviousCat(removeRowUp());
						catThinking = false;
						break;
					}
				case 1:
					if(!model.barrierAt(getRow() - 1, getCol()))
					{
						model.grid[getRow() - 1][getCol()] = tempCat;
						model.setPreviousCat(removeRowDown());
						catThinking = false;
						break;
					}
				case 2:
					if(!model.barrierAt(getRow(), getCol() + 1))
					{
						model.grid[getRow()][getCol() + 1] = tempCat;
						model.setPreviousCat(removeColLeft());
						catThinking = false;
						break;

					}
				case 3:
					if(!model.barrierAt(getRow(), getCol() - 1))
					{
						model.grid[getRow()][getCol() - 1] = tempCat;
						model.setPreviousCat(removeColRight());
						catThinking = false;
						break;
					}
				case 4:
					if(model.humanWin())
					{
						model.grid[getRow()][getCol()] = tempCat;
						catThinking = false;
						break;
					}
			}
		}
	}
		
	/**
	 * Aids in removing previous cat from previous button
	 * @return model.getLength() This is how far away the previous cats location is on the tile button array
	 */
	private int removeRowDown()
	{
		return model.getLength();
	}
	
	/**
	 * Aids in removing previous cat from previous button
	 * @return -model.getLength() This is how far away the previous cats location is on the tile button array
	 */
	private int removeRowUp()
	{
		return -model.getLength();
	}
	
	/**
	 * Aids in removing previous cat from previous button
	 * @return 1 This is how far away the previous cats location is on the tile button array
	 */
	private int removeColRight()
	{
		return 1;
	}
	
	/**
	 * Aids in removing previous cat from previous button
	 * @return -1 This is how far away the previous cats location is on the tile button array
	 */
	private int removeColLeft()
	{
		return -1;
	}
	
// 	Used for debugging		
//	public String toString()
//	{
//		return "CATT";
//	}
}
