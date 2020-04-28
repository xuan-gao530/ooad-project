package userdao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.Product;
import util.DBUtil;

public class ProductDao {
    public Product viewproduct(String productname) {
        String sql = "select *from products where name =?";
        DBUtil db = new DBUtil();
        Connection conn =db.getConnection();
        ResultSet rs = null;
        Product product = new Product();
        try {
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1,productname);
            rs = ps.executeQuery();
            if(rs.next()) {
                product.setProductid(rs.getInt(1));
                product.setCategory(rs.getString(2));
                product.setProductname(rs.getString(3));
                product.setQty(rs.getInt(4));
                product.setPrice(rs.getFloat(5));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            db.closeConn();
        }
        return product;
    }

    public ArrayList<String> getproductinfo(String productname) {
        String sql = "select *from products where name = ?";
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();
        ResultSet rs = null;
        Product product = new Product();
        ArrayList<String> result = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productname);
            rs = ps.executeQuery();
            if (rs.next()) {
                result.add(rs.getString(1));
                result.add(rs.getString(2));
                result.add(rs.getString(3));
                result.add(rs.getString(4));
                result.add(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConn();
        }
        return result;
    }

    public ArrayList getallinfo() {
        String sql = "select *from products";
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();
        ResultSet rs = null;
        ArrayList result = new ArrayList();
        rs = db.query(sql);
        try{
            while(rs.next())
            {
                result.add(rs.getInt("pid"));
                result.add(rs.getString("category"));
                result.add(rs.getString("name"));
                result.add(rs.getInt("qty"));
                result.add(rs.getFloat("price"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            db.closeConn();
        }
        return result;
    }

    public ArrayList updateproductinfo(String[] ids,String[] options,String[] qty) {
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();
        ResultSet rs = null;
        int size = ids.length;
        options= processsarray(options);
        qty= processsarray(qty);

        ArrayList result = new ArrayList();
        if (ids != null) {
            String sqlStr;
            // Process each of the rpoducts
            for (int i = 0; i < ids.length; ++i) {
                // Update the qty of the table products
                if(options[i].equals("add"))
                {
                    sqlStr = "UPDATE products SET qty = qty +"+qty[i]+" WHERE pid = " + ids[i];
                    db.update(sqlStr);
                    result.add(sqlStr);
                }
                else if(options[i].equals("minus"))
                {
                    sqlStr = "UPDATE products SET qty = qty -"+qty[i]+" WHERE pid = " + ids[i];
                    db.update(sqlStr);
                    result.add(sqlStr);
                }
                else
                {
                    result.add("option is invalid");
                }
                }

        }
        return result;

    }

    public ArrayList searchbycate(String[] categorys) {
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();
        ResultSet rs = null;
        ArrayList result = new ArrayList();
        if (categorys == null) {
            return null;
        }
        String sqlStr = "SELECT * FROM products WHERE category IN (";
        for (int i = 0; i < categorys.length; ++i) {
            if (i < categorys.length - 1) {
                sqlStr += "'" + categorys[i] + "', ";  // need a commas
            } else {
                sqlStr += "'" + categorys[i] + "'";    // no commas
            }
        }
        sqlStr += ")";
        rs =  db.query(sqlStr);
        try{
            while(rs.next())
            {
                result.add(rs.getInt("pid"));
                result.add(rs.getString("category"));
                result.add(rs.getString("name"));
                result.add(rs.getInt("qty"));
                result.add(rs.getFloat("price"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            db.closeConn();
        }
        return result;
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
        ProductDao dao = new ProductDao();
        Product i =dao.viewproduct("Shri");
        System.out.println(i.getProductname());
        //System.out.println(dao.getallinfo());
        String[] ids= {"9001","9003"};
        String[] options = {"add","","minus"};
        String[] qty = {"3","4"};
        String[] categorys={"Beverage","Food"};
        ArrayList r = dao.updateproductinfo(ids,options,qty);
        ArrayList es =dao.searchbycate(categorys);
        System.out.println(r);
        System.out.println(es);

    }
}
