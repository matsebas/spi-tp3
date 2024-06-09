package models;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase que representa el reporte de HbA1c historico para un paciente
 */
public class ReporteHbA1cHistorico extends Reporte {

    public ReporteHbA1cHistorico(Long id, Long pacienteId, String datos, LocalDate fechaGeneracion) {
        super(id, pacienteId, ReporteTipo.HB1AC_HISTORICO, datos, fechaGeneracion);
    }

    /**
     * Genera una cadena con formato JSON que representa las estimaciones históricas de HbA1c para un paciente dado.
     *
     * @param paciente @{@link Paciente} al que se le generará el reporte
     * @return Reporte generado
     */

    @Override
    public String generarDatosReporte(Paciente paciente) {
        List<EstimacionGlicosilada> estimaciones = paciente.getHistorialEstimaciones();
        StringBuilder datos = new StringBuilder("[");
        for (EstimacionGlicosilada estimacion : estimaciones) {
            datos.append(String.format("{\"fecha\": \"%s\", \"valor\": %.2f},", estimacion.getFechaCalculo(), estimacion.getValorCalculado()));
        }
        if (datos.length() > 1) {
            datos.deleteCharAt(datos.length() - 1);
        }
        datos.append("]");
        return datos.toString();
    }
}
