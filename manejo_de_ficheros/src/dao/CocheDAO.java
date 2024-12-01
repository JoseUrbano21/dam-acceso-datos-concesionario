package dao;

import model.Coche;

import java.io.*;
import java.util.ArrayList;

public class CocheDAO {

    ArrayList<Coche> listaCoches;

    public CocheDAO(ArrayList<Coche> listaCoches) {
        this.listaCoches = listaCoches;
    }

    public ArrayList<Coche> leerArchivo() {
        File file = new File("resources/coches.dat");
        if (file.exists()) {
            FileInputStream fileInput;
            ObjectInputStream objectInput = null;
            try {
                fileInput = new FileInputStream(file);
                objectInput = new ObjectInputStream(fileInput);
                listaCoches.clear();
                listaCoches.addAll((ArrayList<Coche>) objectInput.readObject());
                System.out.println("Se han cargado los coches:");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (objectInput != null) {
                        objectInput.close();
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            listaCoches = new ArrayList<>();
            System.out.println("El archivo coches.dat no existe\nSe ha creado una lista vacía");
        }
        return this.listaCoches;
    }

    public void guardarArchivo() {
        if (!listaCoches.isEmpty()) {
            File fileSalida = new File("manejo_de_ficheros/src/resources/coches.txt");
            ObjectOutputStream output = null;
            try {
                output = new ObjectOutputStream(new FileOutputStream(fileSalida));
                output.writeObject(listaCoches);
                System.out.println("Se ha creado el fichero con la lista de coches");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (output != null) {
                        output.close();
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    ;
                }
            }
        } else {
            System.out.println("La lista está vacía");
        }
    }

public void exportarCSV() {
    if (!listaCoches.isEmpty()) {
        File fileCsv = new File("manejo_de_ficheros/src/resources/coches.csv");
        BufferedWriter buffer = null;
        try {
            buffer = new BufferedWriter(new FileWriter(fileCsv));
            for (Coche ele : listaCoches) {
                buffer.write(ele.getId() + ";" + ele.getMatricula() + ";" + ele.getMarca() + ";" + ele.getModelo() + ";" + ele.getColor());
                buffer.newLine();
            }
            System.out.println("Archivo CSV creado correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    } else {
        System.out.println("La lista está vacía");
    }
}
}
