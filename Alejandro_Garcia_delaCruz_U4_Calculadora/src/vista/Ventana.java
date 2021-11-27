package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.*;
import javax.swing.text.StyledEditorKit.BoldAction;

import controlador.ManejadorEventos;

public class Ventana extends javax.swing.JFrame{
	
	
	
	private JLabel etiqueta1, etiqueta2, etiqueta3, imagenPortada;
	private JTextField cajaTexto1, cajaTexto2;
	private JButton botonSumar, botonRestar, botonMultiplicar, botonDividir, botonRaizCuadrada, botonRaizCubica;
	private JPanel panel;

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 450);
		setLocationRelativeTo(null);
		setTitle("Calculadora");
		setLayout(null);
		inicializarComponentes();
		
		setResizable(false);
		setVisible(true);
	}
	
	private void inicializarComponentes() {
		
		imagenPortada = new JLabel();
		imagenPortada.setBounds(110, 10, 132, 128);
		imagenPortada.setIcon(new ImageIcon("imagenes/anonymous2.png"));
		add(imagenPortada);
		
		
		
		etiqueta1 = new JLabel("Numero 1:");
		etiqueta1.setBounds(35, 148, 76, 30);
		etiqueta1.setForeground(Color.RED);
		add(etiqueta1);
		
		etiqueta2 = new JLabel("Numero 2:");
		etiqueta2.setBounds(35, 180, 76, 30);
		etiqueta2.setFont(new Font("Arial", Font.BOLD, 12));
		add(etiqueta2);
		
		etiqueta3 = new JLabel("Resultado: ");
		etiqueta3.setBounds(35, 370, 200, 30);
		etiqueta3.setForeground(Color.BLUE);
		add(etiqueta3);
		
		cajaTexto1 = new JTextField();
		cajaTexto1.setBounds(100, 148, 200, 25);
		cajaTexto1.requestFocus();
		add(cajaTexto1);
		
		cajaTexto2 = new JTextField();
		cajaTexto2.setBounds(100, 180, 200, 25);
		add(cajaTexto2);
		
		botonSumar = new JButton("Sumar");
		botonSumar.setBounds(35, 230, 120, 30);
		add(botonSumar);
		
		botonRestar = new JButton("Restar");
		botonRestar.setBounds(180, 230, 120, 30);
		add(botonRestar);
		
		botonMultiplicar = new JButton("Multiplicar");
		botonMultiplicar.setBounds(35, 270, 120, 30);
		add(botonMultiplicar);
		
		botonDividir = new JButton("Dividir");
		botonDividir.setBounds(180, 270, 120, 30);
		add(botonDividir);
		
		botonRaizCuadrada = new JButton("Raiz 2");
		botonRaizCuadrada.setBounds(35, 310, 120, 30);
		add(botonRaizCuadrada);
		
		botonRaizCubica = new JButton("Raiz 3");
		botonRaizCubica.setBounds(180, 310, 120, 30);
		add(botonRaizCubica);
		
		
		panel = new JPanel();
		panel.setBounds(0, 0, 350, 450);
		panel.setForeground(Color.BLUE);
		add(panel);
		
	}
	
	public void establecerManejador(ManejadorEventos manejador) {
		botonSumar.addActionListener(manejador);
		botonRestar.addActionListener(manejador);
		botonMultiplicar.addActionListener(manejador);
		botonDividir.addActionListener(manejador);
		botonRaizCuadrada.addActionListener(manejador);
		botonRaizCubica.addActionListener(manejador);
	}

	public JLabel getEtiqueta3() {
		return etiqueta3;
	}

	public JTextField getCajaTexto1() {
		return cajaTexto1;
	}

	public JTextField getCajaTexto2() {
		return cajaTexto2;
	}

	public JButton getBotonSumar() {
		return botonSumar;
	}

	public JButton getBotonRestar() {
		return botonRestar;
	}

	public JButton getBotonMultiplicar() {
		return botonMultiplicar;
	}

	public JButton getBotonDividir() {
		return botonDividir;
	}

	public JButton getBotonRaizCuadrada() {
		return botonRaizCuadrada;
	}

	public JButton getBotonRaizCubica() {
		return botonRaizCubica;
	}

	public JPanel getPanel() {
		return panel;
	}

}