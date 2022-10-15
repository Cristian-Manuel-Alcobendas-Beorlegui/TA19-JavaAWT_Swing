package Ejercicio3.Controlador;

// Importar clases y librerias
import Ejercicio3.Modelo.*;
import Ejercicio3.Vista.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
	// Atributos de la clase
	private String id, nombre, nombreTabla = "proveedor", mensaje;
	private String[] columnas = {"id", "nombre"};
	private Modelo modelo;
	private Vista vista;
	
	// -------------------------------------------------------------------------------- 
	
	// CONSTRUCTORES DE LA CLASE
	// Constructor parametrizado
	public Controlador(Modelo modelo, Vista vista) {
		// Guardar los objetos de las clases "Modelo" y "Vista" en atributos
		this.modelo = modelo;
		this.vista = vista;
		
		
		// Añadir a los botones de la vista "listeners"
		vista.botonAñadir.addActionListener(this);
		vista.botonEliminar.addActionListener(this);
		vista.botonModificar.addActionListener(this);
		vista.botonCrearBaseDatos.addActionListener(this);
	}

	// -------------------------------------------------------------------------------- 
	
	// EVENTOS
	// Evento 1: Estar antento de los botones
	public void actionPerformed(ActionEvent evento) {
		// Comprovar que tipo de botón ha sido pulsado
		if(vista.botonAñadir == evento.getSource()) { // BOTÓN AÑADIR
			// Guardar los datos en los atributos de la clase "Modelo"
			id = vista.id.getText();
			nombre = vista.nombre.getText();
			modelo.setId(id);
			modelo.setNombre(nombre);
			
			// Usar la función "añadirDatos" del modelo para añadir los datos a la tabla
			mensaje = modelo.añadirDatos();
			
			// Llamar al método "mostrarMensaje" de la vista para mostrar el mensaje generado por la función "añadirDatos"
			vista.mostrarMensaje(mensaje);
			
		} else if(vista.botonEliminar == evento.getSource()) { // BOTÓN ELIMINAR
			// Guardar los datos en los atributos de la clase "Modelo"
			id = vista.id.getText();
			modelo.setId(id);
			
			// Usar la función "eliminarDatos" del modelo para eliminar los datos a la tabla
			mensaje = modelo.eliminarDatos();
			
			// Llamar al método "mostrarMensaje" de la vista para mostrar el mensaje generado por la función "eliminarDatos"
			vista.mostrarMensaje(mensaje);
			
		} else if(vista.botonModificar == evento.getSource()) { // BOTÓN MODIFICAR
			// Guardar los datos en los atributos de la clase "Modelo"
			id = vista.id.getText();
			nombre = vista.nombre.getText();
			modelo.setId(id);
			modelo.setNombre(nombre);
			
			// Usar la función "actualizarDatos" del modelo para actualizar los datos a la tabla
			mensaje = modelo.actualizarDatos();
			
			// Llamar al método "mostrarMensaje" de la vista para mostrar el mensaje generado por la función "actualizarDatos"
			vista.mostrarMensaje(mensaje);
		} else if(vista.botonCrearBaseDatos == evento.getSource()) { // BOTÓN CREAR ESTRUCTURA DE LA BASE DE DATOS
			mensaje = modelo.crearBaseDatos();
			vista.mostrarMensaje(mensaje);	
		}
		
		// Actualizar la tabla de la ventana
		actualizarTabla();


	}

	// -------------------------------------------------------------------------------- 
	
	// MÉTODOS Y FUNCIONES
	// Método 1: Iniciar vista
	public void iniciarVista() {
		// Configuración de la ventana
		vista.setTitle("Gestión de la tabla (" + nombreTabla + ")"); // Título de la ventana
		vista.setBounds(10, 10, 750, 500); // Tamaño y posición de la ventana
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cuando la ventana se cierre, también lo hará el programa.
		vista.setVisible(true); // Hacer que la ventana sea visible
		
		// Actualizar la tabla
		actualizarTabla();
	}
	
	// ################################################################################################################################
	
	// Método 2: Actualizar la tabla
	public void actualizarTabla() {
		// Conseguir los datos de la tabla
		vista.tabla.revalidate(); // Para actualizar la tabla
		modelo.datosTabla();
		
		// Configurar la tabla de la ventana	
		vista.datos = new DefaultTableModel(modelo.registrosTabla, columnas);
		vista.tabla = new JTable(vista.datos);
		vista.tabla.setBounds(10, 90, 700, 100);
		vista.contentPane.add(vista.tabla);
	}
	
	// -------------------------------------------------------------------------------- 
	
	// PROGRAMA PRINCIPAL
	public static void main(String[] args) {
		// 1. Crear los objetos de las clases "Modelo", Vista, "Controlador"
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(modelo, vista);
		
		// 2. Iniciar la vista
		controlador.iniciarVista();
	}
	
	// -------------------------------------------------------------------------------- 

}
