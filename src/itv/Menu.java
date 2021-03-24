/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itv;

import itv.util.GestorIO;
import itv.util.Intervalo;

class Menu {
    
private static final String[] TITULOS = new String[]{
        "\n1. Dar de alta coche y pasar a la cola",
        "\n2. Meter nuevo vehículo a box",
        "\n3. Pasar de fase vehículos en box",
        "\n4. Mostrar box",
        "\n5. Mostrar taller completo",
        "\n6. Calcular y pagar vehículo revisado",
        "\n7. Cálculo de ingresos",
        "\n8. Salir"
    };
    
    private static final Intervalo OPCIONES = new Intervalo(1,6);
    
    public void mostrar(){
        GestorIO gestorIO = new GestorIO();
        for (String titulo : TITULOS) {
            gestorIO.out(titulo);
        }
    }
    
    public int getOpcion() {
        GestorIO gestorIO = new GestorIO();
        int opcion;
        boolean error;
        do {
            gestorIO.out("\nOpción? [1-8]: ");
            opcion = gestorIO.inInt();
            error = !OPCIONES.incluye(opcion);
            if (error){
                gestorIO.out("Error!!! La opción debe ser entre 1 y 8");
            }
        } while (error);
        return opcion;
    }
    
    
    
}
