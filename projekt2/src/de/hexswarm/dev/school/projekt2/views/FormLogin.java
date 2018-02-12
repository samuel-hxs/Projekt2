package de.hexswarm.dev.school.projekt2.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Make Every form a sub of panel or pane for CardLayout
public class FormLogin extends HexForm implements ItemListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6716236714497931624L;

	private final static String BUTTONPANEL = "Card with JButtons";
	private final static String TEXTPANEL = "Card with JTextField";
	private JPanel cards;
	
	public FormLogin(String name) {
		super(name);

		JPanel comboBoxPane = new JPanel(); 
        String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
        JComboBox<String> cb = new JComboBox<String>(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
        //Create the "cards".
        // TODO: Use BoxPanLayout or some similar for scaling
        JPanel pnl_splash = new JPanel();
        pnl_splash.add(new JButton("Button 1"));
        pnl_splash.add(new JButton("Button 2"));
        pnl_splash.add(new JButton("Button 3"));
         
        JPanel pnl_login = new JPanel();
        pnl_login.add(new JTextField("TextField", 20));
        
		//Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(pnl_splash, BUTTONPANEL);
        cards.add(pnl_login, TEXTPANEL);
         
        Container pane = this.getContentPane();
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
	}

	@Override
	public void itemStateChanged(ItemEvent evt) {
		CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
	}

}
