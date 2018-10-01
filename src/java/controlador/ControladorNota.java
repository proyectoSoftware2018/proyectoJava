/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.EsDouble;
import modelo.EsNumero;
import modelo.ListaAlumnos;
import modelo.ListaNotas;
import modelo.Nota;

/**
 *
 * @author alumno
 */
public class ControladorNota extends HttpServlet {

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
        ListaAlumnos li = new ListaAlumnos();
        LinkedList<Alumno> ve = li.select();
        int tam = ve.size();
        boolean si=false;
        String cod[] = new String[tam];
        String nom[] = new String[tam];
        String ape[] = new String[tam];
        String oral[] = new String[tam];
        String prac[] = new String[tam];
        String trab[] = new String[tam];
        String cuad[] = new String[tam];
        String proc[] = new String[tam];
        String bime[] = new String[tam];
        String prome[] = new String[tam];
        ListaNotas no = new ListaNotas();
        
        for (int i = 0; i < tam; i++) {
            
            cod[i] = request.getParameter("codi"+i);
            nom[i] = request.getParameter("nom"+i);
            ape[i] = request.getParameter("ape"+i);
            oral[i] = request.getParameter("ora"+i);
            prac[i] = request.getParameter("pra"+i);
            trab[i] = request.getParameter("tra"+i);
            cuad[i] = request.getParameter("cua"+i);
            proc[i] = request.getParameter("pro"+i);
            bime[i] = request.getParameter("bi"+i);
            prome[i] = request.getParameter("p"+i);

          // ya mira te acuerdas de esto
            if (cod[i].equals("") || nom[i].equals("") || ape[i].equals("") || oral[i].equals("") || prac[i].equals("") || trab[i].equals("")
                    || cuad[i].equals("") || proc[i].equals("") || bime[i].equals("") || prome[i].equals("")) {
                
                String error = "Debera de completar todos los campos";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("errorProfe.jsp").forward(request, response);
            }else{
                
            
                if(EsNumero.validar(oral[i])==false || EsNumero.validar(prac[i])==false || EsNumero.validar(trab[i])==false
                      || EsNumero.validar(cuad[i])==false || EsNumero.validar(bime[i])==false || EsDouble.validar(proc[i])==false || EsDouble.validar(prome[i])==false){
                String error = "Error en uno de las notas";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("errorProfe.jsp").forward(request, response);   
                }else{ 
                 
                  Nota not = new Nota(cod[i], nom[i], ape[i], Integer.parseInt(oral[i]), Integer.parseInt(prac[i]), Integer.parseInt(trab[i]), Integer.parseInt(cuad[i]), Integer.parseInt(bime[i]), Math.round(Double.parseDouble(proc[i])),Math.round(Double.parseDouble(prome[i])));
                  //esto no insertaba te acuerdas responde Si
                  //ya mira parece que el problema era en esto lo he puesto afuera del for
                  //parece que no lo reconocia y me mandaba error pero ahora si mira
                  if(not.insert()==false){
                   String error = "Las notas ya han sido registradas no se puede volver a registrar";
                  request.getSession().setAttribute("error", error);   
                  }else{
                  si = true;
                  }
               }
           }
    }
        
        
        if(si==true){
          LinkedList<Nota> lis = no.select();
          request.getSession().setAttribute("notas", lis);
          request.getRequestDispatcher("reporteNota.jsp").forward(request, response);  
        }else{
          request.getRequestDispatcher("errorProfe.jsp").forward(request, response);  
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
