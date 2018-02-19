package com.company;

import java.time.LocalDate;

public class Records {

    private String name;
    private int absences;
    private LocalDate date;

    /**
     @param n
     @param abs
     @param d

     */

    public Records(String n, int abs, LocalDate d){
        name = n;
        absences = abs;
        date = d;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setName(String n){
        n = "Xavier";
    }

    public void setAbsences(int abs) {
        abs = absences;
    }

    public void setDate(LocalDate d){
        d = date.minusDays(10);
    }

    public void changeabs(int abs){

    }

}

