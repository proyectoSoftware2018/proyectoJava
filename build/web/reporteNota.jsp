<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : reporteAlumno
    Created on : 18-sep-2018, 15:55:24
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        response.setHeader("Pragma", "no-cache");
        response.addHeader("Cache-control", "must-revalidate");
        response.addHeader("Cache-control", "no-cache");
        response.addHeader("Cache-control", "no-store");
        response.setDateHeader("Expires", 0);
    %>
    <%
        try {
            if (request.getSession().getAttribute("usuario") == null) {
                request.getRequestDispatcher("index.jsp");
            }
        } catch (Exception e) {
            request.getRequestDispatcher("index.jsp");
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include  file="WEB-INF/jspf/estilos.jspf" %>
    </head>
    <body>

        <div class="container-fluid">
            <%@include  file="WEB-INF/jspf/cabecera.jspf" %>      
            <%@include  file="WEB-INF/jspf/navProfesor.jspf" %>    
            <section>
                <div class="row justify-content-center">
                    <div class="col-2">

                    </div>

                    <div class="col-12 justify-content-center">
                        <section>
                            <table class="table table-hover">
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

                                    <c:forEach var="lista" items="${sessionScope.notas}">
                                        <tr>
                                            <td>${lista.codigo}</td>
                                            <td>${lista.nombre}</td>
                                            <td>${lista.apellido}</td>
                                            <td>${lista.noral}</td>
                                            <td>${lista.nprac}</td>
                                            <td>${lista.ntrab}</td>
                                            <td>${lista.ncuad}</td>
                                            <td>${lista.proce}</td>
                                            <td>${lista.exabi}</td>
                                            <td>${lista.promedio}</td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>

                        </section>
                    </div>

                    <div class="col-2">

                    </div>

                </div>

        </div>
        <div class="py-3" style="text-align: center;">
            <a href="profesor.jsp" class="btn btn-primary">ir al panel de control</a>
        </div>
    </section>
    <%@include file="WEB-INF/jspf/footer.jspf" %> 
    <%@include file="WEB-INF/jspf/jsfooter.jspf" %> 

</body>
</html>
