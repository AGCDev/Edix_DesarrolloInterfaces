package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import vista.Ventana;




public class ManejadorEventos implements ActionListener{
	
	private Ventana ventana;
	
	public ManejadorEventos(Ventana ventana) {
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			double resultado = 0;
			double numero1 = Double.parseDouble(ventana.getCajaTexto1().getText());
			double numero2 = Double.parseDouble(ventana.getCajaTexto2().getText());
			
			
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
					
					JOptionPane.showMessageDialog(null, "Funcionalidad no disponible", "Información", JOptionPane.INFORMATION_MESSAGE);
					
				}
				
				if (e.getSource() == ventana.getBotonRaizCubica()) {
					
					String passwordGrabado = "1234";
					
					JPasswordField campoPassword = new JPasswordField();
					
					int passwordPedido = JOptionPane.showConfirmDialog(null, campoPassword, "Contraseña: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					
					if (passwordPedido == JOptionPane.OK_OPTION) {
						
						String passwordObtenido = new String(campoPassword.getPassword());
						
						if (passwordGrabado.equals(passwordObtenido) ) {
							
							double numeroIntroducido = 0.0;
					       
							numeroIntroducido = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduce un numero para obtener su raiz cúbica: "));
							double raizCubica = Math.cbrt(numeroIntroducido);
							 
							ventana.getEtiqueta3().setText("El resultado es: " + raizCubica);		
							
						}else {
							JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
						}
					}
				}
				
		} catch (IllegalArgumentException ex) {
			JOptionPane.showMessageDialog(null, "No se permiten campos vacíos ni letras, sólo números.", "Información", JOptionPane.INFORMATION_MESSAGE);
		} 
		
	}
	
	
}
