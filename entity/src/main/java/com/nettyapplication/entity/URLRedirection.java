package com.nettyapplication.entity;

/**
 * Created by Вадим on 16.08.2014.
 */

public class URLRedirection {

    private static final int COUNT_CONSTANT = 0;

    private String urlRedirectionId;

    private int count = COUNT_CONSTANT;

    private String url = "";

    public URLRedirection() {
    }

    public String getUrlRedirectionId() {
        return urlRedirectionId;
    }

    public int getCount() {
        return count;
    }

    public void setUrlRedirectionId(String urlRedirectionId) {
        this.urlRedirectionId = urlRedirectionId;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof URLRedirection)) return false;

        URLRedirection that = (URLRedirection) o;

        if (count != that.count) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (urlRedirectionId != null ? !urlRedirectionId.equals(that.urlRedirectionId) : that.urlRedirectionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = urlRedirectionId != null ? urlRedirectionId.hashCode() : 0;
        result = 31 * result + count;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "URLRedirection{" +
                "urlRedirectionId='" + urlRedirectionId + '\'' +
                ", count=" + count +
                ", url='" + url + '\'' +
                '}';
    }
}
