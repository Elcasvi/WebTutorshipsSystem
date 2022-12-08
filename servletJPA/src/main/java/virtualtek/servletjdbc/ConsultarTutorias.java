package virtualtek.servletjdbc;

import com.mysql.cj.protocol.Resultset;
import entityManager.EntityManagerJPA;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Tutorias;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ConsultarTutoria", value = "/ConsultarTutoria-Servlet")
public class ConsultarTutorias extends HttpServlet {
    private EntityManagerJPA conexion;
    public void init(ServletConfig servletConfig)throws ServletException
    {
        super.init(servletConfig);
        try
        {
            conexion=new EntityManagerJPA();
        }
        catch (Exception exception)
        {
            System.out.println("Exception: "+exception);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try
        {
            List<Tutorias> consultaTutorias=conexion.getAllTutorias();
            out.println("<html><head><title>Tutorias</title></head>");
            out.println("<body>");
            out.println("<table width>");
        }
        catch(Exception ex)
        {

        }

    }
}
