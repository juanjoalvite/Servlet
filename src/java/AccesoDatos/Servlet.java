package AccesoDatos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import JAXB.XMLJAXB;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletContext;
import sun.org.mozilla.javascript.internal.json.JsonParser;

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

        AccesoAlumnos alumnos = new AccesoAlumnos();
        ArrayList<Alumno> listaAlumnos = alumnos.getListaAlumnos();
      
        request.setAttribute("listaAlumnos", listaAlumnos);
        
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/formAl.jsp");
        rd.forward(request, response);
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
        //processRequest(request, response);

        String codi = request.getParameter("selector"); //Extrae el parámetro del selector.
        AccesoAlumnos aa = new AccesoAlumnos();
        ArrayList<Alumno> auxlist = aa.getListaAlumnos();
        boolean trobat = false;
        Alumno al = new Alumno();
        String json = "{\"error\": \"No se ha encontrado el alumno con código "+codi+" \"}";

        for (int i = 0; (i < auxlist.size()) && (trobat == false); i++) { //Compara el parámetro del selector hasta que encuentra un alumno con ese código.
            String auxS = "" + auxlist.get(i).getCodi() + "";
            if (auxS.equals(codi)) {
                trobat = true;
                al = auxlist.get(i);
                Gson gson = new Gson();
                json = gson.toJson(al);
            }
        }
        
        response.setContentType("application/json");
        response.getWriter().write(json);
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
