/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;

import java.util.regex.Pattern;

class Vehiculo {
    //Modificado por la actividad 8.1
    protected String matricula;
    protected String modelo;
    protected TipoVehiculo tipoVehiculo;
    protected int cilindros;
    protected int plazas;
    protected int potencia;
    protected double pma;
    
    public static final String PATRON_MATRICULA = "\\d{4}[A-Z]{3}";

    public Vehiculo(){
        
    }
    
    public Vehiculo(String matricula, String modelo, TipoVehiculo tipoVehiculo, int cilindros, double pma) {
        assert Pattern.matches(PATRON_MATRICULA, matricula);

        this.matricula = matricula;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.cilindros = cilindros;
        this.pma = pma;
    }
    
    public Vehiculo(String matricula, String modelo, TipoVehiculo tipoVehiculo, int cilindros, int plazas, int potencia){
        assert Pattern.matches(PATRON_MATRICULA, matricula);

        this.matricula = matricula;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.cilindros = cilindros;
        this.plazas = plazas;
        this.potencia = potencia;
    }
   
    public boolean tieneEsta(String matricula) {
        assert matricula != null;
        return this.matricula.equals(matricula);
    }   
    
    public String getMatricula(){
        return this.matricula;
    }
    
    @Override
    public String toString() {
        return "Matricula:" + matricula + " Modelo:" + modelo + " Tipo:" + tipoVehiculo.toString();
    }
    
    public double calcularPrecio(){
        return 15*cilindros;
    }
    
    
}
