<%-- 
    Document   : registroProfesor
    Created on : 19-sep-2018, 17:21:03
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspf/estilos.jspf" %>
    </head>
    <body>
        <div class="conteiner-fluid">
            <%@include file="WEB-INF/jspf/cabecera.jspf" %>     
            <%@include file="WEB-INF/jspf/navAdministrador.jspf" %>
            <section>
                
                    <div class="row">
                        <div class="col-12 col-md-12 col-lg-12"></div>
                        <div class="col-12 col-md-12 col-lg-12">
                            <form action="controladorprofe.do" method="post">
                                <div class="form-row">
                                    <div class="form-group col-md-2">
                                        <label for="codigo">Usuario:</label>
                                        <input type="text" class="form-control" id="codigo" name="codigo" placeholder="************">
                                    </div>
                                    <div class="form-group col-md-5">
                                        <label for="nombre">Nombre:</label>
                                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Victor">
                                    </div>
                                    <div class="form-group col-md-5">
                                        <label for="apellido">Apellidos:</label>
                                        <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Morales">
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="dire">Direccion:</label>
                                        <input type="text" class="form-control" id="dire" name="dire" placeholder="av.Belaunde-primera etapa">
                                    </div>
                                    <div class="form-group col-md-5">
                                        <label for="ciudad">Ciudad:</label>
                                        <input type="text" class="form-control" id="ciudad" name="ciudad" placeholder="Lima">
                                    </div>
                                    <div class="form-group col-md-1">
                                        <label for="edad">Edad:</label>
                                        <input type="number" class="form-control" id="edad" name="edad" placeholder="20">
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="tcasa">Telefono de casa:</label>
                                        <input type="number" class="form-control" id="tcasa" name="tcasa" placeholder="24453423">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="tmovil">Telefono movil:</label>
                                        <input type="number" class="form-control" id="tmovil" name="tmovil" placeholder="987543322">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="correo">Correo:</label>
                                        <input type="email" class="form-control" id="correo" name="correo" placeholder="Mario_11@hotmail.com">                  
                                    </div>
                                </div>           
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="contra">Contraseña:</label>
                                        <input type="password" class="form-control" id="contra" name="contra" placeholder="**************">                  
                                    </div>
                                </div> 
                                <br>
                                <div style="text-align: center;">
                                    <button type="submit" class="btn btn-primary">Registrar</button> <a href="administrador.jsp" class="btn btn-danger">Cancelar</a>
                                </div>
                            </form>

                        </div>

                    </div>
                
            </section>
            <%@include file="WEB-INF/jspf/footer.jspf" %>
            <%@include file="WEB-INF/jspf/jsfooter.jspf" %>
        </div>
    </body>
</html>
