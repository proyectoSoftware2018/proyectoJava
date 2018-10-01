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
import modelo.DAOusuario;
import modelo.Usuario;

/**
 *
 * @author KandL
 */
public class ControladorLogin extends HttpServlet {

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
              response.setContentType("text/html;charset=UTF-8");
       
        String codigo = request.getParameter("txtCodigo");
        String contra = request.getParameter("txtContra");
        String tipo = request.getParameter("tipo");
        
         if(codigo.equals("") || contra.equals("") || tipo.equals("")){
          String error = "Debera de completar todos los campos";
          request.getSession().setAttribute("error", error);
          request.getRequestDispatcher("errorLogin.jsp").forward(request, response);
      }else{
         int ti=Integer.parseInt(tipo);
         Usuario usuario = new Usuario(codigo, contra, ti);
         DAOusuario da = new DAOusuario(usuario);
         
         if(da.validar()==false){
          String error = "Datos Incorrectos no esta Registrado";
          request.getSession().setAttribute("error", error);
          request.getRequestDispatcher("errorLogin.jsp").forward(request, response);  
          }else{
          switch(usuario.getTipo()){
              case 1:
                 request.getSession().setAttribute("usuario", usuario.getCodigo());    
                 request.getRequestDispatcher("administrador.jsp").forward(request, response);  
              break;
              case 2:
                 request.getSession().setAttribute("usuario", usuario.getCodigo());    
                 request.getRequestDispatcher("profesor.jsp").forward(request, response);  
              break;
              case 3:
                 request.getSession().setAttribute("usuario", usuario.getCodigo());    
                 request.getRequestDispatcher("padre.jsp").forward(request, response);  
              break;
          }
          
          
          
         }
      }               
         
    
     
        
        
        
        
        
        
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
