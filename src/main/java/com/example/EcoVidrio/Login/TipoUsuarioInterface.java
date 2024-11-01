package com.example.EcoVidrio.Login;

import java.util.List;


public interface TipoUsuarioInterface {
     void guardarTipoUsuario(TipoUsuario tipoUsuario);
    List<TipoUsuario> listadoTipoUsuarios();
    public TipoUsuario consultar(int id);
	public void eliminar(int id);
    boolean existenUsuariosAsociados(int idtipoUsuario);
}
