package com.nettyapplication.dao.impl;

import com.nettyapplication.dao.URLRedirectionDAO;
import com.nettyapplication.entity.URLRedirection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 16.08.2014.
 */

public class URLRedirectionImpl implements URLRedirectionDAO {

    private static URLRedirectionDAO urlRedirectionDAO = new URLRedirectionImpl();

    public URLRedirectionImpl() {
    }

    public static URLRedirectionDAO getURLRedirection(){
        return urlRedirectionDAO;
    }

    List<URLRedirection> urlRedirectionList = new ArrayList<URLRedirection>();


    @Override
    public URLRedirection getURLRedirectionById(String id) {
        for (URLRedirection urlRedirection : urlRedirectionList){
            if (urlRedirection.getUrlRedirectionId().equals(id)) return urlRedirection;
        }
        return null;
    }

    @Override
    public void putURLRedirection(URLRedirection urlRedirection) {
        urlRedirection.setUrlRedirectionId(String.valueOf(urlRedirectionList.size()));
        urlRedirectionList.add(urlRedirection);
    }

    @Override
    public void removeURLRedirectionById(String id) {
        for (URLRedirection urlRedirection : urlRedirectionList){
            if (urlRedirection.getUrlRedirectionId().equals(id)) urlRedirectionList.remove(id);
        }
    }

    @Override
    public void updateURLRedirection(URLRedirection urlRedirection) {
        urlRedirectionList.set(Integer.valueOf(urlRedirection.getUrlRedirectionId()), urlRedirection);
    }

    @Override
    public List<URLRedirection> getAllURLRedirections() {
        return urlRedirectionList;
    }
}
