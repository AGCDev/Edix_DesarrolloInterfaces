package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import vista.Ventana;
import vista.Ventana2;

//Proyecto realizado por: César Ramirez García y Alejandro García de la Cruz

public class ManejadorEventos implements ActionListener{
	
	private Ventana ventana;
	private Ventana2 ventana2;
	private float num1, num2;

	public ManejadorEventos(Ventana ventana) {
		this.ventana = ventana;
	}

	
	public void setNum1(float num1) {
		this.num1 = num1;
	}


	public void setNum2(float num2) {
		this.num2 = num2;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			double resultado = 0;
			double numero1 = Double.parseDouble(ventana.getCajaTexto1().getText());
			double numero2 = Double.parseDouble(ventana.getCajaTexto2().getText());
			
			
			ventana.getCajaTexto1().setText(null);
			ventana.getCajaTexto1().requestFocus();
			ventana.getCajaTexto2().setText(null);
				
				if (e.getSource() == ventana.getBotonSumar()) {
					resultado = numero1 + numero2;
					ventana.getEtiqueta3().setText("El resultado es: " + resultado);
				}
				
				if (e.getSource() == ventana.getBotonRestar()) {
					resultado = numero1 - numero2;
					ventana.getEtiqueta3().setText("El resultado es: " + resultado);
				}
				
				if (e.getSource() == ventana.getBotonMultiplicar()) {
					resultado = numero1 * numero2;
					ventana.getEtiqueta3().setText("El resultado es: " + resultado);
				}
				
				if (e.getSource() == ventana.getBotonDividir()) {
					resultado = numero1 / numero2;
					ventana.getEtiqueta3().setText("El resultado es: " + resultado);
				}
				
				if (e.getSource() == ventana.getBotonRaizCuadrada()) {
					try {
						
						File file = new File("audio/EXPLOBIG.wav");
						AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
						Clip clip = AudioSystem.getClip();
						clip.open(audioStream);
						clip.start();
						
						//No consigo que una etiqueta con texto se vea por encima de una imagen de fondo pero los botones y lo demás si. 
						ventana2 = new Ventana2(this);
						ventana2.establecerTexto(ventana.getCajaTexto1().getText());
						//ventana2.setVisible(true);
					} catch (Exception e2) {
						// TODO: handle exception
					}
					JOptionPane.showMessageDialog(null, "Funcionalidad no disponible.", "Información", JOptionPane.INFORMATION_MESSAGE);
					
				}
				
				if (e.getSource() == ventana.getBotonRaizCubica()) {
					
					String passwordGrabado = "1234";
					
					JPasswordField campoPassword = new JPasswordField();
					
					int passwordPedido = JOptionPane.showConfirmDialog(null, campoPassword, "Contraseña: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					
					if (passwordPedido == JOptionPane.OK_OPTION) {
						
						String passwordObtenido = new String(campoPassword.getPassword());
						
						if (passwordGrabado.equals(passwordObtenido) ) {
							
							
							double numeroIntroducido = 0.0;
					       
							numeroIntroducido = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduce un número para obtener su raíz cúbica: "));
							double raizCubica = Math.cbrt(numeroIntroducido);
							try {
								
								File file = new File("audio/laser.wav");
								AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
								Clip clip = AudioSystem.getClip();
								clip.open(audioStream);
								clip.start();
							} catch (Exception e2) {
								// TODO: handle exception
							}
							ventana.getEtiqueta3().setText("El resultado es: " + raizCubica);		
							
						}else {
							JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
						}
					}
				}
				
				if (e.getSource() == ventana2.getBotonVolver()) {
					ventana2.dispose();
				}
				
		} catch (IllegalArgumentException ex) {
			JOptionPane.showMessageDialog(null, "No se permiten campos vacíos ni letras, sólo números.", "Información", JOptionPane.INFORMATION_MESSAGE);
		} 
		
	}
	
	
	
	
	// Este método iria en esta misma clase
	private boolean comprobarCajaRaiz() {
		if (ventana.getCajaTexto1().getText().isEmpty() && ventana.getCajaTexto2().getText().isEmpty()) {
			cambiarEstilo(Color.RED, 20, "Escriba un número");
			return false;
		}
		
		if(!ventana.getCajaTexto1().getText().isEmpty()){
			try{
				setNum1(Float.parseFloat(ventana.getCajaTexto1().getText()));
				return true;
			}catch(Exception e){
				cambiarEstilo(Color.RED, 20, "Número incorrecto");
				return false;
			}
			
		}else if(!ventana.getCajaTexto2().getText().isEmpty()){
			try{
				setNum1(Float.parseFloat(ventana.getCajaTexto2().getText()));
				return true;
			}catch(Exception e){
				cambiarEstilo(Color.RED, 20, "Número incorrecto");
				return false;
			}
		}else{
			return true;
		}
	}	
	
	private void cambiarEstilo(Color color, int tamanio, String mensaje){
		ventana.getEtiqueta3().setForeground(color);
		ventana.getEtiqueta3().setFont(new Font("Arial", Font.BOLD, tamanio));
		ventana.getEtiqueta3().setText(mensaje);
	}

	
}

















