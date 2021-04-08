/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;

import itv.util.GestorIO;

class FaseRevision {
    
    private String nombre;
    private Vehiculo vehiculo;
    
    public FaseRevision(String nombre) {
        this.nombre = nombre;
        this.vehiculo = null;
    }
   
    public boolean hayVehiculo() {
        return vehiculo != null;
    }

    public void asigna(Vehiculo vehiculo) {
        assert vehiculo != null;
        this.vehiculo = vehiculo;
    }
    
    public void desasignaVehiculo() {
        this.vehiculo = null;
    }
    
    public void mostrar() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("\nFase " + nombre + ": ");
        
        if (vehiculo != null)
            gestorIO.out(vehiculo);
        else
            gestorIO.out("Vacío");
    }

    public void asignaVehiculoA(FaseRevision faseRevision) {
       faseRevision.vehiculo = this.vehiculo;
       this.desasignaVehiculo();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
}