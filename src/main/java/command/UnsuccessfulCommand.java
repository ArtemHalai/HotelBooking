package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static enums.Mappings.UNSUCCESSFUL;

public class UnsuccessfulCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return UNSUCCESSFUL.getName();
    }
}
