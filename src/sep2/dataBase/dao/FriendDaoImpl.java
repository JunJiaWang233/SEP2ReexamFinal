package sep2.dataBase.dao;

import sep2.dataBase.dbUtil.DbUtil;
import sep2.dataBase.entity.Friend;

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
}
