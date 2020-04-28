package userdao;

import entity.Product;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDao {
    public void updateorder_records(ArrayList info) {
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();
        ResultSet rs = null;

        String sqlStr;
        // Process each of the rpoducts
        for (int i = 0; i < info.size(); i = i + 6) {
            sqlStr = "Insert INTO order_records (aid,pid,category,name,qty,price) VALUES(" + info.get(i + 5)
                    + "," + info.get(i) + ",'"
                    + info.get(i + 1) + "','"
                    + info.get(i + 2) + "',"
                    + info.get(i + 3) + ","
                    + info.get(i + 4) + ")";
            db.update(sqlStr);
        }
    }

    public ArrayList<String> getorderbyuser(String userid) {
        String sql = "select *from order_records where FIND_IN_SET('"+userid+"',aid)";
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();
        ResultSet rs =null;
        ArrayList<String> result = new ArrayList<>();
        rs = db.query(sql);
        try{
            while (rs.next()) {
                result.add(rs.getString(1));
                result.add(rs.getString(2));
                result.add(rs.getString(3));
                result.add(rs.getString(4));
                result.add(rs.getString(5));
                result.add(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConn();
        }
        return result;
    }

    public ArrayList getallorder() {
        String sql = "select *from order_records";
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();
        ResultSet rs = null;
        ArrayList result = new ArrayList();
        rs = db.query(sql);
        try{
            while(rs.next())
            {
                result.add(rs.getInt("aid"));
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

}
