package de.hexswarm.dev.school.projekt2;

import javax.swing.JFrame;

import de.hexswarm.dev.school.projekt2.views.HexForm;

public class Main {

	public static void main(String[] args) {
		HexKonfiguration konf = new HexKonfiguration();
		konf.Save();
		konf.Load();
		
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        		HexForm frm_main = new HexForm("Projekt2", konf);
        		frm_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		frm_main.setVisible(true);
            }
        });
	}

}
