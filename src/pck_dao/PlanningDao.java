package pck_dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import pck_metier.NatureActivite;

public class PlanningDao
{
	public static Vector<NatureActivite> getLesNatures(){
		Vector<NatureActivite> lesNatures;
		lesNatures = new Vector<NatureActivite>();
		
		Connection connect = MysqlDao.getConnection();
		
		String req = "select * from natureacti";
		
		try{
			Statement stlien = connect.createStatement();
			ResultSet res = stlien.executeQuery(req);
			
			while (res.next())
			{
				lesNatures.add(new NatureActivite(res.getInt("idNature"),res.getString("libelleNature")));
			}
		}
		catch (Exception e)
		{
			System.out.println("Erreur lors de l'execution de la requête pour getLesNatures() : " + e.getMessage() + "\n");
		}
		
		return lesNatures;
	}
}
