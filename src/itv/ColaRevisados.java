/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;

/**
 *
 * @author ciclost
 */
public class ColaRevisados {
    //Este archivo forma parte del ejercicio 8.1
    final private int cantidadarray;
    private Vehiculo[] array;
    
    public ColaRevisados(){
        cantidadarray = 10;
        array = new Vehiculo[cantidadarray];
        this.aNull();
    }
    
    public void introducirVehiculo(Vehiculo vehiculo){
        if(vehiculo != null){
            for(int i=0;i<array.length;i++){
                if(i == array.length-1){
                    array[i] = vehiculo;
                }
            
                if(i!=array.length-1 && array[i] == null && array[i+1] != null){
                    array[i] = vehiculo;
                    i= array.length+1;
                }
            }
            System.out.println("Se ha introducido un vehículo a la cola de revisados");
        }
    }
    
    public void actualizarArray(){
        Vehiculo acumulador;
        for(int i=array.length-1;i>0;i--){
            if(i != 0) {
                acumulador = array[i-1];
                array[i] = acumulador;
            }
        }
        array[0] = null;
    }
    
    
    public Vehiculo sacarVehiculo(){
        Vehiculo paraSacar;
        for(int i=array.length-1;i>=0;i--){
            if(array[i] !=null) {
                paraSacar = array[i];
                System.out.println("Se ha sacado un vehículo de la cola de revisados");
                return paraSacar;
            }
        }
        System.out.println("No se ha sacado ningún vehículo de la cola de revisados");
        return null;
    }
    
    public void aNull(){
        for(int i=0; i<array.length; i++){
            array[i] = null;
        }
    }
    
    public TipoVehiculo saberUltimoVehiculo() {
        return array[array.length-1].getTipoVehiculo();
    }
    
    

}
