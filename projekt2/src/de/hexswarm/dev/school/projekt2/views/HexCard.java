package de.hexswarm.dev.school.projekt2.views;

import javax.swing.JPanel;

import de.hexswarm.dev.school.projekt2.controlers.HexManager;

public class HexCard extends JPanel {
	private HexManager _manager;
	protected String _name;
	
	public HexCard(HexManager manager) {
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
}
