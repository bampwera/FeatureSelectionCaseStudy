package project.dmkm.feature.visuals;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JPopupMenu;

import prefuse.controls.ControlAdapter;
import prefuse.controls.Control;
import prefuse.visual.NodeItem;
import prefuse.visual.VisualItem;

public class FinalControlListener extends ControlAdapter implements Control {

	

	@Override
	public void itemClicked(VisualItem item, MouseEvent e) {
		if(item instanceof NodeItem)
		{
			JPopupMenu popup = new JPopupMenu();
			popup.add("Name of Authors");
			popup.show(e.getComponent(), (int) item.getX(),(int)item.getY());
		}

	}

	
}
