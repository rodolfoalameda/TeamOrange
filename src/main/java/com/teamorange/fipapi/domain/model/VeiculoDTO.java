package com.teamorange.fipapi.domain.model;

import java.io.Serializable;

public class VeiculoDTO implements Serializable {

    private Long id;
    private String marca;
    private String modelo;
    private String ano;
    private Long idUsuario;
    private String diaDoRodizio;
    private Boolean rodizioAtivo;
    private String valor;
    private String anoTipo;

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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDiaDoRodizio() {
        return diaDoRodizio;
    }

    public void setDiaDoRodizio(String diaDoRodizio) {
        this.diaDoRodizio = diaDoRodizio;
    }

    public Boolean getRodizioAtivo() {
        return rodizioAtivo;
    }

    public void setRodizioAtivo(Boolean rodizioAtivo) {
        this.rodizioAtivo = rodizioAtivo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getAnoTipo() {
        return anoTipo;
    }

    public void setAnoTipo(String anoTipo) {
        this.anoTipo = anoTipo;
    }
}
