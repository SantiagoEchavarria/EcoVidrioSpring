package com.example.EcoVidrio;

import java.util.List;

public interface TrituradoraInterface {
 void guardarTrituradora(Trituradora trituradora);
    List<Trituradora> listadoTrituradoras();
    public Trituradora consultar(int id);
	public void eliminar(int id);
    // Nuevos métodos para inhabilitar y habilitar direcciones
    void inhabilitarTrituradora(int id);
    void habilitarTrituradora(int id);
} 