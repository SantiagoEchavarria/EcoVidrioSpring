package com.example.EcoVidrio;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TurnoOperario")
public class TurnoOperario {
    @Id
    int idOperario;
    String fecha;
    public TurnoOperario() {
		
	}

//Relacion muchos a uno	
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trituradora")
    private Trituradora trituradora;

    public Trituradora getTrituradora() {
        return trituradora;
    }

    public void setTrituradora(Trituradora trituradora) {
        this.trituradora = trituradora;
    }


    //Relacion muchos a uno	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Operador operador;
	

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}



    //Relacion muchos a uno	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "turno_nombre", nullable = true)
	private Turno turno;
	
	

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}


     // Constructor
     public TurnoOperario(int idOperario, String fecha) {
        this.idOperario = idOperario;
        this.fecha = fecha;
        
    }

   
  
    public int getIdOperario() {
        return idOperario;
    }

    public String getFecha() {
        return fecha;
    }

   
  
    public void setIdOperario(int idOperario) {
        this.idOperario = idOperario;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

 

  
    @Override
    public String toString() {
        return "TurnoOperario{" + "idOperario=" + idOperario +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
