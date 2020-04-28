package userdao;
import entity.Product;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartDao {
    public ArrayList updatecart(String[] ids,String[] qty,String aid) {
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();
        ResultSet rs = null;
        ResultSet ps =null;

        ArrayList result = new ArrayList();
        if (ids == null) {
            return null;
        }
        String sqlStr;
        qty= processsarray(qty);
        ArrayList<String> category =new ArrayList<>();
        ArrayList<String>name =new ArrayList<>();
        ArrayList<String>price =new ArrayList<>();;

        // Process each of the rpoducts
        for(int j =0;j<ids.length;j++) {
            sqlStr="select *from products where pid="+ids[j];
            ps = db.query(sqlStr);
            try{
                while(ps.next()) {
                    category.add(ps.getString("category"));
                    name.add(ps.getString("name"));
                    price.add(ps.getString("price"));
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < ids.length; i++) {
            sqlStr = "select *from cart_records where pid=" + ids[i];
            rs = db.query(sqlStr);
            try {
                if (rs.next()) {
                    sqlStr = "UPDATE cart_records SET qty_incart = qty_incart +" + qty[i] + " WHERE pid = " + ids[i];
                } else {
                    sqlStr = "Insert INTO cart_records (pid,category,name,qty_incart,price,aid) VALUES(" + ids[i] + ",'" +category.get(i)+"','"+name.get(i)+"'," + qty[i] + ","+price.get(i) +","+ aid + ")";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
                    // Update the qty of the table products
            db.update(sqlStr);
            result.add(sqlStr);
            }
        return result;
    }

    public ArrayList getcartinfo() {
        String sql = "select *from cart_records";
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();
        ResultSet rs = null;
        ArrayList result = new ArrayList();
        rs = db.query(sql);
        try{
            while(rs.next())
            {
                result.add(rs.getString("pid"));
                result.add(rs.getString("category"));
                result.add(rs.getString("name"));
                result.add(rs.getString("qty_incart"));
                result.add(rs.getString("price"));
                result.add(rs.getString("aid"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            db.closeConn();
        }
        return result;
    }

    public void clearcart() {
        String s1 = "drop table if exists cart_records;";
        String s2 = "create table cart_records (pid int,category varchar(50),name varchar(50),qty_incart int,price float,aid int,primary key(pid));";
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();
        db.reset(s1,s2);
        db.closeConn();
    }

    public String[] processsarray(String[] oldarry) {
        List<String> strList= Arrays.asList(oldarry);
        List<String> strListNew=new ArrayList<>();
        for (int i = 0; i <strList.size(); i++) {
            if (strList.get(i)!=null&&!strList.get(i).equals("")){
                strListNew.add(strList.get(i));
            }
        }
        String[] newarray = strListNew.toArray(new String[strListNew.size()]);
        return newarray;
    }

    public static void main(String[] args) {
        CartDao dao = new CartDao();
        String[] ids= {"9001","9003"};
        String[] qty = {"3","","4"};
        String aid="3";
        String[] ii = {"9001"};
        String[] qty1 ={"1"};
        ArrayList r;
        r=dao.updatecart(ids,qty,aid);
        dao.clearcart();
        System.out.println(r);
    }
}
