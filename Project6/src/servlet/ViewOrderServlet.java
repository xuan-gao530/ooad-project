package servlet;

import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewOrderServlet")
public class ViewOrderServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userid = request.getParameter("aid");
        String usertype=request.getParameter("usertype");
        List<String> infor = new ArrayList<String>();
        OrderService service = new OrderService();
        if(usertype.equals("Register")) {
            infor = service.vieworderbyuser(userid);
        }
        else if(usertype.equals("Order")) {
            infor = service.vieworder();
        }
        request.setAttribute("infor", infor);
        request.getRequestDispatcher("vieworder.jsp").forward(request, response);
    }
}
