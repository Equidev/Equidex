package pck_ctr;

import pck_ihm.Fen_Planning;

public class PlanningCtr
{
	public static void getContenuHoraire(int horaire, int jour)
	{
		Fen_Planning fenPlanning;
		fenPlanning = new Fen_Planning(horaire,jour);
		fenPlanning.setBounds(100, 100, 600, 540);
		fenPlanning.setModal(true);
		fenPlanning.setVisible(true);}
}

//tu verra ce que sa donne
//test eclioe