package sep2.dataBase.dao;

import sep2.dataBase.dbUtil.DateUtil;
import sep2.dataBase.dbUtil.DbUtil;
import sep2.dataBase.entity.User;
import sep2.dataBase.entity.constraints.Gender;

import java.sql.*;

public class UserDaoImpl implements UserDao{

    private Connection connection= null;
    private PreparedStatement preparedStatement= null;
    private ResultSet resultSet= null;


    @Override
    public int insertUser(User user) throws SQLException {
        connection= DbUtil.getConnection();
        String sql= "insert into user values (?,?,?,?,?,?)";
        try {
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getGender().toString());
            Timestamp createDate= DateUtil.getTimestamp();
            preparedStatement.setTimestamp(6, createDate);
            int i= preparedStatement.executeUpdate();
            return i;
        } finally {
            DbUtil.closeAll(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public User selectUserByEmailPhone(String emailPhone, String password) throws SQLException {
        connection= DbUtil.getConnection();
        User user= null;
        String sql= "select * from user where (email= ? or phone= ?) and password= ?";
        try {
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, emailPhone);
            preparedStatement.setString(2, emailPhone);
            preparedStatement.setString(3,password);
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                String username= resultSet.getString("username");
                String pw= resultSet.getString("password");
                String email= resultSet.getString("email");
                String phone= resultSet.getString("phone");
                String g= resultSet.getString("gender");
                Gender gender= Gender.valueOf(g);
                user= new User(username,pw,email,phone,gender);

            }
            return user;
        }finally {
            DbUtil.closeAll(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public User getUserByEmailPhone(String emailPhone) throws SQLException {
        connection= DbUtil.getConnection();
        User user= null;
        String sql= "select * from user where (email= ? or phone= ?) ";
        try {
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, emailPhone);
            preparedStatement.setString(2, emailPhone);
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                String username= resultSet.getString("username");
                String pw= resultSet.getString("password");
                String email= resultSet.getString("email");
                String phone= resultSet.getString("phone");
                String g= resultSet.getString("gender");
                Gender gender= Gender.valueOf(g);
                user= new User(username,pw,email,phone,gender);

            }
            return user;
        }finally {
            DbUtil.closeAll(resultSet, preparedStatement, connection);
        }
    }
}
