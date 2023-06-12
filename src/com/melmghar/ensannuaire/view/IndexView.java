package com.melmghar.ensannuaire.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class IndexView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IndexView window = new IndexView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IndexView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(29, 33, 43));
		frame.getContentPane().setLayout(null);
		
		JButton btnGestionEtudiant = new JButton("Gestion Etudiant");
		btnGestionEtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EtudiantView etudiantFrame;
				try {
					etudiantFrame = new EtudiantView();
					etudiantFrame.frmGestionEtudiant.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnGestionEtudiant.setForeground(Color.PINK);
		btnGestionEtudiant.setBounds(111, 112, 221, 59);
		frame.getContentPane().add(btnGestionEtudiant);
		
		JButton btnGestionDepartement = new JButton("Gestion Departement");
		btnGestionDepartement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DepartementView departementFrame;
				try {
					departementFrame = new DepartementView();
					departementFrame.frmGestionDepartement.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGestionDepartement.setForeground(Color.PINK);
		btnGestionDepartement.setBounds(111, 265, 221, 59);
		frame.getContentPane().add(btnGestionDepartement);
		
		JButton btnGestionFiliere = new JButton("Gestion Filiere");
		btnGestionFiliere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FiliereView filiereFrame;
				try {
					filiereFrame = new FiliereView();
					filiereFrame.frmGestionFiliere.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGestionFiliere.setForeground(Color.PINK);
		btnGestionFiliere.setBounds(111, 182, 221, 59);
		frame.getContentPane().add(btnGestionFiliere);
		
		JLabel lblEnsAnnuaire = new JLabel("ENS Annuaire");
		lblEnsAnnuaire.setForeground(new Color(110, 192, 245));
		lblEnsAnnuaire.setFont(new Font("Kokonor", Font.BOLD, 26));
		lblEnsAnnuaire.setBounds(153, 38, 272, 37);
		frame.getContentPane().add(lblEnsAnnuaire);
		frame.setBounds(100, 100, 450, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
