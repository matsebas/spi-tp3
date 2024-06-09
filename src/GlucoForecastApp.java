package app;

import models.Paciente;
import views.RegistroDatosView;
import views.VisualizacionDatosView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GlucoForecastApp {

    private final RegistroDatosView registroDatosView;
    private final VisualizacionDatosView visualizacionDatosView;
    private final List<Paciente> pacientes;
    private Paciente pacienteSeleccionado;

    public GlucoForecastApp() {
        this.registroDatosView = new RegistroDatosView();
        this.visualizacionDatosView = new VisualizacionDatosView();
        this.pacientes = new ArrayList<>();
        inicializarPacientes();
    }

    private void inicializarPacientes() {
        pacientes.add(new Paciente(1L, "Lionel", "Messi", "lionel.messi@gmail.com", "123456789", new Date(), 35.5, new Date()));
        pacientes.add(new Paciente(2L, "Angel", "Di Maria", "angel.dimaria@gmail.com", "234567890", new Date(), 40.0, new Date()));
        pacientes.add(new Paciente(3L, "Emiliano", "Martinez", "emiliano.martinez@gmail.com", "345678901", new Date(), 45.0, new Date()));
        pacientes.add(new Paciente(4L, "Rodrigo", "De Paul", "rodrigo.depaul@gmail.com", "456789012", new Date(), 50.5, new Date()));
        pacientes.add(new Paciente(5L, "Julian", "Alvarez", "julian.alvarez@gmail.com", "567890123", new Date(), 30.0, new Date()));
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione un paciente:");
            for (int i = 0; i < pacientes.size(); i++) {
                System.out.println((i + 1) + ". " + pacientes.get(i).getNombre() + " " + pacientes.get(i).getApellido());
            }
            System.out.println((pacientes.size() + 1) + ". Salir");

            int seleccionPaciente = scanner.nextInt();
            if (seleccionPaciente > 0 && seleccionPaciente <= pacientes.size()) {
                pacienteSeleccionado = pacientes.get(seleccionPaciente - 1);
                mostrarMenuPrincipal();
            } else if (seleccionPaciente == pacientes.size() + 1) {
                salir = true;
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    private void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Paciente seleccionado: " + pacienteSeleccionado.getNombre() + " " + pacienteSeleccionado.getApellido());
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar datos");
            System.out.println("2. Visualizar resultado de HbA1c");
            System.out.println("3. Volver al menú de selección de paciente");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    registroDatosView.registrarDatos(pacienteSeleccionado);
                    break;
                case 2:
                    visualizacionDatosView.visualizarResultadoHbA1c(pacienteSeleccionado);
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static void main(String[] args) {
        GlucoForecastApp app = new GlucoForecastApp();
        app.iniciar();
    }
}
