package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Usuario {
    private LocalDate fechaNacimiento;
    private double pesoCorporal;
    private LocalDate fechaDiagnostico;

    private List<Medicion> historialMediciones;
    private List<EstimacionGlicosilada> historialEstimaciones;
    private List<Reporte> historialReportes;

    public Paciente(Long id, String nombre, String apellido, String email, String telefono, LocalDate fechaNacimiento,
                    double pesoCorporal, LocalDate fechaDiagnostico) {
        super(id, nombre, apellido, email, telefono);
        this.fechaNacimiento = fechaNacimiento;
        this.pesoCorporal = pesoCorporal;
        this.fechaDiagnostico = fechaDiagnostico;
        this.historialMediciones = new ArrayList<>();
        this.historialEstimaciones = new ArrayList<>();
        this.historialReportes = new ArrayList<>();
    }

    // Getters y setters
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public double getPesoCorporal() {
        return pesoCorporal;
    }

    public LocalDate getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public List<Medicion> getHistorialMediciones() {
        return historialMediciones;
    }

    public List<EstimacionGlicosilada> getHistorialEstimaciones() {
        return historialEstimaciones;
    }

    public List<Reporte> getHistorialReportes() {
        return historialReportes;
    }

    public boolean registrarMedicion(Medicion medicion) {
        return historialMediciones.add(medicion);
    }

    public List<Medicion> revisarHistorial() {
        return historialMediciones;
    }


    /**
     * Sobrescribe el método autenticar para verificar si el nombre de usuario y la contraseña proporcionados
     * coinciden con el usuario y la contraseña de un {@link Paciente}
     *
     * @param usuario el nombre de usuario a autenticar
     * @param clave   la contraseña a autenticar
     * @return true si el nombre de usuario y la contraseña coinciden con el usuario y la contraseña de demostración,
     * false en caso contrario
     */
    @Override
    public boolean autenticar(String usuario, String clave) {
        return DEMO_USER_PACIENTE.equalsIgnoreCase(usuario) && DEMO_PASS_PACIENTE.equalsIgnoreCase(clave);
    }
}
