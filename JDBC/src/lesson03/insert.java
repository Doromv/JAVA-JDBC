package lesson03;

import lesson02.utils.JdbcUtils;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author shkstart
 * @create 2022-01-09-18:57
 */
public class insert {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con= JdbcUtils.getConnection();
            String sql="insert into users(id,`NAME`,`PASSWORD`,`email`,`birthday`) values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1,4);
            ps.setString(2,"Doromv");
            ps.setString(3,"123456");
            ps.setString(4,"DoromvQAQ@163.com");
            ps.setDate(5,new java.sql.Date(new java.util.Date().getTime()));
            int i = ps.executeUpdate();
            if(i>0){
                System.out.println("插入成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(con,ps,null);
        }

    }
}
