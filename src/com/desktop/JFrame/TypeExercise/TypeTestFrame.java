package com.desktop.JFrame.TypeExercise;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.duolingo.model.Exercice;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;

public class TypeTestFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton lastButton = new JButton();

	public TypeTestFrame(Exercice exercice) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 593, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel enunciado = new JLabel("Pregunta");
		enunciado.setText(exercice.getWord1());
		
		JButton respuesta1 = new JButton("Respuesta 1");
		respuesta1.setText(exercice.getWord2());
		respuesta1.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {lastButton = respuesta1;}});

		JButton respuesta2 = new JButton("Respuesta 2");
		respuesta2.setText(exercice.getWord3());
		respuesta2.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {lastButton = respuesta2;}});
		
		JButton respuesta3 = new JButton("Respuesta 3");
		respuesta3.setText(exercice.getWord4());
		respuesta3.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {lastButton = respuesta3;}});
		
		JButton comprobarBoton = new JButton("Comprobar Respuesta");
		comprobarBoton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				respuesta1.setBackground(null);
				respuesta2.setBackground(null);
				respuesta3.setBackground(null);
				if(lastButton == respuesta1) {
					respuesta1.setBackground(Color.GREEN);
				}if(lastButton == respuesta2) {
					respuesta2.setBackground(Color.RED);
				}if(lastButton == respuesta3) {
					respuesta3.setBackground(Color.RED);
				}
				revalidate();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(205)
					.addComponent(comprobarBoton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(221))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(enunciado, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
						.addComponent(respuesta1, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
						.addComponent(respuesta3, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
						.addComponent(respuesta2, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
					.addGap(50))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addComponent(enunciado)
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addComponent(respuesta1)
					.addGap(18)
					.addComponent(respuesta2)
					.addGap(18)
					.addComponent(respuesta3)
					.addGap(67)
					.addComponent(comprobarBoton)
					.addGap(67))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
