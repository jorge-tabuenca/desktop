package com.desktop.JFrame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.naming.RefAddr;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.desktop.JPanel.AdministerCourses;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					MainFrame frame = new MainFrame();
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					Image image;
					URL url = new URL("https://i.imgur.com/5kwCNbM.png%22");
				    image = ImageIO.read(url);
				    frame.setMinimumSize(screenSize);
				    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				    frame.getContentPane().setPreferredSize(screenSize);
				    frame.setIconImage(image);
				    frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);	
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 2128, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
					.addGap(0))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1271, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 726, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		JMenu adminCourses = new JMenu("Administrar Cursos");
		adminCourses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AdministerCourses administerCourses = new AdministerCourses();
				
				administerCourses.setSize(panel.getSize());
				
				panel.setSize(Toolkit.getDefaultToolkit().getScreenSize());
				
				panel.removeAll();
				panel.add(administerCourses);
				
				//pack();
				
				panel.setVisible(true);
				
				
				//getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
				
				invalidate();
				validate();
				
			}
		});
		menu.add(adminCourses);
		
		JMenu adminUsers = new JMenu("Administrar Usuarios");
		adminUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panel.removeAll();
				invalidate();
				validate();
				
				
			}
		});
				
		menu.add(adminUsers);
		
		contentPane.setLayout(gl_contentPane);
	}
}
