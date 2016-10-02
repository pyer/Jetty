package ab.jetty;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HelloHandler extends AbstractHandler
{
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public void handle( String target,
                        Request baseRequest,
                        HttpServletRequest request,
                        HttpServletResponse response )
        throws IOException, ServletException
    {
        LOG.info(request.getRequestURI());
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();

        out.println("<h1>Hello world !</h1><br>");
        out.println(new Date().toString());
//        out.println("<br>session=" + request.getSession(true).getId());
        out.println("<br>method =" + request.getMethod());
        out.println("<br>path   =" + request.getPathInfo() + " ( " + request.getPathTranslated() + " )");
        out.println("<br>query  =" + request.getQueryString());
        out.println("<br>user   =" + request.getRemoteUser());
        out.println("<br>URI    =" + request.getRequestURI());

        baseRequest.setHandled(true);
    }
}
