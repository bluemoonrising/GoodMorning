package com.bluemoon.connect2server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skybl_000 on 2015/05/18.
 */
public class JsonAnalytics {
    final static private String NAME = "name";
    final static private String SEC = "sec";
    final static private String TIME = "time";

    static public List<RankData> analysisSearchResult(JSONArray result)
    {
        List<RankData> list = new ArrayList<RankData>();

        for(int i = 0; i < result.length(); i++)
        {
            try {
                JSONObject jsonObject = result.getJSONObject(i);
                RankData rankData = analysisEntry(jsonObject);
                list.add(rankData);
            } catch (JSONException e) {
                // TODO 自動生成された catch ブロック
                e.printStackTrace();
            }
        }
        return list;
    }

    static private RankData analysisEntry(JSONObject item)
    {
        String name = "";
        double sec = 0.;
        String time = "";

        try {
            name = item.getString(NAME);
            sec = item.getDouble(SEC);
            time = item.getString(TIME);
        } catch (JSONException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

        return new RankData(name, sec, time);
    }


}
