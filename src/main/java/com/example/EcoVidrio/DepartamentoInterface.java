package com.example.EcoVidrio;

import java.util.List;

public interface DepartamentoInterface {
	void guardarDepartamento(Departamento departamento);
    List<Departamento> listadoDepartamentos();
    public Departamento consultar(int id);
	public void eliminar(int id);
}
