package ab.jetty;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jetty.server.Server;

/**
 * Example of embedded jetty and not requiring
 * all of the overhead of a WebAppContext
 */
public class Main
{
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception
    {
        LOG.info("Jetty embedded server");
        Server server = new Server(8080);
        server.setHandler(new HelloHandler());
        // Start Server
        LOG.info("Start...");
        server.start();
        LOG.info("Join...");
        server.join();
    }
}
