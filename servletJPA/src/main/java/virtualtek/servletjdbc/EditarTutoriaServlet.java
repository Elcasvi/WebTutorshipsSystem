package virtualtek.servletjdbc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import entityManager.EntityManagerJPA;
import modelo.Profesores;
import modelo.Tutorias;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.List;


@WebServlet(name = "EditarTutoria", value = "/EditarTutoria-Servlet")
public class EditarTutoriaServlet extends HttpServlet {
    private String StringCookieIDTutoria = "";
    private String StringCookieIDAlumno="";
    private String StringCookieIDProfesor="";
    private String StringcookieNombreProfesor="";

    protected  void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        Enumeration parameters=request.getParameterNames();
        Tutorias tutoria=new Tutorias();
        tutoria.setId_profesor(StringCookieIDProfesor);
        tutoria.setId_alumno(StringCookieIDAlumno);
        tutoria.setId_tutoria(Integer.valueOf(StringCookieIDTutoria));

        try
        {
            while(parameters.hasMoreElements())
            {
                String parametro = (String) parameters.nextElement();
                String valor = request.getParameter(parametro);
                if (parametro.equals("dia")) {
                    tutoria.setDia(valor);
                } else if (parametro.equals("hora")) {
                    tutoria.setHora(valor);
                } else if (parametro.equals("asunto")) {
                    tutoria.setAsunto(valor);
                }
            }
            EntityManagerJPA conexion=new EntityManagerJPA();
            conexion.update(tutoria);
            response.sendRedirect("/servletJDBC_war_exploded/index.jsp");
        }
        catch (Exception exception)
        {
            out.println("Hubo problemas cursando su solicitud <br>Por favor,intentelo otra vez  "+exception);
        }
        out.close();
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        try
        {


            Enumeration parameters=request.getParameterNames();
            while (parameters.hasMoreElements())
            {
                String parametro = (String) parameters.nextElement();
                String valor = request.getParameter(parametro);
                //System.out.println("parametro: " + parametro + " || Valor: " + valor);
                 if(parametro.equals("id_tutoria"))
                 {
                     StringCookieIDTutoria=valor;

                 }
                 else if(parametro.equals("id_alumno"))
                 {
                     StringCookieIDAlumno=valor;
                 }
                else if(parametro.equals("id_profesor"))
                {
                    StringCookieIDProfesor=valor;
                }
                else if (parametro.equals("nombreProfesor"))
                {
                    StringcookieNombreProfesor=valor;
                }
            }

            Cookie cookieIDTutoria = new Cookie("id_tutoria",StringCookieIDTutoria);
            Cookie cookieIDAlumno = new Cookie("id_alumno",StringCookieIDAlumno);
            Cookie cookieIDProfesor = new Cookie("id_profesor",StringCookieIDProfesor);
            Cookie cookieNombreProfesor = new Cookie("nombreProfesor", URLEncoder.encode(StringcookieNombreProfesor,"UTF-8"));

            response.addCookie(cookieIDTutoria);
            response.addCookie(cookieIDAlumno);
            response.addCookie(cookieIDProfesor);
            response.addCookie(cookieNombreProfesor);
            response.sendRedirect("/servletJDBC_war_exploded/editar.jsp");
        }
        catch (Exception exception)
        {
            out.println("Hubo problemas cursando su solicitud <br>Por favor,intentelo otra vez  "+exception);
        }


        out.close();
    }
}
