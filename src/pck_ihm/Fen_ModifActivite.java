package pck_ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pck_dao.ActiviteDao;
import pck_lib.Outils;
import pck_metier.Activite;
import pck_metier.Niveau;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

public class Fen_ModifActivite extends JDialog implements ActionListener
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNomActivite;
	private JTextField txtTarifHeure;
	private JLabel lblNomActivite;
	private JLabel lblNiveauActivite;
	private JLabel lblTarifHeure;
	private JButton btnAjouter;
	private JButton btnAnnuler;
	private JCheckBox chk;
	private ArrayList<Niveau> lesNiveaux;
	private JCheckBox[] lesChkBox;
	private JLabel lblNomActi;
	private JLabel lblNiveauActi;
	private JLabel lblTarifActi;
	private String chaine;

	public Fen_ModifActivite(int numBtnPar, int lignePar)
	{
		setTitle("Modifier activit\u00E9");
		this.setModal(true);

		setBounds(100, 100, 560, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(245, 245, 220));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		txtNomActivite = new JTextField();
		txtNomActivite.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtNomActivite.setText("");
		txtNomActivite.setBounds(10, 80, 220, 30);
		contentPanel.add(txtNomActivite);
		txtNomActivite.setColumns(10);

		txtTarifHeure = new JTextField();
		txtTarifHeure.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtTarifHeure.setBounds(406, 80, 120, 30);
		contentPanel.add(txtTarifHeure);
		txtTarifHeure.setColumns(10);

		lblNomActivite = new JLabel(" Nom de l'activite :");
		lblNomActivite.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNomActivite.setBounds(10, 51, 210, 30);
		contentPanel.add(lblNomActivite);

		lblNiveauActivite = new JLabel("Niveau concern\u00E9 :");
		lblNiveauActivite.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNiveauActivite.setBounds(240, 51, 194, 30);
		contentPanel.add(lblNiveauActivite);

		lblTarifHeure = new JLabel("Tarif par heure :");
		lblTarifHeure.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTarifHeure.setBounds(406, 51, 120, 30);
		contentPanel.add(lblTarifHeure);

		btnAjouter = new JButton("Modifier");
		btnAjouter.addActionListener(this);
		btnAjouter.setBounds(426, 201, 100, 26);
		contentPanel.add(btnAjouter);

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(426, 238, 100, 26);
		contentPanel.add(btnAnnuler);
		
		lblNomActi = new JLabel(" " + Fen_Principal.LES_ACTIVITES.get(lignePar).getNomActivite());
		lblNomActi.setOpaque(true);
		lblNomActi.setBackground(new Color(154, 205, 50));
		lblNomActi.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(0, 100, 0),
				new Color(128, 128, 128), new Color(0, 100, 0)));
		lblNomActi.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNomActi.setBounds(10, 11, 220, 29);
		contentPanel.add(this.lblNomActi);
		
		String chaine = "Galop ";
		int j;
		for (j = 0; j < Fen_Principal.LES_ACTIVITES.get(lignePar).getNiveauActivite().size(); j++)
		{
			if (j == (Fen_Principal.LES_ACTIVITES.get(lignePar).getNiveauActivite().size() - 1))
			{
				chaine += Fen_Principal.LES_ACTIVITES.get(lignePar).getNiveauActivite().get(j).getLibelleNiveau()
						.substring(6, 7);
			} else
			{
				chaine += Fen_Principal.LES_ACTIVITES.get(lignePar).getNiveauActivite().get(j).getLibelleNiveau()
						.substring(6, 7) + "-";
			}

		}
		
		lblNiveauActi = new JLabel(" " + chaine);
		lblNiveauActi.setOpaque(true);
		lblNiveauActi.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(0, 100, 0),
				new Color(128, 128, 128), new Color(0, 100, 0)));
		lblNiveauActi.setBackground(new Color(154, 205, 50));
		lblNiveauActi.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNiveauActi.setBounds(229, 11, 166, 29);
		contentPanel.add(this.lblNiveauActi);
		
		lblTarifActi = new JLabel(" " + Fen_Principal.LES_ACTIVITES.get(lignePar).getTarifHeure() + " €/h");
		lblTarifActi.setBackground(new Color(154, 205, 50));
		lblTarifActi.setOpaque(true);
		lblTarifActi.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(0, 100, 0),
				new Color(128, 128, 128), new Color(0, 100, 0)));
		lblTarifActi.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTarifActi.setBounds(394, 11, 140, 29);
		contentPanel.add(this.lblTarifActi);

		// Affiche la liste des niveaux
		lesChkBox = new JCheckBox[8];
		int i;
		for (i = 0; i < 8; i++)
		{
			chk = new JCheckBox(" Galop " + i);
			chk.setBackground(new Color(245, 245, 220));
			chk.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			chk.setBounds(236, 76 + 24 * i, 120, 30);
			contentPanel.add(chk);

			lesChkBox[i] = chk;
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnAjouter)
		{
			Activite lActivite;
			Niveau leNiveau;

			// Vérifie si les checkbox sont cochés, si non, la variable isItemSelected prend false
			boolean isItemSelected = false;
			int i;

			for (i = 0; i < 8; i++)
			{
				if (lesChkBox[i].isSelected())
				{
					isItemSelected = true;
				}
			}

			// Verification de saisie
			if (txtNomActivite.getText().isEmpty() || isItemSelected == false || txtTarifHeure.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,
						"Erreur: Veuillez renplir tous les champs et cocher un ou des niveaux, avant de modifier cette activité");
			} else
			{
				lActivite = new Activite(txtNomActivite.getText(), Integer.parseInt(txtTarifHeure.getText()));
				for (i = 0; i < 8; i++)
				{
					if (lesChkBox[i].isSelected())
					{
						leNiveau = new Niveau(i, "Galop " + i);
						lActivite.ajouterNiveau(leNiveau);
					}
				}

				// Ajoute la nouvelle ligne dans la base
				ActiviteDao.ajouterActivite(lActivite);

				// Récupère l'id autoincrémenté dans la base et l'affecte à l'id de l'objet lActivite
				lActivite.setIdActivite(ActiviteDao.getActiviteIdRecent());

				Fen_Principal.LES_ACTIVITES.add(lActivite);

				JOptionPane.showMessageDialog(null, "Activité modifié !");
				
				this.dispose();
			}
		}

		if (e.getSource() == btnAnnuler)
		{
			this.dispose();
		}
	}
}