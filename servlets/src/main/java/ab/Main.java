package ab;

import java.net.URL;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;

/**
 * Example of embedded jetty not requiring
 * all of the overhead of a WebAppContext
 */
public class Main
{

    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        // get the full path of webroot directory
        URL webroot = Main.class.getClassLoader().getResource("webroot");
        context.setBaseResource(Resource.newResource(webroot));
        server.setHandler(context);

        // Servlets
        context.addServlet(new ServletHolder(new ServletA()),"/A/*");
        context.addServlet(new ServletHolder(new ServletB()),"/B/*");

        // Add default servlet last (always last)
        // Must be named "default", must be on path mapping "/"
        ServletHolder holderDef = new ServletHolder("default",DefaultServlet.class);
        //holderDef.setInitParameter("dirAllowed","true");
        context.addServlet(holderDef,"/");

        // Start Server
        server.start();
        server.join();
    }

}
