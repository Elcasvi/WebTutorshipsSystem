package virtualtek.servletjdbc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import entityManager.EntityManagerJPA;
import modelo.Profesores;
import modelo.Tutorias;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;


@WebServlet(name = "NuevaTutoria", value = "/NuevaTutoria-Servlet")
public class NuevaTutoriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        Enumeration parameters=request.getParameterNames();
        Profesores profesor=new Profesores();
        Tutorias tutoria=new Tutorias();
        try
        {
            while(parameters.hasMoreElements())
            {
                String parametro = (String) parameters.nextElement();
                String valor = request.getParameter(parametro);
                if(parametro.equals("id_alumno"))
                {
                    tutoria.setId_alumno(valor);
                }
                else if (parametro.equals("nombreProfesor")) {
                    profesor.setNombreProfesor(valor);
                } else if (parametro.equals("dia")) {
                    tutoria.setDia(valor);
                } else if (parametro.equals("hora")) {
                    tutoria.setHora(valor);
                } else if (parametro.equals("asunto")) {
                  tutoria.setAsunto(valor);
                }
            }
            EntityManagerJPA conect=new EntityManagerJPA();
            List lista=conect.consultarIdProfesor(profesor.getNombreProfesor());
            int i=0;
            while(i<lista.size())
            {
                Profesores id=(Profesores)lista.get(i);
                profesor.setId_profesor(id.getId_profesor());
                //out.println(id.getId_profesor());
                break;
            }
            tutoria.setId_profesor(profesor.getId_profesor());


            EntityManagerJPA conexion=new EntityManagerJPA();
            System.out.println("Objeto tutoria:"+ tutoria);
            conexion.persist(tutoria);
            response.sendRedirect("/servletJDBC_war_exploded/index.jsp");
            /*
            out.println("<html>");
            out.println("<title>Concertar una tutoria</title>");
            out.println("Su peticion ha sido registrada<br>Un saludo");
            out.println("<a href=\"/servletJDBC_war_exploded\">Volver</a>");
            out.println("<br><br>");
            out.println("<a href=\"/servletJDBC_war_exploded/index.jsp\">Ver tutorias</a>");
            out.println("</html>");
            out.close();
            */
        }
        catch (Exception exception)
        {
            out.println("Hubo problemas cursando su solicitud <br>Por favor,intentelo otra vez  "+exception);
        }
        out.close();
    }

}
