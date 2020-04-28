package servlet;

import service.LoginService;
import service.ViewStockService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowServlet")
public class ShowServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> infor = new ArrayList<String>();
        ViewStockService vs = new ViewStockService();
        infor = vs.getallinfo();
        request.setAttribute("info", infor);
        request.getRequestDispatcher("showstock.jsp").forward(request, response);
    }
}

