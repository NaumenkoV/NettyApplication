package org.springframework.nettyapplication.mvc;

import com.nettyapplication.dao.ConnectionDAO;
import com.nettyapplication.dao.URLRedirectionDAO;
import com.nettyapplication.dao.UserDAO;
import com.nettyapplication.dao.impl.ConnectionDAOImpl;
import com.nettyapplication.dao.impl.URLRedirectionImpl;
import com.nettyapplication.dao.impl.UserDAOImpl;
import com.nettyapplication.entity.Connection;
import com.nettyapplication.entity.URLRedirection;
import com.nettyapplication.entity.User;

import java.util.List;

/**
 * Created by Вадим on 17.08.2014.
 */

public class MainServiceImpl implements MainService {

    private static MainService mainService = new MainServiceImpl();

    private MainServiceImpl() {
    }

    public static MainService getMainService(){
        return mainService;
    }

    private int connectionsCount = -1;

    UserDAO userDAO = UserDAOImpl.getUserDAO();

    URLRedirectionDAO urlRedirectionDAO = URLRedirectionImpl.getURLRedirection();

    ConnectionDAO connectionDAO = ConnectionDAOImpl.getConnectionDAO();

    @Override
    public User getUserByIp(String userIp) {
        User user = userDAO.getUserByIp(userIp);
        if (user == null){
            user = new User();
            user.setUserIp(userIp);
            userDAO.putUser(user);
        }
        return user;
    }

    @Override
    public void addActiveConnection() {
       connectionsCount++;
    }

    @Override
    public void deleteActiveConnection() {
      connectionsCount--;
    }

    @Override
    public int getActiveConnections() {
        return connectionsCount;
    }

    @Override
    public void addConnectionToUser(String userIp, Connection connection) {
        User user = getUserByIp(userIp);
        user.getUserConnections().add(connection);
        userDAO.updateUser(user);
    }

    @Override
    public void addConnection(Connection connection) {
        connectionDAO.addConnection(connection);
    }

    @Override
    public List<Connection> getAllConnections() {
        return connectionDAO.getAllConnections();
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void putURLRedirection(String url) {

        boolean found = false;
        URLRedirection urlRedirection;

        List<URLRedirection> allUrlRedirections = urlRedirectionDAO.getAllURLRedirections();
        for (URLRedirection urlRedirection1 : allUrlRedirections){
            if (urlRedirection1.getUrl().equals(url)) {
                urlRedirection = urlRedirection1;
                urlRedirection.setCount(urlRedirection1.getCount() + 1);
                urlRedirectionDAO.updateURLRedirection(urlRedirection);
                found = true;
            }
        }
        if (!found){
            urlRedirection = new URLRedirection();
            urlRedirection.setUrl(url);
            urlRedirection.setCount(1);
            urlRedirection.setUrlRedirectionId(url);
            urlRedirectionDAO.putURLRedirection(urlRedirection);
        }
    }

    @Override
    public List<URLRedirection> getAllURLRedirections() {
        return urlRedirectionDAO.getAllURLRedirections();
    }
}
