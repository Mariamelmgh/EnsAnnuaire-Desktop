package com.melmghar.ensannuaire.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.melmghar.ensannuaire.controller.DepartementController;
import com.melmghar.ensannuaire.model.Departement;
import com.melmghar.ensannuaire.model.Etudiant;
import com.melmghar.ensannuaire.model.Filiere;
import com.melmghar.ensannuaire.util.Constent;

public class DepartementView {

	JFrame frmGestionDepartement;

	private JTextField textFieldId;
	private JTextField textFieldNom;
	private JTable tableDepartement;
	private JTextField textFieldRecherche;
	//Controller
	private DepartementController departementController = new DepartementController();
	
	//General var
	private String action;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartementView window = new DepartementView();
					window.frmGestionDepartement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 */
	public DepartementView() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException {
		frmGestionDepartement = new JFrame();
		frmGestionDepartement.setBackground(new Color(33, 38, 55));
		frmGestionDepartement.getContentPane().setBackground(new Color(33, 38, 53));
		frmGestionDepartement.setTitle("Gestion Département");
		frmGestionDepartement.setBounds(100, 100, 982, 517);
		frmGestionDepartement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDepartement.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List Départements");
		lblNewLabel.setForeground(new Color(110, 192, 245));
		lblNewLabel.setFont(new Font("Kokonor", Font.BOLD, 26));
		lblNewLabel.setBounds(395, 26, 235, 37);
		frmGestionDepartement.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(43, 87, 114));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Ajouter un etudiant", TitledBorder.LEADING, TitledBorder.TOP, null, Color.PINK));
		panel.setBounds(37, 109, 362, 178);
		frmGestionDepartement.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Id");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(23, 45, 78, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nom");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setBounds(23, 75, 52, 16);
		panel.add(lblNewLabel_1_2);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(63, 40, 130, 26);
		panel.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		textFieldNom.setBounds(63, 70, 274, 26);
		panel.add(textFieldNom);
		
		textFieldId.enable(false);
		textFieldNom.enable(false);
		effacer();
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setForeground(new Color(33, 38, 52));
		btnEnregistrer.setBackground(new Color(233, 112, 124));
		btnEnregistrer.hide();
		
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Tester sur l'action si 'Ajouter' alors ajouter l'étudiant si 'Modifier'donc on va modifier l'étudiant
				Long id = null;
				if(!textFieldId.getText().isBlank()) {
					id =  Long.parseLong(textFieldId.getText());
				}
				String nom = textFieldNom.getText();
				
				Departement departement = new Departement(id,nom);
				
				if(action == Constent.AJOUTER) {
					
					try {
						departementController.insererDepartement(departement);
						JOptionPane.showMessageDialog(null, "Ajout passé avec succées");
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				}else if (action == Constent.MODIFIER) {
					 
					try {
						departementController.modifierDepartement(departement);
						JOptionPane.showMessageDialog(null, "Modification passé avec succées");
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
						e1.printStackTrace();
					}
					
				}
				
				textFieldNom.enable(true);
				effacer();
				
				btnEnregistrer.hide();
				try {
					loadData();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEnregistrer.setBounds(116, 108, 117, 29);
		panel.add(btnEnregistrer);
		
		//Ajouter département
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(new Color(33, 38, 52));
		btnAjouter.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//Departement à ajouter
			 effacer();
			 textFieldNom.enable(true);;
					
			btnEnregistrer.show();
			action = Constent.AJOUTER;
			}
		});
				
		btnAjouter.setBounds(37, 311, 117, 54);
		frmGestionDepartement.getContentPane().add(btnAjouter);
				
				
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.setForeground(new Color(33, 38, 52));
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Effacer les données dans les textBox
				effacer();
			}
		});
		
		btnEffacer.setBounds(167, 311, 117, 54);
		frmGestionDepartement.getContentPane().add(btnEffacer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(33, 38, 52));
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnnuler.setBounds(286, 311, 117, 54);
		frmGestionDepartement.getContentPane().add(btnAnnuler);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(43, 87, 115));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Recherecher", TitledBorder.LEADING, TitledBorder.TOP, null, Color.PINK));
		panel_1.setBounds(425, 109, 514, 71);
		frmGestionDepartement.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("Nom");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setBounds(18, 28, 30, 16);
		panel_1.add(lblNewLabel_1_4);
		
		textFieldRecherche = new JTextField();
		
		
		textFieldRecherche.setBounds(60, 23, 206, 26);
		textFieldRecherche.setColumns(10);
		panel_1.add(textFieldRecherche);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setForeground(new Color(33, 38, 52));
		btnRechercher.setBackground(new Color(255, 255, 255));
		
		//Recherche département
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Departement departement = departementController.afficherDepartementParNom(textFieldRecherche.getText());
				
					if (departement != null) {
						textFieldId.setText(departement.getId().toString());
						textFieldNom.setText(departement.getNom());
						
						textFieldNom.enable(false);
					}
					
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
		btnRechercher.setBounds(315, 23, 117, 29);
		panel_1.add(btnRechercher);
		

		JButton btnMettreAjour = new JButton("Mettre à jour");
		btnMettreAjour.setForeground(new Color(33, 38, 52));
		btnMettreAjour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				//Etudiant à mettre à jour
				textFieldNom.enable(true);
				btnEnregistrer.show();
				action = Constent.MODIFIER;
				
				
			}
		});
		btnMettreAjour.setBounds(425, 399, 117, 29);
		frmGestionDepartement.getContentPane().add(btnMettreAjour);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setForeground(new Color(33, 38, 52));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long id = Long.parseLong(textFieldId.getText());
				try {
					departementController.supprimerDepartement(id);
					loadData();
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				effacer();
				
			}
		});
		
		btnSupprimer.setBounds(556, 399, 117, 29);
		frmGestionDepartement.getContentPane().add(btnSupprimer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(425, 213, 551, 173);
		frmGestionDepartement.getContentPane().add(scrollPane);
		
		tableDepartement = new JTable();
		tableDepartement.setForeground(Color.WHITE);
		scrollPane.setViewportView(tableDepartement);
		loadData();
		
		tableDepartement.setBackground(new Color(43, 87, 115));
		tableDepartement.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
			if(tableDepartement.getSelectedRow() != -1 ) {
				Long id = Long.parseLong(tableDepartement.getValueAt(tableDepartement.getSelectedRow(), 0).toString());
						
				Departement departement = departementController.afficherDepartementParId(id);
				
				textFieldId.setText(departement.getId().toString());
				textFieldNom.setText(departement.getNom());
			
				textFieldNom.enable(false);
			}
				
				
				
			}

		});
		
		
	}
	
	
	// Effacer les données
	public void effacer() {
		
		textFieldId.setText("");
		textFieldNom.setText("");
	}
	
	//load data
		public void loadData() throws ClassNotFoundException {
			DefaultTableModel defaultTableModel= new DefaultTableModel();
			
			List<Departement> departements = departementController.afficherDepartement();
			
			defaultTableModel.setRowCount(departements.size());
			
			defaultTableModel.addColumn("Id");
			defaultTableModel.addColumn("Nom");
			for(int i = 0;i<departements.size();i++) {
				
				defaultTableModel.setValueAt(departements.get(i).getId(),i,0);
				defaultTableModel.setValueAt(departements.get(i).getNom(),i,1);
				
			}
			
			
			
			tableDepartement.setModel(defaultTableModel);
		}
	

}
