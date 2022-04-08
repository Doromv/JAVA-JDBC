package lesson04;

import lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author shkstart
 * @create 2022-01-09-20:20
 */
public class transaction01 {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con= JdbcUtils.getConnection();
            //关闭数据库的自动提交，并且自动会开启事务
            con.setAutoCommit(false);
            String sql1="update account set money=money-100 where name='A'";
            ps=con.prepareStatement(sql1);
            ps.executeUpdate();
            String sql2="update account set money=money+100 where name='B'";
            ps=con.prepareStatement(sql2);
            ps.executeUpdate();
            con.commit();
            System.out.println("转账成功！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            JdbcUtils.release(con,ps,rs);
        }
    }
}
