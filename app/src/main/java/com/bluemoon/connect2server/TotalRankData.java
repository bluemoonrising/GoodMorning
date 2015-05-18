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

        //��r���\�b�h�i�f�[�^�N���X���r����-1, 0, 1��Ԃ��悤�ɋL�q����j
        public int compare(TotalRankData a, TotalRankData b) {
            int no1 = a.getPoint();
            int no2 = b.getPoint();

            //��������ƎЈ��ԍ��̏����Ń\�[�g�����
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
