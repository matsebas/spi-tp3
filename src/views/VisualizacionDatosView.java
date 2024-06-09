package views;

import controllers.HbA1cController;
import exceptions.GlucoForecastException;
import models.Paciente;

public class VisualizacionDatosView {

    private final HbA1cController hba1cController;

    public VisualizacionDatosView() {
        this.hba1cController = new HbA1cController();
    }

    public void visualizarResultadoHbA1c(Paciente paciente) {
        try {
            double resultadoHbA1c = hba1cController.obtenerUltimaEstimacionHbA1c(paciente);
            System.out.println("HbA1c estimada: " + resultadoHbA1c + "%");
        } catch (GlucoForecastException e) {
            System.err.println(e.getMessage());
        }
    }
}
