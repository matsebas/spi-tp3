package controllers;

import models.*;

import java.time.LocalDate;

public class ReportesController {

    public Reporte generarReporte(Paciente paciente, ReporteTipo tipoReporte) {
        Reporte reporte;
        switch (tipoReporte) {
            case RANGOS_GLUCEMIA:
                reporte = new ReporteRangosGlucemia(null, paciente.getId(), null, LocalDate.now());
                break;
            case HB1AC_HISTORICO:
                reporte = new ReporteHbA1cHistorico(null, paciente.getId(), null, LocalDate.now());
                break;
            case PROMEDIOS_GLUCEMIA:
                reporte = new ReportePromediosGlucemia(null, paciente.getId(), null, LocalDate.now());
                break;
            default:
                System.out.println("Reporte No implementado o no disponible.");
                return null;
        }
        String datos = reporte.generarDatosReporte(paciente);
        reporte.setDatos(datos);
        return reporte;
    }

    public void mostrarReporte(Reporte reporte) {
        if (reporte != null) {
            System.out.println("Reporte: " + reporte.getTipoReporte());
            System.out.println("Datos: " + reporte.getDatos());
        }
    }
}
