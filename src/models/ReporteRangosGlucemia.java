package models;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase que representa el reporte de rangos de glucemia para un paciente
 */
public class ReporteRangosGlucemia extends Reporte {

    public ReporteRangosGlucemia(Long id, Long pacienteId, String datos, LocalDate fechaGeneracion) {
        super(id, pacienteId, ReporteTipo.RANGOS_GLUCEMIA, datos, fechaGeneracion);
    }

    /**
     * Calcula la distribución de los niveles de glucosa de las mediciones históricas de un paciente en diferentes rangos.
     * Cuenta el número de mediciones dentro de rangos específicos de glucosa (por ejemplo, normal, alto, hiperglucemia,
     * hipoglucemia) y devuelve el porcentaje de mediciones que caen en cada rango como una cadena formateada.
     *
     * @param paciente @{@link Paciente} al que se le generará el reporte
     * @return Reporte generado
     */
    @Override
    public String generarDatosReporte(Paciente paciente) {
        List<Medicion> mediciones = paciente.getHistorialMediciones();
        int totalMediciones = mediciones.size();
        int enRango = 0, alto = 0, hiperglucemias = 0, hipoglucemias = 0;

        for (Medicion medicion : mediciones) {
            double glucemia = medicion.getGlucemia();
            if (glucemia >= 70.0 && glucemia <= 140.0) {
                enRango++;
            } else if (glucemia >= 160.0 && glucemia <= 180.0) {
                alto++;
            } else if (glucemia > 180.0) {
                hiperglucemias++;
            } else if (glucemia < 70.0) {
                hipoglucemias++;
            }
        }

        return String.format("{\"hipoglucemias\": %.2f, \"enRango\": %.2f, \"alto\": %.2f, \"hiperglucemias\": %.2f}",
                (hipoglucemias / (double) totalMediciones) * 100.0,
                (enRango / (double) totalMediciones) * 100.0,
                (alto / (double) totalMediciones) * 100.0,
                (hiperglucemias / (double) totalMediciones) * 100.0);
    }
}
