package pck_dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import pck_metier.Activite;
import pck_metier.Niveau;

public class ActiviteDao
{
	// DAO Activité
	public static Vector<Activite> getActivites()
	{
		Vector<Activite> lesActivites;
		lesActivites = new Vector<Activite>();

		Connection connect = MysqlDao.getConnection(); 

		// Execution d'une requete
		String req = "SELECT * FROM activite ORDER BY nomActivite";

		try
		{
			Statement stlien = connect.createStatement();
			ResultSet res = stlien.executeQuery(req);

			// Traitement du résultat
			Activite uneActivite;

			while (res.next())
			{
				uneActivite = new Activite(res.getInt("idActivite"), res.getString("nomActivite"),
						res.getDouble("tarifheure"));

				// Requete qui va chercher tous les niveaux de l'activité en cour
				String req2 = "SELECT N.idNiveau, libelleNiveau FROM niveau N, referer R "
							+ "WHERE N.idNiveau = R.idNiveau " + "AND R.idActivite =" + res.getInt("idActivite");

				Statement stlien2 = connect.createStatement();
				ResultSet res2 = stlien2.executeQuery(req2);

				while (res2.next())
				{
					// Construire une objet metier niveau
					Niveau unNiveau = new Niveau(res2.getInt("idNiveau"), res2.getString("libelleNiveau"));

					// Ajouter le niveau dans la collection niveau
					uneActivite.ajouterNiveau(unNiveau);
				}
				res2.close();
				stlien2.close();
				lesActivites.add(uneActivite);
			}
			res.close();
			stlien.close();
			connect.close();
		} catch (Exception e)
		{
			System.out.println("Erreur lors de l'execution de la requête pour getActivite() : " + e.getMessage() + "\n");
		}

		return lesActivites;
	}
	
	public static void ajouterActivite(Activite lActivite)
	{
		ArrayList<Niveau> lesNiveaux;
		lesNiveaux = lActivite.getNiveauActivite();

		Connection connect = MysqlDao.getConnection(); // Utilisation de
														// connexion générique
														// pour Mysql

		// Création des requêtes
		String reqInsert = "INSERT INTO Activite (nomactivite,tarifheure) VALUES ('" + lActivite.getNomActivite()
				+ "','" + lActivite.getTarifHeure() + "')";

		String reqActi = "select activite.idactivite from activite left join referer on activite.idactivite = referer.idactivite where activite.idactivite not in ( select idactivite from referer)";

		// Insertion des données
		try
		{
			Statement stlien = connect.createStatement();
			stlien.executeUpdate(reqInsert);
			stlien.close();
		} catch (Exception e)
		{
			System.out.println("Erreur dans l'insertion d'une activité");
		}

		// Récupération de l'id et insertion dans referer
		try
		{
			Statement stlien2 = connect.createStatement();
			ResultSet res = stlien2.executeQuery(reqActi);

			while (res.next())
			{
				for (Niveau unNiveau : lesNiveaux)
				{
					Statement stlien3 = connect.createStatement();
					String reqInsertRef = "insert into referer values(" + res.getInt(1) + "," + (unNiveau.getIdNiveau() + 1) + ")";
					stlien3.executeUpdate(reqInsertRef);
					stlien3.close();
				}
			}

			res.close();
			stlien2.close();
			// Fermeture de la connexion
			connect.close();
		} catch (Exception e)
		{
			System.out.println(
					"Erreur lors de l'execution de la requête pour ajouterActivite() : " + e.getMessage() + "\n");
		}
	}
	
	public static void modifierActivite(Activite lActivite)
	{
		ArrayList<Niveau> lesNiveaux;
		lesNiveaux = lActivite.getNiveauActivite();
		
		Connection connect = MysqlDao.getConnection();
		
		//Requetes
		String reqModif = "UPDATE activite SET nomActivite="+ lActivite.getNomActivite() +
							", tarifHeure="+ lActivite.getTarifHeure() +" WHERE idactivite=" + lActivite.getIdActivite();
		
		String reqSuppr = "DELETE FROM referer WHERE idActivite="+ lActivite.getIdActivite();
				
		String reqAjout = "select activite.idactivite from activite left join referer on activite.idactivite = referer.idactivite where activite.idactivite not in ( select idactivite from referer)";	

		// Modification dans la table activite
		try
		{
			Statement stlien = connect.createStatement();
			stlien.executeUpdate(reqModif);
			stlien.close();
		} catch (Exception e)
		{
			System.out.println("Erreur dans la modification d'une activité");
		}
		
		// Suppresion des niveaux de l'activité
		try
		{
			Statement stlien2 = connect.createStatement();
			stlien2.executeUpdate(reqModif);
			stlien2.close();
		} catch (Exception e)
		{
			System.out.println("Erreur dans la supression des niveau de l'activité");
		}

		// Récupération de l'id et insertion des nouveaux niveaux dans referer
		try
		{
			Statement stlien3 = connect.createStatement();
			ResultSet res = stlien3.executeQuery(reqAjout);

			while (res.next())
			{
				for (Niveau unNiveau : lesNiveaux)
				{
					Statement stlien4 = connect.createStatement();
					String reqInsertRef = "insert into referer values(" + res.getInt(1) + "," + (unNiveau.getIdNiveau() + 1) + ")";
					stlien4.executeUpdate(reqInsertRef);
					stlien4.close();
				}
			}

			res.close();
			stlien3.close();
			// Fermeture de la connexion
			connect.close();
		} catch (Exception e)
		{
			System.out.println("Erreur lors de l'execution de la requête pour modifierActivite() : " + e.getMessage() + "\n");
		}
	}
	
	public static void supprimerActivite(Activite lActivite)
	{
		Connection connect = MysqlDao.getConnection();
		
		//Requete
		String reqSuppr1 = "DELETE FROM Referer WHERE idActivite=" + lActivite.getIdActivite();
		String reqSuppr2 = "DELETE FROM activite WHERE idActivite=" + lActivite.getIdActivite();
		
		//Suppression des données dans activité
		try
		{
			Statement stlien1 = connect.createStatement();
			stlien1.executeUpdate(reqSuppr1);
			stlien1.close();
		} catch (Exception e)
		{
			System.out.println("Erreur dans la supression d'une activité");
		}
		
		//Suppression des données dans referer
		try
		{
			Statement stlien2 = connect.createStatement();
			stlien2.executeUpdate(reqSuppr2);
			stlien2.close();
		} catch (Exception e)
		{
			System.out.println("Erreur dans la supression des niveau associé à l'activité");
		}
	}
	
	public static int getNbActivite()
	{
		int nb = 0;
		String req = "select count(*) from activite";
		try
		{
			Connection connect = MysqlDao.getConnection();
			Statement stlien = connect.createStatement();
			ResultSet res = stlien.executeQuery(req);
			while (res.next())
			{
				nb = res.getInt(1); // 1 signifie la premiere colonne
			}
			res.close();
			stlien.close();
			connect.close();
		} catch (Exception e)
		{
			System.out.println("Erreur dans getNbActivite()");
		}
		return nb;
	}

	/** Renvoie l'id d'Activité le plus grand ( le plus recent) */
	public static int getActiviteIdRecent()
	{
		int id = 0;
		String req = "select max(idactivite) from activite";
		try
		{
			Connection connect = MysqlDao.getConnection();
			Statement stlien = connect.createStatement();
			ResultSet res = stlien.executeQuery(req);
			while (res.next())
			{
				id = res.getInt(1); // 1 signifie la premiere colonne
			}
			res.close();
			stlien.close();
			connect.close();
		} catch (Exception e)
		{
			System.out.println("Erreur dans getNbActivite()");
		}
		return id;
	}

}