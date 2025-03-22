/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio19;

abstract class Transporte {
    protected String modelo;

    public Transporte(String modelo) {
        this.modelo = modelo;
    }

    public abstract void mover();
}
class Bicicleta extends Transporte {
    public Bicicleta(String modelo) {
        super(modelo);
    }

    @Override
    public void mover() {
        System.out.println("La bicicleta " + modelo + " se está moviendo pedaleando.");
    }
}
class Coche extends Transporte {
    public Coche(String modelo) {
        super(modelo);
    }

    @Override
    public void mover() {
        System.out.println("coche " + modelo + " se está moviendo con el motor.");
    }
}
 class Main {
    public static void main(String[] args) {
        Transporte bicicleta = new Bicicleta("Solo ciclax");
        Transporte coche = new Coche("Pichirilo");

        bicicleta.mover();
        coche.mover();
    }
}
