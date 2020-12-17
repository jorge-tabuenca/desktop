package com.desktop.JPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import com.desktop.JFrame.AddOpenTranslationFrame;
import com.desktop.JFrame.AddTestExerciceFrame;
import com.duolingo.interfaces.IExercice;
import com.duolingo.interfaces.impl.ExerciceImpl;
import com.duolingo.model.Exercice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AdministerExercices extends JPanel{

    private JPanel panelLeft, panelRight, panelLabels, panelTree;
    private GridBagConstraints gbc = new GridBagConstraints();
    private Border eBorder = BorderFactory.createEtchedBorder();
    private static ArrayList<String> arrayTypeExercisesUrl = new ArrayList<>();
    private static ArrayList<String> arrayTypeExercises = new ArrayList<>();
    int numberTypeExercises = 5;
    IExercice exerciceManager = new ExerciceImpl();
    
    public AdministerExercices(int categoryID, String categoryName, String level, String course){

        // TestGBL
        // Constructor. Se establecen las propiedades del JFrame (habría que cambiarlo a JPanel)
        // Una vez creado el JFrame, ejecuta métodos para rellenarlo y añadirle contenido.

    	
        setSize(1920, 1080);
        setLayout(new GridBagLayout());
        addPanelLeft(categoryID, categoryName, level, course);
        addPanelRight(categoryID);

    }

    private void addPanelLeft(int categoryID, String categoryName, String level, String course){

        // addPanelLeft()
        // Crea un JPanel panelLeft, le establece un layout de tipo
        // GridLayout (2, 1) [Para que hayan dentro 2 JPanel más adelante..]
        // Y se le aplica al GridBagConstraint un porcentaje que equivale al
        // 30% del tañano total de la pantalla. Una vez creado y con todos sus
        // datos, lo añade al JFrame a la IZQUIERDA.

        panelLeft = new JPanel();
        panelLeft.setLayout(new GridLayout(2, 1));

        addPanelLabels(categoryName, level, course);
        addPanelTree(categoryID);

        gbc.gridx = gbc.gridy = 0;
        gbc.gridwidth = gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = gbc.weighty = 0;
        add(panelLeft, gbc);

    }

    private void addPanelRight(int categoryID){

        // addPanelRight()
        // Crea un JPanel panelRight, le establece un layout de tipo
        // GridLayout (numberTypeExercices [7], 1). Un margen entre cada
        // item del GridLayout de valor 5. Y se le aplica al GridBagConstraint
        // un porcentaje que equivale al 70% del tañano total de la pantalla.
        // Una vez creado y con todos sus datos, lo añade al JFrame a la DERECHA.

        panelRight = new JPanel();
        GridLayout layout = new GridLayout(numberTypeExercises,1);
        layout.setVgap(5);
        panelRight.setLayout(layout);

        addTypeExButtons(categoryID);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 0;
        gbc.weightx = gbc.weighty = 70;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(panelRight, gbc);

    }

    private void addTypeExButtons(int categoryID){

        // addTypeExButtons()
        // Añade al JPanel "panelRight" tantos botones como TIPOS DE EJERCICIOS
        // hayan en la BBDD (MockUP = 7). El layout del JPanel panelRight és
        // de tipo GridLayout(C = 1, R = numberTypeExercice [7])

        arrayTypeExercisesUrl.add("https://i.imgur.com/pv6TvlL.png");
        arrayTypeExercises.add("TRADUCCIO REORDENA PARAULES");
        arrayTypeExercisesUrl.add("https://i.imgur.com/T44ESkE.png");
        arrayTypeExercises.add("LISTENIG REORDENA");
        arrayTypeExercisesUrl.add("https://i.imgur.com/9Ixq4HH.png");
        arrayTypeExercises.add("LISTENING OBERT");
        arrayTypeExercisesUrl.add("https://i.imgur.com/kWZUuPw.png");
        arrayTypeExercises.add("APARELLA PARAULES");
        arrayTypeExercisesUrl.add("https://i.imgur.com/JhGuMHe.png");
        arrayTypeExercises.add("OMPLE UNA PARAULA");
        
        JButton testButton;
		try {
			
			for (int i = 0; i < numberTypeExercises; i++){
	            JButton btn = new JButton(arrayTypeExercises.get(i), new ImageIcon(new URL(arrayTypeExercisesUrl.get(i))));
	            btn.setFont(new Font("Arial", Font.BOLD, 28));
	            btn.setHorizontalTextPosition(SwingConstants.CENTER);
	            btn.setForeground(Color.WHITE);
	            btn.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    System.out.println(btn.getText());
	                }
	            });
	            panelRight.add(btn);
	        }
			
			testButton = new JButton("TIPUS TEST", new ImageIcon(new URL("https://i.imgur.com/KUGPqA2.png")));
			testButton.setFont(new Font("Arial", Font.BOLD, 28));
			testButton.setHorizontalTextPosition(SwingConstants.CENTER);
			testButton.setForeground(Color.WHITE);
			testButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                new AddTestExerciceFrame(categoryID);               
	            }
	        });
	        panelRight.add(testButton);
	        
	        JButton openTranslationButton = new JButton("TRADUCCIO OBERTA", new ImageIcon(new URL("https://i.imgur.com/MnvCeVl.png")));
	        openTranslationButton.setFont(new Font("Arial", Font.BOLD, 28));
	        openTranslationButton.setHorizontalTextPosition(SwingConstants.CENTER);
	        openTranslationButton.setForeground(Color.WHITE);
	        openTranslationButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                new AddOpenTranslationFrame(categoryID);             
	            }
	        });
	        panelRight.add(openTranslationButton);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

    private void addPanelLabels(String categoryName, String level, String course){

        // addPanelLabels()
        // Crea una JLabel y le asigna tu texto a partir de los datos guardados en el String[]
        // Una vez creada la JLabel cambia su fuente y tamaño a Calibri 20

        // Esta en MockUP, habría que cambiar este JPanel (panelLabels) a GroupLayout para mejorar
        // su calidad y presentación...

        String [] arrayLabels = new String [] {course, "Categoria: " + categoryName, "Level: " + level};
        panelLabels = new JPanel(new GridLayout(arrayLabels.length, 1));

        for (int i = 0; i < arrayLabels.length; i++){
            JLabel lbl = new JLabel(arrayLabels[i]);
            lbl.setFont(new Font("Calibri", Font.PLAIN, 20));
            panelLabels.add(lbl);
        }

        panelLeft.add(panelLabels);

    }

    private void addPanelTree(int categoryID){

        // addPanelTree
        // Método donde se crea el JPanel panelTree que contendrá
        // un JTree (más adelante...)

    	List<Exercice> exerciceList = exerciceManager.getAllExerciceByCategoryId(categoryID);
    	
        DefaultMutableTreeNode course = new DefaultMutableTreeNode("Ejercicios categoria actual");
        
        int i = 1;
        
        for(Exercice exercice : exerciceList) {

			DefaultMutableTreeNode e = new DefaultMutableTreeNode("Ejercicio " + i);
			course.add(e);	
			i ++;
        }

        JTree tree = new JTree(course);
        
        panelTree = new JPanel();
        panelTree.add(tree);
        panelLeft.add(panelTree);

    }
}