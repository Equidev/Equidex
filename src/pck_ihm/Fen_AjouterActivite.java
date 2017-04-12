package pck_ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pck_dao.ActiviteDao;
import pck_metier.Activite;
import pck_metier.Niveau;

public class Fen_AjouterActivite extends JDialog implements ActionListener
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

	public Fen_AjouterActivite()
	{
		setTitle("Ajouter une nouvelle activit\u00E9");
		this.setModal(true);

		setBounds(100, 100, 560, 284);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(245, 245, 220));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		txtNomActivite = new JTextField();
		txtNomActivite.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtNomActivite.setText("");
		txtNomActivite.setBounds(10, 40, 220, 30);
		contentPanel.add(txtNomActivite);
		txtNomActivite.setColumns(10);

		txtTarifHeure = new JTextField();
		txtTarifHeure.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtTarifHeure.setBounds(406, 40, 120, 30);
		contentPanel.add(txtTarifHeure);
		txtTarifHeure.setColumns(10);

		lblNomActivite = new JLabel("Nom de l'activite :");
		lblNomActivite.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNomActivite.setBounds(10, 11, 210, 30);
		contentPanel.add(lblNomActivite);

		lblNiveauActivite = new JLabel("Niveau concern\u00E9 :");
		lblNiveauActivite.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNiveauActivite.setBounds(240, 11, 194, 30);
		contentPanel.add(lblNiveauActivite);

		lblTarifHeure = new JLabel("Tarif par heure :");
		lblTarifHeure.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTarifHeure.setBounds(406, 11, 120, 30);
		contentPanel.add(lblTarifHeure);

		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(this);
		btnAjouter.setBounds(426, 161, 100, 26);
		contentPanel.add(btnAjouter);

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(426, 198, 100, 26);
		contentPanel.add(btnAnnuler);

		// Affiche la liste des niveaux
		lesChkBox = new JCheckBox[8];
		int i;
		for (i = 0; i < 8; i++)
		{
			chk = new JCheckBox(" Galop " + i);
			chk.setBackground(new Color(245, 245, 220));
			chk.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			chk.setBounds(236, 36 + 24 * i, 120, 30);
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

			// Vérifie si les checkbox sont cochés, si non, la variable
			// isItemSelected prend false
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
				JOptionPane.showMessageDialog(null, "Erreur: Veuillez renplir tous les champs et cocher un ou des niveaux, avant d'ajouté une activité");
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

				// Récupère l'id autoincrémenté dans la base et l'affecte à l'id
				// de l'objet lActivite
				lActivite.setIdActivite(ActiviteDao.getActiviteIdRecent());

				Fen_Principal.LES_ACTIVITES.add(lActivite);

				JOptionPane.showMessageDialog(null, "Activité ajouté !");
				
				this.dispose();
			}
		}

		if (e.getSource() == btnAnnuler)
		{
			this.dispose();
		}
	}
}