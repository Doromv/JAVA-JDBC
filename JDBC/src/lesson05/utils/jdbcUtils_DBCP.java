package lesson05.utils;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author shkstart
 * @create 2022-01-10-14:56
 */
public class jdbcUtils_DBCP {
    private static DataSource dataSource=null;
   static {
       try {
           Properties properties = new Properties();
           properties.load(jdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
           dataSource=BasicDataSourceFactory.createDataSource(properties);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   public static Connection getConnection() throws SQLException {
       return dataSource.getConnection();
   }
    public static void release(Connection con, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (con != null) {

            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
