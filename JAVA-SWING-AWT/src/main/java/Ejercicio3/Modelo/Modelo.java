package Ejercicio3.Modelo;

// Importar librerias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo {
	// Atributos de la clase
	private Connection conexion;
	private String mensaje, nombreBaseDatos = "ejercicio3CRUDJavaSwing", nombreTabla = "proveedor", id, nombre, consulta;
	private int totalRegistros = totalRegistrosTabla() + 1, f, c;
	public String[][] registrosTabla;
	public java.sql.ResultSet listaResultados;
	
	// -------------------------------------------------------------------------------------- //
	
	// MÉTODOS Y FUNCIONES
	
	// Función 1: Abrir la conexión con MySQL
	public String abrirConexion() {
		// Intentar ejecutar el código
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
			mensaje = "Conexión establecida";
		}
		
		// Control de errores
		// SQLException
		catch(SQLException e) {
			mensaje = "No hemos podido conectarnos a la base de datos.";
		}
		
		// ClassNotFoundException
		catch(ClassNotFoundException e2) {
			mensaje = "No nos hemos podido conectar con la base de datos.";
		}
		
		// Devolver el valor del atributo "mensaje"
		return mensaje;
	}
	
	// ###############################################################################################################################
	
	// Función 2: Cerrar la conexión
	public String cerrarConexion() {
		// Intentar ejecutar el código
		try {
			conexion.close();
			mensaje = "La conexión se ha cerrado correctamente.";
		}
		
		// Control de errores
		catch(SQLException e) {
			mensaje = "Ha habido un error al intentar cerrar la conexión.";
		}
		
		// Devolver el valor del atributo "mensaje"
		return mensaje;
	}
	
	// ###############################################################################################################################
	
	// Función 3: Añadir datos a la tabla
	public String añadirDatos() {
		// Intentar ejecutar el código
		try {
			// Abrir la conexión
			abrirConexion();
			
			// Indicar que base de datos usar
			consulta = "USE " + nombreBaseDatos + ";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(consulta);
			
			// Insertar los datos en la base de datos
			consulta = "INSERT INTO " + nombreTabla + "(nombre) VALUES('" + nombre + "')";
			Statement st = conexion.createStatement();
			st.executeUpdate(consulta);
						
			// Cerrar la conexión
			cerrarConexion();
		
			// Mostrar un mensaje por pantalla que indique que los datos se han añadido
			mensaje = "Se han añadido datos en la tabla (" + nombreTabla + ").";
			
		} // Fin TRY
		
		// Control de errores
		catch(SQLException ex) {
			mensaje = "No se ha podido añadir los datos en la tabla (" + nombreTabla + ").";
		}
		
		// Devolver el valor del atributo "mensaje"
		return mensaje;
	}
	
	// ###############################################################################################################################
	
	// Función 4: Eliminar datos de la tabla
	public String eliminarDatos() {
		// Intentar ejecutar el código
		try {
			// Abrir la conexión
			abrirConexion();
			
			// Indicar que base de datos usar
			consulta = "USE " + nombreBaseDatos + ";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(consulta);
			
			// Eliminar los datos de la base de datos
			consulta = "DELETE FROM " + nombreTabla + " WHERE id=" + id + ";";
			Statement st = conexion.createStatement();
			st.executeUpdate(consulta);
			
			// Cerrar la conexión
			cerrarConexion();
			
			// Mostrar un mensaje que indique que los datos han sido eliminados
			mensaje = "Se ha eliminado los datos del ID (" + id + ").";
		} // Fin TRY
		
		// Control de errores
		catch(SQLException ex) {
			mensaje = "No se ha podido eliminar el registro con ID (" + id + ").";
		}
		
		// Devolver el valor del atributo "mensaje"
		return mensaje;
	}
	

	// ###############################################################################################################################
	
	// Función 5: Actualizar datos
	public String actualizarDatos() {
		// Intentar ejecutar el código
		try {
			// Abrir la conexión
			abrirConexion();
			
			// Indicar que base de datos usar
			consulta = "USE " + nombreBaseDatos + ";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(consulta);
			
			// Actualizar los datos de la tabla
			consulta = "UPDATE " + nombreTabla + " SET nombre='" + nombre + "' WHERE id=" + id + ";";
			Statement st = conexion.createStatement();
			st.executeUpdate(consulta);
			
			// Cerrar la conexión
			cerrarConexion();
		
			// Mostrar un mensaje que indique que los datos han sido actualizados.
			mensaje = "El registro con ID (" + id + ") ha sido actualizado.";
		} // Fin TRY
		
		// Control de errores
		catch(SQLException ex) {
			mensaje = "No ha sido posible actualizar el registro con ID (" + id + ").";
		}
		
		// Devolver el valor del atributo "mensaje"
		return mensaje;
	}
	
	
	// ###############################################################################################################################
	
	// Función 6: Mostrar los datos de la tabla
	public String datosTabla() {		
		// Intentar ejecutar código
		try {
			totalRegistros = totalRegistrosTabla();
			
			// Abrir conexión
			abrirConexion();

			// Indicar que base de datos hay que usar
			consulta = "USE " + nombreBaseDatos + ";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(consulta);

			// Consulta para coneguir todos los resultados de la tabla
			consulta = "SELECT * FROM " + nombreTabla + ";";

			// Guardar los resultados
			Statement st = conexion.createStatement();
			listaResultados = st.executeQuery(consulta);

			// Guardar los resultados en una matriz
			registrosTabla = new String[totalRegistros][2];
			f = 0;
			c = 0;
			while(listaResultados.next()) {
				registrosTabla[f][c] = listaResultados.getString("id");
				registrosTabla[f][c + 1] = listaResultados.getString("nombre");
				f++;
			}
			
			// Cerrar conexión
			cerrarConexion();
			
			// Mensaje que indique que se pudo mostrar la tabla
			mensaje = "La tabla se puede mostrar";
			
		} // Fin TRY

		// Control de errores
		catch (SQLException ex) {
			mensaje = "No hemos podido conseguir los datos de la tabla para poderlos mostrar.";
		}
		
		// Devolver el valor de mensaje
		return mensaje;
	}
	
	// ###############################################################################################################################
	
	// Función 7: Contar el total de registros de la tabla
	public int totalRegistrosTabla() {
		// Intentar ejecutar código
		try {
			// Abrir conexión
			abrirConexion();

			// Indicar que base de datos hay que usar
			consulta = "USE " + nombreBaseDatos + ";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(consulta);

			// Consulta para coneguir todos los resultados de la tabla
			consulta = "SELECT * FROM " + nombreTabla + ";";

			// Guardar los resultados
			Statement st = conexion.createStatement();
			listaResultados = st.executeQuery(consulta);

			// Contar el total de resultados
			totalRegistros = 0;
			while(listaResultados.next()) {
				totalRegistros++;
			}
			
			// Cerrar conexión
			cerrarConexion();
		} // Fin TRY

		// Control de errores
		catch (SQLException ex) {
			mensaje = "No hemos podido contar el número de registros de la tabla.";
		}
		
		// Devolver el valor de "listaResultados"
		return totalRegistros;
	}
	
	// ###############################################################################################################################
	
	// Función 8: Crear la estructura de la base de datos
	public String crearBaseDatos() {
		// Intentar ejecutar código
		try {
			// Abrir conexión
			abrirConexion();

			// Especificar y ejecutar la consulta para crear la base de datos y la tabla
			consulta = "DROP DATABASE IF EXISTS " + nombreBaseDatos + ";";
			Statement st = conexion.createStatement();
			st.executeUpdate(consulta);
			
			consulta = "CREATE DATABASE " + nombreBaseDatos + ";";
			st.executeUpdate(consulta);
			
			consulta = "USE " + nombreBaseDatos + ";";
			st.executeUpdate(consulta);
			
			consulta = "CREATE TABLE " + nombreTabla + "("
					+ "id INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,"
					+ " nombre VARCHAR(100) NOT NULL"
					+ ");";
			st.executeUpdate(consulta);
			
			consulta = "INSERT INTO " + nombreTabla + "(nombre) VALUES('Undertale');";
			st.executeUpdate(consulta);
			
			
			// Cerrar conexión
			cerrarConexion();
			
			// Guardar un mensaje indicando que la base de datos ha sido creada
			mensaje = "La base de datos " + nombreBaseDatos + " se ha creado correctamente";
		} // Fin TRY

		// Control de errores
		catch (SQLException ex) {
			mensaje = "No hemos podido crear la base de datos " + nombreBaseDatos;
		}
		
		// Devolver el valor de "mensaje"
		return mensaje;
	}
	
	
	// --------------------------------------------------------------------------------------- //
	
	// Getters y setters
	// Atributo 1: id
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	// Atributo 2: Nombre
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
	// --------------------------------------------------------------------------------------- //
	
}
