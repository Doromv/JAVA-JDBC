package lesson01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author shkstart
 * @create 2022-01-08-19:21
 */
public class JDBCfirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.用户信息和url
        String url="jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username="root";
        String password="QAQm..02r";
        //3.连接成功，数据库对象
        Connection con=DriverManager.getConnection(url,username,password);
        //4.执行SQL的对象 statement执行sql的对象
        Statement statement=con.createStatement();
        //5.执行SQL的对象 去执行SQL，可能存在结果，查看返回结果
        String sql="select * from users";
        ResultSet resultSet = statement.executeQuery(sql);// 返回的结果集封装了我们全部的查询结果
        while (resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("NAME"));
            System.out.println("pwd="+resultSet.getObject("PASSWORD"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birthday="+resultSet.getObject("birthday"));
            System.out.println("==========================");
        }
        //6.释放连接
        resultSet.close();
        statement.close();
        con.close();
    }
}
