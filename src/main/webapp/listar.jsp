<%-- 
    Document   : listar
    Created on : 05-mar-2021, 20:53:27
    Author     : DAW-A
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Automoviles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            #lista {
                padding: 30px;
            }
        </style>
        
    </head>
    <body>
    <nav class="navbar navbar-expand-md bg-dark navbar-dark">
        <!-- Brand -->
        <a class="navbar-brand" href="#">Gestión Automóviles</a>

        <!-- Toggler/collapsibe Button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Navbar links -->
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="ServletAutomovil?op=listar">Listar Autos</a><br>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ServletAutomovil?op=insert1">Insertar Auto</a>
                </li>
            </ul>
        </div>
    </nav>
        <div id="lista">
        <h3>Listado de Automóviles</h3>
        <% List<Automoviles> misAutos = (List<Automoviles>) request.getAttribute("misAutos");  %>

        <table class="table table-hover">
            <tr>
                <th>id</th>
                <th>marca</th>
                <th>modelo</th>
                <th>cv</th>
                <th>Borrar</th>
                <th>Actualizar</th>
            </tr>
            <% for (Automoviles a : misAutos) {
                    String cadenaBorrar = "<a onclick='return confirmation()' href='ServletAutomovil?op=borrar&id=" + a.getId() + "'><i class='fas fa-trash-alt'></i></a>";
                    String cadenaActualizar = "<a href='ServletAutomovil?op=update1&id=" + a.getId() + "'><i class='far fa-edit'></i></a>";
            %>
            <tr>
                <td><%= a.getId()%></td>
                <td><%= a.getMarca()%></td>
                <td><%= a.getModelo()%></td>
                <td><%= a.getCv()%></td>
                <td><%= cadenaBorrar%></td>
                <td><%= cadenaActualizar%></td>

            </tr>
            <% }%>
        </table>
</div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script type="text/javascript">
            function confirmation() {
                if (confirm('Está seguro de eliminar el registro?') === true) {
                    alert("El registro ha sido eliminado correctamente");
                    return true;
                } else {
                    alert("Cancelo la eliminación");
                    return false;
                }
            }
        </script>
    </body>
</html>
