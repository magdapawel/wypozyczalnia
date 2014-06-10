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
public class SprzetController {
    static long id = 1;
    String sql;
    Connection polaczenie;
    Statement polecenie;
    ResultSet krotki;
    public SprzetController(Connection polaczenie_) { polaczenie = polaczenie_;}
    public void dodaj_sprzet(ArrayList<String[]> sprzet) throws Exception {
        try{
            polecenie = polaczenie.createStatement();
            for (String[] t : sprzet) {
                sql = "SELECT * FROM Wypozyczalnia_baza.Sprzet_dane WHERE ID" + "'" + t[0] + "'";
                krotki = polecenie.executeQuery(sql);
                if (krotki.next()) {
                    long pom = Long.parseLong(krotki.getString("id_sprzet_dane"));
                    int nr = Integer.parseInt(t[1]);
                    sql = "SELECT * FROM Wypozyczalnia_baza.Sprzet WHERE numer =" + nr + "and id_sprzet" + pom;
                    krotki = polecenie.executeQuery(sql);
                    if (!krotki.next()) {
                        polecenie.executeUpdate("INSERT INTO Wypozyczalna_baza.Sprzet (id_sprzet, numer, id_sprzet_dane)"
                        + "VALUES (" + (id++) + "," + nr + "," + pom + ")"); } 
                    }
                }
            }catch (SQLException e) {
                throw new Exception();
        }
    }
    public ArrayList<String> sprzet() throws Exception {
        try{
            polecenie = polaczenie.createStatement();
            sql = "SELECT * FROM Wypozyczalnia_baza.Sprzet_dane, Wypozyczalnia_baza.Sprzet WHERE id_sprzet_dane = id_sprzet_dane_";
            krotki = polecenie.executeQuery(sql);
            ArrayList<String> sprzet = new ArrayList();
            String s = "";
            while (krotki.next()) {
                s = "id_sprzet_dane: " + krotki.getString("id_sprzet_dane") + " numer: " + krotki.getString("numer")
                        + "ID: " + krotki.getString("ID");
                sprzet.add(s);
                s = "";}
            polecenie.close();
            return sprzet;       
           }catch (SQLException e) {
               throw new Exception();
        }
    }
    public ArrayList<String[]> sprzet_t_we() throws Exception {
        try{
            ArrayList<String> sprzet = sprzet();
            ArrayList<String[]> sprzet_ = new ArrayList();
            String id_ = "1";
            for (String s : sprzet) {
                String[] pom = s.split(" ");
                id_ = pom[1];
                String[] dane = {pom[5], pom[3]};
                sprzet_.add(dane); }
                id = Long.parseLong(id_) + 1;
                return sprzet_;
            }catch (SQLException e) {
                throw new Exception();
        }
    }
}
