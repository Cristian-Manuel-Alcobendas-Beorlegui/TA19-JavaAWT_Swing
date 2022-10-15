package Ejercicio1.Controlador;

// Importar clases y librerias
import Ejercicio1.Modelo.*;
import Ejercicio1.Vista.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
	// Atributos de la clase
	private Modelo modelo;
	private Vista vista;
	private String nombre;
	
	// ---------------------------------------------------------------------------------- //
	
	// CONSTRUCTORES DE LA CLASE
	// Constructor parametrizado
	public Controlador(Modelo modelo, Vista vista) {
		// Inicializar los objetos de las clases "Modelo" y "Vista"
		this.modelo = modelo;
		this.vista = vista;
		
		// Añadir la acción ActionListener al boton
		this.vista.botonSaludar.addActionListener(this);
	}
	
	// ---------------------------------------------------------------------------------- //
	
	// EVENTOS
	// Evento 1: Estar antento del botón "botonSaludar"
	public void actionPerformed(ActionEvent evento) {
		// Comprovar si han pulsado el botón
		if(vista.botonSaludar == evento.getSource()) {
			// Guardar el valor de nombre en una variable y después en el atributo de la clase "Modelo"
			nombre = vista.textArea.getText();
			modelo.setNombre(nombre);
			
			// Guardar el nombre en una variable
			nombre = modelo.getNombre();
			
			// Enviar a la ventana mostrar el saludo con el nombre introducido.
			vista.mostrarMensaje("Encantado de conocerte " + nombre + ".");
		} // Fin IF
	}
	
	
	// ---------------------------------------------------------------------------------- //
	
	// MÉTODOS Y FUNCIONES
	
	// Método 1: Iniciar la vista
	public void iniciarVista() {
		// Configurar la ventana
		vista.setTitle("Sistema de saludo personalizado"); // Título de la ventana
		vista.setBounds(10, 10, 500, 350); // Indicar la posición y el tamaño de la ventana
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Indicar que cuando la ventana se cierre también lo haga el programa.
		vista.setVisible(true); // Hacer que la ventana sea visible, que se pueda ver.
	}
	
	
	// ----------------------------------------------------------------------------------- // 
	
	// PROGRAMA PRINCIPAL
	public static void main(String[] args) {
		// 1. Crear los objetos de las clases "Modelo", "Vista" y "Controlador"
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(modelo, vista);
		
		// 2. Iniciar la vista
		controlador.iniciarVista();
	}

	// ----------------------------------------------------------------------------------- // 
	
	// Fin del controlador
}
