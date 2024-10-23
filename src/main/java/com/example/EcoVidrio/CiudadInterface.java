package com.example.EcoVidrio;

import java.util.List;

public interface CiudadInterface {
    void guardarCiudad(Ciudad ciudad);
    List<Ciudad> listadoCiudades();
    public Ciudad consultar(int id);
	public void eliminar(int id);

  
}