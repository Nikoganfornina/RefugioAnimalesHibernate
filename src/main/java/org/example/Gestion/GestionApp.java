package org.example.Gestion;

import org.example.DAO.animalesImpl;
import org.example.DAO.personaImpl;
import org.example.entities.Animales;
import org.example.entities.Persona;

import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que maneja la gestión de animales, personas y adopciones en un sistema de casa de acogida.
 * Utiliza un menú interactivo para permitir al usuario seleccionar qué operación desea realizar.
 */
public class GestionApp {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Método principal que inicia el programa y presenta un menú para gestionar animales, personas y adopciones.
     */
    public static void InicioPrograma() {
        boolean continuar = true;

        System.out.println("Bienvenidos al sistema de gestión de la casa de acogida de animales Hibernate");

        while (continuar) {
            System.out.println("\n¿Qué desea hacer hoy?");
            System.out.println("1. Gestionar animales");
            System.out.println("2. Gestionar personas");
            System.out.println("3. Gestionar adopciones");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String input = scanner.nextLine();

            try {
                int opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado 'Gestionar animales'.");
                        GestionarAnimales(scanner);
                        break;
                    case 2:
                        System.out.println("Has seleccionado 'Gestionar personas'.");
                        GestionarPersonas(scanner);
                        break;
                    case 3:
                        System.out.println("Has seleccionado 'Gestionar adopciones'.");
                        GestionarAdopciones(scanner);
                        break;
                    case 4:
                        System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 4.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entre 1 y 4.");
            }
        }

        scanner.close();
    }

    /**
     * Método que gestiona las operaciones relacionadas con los animales (agregar, ver, eliminar, buscar por especie).
     * @param scanner El objeto Scanner para la lectura de entradas del usuario.
     */
    public static void GestionarAnimales(Scanner scanner) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú Gestión de Animales");
            System.out.println("¿Qué desea hacer hoy?");
            System.out.println("1. Agregar animales");
            System.out.println("2. Ver animales");
            System.out.println("3. Eliminar animales");
            System.out.println("4. Buscar por especie de animales");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            String input = scanner.nextLine();

            try {
                int opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        System.out.println("Agregar animales");
                        AgregarAnimales();
                        break;
                    case 2:
                        System.out.println("Ver animales");
                        verAnimales();
                        break;
                    case 3:
                        System.out.println("Eliminar animales");
                        EliminarAnimales();
                        break;
                    case 4:
                        System.out.println("Ver por especie");
                        verAnimalporespecie();
                        break;
                    case 5:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 4.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entre 1 y 4.");
            }
        }
    }

    /**
     * Método que gestiona las operaciones relacionadas con las personas (agregar, ver, eliminar).
     * @param scanner El objeto Scanner para la lectura de entradas del usuario.
     */
    public static void GestionarPersonas(Scanner scanner) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú Gestión de Personas");
            System.out.println("¿Qué desea hacer hoy?");
            System.out.println("1. Agregar personas");
            System.out.println("2. Ver personas");
            System.out.println("3. Eliminar personas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String input = scanner.nextLine();

            try {
                int opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        System.out.println("Agregar personas");
                        AgregarPersonas();
                        break;
                    case 2:
                        System.out.println("Ver personas");
                        verPersonas();
                        break;
                    case 3:
                        System.out.println("Eliminar personas");
                        EliminarPersonas();
                        break;
                    case 4:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 4.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entre 1 y 4.");
            }
        }
    }

    /**
     * Método que gestiona las operaciones relacionadas con las adopciones (agregar y ver adopciones).
     * @param scanner El objeto Scanner para la lectura de entradas del usuario.
     */
    public static void GestionarAdopciones(Scanner scanner) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú Gestión de Adopciones");
            System.out.println("¿Qué desea hacer hoy?");
            System.out.println("1. Agregar adopciones");
            System.out.println("2. Ver adopciones");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            String input = scanner.nextLine();

            try {
                int opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        System.out.println("Agregar adopciones");
                        AgregarAdopciones();
                        break;
                    case 2:
                        System.out.println("Ver adopciones");
                        VerAdopciones();
                        break;
                    case 3:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 3.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entre 1 y 3.");
            }
        }
    }



    /**
     * Agrega un nuevo animal al refugio solicitando al usuario información como nombre, especie, edad, estado y descripción.
     */
    public static void AgregarAnimales() {
        animalesImpl ani = new animalesImpl();
        Scanner scanner = new Scanner(System.in);

        // Validación del nombre del animal
        String nombre;
        while (true) {
            System.out.println("Ingrese el nombre del animal (no puede estar vacío):");
            nombre = scanner.nextLine().trim();
            if (!nombre.isEmpty() && nombre.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Error: El nombre no puede estar vacío y debe contener solo letras.");
            }
        }

        // Validación de la especie del animal
        String especie;
        while (true) {
            System.out.println("Ingrese la especie del animal (no puede estar vacía):");
            especie = scanner.nextLine().trim();
            if (!especie.isEmpty() && especie.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Error: La especie no puede estar vacía y debe contener solo letras.");
            }
        }

        // Validar edad del animal
        int edad;
        while (true) {
            System.out.println("Ingrese la edad del animal (número entero positivo):");
            if (scanner.hasNextInt()) {
                edad = scanner.nextInt();
                if (edad > 0) {
                    scanner.nextLine();  // Limpiar el buffer de la entrada
                    break;
                } else {
                    System.out.println("Error: La edad debe ser un número mayor que 0.");
                }
            } else {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.next();
            }
        }

        // Selección del estado del animal
        Animales.EstadoAnimal e = null;
        while (true) {
            System.out.println("Elija el estado del animal:");
            System.out.println("1. Recien Abandonado");
            System.out.println("2. Con tiempo en el refugio");
            System.out.println("3. Proximamente en adopcion");
            if (scanner.hasNextInt()) {
                int estado = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer de la entrada
                switch (estado) {
                    case 1:
                        e = Animales.EstadoAnimal.RECIEN_ABANDONADO;
                        break;
                    case 2:
                        e = Animales.EstadoAnimal.TIEMPO_EN_EL_REFUGIO;
                        break;
                    case 3:
                        e = Animales.EstadoAnimal.PROXIMAMENTE_EN_ACOGIDA;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elija un número entre 1 y 3.");
                        continue;
                }
                break;
            } else {
                System.out.println("Error: Debe ingresar un número entero entre 1 y 3.");
                scanner.next();
            }
        }

        // Validación de la descripción del animal
        String descripcion;
        while (true) {
            System.out.println("Ingrese la descripción del animal (no puede estar vacía):");
            descripcion = scanner.nextLine().trim();
            if (!descripcion.isEmpty()) {
                break;
            } else {
                System.out.println("Error: La descripción no puede estar vacía.");
            }
        }

        // Guardar el nuevo animal en la base de datos
        ani.save(new Animales(null, nombre, especie, edad, descripcion, e, null));
        System.out.println("Animal agregado correctamente.");
    }

    /**
     * Muestra la lista completa de los animales en el refugio.
     */
    public static void verAnimales() {
        System.out.println("Esta es la lista completa de los animales del refugio");
        System.out.println("--------------------------------------------------");
        animalesImpl ani = new animalesImpl();
        System.out.println(ani.findAll());
    }

    /**
     * Permite buscar y ver animales por especie.
     */
    public static void verAnimalporespecie() {
        animalesImpl ani = new animalesImpl();
        Scanner scanner = new Scanner(System.in);
        String especie;

        while (true) {
            System.out.println("Ingrese la especie del animal (o una aproximación del nombre de la especie):");
            especie = scanner.nextLine().trim();

            if (especie.isEmpty()) {
                System.out.println("La entrada no puede estar vacía. Intente nuevamente.");
                continue;
            }

            List<Animales> animalesEncontrados = ani.findByEspecie(especie);

            if (animalesEncontrados.isEmpty()) {
                System.out.println("No se encontraron animales con esa especie. Intente nuevamente.");
            } else {
                System.out.println("Animales encontrados:");
                System.out.println("--------------------------------------------------");
                for (Animales animal : animalesEncontrados) {
                    System.out.println(animal);
                }
                break;
            }
        }
    }

    /**
     * Elimina un animal del refugio según su ID.
     */
    public static void EliminarAnimales() {
        animalesImpl ani = new animalesImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Esta es la lista de animales");
        System.out.println("--------------------------------------------------");
        System.out.println(ani.findAll());
        int id;

        while (true) {
            System.out.println("Ingrese el ID del animal que desea eliminar:");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                break;
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next();
            }
        }

        ani.delete(id);
        System.out.println("Animal eliminado correctamente.");
    }


    /**
     * Agrega una nueva persona al sistema. Solicita el nombre, ciudad y edad del usuario, validando
     * que la información ingresada sea correcta y cumpla con los requisitos establecidos.
     * El nombre y la ciudad deben contener solo letras y no pueden estar vacíos. La edad debe ser un número
     * entero positivo.
     */
    public static void AgregarPersonas() {
        personaImpl ani = new personaImpl();

        String nombre;
        while (true) {
            System.out.println("Ingrese el nombre del usuario (no puede estar vacío):");
            nombre = scanner.nextLine().trim();
            if (!nombre.isEmpty() && nombre.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Error: El nombre no puede estar vacío y debe contener solo letras.");
            }
        }

        String ciudad;
        while (true) {
            System.out.println("Ingrese la ciudad de la que proviene el usuario (no puede estar vacía):");
            ciudad = scanner.nextLine().trim();
            if (!ciudad.isEmpty() && ciudad.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Error: La especie no puede estar vacía y debe contener solo letras.");
            }
        }

        int edad;
        while (true) {
            System.out.println("Ingrese la edad del usuario (número entero positivo):");
            if (scanner.hasNextInt()) {
                edad = scanner.nextInt();
                if (edad > 0) {
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Error: La edad debe ser un número mayor que 0.");
                }
            } else {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.next();
            }
        }

        ani.save(new Persona(null, nombre, ciudad, edad));
        System.out.println("Persona agregada correctamente.");
    }

    /**
     * Muestra una lista completa de las personas en el sistema, mostrando la información de todas las
     * personas registradas en el refugio.
     */
    public static void verPersonas() {
        System.out.println("Esta es la lista completa de los usuarios del refugio");
        System.out.println("--------------------------------------------------");
        personaImpl ani = new personaImpl();
        System.out.println(ani.findAll());
    }

    /**
     * Elimina a una persona del sistema. Muestra la lista de personas y solicita al usuario que ingrese
     * el ID de la persona que desea eliminar. Valida que la entrada sea un número entero.
     */
    public static void EliminarPersonas() {
        personaImpl ani = new personaImpl();
        System.out.println("Esta es la lista de personas");
        System.out.println("--------------------------------------------------");
        System.out.println(ani.findAll());
        int id;

        while (true) {
            System.out.println("Ingrese el ID de la persona que desea eliminar:");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                break;
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next();
            }
        }

        ani.delete(id);
        System.out.println("Persona eliminada correctamente.");
    }

    /**
     * Inicia el proceso de adopción. Muestra la lista de animales y personas disponibles y permite al usuario
     * seleccionar el animal y la persona que llevará a cabo la adopción. Valida las entradas para asegurarse
     * de que son números enteros.
     */
    public static void AgregarAdopciones() {
        animalesImpl ani = new animalesImpl();
        personaImpl per = new personaImpl();
        System.out.println("Este es el sistema de adopciones");
        System.out.println("--------------------------------------------------");
        System.out.println(ani.findAll());
        int id_animal;

        while (true) {
            System.out.println("Elija la id del animal que desea adoptar:");
            if (scanner.hasNextInt()) {
                id_animal = scanner.nextInt();
                break;
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next();
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println(per.findAll());
        int id_persona;

        while (true) {
            System.out.println("Elija la id de la persona que desea adoptar:");
            if (scanner.hasNextInt()) {
                id_persona = scanner.nextInt();
                break;
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next();
            }
        }

        ani.adopt(id_animal, id_persona);
        System.out.println("Animal adoptado correctamente.");
    }

    /**
     * Muestra una lista de todas las adopciones realizadas, mostrando la información de los animales
     * que han sido adoptados.
     */
    public static void VerAdopciones() {
        animalesImpl ani = new animalesImpl();
        System.out.println("--------------------------------------------------");
        System.out.println(ani.adoptados());
    }

}
