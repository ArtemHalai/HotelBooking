package command;


import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractCommand implements Command {
    private final Logger LOG = Logger.getLogger(this.getClass());

    protected void sendError(HttpServletResponse response, int errorCode){
        try {
            response.sendError(errorCode);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
