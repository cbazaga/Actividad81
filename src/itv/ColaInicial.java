/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;

import java.util.Arrays;
import itv.util.GestorIO;

class ColaInicial {
    
    private Vehiculo[] vehiculos;
    
    public ColaInicial() {
        
        vehiculos = new Vehiculo[0];
    }

    public void mete(Vehiculo vehiculo) {
        GestorIO gestorIO = new GestorIO();
        if(this.repetidaMatricula(vehiculo)){
            gestorIO.out("No se ha podido añadir. Matrícula repetida.");
        }
        else{
            vehiculos = Arrays.copyOf(vehiculos, vehiculos.length + 1);
            vehiculos[vehiculos.length - 1] = vehiculo;
            gestorIO.out("Vehículo añadido a la cola");
        }
        
    }
    
    public Vehiculo saca() {
        assert !vacia();
        
        Vehiculo vehiculo = vehiculos[0];
        
        for (int i = 1; i < vehiculos.length; i++) {
            this.vehiculos[i-1] = this.vehiculos[i];
        }
        
        vehiculos = Arrays.copyOf(vehiculos, vehiculos.length - 1);
        
        return vehiculo;
    }

    public boolean vacia() {
        return this.vehiculos.length == 0;
    }

    public void mostrar() {
        GestorIO gestorIO = new GestorIO();
        if (!this.vacia()){
            gestorIO.out("\nCola Inicial:");
            for (Vehiculo vehiculo : vehiculos) {
                gestorIO.out("\n"+vehiculo);
            }
        }
    }

    private boolean repetidaMatricula(Vehiculo vehiculo) {
        for(Vehiculo v: vehiculos){
            if(v.tieneEsta(vehiculo.getMatricula())){
                return true;
            }
        }
        return false;
    }
    
}
