package org.springframework.nettyapplication.mvc;

import com.nettyapplication.entity.Connection;
import com.nettyapplication.entity.URLRedirection;
import com.nettyapplication.entity.User;

import java.util.List;

/**
 * Created by Вадим on 17.08.2014.
 */
public interface MainService {

    User getUserByIp(String userIp);
    void addActiveConnection();
    void deleteActiveConnection();
    int getActiveConnections();
    void addConnectionToUser(String userIp, Connection connection);
    List<User> getAllUsers();

    void addConnection(Connection connection);
    List<Connection> getAllConnections();

    void putURLRedirection(String url);
    List<URLRedirection> getAllURLRedirections();
}
