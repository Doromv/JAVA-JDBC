package lesson02;

import lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author shkstart
 * @create 2022-01-09-11:18
 */
public class update {
    public static void main(String[] args) {
        Connection con = null;
        Statement st=null;
        ResultSet rs=null;
        try {
            con = JdbcUtils.getConnection();
            st=con.createStatement();
            String sql="update users set `NAME`='RGOD' where id=1 ";
            int i=st.executeUpdate(sql);
            if(i>0){
                System.out.println("更新成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(con,st,rs);
        }
    }
}
