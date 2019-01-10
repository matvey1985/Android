package com.example.matvey.kotlintestapp;

public class Notice {


    int userid;
    String date, notice;

    public void setId(int id)
    {
        this.userid =id;
    }

    public int getId()
    {
        return this.userid;
    }

    public void setDate(String date)
    {
        this.date= date;
    }
    public String getDate()
    {
        return this.date;
    }

    public void setNotice(String notice)
    {
        this.notice= notice;
    }
    public String getNotice()
    {
        return this.notice;
    }
}
