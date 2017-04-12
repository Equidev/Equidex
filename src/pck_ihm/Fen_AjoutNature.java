package pck_ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pck_metier.Activite;
import pck_metier.NatureActivite;
import javax.swing.JTextField;
import java.awt.Font;

public class Fen_AjoutNature extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNature;
	private JButton btnNewButton;
	private JButton btnAnnuler;
	private JLabel lblNewLabel;

	/**
	 * Create the dialog.
	 */
	public Fen_AjoutNature()
	{
		setTitle("Ajout nature d'activit\u00E9");
		setBounds(100, 100, 300, 150);
		getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		this.txtNature = new JTextField();
		this.txtNature.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.txtNature.setBounds(50, 40, 200, 25);
		contentPanel.add(this.txtNature);
		this.txtNature.setColumns(10);
		
		this.btnNewButton = new JButton("Valider");
		this.btnNewButton.setBounds(159, 72, 91, 23);
		contentPanel.add(this.btnNewButton);
		
		this.btnAnnuler = new JButton("Annuler");
		this.btnAnnuler.setBounds(50, 72, 91, 23);
		contentPanel.add(this.btnAnnuler);
		
		this.lblNewLabel = new JLabel("Entrez un nom de nature d'activit\u00E9:");
		this.lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		this.lblNewLabel.setBounds(64, 15, 186, 14);
		contentPanel.add(this.lblNewLabel);

	}
}
