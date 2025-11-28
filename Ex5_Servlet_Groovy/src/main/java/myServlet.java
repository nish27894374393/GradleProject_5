import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
