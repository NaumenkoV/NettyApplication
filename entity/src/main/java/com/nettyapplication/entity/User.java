package com.nettyapplication.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 16.08.2014.
 */

public class User implements Serializable {


    private String userIp = "";

    private List<Connection> userConnections = new ArrayList<Connection>();

    public String getUserIp() {
        return userIp;
    }

    public List<Connection> getUserConnections() {
        return userConnections;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public void setUserConnections(List<Connection> userConnections) {
        this.userConnections = userConnections;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (userConnections != null ? !userConnections.equals(user.userConnections) : user.userConnections != null)
            return false;
        if (userIp != null ? !userIp.equals(user.userIp) : user.userIp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userIp != null ? userIp.hashCode() : 0;
        result = 31 * result + (userConnections != null ? userConnections.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userIp='" + userIp + '\'' +
                ", userConnections=" + userConnections +
                '}';
    }
}
