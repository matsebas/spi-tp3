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
        // Implementación del algoritmo de cálculo de HbA1c
        // Por simplicidad, este es un ejemplo básico y no el cálculo real
        double totalGlucemia = mediciones.stream().mapToDouble(Medicion::getGlucemia).sum();
        return totalGlucemia / mediciones.size();
    }
}
