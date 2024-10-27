package com.example.EcoVidrio;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperadorServicio implements OperadorInterface{
     @Autowired
   private OperadorDAO operadorDAO;

   public OperadorServicio() {
   }

   @Transactional
   public void guardarOperador(Operador operador) {
      this.operadorDAO.save(operador);
   }

   @Transactional
   public List<Operador> listadoOperadores() {
      return this.operadorDAO.findAll();
   }

   @Override
   public Operador consultar(String cedula) {
    return operadorDAO.findByCedula(cedula).orElse(null);  // Usa findByCedula en lugar de findById
}

    @Override
@Transactional
public void eliminar(String cedula) {
    operadorDAO.deleteByCedula(cedula);  // Usa deleteByCedula en lugar de deleteById
}

@Override
@Transactional
public boolean existeCedula(String cedula) {
    return operadorDAO.findByCedula(cedula).isPresent();  // Verifica si existe la cédula
}


}
