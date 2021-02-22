package web.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletContextDemo")
public class ServletContextDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        String path2 = context.getRealPath("/WEB-INF/classes/druid.properties");
        String path4 = context.getRealPath("aaa.txt");

        resp.setHeader("charset", "utf-8");
        ServletOutputStream sos = resp.getOutputStream();

        // createFileIfNotExists(sos, path4);
        // createFileIfNotExists(sos, path2);
    }

    private static void createFileIfNotExists(ServletOutputStream sos, String realPath)
            throws IOException {
        File file = new File(realPath);
        sos.write((file.getName() + "\t").getBytes());
        if (!file.exists()) {
            file.createNewFile();
            if (file.exists()) {
                sos.write(("Detect successfully: File not exists, craeted.\n").getBytes());
            } else {
                sos.write(("Detect failed: File not exists, failed to craete.\n").getBytes());
            }
        } else {
            sos.write("Detect successfully: File exists.\n".getBytes());
        }
    }
}
