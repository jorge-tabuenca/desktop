package com.desktop.JFrame.TypeExercise;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import com.duolingo.model.Exercice;
import javax.swing.JTextField;
import java.awt.Font;

public class TypeOpenTranslationFrame extends JFrame {

	private JPanel contentPane;
	private JButton lastButton = new JButton();
	private JTextField introduceText;
	
	public TypeOpenTranslationFrame(Exercice exercice) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 608, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		introduceText = new JTextField();
		
		JLabel enunciado = new JLabel("Frase a Traducir:", SwingConstants.CENTER);
		enunciado.setText(exercice.getWord1());
		
		JButton comprobarBoton = new JButton("Comprobar Respuesta");
		comprobarBoton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String respuesta = introduceText.getText().replaceAll("[.:,;!\"·$%&/()=?¿¡]", "").replaceAll("[\\s]+", " ").toLowerCase();
				
				String[] correctas = exercice.getWord2().split("//");
				
				int x = 0;

				for(int i = 0; i < correctas.length; i ++) {
					if(correctas[i].equalsIgnoreCase(respuesta)) {
						introduceText.setBackground(Color.GREEN);
						x = 1;
					}
				}
				if(x == 0) {
					introduceText.setBackground(Color.RED);
				}
				revalidate();
			}
		});
				
		introduceText.setColumns(10);
		
		JLabel textFixed = new JLabel("Traduce esta frase:");
		textFixed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(205)
					.addComponent(comprobarBoton, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
					.addGap(221))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFixed, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
						.addComponent(enunciado, GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(introduceText, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
							.addGap(8)))
					.addGap(22))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addComponent(textFixed)
					.addGap(47)
					.addComponent(enunciado)
					.addGap(49)
					.addComponent(introduceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
					.addComponent(comprobarBoton)
					.addGap(67))
		);
		contentPane.setLayout(gl_contentPane);
	}
}