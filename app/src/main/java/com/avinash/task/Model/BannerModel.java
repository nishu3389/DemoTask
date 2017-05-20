package com.avinash.task.Model;

import android.graphics.drawable.Drawable;

/**
 * Created by Nishu on 20-05-2017.
 */

public class BannerModel {
    String title1,title2;
    Drawable drawable;


    public BannerModel(String title1, String title2, Drawable drawable) {
        this.title1 = title1;
        this.title2 = title2;
        this.drawable = drawable;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }
}
