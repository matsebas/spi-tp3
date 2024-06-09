package models;

import java.util.Date;

public class Medicion {
    private Long id;
    private Long pacienteId;
    private Date fechaHora;
    private double glucemia;
    private double carbohidratos;
    private double insulinaComida;
    private double insulinaCorreccion;
    private String descripcionComida;
    private double insulinaLenta;
    private String notas;
    private String tags;

    public Medicion(Long id, Long pacienteId, Date fechaHora, double glucemia, double carbohidratos, double insulinaComida, double insulinaCorreccion, String descripcionComida, double insulinaLenta, String notas, String tags) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.fechaHora = fechaHora;
        this.glucemia = glucemia;
        this.carbohidratos = carbohidratos;
        this.insulinaComida = insulinaComida;
        this.insulinaCorreccion = insulinaCorreccion;
        this.descripcionComida = descripcionComida;
        this.insulinaLenta = insulinaLenta;
        this.notas = notas;
        this.tags = tags;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public double getGlucemia() {
        return glucemia;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public double getInsulinaComida() {
        return insulinaComida;
    }

    public double getInsulinaCorreccion() {
        return insulinaCorreccion;
    }

    public String getDescripcionComida() {
        return descripcionComida;
    }

    public double getInsulinaLenta() {
        return insulinaLenta;
    }

    public String getNotas() {
        return notas;
    }

    public String getTags() {
        return tags;
    }
}
