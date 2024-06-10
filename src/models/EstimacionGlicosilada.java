package models;

import java.util.Date;
import java.util.List;

public class EstimacionGlicosilada {
    private Long id;
    private Long pacienteId;
    private double valorCalculado;
    private Date fechaCalculo;

    public EstimacionGlicosilada(Long id, Long pacienteId, double valorCalculado, Date fechaCalculo) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.valorCalculado = valorCalculado;
        this.fechaCalculo = fechaCalculo;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public double getValorCalculado() {
        return valorCalculado;
    }

    public Date getFechaCalculo() {
        return fechaCalculo;
    }

    public static double calcularEstimacion(List<Medicion> mediciones) {
        double promedioGlucemia = mediciones.stream().mapToDouble(Medicion::getGlucemia).average().orElse(0.0);
        return (promedioGlucemia + 46.7) / 28.7;
    }
}
