<%@ page import="java.util.Vector" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div align="center" class="jumbotron">
  <h1>EDITAR TUTORIA</h1>
  <form action="http://localhost:8080/servletJDBC_war_exploded/EditarTutoria-Servlet" method="post">
    <%
      Cookie[] myCookies=request.getCookies();
      String cookieAlumno="";
      String cookieIDProfesor="";
      String cookieNombreProfesor="";

      for(Cookie cookie:myCookies) {
        if(cookie.getName().equals("id_alumno"))
        {
          cookieAlumno=cookie.getValue();
        }
        else if (cookie.getName().equals("id_profesor"))
        {
          cookieIDProfesor=cookie.getValue();
        }
        else if (cookie.getName().equals("nombreProfesor"))
        {
          String nuevoNombreCookie="";
          String valorDeCookie=cookie.getValue();
          for(int i=0;i<valorDeCookie.length();i++)
          {
            if(String.valueOf(valorDeCookie.charAt(i)).equalsIgnoreCase("+")==false)
            {
              nuevoNombreCookie=nuevoNombreCookie+valorDeCookie.charAt(i);
            }
            else
            {
              nuevoNombreCookie=nuevoNombreCookie+" ";
            }
          }
          cookieNombreProfesor=nuevoNombreCookie;
        }
      }
    %>
    <div class="form-group" style="width: 500px;">
      <label>Matricula del alumno</label>
      <input type="text" name="id_alumno" size="60" placeholder="Alumno:" value=<%=cookieAlumno%> readonly="readonly">
    </div>
    <br>

    <div class="form-group" style="width: 500px;">
      <label>Nombre del profesor</label>
      <input type="text" name="nombreProfesor" size="60" placeholder="Profesor:" value=<%=cookieNombreProfesor%> readonly="readonly">
    </div>
    <br>
    <br>


    <select size="1" name="dia">
      <option selected>Dia...</option>
      <option>Lunes</option>
      <option>Miercoles</option>
      <option>Jueves</option>
    </select>

    <br>
    <label>Hora: </label>
    &nbsp;
    <input type="radio" name="hora" value="10">
    10
    &nbsp;
    <input type="radio" name="hora" value="12">
    12
    &nbsp;
    <input type="radio" name="hora" value="16">
    16
    &nbsp;
    <input type="radio" name="hora" value="18">
    18
    <br>
    <br>
    <label>Asunto de la tutoria</label>
    <br>
    <textarea name="asunto" rows="5" cols="40" wrap></textarea>
    <br>
    <br>
    <button type="submit" value="Enviar datos" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-danger">Reset</button>
  </form>
  <br>
  <a class="btn btn-warning" href="/servletJDBC_war_exploded/index.jsp" role="button">Ver tutorias</a>
</div>
</body>
</html>
