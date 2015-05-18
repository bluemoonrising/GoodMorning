package com.bluemoon.connect2server;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

/**
 * Created by skybl_000 on 2015/05/18.
 */
public class RankData {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

    String name;
    double time;
    Calendar cal;

    public RankData(String name, double time,String cal){
        this.name = name;
        this.time = time;
        this.cal = Calendar.getInstance();
        try {
            this.cal.setTime(sdf.parse(cal));
        }catch (Exception e)
        {

        }
    }

    public String getName(){
        return name;
    }

    public double getTime(){
        return time;
    }

    public int getPoint(){
        int point;
        point = 100 - (int)Math.round(time);
        if(point < 0)
        {
            point = 0;
        }
        return point;
    }

    public Calendar getCalender(){
        return cal;
    }

    public static List<RankData> TodayRank(List<RankData> list) {
        List<RankData> l = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        for(RankData d : list)
        {
            if(d.getCalender().get(Calendar.YEAR) == calendar.get(Calendar.YEAR) &&
               d.getCalender().get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
               d.getCalender().get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)){
                l.add(d);
            }

        }

        return l;
    }


}
