/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EsNumero;
import modelo.Profesor;

/**
 *
 * @author alumno
 */
public class controladorProfe extends HttpServlet {

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

        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("dire");
        String ciudad = request.getParameter("ciudad");
        String edad = request.getParameter("edad");
        String tcasa = request.getParameter("tcasa");
        String tmovil = request.getParameter("tmovil");
        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("contra");

        if (codigo.equals("") || apellido.equals("") || nombre.equals("") || direccion.equals("") || ciudad.equals("") || edad.equals("") || tcasa.equals("") || tmovil.equals("") || correo.equals("") || contraseña.equals("")) {
            String error = "Debera de completar todos los campos";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("errorAdmi.jsp").forward(request, response);
        } else if (EsNumero.validar(edad) == false || EsNumero.validar(tcasa) == false || EsNumero.validar(tmovil) == false) {

            String error = "Error un tipo de dato no es correcto";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("errorAdmi.jsp").forward(request, response);
        } else {
            int eda = Integer.parseInt(edad);
            int tc = Integer.parseInt(tcasa);
            int tm = Integer.parseInt(tmovil);
            Profesor pro = new Profesor(codigo, apellido, nombre, direccion, ciudad, eda, tc, tm, correo, contraseña);
            
            if (pro.insert() == true) {
                    request.getSession().setAttribute("profesor", pro);
                    request.getRequestDispatcher("inforProfe.jsp").forward(request, response);
                } else {
                    String error = "Error no se inserto";
                    request.getSession().setAttribute("error", error);
                    request.getRequestDispatcher("errorAdmi.jsp").forward(request, response);
                }
        }

        /*
         Profesor pro = new Profesor(codigo,apellido,nombre,direccion,ciudad,eda,tc,tm,correo,contraseña);
            
         if(pro.insert()==true){
         request.getSession().setAttribute("profesor",pro );    
         request.getRequestDispatcher("inforProfe.jsp").forward(request, response);  
         }else{
         String error = "Error no se inserto";
         request.getSession().setAttribute("error", error);
         request.getRequestDispatcher("error.jsp").forward(request, response);   
         }
         */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
