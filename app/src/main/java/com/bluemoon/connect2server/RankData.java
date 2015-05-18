package com.bluemoon.connect2server;

/**
 * Created by skybl_000 on 2015/05/18.
 */
public class RankData {
    String name;
    double time;
    int point;

    public RankData(String name, double time, int point){
      this.name = name;
      this.time = time;
      this.point = point;
    }

    public String getName(){
        return name;
    }

    public double getTime(){
        return time;
    }

    public int getPoint(){
        return point;
    }
}
