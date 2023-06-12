package com.melmghar.ensannuaire.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import com.melmghar.ensannuaire.controller.FiliereController;
import com.melmghar.ensannuaire.model.Departement;
import com.melmghar.ensannuaire.model.Filiere;
import com.melmghar.ensannuaire.util.Constent;

public class FiliereView {

	JFrame frmGestionFiliere;
	private JTextField textFieldNom;
	private JTextField textFieldId;
	private JComboBox<Departement> comboBoxDepartement;
	private JComboBox<Departement> comboBoxSelectDep;
	private JTable tableFiliere;
	private JTextField textFieldRecherche ;
	//Controller
	private FiliereController filiereController = new FiliereController();
	private DepartementController departementController = new DepartementController();
	//Général variable
	private String action;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiliereView window = new FiliereView();
					window.frmGestionFiliere.setVisible(true);
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
	public FiliereView() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException {
		frmGestionFiliere = new JFrame();
		frmGestionFiliere.getContentPane().setBackground(new Color(29, 33, 45));
		frmGestionFiliere.setBackground(new Color(29, 32, 45));
		frmGestionFiliere.setBounds(100, 100, 999, 510);
		frmGestionFiliere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionFiliere.getContentPane().setLayout(null);
		
		//
		JLabel lblNewLabel = new JLabel("List Filiére");
		lblNewLabel.setForeground(new Color(110, 192, 245));
		lblNewLabel.setFont(new Font("Kokonor", Font.BOLD, 26));
		lblNewLabel.setBounds(409, 25, 272, 37);
		frmGestionFiliere.getContentPane().add(lblNewLabel);
		
		//
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(43, 87, 114));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Ajouter une filiére", TitledBorder.LEADING, TitledBorder.TOP, null, Color.PINK));
		panel.setBounds(37, 109, 354, 317);
		frmGestionFiliere.getContentPane().add(panel);
		panel.setLayout(null);
		
		//
		JLabel lblNewLabel_1_1 = new JLabel("Id");
		lblNewLabel_1_1.setBounds(49, 81, 78, 16);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		panel.add(lblNewLabel_1_1);
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Nom");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		panel.add(lblNewLabel_1_1);
		
		//
		//ComboBoxModel
		comboBoxDepartement = new JComboBox<Departement>(new DefaultComboBoxModel(departementController.afficherDepartementNom().toArray()));
		comboBoxDepartement.setBounds(146, 158, 130, 27);
				
		panel.add(comboBoxDepartement);
				
		
		//
		textFieldNom = new JTextField();
		textFieldNom.setBounds(146, 120, 130, 26);
		textFieldNom.setColumns(10);
		panel.add(textFieldNom);
		
		//
		
		textFieldId = new JTextField();
		textFieldId.setBounds(146, 76, 130, 26);
		textFieldId.setColumns(10);
		panel.add(textFieldId);
		//
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(425, 253, 551, 173);
		frmGestionFiliere.getContentPane().add(scrollPane);
		
		//
		
		tableFiliere = new JTable();
		tableFiliere.setForeground(Color.WHITE);
		scrollPane.setViewportView(tableFiliere);
		loadData(filiereController.afficherFiliere());
		
		tableFiliere.setBackground(new Color(43, 87, 115));
		
		//
	    comboBoxSelectDep =  new JComboBox<Departement>(new DefaultComboBoxModel(departementController.afficherDepartementNom().toArray()));
		comboBoxSelectDep.setBounds(520, 220, 392, 27);
		frmGestionFiliere.getContentPane().add(comboBoxSelectDep);
		
		comboBoxSelectDep.addItemListener(new ItemListener() {
		     @Override
		     public void itemStateChanged(ItemEvent e) {
		    	 if(comboBoxSelectDep.getSelectedIndex() == -1) {
		    		 try {
						loadData(filiereController.afficherFiliere());
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	 }else {
		    		 Long id;
					try {
						id = departementController.afficherDepartementParNom(comboBoxSelectDep.getSelectedItem().toString()).getId();
						loadData(filiereController.afficherFilierParDepartement(id));
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		 
		    	 }
		    	 
		         System.out.println("Change");
		     }
		 });
		enable(false);
		effacer();
		
		//
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBounds(103, 236, 117, 29);
		btnEnregistrer.setForeground(new Color(33, 38, 52));
		btnEnregistrer.setBackground(new Color(233, 112, 124));
		btnEnregistrer.hide();
		
		btnEnregistrer.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			//Tester sur l'action si 'Ajouter' alors ajouter l'étudiant si 'Modifier'donc on va modifier l'étudiant
				
				Long id = null;
				
				if(!textFieldId.getText().isBlank()) {
					id = Long.parseLong(textFieldId.getText());
				}
				
				String nom = textFieldNom.getText();
				String departement = comboBoxDepartement.getSelectedItem().toString();
				
				Long departementId = null;
				try {
					departementId = departementController.afficherDepartementParNom(departement).getId();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				Filiere filiere = new Filiere(id,nom,departementId);
				
				if(action == Constent.AJOUTER) {
					
					try {
						filiereController.insererFiliere(filiere);
						JOptionPane.showMessageDialog(null, "Ajout passé avec succées");
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				}else if (action == Constent.MODIFIER) {
					 textFieldId.enable(false);
					 
					try {
						filiereController.modifierFilier(filiere);
						JOptionPane.showMessageDialog(null, "Modification passé avec succées");
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
						e1.printStackTrace();
					}
					
				}
				//
				enable(false);
				effacer();
				
				
				
				btnEnregistrer.hide();
				try {
					loadData( filiereController.afficherFiliere());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			 	
		});
		panel.add(btnEnregistrer);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Departement");
		lblNewLabel_1_1_1.setBounds(46, 162, 140, 16);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Nom");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setBounds(49, 118, 78, 16);
		panel.add(lblNewLabel_1_1_2);
	
		
		//Ajouter un étudiant
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setForeground(new Color(33, 38, 52));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Etudiant à ajouter
				effacer();
				enable(true);
			
				btnEnregistrer.show();
				action = Constent.AJOUTER;
			}
		});
		

		btnAjouter.setBounds(53, 427, 117, 29);
		frmGestionFiliere.getContentPane().add(btnAjouter);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.setForeground(new Color(33, 38, 52));
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Effacer les données dans les textBox
				effacer();
			}
		});
		
		
		//
		btnEffacer.setBounds(172, 427, 117, 29);
		frmGestionFiliere.getContentPane().add(btnEffacer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(33, 38, 52));
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				enable(false);
				effacer();
			
			}
		});
		btnAnnuler.setBounds(282, 427, 117, 29);
		frmGestionFiliere.getContentPane().add(btnAnnuler);
		
		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(43, 87, 115));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Recherecher", TitledBorder.LEADING, TitledBorder.TOP, null, Color.PINK));
		panel_1.setBounds(425, 109, 514, 71);
		frmGestionFiliere.getContentPane().add(panel_1);
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
		
		// Recherche Filiére
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Filiere filiere = filiereController.afficherFilierParNom(textFieldRecherche.getText());
					Departement departement =  departementController.afficherDepartementParId(filiere.getDepartementId());
					//
					System.out.println(filiere.getNom());
					System.out.println(departement.getNom());
					
					if (filiere != null) {
						textFieldId.setText(filiere.getId().toString());
						textFieldNom.setText(filiere.getNom());
						comboBoxDepartement.setSelectedItem(departement.getId());


						enable(false);

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
				enable(true);
				btnEnregistrer.show();
				action = Constent.MODIFIER;
				
				
			}
		});
		
		btnMettreAjour.setBounds(458, 439, 117, 29);
		frmGestionFiliere.getContentPane().add(btnMettreAjour);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setForeground(new Color(33, 38, 52));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long id = Long.parseLong(textFieldId.getText());
			
				try {
					filiereController.supprimerFilier(id);
					loadData( filiereController.afficherFiliere());
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
				
				effacer();
				
			}
		});
		
		btnSupprimer.setBounds(590, 439, 117, 29);
		frmGestionFiliere.getContentPane().add(btnSupprimer);
		
		
			
		JLabel lblNewLabel_1_4_1 = new JLabel("Departement");
		lblNewLabel_1_4_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1.setBounds(425, 225, 93, 16);
		frmGestionFiliere.getContentPane().add(lblNewLabel_1_4_1);
		
		tableFiliere.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
			if(tableFiliere.getSelectedRow() != -1 ) {
				Long id = (Long) tableFiliere.getValueAt(tableFiliere.getSelectedRow(), 0);
				Filiere filiere = new Filiere();
				
			
			
				try {
					filiere = filiereController.afficherFilierParId(id);
					System.out.println(filiere.getDepartementId());
					Departement departement = departementController.afficherDepartementParId(filiere.getDepartementId());
					
					textFieldId.setText(filiere.getId().toString());
					textFieldNom.setText(filiere.getNom());
					comboBoxDepartement.setSelectedItem(departement.getNom());
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				enable(false);
			}
				
				
				
			}

		});
	
		}
	public void loadData(List<Filiere> data) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		DefaultTableModel defaultTableModel= new DefaultTableModel();
		
		List<Filiere> filieres = data;
		defaultTableModel.setRowCount(filieres.size());
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("Nom");
		
	
		for(int i = 0;i<filieres.size();i++) {
			
			defaultTableModel.setValueAt(filieres.get(i).getId(),i,0);
			defaultTableModel.setValueAt(filieres.get(i).getNom(),i,1);
			
		}
		
		
		
		tableFiliere.setModel(defaultTableModel);
		
	}

	public void effacer() {
		// TODO Auto-generated method stub
		textFieldId.setText("");
		textFieldNom.setText("");
		comboBoxDepartement.setSelectedIndex(-1);
		comboBoxSelectDep.setSelectedIndex(-1);
		tableFiliere.clearSelection();
		
	}

	public void enable(boolean value) {
		// TODO Auto-generated method stub
		textFieldId.enable(false);
		textFieldNom.enable(value);
		comboBoxDepartement.enable(value);
		comboBoxSelectDep.enable(!value);
	}
}
