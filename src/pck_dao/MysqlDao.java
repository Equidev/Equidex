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
			System.out.println("Problème de chargement du driver: " + e.getMessage());
		}

		// Etablissement de la connexion à la base
		final String base = "jdbc:mysql://localhost/equidex?useSSL=false"; // adresse /nom de
																// la base
		final String user = "root";
		final String pswd = "";
		// Etablissement de la connexion à la base
		Connection connect = null;

		try
		{
			connect = DriverManager.getConnection(base, user, pswd);
		} catch (SQLException e)
		{
			System.out.println("Problème lors de la connexion à la base de donnée: " + e.getMessage());
		}
		return connect;
	}
}