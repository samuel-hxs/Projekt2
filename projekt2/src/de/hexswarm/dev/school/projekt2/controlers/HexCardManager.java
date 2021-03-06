package de.hexswarm.dev.school.projekt2.controlers;

import java.awt.CardLayout;
import java.awt.Container;
import java.util.Stack;

import javax.swing.JPanel;

import de.hexswarm.dev.school.projekt2.HexKonfiguration;
import de.hexswarm.dev.school.projekt2.views.HexCard;
import de.hexswarm.dev.school.projekt2.views.HexForm;

public class HexCardManager {
	private HexKonfiguration _konf;
	private Stack<HexCard> _stack = new Stack<HexCard>();
	private HexForm _form;
	private JPanel _cards;
	
	public HexCardManager(HexForm form, HexKonfiguration konf)	{
		_konf = konf;
		_form = form;
		_cards = new JPanel(new CardLayout());
		_form.getContentPane().add(_cards);
	}

	public void Push(HexCard hexCard) {
		if(!_stack.contains(hexCard)) {
			//System.out.println("Pushing '" + hexCard.GetName() + "' to stack.");
			
			_stack.push(hexCard);
			_cards.add(hexCard, hexCard.GetName());
			
			CardLayout cl = (CardLayout)(_cards.getLayout());
			cl.show(_cards, hexCard.GetName());
			//cl.last(_cards);
		}
		else {
			//System.out.println("HexCard '" + hexCard.GetName() + "' already exsists.");

			CardLayout cl = (CardLayout)(_cards.getLayout());
			cl.show(_cards, _stack.peek().GetName());
		}
	}

	public void Pop(HexCard hexCard) {
		if(_stack.size() <= 0) {
			System.out.println("Fehler im UI Stack.");
			return;
		}
		
		if(!_stack.contains(hexCard))
		{
			System.out.println("Object nicht im Stack. Wurde Push benutzt?");
			return;
		}
		
		_stack.remove(hexCard);
		CardLayout cl = (CardLayout)(_cards.getLayout());
		cl.show(_cards, _stack.peek().GetName());
	}

	public HexKonfiguration getKonfiguration() {
		return _konf;
	}
}
