<%@page import="modelo.Alumno"%>
<%@page import="java.util.LinkedList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : registroNota
    Created on : 20/09/2018, 03:54:26 AM
    Author     : KandL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% int tamaño = (Integer) request.getSession().getAttribute("tama");
    LinkedList<Alumno> l = (LinkedList<Alumno>) request.getSession().getAttribute("lista");

%>
<!DOCTYPE html>
<html ng-app>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include  file="WEB-INF/jspf/estilos.jspf" %>
    </head>
    <body>


        <%@include  file="WEB-INF/jspf/cabecera.jspf" %>      
        <%@include  file="WEB-INF/jspf/navProfesor.jspf" %>    
        <section>
            
            <section>
                <div class="row">
                    <div class="col-1">

                    </div>
                    <div class="col-10">
                        <form action="controladornota.do" method="post">
                     <div class="py-3" style="text-align: center;">
                         <button type="submit" class="btn btn-primary">Registrar</button>
                    <a href="profesor.jsp" class="btn btn-primary">ir al panel de control</a>
                      </div> 
                <table class="table table-responsive table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th>Cod.Usuario</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Nota Oral</th>
                        <th>Nota Prac</th>
                        <th>Nota Trab</th>
                        <th>Nota Cuad</th>
                        <th>Proceso</th>
                        <th>Ex. Bimes.</th>
                        <th>Promedio</th>
                    </tr>
                </thead>
                <tbody>
                 
                    <%    for (int i = 0; i < tamaño; i++) {
                            out.print("<tr>");
                    %>
                <td><input class="alert alert-success" readonly="readonly" size="7" class="text-center" name="codi<%out.print(i);%>" type="text" value="<%out.print(l.get(i).getUsuario());%>" /></td>
                <td><input class="alert alert-success" readonly="readonly" size="12" class="text-center" name="nom<%out.print(i);%>" type="text" value="<%out.print(l.get(i).getNombreh());%>"/></td>
                <td><input class="alert alert-success" readonly="readonly" size="12" class="text-center" name="ape<%out.print(i);%>" type="text" value="<%out.print(l.get(i).getApellidoh());%>"/></td>
                <td><input class="alert alert-secondary" min="0" max="20" class="text-center" name="ora<%out.print(i);%>" type="number" ng-model="a<%out.print(i);%>"/></td>
                <td><input class="alert alert-secondary" min="0" max="20" class="text-center" name="pra<%out.print(i);%>" type="number" ng-model="b<%out.print(i);%>"/></td>
                <td><input class="alert alert-secondary" min="0" max="20" class="text-center" name="tra<%out.print(i);%>" type="number" ng-model="c<%out.print(i);%>"/></td>
                <td><input class="alert alert-secondary" min="0" max="20" class="text-center" name="cua<%out.print(i);%>" type="number" ng-model="d<%out.print(i);%>"/></td>
                <td><input class="alert alert-danger" min="0" max="20" readonly="readonly" class="text-center" name="pro<%out.print(i);%>" type="number" value="{{(((a<%out.print(i);%>)+(b<%out.print(i);%>)+(c<%out.print(i);%>)+(d<%out.print(i);%>))/4)}}"/></td>
                <td><input class="alert alert-secondary" min="0" max="20" class="text-center" name="bi<%out.print(i);%>" type="number"  ng-model="bi<%out.print(i);%>"/></td>
                <td><input class="alert alert-danger" min="0" max="20" readonly="readonly" class="text-center" name="p<%out.print(i);%>" type="number" value="{{(((((a<%out.print(i);%>)+(b<%out.print(i);%>)+(c<%out.print(i);%>)+(d<%out.print(i);%>))/4))+bi<%out.print(i);%>)/2}}" ng-init="0"/></td>
                    <%
                            out.print("</tr>");
                        }
                    %>  
                </tbody>
            </table>
                        </form>
                <div class="col-1">

                    </div>
                </div>
                </div>
            </section>

        </section>
        <%@include file="WEB-INF/jspf/footer.jspf" %> 
        <%@include file="WEB-INF/jspf/jsfooter.jspf" %> 

    </body>
</html>
