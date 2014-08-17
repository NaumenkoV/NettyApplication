package com.nettyapplication.entity;

/**
 * Created by Вадим on 16.08.2014.
 */

public class Connection  {

    private String userIp = "";

    private int connectionId;

    private String url = "";

    private long timestamp;

    private String sentBytes = "";

    private String receivedBytes = "";

    private int speed;

    public Connection() {
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public int getConnectionId() {
        return connectionId;
    }

    public String getUrl() {
        return url;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSentBytes() {
        return sentBytes;
    }

    public String getReceivedBytes() {
        return receivedBytes;
    }

    public int getSpeed() {
        return speed;
    }

    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setSentBytes(String sentBytes) {
        this.sentBytes = sentBytes;
    }

    public void setReceivedBytes(String receivedBytes) {
        this.receivedBytes = receivedBytes;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Connection)) return false;

        Connection that = (Connection) o;

        if (connectionId != that.connectionId) return false;
        if (Double.compare(that.timestamp, timestamp) != 0) return false;
        if (receivedBytes != null ? !receivedBytes.equals(that.receivedBytes) : that.receivedBytes != null)
            return false;
        if (sentBytes != null ? !sentBytes.equals(that.sentBytes) : that.sentBytes != null) return false;

        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (userIp != null ? !userIp.equals(that.userIp) : that.userIp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userIp != null ? userIp.hashCode() : 0;
        result = 31 * result + connectionId;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        temp = Double.doubleToLongBits(timestamp);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (sentBytes != null ? sentBytes.hashCode() : 0);
        result = 31 * result + (receivedBytes != null ? receivedBytes.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "userIp='" + userIp + '\'' +
                ", connectionId=" + connectionId +
                ", url='" + url + '\'' +
                ", timestamp=" + timestamp +
                ", sentBytes='" + sentBytes + '\'' +
                ", receivedBytes='" + receivedBytes + '\'' +
                ", speed='" + speed + '\'' +
                '}';
    }
}
