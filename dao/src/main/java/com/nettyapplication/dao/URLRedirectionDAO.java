package com.nettyapplication.dao;

import com.nettyapplication.entity.URLRedirection;

import java.util.List;

/**
 * Created by Вадим on 16.08.2014.
 */
public interface URLRedirectionDAO {

    URLRedirection getURLRedirectionById(String id);
    void putURLRedirection(URLRedirection urlRedirection);
    void removeURLRedirectionById(String id);
    void updateURLRedirection(URLRedirection urlRedirection);
    List<URLRedirection> getAllURLRedirections();


}
