package controllers;

import exceptions.GlucoForecastException;
import models.EstimacionGlicosilada;
import models.Medicion;
import models.Paciente;

import java.util.Date;
import java.util.List;

public class HbA1cController {

    public boolean calcularHbA1c(Paciente paciente) {
        List<Medicion> mediciones = paciente.getHistorialMediciones();

        if (!enoughData(mediciones)) {
            return false;
        }

        double estimacionHbA1c = EstimacionGlicosilada.calcularEstimacion(mediciones);
        EstimacionGlicosilada estimacion = new EstimacionGlicosilada(null, paciente.getId(), estimacionHbA1c, new Date());
        paciente.getHistorialEstimaciones().add(estimacion);
        return true;
    }

    public double obtenerUltimaEstimacionHbA1c(Paciente paciente) throws GlucoForecastException {
        List<EstimacionGlicosilada> historialEstimaciones = paciente.getHistorialEstimaciones();
        if (historialEstimaciones.isEmpty()) {
            throw new GlucoForecastException("No hay suficientes datos para calcular la estimación de HbA1c.");
        }

        EstimacionGlicosilada ultimaEstimacion = historialEstimaciones.get(historialEstimaciones.size() - 1);
        return ultimaEstimacion.getValorCalculado();
    }

    private boolean enoughData(List<Medicion> mediciones) {
        return mediciones.size() >= 3;
    }
}
