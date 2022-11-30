package catTrap;

public class TrapModel {

	public int length = 9;
	private Cat[][] grid = new Cat[length][length];
	private boolean singlePlayer = true;
	private Cat cat;
	
	TrapModel()
	{
		int index = (length / 2) + 1;
		
		grid[index][index] = cat;
	}
	
	public void catWin() 
	{
		
	}
	
	public void humanWin() 
	{
		
	}
	
	public void getBarriersPlaced()
	{
		
	}
	
	public void getTurn() 
	{
		
	}
}
