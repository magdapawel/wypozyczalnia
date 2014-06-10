/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warstwa_biznesowa;

import java.util.*;
import java.util.ArrayList;

public class Fasada {
    private Sprzet_dane sprzet_dane;
    private ArrayList<Sprzet_dane> sprzet_lista = new ArrayList<Sprzet_dane>();

    public Fasada() {
    }

    public ArrayList<Sprzet_dane> getSprzet_dane() {
        return sprzet_lista;
    }

    public void dodaj_sprzet_dane(String dane_sprzet[]) {
        sprzet_dane = new Sprzet_dane();
        sprzet_dane.setRodzaj(dane_sprzet[0]);
        sprzet_dane.setModel(dane_sprzet[1]);
        sprzet_dane.setMarka(dane_sprzet[2]);
        sprzet_dane.setID(dane_sprzet[3]);
        sprzet_dane.setStan(dane_sprzet[4]);
        sprawdz_czy_jest(sprzet_dane);
    }

    public void sprawdz_czy_jest(Sprzet_dane val) {
        boolean czy_jest = sprzet_lista.contains(val);
        if (!czy_jest) {
            sprzet_lista.add(val);
        }
    }

    public void dodaj_sprzet(String dane[]) {
        Sprzet_dane pom = new Sprzet_dane();
        pom.setID(dane[0]);
        int idx = sprzet_lista.indexOf(pom);
        if (idx != -1) {
            Sprzet_dane pom1 = sprzet_lista.get(idx);
            pom1.dodaj_sprzet(dane);
            System.out.println(pom1.getSprzet().toString());
        }//linia tymczasowa
    }

    public void setSprzet_dane(ArrayList<Sprzet_dane> val) {
        this.sprzet_lista = val;
    }

    public ArrayList<String> sprzet_dane() {
        ArrayList<String> sprzet_dane_fasada = new ArrayList<String>();
        Iterator<Sprzet_dane> it = sprzet_lista.iterator();
        while (it.hasNext()) {
            sprzet_dane_fasada.add(it.next().toString());

        }
        return sprzet_dane_fasada;
    }

    public ArrayList<String> sprzet_fasada() {
        ArrayList<String> sprzet_fasada = new ArrayList<String>();
        Iterator<Sprzet_dane> it = sprzet_lista.iterator();
        while (it.hasNext()) {
            sprzet_fasada.addAll(it.next().sprzet());
        }
        return sprzet_fasada;
    }
}
