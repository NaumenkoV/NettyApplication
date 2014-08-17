package com.nettyapplication.dao.impl;

import com.nettyapplication.dao.ConnectionDAO;
import com.nettyapplication.entity.Connection;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 16.08.2014.
 */
@Repository
public class ConnectionDAOImpl implements ConnectionDAO {

    private static ConnectionDAO connectionDAO= new ConnectionDAOImpl();

    public ConnectionDAOImpl() {
    }

    public static ConnectionDAO getConnectionDAO(){
        return connectionDAO;
    }

    List<Connection> connectionList = new ArrayList<Connection>();

    @Override
    public Connection getConnectionById(int connectionId) {
        Connection connectionForReturn = null;
        for (Connection connection : connectionList){
            if (connection.getConnectionId() == connectionId) connectionForReturn = connection;
        }
        return connectionForReturn;
    }

    @Override
    public void updateConnection(Connection connection) {
        for (int i = 0; i < connectionList.size(); i++){
            if (connectionList.get(i).getConnectionId() == (connection.getConnectionId())) connectionList.set(i, connection);
        }
    }

    @Override
    public List<Connection> getAllConnections() {
        return connectionList;
    }

    @Override
    public void addConnection(Connection connection) {
        connection.setConnectionId(connectionList.size());
        connectionList.add(connection);

    }
}
