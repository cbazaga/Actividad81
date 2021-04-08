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
public class ColaPagados {
    private Vehiculo[] array;
    final private int cantidad;
    
    public ColaPagados(){
        cantidad = 10;
        array = new Vehiculo[cantidad];
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
            System.out.println("Se ha introducido un vehículo a la cola de pagados");
        }
    }
    
    public double calcularTotal() {
        double total = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] != null){
                total += array[i].calcularPrecio();
            }
        }
        return total;
    }
    
    public void aNull(){
        for(int i=0; i<array.length; i++){
            array[i] = null;
        }
    }
    
}
