package virtualtek.servletjdbc;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "Tutorias", value = "/Tutorias-Servlet")
public class TutoriasServlet extends HttpServlet
{
    String carpeta="C:/Java/Archivos";

    /*
    public void init(ServletConfig config)throws ServletException
    {
        super.init(config);
        carpeta=getInitParameter("carpeta");
        if(carpeta==null)
        {
            System.err.println("No se especificó la carpeta de destino");
        }
    }
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        try {
            FileWriter fileWriter=new FileWriter("C:/Java/Archivos"+"/tutorias.txt",true);
            PrintWriter ficherosTutorias=new PrintWriter(fileWriter);
            Enumeration nombresParam=request.getParameterNames();

            while(nombresParam.hasMoreElements())
            {
                String param=(String)nombresParam.nextElement();
                String valor=request.getParameter(param);
                ficherosTutorias.println(param+": "+valor);
            }
            ficherosTutorias.println("<FIN>");
            ficherosTutorias.close();
            fileWriter.close();
        }
        catch(IOException exception)
        {
            out.println("Hubo problemas cursando su solicitud <br>Por favor,intentelo otra vez  "+exception);
        }
        out.close();
    }
    public String getServlet()
    {
        return("Servlet Tutorias");
    }
}