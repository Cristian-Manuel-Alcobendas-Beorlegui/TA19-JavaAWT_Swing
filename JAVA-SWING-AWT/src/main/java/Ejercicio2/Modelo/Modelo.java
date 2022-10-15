package Ejercicio2.Modelo;

public class Modelo {
	// Atributo de la clase
	private Double num1, num2, resultado;
	
	// ---------------------------------------------------------------------- //
	
	// Getters y Setters
	// Atributo 1: num1
	public Double getNum1() {
		return num1;
	}
	
	public void setNum1(Double num1) {
		this.num1 = num1;
	}
	
	// Atributo 2: num2
	public Double getNum2() {
		return num2;
	}
	
	public void setNum2(Double num2) {
		this.num2 = num2;
	}
	
	// Atributo 3: Resultado
	public Double getResultado() {
		return resultado;
	}
	
	// ---------------------------------------------------------------------- //
	
	// MÉTODOS Y FUNCIONES
	// Método 1: Sumar
	public void suma() {
		resultado = num1 + num2;
	}
	
	// Método 2: Restar
	public void restar() {
		resultado = num1 - num2;
	}
	
	// Método 3: Multiplicar
	public void multiplicar() {
		resultado = num1 * num2;
	}
	
	// Método 4: Dividir
	public void dividir() {
		resultado = num1 / num2;
	}
	
	// ---------------------------------------------------------------------- //
	
	// Fin del modelo
}
