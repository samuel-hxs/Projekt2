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
import de.hexswarm.dev.school.projekt2.models.StringListModel;
import de.hexswarm.dev.school.projekt2.views.HexCard;

public class HexKunde extends HexCard {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5534156334935396424L;
	private JList<String> lst_kunden;
	
	public HexKunde(HexCardManager manager) {
		super(manager);
		_name = "Kunde";

		// Layout
		setLayout(null);
		setBackground(Color.WHITE);

        JLabel label = new JLabel("Kunden:");
        label.setBounds(10, 10, 340, 40);
        label.setLabelFor(lst_kunden);
        add(label);
        
		LinkedList<String> model = new LinkedList<String>();
		model.add("Käsekuchen Hellblau 60cm");
		
		lst_kunden = new JList<String>(new StringListModel(model));
        lst_kunden.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        lst_kunden.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        lst_kunden.setVisibleRowCount(-1);
       
        JScrollPane lsp_kunden = new JScrollPane(lst_kunden);
        lsp_kunden.setPreferredSize(new Dimension(250, 80));
        lsp_kunden.setAlignmentX(LEFT_ALIGNMENT);
        lsp_kunden.setBounds(10, 60, 340, 240);
        add(lsp_kunden);
        
		JButton btn_zurück = new JButton();
        btn_zurück.setBounds(10, 310, 100, 40);
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
		add(btn_zurück);
		        
		JButton btn_edit = new JButton();
        btn_edit.setBounds(120, 310, 120, 40);
		btn_edit.setText("Berabeiten");
		btn_edit.setBackground(Color.BLUE);
		btn_edit.setForeground(Color.WHITE);
		btn_edit.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn_edit.setFocusPainted(false);
		btn_edit.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new HexKundeBearbeiten(_manager).Push();
		    }
		});
		add(btn_edit);
        
		JButton btn_neu = new JButton();
        btn_neu.setBounds(250, 310, 100, 40);
		btn_neu.setText("Erstellen");
		btn_neu.setBackground(Color.GREEN);
		btn_neu.setForeground(Color.WHITE);
		btn_neu.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn_neu.setFocusPainted(false);
		btn_neu.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new HexKundeNeu(_manager).Push();
		    }
		});
		add(btn_neu);
	}
}
