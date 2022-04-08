package lesson05;

import lesson02.utils.JdbcUtils;
import lesson05.utils.jdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author shkstart
 * @create 2022-01-10-14:55
 */
public class TesrDBCP {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con= jdbcUtils_DBCP.getConnection();
            String sql="delete from users where id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,2);
            int i = ps.executeUpdate();
            if(i>0){
                System.out.println("删除成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
           jdbcUtils_DBCP.release(con,ps,null);
        }
    }
}
