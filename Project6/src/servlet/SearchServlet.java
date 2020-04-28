package servlet;

import service.SearchService;
import service.UpdateStockService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchServlet extends HttpServlet {
    String aid;
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] categorys= request.getParameterValues("category");
        String[] ids = request.getParameterValues("pid");
        String[] userid=request.getParameterValues("userid");
        String[] qty= request.getParameterValues("qty");
        String guest = request.getParameter("guest");
        List<String> info = new ArrayList<String>();
        List<String> cart = new ArrayList<>();
        if(guest!=null)
        {
            aid ="9";
        }

        else{aid = userid[0];}
        request.setAttribute("aid",aid);
        SearchService service = new SearchService();
        info = service.searchbycate(categorys);
        request.setAttribute("info", info);
        cart = service.addtocart(ids, qty, aid);
        request.setAttribute("cart", cart);
        if(aid.equals("9"))
        {
            String unregister ="guest";
            request.setAttribute("guest", unregister);
        }

        if(cart!=null){request.setAttribute("feedback","Adding to the cart successfully");}
        request.getRequestDispatcher("shopping.jsp").forward(request, response);
    }
}
