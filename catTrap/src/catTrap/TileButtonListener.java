package catTrap;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TileButtonListener implements ActionListener {

	private TrapModel model;
	private TrapView view;
	private TileButton tile;
	
	public TileButtonListener(TrapModel model, TrapView view,
			TileButton tb)
	{
		this.model = model;
		this.view = view;
		this.tile = tb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(!model.catAt(tile.getRow(), tile.getCol())) 
		{
			model.addBarrier(tile.getRow(),tile.getCol());
			tile.setBackground(Color.green);
			tile.setText("barrier");
		}
		
		model.updateCat();
		view.updateUI();
	}

}
