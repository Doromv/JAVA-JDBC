package lesson02;

import lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author shkstart
 * @create 2022-01-09-9:56
 */
public class insert {
    public static void main(String[] args) {
        Connection con = null;
        Statement st=null;
        ResultSet rs=null;
        try {
             con = JdbcUtils.getConnection();
             st=con.createStatement();
             String sql="insert into users(id,`NAME`,`PASSWORD`,`email`,`birthday`) values(4,'RGOD','123456','935863060@qq.com','2001-02-02')";
             int i=st.executeUpdate(sql);
             if(i>0){
                 System.out.println("插入成功");
             }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(con,st,rs);
        }
    }
}
