package com.bluemoon.connect2server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by skybl_000 on 2015/05/18.
 */
public class TotalRankData {
    String name;
    int point;

    public TotalRankData(RankData rd)
    {
        this.name = rd.name;
        this.point = rd.getPoint();
    }

    public String getName(){
        return name;
    }

    public void addPoint(int p)
    {
        point += p;
    }

    public int getPoint()
    {
        return point;
    }

    public static List<TotalRankData> RankToTotal(List<RankData> list){
        ArrayList<TotalRankData> tlist = new ArrayList<>();

        for(RankData rd : list){
            boolean f = false;
            for(TotalRankData tr : tlist)
            {
                if(tr.getName().compareTo(rd.getName()) == 0){
                    f = true;
                    tr.addPoint(rd.getPoint());
                    break;
                }
            }
            if(f == false)
            {
                tlist.add(new TotalRankData(rd));
            }
        }
        Collections.sort(tlist,new MyComparator());
        return tlist;
    }

    static class MyComparator implements Comparator<TotalRankData> {

        //比較メソッド（データクラスを比較して-1, 0, 1を返すように記述する）
        public int compare(TotalRankData a, TotalRankData b) {
            int no1 = a.getPoint();
            int no2 = b.getPoint();

            //こうすると社員番号の昇順でソートされる
            if (no1 > no2) {
                return -1;

            } else if (no1 == no2) {
                return 0;

            } else {
                return 1;

            }
        }

    }
}
