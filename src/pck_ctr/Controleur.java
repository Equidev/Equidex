package pck_ctr;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pck_dao.ActiviteDao;
import pck_ihm.Fen_AjouterActivite;
import pck_ihm.Fen_AjouterClient;
import pck_ihm.Fen_ModifActivite;
import pck_ihm.Fen_Principal;
import pck_metier.Activite;

public class Controleur
{
	public static void action(int numOnglet, Object objetCliquer, JPanel panPlanning, JPanel panRecap,
			JPanel panActivite, JPanel panClient, JPanel panCheval, JButton lesBtnPlanning[][],
			JButton lesBtnActivite[][], JButton nouvelleActivite, JButton nouveauClient, Fen_Principal fp)
	{
		int i, j;
		Fen_AjouterActivite fenAjouterActivite;
		Fen_ModifActivite fenModifActivite;
		Fen_AjouterClient fenAjouterClient;

		switch (numOnglet)
			{
			// Onglet Planning
			case 0:
				for (i=0;i<8;i++)
				{
					for (j=0;j<6;j++)
					{
						if (objetCliquer == lesBtnPlanning[i][j])
						{
							PlanningCtr.getContenuHoraire(i,j);
						}
					}
				}
				break;
				// Onglet Recap
			case 1:
				break;
				// Onglet Activite
			case 2:
				for (i = 0; i < Fen_Principal.LES_ACTIVITES.size(); i++)

				{
					if (objetCliquer == lesBtnActivite[i][0])
					{
						// Ouvre la fenêtre modale Fen_AjouterActivite
						fenModifActivite = new Fen_ModifActivite(0, i);
						fenModifActivite.setBounds(20, 20, 560, 324);
						fenModifActivite.setLocation(280, 280);
						fenModifActivite.setModal(true);
						fenModifActivite.setVisible(true);
						while (fp.isFocusable() == false)
						{
							// Bloque le déroulement du code tant que la fenetre
							// est afficher
						}
						fp.refreshActivite();
					}

					if (objetCliquer == lesBtnActivite[i][1])
					{
						Activite lActivite;

						lActivite = Fen_Principal.LES_ACTIVITES.get(i);
						Fen_Principal.LES_ACTIVITES.remove(i);
						ActiviteDao.supprimerActivite(lActivite);
						JOptionPane.showMessageDialog(null, "Activité supprimé !");
						fp.refreshActivite();
					}

					if (objetCliquer == lesBtnActivite[i][2])
					{
						System.out.println("Coucou");
					}
				}

				// Bouton pour crée une nouvelle activité
				if (objetCliquer == nouvelleActivite)
				{
					// Ouvre la fenêtre modale Fen_AjouterActivite
					fenAjouterActivite = new Fen_AjouterActivite();
					fenAjouterActivite.setBounds(20, 20, 560, 284);
					fenAjouterActivite.setLocation(280, 280);
					fenAjouterActivite.setModal(true);
					fenAjouterActivite.setVisible(true);
					while (fp.isFocusable() == false)
					{
						// Bloque le déroulement du code tant que la fenetre est
						// afficher
					}
					fp.refreshActivite();
				}
				
				break;
				// Onglet Client
			case 3:
				// Bouton pour crée une nouvelle activité
				if (objetCliquer == nouveauClient)
				{
					// Ouvre la fenêtre modale Fen_AjouterActivite
					fenAjouterClient = new Fen_AjouterClient();
					fenAjouterClient.setBounds(20, 20, 560, 360);
					fenAjouterClient.setLocation(280, 280);
					fenAjouterClient.setModal(true);
					fenAjouterClient.setVisible(true);
					while (fp.isFocusable() == false)
					{
						// Bloque le déroulement du code tant que la fenetre est
						// afficher
					}
					fp.refreshClient();
				}
				break;
				// Onglet Cheval
			case 4:
				break;
			}
	}
}
