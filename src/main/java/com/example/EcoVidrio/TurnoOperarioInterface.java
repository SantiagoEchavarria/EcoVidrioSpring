package com.example.EcoVidrio;

import java.util.List;

public interface TurnoOperarioInterface {
    void guardarTurnoOperario(TurnoOperario ciudad);
    List<TurnoOperario> listadoTurnoOperarios();
    public TurnoOperario consultar(int id);
	public void eliminar(int id);
} 