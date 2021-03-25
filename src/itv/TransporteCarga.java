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
public class TransporteCarga extends Vehiculo{
    //Este archivo forma parte del ejercicio 8.1
    
    public double calcularPrecio(){
        double total=0;
        double base = super.calcularPrecio();
        if(this.cilindros<10){
            total += 3*pma;
        }
        else total += 4*pma;
        
        if(this.tipoVehiculo == TipoVehiculo.CAMION){
            total += 40+(20/100*base);
            if(this.potencia>2000){
                total +=20;
            }
        }
        return total*base;
    }
    
}
