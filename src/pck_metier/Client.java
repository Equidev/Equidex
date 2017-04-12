package pck_metier;

import java.util.ArrayList;
import java.util.Date;

public class Client
{
	private int idClient;
	private String nomClient;
	private String prenomClient;
	private String mailClient;
	private String telClient;
	private String rueClient;
	private String CPClient;
	private String villeClient;
	private Date dateNaissClient;
	private Niveau leNiveau;
	private ArrayList<Participer> lesParticipations;
	
	public Client(int idClient, String nomClient, String prenomClient, String mailClient, String telClient,
			String rueClient, String cPClient, String villeClient, Date dateNaissClient, Niveau leNiveau)
	{
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.mailClient = mailClient;
		this.telClient = telClient;
		this.rueClient = rueClient;
		this.CPClient = cPClient;
		this.villeClient = villeClient;
		this.dateNaissClient = dateNaissClient;
		this.leNiveau = leNiveau;
		this.lesParticipations = new ArrayList<Participer>();
	}
	
	public Client(String nomClient, String prenomClient, String mailClient, String telClient,
			String rueClient, String cPClient, String villeClient, Date dateNaissClient, Niveau leNiveau)
	{
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.mailClient = mailClient;
		this.telClient = telClient;
		this.rueClient = rueClient;
		this.CPClient = cPClient;
		this.villeClient = villeClient;
		this.dateNaissClient = dateNaissClient;
		this.leNiveau = leNiveau;
		this.lesParticipations = new ArrayList<Participer>();
	}

	public int getIdClient()
	{
		return idClient;
	}
	public void setIdClient(int idClient)
	{
		this.idClient = idClient;
	}
	public String getNomClient()
	{
		return nomClient;
	}
	public void setNomClient(String nomClient)
	{
		this.nomClient = nomClient;
	}
	public String getPrenomClient()
	{
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient)
	{
		this.prenomClient = prenomClient;
	}
	public String getMailClient()
	{
		return mailClient;
	}
	public void setMailClient(String mailClient)
	{
		this.mailClient = mailClient;
	}
	public String getTelClient()
	{
		return telClient;
	}
	public void setTelClient(String telClient)
	{
		this.telClient = telClient;
	}
	public String getRueClient()
	{
		return rueClient;
	}
	public void setRueClient(String rueClient)
	{
		this.rueClient = rueClient;
	}
	public String getCPClient()
	{
		return CPClient;
	}
	public void setCPClient(String cPClient)
	{
		CPClient = cPClient;
	}
	public String getVilleClient()
	{
		return villeClient;
	}
	public void setVilleClient(String villeClient)
	{
		this.villeClient = villeClient;
	}
	public Date getDateNaissClient()
	{
		return dateNaissClient;
	}
	public void setDateNaissClient(Date dateNaissClient)
	{
		this.dateNaissClient = dateNaissClient;
	}

	public Niveau getLeNiveau()
	{
		return leNiveau;
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