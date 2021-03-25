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
public class TransportePersonas extends Vehiculo{
    //Este archivo forma parte del ejercicio 8.1
    
    public double calcularPrecio(){
        double base = super.calcularPrecio();
        double total=0;
        if(this.tipoVehiculo == TipoVehiculo.COCHE) {
            if(this.plazas > 3){
                total += plazas*1.5;
            }
        }
        else if(this.tipoVehiculo == TipoVehiculo.MICROBUS){
            if(this.plazas > 3){
                total += plazas*2;
            }
        }
        
        if(this.potencia>1200){
                total += plazas+10;
            }
        return total+base;
    }
    
    
    
}
