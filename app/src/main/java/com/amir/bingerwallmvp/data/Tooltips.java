package com.amir.bingerwallmvp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amir on 3/19/17.
 */

public class Tooltips {

    @SerializedName("loading")
    @Expose
    private String loading;
    @SerializedName("previous")
    @Expose
    private String previous;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("walle")
    @Expose
    private String walle;
    @SerializedName("walls")
    @Expose
    private String walls;

    public String getLoading() {
        return loading;
    }

    public void setLoading(String loading) {
        this.loading = loading;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getWalle() {
        return walle;
    }

    public void setWalle(String walle) {
        this.walle = walle;
    }

    public String getWalls() {
        return walls;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }

}
