package models;

public abstract class Usuario {

    public static final String DEMO_USER_PACIENTE = "paciente";
    public static final String DEMO_PASS_PACIENTE = "paciente";

    public static final String DEMO_USER_CUIDADOR = "cuidador";
    public static final String DEMO_PASS_CUIDADOR = "cuidador";

    public static final String DEMO_USER_MEDICO = "medico";
    public static final String DEMO_PASS_MEDICO = "medico";

    private final Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public Usuario(Long id, String nombre, String apellido, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public abstract boolean autenticar(String usuario, String clave);
}
