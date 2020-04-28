package servlet;

import service.UpdateStockService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateStockServlet")
public class UpdateStockServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] ids = request.getParameterValues("pid");
        String[] options = request.getParameterValues("options");
        String[] qty= request.getParameterValues("qty");
        List<String> info = new ArrayList<String>();

        UpdateStockService service = new UpdateStockService();
        info = service.updateinfo(ids,options,qty);
        request.setAttribute("info", info);
        request.getRequestDispatcher("updatestock.jsp").forward(request, response);
    }
}
