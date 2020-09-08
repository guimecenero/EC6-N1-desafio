package VO;
import Enums.*;

public class RoupaVO {
    private int id;
    private String dataEntrada;
    private String localCompra;
    private String tipo;
    private String marca;
    private String descricaoPeca;
    private TamanhoRoupa tamanho;
    private CoresRoupa cor;
    private double valorEtiqueta;
    private double ValorPago;
    private double precoSugerido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataEntrada() { return dataEntrada; }

        public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getLocalCompra() {
        return localCompra;
    }

    public void setLocalCompra(String localCompra) {
        this.localCompra = localCompra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo (String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricaoPeca() {
        return descricaoPeca;
    }

    public void setDescricaoPeca(String descricaoPeca) {
        this.descricaoPeca = descricaoPeca;
    }

    public TamanhoRoupa getTamanho() {
        return tamanho;
    }

    public void setTamanho(TamanhoRoupa tamanho) {
        this.tamanho = tamanho;
    }

    public CoresRoupa getCor() {
        return cor;
    }

    public void setCor(CoresRoupa cor) {
        this.cor = cor;
    }

    public double getValorEtiqueta() {
        return valorEtiqueta;
    }

    public void setValorEtiqueta(double valorEtiqueta) {
        this.valorEtiqueta = valorEtiqueta;
    }

    public double getValorPago() {
        return ValorPago;
    }

    public void setValorPago(double valorPago) {
        ValorPago = valorPago;
    }

    public double getValorMargem100porcento() {
        return getValorPago() * 2;
    }

    public double getPrecoSugerido() {
        return precoSugerido;
    }

    public void setPrecoSugerido(double precoSugerido) {
        this.precoSugerido = precoSugerido;
    }
}
