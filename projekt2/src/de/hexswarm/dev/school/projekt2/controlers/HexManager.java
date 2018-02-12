package de.hexswarm.dev.school.projekt2.controlers;

import java.awt.CardLayout;
import java.awt.Container;
import java.util.Stack;

import javax.swing.JPanel;

import de.hexswarm.dev.school.projekt2.views.HexCard;

public class HexManager {
	private Stack<HexCard> _stack = new Stack<HexCard>();
	private Container _pane;
	private JPanel _cards;
	
	public HexManager(Container pane)	{
		_pane = pane;
		_cards = new JPanel(new CardLayout());
		_pane.add(_cards);
	}

	public void Push(HexCard hexCard) {
		if(!_stack.contains(hexCard)) {
			System.out.println("Pushing '" + hexCard.GetName() + "' to Stack.");
			_stack.push(hexCard);
			
			_cards.add(_stack.peek(), _stack.peek().getName());
			
			CardLayout cl = (CardLayout)(_cards.getLayout());
			cl.show(_cards, _stack.peek().GetName());
		}
		else {
			System.out.println("HexCard '" + hexCard.GetName() + "' already exsists.");
		}
	}

	public void Pop(HexCard hexCard) {
		_stack.pop();
		CardLayout cl = (CardLayout)(_cards.getLayout());
		cl.show(_stack.peek(), _stack.peek().GetName());
	}
}
