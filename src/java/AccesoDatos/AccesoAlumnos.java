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
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class AccesoAlumnos {

    private final ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    public AccesoAlumnos() {
        cargarAlumnos();
    }

    public void cargarAlumnos() {
        try {
            int codi;
            String nom;
            String asign;
            String tut;
            Alumno a = new Alumno();
            MysqlConnectionHandler mc = new MysqlConnectionHandler();
            Connection con = mc.doConnection();
            Statement st = con.createStatement();
            
            for (int i = 1; i < 9; i++) {
                try {
                    
                    ResultSet rs = st.executeQuery("select alumne.nom as nombre,alumne.codi as codigo,tutoria.nom as nomtutoria, assignatura.nom as nomassignatura"
                            + " from alumne inner join tutoriaalumne on tutoriaalumne.codiAlumne= alumne.codi INNER join tutoria on tutoria.codi=tutoriaalumne.codiTutoria"
                            + " INNER join assignatura on assignatura.codi=tutoria.codiAssignatura where alumne.codi=" + i);
                    while (rs.next()) {
                        a.setNom(rs.getString("nombre"));
                        a.setCodi(rs.getInt("codigo"));
                        a.setAsign(rs.getString("nomassignatura"));
                        a.setTut(rs.getString("nomtutoria"));
                    }
                    listaAlumnos.add(a);
                    a = new Alumno();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(AccesoAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            mc.closeConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccesoAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }
}
