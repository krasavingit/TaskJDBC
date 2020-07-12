package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl checker = new UserDaoJDBCImpl();
    public void createUsersTable() throws SQLException {
        checker.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        checker.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        checker.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) throws SQLException {
        checker.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return checker.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        checker.cleanUsersTable();
    }
}
