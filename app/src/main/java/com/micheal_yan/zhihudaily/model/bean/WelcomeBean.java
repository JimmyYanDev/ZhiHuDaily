package com.micheal_yan.zhihudaily.model.bean;

/**
 * Created by micheal-yan on 2017/2/19.
 */

public class WelcomeBean {

    private String imgUrl;
    private String text;

    public WelcomeBean() {
    }

    public WelcomeBean(String imgUrl, String text) {
        this.imgUrl = imgUrl;
        this.text = text;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
