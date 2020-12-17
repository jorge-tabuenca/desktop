package com.desktop.JFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.duolingo.interfaces.ICategory;
import com.duolingo.interfaces.IExercice;
import com.duolingo.interfaces.impl.CategoryImpl;
import com.duolingo.interfaces.impl.ExerciceImpl;
import com.duolingo.model.Exercice;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddTestExerciceFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldOriginalSentence;
	private JTextField textField_TranslatedSentence;
	private JTextField textFieldIncorrectSentence1;
	private JTextField textFieldIncorrectSentence2;
	ICategory categoryManager = new CategoryImpl();

	public AddTestExerciceFrame(int categoryID) {
		
		IExercice exerciceManager = new ExerciceImpl();
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 605, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblExerciceContentTitle = new JLabel("Ejercicio tipo test");
		lblExerciceContentTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblOriginalSentence = new JLabel("Frase a traducir:");
		
		JLabel lblTranslatedSentence = new JLabel("Frase traducida:");
		
		JLabel lblIncorrectSentence1 = new JLabel("Frase erronea 1:");
		
		JLabel lblIncorrectSentence2 = new JLabel("Frase erronea 2:");
		
		textFieldOriginalSentence = new JTextField();
		textFieldOriginalSentence.setColumns(10);
		
		textField_TranslatedSentence = new JTextField();
		textField_TranslatedSentence.setColumns(10);
		
		textFieldIncorrectSentence1 = new JTextField();
		textFieldIncorrectSentence1.setColumns(10);
		
		textFieldIncorrectSentence2 = new JTextField();
		textFieldIncorrectSentence2.setColumns(10);
		
		JButton btnExerciceToDDBB = new JButton("A\u00F1adir Ejercicio");
		btnExerciceToDDBB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String original = textFieldOriginalSentence.getText();
				String correct = textField_TranslatedSentence.getText();
				String incorrect1 = textFieldIncorrectSentence1.getText();
				String incorrect2 = textFieldIncorrectSentence2.getText();
				
				Exercice exercice = new Exercice();
				
				exercice.setCategory(categoryID);
				exercice.setStatus(1);
				exercice.setTypeExercice(2);
				exercice.setWord1(original);
				exercice.setWord2(correct);
				exercice.setWord3(incorrect1);
				exercice.setWord4(incorrect2);

				exerciceManager.insertExercice(exercice);
				dispose();
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnExerciceToDDBB, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblIncorrectSentence1, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
								.addComponent(lblTranslatedSentence, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblOriginalSentence, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblIncorrectSentence2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(39)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblExerciceContentTitle)
								.addComponent(textFieldOriginalSentence, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_TranslatedSentence, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldIncorrectSentence1, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldIncorrectSentence2, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE))))
					.addGap(35))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblExerciceContentTitle)
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOriginalSentence)
						.addComponent(textFieldOriginalSentence, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTranslatedSentence)
						.addComponent(textField_TranslatedSentence, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIncorrectSentence1)
						.addComponent(textFieldIncorrectSentence1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldIncorrectSentence2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIncorrectSentence2))
					.addGap(18)
					.addComponent(btnExerciceToDDBB, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
					.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
