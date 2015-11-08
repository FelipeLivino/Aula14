package br.usjt.veiculop2;

import java.io.Serializable;

public class Veiculo implements Comparable<Veiculo>, Serializable{
    private String modelo;
    private String imagem;
    private double kmlivre;
    private String ano;
    private String marca;
    private String categoria;
    public static final String NAO_ENCONTRADO = "Não encontrado.";

    public Veiculo(String ano, String modelo, String marca, String categoria, String imagem, double kmlivre) {
        this.ano = ano;
        this.imagem = imagem;
        this.kmlivre = kmlivre;
        this.modelo = modelo;
        this.marca = marca;
        this.categoria = categoria;
    }

    public String getAno() {
        return ano;
    }

    public String getImagem() {
        return imagem;
    }

    public double getKmlivre() {
        return kmlivre;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "br.usjt.veiculop1.veiculo{" +
                "ano='" + ano + '\'' +
                ", imagem='" + imagem + '\'' +
                ", kmlivre='" + kmlivre + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    @Override
    public int compareTo(Veiculo veiculo) {
        if (modelo.equals(veiculo.getModelo())
                && ano.equals(veiculo.getAno())
                && marca.equals(veiculo.getMarca())
                && categoria.equals(veiculo.getCategoria())) {
            return 0;
        }
        return this.getModelo().compareTo(veiculo.getModelo());
    }
}
