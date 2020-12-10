package com.desktop.JPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.desktop.JFrame.AddExerciceFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdministerExercices extends JPanel{

    private JPanel panelLeft, panelRight, panelLabels, panelTree;
    private GridBagConstraints gbc = new GridBagConstraints();
    private Border eBorder = BorderFactory.createEtchedBorder();
    private static ArrayList<String> arrayTypeExercises = new ArrayList<>();
    int numberTypeExercises = 6;

    public AdministerExercices(int categoryID){

        // TestGBL
        // Constructor. Se establecen las propiedades del JFrame (habr�a que cambiarlo a JPanel)
        // Una vez creado el JFrame, ejecuta m�todos para rellenarlo y a�adirle contenido.

    	
        setSize(1920, 1080);
        setLayout(new GridBagLayout());
        addPanelLeft();
        addPanelRight(categoryID);

    }

    private void addPanelLeft(){

        // addPanelLeft()
        // Crea un JPanel panelLeft, le establece un layout de tipo
        // GridLayout (2, 1) [Para que hayan dentro 2 JPanel m�s adelante..]
        // Y se le aplica al GridBagConstraint un porcentaje que equivale al
        // 30% del ta�ano total de la pantalla. Una vez creado y con todos sus
        // datos, lo a�ade al JFrame a la IZQUIERDA.

        panelLeft = new JPanel();
        panelLeft.setLayout(new GridLayout(2, 1));

        addPanelLabels();
        addPanelTree();

        gbc.gridx = gbc.gridy = 0;
        gbc.gridwidth = gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = gbc.weighty = 35;
        add(panelLeft, gbc);

    }

    private void addPanelRight(int categoryID){

        // addPanelRight()
        // Crea un JPanel panelRight, le establece un layout de tipo
        // GridLayout (numberTypeExercices [7], 1). Un margen entre cada
        // item del GridLayout de valor 5. Y se le aplica al GridBagConstraint
        // un porcentaje que equivale al 70% del ta�ano total de la pantalla.
        // Una vez creado y con todos sus datos, lo a�ade al JFrame a la DERECHA.

        panelRight = new JPanel();
        GridLayout layout = new GridLayout(numberTypeExercises,1);
        layout.setVgap(5);
        panelRight.setLayout(layout);

        addTypeExButtons(categoryID);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 0;
        gbc.weightx = gbc.weighty = 70;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(panelRight, gbc);

    }

    private void addTypeExButtons(int categoryID){

        // addTypeExButtons()
        // A�ade al JPanel "panelRight" tantos botones como TIPOS DE EJERCICIOS
        // hayan en la BBDD (MockUP = 7). El layout del JPanel panelRight �s
        // de tipo GridLayout(C = 1, R = numberTypeExercice [7])

        arrayTypeExercises.add("TRADUCCIO_OBERTA");
        arrayTypeExercises.add("TRADUCCIO_REORDENA_PARAULES");
        arrayTypeExercises.add("LISTENING_REORDENA");
        arrayTypeExercises.add("LISTENING_OBERT");
        arrayTypeExercises.add("APARELLA_PARAULES");
        arrayTypeExercises.add("OMPLE_UNA_PARAULA");
        

        for (int i = 0; i < numberTypeExercises; i++){
            JButton btn = new JButton(arrayTypeExercises.get(i));
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println(btn.getText());
                }
            });
            panelRight.add(btn);
        }
        JButton btn = new JButton("TIPUS TEST");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddExerciceFrame(categoryID);
                
            }
        });
        panelRight.add(btn);
    }

    private void addPanelLabels(){

        // addPanelLabels()
        // Crea una JLabel y le asigna tu texto a partir de los datos guardados en el String[]
        // Una vez creada la JLabel cambia su fuente y tama�o a Calibri 20

        // Esta en MockUP, habr�a que cambiar este JPanel (panelLabels) a GroupLayout para mejorar
        // su calidad y presentaci�n...

        String [] arrayLabels = new String [] {"Curso: Test", "Categoria: Test"};
        panelLabels = new JPanel(new GridLayout(arrayLabels.length, 1));

        for (int i = 0; i < arrayLabels.length; i++){
            JLabel lbl = new JLabel(arrayLabels[i]);
            lbl.setFont(new Font("Calibri", Font.PLAIN, 20));
            panelLabels.add(lbl);
        }

        panelLeft.add(panelLabels);

    }

    private void addPanelTree(){

        // addPanelTree
        // M�todo donde se crea el JPanel panelTree que contendr�
        // un JTree (m�s adelante...)

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Test 1");
        DefaultTreeModel dtm = new DefaultTreeModel(root);
        JTree tree = new JTree(dtm);
        
        panelTree = new JPanel();
        panelTree.add(tree);
        panelLeft.add(panelTree);

    }

}