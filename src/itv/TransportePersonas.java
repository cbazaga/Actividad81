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
public class TransportePersonas extends Vehiculo{
    //Este archivo forma parte del ejercicio 8.1
    public static final String PATRON_MATRICULA = "\\d{4}[A-Z]{3}";
    
    public TransportePersonas(){
        
    }
    
    //COCHES Y MICROBUSES
    public TransportePersonas(String matricula, String modelo, TipoVehiculo tipoVehiculo, int cilindros, int plazas, int potencia){
        assert Pattern.matches(PATRON_MATRICULA, matricula);

        this.matricula = matricula;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.cilindros = cilindros;
        this.plazas = plazas;
        this.potencia = potencia;
    }
    
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
