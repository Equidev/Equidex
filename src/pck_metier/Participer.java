package pck_metier;

import java.sql.Date;

public class Participer
{
	private int numParticipation;
	private Date dateHeure;
	private Cheval leCheval;
	private Client leClient;
	private Activite lActivite;
	private NatureActivite laNature;
	
	public Participer(int numParticipation, Date dateHeure, Cheval leCheval, Client leClient, Activite lActivite, NatureActivite laNature)
	{
		this.numParticipation = numParticipation;
		this.dateHeure = dateHeure;
		this.leCheval = leCheval;
		this.leCheval.ajouterParticipation(this);
		this.leClient = leClient;
		this.leClient.ajouterParticipation(this);
		this.lActivite = lActivite;
		this.laNature = laNature;
	}
	
	public int getNumParticipation()
	{
		return numParticipation;
	}
	public void setNumParticipation(int numParticipation)
	{
		this.numParticipation = numParticipation;
	}
	public Date getDateHeure()
	{
		return dateHeure;
	}
	public void setDateHeure(Date dateHeure)
	{
		this.dateHeure = dateHeure;
	}
	
}