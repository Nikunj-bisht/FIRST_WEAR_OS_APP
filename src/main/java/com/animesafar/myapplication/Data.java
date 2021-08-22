package com.animesafar.myapplication;

import java.io.Serializable;

public class Data implements Serializable {

    private String title;
Data(String str){
    this.title = str;
}
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
