package catTrap;

public class Barrier extends PlayPiece {

	private TrapModel model;
	private int row;
	private int column;
	
	Barrier(TrapModel model) 
	{
		this.model = model;
	}
	@Override
	public int getRow() 
	{
		for(int i = 0 ; i < model.length; i++)
		{
			for(int j = 0; j < model.length; j++)
			{
				if(model.grid[i][j] == this) 
				{
					row = i;
				}
			}
		}
		return row;
	}

	@Override
	public int getCol() 
	{
		for(int i = 0 ; i < model.length; i++)
		{
			for(int j = 0; j < model.length; j++)
			{
				if(model.grid[i][j] == this) 
				{
					column = j;
				}
			}
		}
		return column;	
	}
	
	public String toString()
	{
		return "barr";
	}
}
