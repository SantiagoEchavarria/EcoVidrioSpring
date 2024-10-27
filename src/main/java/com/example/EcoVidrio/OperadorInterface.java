package com.example.EcoVidrio;
import java.util.List;

public interface OperadorInterface {
    void guardarOperador(Operador operador);
    List<Operador> listadoOperadores();
    public Operador consultar(String cedula);
	public void eliminar(String cedula);
    // Método para verificar si la cédula existe
    boolean existeCedula(String cedula);
}
