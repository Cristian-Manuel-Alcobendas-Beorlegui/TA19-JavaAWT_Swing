package Ejercicio2.Vista;

// Importar librerias
import javax.swing.*;

public class Vista extends JFrame {
	
	// Atributos de la clase
	public JButton botonCalcular;
	public JRadioButton suma, resta, multiplicar, dividir;
	public JTextField numero1, numero2;
	public JLabel resultado;
	private JLabel titulo, mensaje;
	private ButtonGroup opcionOperacion;
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	
	// ------------------------------------------------------------------------------------------ //
	
	// CONSTRUCTORES DE LA CLASE
	// Constructor por defecto
	public Vista() {
		// Configuración del contentPane
		contentPane = new JPanel(); 
		contentPane.setLayout(null); 
		setContentPane(contentPane);
		
		// Título que indique que hace la ventana
		titulo = new JLabel("Mini-Calculadora");
		titulo.setBounds(140, 10, 100, 20);
		contentPane.add(titulo);
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		// SECCIÓN 1: SELECCIONAR EL TIPO DE OPERACIÓN
		// Título de la sección
		mensaje = new JLabel("1- TIPO DE OPERACIÓN");
		mensaje.setBounds(10, 50, 250, 20);
		contentPane.add(mensaje);
		
		// Mensaje que le indique al usuario que escoja una opción
		mensaje = new JLabel("Selecciona el tipo de operación que deseas realizar: ");
		mensaje.setBounds(10, 70, 400, 20);
		contentPane.add(mensaje);
		
		// Botones (RADIO BUTTON) con los diferentes tipos de operación
		// Suma
		suma = new JRadioButton("Sumar", true);
		suma.setBounds(30, 90, 250, 20);
		contentPane.add(suma);
		
		// Resta
		resta = new JRadioButton("Restar");
		resta.setBounds(30, 110, 250, 20);
		contentPane.add(resta);
		
		// Multiplicar
		multiplicar = new JRadioButton("Multiplicar");
		multiplicar.setBounds(30, 130, 250, 20);
		contentPane.add(multiplicar);
		
		// Dividir
		dividir = new JRadioButton("Dividir");
		dividir.setBounds(30, 150, 250, 20);
		contentPane.add(dividir);
		
		// Agrupar los botones en el grupo "opcionOperacion"
		opcionOperacion = new ButtonGroup();
		opcionOperacion.add(suma);
		opcionOperacion.add(resta);
		opcionOperacion.add(multiplicar);
		opcionOperacion.add(dividir);
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		// SECCIÓN 2: INTRODUCIR LOS NUMEROS
		// Mostrar el título de la sección
		mensaje = new JLabel("2- INTRODUCIR LOS NÚMEROS");
		mensaje.setBounds(10, 200, 250, 20);
		contentPane.add(mensaje);
		
		// Mensaje que indique al usuario que introduzca los números
		// Primer número
		mensaje = new JLabel("Introduce el primer número: ");
		mensaje.setBounds(10, 220, 250, 20);
		contentPane.add(mensaje);
		// Añadir un contador para que el usuario introduzca el primer número
		numero1 = new JTextField();
		numero1.setBounds(10, 240, 250, 20);
		contentPane.add(numero1);
		
		// Segundo número
		mensaje = new JLabel("Introduce el segundo número: ");
		mensaje.setBounds(10, 270, 250, 20);
		contentPane.add(mensaje);
		// Añadir un contador para que el usuario introduzca el segundo número
		numero2 = new JTextField();
		numero2.setBounds(10, 290, 250, 20);
		contentPane.add(numero2);
		
		// Añadir un botón para hacer la operación
		botonCalcular = new JButton("Calcular");
		botonCalcular.setBounds(10, 330, 100, 20);
		contentPane.add(botonCalcular);
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		// SECCIÓN 3: RESULTADO DE LA OPERACIÓN ANTERIOR
		// Mostrar el título de la sección
		mensaje = new JLabel("3- RESULTADO");
		mensaje.setBounds(10, 380, 250, 20);
		contentPane.add(mensaje);
		
		// Mostrar un mensaje que diga "Resultado de la operación anterior: "
		mensaje = new JLabel("Resultado de la operación anterior: ");
		mensaje.setBounds(10, 400, 250, 20);
		contentPane.add(mensaje);
		
		// Mostrar el resultado de la operación anterior
		resultado = new JLabel("(Sin resultados)");
		resultado.setBounds(220, 400, 300, 20);
		contentPane.add(resultado);
	}
	
	
	// ------------------------------------------------------------------------------------------ //
	
	// MÉTODOS Y FUNCIONES
	// Método 1: Mostrar un mensaje
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	// ------------------------------------------------------------------------------------------ //
	
	// Fin de la vista
}
