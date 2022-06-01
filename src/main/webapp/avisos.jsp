<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Aviso"%>
<%
    List<Aviso> avisos = (List<Aviso>) request.getAttribute("avisos");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
    </head>
    <body>


        <table border="1">
            <tr>
                <td>
                    <h1>SEGUNDO PARCIAL TEM-742</h1>
                    <br>
                    <p>Nombre: Abad Segio Yujra Quispe</p>
                    <p>Carnet: 9954318</p>
                </td>
            </tr> 
            <br>
            <br>

            <table border="1">
                <tr>
                    <td>



            </table>

            <h1>Seminarios disponibles</h1>
            <p><a href="AvisoController?action=add">Nuevo</a></p>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Titulo</th>
                    <th>Fecha</th>
                    <th>cupos</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${avisos}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.titulo}</td>
                        <td>${item.fecha}</td>
                        <td>${item.cupo}</td>
                        <td><a href="AvisoController?action=edit&id=${item.id}">Editar</a></td>
                        <td><a href="AvisoController?action=delete&id=${item.id}">Eliminar</a></td>
                    </tr>              
                </c:forEach>
            </table>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        </td>
    </tr>
</table>
</body>

</html>
