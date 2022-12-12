package catTrap;

import java.awt.Color;

import javax.swing.JButton;

public class TileButton extends JButton {

	private int row;
	private int column;
	private TrapModel model;
	
	public TileButton(TrapModel model, int row, int column)
	{
		this.model = model;
		this.row = row;
		this.column = column;
		checkPiece();
	}
	
	public void checkPiece()
	{
		if(model.catAt(this.getRow(), this.getCol()))
		{
			this.setText("cat");
			this.setBackground(Color.red);
		}
		
		if(model.barrierAt(this.getRow(), this.getCol()))
		{
			this.setText("barrier");
			this.setBackground(Color.green);
		}
	}
	
	public int getRow() 
	{
		return row;
	}
	
	public int getCol() 
	{
		return column;
	}
}
