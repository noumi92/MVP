package com.noumi.mvp.data;

public class News {
    private String mTitle, mIntro;

    public News() {
    }

    public News(String title, String intro) {
        mTitle = title;
        mIntro = intro;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getIntro() {
        return mIntro;
    }

    public void setIntro(String intro) {
        mIntro = intro;
    }
}
