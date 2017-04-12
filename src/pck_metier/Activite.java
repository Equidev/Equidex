package pck_metier;

import java.util.ArrayList;

public class Activite
{
	private int idActivite;
	private String nomActivite;
	private double tarifHeure;
	private ArrayList<Niveau> lesNiveaux;
	
	public Activite(int idActivite, String nomActivite, double tarifHeure)
	{
		this.idActivite = idActivite;
		this.nomActivite = nomActivite;
		this.tarifHeure = tarifHeure;
		this.lesNiveaux = new ArrayList<Niveau>();
	}
	
	public Activite(String nomActivite, double tarifHeure)
	{
		this.idActivite = -1;
		this.nomActivite = nomActivite;
		this.tarifHeure = tarifHeure;
		this.lesNiveaux = new ArrayList<Niveau>();
	}

	public int getIdActivite()
	{
		return idActivite;
	}
	public void setIdActivite(int idActivite)
	{
		this.idActivite = idActivite;
	}
	public String getNomActivite()
	{
		return nomActivite;
	}
	public void setNomActivite(String nomActivite)
	{
		this.nomActivite = nomActivite;
	}
	public double getTarifHeure()
	{
		return tarifHeure;
	}
	public void setTarifHeure(double tarifHeure)
	{
		this.tarifHeure = tarifHeure;
	}
	
	//-------------------------------------------------------------------//
	// AJOUTER un Niveau
	public void ajouterNiveau(Niveau unNiveau)
	{
		this.lesNiveaux.add(unNiveau);
	}
	
	// SUPPRIMER un Niveau
	public void supprimerNiveau(Niveau leNiveau)
	{
		this.lesNiveaux.remove(leNiveau);
	}
	
	// AFFICHER le niveau pour l'activite courante
	public ArrayList<Niveau> getNiveauActivite()
	{
		return this.lesNiveaux;
	}
	
	@Override
	public String toString()
	{
		String chaine = this.nomActivite+" Galop ";
		int j;
		for (j = 0; j < this.lesNiveaux.size(); j++)
		{
			if (j == (this.lesNiveaux.size() - 1))
			{
				chaine += this.lesNiveaux.get(j).getLibelleNiveau().substring(6, 7);
			} else
			{
				chaine += this.lesNiveaux.get(j).getLibelleNiveau()
						.substring(6, 7) + "-";
			}

		}
		return chaine;
	}
	
}