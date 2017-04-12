package pck_ihm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import pck_ctr.Controleur;
import pck_dao.ActiviteDao;
import pck_dao.ClientDao;
import pck_dao.PlanningDao;
import pck_lib.Outils;
import pck_metier.Activite;
import pck_metier.Client;
import pck_metier.NatureActivite;

public class Fen_Principal extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JPanel panRecap;
	private JPanel panActivite;
	private JPanel panCheval;
	private JPanel panPlanning;
	private JPanel panClient;
	// private JPanel panLstActivite;
	private JScrollBar scrollBar;
	private JButton nouvelleActivite;
	private JButton nouveauClient;
	private JButton lesBtnActivite[][];
	private JButton lesBtnPlanning[][];
	private JButton lesBtnClient[][];
	private int i, j;
	private JLabel lblLundi;
	private JLabel lblMardi;
	private JLabel lblMercredi;
	private JLabel lblJeudi;
	private JLabel lblVendredi;
	private JLabel lblSamedi;

	public static Vector<Activite> LES_ACTIVITES;
	public static Vector<Client> LES_CLIENTS;
	public static Vector<NatureActivite> LES_NATURES;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Fen_Principal frame = new Fen_Principal();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fen_Principal()
	{	
		LES_ACTIVITES = ActiviteDao.getActivites();
		LES_CLIENTS = ClientDao.getClients();
		LES_NATURES = PlanningDao.getLesNatures();

		setTitle("E-quidex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBackground(new Color(255, 165, 0));
		tabbedPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		tabbedPane.setBounds(0, 0, 944, 682);
		contentPane.add(tabbedPane);

		/** Onglet Planning */
		panPlanning = new JPanel();
		tabbedPane.addTab("Planning", null, panPlanning, null);
		panPlanning.setLayout(null);
		
		lblLundi = new JLabel("Lundi");
		lblLundi.setBackground(new Color(245, 245, 220));
		lblLundi.setHorizontalAlignment(SwingConstants.CENTER);
		lblLundi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblLundi.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblLundi.setBounds(64, 31, 147, 30);
		panPlanning.add(lblLundi);
		
		lblMardi = new JLabel("Mardi");
		lblMardi.setHorizontalAlignment(SwingConstants.CENTER);
		lblMardi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblMardi.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblMardi.setBounds(209, 31, 147, 30);
		panPlanning.add(lblMardi);
		
		lblMercredi = new JLabel("Mercredi");
		lblMercredi.setHorizontalAlignment(SwingConstants.CENTER);
		lblMercredi.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblMercredi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblMercredi.setBounds(354, 31, 147, 30);
		panPlanning.add(lblMercredi);
		
		lblJeudi = new JLabel("Jeudi");
		lblJeudi.setHorizontalAlignment(SwingConstants.CENTER);
		lblJeudi.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblJeudi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblJeudi.setBounds(499, 31, 147, 30);
		panPlanning.add(lblJeudi);
		
		lblVendredi = new JLabel("Vendredi");
		lblVendredi.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendredi.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblVendredi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblVendredi.setBounds(644, 31, 147, 30);
		panPlanning.add(lblVendredi);
		
		lblSamedi = new JLabel("Samedi");
		lblSamedi.setHorizontalAlignment(SwingConstants.CENTER);
		lblSamedi.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblSamedi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblSamedi.setBounds(789, 31, 147, 30);
		panPlanning.add(lblSamedi);

		Outils.affichePlanning(panPlanning);
		lesBtnPlanning = Outils.getTabPlanning(panPlanning, this);

		
		/** Onglet recap */
		panRecap = new JPanel();
		tabbedPane.addTab("R\u00E9capitulatif", null, panRecap, null);
		panRecap.setLayout(null);
				
		/** Onglet Activité */
		panActivite = new JPanel();
		panActivite.setBackground(new Color(245, 245, 220));
		panActivite.setLayout(null);
		tabbedPane.addTab("Activit\u00E9s", null, panActivite, null);
		
		lesBtnActivite = Outils.afficheActivite(panActivite, this);
		nouvelleActivite = Outils.getBtnNouvelleActivite(panActivite, this);

		
		/** Onglet Client */
		panClient = new JPanel();
		panClient.setBackground(new Color(245, 245, 220));
		tabbedPane.addTab("Client", null, panClient, null);
		panClient.setLayout(null);
		
		lesBtnClient = Outils.afficheClient(panClient, this);
		nouveauClient = Outils.getBtnNouveauClient(panClient, this);

		
		/** Onglet cheval */
		panCheval = new JPanel();
		tabbedPane.addTab("Chevaux", null, panCheval, null);
		panCheval.setLayout(null);		
	}

	/** Permet de rafraichir l'onglet activité */
	public void refreshActivite()
	{
		this.panActivite.removeAll();
		this.lesBtnActivite = Outils.afficheActivite(panActivite, this);
		this.nouvelleActivite = Outils.getBtnNouvelleActivite(panActivite, this);
		this.invalidate();
		this.revalidate();
		this.repaint();
	}
	
	/** Permet de rafraichir l'onglet activité */
	public void refreshClient()
	{
		this.panClient.removeAll();
		//this.lesBtnClients = Outils.afficheClient(panClient, this);
		this.nouveauClient = Outils.getBtnNouveauClient(panClient, this);
		this.invalidate();
		this.revalidate();
		this.repaint();
	}

	public void actionPerformed(ActionEvent e)
	{

		Controleur.action(tabbedPane.getSelectedIndex(), e.getSource(), panPlanning, panRecap, panActivite, panClient,
				panCheval, lesBtnPlanning, lesBtnActivite, nouvelleActivite, nouveauClient, this);

	}
}