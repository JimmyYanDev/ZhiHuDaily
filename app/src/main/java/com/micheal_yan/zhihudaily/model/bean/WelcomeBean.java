package com.micheal_yan.zhihudaily.model.bean;

/**
 * Created by micheal-yan on 2017/2/19.
 */

public class WelcomeBean {

    private String imgUrl;
    private String who;

    public WelcomeBean() {
    }

    public WelcomeBean(String imgUrl, String who) {
        this.imgUrl = imgUrl;
        this.who = who;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
