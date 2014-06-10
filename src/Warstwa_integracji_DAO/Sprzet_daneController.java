/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Warstwa_integracji_DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author magdalena
 */
public class Sprzet_daneController {
    static long id = 1;
    String sql;
    Connection polaczenie;
    Statement polecenie;
    ResultSet krotki;
    
    public Sprzet_daneController(Connection polaczenie_) {
        polaczenie = polaczenie_;
    }
    public void dodaj_sprzet_dane(ArrayList<String[]> sprzet_dane) throws Exception {
try{
    polecenie = polaczenie.createStatement();
    for (String[] t : sprzet_dane) {
        sql = "SELECT * FROM Wypozyczalnia_baza.Sprzet_dane WHERE " + "'" + t[3] + "'";
        krotki = polecenie.executeQuery(sql);
        if(!krotki.next()) {
            polecenie.executeUpdate("INSERT INTO Wypozyczalnia_baza.Sprzet_dane (id_sprzet_dane, rodzaj, model, marka, id, stan, numer_sprzetu)" 
                    + " VALUES (" + (id++) + ",'" + t[0] + "','" + t[1] + "','" + t[2] + "','" + t[3] + "','" + t[4] + "','" + t[5] + ")"); }
    }
    polecenie.close();
}catch (SQLException e) {
    throw new Exception(); 
    }
}   
    public ArrayList<String> sprzet_dane() throws Exception {
        try{
            polecenie = polaczenie.createStatement();
            sql="SELECT * FROM Wypozyczalnia_baza.Sprzet_dane ORDER BY model";
            krotki = polecenie.executeQuery(sql);
            String s = "";
            ArrayList<String> sprzet_dane = new ArrayList();
            while (krotki.next()) {
                s = "id_sprzet_dane" + krotki.getString("id_sprzet_dane") + "rodzaj" + krotki.getString("rodzaj")
                        + "model" + krotki.getString("model") + "marka" + krotki.getString("marka") +
                        "id" + krotki.getString("id") + "stan" + krotki.getString("stan") + 
                        "numer_sprzetu" + krotki.getString("numer_sprzetu");
                sprzet_dane.add(s);
                s = "";
            }
            polecenie.close();
            return sprzet_dane;
                    } 
        catch (SQLException e) {
            throw new Exception();
        }
    }
        public ArrayList<String[]> sprzet_dane_t_we() throws Exception {
            try{
                ArrayList<String> sprzet_dane = sprzet_dane();
                ArrayList<String[]> sprzet_dane_ = new ArrayList();
                String id_ = "1";
                for (String s : sprzet_dane){
                    String[] pom = s.split(" ");
                    id_ = pom[1];
                    String[] dane = {pom[3], pom[5], pom[7], pom[9], pom[11]};
                    sprzet_dane_.add(dane); }
                id = Long.parseLong(id_) + 1;
                return sprzet_dane_;
            } catch (SQLException e) {
                throw new Exception();
                }
            }
    }
