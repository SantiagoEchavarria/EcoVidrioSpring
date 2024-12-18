package com.example.EcoVidrio;

import java.util.List;

public interface DepartamentoInterface {
    void guardarDepartamento(Departamento departamento);
    List<Departamento> listadoDepartamentos();
    public Departamento consultar(int id);
    public void eliminar(int id);
    // Métodos para inhabilitar y habilitar departamentos
    void inhabilitar(int id); // Método para inhabilitar departamento
    void habilitarDepartamento(int id); // Método para habilitar departamento
    Object obtenerDepartamentosHabilitados();
}
