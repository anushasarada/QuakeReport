package com.example.android.quakereport;

/**
 * Created by sarada on 1/23/2018.
 */

public class Earthquake {

    private String place,url;
    private double mag;
    private long timeInMilliSec;

    public Earthquake(Double emag, String eplace, long etimeInMilliSec, String eurl)
    {
        mag = emag;
        place = eplace;
        timeInMilliSec = etimeInMilliSec;
        url = eurl;
    }

    public Double getMag() {
        return mag;
    }

    public String getPlace() {
        return place;
    }

    public long getDate() {
        return timeInMilliSec;
    }

    public String getUrl() {
        return url;
    }

}
