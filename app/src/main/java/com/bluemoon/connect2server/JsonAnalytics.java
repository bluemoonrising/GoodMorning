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
    final static private String TIME = "time";
    final static private String POINT = "point";

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
        double time = 0.;
        int point = 0;

        try {
            name = item.getString(NAME);
            time = item.getDouble(TIME);
            point = item.getInt(POINT);
        } catch (JSONException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

        return new RankData(name, time, point);
    }


}
