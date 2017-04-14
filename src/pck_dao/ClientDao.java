package pck_dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import pck_metier.Client;
import pck_metier.Niveau;

public class ClientDao
{
	public static Vector<Client> getClients()
	{
		Vector<Client> lesClients;
		lesClients = new Vector<Client>();

		Connection connect = MysqlDao.getConnection(); 

		// Execution d'une requete
		String req = "SELECT * FROM client ORDER BY nomClient";

		try
		{
			Statement stlien = connect.createStatement();
			ResultSet res = stlien.executeQuery(req);

			// Traitement du résultat
			Client unClient;

			while (res.next())
			{
				unClient = new Client(res.getInt("idClient"), res.getString("nomClient"), res.getString("prenomClient"), 
										res.getString("mailClient"), res.getString("telClient"), res.getString("rueClient"), res.getString("CPClient"), 
										 res.getString("villeClient"), res.getDate("dateNaissClient"), new Niveau(res.getInt("idNiveau"), res.getString("idNiveau")));
				lesClients.add(unClient);
			}
			res.close();
			stlien.close();
			connect.close();			
		} catch (Exception e)
		{
			System.out.println("Erreur lors de l'execution de la requête pour getClient() : " + e.getMessage() + "\n");
		}

		return lesClients;
	}
	
	public static void ajouterClient(Client leClient)
	{
		Connection connect = MysqlDao.getConnection(); 

		//Formatage du java util date pour implément dans la base
//	    DateFormat maDF = new SimpleDateFormat("dd/MM/yyyy");
//	    maDF.format(leClient.getDateNaissClient().getDate()); 
	    //java.sql.Date maD = ;
		Date uneDate = Date.valueOf("2000-06-24");
		
		String reqInsert = "INSERT INTO client (nomClient, prenomClient, mailClient, telClient, CPClient, rueClient, villeClient, dateNaissClient, idNiveau)" +
							"VALUES ('" + leClient.getNomClient() +"','"+ leClient.getPrenomClient() +"','"+ leClient.getMailClient() +"','"+ leClient.getTelClient() +
							"','"+ leClient.getCPClient() +"','"+ leClient.getRueClient() +"','"+ leClient.getVilleClient() +"','"+ leClient.getDateNaissClient() +"','"+ leClient.getLeNiveau().getIdNiveau() +"')";

		try
		{
			Statement stlien = connect.createStatement();
			stlien.executeUpdate(reqInsert);
			stlien.close();
		} catch (Exception e)
		{
			System.out.println("Erreur dans l'insertion d'un client : \n" + e.getMessage() + "\n");
		}
	}
	
	public static void modifierClient(Client leClient)
	{
		
	}
	
	public static void supprimerClient(Client leClient)
	{
		
	}
	
	public static int getNbClient()
	{
		int nb = 0;
		String req = "select count(*) from client";
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
			System.out.println("Erreur dans getNbClient()");
		}
		return nb;
	}

	/** Renvoie l'id d'Activité le plus grand ( le plus recent) */
	public static int getClientIdRecent()
	{
		int id = 0;
		String req = "select max(idClient) from client";
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
			System.out.println("Erreur dans getClientIdRecent()");
		}
		return id;
	}

	public static Vector<Niveau> getNiveaux()
	{
		Vector<Niveau> lesNiveaux;
		lesNiveaux = new Vector<Niveau>();

		Connection connect = MysqlDao.getConnection(); 

		// Execution d'une requete
		String req = "SELECT * FROM niveau";

		try
		{
			Statement stlien = connect.createStatement();
			ResultSet res = stlien.executeQuery(req);

			// Traitement du résultat
			Niveau unNiveau;

			while (res.next())
			{
				unNiveau = new Niveau(res.getInt("idNiveau"), res.getString("libelleNiveau"));
				lesNiveaux.add(unNiveau);
			}
			res.close();
			stlien.close();
			connect.close();			
		} catch (Exception e)
		{
			System.out.println("Erreur lors de l'execution de la requête pour getNiveau() : " + e.getMessage() + "\n");
		}

		return lesNiveaux;
	}
}