package com.teamorange.fipapi.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_VEICULO")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String ano;

    private String diaDoRodizio;

    private Boolean rodizioAtivo;

    private String valor;

    private String anoTipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Veiculo() {
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(id, veiculo.id) &&
                Objects.equals(marca, veiculo.marca) &&
                Objects.equals(modelo, veiculo.modelo) &&
                Objects.equals(ano, veiculo.ano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marca, modelo, ano);
    }
}
