package models;

import java.util.Date;
import java.util.List;

public class Reporte {
    private Long id;
    private Long pacienteId;
    private ReporteTipo tipoReporte;
    private String datos;
    private Date fechaGeneracion;

    public Reporte(ReporteTipo tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public Reporte(Long id, Long pacienteId, ReporteTipo tipoReporte, String datos, Date fechaGeneracion) {
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

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public String generar(ReporteTipo tipoReporte) {
        // Implementación de la generación del reporte
        return "Reporte generado para el tipo: " + tipoReporte;
    }

    public static List<ReporteTipo> listarTipoDeReportes() {
        return List.of(ReporteTipo.values());
    }
}
