package org.example.Gestion;

import java.util.Scanner;

public class GestionApp {

    public static void InicioPrograma() {
        Scanner scanner = new Scanner(System.in);
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
                        break;
                    case 2:
                        System.out.println("Ver animales");
                        break;
                    case 3:
                        System.out.println("Eliminar animales");
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
}
