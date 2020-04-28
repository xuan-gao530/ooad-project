package servlet;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import service.ViewStockService;

@WebServlet(name = "ViewStockServlet")
public class ViewStockServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productname = request.getParameter("productname");
        List<String> infor = new ArrayList<String>();
        ViewStockService service = new ViewStockService();
        if (productname.equals("all")) {
            infor = service.getallinfo();
            request.setAttribute("infor", infor);
            request.getRequestDispatcher("viewstock.jsp").forward(request, response);
        } else {
            boolean flag = service.checkstock(productname);
            String msg = flag ? "success" : "error";
            request.setAttribute("msg", msg);
            if (msg == "success") {
                infor = service.getinfo(productname);
                System.out.println(infor.get(1));
                request.setAttribute("infor", infor);
                request.getRequestDispatcher("viewstock.jsp").forward(request, response);
            } else {
                infor.add("invalid product name,please try again.");
                request.setAttribute("infor", infor);
                request.getRequestDispatcher("login_stock.jsp").forward(request, response);
            }

        }
    }
}



