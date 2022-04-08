package lesson02;

import lesson02.utils.JdbcUtils;

import java.sql.*;

/**
 * @author shkstart
 * @create 2022-01-09-11:45
 */
public class SQL注入 {
    public static void main(String[] args) {
login("Doromv","123456");
    }
    public static void login(String username,String password){

            Connection con = null;
            PreparedStatement st=null;
            ResultSet rs=null;
            try {
                con = JdbcUtils.getConnection();
                String sql="select * from users where `NAME`=? and `PASSWORD`=?";
                st=con.prepareStatement(sql);
                st.setString(1,username);
                st.setString(2,password);
                 rs=st.executeQuery();
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

