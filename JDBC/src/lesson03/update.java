package lesson03;

import lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author shkstart
 * @create 2022-01-09-19:34
 */
public class update {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con= JdbcUtils.getConnection();
            String sql="update users set `NAME`=? where id=? ";
            ps=con.prepareStatement(sql);
            ps.setInt(2,1);
            ps.setString(1,"Doromv");
            int i = ps.executeUpdate();
            if(i>0){
                System.out.println("更新成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(con,ps,null);
        }
    }
}
