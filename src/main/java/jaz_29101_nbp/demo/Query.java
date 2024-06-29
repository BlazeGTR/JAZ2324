package jaz_29101_nbp.demo;

import jakarta.persistence.*;
import java.time.LocalDate;

import java.util.Date;

@Entity
@Table(name = "NBP")
public class Query {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String waluta;
    private LocalDate dataStart;
    private LocalDate dataEND;
    private double avg;
    //private int queryTime;

    public Query(String waluta, LocalDate dataStart, LocalDate dataEND, double avg) {
        this.waluta = waluta;
        this.dataStart = dataStart;
        this.dataEND = dataEND;
        this.avg = avg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public LocalDate getDataStart() {
        return dataStart;
    }

    public void setDataStart(LocalDate dataStart) {
        this.dataStart = dataStart;
    }

    public LocalDate getDataEND() {
        return dataEND;
    }

    public void setDataEND(LocalDate dataEND) {
        this.dataEND = dataEND;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

        /*
    public int getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(int queryTime) {
        this.queryTime = queryTime;
    }*/
}
