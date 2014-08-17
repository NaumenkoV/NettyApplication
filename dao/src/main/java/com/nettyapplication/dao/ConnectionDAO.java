package com.nettyapplication.dao;

import com.nettyapplication.entity.Connection;

import java.util.List;

/**
 * Created by Вадим on 16.08.2014.
 */
public interface ConnectionDAO {

    Connection getConnectionById(int connectionId);
    void updateConnection(Connection connection);
    List<Connection> getAllConnections();
    void addConnection(Connection connection);
}
