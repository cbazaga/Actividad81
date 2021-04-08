/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;

import static itv.Vehiculo.PATRON_MATRICULA;
import java.util.regex.Pattern;

/**
 *
 * @author ciclost
 */
public class TransporteCarga extends Vehiculo{
    //Este archivo forma parte del ejercicio 8.1
    
    public TransporteCarga(String matricula, String modelo, TipoVehiculo tipoVehiculo, int cilindros, double pma) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.cilindros = cilindros;
        this.pma = pma;
    }
    
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
