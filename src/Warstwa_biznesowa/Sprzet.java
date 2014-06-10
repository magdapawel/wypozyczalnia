/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Warstwa_biznesowa;
public class Sprzet
{ 
private int numer;
private Sprzet_dane mSprzet_dane;

public Sprzet() { }

public int getNumer() { return numer;}
public void setNumer(int _numer) { numer = _numer; }

public Sprzet_dane getSprzet_dane() { return mSprzet_dane;}
public void setSprzet_dane(Sprzet_dane val) { mSprzet_dane = val; }

public boolean equals(Object ob)
{ return numer==((Sprzet)ob).getNumer(); }

public String toString()
{ 
    String pom= mSprzet_dane.toString();
    pom+=" Numer: "+getNumer();
    return pom;
}
}
