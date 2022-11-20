package com.mycompany.pelucanina.persistencia;

import com.mycompany.pelucanina.logica.Duenio;
import com.mycompany.pelucanina.logica.Mascota;
import com.mycompany.pelucanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascoJpa = new MascotaJpaController();
    
    public void guardar(Duenio duenio, Mascota masco){
        
        //Crear en la BD el Dueño
        duenioJpa.create(duenio);
        
        //Crear en la BD la mascota
        mascoJpa.create(masco);
       
        
    }

     public List<Mascota> traerMascota() {
        
      return mascoJpa.findMascotaEntities();
         
     }  

    public void BorrarMascota(int num_cliente){
        try{
         mascoJpa.destroy(num_cliente);
        }catch (NonexistentEntityException ex){
         Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE,null,ex);
        }
    }    

    public Mascota traerMascota(int num_cliente) {
       return mascoJpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco) {
        try{
        mascoJpa.edit(masco);
        }catch(Exception e){
        Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE,null,e);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
       return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio dueno) {
        try{
        duenioJpa.edit(dueno);
        }catch(Exception e){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
