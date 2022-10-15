package Ejercicio2.Controlador;

// Importar librerias y paquetes
import Ejercicio2.Modelo.*;
import Ejercicio2.Vista.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class Controlador implements ActionListener {
	// Atributos de la clase
	private Double num1, num2, resultado;
	private Modelo modelo;
	private Vista vista;
	private DecimalFormat decimal = new DecimalFormat("0.##");
	
	// -------------------------------------------------------------------- //
	
	// CONSTRUCTORES DE LA CLASE
	// Constructor parametrizado
	public Controlador(Modelo modelo, Vista vista) {
		// Guardar los objetos en los atributos de la clase
		this.modelo = modelo;
		this.vista = vista;
		
		// Añadir un evento ActionListener al botón "botonCalcular"
		vista.botonCalcular.addActionListener(this);
	}
	
	
	// -------------------------------------------------------------------- //
	
	// MÉTODOS Y FUNCIONES
	// Método 1: Iniciar la vista
	public void iniciarVista() {
		// Configurar la ventana
		vista.setTitle("Mini-Calculadora"); // Título de la ventana
		vista.setBounds(10, 10, 500, 750); // Tamaño y posición de la ventana
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cuando la ventana se cierre, también lo hará el programa.
		vista.setVisible(true); // Hacer que la ventana sea visible
	}
	
	
	// -------------------------------------------------------------------- //
	
	// EVENTOS
	// Evento 1: Estar pendiente del botón "botonCalcular"
	public void actionPerformed(ActionEvent evento) {
		// Si pulsan el botón "botonCalcular"
		if(vista.botonCalcular == evento.getSource()) {
			// Intentar ejecutar el código
			try {
				// Guardar los números en los atributos de la clase Modelo
				num1 = Double.parseDouble(vista.numero1.getText());
				num2 = Double.parseDouble(vista.numero2.getText());
				modelo.setNum1(num1);
				modelo.setNum2(num2);
				
				// Comprovar que tipo de operación hay que hacer y calcular el resultado.
				if(vista.suma.isSelected()) { // SUMAR
					modelo.suma();
				} else if(vista.resta.isSelected()) { // RESTAR
					modelo.restar();
				} else if(vista.multiplicar.isSelected()) { // MULTIPLICAR
					modelo.multiplicar(); 
				} else if(vista.dividir.isSelected()) { // DIVIDIR
					modelo.dividir();
				}
				
				// Guardar el resulado
				resultado = modelo.getResultado();
				
				// Mostrar un mensaje por pantalla con el resultado de la operación
				vista.mostrarMensaje("El resultado de la operación es " + decimal.format(resultado) + ".");
				vista.resultado.setText("" + decimal.format(resultado));
			}
			
			// Control de errores
			catch(NumberFormatException e) {
				vista.mostrarMensaje("Por favor, introduce valores que sean correctos.");
				vista.resultado.setText("Operación inválida");
			} // Fin CATCH
		} // Fin IF
	}
	
	// -------------------------------------------------------------------- //
	
	// PROGRAMA PRINCIPAL
	public static void main(String[] args) {
		// 1. Crear los objetos de las clases "Modelo", "Vista" y "Controlador"
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(modelo, vista);
	
		// 2. Iniciar la vista
		controlador.iniciarVista();
	}
	
	// -------------------------------------------------------------------- //
	
	// Fin del controlador
}
