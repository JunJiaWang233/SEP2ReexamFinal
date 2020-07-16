package sep2.dataBase.dbUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtil {
    private static String mysqlDriver;
    private static String mysqlURL;
    private static String mysqlUser;
    private static String mysqlPassword;
    private static Connection connection;

    static {
        InputStream inputStream= DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties= new Properties();
        try {
            properties.load(inputStream);
            mysqlDriver= properties.getProperty("mysqlDriver");
            mysqlURL= properties.getProperty("mysqlURL");
            mysqlUser= properties.getProperty("mysqlUser");
            mysqlPassword= properties.getProperty("mysqlPassword");
            Class.forName(mysqlDriver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){
        try {
            connection= DriverManager.getConnection(mysqlURL, mysqlUser, mysqlPassword);
            return connection;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public static void closeAll(ResultSet resultSet, Statement statement, Connection connection){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
