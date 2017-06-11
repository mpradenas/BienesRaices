package Entities;

import java.io.Serializable;

public class Proyecto implements Serializable {


    private int tipoProyecto;
    private String nombreProyecto;
    private double dimensiones;
    private double valorUF;
    private double valorNeto;
    private double descuentosBco;
    private double desctoEnVerde;
    private double valorTotal;


    public int getTipoProyecto() {

        return tipoProyecto;
    }

    public void setTipoProyecto(int tipoProyecto) {

        this.tipoProyecto = tipoProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public double getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(double dimensiones) {
        this.dimensiones = dimensiones;
    }

    public double getValorUF() {
        return valorUF;
    }

    public void setValorUF(double valorUF) {
        this.valorUF = valorUF;
    }

    public double getValorNeto() {
        return valorNeto;
    }

    public void setValorNeto(double valorNeto) {
        this.valorNeto = valorNeto;
    }

    public double getDescuentosBco() {
        return descuentosBco;
    }

    public void setDescuentosBco(double descuentosBco) {
        this.descuentosBco = descuentosBco;
    }

    public double getDesctoEnVerde() {
        return desctoEnVerde;
    }

    public void setDesctoEnVerde(double desctoEnVerde) {
        this.desctoEnVerde = desctoEnVerde;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
