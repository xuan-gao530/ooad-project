package service;

import entity.Product;
import entity.User;
import userdao.ProductDao;
import userdao.UserDao;

import java.util.ArrayList;


public class ViewStockService {
    public boolean checkstock(String productname) {
        ProductDao dao = new ProductDao();
        Product product = dao.viewproduct(productname);
        System.out.println(product);
        return product != null && productname.equals(product.getProductname()) ?true :false;
    }

    public ArrayList<String> getinfo(String productname) {
        ProductDao dao = new ProductDao();
        ArrayList<String> info = new ArrayList<>();
        info = dao.getproductinfo(productname);
        System.out.println("info success");
        return info;
    }

    public ArrayList getallinfo() {
        ProductDao dao = new ProductDao();
        ArrayList info = new ArrayList();
        info = dao.getallinfo();
        System.out.println("all info success");
        return info;
    }

    public static void main(String[] args) {
        ViewStockService vs = new ViewStockService();
        boolean flag =vs.checkstock("Shrimp");
        ArrayList result = vs.getallinfo();
        System.out.println(flag);
        System.out.println(result);
    }
}
