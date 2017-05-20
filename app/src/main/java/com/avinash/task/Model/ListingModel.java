package com.avinash.task.Model;

import android.graphics.drawable.Drawable;

/**
 * Created by Nishu on 20-05-2017.
 */

public class ListingModel {
    String title,time,detail;
    Drawable drawable;

    public ListingModel(String title, String time, String detail, Drawable drawable) {
        this.title = title;
        this.time = time;
        this.detail = detail;
        this.drawable = drawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
