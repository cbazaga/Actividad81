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
    //CAMIONES Y FURGONETAS
    public Vehiculo(String matricula, String modelo, TipoVehiculo tipoVehiculo, int cilindros, double pma) {
        assert Pattern.matches(PATRON_MATRICULA, matricula);

        this.matricula = matricula;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.cilindros = cilindros;
        this.pma = pma;
    }
    
    //COCHES Y MICROBUSES
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

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCilindros() {
        return cilindros;
    }

    public int getPlazas() {
        return plazas;
    }

    public int getPotencia() {
        return potencia;
    }

    public double getPma() {
        return pma;
    }

    public TransportePersonas convertirTransporte(){
        return new TransportePersonas(this.matricula, this.modelo , this.tipoVehiculo, this.cilindros, this.plazas, this.potencia);
    }
    
    public TransporteCarga convertirCarga(){
        return new TransporteCarga(this.matricula, this.modelo, this.tipoVehiculo, this.cilindros, this.pma);
    }
    
    
    
    
    
    
}
