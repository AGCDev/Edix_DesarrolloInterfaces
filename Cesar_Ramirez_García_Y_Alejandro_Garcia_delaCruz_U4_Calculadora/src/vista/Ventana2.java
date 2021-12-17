package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controlador.ManejadorEventos;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.SwingConstants;

public class Ventana2 extends JDialog {

	private JPanel contentPane;
	private JLabel imagenFondo, etiquetaSaludo;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JButton btnNewButton;
	private JButton botonVolver;
	private ManejadorEventos controlador;
	

	/**
	 * Create the frame.
	 */
	public Ventana2(ManejadorEventos controlador) {
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(158, 98, 86, 20);
		TextPrompt placeholderContraseña = new TextPrompt("Contraseña", txtPassword);
		placeholderContraseña.changeAlpha(0.75f);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(158, 67, 86, 20);
		TextPrompt placeholderUsuario = new TextPrompt("Usuario", txtUsuario);
		placeholderUsuario.changeAlpha(0.75f);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setBounds(155, 148, 89, 23);
		contentPane.add(btnNewButton);
		//setVisible(true);
		
		botonVolver = new JButton("Volver");
		botonVolver.addActionListener(controlador);
		botonVolver.setBounds(155, 188, 89, 23);
		contentPane.add(botonVolver);
		
		
		imagenFondo = new JLabel("");
		imagenFondo.setForeground(Color.WHITE);
		imagenFondo.setBackground(Color.BLACK);
		imagenFondo.setIcon(new ImageIcon("imagenes\\fondo4.png"));
		imagenFondo.setBounds(0, 0, 434, 261);
		contentPane.add(imagenFondo);
		
		
		etiquetaSaludo = new JLabel();
		etiquetaSaludo.setBounds(35, 20, 76, 30);
		etiquetaSaludo.setForeground(Color.WHITE);
		add(etiquetaSaludo);
		
		setVisible(true);
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}


	public JButton getBotonVolver() {
		return botonVolver;
	}


	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
	}

	
	public void establecerTexto(String saludo) {
		etiquetaSaludo.setText(saludo);
	}
}
