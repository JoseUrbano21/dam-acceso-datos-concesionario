import dao.CocheDAO;
import logicaNegocio.Concesionario;
import model.Coche;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));
        ArrayList<Coche> lista = new ArrayList<>();
        CocheDAO cocheDAO = new CocheDAO(lista);
        ArrayList<Coche> listaCoches = cocheDAO.leerArchivo();
        Concesionario concesionario = new Concesionario(listaCoches);

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            // SE MUESTRA EL MENÚ AL USUARIO
            System.out.println("""
                    Elige una opción:
                    1. Añadir nuevo coche
                    2. Borrar coche por id
                    3. Consulta coche por id
                    4. Listado de coches
                    5. Exportar a CSV
                    6. Terminar el programa
                    """);

            // CON SCANNER SE CAPTA LA OPCIÓN DEL USUARIO Y SE EJECUTA EL CASE CORRESPONDIENTE DEL SWITCH
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // AÑADIR UN COCHE A LA LISTA
                    System.out.println("Escribe los datos del coche a añadir:");
                    System.out.println("ID:");
                    String newId = scanner.nextLine();
                    System.out.println("Matrícula:");
                    String newMatricula = scanner.nextLine();
                    System.out.println("Marca:");
                    String newMarca = scanner.nextLine();
                    System.out.println("Modelo:");
                    String newModelo = scanner.nextLine();
                    System.out.println("Color:");
                    String newColor = scanner.nextLine();

                    Coche coche = new Coche(newId, newMatricula, newMarca, newModelo, newColor);
                    concesionario.añadirCoche(coche);
                    break;
                case 2:
                    // BORRAR UN COCHE DE LA LISTA
                    System.out.println("Escribe el ID del coche a borrar:");
                    String borrarId = scanner.nextLine();
                    concesionario.borrarCoche(borrarId);
                    break;
                case 3:
                    // CONSULTAR UN COCHE DE LA LISTA
                    System.out.println("Escribe el ID del coche a consultar:");
                    String consultarId = scanner.nextLine();
                    concesionario.consultarCoche(consultarId);
                    break;
                case 4:
                    // MOSTRAR LA LISTA DE COCHES
                    concesionario.mostrarLista();
                    break;
                case 5:
                    // EXPORTAR LA LISTA DE COCHES A UN ARCHIVO CSV
                    cocheDAO.exportarCSV();
                    break;
                case 6:
                    // SE GENERA UN ARCHIVO NUEVO QUE SOBREESCRIBE AL ANTERIOR CON LOS NUEVOS DATOS DE LA LISTA
                    System.out.println("Ha salido del menú\nSe ha creado un archivo\nFin del programa");
                    cocheDAO.guardarArchivo();
                    break;
                default:
                    System.out.println("La opción no es válida");
                    break;
            }
        } while (opcion != 6);
    }
}