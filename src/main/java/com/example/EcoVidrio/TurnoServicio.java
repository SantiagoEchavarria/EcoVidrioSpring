package com.example.EcoVidrio;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TurnoServicio implements TurnoInterface {
    @Autowired
    private TurnoDAO turnoDAO;
 
    public TurnoServicio() {
    }
 
    @Transactional
    public void guardarTurno(Turno turno) {
       this.turnoDAO.save(turno);
    }
 
    @Transactional
    public List<Turno> listadoTurnos() {
       return this.turnoDAO.findAll();
    }
 
    @Override
    public Turno consultar(int id) {
     return turnoDAO.findById(id).orElse(null);  
 }
 
    @Override
    @Transactional
    public void eliminar(int id) {
        turnoDAO.deleteById(id); 
 }
}