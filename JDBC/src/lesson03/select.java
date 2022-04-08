package lesson03;

import lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author shkstart
 * @create 2022-01-09-19:42
 */
public class select {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con= JdbcUtils.getConnection();
            String sql="select * from users where id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,1);
             rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getObject("NAME"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(con,ps,null);
        }
    }
}
