package service;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import userdao.CartDao;
import userdao.OrderDao;

import java.util.ArrayList;

public class OrderService {
    public ArrayList viewcart() {
        CartDao dao = new CartDao();
        ArrayList info = new ArrayList();
        info = dao.getcartinfo();
        System.out.println("view the cart");
        return info;
    }
    public void clearcart() {
        CartDao dao =new CartDao();
        dao.clearcart();
    }

    public void updateorder(ArrayList info) {
        OrderDao dao =new OrderDao();
        dao.updateorder_records(info);
    }

    public ArrayList vieworderbyuser(String userid) {
        OrderDao dao = new OrderDao();
        ArrayList info = new ArrayList();
        info = dao.getorderbyuser(userid);
        System.out.println("view the order by user");
        return info;
    }

    public ArrayList vieworder() {
        OrderDao dao = new OrderDao();
        ArrayList info = new ArrayList();
        info = dao.getallorder();
        System.out.println("view all the order_records");
        return info;
    }



    public static void main(String[] args) {
        OrderService vs = new OrderService();
        String[] categorys= {"Personal Care","Household"};
        String[] ids= {"9001","9003"};
        String[] qty = {"3","","4"};
        String aid="3";
        String[] ii = {"9001"};
        String[] qty1 ={"1"};
        SearchService ss = new SearchService();
        ArrayList d =ss.addtocart(ids,qty,aid);
        ArrayList c = vs.viewcart();
        System.out.println(c);
        vs.updateorder(c);
        vs.clearcart();
    }
}
