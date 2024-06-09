package models;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que representa el reporte de promedios de glucemia para un paciente
 */
public class ReportePromediosGlucemia extends Reporte {

    public ReportePromediosGlucemia(Long id, Long pacienteId, String datos, LocalDate fechaGeneracion) {
        super(id, pacienteId, ReporteTipo.PROMEDIOS_GLUCEMIA, datos, fechaGeneracion);
    }

    @Override
    public String generarDatosReporte(Paciente paciente) {
        List<Medicion> mediciones = paciente.getHistorialMediciones();
        return mediciones.stream()
                .collect(Collectors.groupingBy(m -> m.getFechaHora().getHour(),
                        Collectors.averagingDouble(Medicion::getGlucemia)))
                .entrySet().stream()
                .map(entry -> String.format("{\"hora\": %d, \"promedio\": %.2f}", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(",", "[", "]"));
    }
}
