package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        UserDaoJDBCImpl u1 = new UserDaoJDBCImpl();
        u1.createUsersTable();
        u1.saveUser("Vasya","Pupkin",(byte)22);
        u1.saveUser("Petr","Geter",(byte)44);
        u1.saveUser("Ivan","Seter",(byte)33);
        u1.saveUser("test","test",(byte)1);
        for (User user : u1.getAllUsers()) {
            System.out.println(user.toString());
        }
        u1.cleanUsersTable();
        u1.dropUsersTable();

    }
}
