package com.desktop.JPanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class AdministerCourses extends JPanel {

	public AdministerCourses() {
		
		JPanel courseSelectorPanel = new JPanel();
		
		JLabel lblCursSelectorTitle = new JLabel("Cursos existentes (filtrar por origen y/o destino)");
		
		JLabel lblListCourses = new JLabel("Cursos\r\n");
		
		JList listCourses = new JList();
		
		JLabel lblListCategories = new JLabel("Categorias del curso seleccionado");
		
		JList listCategories = new JList();
		
		JList listLevels = new JList();
		
		JLabel lblListLevels = new JLabel("Niveles de categor\u00EDa seleccionada");
		
		JButton btnAddCategory = new JButton("A\u00F1adir categoria");
		
		JButton btnAddLevel = new JButton("A\u00F1adir nivel");
		
		JButton btnAddExercice = new JButton("A\u00D1ADIR PREGUNTA");
		
		JButton btnShowExercice = new JButton("VISUALIZAR PREGUNTAS");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(courseSelectorPanel, GroupLayout.PREFERRED_SIZE, 689, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCursSelectorTitle)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnAddExercice, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(lblListCourses)
										.addGap(191)
										.addComponent(lblListCategories, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(listCourses, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
										.addGap(43)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(btnAddCategory, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(listCategories, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))))
								.addGap(43)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btnAddLevel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblListLevels, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(listLevels, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))))
						.addComponent(btnShowExercice, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblCursSelectorTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(courseSelectorPanel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListCourses)
						.addComponent(lblListCategories)
						.addComponent(lblListLevels))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(listCategories, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
						.addComponent(listLevels, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
						.addComponent(listCourses, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddCategory)
						.addComponent(btnAddLevel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAddExercice)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnShowExercice)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		
		JLabel lblOriginLanguage = new JLabel("Idioma de origen");
		
		JComboBox comboBoxOriginLanguage = new JComboBox();
		
		JLabel lblDestinationLanguage = new JLabel("Idioma de destino");
		
		JComboBox comboBoxDestinationLanguage = new JComboBox();
		
		JButton btnApplyFilter = new JButton("Aplicar filtro");
		
		JButton btnCreateCourse = new JButton("Crear curso");
		GroupLayout gl_courseSelectorPanel = new GroupLayout(courseSelectorPanel);
		gl_courseSelectorPanel.setHorizontalGroup(
			gl_courseSelectorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_courseSelectorPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_courseSelectorPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOriginLanguage)
						.addGroup(gl_courseSelectorPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(comboBoxOriginLanguage, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
					.addGap(66)
					.addGroup(gl_courseSelectorPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDestinationLanguage, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_courseSelectorPanel.createSequentialGroup()
							.addComponent(comboBoxDestinationLanguage, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addGroup(gl_courseSelectorPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCreateCourse, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnApplyFilter, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		gl_courseSelectorPanel.setVerticalGroup(
			gl_courseSelectorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_courseSelectorPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_courseSelectorPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOriginLanguage)
						.addComponent(lblDestinationLanguage))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_courseSelectorPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxOriginLanguage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxDestinationLanguage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnApplyFilter))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCreateCourse)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		courseSelectorPanel.setLayout(gl_courseSelectorPanel);
		setLayout(groupLayout);

	}
}
