package pck_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDao
{
	public static Connection getConnection()
	{
		// Chargement des pilotes
		final String nomPilote1 = "com.mysql.jdbc.Driver";

		try
		{
			Class.forName(nomPilote1);
		} catch (ClassNotFoundException e)
		{
			System.out.println("Probl�me de chargement du driver: " + e.getMessage());
		}

		// Etablissement de la connexion � la base
		final String base = "jdbc:mysql://localhost/equidex?useSSL=false"; // adresse /nom de
																// la base
		final String user = "root";
		final String pswd = "";
		// Etablissement de la connexion � la base
		Connection connect = null;

		try
		{
			connect = DriverManager.getConnection(base, user, pswd);
		} catch (SQLException e)
		{
			System.out.println("Probl�me lors de la connexion � la base de donn�e: " + e.getMessage());
		}
		return connect;
	}
}