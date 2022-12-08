<%@ page import="entityManager.EntityManagerJPA" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Tutorias" %>
<%@ page import="modelo.Alumnos" %>
<%@ page import="modelo.Profesores" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
</head>
<body>
<%
    EntityManagerJPA entityManagerTutorias =new EntityManagerJPA();
    List<Alumnos>alumnos;
    List<Profesores>profesores;
    List<Tutorias>tutorias= entityManagerTutorias.getAllTutorias();

%>
<div class="jumbotron">
    <h1>TUTORIAS</h1>
    <table class="table">
        <thead class="table-dark">
        <tr>
            <th scope="col">Alumno</th>
            <th scope="col">Dia</th>
            <th scope="col">Hora</th>
            <th scope="col">Profesor</th>
            <th scope="col">Asunto</th>
            <th scope="col">Accion</th>
        </tr>
        </thead>
        <tbody class="table-group-divider">
        <%
            for(Tutorias tutoria:tutorias)
            {
                alumnos= entityManagerTutorias.consultarNombreAlumnos(tutoria.getId_alumno());
                profesores= entityManagerTutorias.consultarNombreProfesor(tutoria.getId_profesor());
                String nombreAlumno=alumnos.get(0).getNombreAlumno();
                String nombreProfesor=profesores.get(0).getNombreProfesor();
        %>
        <tr>
            <td><%=tutoria.getId_alumno()+"/"+nombreAlumno%></td>
            <td><%=tutoria.getDia()%></td>
            <td><%=tutoria.getHora()%></td>
            <td><%=tutoria.getId_profesor()+"/"+nombreProfesor%></td>
            <td><%=tutoria.getAsunto()%></td>
            <td>
                <a href="http://localhost:8080/servletJDBC_war_exploded/EditarTutoria-Servlet?id_tutoria=<%=Integer.valueOf(tutoria.getId_tutoria())%>&id_alumno=<%=tutoria.getId_alumno()%>&id_profesor=<%=tutoria.getId_profesor()%>&nombreProfesor=<%=nombreProfesor%>" class="btn btn-warning">
                    <i class="bi bi-pen">Editar</i>
                </a>
                <a href="http://localhost:8080/servletJDBC_war_exploded/EliminarTutoria-Servlet?id=<%=tutoria.getId_tutoria()%>&id_alumno=<%=tutoria.getId_alumno()%>&id_profesor=<%=tutoria.getId_profesor()%>&dia=<%=tutoria.getDia()%>&hora=<%=tutoria.getHora()%>&asunto=<%=tutoria.getAsunto()%>&nombreProfesor=<%=nombreProfesor%>" class="btn btn-danger">
                    <i class="bi bi-trash3-fill">Eliminar</i>
                </a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <br>
    <a class="btn btn-warning" href="/servletJDBC_war_exploded" role="button">
        <i class="bi bi-arrow-left-square-fill">Volver</i>
    </a>
</div>
<br/>
</body>
</html>