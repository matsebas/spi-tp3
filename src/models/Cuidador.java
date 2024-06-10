package models;

import java.util.ArrayList;
import java.util.List;

public class Cuidador extends Usuario {
    private final List<Paciente> pacientesACargo;

    public Cuidador(Long id, String nombre, String apellido, String email, String telefono) {
        super(id, nombre, apellido, email, telefono);
        this.pacientesACargo = new ArrayList<>();
    }

    // Getters y setters
    public List<Paciente> getPacientesACargo() {
        return pacientesACargo;
    }

    public void agregarPacienteACargo(Paciente paciente) {
        pacientesACargo.add(paciente);
    }

    public Paciente accederDatosPaciente(Long pacienteId) {
        return pacientesACargo.stream().filter(p -> p.getId().equals(pacienteId)).findFirst().orElse(null);
    }

    public boolean registrarMedicion(Long pacienteId, Medicion medicion) {
        Paciente paciente = accederDatosPaciente(pacienteId);
        if (paciente != null) {
            return paciente.registrarMedicion(medicion);
        }
        return false;
    }

    public List<Medicion> revisarHistorial(Long pacienteId) {
        Paciente paciente = accederDatosPaciente(pacienteId);
        if (paciente != null) {
            return paciente.revisarHistorial();
        }
        return new ArrayList<>();
    }

    /**
     * Sobrescribe el método autenticar para verificar si el nombre de usuario y la contraseña proporcionados
     * coinciden con el usuario y la contraseña de un {@link Cuidador}
     *
     * @param usuario el nombre de usuario a autenticar
     * @param clave   la contraseña a autenticar
     * @return true si el nombre de usuario y la contraseña coinciden con el usuario y la contraseña de demostración,
     * false en caso contrario
     */
    @Override
    public boolean autenticar(String usuario, String clave) {
        return DEMO_USER_CUIDADOR.equalsIgnoreCase(usuario) && DEMO_PASS_CUIDADOR.equalsIgnoreCase(clave);
    }
}
