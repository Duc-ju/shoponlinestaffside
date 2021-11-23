package logicapplication.baseDAO;

import java.sql.Connection;
import java.util.List;
import databaseconfig.ConnectDB;
import java.sql.Connection;

import databaseconfig.ConnectDB;

public interface BaseDAO<T> {
    Connection con = ConnectDB.openConnect();
    List<T> getAll();

    T get(int id);

    int add(T t);

    void update(T t);

    void delete(T t);

}