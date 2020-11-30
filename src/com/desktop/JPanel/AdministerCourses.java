package com.desktop.JPanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.duolingo.interfaces.ILanguage;
import com.duolingo.interfaces.impl.LanguageImpl;
import com.duolingo.model.Course;
import com.duolingo.model.Language;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class AdministerCourses extends JPanel {

	public AdministerCourses() {
		
		ILanguage languageManager = new LanguageImpl();
		List<Language> languages = languageManager.getAllLanguages();	
		
		JPanel courseSelectorPanel = new JPanel();
		
		JLabel lblCursSelectorTitle = new JLabel("Cursos existentes (filtrar por origen y/o destino)");
		
		JLabel lblListCourses = new JLabel("Cursos\r\n");
		
		DefaultListModel<String> dlmCourses = new DefaultListModel<>();
		JList<String> listCourses = new JList<>(dlmCourses);
		
		JLabel lblListCategories = new JLabel("Categorias del curso seleccionado");

		DefaultListModel<String> dlmCategories = new DefaultListModel<>();
		JList<String> listCategories = new JList<>(dlmCategories);
		
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
							.addComponent(courseSelectorPanel, GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblCursSelectorTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(457))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btnAddExercice, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(listCourses, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
												.addGap(43))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblListCourses, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
												.addGap(132)))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
													.addComponent(btnAddCategory, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
													.addComponent(listCategories, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
												.addGap(43))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblListCategories, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
												.addGap(18)))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(btnAddLevel, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
											.addComponent(lblListLevels, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
											.addComponent(listLevels, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))))
								.addGap(60))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnShowExercice, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
								.addGap(60)))
						.addGap(18))
		);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(28)
						.addComponent(lblCursSelectorTitle)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(courseSelectorPanel, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblListCourses)
							.addComponent(lblListLevels)
							.addComponent(lblListCategories))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(listCategories, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
							.addComponent(listLevels, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
							.addComponent(listCourses, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAddCategory)
							.addComponent(btnAddLevel))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnAddExercice)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnShowExercice)
						.addGap(45))
		);
		
		JLabel lblOriginLanguage = new JLabel("Idioma de origen");
		
		JComboBox comboBoxOriginLanguage = new JComboBox();
		comboBoxOriginLanguage.setModel(new DefaultComboBoxModel(new String[] {"Selecciona Idioma"}));
		
		for (Language l : languages) {
			comboBoxOriginLanguage.addItem(l.getName());
		}
		
		JLabel lblDestinationLanguage = new JLabel("Idioma de destino");		
		
		JComboBox comboBoxDestinationLanguage = new JComboBox();
		comboBoxDestinationLanguage.setModel(new DefaultComboBoxModel(new String[] {"Selecciona Idioma"}));
		
		for (Language l : languages) {
			comboBoxDestinationLanguage.addItem(l.getName());
		}
		
		JButton btnCreateCourse = new JButton("Crear curso");
		btnCreateCourse.setEnabled(false);
		
		JButton btnApplyFilter = new JButton("Aplicar filtro");
		btnApplyFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Language languageOrigin = new Language();
				Language languageDestination = new Language();
				
				// Borra todos los cursos que hayan en la lista al efectuar el fitro.
				dlmCourses.removeAllElements();
				
				for(Language l : languages) {
					if(l.getId() == comboBoxOriginLanguage.getSelectedIndex()+1) {
						languageOrigin = l;
					}					
				}
				for(Language l : languages) {
					if(l.getId() == comboBoxDestinationLanguage.getSelectedIndex()+1) {
						languageDestination = l;
					}					
				}
				
				// Añadira todos los cursos que coincidan con el fitro establecido
				
				/*for(Course course : languageOrigin.getCourses()) {
					if(languageOrigin.getName().equals(languageDestination.getName())) {
						listCourses.add(course.getName());
					}
				}*/	
				
				// Una vez añadidos todos los cursos se ejecutará esta función, si al final no se
				// ha añadido ningun curso esta habilitará el botón bnCreateCourse.
				// Dentro de ella se encargará de añadir el curso a la JList y a la BBDD
				checkCourses(dlmCourses, btnCreateCourse);
			}
		});
		
		GroupLayout gl_courseSelectorPanel = new GroupLayout(courseSelectorPanel);
		gl_courseSelectorPanel.setHorizontalGroup(
				gl_courseSelectorPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_courseSelectorPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_courseSelectorPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_courseSelectorPanel.createSequentialGroup()
								.addComponent(lblOriginLanguage)
								.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE))
							.addGroup(gl_courseSelectorPanel.createSequentialGroup()
								.addGap(10)
								.addComponent(comboBoxOriginLanguage, 0, 162, Short.MAX_VALUE)))
						.addGap(66)
						.addGroup(gl_courseSelectorPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_courseSelectorPanel.createSequentialGroup()
								.addComponent(lblDestinationLanguage, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
								.addGap(269))
							.addGroup(gl_courseSelectorPanel.createSequentialGroup()
								.addComponent(comboBoxDestinationLanguage, 0, 162, Short.MAX_VALUE)
								.addGap(58)
								.addGroup(gl_courseSelectorPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(btnCreateCourse, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
									.addComponent(btnApplyFilter, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))))
						.addGap(67))
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
	
	public void checkCourses(DefaultListModel<String> dlmCourses, JButton btnCreateCourse) {
        if (dlmCourses.getSize() == 0) {
            btnCreateCourse.setEnabled(true);
            btnCreateCourse.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Crea CURS con IDIOMA DESTÍ + IDIOMA ORIGEN
                    dlmCourses.addElement("Aqui va el curso");
                    btnCreateCourse.setEnabled(false);
                }
            });
        }

    }
}