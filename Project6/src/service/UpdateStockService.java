package service;

import userdao.ProductDao;
import java.util.ArrayList;

public class UpdateStockService{
    public ArrayList<String> updateinfo(String[] ids, String[] options, String[] qty) {
        ProductDao dao = new ProductDao();
        ArrayList<String> info = new ArrayList<>();
        info = dao.updateproductinfo(ids, options, qty);
        System.out.println("update success");
        return info;
    }

    public static void main(String[] args) {
        UpdateStockService vs = new UpdateStockService();
        String[] ids= {"9001","9003"};
        String[] options = {"minus","add"};
        String[] qty = {"3","4"};
        ArrayList r = vs.updateinfo(ids,options,qty);
        System.out.println(r);
    }
}
