<%-- 
    Document   : login
    Created on : 12/09/2018, 07:24:18 PM
    Author     : ALUMNO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    response.setHeader("Pragma", "no-cache");
    response.addHeader("Cache-control", "must-revalidate");
    response.addHeader("Cache-control", "no-cache");
    response.addHeader("Cache-control", "no-store");
    response.setDateHeader("Expires", 0);
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspf/estilos.jspf" %>

    </head>
    <body>
        <div class="conteiner-fluid">
            <%@include file="WEB-INF/jspf/cabecera.jspf" %>
            <%@include file="WEB-INF/jspf/nav.jspf" %>
            <section>
                <div class="row">
                    <div class="col-12 col-md-4 col-lg-4"></div>
                    <div class="col-12 col-md-4 col-lg-4">
                        <section>
                            <form action="controladorlogin.do" method="post">
                                <div class="form-group">
                                    <label for="codigo">Usuario:</label>
                                    <input type="text" class="form-control" id="codigo" name="txtCodigo" aria-describedby="emailHelp" placeholder="Usuario">
                                    <small id="emailHelp" class="form-text text-muted">Usuario Necesario para ingresar.</small>
                                </div>
                                <div class="form-group">
                                    <label for="contra">Contraseña</label>
                                    <input type="password" class="form-control" id="contra" name="txtContra" placeholder="Contraseña">
                                </div>
                                <div class="form-group">
                                    <label for="tipo">Tipo Usuario:</label>
                                    <select name="tipo" id="tipo" class="form-control" >
                                        <option value="1">Administrador</option>
                                        <option value="2">Profesor</option>
                                        <option value="3">Padre</option>
                                    </select>
                                    <br>
                                    <button type="submit" class="btn btn-primary">Ingresar</button>
                            </form>
                        </section>
                    </div>
                </div>

            </section>
            <%@include file="WEB-INF/jspf/footer.jspf" %>
            <%@include file="WEB-INF/jspf/jsfooter.jspf" %>
        </div>
    </body>
</html>
