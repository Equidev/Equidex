package pck_lib;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import pck_dao.ActiviteDao;
import pck_dao.ClientDao;
import pck_ihm.Fen_Principal;

public class Outils
{

	/** Renvoie un tableau 2D de JButton des participations sur une semaine */
	public static JButton[][] getTabPlanning(JPanel panPlanning, Fen_Principal fp)
	{
		JButton res[][] = new JButton[8][6];
		JButton unBouton;
		int i, j;
		for (i = 0; i < 8; i++)
		{
			for (j = 0; j < 6; j++)
			{
				unBouton = new JButton("bouton" + i + j);
				unBouton.setBorder(new LineBorder(new Color(0, 0, 0)));
				if (i < 8 / 2)
				{
					unBouton.setBounds(65 + 145 * j, 60 + 60 * i, 145, 60);
				} else
				{
					unBouton.setBounds(65 + 145 * j, 150 + 60 * i, 145, 60);
				}
				unBouton.addActionListener(fp);
				panPlanning.add(unBouton);
				res[i][j] = unBouton;
			}
		}
		return res;
	}

	/** Renvoie l'affichage de l'onglet Planning */
	public static void affichePlanning(JPanel panPlanning)
	{
		JLabel unLabel;
		int i, j;

		/** Affichage des heures */
		for (i = 0; i < 8; i++)
		{
			if (i < 8 / 2)
			{
				unLabel = new JLabel((8 + i) + "h-" + (9 + i) + "h");
				unLabel.setBounds(5, 60 + 60 * i, 60, 60);
			} else
			{
				unLabel = new JLabel((10 + i) + "h-" + (11 + i) + "h");
				unLabel.setBounds(5, 150 + 60 * i, 60, 60);
			}
			unLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
			unLabel.setBackground(Color.LIGHT_GRAY);
			unLabel.setOpaque(true);
			panPlanning.add(unLabel);
		}

		/** Affichage de la séparation du midi */
		for (i = 0; i < 2; i++)
		{
			for (j = 0; j < 7; j++)
			{
				if (j == 0)
				{
					unLabel = new JLabel((12 + i) + "h-" + (13 + i) + "h");
					unLabel.setBounds(5, 300 + 45 * i, 60, 45);
				} else
				{
					unLabel = new JLabel();
					unLabel.setBounds(65 + 145 * (j - 1), 300 + 45 * i, 145, 45);
				}
				unLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
				unLabel.setBackground(Color.LIGHT_GRAY);
				unLabel.setOpaque(true);
				panPlanning.add(unLabel);
			}
		}

	}

	/** Renvoie l'affichage de l'onglet Activité */
	public static JButton[][] afficheActivite(JPanel panActivite, Fen_Principal fp)
	{
		int i, j;
		JLabel jlabNom, jlabNiveau, jlabTarif;
		JButton jBtnAffichActi, jBtnEditActi, jBtnSupprActi;
		JButton lesBoutons[][];
		JScrollPane jSPanLstActivite;
		JPanel panLstActivite, mainPanel;

		panLstActivite = new JPanel();
		mainPanel = new JPanel();
		mainPanel.setBounds(5, 5, 930, 552);
		mainPanel.setLayout(new BorderLayout());
		int var = Fen_Principal.LES_ACTIVITES.size();
		panLstActivite.setPreferredSize(new Dimension(930,40+60*var));
		panLstActivite.setLayout(null);


		// Liste des activités
		for (i = 0; i < Fen_Principal.LES_ACTIVITES.size(); i++)
		{
			jlabNom = new JLabel("  " + Fen_Principal.LES_ACTIVITES.get(i).getNomActivite());
			jlabNom.setOpaque(true);
			jlabNom.setBackground(new Color(154, 205, 50));
			jlabNom.setForeground(Color.BLACK);
			jlabNom.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			jlabNom.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(0, 100, 0),
					new Color(128, 128, 128), new Color(0, 100, 0)));
			jlabNom.setBounds(5, 22 + 60 * i, 320, 40);
			panLstActivite.add(jlabNom);

			// Présentation des galop dans le label Niveau
			String chaine = "  Galop ";
			for (j = 0; j < Fen_Principal.LES_ACTIVITES.get(i).getNiveauActivite().size(); j++)
			{
				if (j == (Fen_Principal.LES_ACTIVITES.get(i).getNiveauActivite().size() - 1))
				{
					chaine += Fen_Principal.LES_ACTIVITES.get(i).getNiveauActivite().get(j).getLibelleNiveau()
							.substring(6, 7);
				} else
				{
					chaine += Fen_Principal.LES_ACTIVITES.get(i).getNiveauActivite().get(j).getLibelleNiveau()
							.substring(6, 7) + "-";
				}

			}

			jlabNiveau = new JLabel(String.valueOf(chaine));
			jlabNiveau.setOpaque(true);
			jlabNiveau.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			jlabNiveau.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(0, 100, 0),
					new Color(128, 128, 128), new Color(0, 100, 0)));
			jlabNiveau.setBackground(new Color(154, 205, 50));
			jlabNiveau.setBounds(324, 22 + 60 * i, 210, 40);
			panLstActivite.add(jlabNiveau);

			jlabTarif = new JLabel("  " + String.valueOf(Fen_Principal.LES_ACTIVITES.get(i).getTarifHeure()) + " €/h");
			jlabTarif.setOpaque(true);
			jlabTarif.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			jlabTarif.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(0, 100, 0),
					new Color(128, 128, 128), new Color(0, 100, 0)));
			jlabTarif.setBackground(new Color(154, 205, 50));
			jlabTarif.setBounds(533, 22 + 60 * i, 210, 40);
			panLstActivite.add(jlabTarif);

		}

		lesBoutons = new JButton[Fen_Principal.LES_ACTIVITES.size()][3];
		int nb = ActiviteDao.getNbActivite();
		for (i = 0; i < nb ; i++)
		{

			jBtnEditActi = new JButton("btnEditerActivite" + i);
			jBtnEditActi.setText("");
			jBtnEditActi.setBackground(new Color(192, 192, 192));
			jBtnEditActi.setIcon(new ImageIcon(Fen_Principal.class.getResource("/pck_design/btnFiche.jpg")));
			jBtnEditActi.setForeground(Color.WHITE);
			jBtnEditActi.setBounds(811, 22 + 60 * i, 40, 40);
			panLstActivite.add(jBtnEditActi);

			jBtnSupprActi = new JButton("btnSupprimerActivite" + i);
			jBtnSupprActi.setText("");
			jBtnSupprActi.setBackground(new Color(192, 192, 192));
			jBtnSupprActi.setIcon(new ImageIcon(Fen_Principal.class.getResource("/pck_design/btnCorbeille.jpg")));
			jBtnSupprActi.setBounds(862, 22 + 60 * i, 40, 40);
			panLstActivite.add(jBtnSupprActi);

			jBtnEditActi.addActionListener(fp);
			jBtnSupprActi.addActionListener(fp);

			lesBoutons[i][0] = jBtnEditActi;
			lesBoutons[i][1] = jBtnSupprActi;
		}

		jSPanLstActivite = new JScrollPane(panLstActivite,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		mainPanel.add(jSPanLstActivite,BorderLayout.CENTER);
		
		
		panActivite.add(mainPanel);
		return lesBoutons;
	}

	public static JButton getBtnNouvelleActivite(JPanel panActivite, Fen_Principal fp)
	{
		JButton nouvelleActivite;
		nouvelleActivite = new JButton("");
		nouvelleActivite.setText("Ajouter une nouvelle activité");
		nouvelleActivite.setBounds(98, 580, 738, 40);
		panActivite.add(nouvelleActivite);
		nouvelleActivite.addActionListener(fp);
		return nouvelleActivite;
	}
	
	
	public static JButton[][] afficheClient(JPanel panClient, Fen_Principal fp)
	{
		int i;
		JLabel jlabNom, jlabPrenom, jlabNiveau, jlabTel;
		JButton jBtnAfficheClient, jBtnEditClient, jBtnSupprClient;
		JButton lesBoutons[][];
		JScrollPane jSPanLstClient;
		JPanel panLstClient;

		panLstClient = new JPanel();
		int var = Fen_Principal.LES_CLIENTS.size();
		panLstClient.setBounds(5, 5, 930, 40+80*var);
		panLstClient.setLayout(null);

		// Liste des clients
		for (i = 0; i < Fen_Principal.LES_CLIENTS.size(); i++)
		{
			jlabNom = new JLabel("  " + Fen_Principal.LES_CLIENTS.get(i).getNomClient());
			jlabNom.setOpaque(true);
			jlabNom.setBackground(new Color(135, 206, 250));
			jlabNom.setForeground(Color.BLACK);
			jlabNom.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			jlabNom.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(0, 100, 0),
					new Color(128, 128, 128), new Color(0, 100, 0)));
			jlabNom.setBounds(5, 22 + 60 * i, 200, 40);
			panLstClient.add(jlabNom);

			jlabPrenom = new JLabel("  " + Fen_Principal.LES_CLIENTS.get(i).getPrenomClient());
			jlabPrenom.setOpaque(true);
			jlabPrenom.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			jlabPrenom.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(0, 100, 0),
					new Color(128, 128, 128), new Color(0, 100, 0)));
			jlabPrenom.setBackground(new Color(135, 206, 250));
			jlabPrenom.setBounds(204, 22 + 60 * i, 200, 40);
			panLstClient.add(jlabPrenom);
			
			jlabNiveau = new JLabel("  Galop " + Fen_Principal.LES_CLIENTS.get(i).getLeNiveau().getLibelleNiveau());
			jlabNiveau.setOpaque(true);
			jlabNiveau.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			jlabNiveau.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(0, 100, 0),
					new Color(128, 128, 128), new Color(0, 100, 0)));
			jlabNiveau.setBackground(new Color(135, 206, 250));
			jlabNiveau.setBounds(403, 22 + 60 * i, 160, 40);
			panLstClient.add(jlabNiveau);
			
			jlabTel = new JLabel("  " + Fen_Principal.LES_CLIENTS.get(i).getTelClient());
			jlabTel.setOpaque(true);
			jlabTel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			jlabTel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(0, 100, 0),
					new Color(128, 128, 128), new Color(0, 100, 0)));
			jlabTel.setBackground(new Color(135, 206, 250));
			jlabTel.setBounds(562, 22 + 60 * i, 181, 40);
			panLstClient.add(jlabTel);
				
		}

		lesBoutons = new JButton[Fen_Principal.LES_CLIENTS.size()][3];
		for (i = 0; i < ClientDao.getNbClient(); i++)
		{
			jBtnAfficheClient = new JButton("btnEditerClient" + i);
			jBtnAfficheClient.setText("");
			jBtnAfficheClient.setBackground(new Color(192, 192, 192));
			jBtnAfficheClient.setIcon(new ImageIcon(Fen_Principal.class.getResource("/pck_design/btnLoupe.jpg")));
			jBtnAfficheClient.setBounds(762, 22 + 60 * i, 40, 40);
			panLstClient.add(jBtnAfficheClient);

			jBtnEditClient = new JButton("btnEditerClient" + i);
			jBtnEditClient.setText("");
			jBtnEditClient.setBackground(new Color(192, 192, 192));
			jBtnEditClient.setIcon(new ImageIcon(Fen_Principal.class.getResource("/pck_design/btnFiche.jpg")));
			jBtnEditClient.setForeground(Color.WHITE);
			jBtnEditClient.setBounds(811, 22 + 60 * i, 40, 40);
			panLstClient.add(jBtnEditClient);

			jBtnSupprClient = new JButton("btnSupprimerClient" + i);
			jBtnSupprClient.setText("");
			jBtnSupprClient.setBackground(new Color(192, 192, 192));
			jBtnSupprClient.setIcon(new ImageIcon(Fen_Principal.class.getResource("/pck_design/btnCorbeille.jpg")));
			jBtnSupprClient.setBounds(862, 22 + 60 * i, 40, 40);
			panLstClient.add(jBtnSupprClient);

			jBtnAfficheClient.addActionListener(fp);
			jBtnEditClient.addActionListener(fp);
			jBtnSupprClient.addActionListener(fp);

			lesBoutons[i][0] = jBtnAfficheClient;
			lesBoutons[i][1] = jBtnEditClient;
			lesBoutons[i][2] = jBtnSupprClient;
			
			System.out.println(i);
		}

		jSPanLstClient = new JScrollPane(panLstClient);
		jSPanLstClient.setBounds(5, 5, 930, 552);
		panClient.add(jSPanLstClient);

		return lesBoutons;
	}

	public static JButton getBtnNouveauClient(JPanel panClient, Fen_Principal fp)
	{
		JButton nouveauClient;
		nouveauClient = new JButton("");
		nouveauClient.setText("Ajouter un nouveau client");
		nouveauClient.setBounds(98, 580, 738, 40);
		panClient.add(nouveauClient);
		nouveauClient.addActionListener(fp);
		return nouveauClient;
	}
}
