package org.springframework.nettyapplication.netty;

import com.nettyapplication.entity.Connection;
import com.nettyapplication.entity.URLRedirection;
import com.nettyapplication.entity.User;
import org.springframework.nettyapplication.mvc.MainService;
import org.springframework.nettyapplication.mvc.MainServiceImpl;

import java.util.Date;
import java.util.List;

/**
 * Created by Вадим on 17.08.2014.
 */
public class PrintStatus {

    MainService mainService = MainServiceImpl.getMainService();
    List<Connection> connectionList;
    List<User> userList;
    List<URLRedirection> urlRedirectionList;
    String result = "";

    public void getFirstAndSecondElement() {
        connectionList = mainService.getAllConnections();
        List<User> userList = mainService.getAllUsers();

        result = "<html><head><center><h1>Status</h1></center></head>"
                .concat("<p><center><table><tr><td><h3>Our total number of requests:</h3></td><td><h3>" + connectionList.size() + "</h3></td></tr></table></center></p>")
                .concat("<p><center><table><tr><td><h3>Our unique visitors:</h3></td><td><h3>" + userList.size() + "</h3></td></tr></table></center></p>")
                .concat("<p><center><h3>Requests counter by IP</h3></center></p>");
    }

    public void getThirdElement() {

        userList = mainService.getAllUsers();

        String ip;
        int count;
        Date date;

        result += "<p><center><table border=4><tr><td><center>    User IP address    </center></td><td><center>    Total connections   </center> </td><td><center>    Last connection    </center></td></tr>";

        for(User user : userList){
           ip = user.getUserIp();
           count = user.getUserConnections().size();
           date = new Date(user.getUserConnections().get(count - 1).getTimestamp());
            result += "<tr><td><center>" + ip + "</center></td><td><center>" + String.valueOf(count) + "</center></td><td><center>" + date.toString() + "</center></td></tr>";
        }

        result += "</table></center></p>";
    }

    public void getFourthElement() {

        urlRedirectionList = mainService.getAllURLRedirections();

        String url;
        int count;
        result += "<p><center><h3>Number of URL redirects</h3></center></p>";
        result += "<p><center><table border=4><tr><td><center>    URL    </center></td><td><center>    Number of redirects   </center> </td></tr>";

        for(URLRedirection urlRedirection : urlRedirectionList){
            url = urlRedirection.getUrl();
            count = urlRedirection.getCount();

            result += "<tr><td><center>" + url + "</center></td><td><center>" + String.valueOf(count) + "</center></td></tr>";
        }

        result += "</table></center></p>";
    }

    public void getFifthElement() {

        int activeConnections = mainService.getActiveConnections();
        result += "<p><center><table><tr><td><h3>Our active users at the moment:</h3></td><td><h3>" + activeConnections + "</h3></td></tr></table></center></p>";

    }

    public void getSixthElement() {

        connectionList = mainService.getAllConnections();

        String ip;
        String url;
        Date date;
        String sentBytes;
        String receivedBytes;
        int speed;
        int count = 0;

        result += "<p><center><h3>Our last requests</h3></center></p>";
        result += "<p><center><table border=4><tr><td><center>    IP address    </center></td>" +
                                         "<td><center>    URL address   </center> </td>" +
                                            "<td><center>    Time    </center></td>" +
                                           "<td><center>    Sent bytes    </center>" +
                                    "</td><td><center>    Received bytes    </center></td>" +
                                            "<td><center>    Speed    </center></td></tr>";

        for(Connection connection : connectionList){
            if (count == 16) break;
            count++;
            ip = connection.getUserIp();
            url = connection.getUrl();
            date = new Date(connection.getTimestamp());
            sentBytes = connection.getSentBytes();
            receivedBytes = connection.getReceivedBytes();
            speed = connection.getSpeed();

            result += "<tr><td><center>" + ip + "</center></td>" +
                    "<td><center>" + url + "</center></td>" +
                    "<td><center>" + date + "</center></td>" +
                    "<td><center>" + sentBytes + "</center>" +
                    "</td><td><center>" + receivedBytes + "</center></td>" +
                    "<td><center>" + speed + "</center></td></tr>";
        }

        result += "</table></center></p>";
    }

    public String getResult(){
        getFirstAndSecondElement();
        getThirdElement();
        getFourthElement();
        getFifthElement();
        getSixthElement();
        return result;
    }
}
