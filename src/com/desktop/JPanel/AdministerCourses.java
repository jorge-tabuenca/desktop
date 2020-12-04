package com.desktop.JPanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.duolingo.interfaces.ICategory;
import com.duolingo.interfaces.ICourse;
import com.duolingo.interfaces.ILanguage;
import com.duolingo.interfaces.ILanguageCourse;
import com.duolingo.interfaces.impl.CategoryImpl;
import com.duolingo.interfaces.impl.CourseImpl;
import com.duolingo.interfaces.impl.LanguageCourseImpl;
import com.duolingo.interfaces.impl.LanguageImpl;
import com.duolingo.model.Category;
import com.duolingo.model.Course;
import com.duolingo.model.Language;
import com.duolingo.model.LanguageCourse;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class AdministerCourses extends JPanel {

	DefaultListModel<String> dlmCategories, dlmCourses;
	JList<String> listCategories, listCourses;
	JComboBox comboBoxOriginLanguage, comboBoxDestinationLanguage;
	JButton btnCreateCourse = new JButton();

	ILanguage languageManager = new LanguageImpl();
	ICourse courseManager = new CourseImpl();
	ICategory categoryManager = new CategoryImpl();
	ILanguageCourse languageCourseManager = new LanguageCourseImpl();

	
	public AdministerCourses() {		
		
		
		List<Language> languages = languageManager.getAllLanguages();	
		List<Course> courses = courseManager.getAllCourses();
		
		JPanel courseSelectorPanel = new JPanel();
			
		JLabel lblCursSelectorTitle = new JLabel("Cursos existentes (filtrar por origen y/o destino)");
		JLabel lblListCategories = new JLabel("Categorias del curso seleccionado");
		JLabel lblListLevels = new JLabel("Niveles de categor\u00EDa seleccionada");
		JLabel lblListCourses = new JLabel("Cursos\r\n");
		
		
		dlmCategories = new DefaultListModel<>();
		listCategories = new JList<>(dlmCategories);
		
		dlmCourses = new DefaultListModel<>();
		listCourses = new JList<>(dlmCourses);		
		listCourses.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
					dlmCategories.removeAllElements();
					
					int languageID = comboBoxOriginLanguage.getSelectedIndex();
					int courseID = comboBoxDestinationLanguage.getSelectedIndex();
					
					checkCategories(languageID, courseID);					
				}
			}
		});
		
		JList listLevels = new JList();		
		
		JButton btnAddCategory = new JButton("A\u00F1adir categoria");
		btnAddCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int languageID = comboBoxOriginLanguage.getSelectedIndex();
				int courseID = comboBoxDestinationLanguage.getSelectedIndex();
				
				addCategory(languageID, courseID);
				
			}
		});
		
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
		
		comboBoxOriginLanguage = new JComboBox();
		comboBoxOriginLanguage.setModel(new DefaultComboBoxModel(new String[] {"Selecciona Idioma"}));
		
		// Añade todos los idiomas disponibles en la BBDD al JComboBox
		for (Language l : languages) {
			comboBoxOriginLanguage.addItem(l.getName());
		}
		
		
		JLabel lblDestinationLanguage = new JLabel("Idioma de destino");		
		comboBoxDestinationLanguage = new JComboBox();
		comboBoxDestinationLanguage.setModel(new DefaultComboBoxModel(new String[] {"Selecciona Idioma"}));
		
		// Añade todos los idiomas disponibles en la BBDD al JComboBox
		for (Course c : courses) {
			comboBoxDestinationLanguage.addItem(c.getName());
		}
		
		btnCreateCourse.setText("Crear curso");
		btnCreateCourse.setEnabled(false);
		btnCreateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				short originLang = (short) comboBoxOriginLanguage.getSelectedIndex();
				short destLang = (short) comboBoxDestinationLanguage.getSelectedIndex();
				
				addCourse(originLang, destLang);
			}
		});
		
		
		JButton btnApplyFilter = new JButton("Aplicar filtro");
		btnApplyFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				short originLang = (short) comboBoxOriginLanguage.getSelectedIndex();
				short destLang = (short) comboBoxDestinationLanguage.getSelectedIndex();
												
				dlmCategories.removeAllElements();
				dlmCourses.removeAllElements();				
				checkCourses(originLang, destLang);
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
	
	
	private void checkCourses(short originLang, short destLang) {
		
		// checkCourses - Filtro CURSOS
		// QUERY donde filtra todos los CURSOS que cumplan con los 2 IDIOMAS
		// seleccionados en las JComboBox.
		// Añade el nombre del CURSO a la JList de CURSOS.
		
		System.out.println(originLang + " || " + destLang);
		List<LanguageCourse> courses =  languageCourseManager.getAllCourses(originLang, destLang);		
		
		System.out.println(courses.size());
		
		if (courses.size() == 0) {
            btnCreateCourse.setEnabled(true);
        }else {
    		// Si la QUERY SI obtiene coincidencias, desactiva el botón btnCreareCourse
        	// y añade todos los CURSOS a la JList
        	btnCreateCourse.setEnabled(false);
        	
        	// ## Falta x hacer FOREACH (Da error CastException o algo asi)
        	for (LanguageCourse lc : courses) {
				dlmCourses.addElement("CURSO - ["+comboBoxOriginLanguage.getItemAt(lc.getLanguage_ID()) + " // " + comboBoxDestinationLanguage.getItemAt(lc.getCourse_ID()) + "]");
				// idRelationCourseLanguage = lc.getId();
			}
    		// dlmCourses.addElement("CURSO - ["+comboBoxOriginLanguage.getItemAt(originLang) + " // " + comboBoxDestinationLanguage.getItemAt(destLang) + "]");
		}

    }
	
	private void addCourse(short originLang, short destLang) {
		
		// addCourse
		// Al pulsar btnCreateCourse se activa este método que añade
		// a la JList un ITEM haciendo referencia a los 2 idiomas
		// seleccionados en las JComboBox
		
		dlmCourses.removeAllElements();
		
		// Ejecuta el METODO HIBERNATE que añade el CURSO
		ILanguageCourse languageCourseManager = new LanguageCourseImpl();
		languageCourseManager.insertCourse(originLang, destLang);
		
		// Muestra el CURSO añadido en la JList, al volver a filtrar ya lo mostrará como parte de la BBDD
		dlmCourses.addElement("CURSO - [" + comboBoxOriginLanguage.getItemAt(originLang) + " // " + comboBoxDestinationLanguage.getItemAt(destLang) + "]");
		btnCreateCourse.setEnabled(false);
		
	}
	
	private void checkCategories(int languageID, int courseID) {
		
		// checkCategories
		// Al seleccionar un CURSO, mostrará todas sus CATEGORÍAS aplicando
		// una QUERY que filtrará los resultados.
		
		List<Category> categories = categoryManager.getAllCategories(languageID, courseID);// MockUP -- El de abajo es el que funciona con la QUERY
		
		for (Category c : categories) {
			dlmCategories.addElement(c.getName()); 	// Nombre de CATEGORIA
		}		
	}
	
	private void addCategory(int languageID, int courseID) {
		
		// addCategory
		// Si hay un CURSO seleccionado, al presionar el JButton btnAddCategory
		// mostrará un JOptionPane preguntando al usuario el nombre de la categoria
		// que quiere añadir. En caso de ser nueva e unica, esta se añade, si se repite
		// aborta y no la añade a la JList.
		
		if(listCourses.getSelectedValue() != null) {          
			String nameCategory = JOptionPane.showInputDialog("Nombre de la categoria:");
            Boolean isRepeated = false;
            
            categoryManager.insertCategory(languageID, courseID, nameCategory);
            
            for (int i=0; i<dlmCategories.size();i++) {
            	if(dlmCategories.get(i).toLowerCase().equals(nameCategory.toLowerCase())) {
            		
            		isRepeated = true;
            	}
            }
            if(isRepeated) {
            	JOptionPane.showMessageDialog(null, "La categoria " + nameCategory + " no ha sido añadida, ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
            	dlmCategories.addElement(nameCategory);
            	JOptionPane.showMessageDialog(null, "La categoria " + nameCategory + " sido añadida");
            } 
        }
	}
	
	private void addLevel() {
		
		// addLevel()
		// Si hay un CURSO y una CATEGORIA seleccionadas, al presionar el JButton btnAddLevel
		// y mostrará un JOptionPane preguntando al usuario el nombre de este nuevo nivel.
		// Una vez el usuario accepte lo añadirá a la BBDD y a la JList listLevels
		
		if (listCourses.getSelectedIndices().length == 1 && listCategories.getSelectedIndices().length == 1) {
			String nameLevel = JOptionPane.showInputDialog("Nombre del nivel: ");
			
			if (!(nameLevel.isBlank() || nameLevel.isEmpty())) {
				
				int idCourse = listCourses.getSelectedIndex();
				String nameCategory = listCategories.getSelectedValue();			
				// categoryManager.insertCategoryLevel(idCourse, nameCategory);
				
			}
			
			
		}
		
	}
}