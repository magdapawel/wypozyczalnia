/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Warstwa_biznesowa;
import java.util.*;
/**
 *
 * @author Magdalena, Paweł
 */
public class Sprzet_dane {
private String rodzaj;
private String marka;
private String model;
private String stan;
private int ilosc;
private int cena_wypozyczenia;
private int cena_fabryczna;
private int cena_kara;
private String id;
private java.util.ArrayList<Sprzet> mSprzet = new java.util.ArrayList<Sprzet>();

public Sprzet_dane() { }

public java.util.ArrayList<Sprzet> getSprzet() {
return mSprzet;
}
public void setSprzet(java.util.ArrayList<Sprzet> val) {
this.mSprzet = val;
}
public String getRodzaj() {return rodzaj; }
public void setRodzaj(String val) {this.rodzaj = val;}

public String getMarka() {return marka; }
public void setMarka(String val) {this.marka = val;}

public String getModel() {return model; }
public void setModel(String val) {this.model = val;}

public String getStan() {return stan; }
public void setStan(String val) {this.stan = val;}

public int getIlosc() {return ilosc; }
public void setIlosc(int val) {this.ilosc = val;}

public int getCena_wypozyczenia () {return cena_wypozyczenia; }
public void setCena_wypozyczenia (int val) {this. cena_wypozyczenia = val;}

public int getCena_fabryczna () {return cena_fabryczna; }
public void setCena_fabryczna (int val) {this. cena_fabryczna = val;}

public int getCena_kara () {return cena_kara; }
public void setCena_kara (int val) {this. cena_kara = val;}

public String getID () {return id; }
public void setID(String val) {this.id = val;}

@Override 
public String toString() { 
    String pom = "Rodzaj: " + getRodzaj(); 
    pom += " Marka:" + getMarka();
    pom += " Model " + getModel(); 
    pom += " ID: " + getID();
    pom += " Stan:"  + getStan(); 
        return pom;   
} 

@Override 
public boolean equals(Object ob)   { 
String id = getID(); 
String id2 = ((Sprzet_dane) ob).getID(); 
boolean a = id.equals(id2); 
return a;   
}

public void dodaj_sprzet(String dane[])
{ Sprzet nowa = new Sprzet();
if (nowa != null) {
nowa.setNumer(Integer.parseInt(dane[1]));
addSprzet(nowa);
}
}

public void addSprzet(Sprzet nowa) {
if (!this.mSprzet.contains(nowa)) {
this.mSprzet.add(nowa);
nowa.setSprzet_dane(this);
}
}

public java.util.ArrayList<String>sprzet()
{
java.util.ArrayList<String> sprzet = new java.util.ArrayList<String>();
Iterator<Sprzet> it = mSprzet.iterator();
while
        (it.hasNext()){
    sprzet.add(it.next().toString());
}
return
sprzet;
}
}
