package com.desktop.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.duolingo.interfaces.IExercice;
import com.duolingo.interfaces.impl.ExerciceImpl;
import com.duolingo.model.Exercice;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;

public class ShowExerciceFrame extends JFrame {

	IExercice exerciceManager = new ExerciceImpl();

	public ShowExerciceFrame(int categoryID) {
				
		List<Exercice> exerciceList = exerciceManager.getAllExerciceByCategoryId(categoryID);

		setSize(700,300);
		setResizable(false);
	    setPreferredSize(new Dimension(300, 700));
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setVisible(true);
		
		JPanel bottonPanel = new JPanel();
		bottonPanel.setLayout(new GridLayout(0, 1));
		
		//Creacion todos los botones de todos los ejercicios
		for(Exercice exercice : exerciceList) {
		
			String typeExcercie = getTypeExcerciceName(exercice);
			JButton exerciceButton = new JButton(exercice.getWord1() + " " + typeExcercie);
			exerciceButton.setPreferredSize(new Dimension(660, 50));
			bottonPanel.add(exerciceButton);
		}
		
		JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	    container.add(bottonPanel);
	    JScrollPane scrollPane = new JScrollPane(container);
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    getContentPane().add(scrollPane);
	}
	
	//Ya que nosotros en la BBDD tratamos el tipo dejercicio con valores enteros el tipo de
	//ejercicio aqui lo transfiguramos para obtener el nombre de este
	public String getTypeExcerciceName(Exercice exercice) {
		String typeExcercie = "";
		
		switch (exercice.getCategory()) {
			case 1:
				typeExcercie = "Ex.Trad.Lliure";
			break;	
			case 2:
				typeExcercie = "Test";
			break;			
		}
		return typeExcercie;
	}
}
