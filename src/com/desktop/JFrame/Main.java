package com.desktop.JFrame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
	    
	    JFrame f = new JFrame();
	    f.setSize(700,300);
	    f.setPreferredSize(new Dimension(300, 700));
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	    JPanel panel = new JPanel();

	    panel.setLayout(new GridLayout(0, 1));
	    for (int i = 0; i < 10 ; i++) {
	      JButton button = new JButton(String.valueOf(i));
	      button.setPreferredSize(new Dimension(700, 50));
	      panel.add(button);
	    }
	    JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	    container.add(panel);
	    JScrollPane scrollPane = new JScrollPane(container);
	    f.getContentPane().add(scrollPane);

	    f.setLocationRelativeTo(null);
	    f.setVisible(true);
	  }
}
