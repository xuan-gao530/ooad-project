package servlet;

import service.OrderService;
import service.UpdateStockService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderService service = new OrderService();
        ArrayList cartinfo = service.viewcart();
        request.setAttribute("cartinfo", cartinfo);

        String[] ids = request.getParameterValues("pid");
        String[] qty= request.getParameterValues("qty");
        List<String> stockinfo = new ArrayList<String>();
        List<String> optionsinfo = new ArrayList<String>();
        String confirm = request.getParameter("confirm");
        //if confirming the order :1)update the stock 2)create the order_records
        if(confirm!=null) {
            for (int i = 0; i < ids.length; i++) {
                optionsinfo.add("minus");
            }
            String[] options = optionsinfo.toArray(new String[optionsinfo.size()]);
            UpdateStockService us = new UpdateStockService();
            stockinfo = us.updateinfo(ids, options, qty);  //update the stock
            service.updateorder(cartinfo);  //create the order_records
            service.clearcart();  //clear the cart information
            request.setAttribute("feedback", "Your order has confirmed, thank you!");
        }
        request.getRequestDispatcher("order.jsp").forward(request, response);
    }
}
