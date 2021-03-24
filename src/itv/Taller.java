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

    public static final int NUM_BOXES = 6;
    
    public Taller() {
        this.boxes = new Box[Taller.NUM_BOXES];
        for (int i = 0; i < boxes.length; i++) {
            this.boxes[i] = new Box(i + 1);
        }
        this.colaInicial= new ColaInicial();
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
                    
                case 6:amedias
                        
                        
                case 7:amedias
                    

                default:
            }
        } while (opcion != 8);
    }

    private Vehiculo recogerNuevoVehiculo() {
        return new Vehiculo(getMatricula(), getModelo(), getTipoVehiculo());
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
        return TipoVehiculo.tipoSegunIndice(opcion);
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
