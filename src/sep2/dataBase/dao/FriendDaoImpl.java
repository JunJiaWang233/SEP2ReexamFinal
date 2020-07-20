package sep2.dataBase.dao;

import sep2.dataBase.dbUtil.DbUtil;
import sep2.dataBase.entity.Friend;
import sep2.dataBase.entity.User;
import sep2.dataBase.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FriendDaoImpl implements FriendDao{

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public int insertFriend(Friend friend) throws SQLException {
        int i= 0;
        connection= DbUtil.getConnection();
        String sql= "insert into friend values (?, ?, ?)";
        preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1, friend.getHashFriend());
        preparedStatement.setString(2, friend.getF1());
        preparedStatement.setString(3, friend.getF2());
        i = preparedStatement.executeUpdate();

        return i;
    }

    @Override
    public Friend selectFriendByHash(String f1, String f2) throws SQLException {
        Friend friend= null;
        connection= DbUtil.getConnection();
        String sql= "select * from friend where hashFriend= ?";
        preparedStatement= connection.prepareStatement(sql);
        int hashFriend= f1.hashCode()+ f2.hashCode();
        preparedStatement.setInt(1, hashFriend);
        resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            String f1d= resultSet.getString("f1");
            String f2d= resultSet.getString("f2");
            friend= new Friend(f1d, f2d);
        }
        return friend;
    }

    @Override
    public Users getFriendByEmail(String email) throws SQLException {
        Users users= new Users();
        connection= DbUtil.getConnection();
        String sql= "select * from friend where f1= ? or f2= ?";
        preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, email);
        resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            String f1 = resultSet.getString("f1");
            String f2= resultSet.getString("f2");
            String fEmail= "";
            if (email.equals(f1)){
                fEmail= f2;
            }else {
                fEmail= f1;
            }
            UserDao userDao= new UserDaoImpl();
            User user= userDao.getUserByEmailPhone(fEmail);
            users.addUser(user);

        }


        return users;
    }
}
