/**
 * @Alumno: Matias Sebastiao
 * @DNI: 31070095
 * @Legajo: VINF011605
 */

import controllers.MedicionesController;
import exceptions.GlucoForecastException;
import models.Paciente;
import utils.UtilColores;
import views.RegistroDatosView;
import views.VisualizacionDatosView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal de la aplicación GlucoForecast.
 */
public class GlucoForecastApp {

    private final RegistroDatosView registroDatosView;
    private final VisualizacionDatosView visualizacionDatosView;
    private final List<Paciente> pacientes;
    private final MedicionesController medicionesController;
    private Paciente pacienteSeleccionado;

    public GlucoForecastApp() {
        this.registroDatosView = new RegistroDatosView();
        this.visualizacionDatosView = new VisualizacionDatosView();
        this.pacientes = new ArrayList<>();
        this.medicionesController = new MedicionesController();
        setupDatosDemo();
    }

    private void setupDatosDemo() {
        Paciente paciente1 = new Paciente(1L, "Lionel", "Messi", "lionel.messi@gmail.com", "123456789", LocalDate.of(1986, 5, 24), 35.5, LocalDate.now());
        Paciente paciente2 = new Paciente(2L, "Angel", "Di Maria", "angel.dimaria@gmail.com", "234567890", LocalDate.of(1987, 6, 25), 40.0, LocalDate.now());
        Paciente paciente3 = new Paciente(3L, "Emiliano", "Martinez", "emiliano.martinez@gmail.com", "345678901", LocalDate.of(1988, 7, 26), 45.0, LocalDate.now());
        Paciente paciente4 = new Paciente(4L, "Rodrigo", "De Paul", "rodrigo.depaul@gmail.com", "456789012", LocalDate.of(1989, 8, 27), 50.5, LocalDate.now());
        Paciente paciente5 = new Paciente(5L, "Julian", "Alvarez", "julian.alvarez@gmail.com", "567890123", LocalDate.of(1990, 9, 28), 30.0, LocalDate.now());

        agregarDatosDemoMediciones(paciente1, 7);
        agregarDatosDemoMediciones(paciente2, 6);
        agregarDatosDemoMediciones(paciente3, 5);
        agregarDatosDemoMediciones(paciente4, 2);
        agregarDatosDemoMediciones(paciente5, 2);

        pacientes.add(paciente1);
        pacientes.add(paciente2);
        pacientes.add(paciente3);
        pacientes.add(paciente4);
        pacientes.add(paciente5);
    }

    private void agregarDatosDemoMediciones(Paciente paciente, int cantidadMediciones) {
        for (int i = 0; i < cantidadMediciones; i++) {
            double glucemia = (i % 2 == 0) ? 100 + (i * 10) : 60 + (i * 20);
            double carbohidratos = 30 + (i * 5);
            double insulinaComida = 2 + (i * 0.5);
            double insulinaCorreccion = 1 + (i * 0.3);
            double insulinaLenta = 1.5 + (i * 0.4);
            String descripcion = "Descripción " + (i + 1);
            String tags = "Tag" + (i + 1);

            try {
                medicionesController.registrarGlucemia(paciente, glucemia, descripcion, tags);
                medicionesController.registrarCarbohidratos(paciente, carbohidratos, descripcion);
                medicionesController.registrarInsulina(paciente, insulinaComida, insulinaCorreccion, insulinaLenta);
            } catch (GlucoForecastException e) {
                System.err.println(UtilColores.RED_BOLD_BRIGHT + "Error registrando medición: " + e.getMessage() + UtilColores.RESET);
            }
        }
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println(UtilColores.BLUE_BOLD_BRIGHT + "================ LISTADO DE PACIENTES ================" + UtilColores.RESET);
            System.out.println(UtilColores.WHITE_BOLD_BRIGHT + "> SELECCIONE UN PACIENTE:" + UtilColores.RESET);
            System.out.println("-------------------------");
            for (int i = 0; i < pacientes.size(); i++) {
                System.out.println(UtilColores.GREEN_BOLD_BRIGHT + "[" + (i + 1) + "] " + pacientes.get(i).getNombre() + " " + pacientes.get(i).getApellido() + UtilColores.RESET);
            }
            System.out.println("[" + (pacientes.size() + 1) + "] SALIR");
            System.out.println(UtilColores.BLUE_BOLD_BRIGHT + "======================================================" + UtilColores.RESET);

            int seleccionPaciente = scanner.nextInt();
            if (seleccionPaciente > 0 && seleccionPaciente <= pacientes.size()) {
                pacienteSeleccionado = pacientes.get(seleccionPaciente - 1);
                mostrarMenuPrincipal();
            } else if (seleccionPaciente == pacientes.size() + 1) {
                salir = true;
            } else {
                System.out.println(UtilColores.RED_BOLD_BRIGHT + "Opción no válida. Intente nuevamente." + UtilColores.RESET);
            }
        }
        scanner.close();
    }

    private void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println(UtilColores.BLUE_BOLD_BRIGHT + "=================== MENU PRINCIPAL ===================" + UtilColores.RESET);
            System.out.println(UtilColores.GREEN_BOLD_BRIGHT + "PACIENTE SELECCIONADO: " + UtilColores.YELLOW_BOLD_BRIGHT + pacienteSeleccionado.getNombre() + " " + pacienteSeleccionado.getApellido() + UtilColores.RESET);
            System.out.println("------------------------------------------------------");
            System.out.println(UtilColores.WHITE_BOLD_BRIGHT + "> SELECCIONE UNA OPCIÓN:" + UtilColores.RESET);
            System.out.println("------------------------");
            System.out.println(UtilColores.GREEN_BOLD_BRIGHT + "[1] Registrar datos" + UtilColores.RESET);
            System.out.println(UtilColores.GREEN_BOLD_BRIGHT + "[2] Visualizar resultado de HbA1c" + UtilColores.RESET);
            System.out.println(UtilColores.GREEN_BOLD_BRIGHT + "[3] Generar Reportes" + UtilColores.RESET);
            System.out.println("[4] Volver al menú de selección de paciente");
            System.out.println(UtilColores.BLUE_BOLD_BRIGHT + "======================================================" + UtilColores.RESET);

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    registroDatosView.registrarDatos(pacienteSeleccionado);
                    break;
                case 2:
                    visualizacionDatosView.visualizarResultadoHbA1c(pacienteSeleccionado);
                    break;
                case 3:
                    visualizacionDatosView.visualizarReporte(pacienteSeleccionado);
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println(UtilColores.RED_BOLD_BRIGHT + "Opción no válida. Intente nuevamente." + UtilColores.RESET);
            }
        }
    }

    public static void main(String[] args) {
        GlucoForecastApp app = new GlucoForecastApp();
        app.iniciar();
    }
}
