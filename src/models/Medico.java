package models;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Usuario {
    private String institucion;
    private List<Paciente> pacientes;

    public Medico(Long id, String nombre, String apellido, String email, String telefono, String institucion) {
        super(id, nombre, apellido, email, telefono);
        this.institucion = institucion;
        this.pacientes = new ArrayList<>();
    }

    // Getters y setters
    public String getInstitucion() {
        return institucion;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Paciente accederDatosPaciente(Long pacienteId) {
        return pacientes.stream().filter(p -> p.getId().equals(pacienteId)).findFirst().orElse(null);
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
     * coinciden con el usuario y la contraseña de un {@link Medico}
     *
     * @param usuario el nombre de usuario a autenticar
     * @param clave   la contraseña a autenticar
     * @return true si el nombre de usuario y la contraseña coinciden con el usuario y la contraseña de demostración,
     * false en caso contrario
     */
    @Override
    public boolean autenticar(String usuario, String clave) {
        return DEMO_USER_MEDICO.equalsIgnoreCase(usuario) && DEMO_PASS_MEDICO.equalsIgnoreCase(clave);
    }
}
