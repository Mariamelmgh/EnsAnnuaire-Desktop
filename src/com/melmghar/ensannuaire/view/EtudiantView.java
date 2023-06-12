package com.melmghar.ensannuaire.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.melmghar.ensannuaire.util.ConnectionHelper;
import com.melmghar.ensannuaire.util.Constent;
import com.melmghar.ensannuaire.controller.DepartementController;
import com.melmghar.ensannuaire.controller.EtudiantController;
import com.melmghar.ensannuaire.controller.FiliereController;
import com.melmghar.ensannuaire.model.Etudiant;
import com.melmghar.ensannuaire.model.Filiere;

import javax.swing.JTextField;
import javax.swing.MutableComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.EtchedBorder;

public class EtudiantView {

	JFrame frmGestionEtudiant;
	private JTextField textFieldCNE;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldRecherche;
	private JComboBox<Filiere> comboBoxFiliere;
	private JTextField textFieldTelephone;
	private JTable tableEtudiant;
	
	//Controllers
	private EtudiantController etudiantController = new EtudiantController();
	private FiliereController filiereController = new FiliereController();
	private DepartementController departementController = new DepartementController();
	
	//General vars
	private String action;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EtudiantView window = new EtudiantView();
					window.frmGestionEtudiant.setVisible(true);
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
	public EtudiantView() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException {
		frmGestionEtudiant = new JFrame();
		frmGestionEtudiant.setBackground(new Color(33, 38, 55));
		frmGestionEtudiant.getContentPane().setBackground(new Color(33, 38, 53));
		frmGestionEtudiant.setTitle("Gestion Etudiant");
		frmGestionEtudiant.setBounds(100, 100, 982, 517);
		frmGestionEtudiant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionEtudiant.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List Etudiants");
		lblNewLabel.setForeground(new Color(110, 192, 245));
		lblNewLabel.setFont(new Font("Kokonor", Font.BOLD, 26));
		lblNewLabel.setBounds(395, 26, 235, 37);
		frmGestionEtudiant.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(43, 87, 114));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Ajouter un etudiant", TitledBorder.LEADING, TitledBorder.TOP, null, Color.PINK));
		panel.setBounds(37, 109, 362, 277);
		frmGestionEtudiant.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prénom");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(51, 108, 78, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nom");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setBounds(51, 73, 52, 16);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("CNE");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setBounds(51, 45, 52, 16);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Filiére");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(51, 186, 78, 16);
		panel.add(lblNewLabel_1_1_1);
		
		textFieldCNE = new JTextField();
		textFieldCNE.setBounds(170, 40, 130, 26);
		panel.add(textFieldCNE);
		textFieldCNE.setColumns(10);
		
		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		textFieldNom.setBounds(170, 70, 130, 26);
		panel.add(textFieldNom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(170, 103, 130, 26);
		panel.add(textFieldPrenom);
		
		//ComboBoxModel
		comboBoxFiliere = new JComboBox<Filiere>(new DefaultComboBoxModel(filiereController.afficherFiliereNom().toArray()));
		
		comboBoxFiliere.setBounds(170, 182, 130, 27);
		
		panel.add(comboBoxFiliere);
		
		textFieldTelephone = new JTextField();
		textFieldTelephone.setColumns(10);
		textFieldTelephone.setBounds(170, 148, 130, 26);
		panel.add(textFieldTelephone);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Téléphone");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setBounds(51, 153, 78, 16);
		panel.add(lblNewLabel_1_1_2);
		
		enable(false);
		effacer();
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setForeground(new Color(33, 38, 52));
		btnEnregistrer.setBackground(new Color(233, 112, 124));
		btnEnregistrer.hide();
		
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Tester sur l'action si 'Ajouter' alors ajouter l'étudiant si 'Modifier'donc on va modifier l'étudiant
				String cne = textFieldCNE.getText();
				String nom = textFieldNom.getText();
				String prenom = textFieldPrenom.getText();
				String telephone = textFieldTelephone.getText();
				String departement ="";
				Filiere filiere = new Filiere();
				//Long filiereId = (long) comboBoxFiliere.getSelectedIndex() + 1;
				try {
					 filiere = filiereController.afficherFilierParNom(comboBoxFiliere.getSelectedItem().toString());
		
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				 departement = departementController.afficherDepartementParId(filiere.getDepartementId()).getNom();
				Etudiant etudiant = new Etudiant(cne,nom,prenom,filiere.getId(),departement,telephone);
				
				
				if(action == Constent.AJOUTER) {
					
					try {
						etudiantController.insererEtudiant(etudiant);
						JOptionPane.showMessageDialog(null, "Ajout passé avec succées");
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				}else if (action == Constent.MODIFIER) {
					 textFieldCNE.enable(false);
					 
					try {
						etudiantController.modifierEtudiant(etudiant);
						JOptionPane.showMessageDialog(null, "Modification passé avec succées");
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
						e1.printStackTrace();
					}
					
				}
				
				enable(false);
				effacer();
				
				comboBoxFiliere.setSelectedIndex(-1);
				comboBoxFiliere.enable(true);
				
				btnEnregistrer.hide();
				try {
					loadData();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEnregistrer.setBounds(110, 214, 117, 29);
		panel.add(btnEnregistrer);
		
		
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
		frmGestionEtudiant.getContentPane().add(btnAjouter);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.setForeground(new Color(33, 38, 52));
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Effacer les données dans les textBox
				effacer();
				enable(false);
			}
		});
		btnEffacer.setBounds(172, 427, 117, 29);
		frmGestionEtudiant.getContentPane().add(btnEffacer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(33, 38, 52));
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnnuler.setBounds(282, 427, 117, 29);
		frmGestionEtudiant.getContentPane().add(btnAnnuler);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(43, 87, 115));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Recherecher", TitledBorder.LEADING, TitledBorder.TOP, null, Color.PINK));
		panel_1.setBounds(425, 109, 514, 71);
		frmGestionEtudiant.getContentPane().add(panel_1);
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
		//Recherche étudiant
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Etudiant etudiant = etudiantController.afficherEtudiantParNom(textFieldRecherche.getText());
				
					if (etudiant != null) {
						textFieldCNE.setText(etudiant.getCNE());
						textFieldNom.setText(etudiant.getNom());
						textFieldPrenom.setText(etudiant.getPrenom());
						textFieldTelephone.setText(etudiant.getTelephone());
						comboBoxFiliere.setSelectedIndex((int) (etudiant.getFiliereId() +1));
						
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
		frmGestionEtudiant.getContentPane().add(btnMettreAjour);
		
		
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setForeground(new Color(33, 38, 52));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cne = textFieldCNE.getText();
				try {
					etudiantController.supprimerEtudiant(cne);
					loadData();
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				effacer();
				
			}
		});
		btnSupprimer.setBounds(590, 439, 117, 29);
		frmGestionEtudiant.getContentPane().add(btnSupprimer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(425, 213, 551, 173);
		frmGestionEtudiant.getContentPane().add(scrollPane);
		
		tableEtudiant = new JTable();
		tableEtudiant.setForeground(Color.WHITE);
		scrollPane.setViewportView(tableEtudiant);
		loadData();
		tableEtudiant.setBackground(new Color(43, 87, 115));
		
		tableEtudiant.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
			if(tableEtudiant.getSelectedRow() != -1 ) {
				String cne = tableEtudiant.getValueAt(tableEtudiant.getSelectedRow(), 0).toString();
				Etudiant etudiant = etudiantController.afficherEtudiantParCNE(cne);
				
				textFieldCNE.setText(etudiant.getCNE());
				textFieldNom.setText(etudiant.getNom());
				textFieldPrenom.setText(etudiant.getPrenom());
				textFieldTelephone.setText(etudiant.getTelephone());
			//	comboBoxFiliere.setSelectedIndex((int) etudiant.getFiliereId());
				try {
					comboBoxFiliere.setSelectedItem(etudiant.getFiliere());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				enable(false);
			}
				
				
				
			}

		});
		
	
	}
	
	
	// Effacer les données
	public void effacer() {
		
		textFieldCNE.setText("");
		textFieldPrenom.setText("");
		textFieldNom.setText("");
		textFieldTelephone.setText("");
		comboBoxFiliere.setSelectedIndex(-1);
	
		
	}
	
	
	//load data
	public void loadData() throws ClassNotFoundException {
		DefaultTableModel defaultTableModel= new DefaultTableModel();
		
		List<Etudiant> etudiants = etudiantController.afficherEtudiant();
		defaultTableModel.setRowCount(etudiants.size());
		defaultTableModel.addColumn("CNE");
		defaultTableModel.addColumn("Nom");
		defaultTableModel.addColumn("Prenom");
		defaultTableModel.addColumn("Filiére");
		defaultTableModel.addColumn("Telephone");
		defaultTableModel.addColumn("Département");
	
		for(int i = 0;i<etudiants.size();i++) {
			
			defaultTableModel.setValueAt(etudiants.get(i).getCNE(),i,0);
			defaultTableModel.setValueAt(etudiants.get(i).getNom(),i,1);
			defaultTableModel.setValueAt(etudiants.get(i).getPrenom(),i,2);
			defaultTableModel.setValueAt(etudiants.get(i).getFiliere(),i,3);
			defaultTableModel.setValueAt(etudiants.get(i).getTelephone(),i,4);
			defaultTableModel.setValueAt(etudiants.get(i).getDepartement(),i,5);

			
		}
		
		
		
		tableEtudiant.setModel(defaultTableModel);
	}
	
	public void enable(boolean value ) {
		
		textFieldCNE.enable(value);
		textFieldNom.enable(value);
		textFieldPrenom.enable(value);
		textFieldTelephone.enable(value);
		comboBoxFiliere.enable(value); 
	}
}

