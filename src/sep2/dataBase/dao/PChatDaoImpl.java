package sep2.dataBase.dao;

import sep2.dataBase.dbUtil.DbUtil;
import sep2.dataBase.entity.PrivateChat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PChatDaoImpl implements PrivateChatDao{

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    @Override
    public PrivateChat selectPrivateChatByPK(String sender, String receiver) throws SQLException {
        PrivateChat privateChat= null;
        connection= DbUtil.getConnection();
        String sql= "select * from privateChat where sender= ? and receiver= ?";
        preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1, sender);
        preparedStatement.setString(2, receiver);
        resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            String s= resultSet.getString("sender");
            String r= resultSet.getString("receiver");
            privateChat= new PrivateChat(s, r);
        }
        return privateChat;
    }

    @Override
    public int insertPrivateChat(String sender, String receiver) throws SQLException {
        int i =0 ;
        connection= DbUtil.getConnection();
        String sql= "insert into privateChat values (?, ?)";
        preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1, sender);
        preparedStatement.setString(2, receiver);
        i= preparedStatement.executeUpdate();

        return i;
    }
}
