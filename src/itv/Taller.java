/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;

import itv.util.GestorIO;
import itv.util.Intervalo;
import java.util.regex.Pattern;

public class Taller {

    private Box[] boxes;
    private ColaInicial colaInicial;
    private TipoVehiculo tipovehiculo;

    public static final int NUM_BOXES = 6;
    
    public Taller() {
        this.boxes = new Box[Taller.NUM_BOXES];
        for (int i = 0; i < boxes.length; i++) {
            this.boxes[i] = new Box(i + 1);
        }
        this.colaInicial= new ColaInicial();
        this.tipovehiculo= TipoVehiculo.NADA;
    }
    
    private void comenzar() {
        Menu menu = new Menu();
        GestorIO gestorIO = new GestorIO();
        int opcion;
        do {
            menu.mostrar();
            opcion = menu.getOpcion();

            switch (opcion) {
                case 1:
                    colaInicial.mete(this.recogerNuevoVehiculo());
     
                    break;
                case 2:
                    
                    if (!colaInicial.vacia()) {
                        Box box = this.getBox();
                    
                        if (box.estaLibre()) {
                            box.mete(colaInicial.saca());
                            gestorIO.out("Vehículo añadido al box correctamente");
                        }
                        else {
                            gestorIO.out("Error!! No se pueden meter el vehículo, hay uno en la primera fase del box");
                        }
                    }
                    else {
                        gestorIO.out("Error!!! En la cola no hay vehículos");
                    }
                    break;
                case 3:
                    this.getBox().pasaVehiculosDeFase();
                    gestorIO.out("Vehículos desplazados de fase correctamente");
                    break;
                case 4:
                    this.getBox().mostrar();
                    break;

                case 5:
                    this.mostrar();
                    break;
                    
                //case 6:amedias
                        
                        
                //case 7:amedias
                    

                default:
            }
        } while (opcion != 8);
    }

    private Vehiculo recogerNuevoVehiculo() {
        String matricula = getMatricula();
        String Modelo = getModelo();
        tipovehiculo = getTipoVehiculo();
        if(tipovehiculo == TipoVehiculo.CAMION || tipovehiculo == TipoVehiculo.FURGONETA){
            return new Vehiculo(matricula, Modelo, tipovehiculo, getCilindro(), getPma());
        }
        else return new Vehiculo(matricula, Modelo, tipovehiculo, getCilindro(), getPlazas(), getPotencia());
        
    }
    
    private String getMatricula() {
        GestorIO gestorIO = new GestorIO();
        String matricula;
        boolean error;
        do {
            gestorIO.out("¿Mátricula? [DDDDLLL]:");
            matricula = gestorIO.inString();
            error = !Pattern.matches(Vehiculo.PATRON_MATRICULA, matricula);
            if (error){
                gestorIO.out("Error!!! Debe ser una matrícula válida");
            }
        } while(error);
        return matricula;
    }
    
    private String getModelo() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("¿Modelo?:");
        return gestorIO.inString();
    }
    
    private TipoVehiculo getTipoVehiculo() {
        GestorIO gestorIO = new GestorIO();
        boolean error;
        int opcion;
        
        do {
            gestorIO.out("¿Tipo de vehículo? [1:Coche, 2:Microbús, 3: Furgoneta, 4:Camión]:");
            opcion = gestorIO.inInt();
            error = !new Intervalo(1,4).incluye(opcion);
            if (error){
                gestorIO.out("Error!!! Debe ser un tipo válido");
            }
        } while(error);
        tipovehiculo = TipoVehiculo.tipoSegunIndice(opcion);
        return TipoVehiculo.tipoSegunIndice(opcion);
    }
    
    private int getCilindro() {
        GestorIO gestorIO = new GestorIO();
        int cilindro;
        
        gestorIO.out("¿Cilindros? ");
        cilindro = gestorIO.inInt();
        while(tipovehiculo == TipoVehiculo.COCHE && cilindro < 2 || cilindro > 6) {
            gestorIO.out("ERROR!! Los coches deben tener de 2 a 6 cilindros.");
            cilindro = gestorIO.inInt();
        }
        while(tipovehiculo == TipoVehiculo.MICROBUS && cilindro < 2 || cilindro > 6) {
            gestorIO.out("ERROR!! Los microbuses deben tener de 2 a 6 cilindros.");
            cilindro = gestorIO.inInt();
        }
        while(tipovehiculo == TipoVehiculo.FURGONETA && cilindro < 4 || cilindro > 10) {
            gestorIO.out("ERROR!! Las furgonetas deben tener de 4 a 10 cilindros.");
            cilindro = gestorIO.inInt();
        }
        while(tipovehiculo == TipoVehiculo.CAMION && cilindro < 8 || cilindro > 16) {
            gestorIO.out("ERROR!! Los camiones deben tener de 8 a 16 cilindros.");
            cilindro = gestorIO.inInt();
        }
        return cilindro;
    }
    
    private int getPlazas() {
        int plazas;
        GestorIO gestorIO = new GestorIO();
        do {
        gestorIO.out("¿Cuántas plazas?: (Entre 2 y 7) ");
        
        plazas = gestorIO.inInt();
        } while(plazas<2 || plazas>7);
        return plazas;
    }
    
    private int getPotencia() {
        double potencia;
        GestorIO gestorIO = new GestorIO();
        do {
            gestorIO.out("¿Cuantos CC? ");
            potencia = gestorIO.inFloat();
        } while(potencia < 0);
        return (int)potencia;
    }
    
    private double getPma() {
        double pma;
        GestorIO gestorIO = new GestorIO();
        do {
            gestorIO.out("¿Cuánto PMA? (Peso Máximo Autorizado) ");
            pma = gestorIO.inFloat();
        } while(pma < 0);
        return pma;
    }
    
    private Box getBox() {
        GestorIO gestorIO = new GestorIO();
        int numBox;
        boolean error;
        do {
            gestorIO.out("¿Número box? [1-"+NUM_BOXES+"]:");
            numBox = gestorIO.inInt();
            error = !new Intervalo(1,NUM_BOXES).incluye(numBox);
            if (error){
                gestorIO.out("Error!!! Debe ser un número de box válido");
            }
        } while(error);
        return boxes[numBox - 1];
    }

    private void mostrar() {
       colaInicial.mostrar();
       mostrarBoxes();
    }
    
    public void mostrarBoxes() {
        for (Box box : boxes) {
            box.mostrar();
        }
    }
    
    public static void main(String[] args) {
        new Taller().comenzar();
    }

}
