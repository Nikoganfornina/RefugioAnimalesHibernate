package org.example.Gestion;

import org.example.DAO.animalesImpl;
import org.example.entities.Animales;

import java.util.Scanner;

public class GestionApp {
    static Scanner scanner = new Scanner(System.in);

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

    public static void GestionarAnimales(Scanner scanner) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú Gestión de Animales");
            System.out.println("¿Qué desea hacer hoy?");
            System.out.println("1. Agregar animales");
            System.out.println("2. Ver animales");
            System.out.println("3. Eliminar animales");
            System.out.println("4. Salir");
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
                        break;
                    case 2:
                        System.out.println("Ver personas");
                        break;
                    case 3:
                        System.out.println("Eliminar personas");
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
                        break;
                    case 2:
                        System.out.println("Ver adopciones");
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

    public static void AgregarAnimales() {
        animalesImpl ani = new animalesImpl();
        Scanner scanner = new Scanner(System.in);

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

        // Validar edad
        int edad;
        while (true) {
            System.out.println("Ingrese la edad del animal (número entero positivo):");
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

        Animales.EstadoAnimal e = null;
        while (true) {
            System.out.println("Elija el estado del animal:");
            System.out.println("1. Recien Abandonado");
            System.out.println("2. Con tiempo en el refugio");
            System.out.println("3. Proximamente en adopcion");
            if (scanner.hasNextInt()) {
                int estado = scanner.nextInt();
                scanner.nextLine();
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


        ani.save(new Animales(null, nombre, especie, edad, descripcion, e, null));
        System.out.println("Animal agregado correctamente.");
    }

    public static void verAnimales() {
        System.out.println("Esta es la lista completa de los animales del refugio");
        System.out.println("--------------------------------------------------");
        animalesImpl ani = new animalesImpl();
        System.out.println(ani.findAll());
    }

    public static void EliminarAnimales() {
        animalesImpl ani = new animalesImpl();
        System.out.println("Esta es la lista de animales");
        System.out.println("--------------------------------------------------");
        System.out.println(ani.findAll());
        System.out.println("Ingrese el ID del animal que desea eliminar:");
        int id = scanner.nextInt();
        ani.delete(id);
        System.out.println("Animal eliminado correctamente.");
    }
}
