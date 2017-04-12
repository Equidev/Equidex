package pck_metier;

public class NatureActivite
{
	private int idNature;
	private String libelleNature;
	
	public NatureActivite(int idNature, String libelleNature)
	{
		this.idNature = idNature;
		this.libelleNature = libelleNature;
	}
	

	public int getIdNature()
	{
		return idNature;
	}

	public void setIdNature(int idNature)
	{
		this.idNature = idNature;
	}

	public String getLibelleNature()
	{
		return libelleNature;
	}

	public void setLibelleNature(String libelleNature)
	{
		this.libelleNature = libelleNature;
	}
	
}