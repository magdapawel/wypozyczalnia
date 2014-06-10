/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warstwa_klienta;

import Warstwa_biznesowa.Fasada;
import javax.swing.JOptionPane;
import java.util.Iterator;
import java.util.ArrayList;
import javax.swing.JComboBox;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    JLabel elista_rodzaj = new JLabel("Rodzaj sprzetu");
    JComboBox tytuly = new JComboBox();
    JLabel elista_sprzet = new JLabel("Sprzet");
    JComboBox sprzet = new JComboBox();
    JLabel esprzet = new JLabel(" Rodzaj sprzetu");
    JTextField TRodzaj = new JTextField(30);
    JLabel emodel = new JLabel("Model");
    JTextField TModel = new JTextField(30);
    JLabel emarka = new JLabel("Marka");
    JTextField TMarka = new JTextField(30);
    JLabel eID = new JLabel("ID");
    JTextField TID = new JTextField(30);
    JLabel stan = new JLabel("Stan");
    JTextField TStan = new JTextField(30);
    JLabel enumer = new JLabel("Numer sprzetu");
    JTextField TNumer = new JTextField(30);
    JButton zapisz_rodzaj = new JButton("Zapisz rodzaj");
    JButton zapisz_sprzet = new JButton("Zapisz model");
    JButton wyswietl_rodzaj = new JButton("Wyswietl rodzaj");
    JButton wyswietl_sprzet = new JButton("Wyswietl sprzet");
    Fasada fasada = new Fasada();

    GUI() {
        super("Aplikacja UML");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(esprzet);
        panel.add(TRodzaj);
        panel.add(emodel);
        panel.add(TModel);
        panel.add(emarka);
        panel.add(TMarka);
        panel.add(eID);
        panel.add(TID);
        panel.add(stan);
        panel.add(TStan);
        panel.add(enumer);
        panel.add(TNumer);
        zapisz_sprzet.addActionListener(this);
        panel.add(zapisz_sprzet);
        zapisz_rodzaj.addActionListener(this);
        panel.add(zapisz_rodzaj);
        wyswietl_rodzaj.addActionListener(this);
        panel.add(wyswietl_rodzaj);
        wyswietl_sprzet.addActionListener(this);
        panel.add(wyswietl_sprzet);
        panel.add(tytuly);
        panel.add(elista_rodzaj);
        panel.add(sprzet);
        panel.add(elista_sprzet);
        setContentPane(panel);
    }

    private void zawartosc_listy(ArrayList<String> kol, JComboBox lista) {
        String s;
        lista.removeAllItems();
        Iterator<String> iterator = kol.iterator();
        while (iterator.hasNext()) {
            s = iterator.next();
            lista.addItem(s);
        }
    }

    public void actionPerformed(ActionEvent evt) {
        String s1, s2, s3, s4, s5;
        Object zrodlo = evt.getSource();
        if (zrodlo == zapisz_rodzaj) {
            s1 = TRodzaj.getText();
            s2 = TModel.getText();
            s3 = TMarka.getText();
            s4 = TID.getText();
            s5 = TStan.getText();
            String[] sprzet = {s1, s2, s3, s4, s5};
            if (!s1.equals("") && !s2.equals("") && !s3.equals("")
                    && !s4.equals("") && !s5.equals("")) {
                fasada.dodaj_sprzet_dane(sprzet);
            }
        } else if (zrodlo == zapisz_sprzet) {
            s1 = TID.getText();
            s2 = TNumer.getText();
            String[] sprzet = {s1, s2};
            if (!s1.equals("") && !s2.equals("")) {
                fasada.dodaj_sprzet(sprzet);
            }
        } else if (zrodlo == wyswietl_rodzaj) {
            zawartosc_listy(fasada.sprzet_fasada(), tytuly);
        } else if (zrodlo == wyswietl_sprzet) {
            zawartosc_listy(fasada.sprzet_dane(), sprzet);
        }
        repaint();
    }

    static public void main(String args[]) {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}
