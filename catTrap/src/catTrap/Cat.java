package catTrap;

public class Cat extends PlayPiece {

	private int row;
	private int column;
	private TrapModel model;
	
	Cat(TrapModel model) 
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
	
	public void catMove()
	{
		Cat tempCat = (Cat) model.grid[getRow()][getCol()];
		model.grid[getRow()][getCol()] = null;
		model.grid[getRow()+1][getCol()] = tempCat;
	}
	
	public String toString()
	{
		return "catt";
	}
}
