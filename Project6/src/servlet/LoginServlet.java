package servlet;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import service.LoginService;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response)
                   throws ServletException, IOException {
        String username = request.getParameter("username");
        String userpass = request.getParameter("password");
        List<String> info=new ArrayList<String>();

        LoginService service = new LoginService();
        boolean flag = service.checkUser(username,userpass);
        String msg   = flag?"success":"error";

        request.setAttribute("msg",msg);
        if(msg=="success") {
            info = service.getinfo(username);
            System.out.println(info.get(1));
            request.setAttribute("info", info);
            if (info.get(1) .equals("Register")) {
                request.getRequestDispatcher("login_register.jsp").forward(request, response);
            }
            if (info.get(1).equals("Stock")) {
                request.getRequestDispatcher("login_stock.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("login_order.jsp").forward(request, response);
            }
        }
        else {
            info.add("invalid username or password,please try again.");
            request.setAttribute("info", info);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}