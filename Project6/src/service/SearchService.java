package service;

import userdao.CartDao;
import userdao.ProductDao;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchService {
    public ArrayList<String> searchbycate(String[] categorys) {
        ProductDao dao = new ProductDao();
        ArrayList<String> info = new ArrayList<>();
        info = dao.searchbycate(categorys);
        System.out.println("view by categorys success");
        return info;
    }

    public ArrayList<String> addtocart(String[] ids,String[] qty,String aid) {
        CartDao dao = new CartDao();
        ArrayList<String> cartinfo =new ArrayList<>();
        cartinfo =dao.updatecart(ids,qty,aid);
        System.out.println("update the cart successfullly");
        return cartinfo;
    }

    public static void main(String[] args) {
        SearchService vs = new SearchService();
        String[] categorys= {"Personal Care","Household"};
        String[] ids= {"9001","9003"};
        String[] qty = {"3","","4"};
        String aid="3";
        String[] ii = {"9001"};
        String[] qty1 ={"1"};

        ArrayList r = vs.searchbycate(categorys);
        ArrayList c = vs.addtocart(ids,qty,aid);
        c.add(vs.addtocart(ii,qty1,aid));
        System.out.println(r);
    }
}

