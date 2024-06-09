package controllers;

import models.Paciente;
import models.Reporte;
import models.ReporteTipo;

import java.util.Date;
import java.util.List;

public class ReportesController {

    public Reporte generarReporte(Paciente paciente, ReporteTipo tipoReporte) {
        String datos = generarDatosReporte(paciente, tipoReporte);
        Reporte reporte = new Reporte(null, paciente.getId(), tipoReporte, datos, new Date());
        paciente.getHistorialReportes().add(reporte);
        return reporte;
    }

    private String generarDatosReporte(Paciente paciente, ReporteTipo tipoReporte) {
        // Implementación de la lógica para generar datos de reporte según el tipo
        // Por simplicidad, se retorna un ejemplo de datos en formato JSON
        return "[{\"tipo\": \"" + tipoReporte + "\", \"fecha\": \"" + new Date() + "\", \"valor\": 100}]";
    }

    public List<Reporte> obtenerHistorialReportes(Paciente paciente) {
        return paciente.getHistorialReportes();
    }

    public List<ReporteTipo> listarTiposDeReportes() {
        return Reporte.listarTipoDeReportes();
    }
}
