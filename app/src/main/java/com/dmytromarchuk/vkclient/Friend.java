package com.dmytromarchuk.vkclient;

/**
 * Created by Dmytro on 10.11.2015.
 */
public class Friend {
    String flName;
    String UrlAvatar;

    public Friend(String _flname, String _avatar) {
        flName = _flname;
        UrlAvatar = _avatar;
    }

    public String getUrlAvatar() {
        return UrlAvatar;
    }

    public String getFlName() {
        return flName;
    }
}
