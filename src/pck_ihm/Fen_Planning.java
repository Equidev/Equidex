package pck_ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pck_metier.Activite;
import pck_metier.NatureActivite;

public class Fen_Planning extends JDialog implements ActionListener
{

	private final JPanel contentPanel = new JPanel();
	private JLabel lblListeAssociation;
	private JLabel lblNewLabel;
	private JLabel lblActivit;
	private JComboBox<Activite> cbxActivite;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JLabel lblHeureDisplay;
	private JLabel lblJourDisplay;
	private JComboBox<NatureActivite> cbxNature;
	private JButton btnAjoutActi;
	private JButton btnDelActi;
	private JButton btnAjoutNatureActi;
	private JButton btnDelNature;
	private JList list;
	
	
	public Fen_Planning(int horaire, int jour)
	{
		setTitle("Contenu S\u00E9ance");
		setBounds(100, 100, 600, 540);
		getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		this.lblListeAssociation = new JLabel("Liste des participations :");
		this.lblListeAssociation.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.lblListeAssociation.setBounds(10, 186, 200, 20);
		contentPanel.add(this.lblListeAssociation);
		
		this.lblNewLabel = new JLabel("Nature de l'activit\u00E9 :");
		this.lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.lblNewLabel.setBounds(10, 121, 160, 20);
		contentPanel.add(this.lblNewLabel);
		
		this.lblActivit = new JLabel("Activit\u00E9 :");
		this.lblActivit.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.lblActivit.setBounds(10, 53, 75, 20);
		contentPanel.add(this.lblActivit);
		
		this.cbxActivite = new JComboBox<Activite>(Fen_Principal.LES_ACTIVITES);
		this.cbxActivite.setBounds(10, 78, 364, 26);
		contentPanel.add(this.cbxActivite);
		
		this.btnValider = new JButton("Valider");
		this.btnValider.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		this.btnValider.setBounds(474, 459, 100, 26);
		contentPanel.add(this.btnValider);
		this.btnValider.addActionListener(this);
		
		this.btnAnnuler = new JButton("Annuler");
		this.btnAnnuler.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		this.btnAnnuler.setBounds(474, 422, 100, 26);
		contentPanel.add(this.btnAnnuler);
		this.btnAnnuler.addActionListener(this);
		
		this.lblHeureDisplay = new JLabel("");
		this.lblHeureDisplay.setOpaque(true);
		this.lblHeureDisplay.setBackground(Color.LIGHT_GRAY);
		this.lblHeureDisplay.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		this.lblHeureDisplay.setBounds(102, 11, 78, 26);
		contentPanel.add(this.lblHeureDisplay);
		
		this.lblJourDisplay = new JLabel("");
		this.lblJourDisplay.setOpaque(true);
		this.lblJourDisplay.setBackground(Color.LIGHT_GRAY);
		this.lblJourDisplay.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		this.lblJourDisplay.setBounds(10, 11, 93, 26);
		contentPanel.add(this.lblJourDisplay);
		
		this.cbxNature = new JComboBox<NatureActivite>(Fen_Principal.LES_NATURES);
		this.cbxNature.setBounds(10, 146, 364, 26);
		contentPanel.add(this.cbxNature);
		
		this.btnAjoutActi = new JButton("Ajouter une activit\u00E9");
		this.btnAjoutActi.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		this.btnAjoutActi.setBounds(384, 78, 154, 26);
		contentPanel.add(this.btnAjoutActi);
		this.btnAjoutActi.addActionListener(this);
		
		this.btnDelActi = new JButton("Del");
		this.btnDelActi.setBounds(548, 78, 26, 26);
		contentPanel.add(this.btnDelActi);
		
		this.btnAjoutNatureActi = new JButton("Ajouter une nature");
		this.btnAjoutNatureActi.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		this.btnAjoutNatureActi.setBounds(384, 146, 154, 26);
		contentPanel.add(this.btnAjoutNatureActi);
		
		this.btnDelNature = new JButton("New button");
		this.btnDelNature.setBounds(548, 146, 26, 26);
		contentPanel.add(this.btnDelNature);
		
		this.list = new JList();
		this.list.setBounds(20, 217, 401, 268);
		contentPanel.add(this.list);
		this.btnDelActi.addActionListener(this);
		
		if ( horaire < 4) {
			this.lblHeureDisplay.setText(String.valueOf(8+horaire)+"h-"+String.valueOf(9+horaire)+"h");
		}
		else
		{
			this.lblHeureDisplay.setText(String.valueOf(10+horaire)+"h-"+String.valueOf(11+horaire)+"h");
		}
		
		switch (jour)
		{
		case 0:
			this.lblJourDisplay.setText("Lundi");
			break;
		case 1:
			this.lblJourDisplay.setText("Mardi");
			break;
		case 2:
			this.lblJourDisplay.setText("Mercredi");
			break;
		case 3:
			this.lblJourDisplay.setText("Jeudi");
			break;
		case 4:
			this.lblJourDisplay.setText("Vendredi");
			break;
		case 5:
			this.lblJourDisplay.setText("Samedi");
			break;
		}
	
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == btnAnnuler)
		{
			this.dispose();
		}
		if (e.getSource() == btnAjoutActi)
		{ 
			Fen_AjouterActivite fenAjouterActivite;
			// Ouvre la fenêtre modale Fen_AjouterActivite
			fenAjouterActivite = new Fen_AjouterActivite();
			fenAjouterActivite.setBounds(20, 20, 560, 284);
			fenAjouterActivite.setLocation(280, 280);
			fenAjouterActivite.setModal(true);
			fenAjouterActivite.setVisible(true);
			while (this.isFocusable() == false)
			{
				// Bloque le déroulement du code tant que la fenetre est
				// afficher
			}
		}
		if (e.getSource() == btnDelActi)
		{
			if(JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer cette activité?\n"+this.cbxActivite.getSelectedItem().toString(), "Supprimer une activité", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				System.out.println("BITE");
			}
		}
	}
}
