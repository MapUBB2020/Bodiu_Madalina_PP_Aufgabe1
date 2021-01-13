package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Kosten {
    public enum Kategorie {
        FOOD,
        ACCOMODATION,
        UNI,
        TRANSPORT
    }

    private String name;
    private Kategorie kategorie;
    private float preis;
    private float menge;
    private LocalDate datum;

    public Kosten(String name, String kategorie, String preis, String menge, String datum) {
        this.name = name;
        this.kategorie=Kategorie.valueOf(kategorie);
        this.preis = Float.parseFloat(preis);
        this.menge = Float.parseFloat(menge);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.datum = LocalDate.parse(datum, format);
    }

    public String getName() {
        return name;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public float getPreis() {
        return preis;
    }

    public float getMenge() {
        return menge;
    }

    public LocalDate getDatum() {
        return datum;
    }
}
