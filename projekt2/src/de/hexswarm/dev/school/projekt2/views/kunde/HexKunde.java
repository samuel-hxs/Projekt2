package de.hexswarm.dev.school.projekt2.views.kunde;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import de.hexswarm.dev.school.projekt2.controlers.HexCardManager;
import de.hexswarm.dev.school.projekt2.models.Rückgabe;
import de.hexswarm.dev.school.projekt2.models.StringListModel;
import de.hexswarm.dev.school.projekt2.views.HexCard;

public class HexKunde extends HexCard {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5534156334935396424L;
	private JList<String> lst_kunden;
	private JLabel lbl_kunde;
    private LinkedList<String> _model = new LinkedList<String>();
	
	public HexKunde(HexCardManager manager) {
		super(manager);
		_name = "Kunde";

		// Layout
		setLayout(null);
		setBackground(Color.WHITE);

		lbl_kunde = new JLabel("Info");
		lbl_kunde.setBounds(15, 65, 330, 600);
		lbl_kunde.setVisible(false);
		lbl_kunde.setBackground(Color.RED);
		lbl_kunde.setOpaque(true);
		add(lbl_kunde);
		
        JLabel label = new JLabel("Kunden:");
        label.setBounds(10, 10, 340, 40);
        label.setLabelFor(lst_kunden);
        add(label);
		
		lst_kunden = new JList<String>(new StringListModel(_model));
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
		
		doAbfrage();
	}

	private void doAbfrage() {
		String template = "SELECT * FROM kunde";
    	
    	String statement = String.format(template, "");
    	_manager.getKonfiguration().getDBManager().doStatement(statement);
    	
    	Rückgabe rg = null;
    	if(rg == null) {
    		return;
    	}
    	
    	if(rg.isErfolreich()) {
    		LinkedList<LinkedList<Object>> reihen = rg.getReihen();
    		_model.add(reihen.get(0).get(0).toString());
    	}
    	else {
    		System.out.println("Auslesen der Kunden fehlgeschlagen!");
    		lbl_kunde.setText("Auslesen der Kunden ist fehlgeschlagen!");
    		lbl_kunde.setVisible(true);
    	}
	}
}
