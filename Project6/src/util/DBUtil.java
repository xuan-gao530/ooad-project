package util;
import java.sql.*;

public class DBUtil {
    private static final String URL="jdbc:mysql://localhost:3306/market?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private static final String NAME="xuan";
    private static final String PASSWORD="serafina530";

    Connection conn = null;
    Statement st = null;
    ResultSet result =null;

    public Connection getConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
            System.out.println("Connecting mysql successfully");
            return this.conn;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DBUtil(){
        this.conn = this.getConnection();
    }

     //query the database
    public ResultSet query(String sql)
    {
        try {
            st = conn.createStatement();
            result = st.executeQuery(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    // update the database
    public void update(String sql)
    {
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void reset(String s1,String s2)
    {
        try {
            st = conn.createStatement();
            st.execute(s1);
            st.execute(s2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeConn() {
        try {
            if(result != null) result.close();
            if(st != null) st.close();
            if(conn!= null) conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        DBUtil db = new DBUtil();
        System.out.println(db.getConnection());
        System.out.println(db.query("select *from products"));

    }
}
