package com.ecommerce.model;

/**
 * Representa um produto da plataforma e-commerce
 */
public class Produkt {

    private int id;
    private String name;
    private double preis;
    private int lagerbestand;
    private String kategorie;

    public Produkt() {
    }

    public Produkt(int id, String name, double preis, int lagerbestand, String kategorie) {
        this.id = id;
        this.name = name;
        this.preis = preis;
        this.lagerbestand = lagerbestand;
        this.kategorie = kategorie;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public int getLagerbestand() {
        return lagerbestand;
    }

    public void setLagerbestand(int lagerbestand) {
        this.lagerbestand = lagerbestand;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }
}