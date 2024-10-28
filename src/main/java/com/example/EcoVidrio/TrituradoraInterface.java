package com.example.EcoVidrio;

import java.util.List;
import java.util.Optional;

public interface TrituradoraInterface {
 void guardarTrituradora(Trituradora trituradora);
    List<Trituradora> listadoTrituradoras();
    public Trituradora consultar(int id);
	public void eliminar(int id);
    void inhabilitarTrituradora(int id);
    void habilitarTrituradora(int id);
    Optional<Trituradora> buscarPorNombre(String nombre);
} 