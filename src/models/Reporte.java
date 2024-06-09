package models;

import java.time.LocalDate;
import java.util.List;

public abstract class Reporte {
    private Long id;
    private Long pacienteId;
    private final ReporteTipo tipoReporte;
    private String datos;
    private LocalDate fechaGeneracion;

    public Reporte(ReporteTipo tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public Reporte(Long id, Long pacienteId, ReporteTipo tipoReporte, String datos, LocalDate fechaGeneracion) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.tipoReporte = tipoReporte;
        this.datos = datos;
        this.fechaGeneracion = fechaGeneracion;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public ReporteTipo getTipoReporte() {
        return tipoReporte;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    /**
     * Método abstracto para generar los datos del reporte.
     * Cada subclase debe implementar este método dependiendo del tipo de reporte que se requiera generar
     *
     * @param paciente @{@link Paciente} al que se le generará el reporte
     * @return Reporte generado
     */
    public abstract String generarDatosReporte(Paciente paciente);

    /**
     * Retorna una lista de los tipos de reportes habilitados.
     *
     * @return Lista de @{@link ReporteTipo} habilitados
     */
    public static List<ReporteTipo> reportesHabilitados() {
        return List.of(ReporteTipo.HB1AC_HISTORICO, ReporteTipo.PROMEDIOS_GLUCEMIA, ReporteTipo.RANGOS_GLUCEMIA);
    }
}
