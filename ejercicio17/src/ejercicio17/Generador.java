/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio17;

import java.util.HashMap;
import java.util.Map;

interface Almacenamiento {
    void guardarArchivo(String nombre, String contenido);
    String recuperarArchivo(String nombre);
}
class AlmacenamientoLocal implements Almacenamiento {
    private Map<String, String> almacenamiento = new HashMap<>();

    @Override
    public void guardarArchivo(String nombre, String contenido) {
        almacenamiento.put(nombre, contenido);
        System.out.println("Archivo '" + nombre + "' guardado en almacenamiento local.");
    }
 
 @Override
 public String recuperarArchivo(String nombre) {
   return almacenamiento.getOrDefault(nombre, "Archivo no encontrado en local.");
    }
}
class AlmacenamientoNube implements Almacenamiento {
    private Map<String, String> almacenamiento = new HashMap<>();

    @Override
    public void guardarArchivo(String nombre, String contenido) {
        almacenamiento.put(nombre, contenido);
        System.out.println("Archivo '" + nombre + "' subido a la nube.");
    }

    @Override
    public String recuperarArchivo(String nombre) {
        return almacenamiento.getOrDefault(nombre, "Archivo no encontrado en la nube.");
    }
}
class GestorArchivos {
    private Almacenamiento almacenamiento;

    public GestorArchivos(Almacenamiento almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public void guardar(String nombre, String contenido) {
        almacenamiento.guardarArchivo(nombre, contenido);
    }

    public void recuperar(String nombre) {
        String contenido = almacenamiento.recuperarArchivo(nombre);
        System.out.println("Contenido del archivo '" + nombre + "': " + contenido);
    }
}
 class Main {
    public static void main(String[] args) {
        // Uso de almacenamiento local
        GestorArchivos gestorLocal = new GestorArchivos(new AlmacenamientoLocal());
        gestorLocal.guardar("documento.txt", "Este es un archivo de prueba.");
        gestorLocal.recuperar("documento.txt");

        // Uso de almacenamiento en la nube
        GestorArchivos gestorNube = new GestorArchivos(new AlmacenamientoNube());
        gestorNube.guardar("foto.jpg", "Imagen en formato binario...");
        gestorNube.recuperar("foto.jpg");
    }
}
