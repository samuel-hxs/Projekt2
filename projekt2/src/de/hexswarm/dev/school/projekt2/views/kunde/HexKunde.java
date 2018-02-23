package de.hexswarm.dev.school.projekt2.views.kunde;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import de.hexswarm.dev.school.projekt2.controlers.HexCardManager;
import de.hexswarm.dev.school.projekt2.views.HexCard;

public class HexKunde extends HexCard {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5534156334935396424L;
	private JList list;
	
	public HexKunde(HexCardManager manager) {
		super(manager);
		_name = "Kunde";

		// Layout
		LinkedList<String> model = new LinkedList<String>();
		model.add("Käsekuchen Hellblau 60cm");
		
		list = new JList(model.toArray());
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
       
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        listScroller.setAlignmentX(LEFT_ALIGNMENT);
        
        JLabel label = new JLabel("Artikel");
        label.setLabelFor(list);
        
		JButton btn_zurück = new JButton();
		btn_zurück.setText("Zurück");
		btn_zurück.setBackground(Color.RED);
		btn_zurück.setForeground(Color.WHITE);
		btn_zurück.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn_zurück.setFocusPainted(false);
		btn_zurück.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Pop();
		    }
		});
		
        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        listPane.add(label);
        listPane.add(Box.createRigidArea(new Dimension(0,5)));
        listPane.add(listScroller);
        listPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		listPane.add(btn_zurück, BorderLayout.PAGE_END);
		add(listPane, BorderLayout.SOUTH);
	}
}
