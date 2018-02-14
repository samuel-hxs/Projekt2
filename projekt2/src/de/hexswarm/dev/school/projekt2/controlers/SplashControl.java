package de.hexswarm.dev.school.projekt2.controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.hexswarm.dev.school.projekt2.views.HexLogin;

public class SplashControl implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
    	new HexLogin(null);
    }
}
