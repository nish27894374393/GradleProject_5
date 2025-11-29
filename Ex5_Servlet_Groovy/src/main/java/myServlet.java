import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns={"/patients","/doctors"},loadOnStartup = 1)
public class myServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        resp.setContentType("text/html");
        if (path.equals("/doctors")){
            resp.getWriter().write("Hi Doctor Mike");
        }
        else if (path.equals("/patients")){
            resp.getWriter().write("Hi Nettles (Patient 1)");
        }
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Read the bytes of the body – ie the message
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        resp.setContentType("text/html");
        resp.getWriter().write("Thank you client! "+reqBody);
    }
}
