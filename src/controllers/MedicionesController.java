package controllers;

import exceptions.GlucoForecastException;
import models.Medicion;
import models.Paciente;

import java.time.LocalDateTime;


public class MedicionesController {

    public void registrarGlucemia(Paciente paciente, double glucemia, String notas, String tags) throws GlucoForecastException {
        if (glucemia < 30 || glucemia > 600) {
            throw new GlucoForecastException("Valor de glucemia fuera de rango.");
        }

        Medicion medicion = new Medicion(null, paciente.getId(), LocalDateTime.now(), glucemia, 0, 0, 0, "", 0, notas, tags);
        paciente.registrarMedicion(medicion);

        // Llamada al controlador de HbA1c para calcular la nueva estimación
        HbA1cController controladorHbA1c = new HbA1cController();
        controladorHbA1c.calcularHbA1c(paciente);
    }

    public void registrarCarbohidratos(Paciente paciente, double carbohidratos, String descripcionComida) throws GlucoForecastException {
        if (carbohidratos < 0) {
            throw new GlucoForecastException("Cantidad de carbohidratos no puede ser negativa.");
        }

        Medicion medicion = new Medicion(null, paciente.getId(), LocalDateTime.now(), 0, carbohidratos, 0, 0, descripcionComida, 0, "", "");
        paciente.registrarMedicion(medicion);
    }

    public void registrarInsulina(Paciente paciente, double insulinaComida, double insulinaCorreccion, double insulinaLenta) throws GlucoForecastException {
        if (insulinaComida < 0 || insulinaCorreccion < 0 || insulinaLenta < 0) {
            throw new GlucoForecastException("Dosis de insulina no puede ser negativa.");
        }

        Medicion medicion = new Medicion(null, paciente.getId(), LocalDateTime.now(), 0, 0, insulinaComida, insulinaCorreccion, "", insulinaLenta, "", "");
        paciente.registrarMedicion(medicion);
    }
}
