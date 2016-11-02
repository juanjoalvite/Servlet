package AccesoDatos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author juanj
 */
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String codi = request.getParameter("selector");
        response.setContentType("text/html;charset=UTF-8");
        AccesoAlumnos aa = new AccesoAlumnos();
        ArrayList<Alumno> auxlist = aa.getListaAlumnos();
        boolean trobat = false;
        Alumno al = new Alumno();

        for (int i = 0; (i < auxlist.size()) && (trobat == false); i++) {
            String auxS = "" + auxlist.get(i).getCodi() + "";
            if (auxS.equals(codi)) {
                trobat = true;
                al = auxlist.get(i);
            }
        }

        request.setAttribute("alumno", al);
        RequestDispatcher a = request.getRequestDispatcher("/datosAl.jsp");
        a.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
