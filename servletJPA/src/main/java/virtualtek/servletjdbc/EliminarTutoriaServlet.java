package virtualtek.servletjdbc;

import entityManager.EntityManagerJPA;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Profesores;
import modelo.Tutorias;

import java.awt.image.PackedColorModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "EliminarTutoria", value = "/EliminarTutoria-Servlet")
public class EliminarTutoriaServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("txt/html");
        PrintWriter out = response.getWriter();
            Enumeration parameters = request.getParameterNames();
            Tutorias tutoria = new Tutorias();
            try {
                while (parameters.hasMoreElements()) {
                    String parametro = (String) parameters.nextElement();
                    String valor = request.getParameter(parametro);
                    if (parametro.equalsIgnoreCase("id_alumno"))
                    {
                        tutoria.setId_alumno(valor);
                    }
                    else if (parametro.equalsIgnoreCase("id_profesor"))
                    {
                        tutoria.setId_profesor(valor);
                    }
                    else if (parametro.equalsIgnoreCase("dia"))
                    {
                        tutoria.setDia(valor);
                    }
                    else if (parametro.equalsIgnoreCase("hora"))
                    {
                        tutoria.setHora(valor);
                    }
                    else if (parametro.equalsIgnoreCase("asunto"))
                    {
                        tutoria.setAsunto(valor);
                    }
                    else if(parametro.equalsIgnoreCase("id"))
                    {
                        tutoria.setId_tutoria(Integer.valueOf(valor));
                    }
                }
                EntityManagerJPA conexion = new EntityManagerJPA();
                conexion.delete(tutoria);
                response.sendRedirect("/servletJDBC_war_exploded/index.jsp");
            }
            catch (Exception exception) {
                out.println("Hubo problemas cursando su solicitud <br>Por favor,intentelo otra vez  " + exception);
            }
            out.close();
    }
}
