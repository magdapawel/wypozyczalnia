/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Warstwa_integracji_DAO;
import Warstwa_biznesowa.Fasada;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author magdalena
 */
public class Baza {
    private Connection polaczenie;
    private Statement polecenie;
    private Sprzet_daneController sprzet_dane_c;
    private SprzetController sprzet_c;
    private Fasada fasada;
    
    public Baza(Fasada fasada_) {
        fasada = fasada_;
    }
    public void polaczenie_z_baza () throws Exception{
        try{
            String data = "jdbc:derby://localhost:1527/Wypozyczalnia_baza";
            try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                            }
            catch (Exception e){
                System.out.println("Nie mozna zaladowac sterownika");
                throw new SQLException(e.toString());
            }
            polaczenie = DriverManager.getConnection(data, "Wypozyczalnia_baza", "Wypozyczalnia_baza" );
            sprzet_dane_c = new Sprzet_daneController(polaczenie);
            sprzet_c = new SprzetController(polaczenie);
                    }
        catch (SQLException e){
            throw new Exception();
        }
    }
    public void tabele() throws Exception {
        polecenie = polaczenie.createStatement();
        try{
            polecenie.executeUpdate("CREATE TABLE Wypozyczalnia_baza.Sprzet_dane (id_sprzet_dane BIGINT, rodzaj VARCHAR(50),"
                    + "Model VARCHAR(20), Marka VARCHAR(20), ID VARCHAR (20), )" 
            + "Stan VARCHAR(20), Numer_sprzetu VARCHAR (20), PRIMARY KEY(id_sprzet_dane)");
        }catch (SQLException e){
            System.out.println("Nie mozna zalozyc tabeli Sprzet_dane");
        }
    try{
    polecenie.executeUpdate("CREATE TABLE Wypozyczalnia_baza.Sprzet(id_sprzet BIGINT, numer INTEGER,"
            + "id_sprzet_dane_ BIGINT, PRIMARY KEY(id_sprzet),"
            + "FOREIGN KEY (id_sprzet_dane_) REFERENCES Wypozyczalnia_baza.Sprzet_dane(id_sprzet_dane))");
        }catch(SQLException e){
    System.out.println("Nie mozna zalozyc tabeli Sprzet");
}
}
    public ArrayList<String> sprzet () throws Exception {return sprzet_c.sprzet();}
    public ArrayList<String> sprzet_dane() throws Exception {return sprzet_dane_c.sprzet_dane();}
    public ArrayList<String[]> sprzet_t_we() throws Exception {return sprzet_c.sprzet_t_we();}
    public ArrayList<String[]> sprzet_dane_t_we() throws Exception {return sprzet_dane_c.sprzet_dane_t_we();}
    public void dodaj_sprzet() throws Exception {sprzet_c.dodaj_sprzet(sprzet_t_wy());}
    public void dodaj_sprzet_dane() throws Exception {sprzet_dane_c.dodaj_sprzet_dane(sprzet_dane_t_wy());}
public ArrayList<String[]> sprzet_dane_t_wy() {
ArrayList<String[]> sprzet_dane = new ArrayList();
ArrayList<String> sprzet_dane_ = fasada.sprzet_dane();
for (String t : sprzet_dane_) {
String[] dana = t.split(" ");
String[] sprzet_dane1 = {dana[1], dana[3], dana[4], dana[6
], dana[8]};
sprzet_dane.add(sprzet_dane1);                                 
  // Pobranie z kolekcji łacuchów reprezentujących 
}                                              // w
return sprzet_dane;
}
public ArrayList<String[]> sprzet_t_wy() {
ArrayList<String[]> sprzet = new ArrayList();
ArrayList<String> sprzet_ = fasada.sprzet_fasada();
for (String t : sprzet_) {
String[] dana = t.split(" ");
String[] sprzet1 = {dana[6], dana[10]};
sprzet.add(sprzet1);                                 
  // Pobranie z kolekcji łacuchów reprezentujących 
}                                              // w
return sprzet;
}
public void uaktualnij_dane() throws Exception{
    try{
        for (String[] t : sprzet_dane_t_we()){
            fasada.dodaj_sprzet_dane(t);
        }
        for(String[] t : sprzet_t_we()){
            fasada.dodaj_sprzet(t);
        }
    }catch (SQLException e){
                System.out.println(e);
                }
    }
}


