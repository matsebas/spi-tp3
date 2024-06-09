package views;

import controllers.MedicionesController;
import exceptions.GlucoForecastException;
import models.Paciente;

import java.util.Scanner;

public class RegistroDatosView {

    private final MedicionesController medicionesController;

    public RegistroDatosView() {
        this.medicionesController = new MedicionesController();
    }

    public void registrarDatos(Paciente paciente) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese tipo de dato a registrar:");
        System.out.println("1. Glucemia");
        System.out.println("2. Carbohidratos");
        System.out.println("3. Insulina");
        int tipoDato = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        try {
            switch (tipoDato) {
                case 1:
                    System.out.println("Ingrese valor de glucemia:");
                    double glucemia = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.println("Ingrese descripción:");
                    String descripcionGlucemia = scanner.nextLine();
                    System.out.println("Ingrese tags:");
                    String tagsGlucemia = scanner.nextLine();
                    medicionesController.registrarGlucemia(paciente, glucemia, descripcionGlucemia, tagsGlucemia);
                    System.out.println("Datos de glucemia registrados correctamente.");
                    break;
                case 2:
                    System.out.println("Ingrese cantidad de carbohidratos:");
                    double carbohidratos = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.println("Ingrese descripción:");
                    String descripcionCarbohidratos = scanner.nextLine();
                    medicionesController.registrarCarbohidratos(paciente, carbohidratos, descripcionCarbohidratos);
                    System.out.println("Datos de carbohidratos registrados correctamente.");
                    break;
                case 3:
                    System.out.println("Ingrese dosis de insulina de comida:");
                    double insulinaComida = scanner.nextDouble();
                    System.out.println("Ingrese dosis de insulina de corrección:");
                    double insulinaCorreccion = scanner.nextDouble();
                    System.out.println("Ingrese dosis de insulina lenta:");
                    double insulinaLenta = scanner.nextDouble();
                    medicionesController.registrarInsulina(paciente, insulinaComida, insulinaCorreccion, insulinaLenta);
                    System.out.println("Datos de insulina registrados correctamente.");
                    break;
                default:
                    System.out.println("Tipo de dato no válido.");
            }
        } catch (GlucoForecastException e) {
            System.err.println(e.getMessage());
        }
    }
}
