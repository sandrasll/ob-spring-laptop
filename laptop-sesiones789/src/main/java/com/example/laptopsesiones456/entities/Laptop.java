package com.example.laptopsesiones456.entities;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "laptop")
public class Laptop {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String procesador;
    private Integer ram;
    private Double velocprocesador;
    private Integer capacidad;
    private LocalDate fechafabricacion;


    //constructores

    public Laptop() {
    }

    public Laptop(Long id, String marca, String procesador, Integer ram, Double velocprocesador, Integer capacidad, LocalDate fechafabricacion) {
        this.id = id;
        this.marca = marca;
        this.procesador = procesador;
        this.ram = ram;
        this.velocprocesador = velocprocesador;
        this.capacidad = capacidad;
        this.fechafabricacion = fechafabricacion;
    }

    // getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Double getVelocprocesador() {
        return velocprocesador;
    }

    public void setVelocprocesador(Double velocprocesador) {
        this.velocprocesador = velocprocesador;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public LocalDate getFechafabricacion() {
        return fechafabricacion;
    }

    public void setFechafabricacion(LocalDate fechafabricacion) {
        this.fechafabricacion = fechafabricacion;
    }

}
