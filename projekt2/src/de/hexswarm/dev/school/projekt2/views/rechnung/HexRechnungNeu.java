package de.hexswarm.dev.school.projekt2.views.rechnung;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import de.hexswarm.dev.school.projekt2.HexKonfiguration;
import de.hexswarm.dev.school.projekt2.controlers.HexCardManager;
import de.hexswarm.dev.school.projekt2.models.Artikel;
import de.hexswarm.dev.school.projekt2.models.Rechnung;
import de.hexswarm.dev.school.projekt2.views.HexCard;

public class HexRechnungNeu extends HexCard {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8435556578146148470L;

	public HexRechnungNeu(HexCardManager manager) {
		super(manager);
		_name = "HexRechnungNez";
		Rechnung r  = new Rechnung(null, _manager.getKonfiguration().getNutzer(), new LinkedList());
		
		// Layout
		setLayout(null);
		JLabel lbl_kunde = new JLabel("Kunde:");
		lbl_kunde.setBounds(10, 10, 410, 40);
        add(lbl_kunde);
        
		JTextField txt_kunde = new JTextField();
		txt_kunde.setBounds(10, 45, 370, 40);
		add(txt_kunde);
		
//		JLabel lbl_nutzer = new JLabel("Berarbeiter");
//		lbl_nutzer.setBounds(10, 80, 240, 40);
//        add(lbl_nutzer);
//		
//        JLabel lbl_nutzer_value = new JLabel(_manager.getKonfiguration().getNutzer().GetName());
//		lbl_nutzer_value.setBounds(240, 80, 240, 40);
//        add(lbl_nutzer_value);

		setLayout(null);
		JLabel lbl_artikel_search = new JLabel("Artikel:");
		lbl_artikel_search.setBounds(10, 90, 410, 40);
        add(lbl_artikel_search);
        
		JTextField txt_artikel_search = new JTextField();
		txt_artikel_search.setBounds(10, 125, 370, 40);
		add(txt_artikel_search);
        
		JLabel lbl_artikel = new JLabel("Alle Artikel");
		lbl_artikel.setBounds(10, 160, 170, 40);
		add(lbl_artikel);
		
//		JLabel lbl_artikel_2 = new JLabel("Bestellte Artikel");
//		lbl_artikel_2.setBounds(190, 160, 170, 40);
//		add(lbl_artikel_2);
		
		DefaultListModel arts = new DefaultListModel();
		JList<String> list_artikel = new JList(arts);
		LinkedList arters = r.getArtikels();
		for (int i = 0; i < arters.size(); i++) {
			arts.addElement(arters.get(i));
		}
		list_artikel.setBounds(10, 200, 370, 310);
		add(list_artikel);

//		DefaultListModel artser = new DefaultListModel();
//		JList<String> list_artikel_touse = new JList(artser);
//		LinkedList arterser = r.getArtikels();
//		for (int i = 0; i < arters.size(); i++) {
//			artser.addElement(arters.get(i));
//		}
//		list_artikel_touse.setBounds(190, 200, 170, 310);
//		add(list_artikel_touse);
		
		JButton btn_zurück = new JButton();
		btn_zurück.setBounds(10, 520, 170, 40);
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
		
		JButton btn_hinzufügen = new JButton();
		btn_hinzufügen.setBounds(210, 520, 170, 40);
		btn_hinzufügen.setText("Abschließen");
		btn_hinzufügen.setBackground(Color.GREEN);
		btn_hinzufügen.setForeground(Color.WHITE);
		btn_hinzufügen.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_hinzufügen.setFocusPainted(false);
		btn_hinzufügen.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		});
		add(btn_hinzufügen);
	}
}
