/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

/**
 *
 * @author juanj
 */
public class Alumno {

    private int codi;
    private String nom;
    private String asign = "";
    private String tut = "";

    public Alumno() {
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAsign() {
        return asign;
    }

    public void setAsign(String asign) {
        this.asign += " | "+ asign + " | ";
    }

    public String getTut() {
        return tut;
    }

    public void setTut(String tut) {
        this.tut = " | " + tut + " | ";
    }

    @Override
    public String toString() {
        return "Alumno{" + "codi=" + codi + ", nom=" + nom + ", asign=" + asign + ", tut=" + tut + '}';
    }

}
