package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.StyledEditorKit.BoldAction;

import controlador.ManejadorEventos;

//Proyecto realizado por: César Ramirez García y Alejandro García de la Cruz

public class Ventana extends javax.swing.JFrame {

	private JLabel etiqueta1, etiqueta2, etiqueta3, imagenPortada, info;
	private JTextField cajaTexto1, cajaTexto2;
	private JButton botonSumar, botonRestar, botonMultiplicar, botonDividir, botonRaizCuadrada, botonRaizCubica;
	private JPanel panel;

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 450);
		setLocationRelativeTo(null);
		setTitle("Calculadora");
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/iconoCalculadora.jpeg"));
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

		info = new JLabel(new ImageIcon("imagenes/iconoInfo2.jpeg"));
		info.setBounds(280, 10, 25, 25);
		add(info);
		
		etiqueta3 = new JLabel("Resultado: ");
		etiqueta3.setBounds(35, 370, 200, 30);
		etiqueta3.setForeground(Color.BLUE);
		etiqueta3.setFont(new Font("Arial", Font.BOLD, 20));
		add(etiqueta3);

		cajaTexto1 = new JTextField();
		cajaTexto1.setBounds(35, 148, 265, 25);
		TextPrompt placeholder = new TextPrompt("Numero 1", cajaTexto1);
		placeholder.changeAlpha(0.75f); // bajar la transparecia de la fuente (0 = transparente,  1 = opaco)
		//cajaTexto1.requestFocus(); //EL placeholder ya lleva incorporada la función focus
		add(cajaTexto1);

		cajaTexto2 = new JTextField();
		cajaTexto2.setBounds(35, 180, 265, 25);
		TextPrompt placeholder2 = new TextPrompt("Numero 2", cajaTexto2);
		placeholder2.changeAlpha(0.75f);
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
		panel.setBackground(Color.black);
		panel.setOpaque(true);
		add(panel);

	}

	public void establecerManejador(ManejadorEventos manejador) {
		botonSumar.addActionListener(manejador);
		botonRestar.addActionListener(manejador);
		botonMultiplicar.addActionListener(manejador);
		botonDividir.addActionListener(manejador);
		botonRaizCuadrada.addActionListener(manejador);
		botonRaizCubica.addActionListener(manejador);

		info.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Información sobre el uso de la aplicación." + "\n" + "\n"
						+ "1. Para realizar 'cualquier' cálculo, debe introducir números en las dos cajas." + "\n"
						+ "2. Si no se introduce ningún dato o un caracter que no sea un número saltará un aviso." + "\n"
						+ "3. 'Raiz 3' Se le pedirá de nuevo el número a calcular despues de introducir la contraseña."
						+ "\n" + "4. La contraseña para acceder a la función 'Raiz 3' es: 1234 ");
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

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
	
	private void cambiarEstilo(Color color, int tamanio, String mensaje){
		etiqueta3.setForeground(color);
		etiqueta3.setFont(new Font("Arial", Font.BOLD, tamanio));
		etiqueta3.setText(mensaje);
	}

}
