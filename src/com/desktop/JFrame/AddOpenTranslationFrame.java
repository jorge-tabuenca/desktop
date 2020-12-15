package com.desktop.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.duolingo.interfaces.IExercice;
import com.duolingo.interfaces.impl.ExerciceImpl;
import com.duolingo.model.Exercice;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class AddOpenTranslationFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private List<JTextField> options = new ArrayList<>();
	private String enunciado;
	private String opcionesSeparadas;

	public AddOpenTranslationFrame(int categoryID) {
		
		IExercice exerciceManager = new ExerciceImpl();
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 721, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel title = new JLabel("Ejercicio tipo traduccion abierta");
		title.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel originPhrase = new JLabel("Frase Origen:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		
		JPanel phrases = new JPanel();
		
		JButton addPhrase = new JButton("Agregar Posible Frase");
		
		JButton addExercice = new JButton("Aceptar");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(title, GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(originPhrase)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(144)
					.addComponent(addPhrase)
					.addPreferredGap(ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
					.addComponent(addExercice)
					.addGap(145))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(title, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(originPhrase)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(addPhrase)
						.addComponent(addExercice))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane(phrases);
		phrases.setLayout(new BoxLayout(phrases, BoxLayout.Y_AXIS));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		addPhrase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTextField newPhrase = new JTextField();
				newPhrase.setPreferredSize(new Dimension(660, 50));
				options.add(newPhrase);
				phrases.add(newPhrase);
				revalidate();
			}
		});
		
		addExercice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				opcionesSeparadas = "";
				for(int i = 0; i < options.size(); i++) {
					opcionesSeparadas = opcionesSeparadas + options.get(i).getText() + "||";
		        }			
				
				Exercice exercice = new Exercice();
				
				exercice.setCategory(categoryID);
				exercice.setStatus(1);
				exercice.setTypeExercice(1);
				exercice.setWord1(enunciado = textField.getText());
				exercice.setWord2(opcionesSeparadas);
				
				exerciceManager.insertExercice(exercice);
				
				System.out.println(enunciado);
				System.out.println(opcionesSeparadas);
				dispose();
			}
		});
		
		panel.add(scrollPane, BorderLayout.CENTER);
		revalidate();
		contentPane.setLayout(gl_contentPane);
		
	}
}
