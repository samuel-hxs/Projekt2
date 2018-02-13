package de.hexswarm.dev.school.projekt2.views;

import javax.swing.JPanel;

import de.hexswarm.dev.school.projekt2.controlers.HexCardManager;

public class HexCard extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 252845380818170971L;
	protected HexCardManager _manager;
	protected String _name;
	
	public HexCard(HexCardManager manager) {
		_manager = manager;
	}
	
	public void Push() {
		_manager.Push(this);
	}
	
	public void Pop() {
		_manager.Pop(this);
	}
	
	public String GetName() {
		return _name;
	}

	public void SetManager(HexCardManager manager) {
		_manager = manager;
	}
}
