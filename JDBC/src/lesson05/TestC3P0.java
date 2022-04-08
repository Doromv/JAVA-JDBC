package lesson05;

import lesson05.utils.jdbcUtils_C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author shkstart
 * @create 2022-01-10-16:40
 */
public class TestC3P0 {
    public static void main(String[] args) {
    Connection con=null;
    PreparedStatement ps=null;
    try {
        con= jdbcUtils_C3P0.getConnection();
        String sql="delete from users where id=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,1);
        int i = ps.executeUpdate();
        if(i>0){
            System.out.println("删除成功");
        }
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }finally {
        jdbcUtils_C3P0.release(con,ps,null);
    }
}
}
