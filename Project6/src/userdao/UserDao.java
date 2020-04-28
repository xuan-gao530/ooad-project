package userdao;
import java.sql.*;
import java.util.ArrayList;

import entity.User;
import util.DBUtil;

public class UserDao {
    public User findUserByName(String username) {
        String sql = "select *from accounts where username = ?";
        DBUtil db = new DBUtil();
        Connection conn =db.getConnection();
        ResultSet rs = null;
        User user = new User();
        try {
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if(rs.next()) {
                user.setUsername(rs.getString(3));
                user.setPassword(rs.getString(4));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            db.closeConn();
        }
        return user;
    }

    public ArrayList<String> getuserinfo(String username) {
        String sql = "select *from accounts where username = ?";
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();
        ResultSet rs = null;
        User user = new User();
        ArrayList<String> result = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                result.add(rs.getString(1));
                result.add(rs.getString(2));
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

    public static void main(String[] args) {
        UserDao dao = new UserDao();
        User i =dao.findUserByName("Rachel");
        ArrayList<String> r = new ArrayList<>();
        r = dao.getuserinfo(i.getUsername());
        System.out.println(i.getUsername());
        System.out.println(r);
    }
}
