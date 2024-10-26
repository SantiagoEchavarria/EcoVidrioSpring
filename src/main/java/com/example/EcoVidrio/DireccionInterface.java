package com.example.EcoVidrio;

import java.util.List;

public interface DireccionInterface {
void guardarDireccion(Direccion direccion);
    List<Direccion> listadoDirecciones();
    public Direccion consultar(int id);
	public void eliminar(int id);
    
} 