package Ejercicio1.Vista;

// Importar librerias
import javax.swing.*;

public class Vista extends JFrame {

	// Atributos de la clase
	private JLabel titulo, mensaje;
	public JTextArea textArea;
	private JPanel contentPane;
	public JButton botonSaludar;
	private static final long serialVersionUID = -7373457861722819914L;
	
	// -------------------------------------------------------------------------------- //
	
	// CONTRUCTORES DE LA CLASE
	public Vista() {
		// CONFIGURADOR JPANEL
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		// CONTENIDO DE LA PÁGINA
		
		// Título que dice que hace la ventana
		titulo = new JLabel("Sistema de saludo personalizado.");
		titulo.setBounds(175, 10, 250, 20);
		contentPane.add(titulo);
		
		// Mensaje que indique al usuario que introduzca un nombre
		mensaje = new JLabel("Introduce tu nombre: ");
		mensaje.setBounds(10, 30, 250, 20);
		contentPane.add(mensaje);
		
		// Añadir el cuadro de texto donde el usuario introducirá su nombre
		textArea = new JTextArea();
		textArea.setBounds(10, 60, 250, 20);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		contentPane.add(textArea);
		
		// Añadir un botón que indique cuando el usuario a acabado
		botonSaludar = new JButton("Saludar");
		botonSaludar.setBounds(10, 90, 100, 20);
		contentPane.add(botonSaludar);	
	}
	
	// -------------------------------------------------------------------------------- //
	
	// MÉTODOS Y FUNCIONES
	// Método 1: Mostrar por pantalla un mensaje
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	// -------------------------------------------------------------------------------- //
	
	// Fin de la vista
}
