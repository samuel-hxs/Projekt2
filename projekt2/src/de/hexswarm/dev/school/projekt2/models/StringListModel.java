package de.hexswarm.dev.school.projekt2.models;

import java.util.LinkedList;

import javax.swing.AbstractListModel;

public class StringListModel extends AbstractListModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4748132192062008832L;
	private LinkedList<String> _list;

	public StringListModel(LinkedList<String> list) {
	    _list = list;
	}
	
	public int getSize() {
	    return _list.size();
	}
	
	public Object getElementAt(int n) {
	    return _list.get(n);
	}
}
