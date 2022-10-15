package Ejercicio3.Vista;

// Importar librerias
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Vista extends JFrame {

	// Atributos de la clase
	public JButton botonAñadir, botonEliminar, botonModificar, botonCrearBaseDatos;
	public JLabel tablaEnUso;
	public JTextField id, nombre, apellido;
	public DefaultTableModel datos;
	public JTable tabla;
	private JLabel titulo, mensaje;
	public JPanel contentPane;
	private static final long serialVersionUID = 1L;
	
	
	// ------------------------------------------------------------------------- //
	
	// CONSTRUCTORES DE LA CLASE
	// Constructor por defecto
	public Vista() {
		// Añadir el JPane
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		// TÍTULO DE LA VENTANA
		// Indicar en el centro el título de la ventana
		titulo = new JLabel("GESTIÓN DE TABLAS");
		titulo.setBounds(330, 20, 300, 20);
		contentPane.add(titulo);
		
		// NOMBRE DE LA TABLA ACTUAL
		// Indicar el nombre de la tabla que se está mostrando
		mensaje = new JLabel("Tabla en uso: ");
		mensaje.setBounds(10, 40, 200, 20);
		contentPane.add(mensaje);
		// Nombre de la tabla
		tablaEnUso = new JLabel("Proveedor");
		tablaEnUso.setBounds(90, 40, 200, 20);
		contentPane.add(tablaEnUso);
	
		// #####################################################################################################################
		
		// SECCIÓN 1: Mostrar el contenido de la tabla "proveedores"
		// Título de la sección
		mensaje = new JLabel("1- CONTENIDO DE LA TABLA");
		mensaje.setBounds(10, 70, 200, 20);
		contentPane.add(mensaje);
		
		// Configurar la tabla
		datos = new DefaultTableModel();
		tabla = new JTable(datos);
		/*
		// Añadir las columnas
		for(int i = 0; i < columnas.length; i++) {
			datos.addColumn(columnas[i]);
		}
		
		// Mostrar la tabla
		tabla.setBounds(10, 90, 700, 100);
		contentPane.add(tabla);*/
		
		// #####################################################################################################################
		
		// SECCIÓN 2: Sección donde se muestra un mini-formulario con los datos para poder añadir, eliminar o modificar.
		// Título de la sección
		mensaje = new JLabel("2- DATOS");
		mensaje.setBounds(10, 200, 200, 20);
		contentPane.add(mensaje);
		
		// Sección dato "ID"
		mensaje = new JLabel("ID: ");
		mensaje.setBounds(10, 220, 200, 20);
		contentPane.add(mensaje);
		// Cuadro de texto para la sección ID
		id = new JTextField();
		id.setBounds(70, 220, 100, 20);
		contentPane.add(id);
		
		// Sección "Nombre"
		mensaje = new JLabel("Nombre: ");
		mensaje.setBounds(10, 240, 100, 20);
		contentPane.add(mensaje);
		// Añadir el cuadro de texto para el campo "nombre"
		nombre = new JTextField();
		nombre.setBounds(70, 240, 100, 20);
		contentPane.add(nombre);
	
		// #####################################################################################################################
		
		// SECCIÓN 3: Elegir el tipo de operación que se quiere realizar, si añadir, eliminar o modificar
		// Titulo de la sección
		mensaje = new JLabel("3- TIPO DE OPERACIÓN");
		mensaje.setBounds(10, 270, 200, 20);
		contentPane.add(mensaje);
		
		// Añadir los botones con los tipos de operación que se pueden realizar.
		// AÑADIR
		botonAñadir = new JButton("Añadir");
		botonAñadir.setBounds(10, 290, 100, 30);
		contentPane.add(botonAñadir);
		// ELIMINAR
		botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(120, 290, 100, 30);
		contentPane.add(botonEliminar);
		// MODIFICAR
		botonModificar = new JButton("Modificar");
		botonModificar.setBounds(230, 290, 100, 30);
		contentPane.add(botonModificar);
		
		// #####################################################################################################################
		
		// SECCIÓN EXTRA: Sección donde aparece un botón para volver a crear la base de datos con la tabla correspondiente.
		botonCrearBaseDatos = new JButton("Volver a crear la base de datos");
		botonCrearBaseDatos.setBounds(10, 330, 250, 30);
		contentPane.add(botonCrearBaseDatos);
	}
	
	// ------------------------------------------------------------------------- //
	
	// MÉTODOS Y FUNCIONES
	// Método 1: Mostrar un mensaje por pantalla
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	// ------------------------------------------------------------------------- //
	
	// Fin de la vista
}
