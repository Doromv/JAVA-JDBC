package lesson02;

import lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author shkstart
 * @create 2022-01-09-11:22
 */
public class select {
    public static void main(String[] args) {
        Connection con = null;
        Statement st=null;
        ResultSet rs=null;
        try {
            con = JdbcUtils.getConnection();
            st=con.createStatement();
            String sql="select * from users where id=1";
             rs = st.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getObject("NAME"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(con,st,rs);
        }
    }
}
