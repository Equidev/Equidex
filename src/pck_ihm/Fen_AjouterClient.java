package pck_ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import pck_dao.ClientDao;
import pck_metier.Client;
import pck_metier.Niveau;

public class Fen_AjouterClient extends JDialog implements ActionListener
{

	private final JPanel contentPanel = new JPanel();
	private JButton btnAjouter;
	private JButton btnAnnuler;
	private JLabel lblTxt1;
	private JLabel lblTxt2;
	private JLabel lblTxt3;
	private JLabel lblTxt4;
	private JLabel lblTxt5;
	private JLabel lblTxt6;
	private JLabel lblTxt7;
	private JLabel lblTxt8;
	private JComboBox cbxGrade;
	private JLabel lbltxt9;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JDateChooser dateNaissJDC;
	private JTextField txtTel;
	private JTextField txtMail;
	private JTextField txtRue;
	private JTextField txtVille;
	private JTextField txtCP;
	
	public Fen_AjouterClient()
	{
		setTitle("Ajouter un nouveau client");
		setBounds(100, 100, 560, 360);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(245, 245, 220));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(this);
		btnAjouter.setBounds(423, 234, 100, 26);
		contentPanel.add(btnAjouter);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBounds(423, 271, 100, 26);
		contentPanel.add(btnAnnuler);
		
		lblTxt1 = new JLabel("Nom :");
		lblTxt1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTxt1.setBounds(10, 11, 37, 30);
		contentPanel.add(lblTxt1);
		
		lblTxt2 = new JLabel("Pr\u00E9nom :");
		lblTxt2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTxt2.setBounds(10, 47, 55, 30);
		contentPanel.add(lblTxt2);
		
		lblTxt3 = new JLabel("Date de naissance :");
		lblTxt3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTxt3.setBounds(10, 83, 125, 30);
		contentPanel.add(lblTxt3);
		
		lblTxt4 = new JLabel("Téléphone :");
		lblTxt4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTxt4.setBounds(10, 119, 125, 30);
		contentPanel.add(lblTxt4);
		
		lblTxt5 = new JLabel("Adresse mail :");
		lblTxt5.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTxt5.setBounds(10, 155, 92, 30);
		contentPanel.add(lblTxt5);
		
		lblTxt6 = new JLabel("Rue :");
		lblTxt6.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTxt6.setBounds(10, 191, 32, 30);
		contentPanel.add(lblTxt6);
		
		lblTxt7= new JLabel("Code postal :");
		lblTxt7.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTxt7.setBounds(10, 227, 82, 30);
		contentPanel.add(lblTxt7);
		
		lblTxt8 = new JLabel("Ville :");
		lblTxt8.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTxt8.setBounds(10, 263, 37, 30);
		contentPanel.add(lblTxt8);
		
		cbxGrade = new JComboBox(ClientDao.getNiveaux());
		cbxGrade.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		cbxGrade.setBounds(368, 47, 155, 26);
		contentPanel.add(cbxGrade);
		
		lbltxt9 = new JLabel("Grade :");
		lbltxt9.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lbltxt9.setBounds(368, 11, 48, 30);
		contentPanel.add(lbltxt9);
		
		txtNom = new JTextField();
		txtNom.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtNom.setBounds(145, 15, 100, 26);
		contentPanel.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtPrenom.setBounds(145, 51, 100, 26);
		contentPanel.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		dateNaissJDC = new JDateChooser();
		//dateNaissJDC.setDate(new Date());
		dateNaissJDC.setBounds(145, 87, 122, 26);
		contentPanel.add(dateNaissJDC);
		
		txtTel = new JTextField();
		txtTel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtTel.setColumns(10);
		txtTel.setBounds(145, 125, 100, 26);
		contentPanel.add(txtTel);
		
		txtMail = new JTextField();
		txtMail.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtMail.setColumns(10);
		txtMail.setBounds(145, 161, 146, 26);
		contentPanel.add(txtMail);
		
		txtRue = new JTextField();
		txtRue.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtRue.setColumns(10);
		txtRue.setBounds(145, 197, 172, 26);
		contentPanel.add(txtRue);
		
		txtVille = new JTextField();
		txtVille.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtVille.setColumns(10);
		txtVille.setBounds(145, 233, 172, 26);
		contentPanel.add(txtVille);
		
		txtCP = new JTextField();
		txtCP.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtCP.setColumns(10);
		txtCP.setBounds(145, 270, 86, 26);
		contentPanel.add(txtCP);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == dateNaissJDC)
		{
			
		}
		
		if (e.getSource() == btnAjouter)
		{
			Client leClient;
			
			// Verification de saisie	
			if (txtNom.getText().isEmpty() || txtPrenom.getText().isEmpty() || txtTel.getText().isEmpty() || 
				txtMail.getText().isEmpty() || txtRue.getText().isEmpty() || txtVille.getText().isEmpty() || txtCP.getText().isEmpty() || cbxGrade.getSelectedItem() == null)
			{
				JOptionPane.showMessageDialog(null, "Erreur: Veuillez renplir tous les champs avant d'ajouter un nouveau client");
			} 
			else 
			{
				leClient = new Client(txtNom.getText(), txtPrenom.getText(), txtMail.getText(), txtTel.getText(), txtRue.getText(), txtCP.getText(),
						txtVille.getText(), dateNaissJDC.getDate(), (Niveau)cbxGrade.getSelectedItem());

				// Ajoute la nouvelle ligne dans la base
				ClientDao.ajouterClient(leClient);
				
				// Récupère l'id autoincrémenté dans la base et l'affecte à l'id
				leClient.setIdClient(ClientDao.getClientIdRecent());
				
				Fen_Principal.LES_CLIENTS.add(leClient);
				
				JOptionPane.showMessageDialog(null, "Client ajouté !");
				
				this.dispose();
			}

		}

		if (e.getSource() == btnAnnuler)
		{
			this.dispose();
		}
	}
}
