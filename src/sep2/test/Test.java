package sep2.test;

import sep2.dataBase.dao.UserDao;
import sep2.dataBase.dao.UserDaoImpl;
import sep2.dataBase.entity.User;
import sep2.dataBase.entity.constraints.Gender;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
       UserDao userDao= new UserDaoImpl();

        System.out.println( userDao.selectUserByEmailPhone("1", "test01"));
    }
}
