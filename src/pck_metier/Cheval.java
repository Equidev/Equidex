package pck_metier;

import java.sql.Date;
import java.util.ArrayList;

public class Cheval
{
	private int idCheval;
	private String nomCheval;
	private Date dateNaissCheval;
	private String matriculeCheval;
	private char sexeCheval;
	private ArrayList<Participer> lesParticipations;
	
	public Cheval(int idCheval, String nomCheval, Date dateNaissCheval, String matriculeCheval, char sexeCheval)
	{
		this.idCheval = idCheval;
		this.nomCheval = nomCheval;
		this.dateNaissCheval = dateNaissCheval;
		this.matriculeCheval = matriculeCheval;
		this.sexeCheval = sexeCheval;
	}

	public int getIdCheval()
	{
		return idCheval;
	}
	public void setIdCheval(int idCheval)
	{
		this.idCheval = idCheval;
	}
	public String getNomCheval()
	{
		return nomCheval;
	}
	public void setNomCheval(String nomCheval)
	{
		this.nomCheval = nomCheval;
	}
	public Date getDateNaissCheval()
	{
		return dateNaissCheval;
	}
	public void setDateNaissCheval(Date dateNaissCheval)
	{
		this.dateNaissCheval = dateNaissCheval;
	}
	public String getMatriculeCheval()
	{
		return matriculeCheval;
	}
	public void setMatriculeCheval(String matriculeCheval)
	{
		this.matriculeCheval = matriculeCheval;
	}
	public char getSexeCheval()
	{
		return sexeCheval;
	}
	public void setSexeCheval(char sexeCheval)
	{
		this.sexeCheval = sexeCheval;
	}
	
	//-------------------------------------------------------------------//
	//AJOUTER une participation
	public void ajouterParticipation(Participer uneParticipation)
	{
		this.lesParticipations.add(uneParticipation);
	}
	
	//SUPPRIMER une participation
	public void supprimerParticipation(Participer laParticipation)
	{
		this.lesParticipations.remove(laParticipation);
	}
	
}