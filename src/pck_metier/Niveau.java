package pck_metier;

public class Niveau
{
	private int idNiveau;
	private String libelleNiveau;
	
	public Niveau(int idNiveau, String libelleNiveau)
	{
		this.idNiveau = idNiveau;
		this.libelleNiveau = libelleNiveau;
	}
	
	public int getIdNiveau()
	{
		return idNiveau;
	}
	public void setIdNiveau(int idNiveau)
	{
		this.idNiveau = idNiveau;
	}
	public String getLibelleNiveau()
	{
		return libelleNiveau;
	}
	public void setLibelleNiveau(String libelleNiveau)
	{
		this.libelleNiveau = libelleNiveau;
	}

	@Override
	public String toString()
	{
		return this.libelleNiveau;
	}

}