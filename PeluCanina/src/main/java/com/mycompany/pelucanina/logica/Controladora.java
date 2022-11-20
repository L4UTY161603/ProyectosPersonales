package com.mycompany.pelucanina.logica;

import com.mycompany.pelucanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String alergico, String atenesp, String nombreDuenio, String celDuenio) {
        
        //Creamos dueño y aisgnamos sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        //Creamos mascota y asignamos sus valores
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenesp);
        masco.setObservaciones(observaciones);
        masco.setUnDuenio(duenio);
        
  
        controlpersis.guardar(duenio,masco);
       
            
    }

    public List<Mascota> traerMascotas() {
       
        return controlpersis.traerMascota();
        
    }

    public void borrarMascota(int num_cliente) {
       controlpersis.BorrarMascota(num_cliente);
    }

    public Mascota traerMascotas(int num_cliente) {
      return controlpersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atenesp, String nombreDuenio, String celDuenio) {
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenesp);
        
        //Modifico mascota
        controlpersis.modificarMascota(masco);
        
        //seteo nuestros valores de dueño
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        dueno.setCelDuenio(celDuenio);
        dueno.setNombre(nombreDuenio);
        
        //llamar al modificar dueño
        this.modificarDuenio(dueno);
    }

    private Duenio buscarDuenio(int id_duenio) {
      return controlpersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        controlpersis.modificarDuenio(dueno);
    }
 
}
