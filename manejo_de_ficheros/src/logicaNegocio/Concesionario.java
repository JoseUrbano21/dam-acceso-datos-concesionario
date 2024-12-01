package logicaNegocio;

import model.Coche;

import java.util.ArrayList;

public class Concesionario {

    ArrayList<Coche> listaCoches;

    public Concesionario(ArrayList<Coche> listaCoches) {
        this.listaCoches = listaCoches;
    }

    public void añadirCoche(Coche coche) {
        if (!listaCoches.contains(coche)) {
            listaCoches.add(coche);
            System.out.println("El coche ha sido añadido a la lista:");
            mostrarLista();
        } else {
            System.out.println("El coche ya se encuentra en la lista");
        }
    }

    public void borrarCoche(String id) {
        Coche coche = new Coche();
        coche.setId(id);
        int pos = listaCoches.indexOf(coche);
        if (pos != -1) {
            listaCoches.remove(pos);
            System.out.println("El coche se ha eliminado de la lista:");
            mostrarLista();
        } else {
            System.out.println("No existe el coche con ID " + id);
        }
    }

    public void consultarCoche(String id) {
        Coche coche = new Coche();
        coche.setId(id);
        int pos = listaCoches.indexOf(coche);
        if (pos != -1) {
            Coche ele = listaCoches.get(pos);
            System.out.println(ele.toString());
        } else {
            System.out.println("No existe el coche con ID " + id);
        }
    }

    public void mostrarLista() {
        if (!listaCoches.isEmpty()) {
            for (Coche ele : listaCoches) {
                System.out.println(ele.toString());
            }
        } else {
            System.out.println("La lista está vacía");
        }
    }
}
