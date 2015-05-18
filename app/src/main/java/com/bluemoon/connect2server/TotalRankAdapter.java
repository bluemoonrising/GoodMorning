package com.bluemoon.connect2server;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by skybl_000 on 2015/05/18.
 */

public class TotalRankAdapter extends ArrayAdapter<TotalRankData> {
    static class ViewHolder {
        TextView nameTextView;
        TextView timeTextView;
    }

    private LayoutInflater inflater;

    public TotalRankAdapter(Context context, int resource, List<TotalRankData> objects) {
        super(context, resource, objects);
        // TODO 自動生成されたコンストラクター・スタブ
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View view = convertView;

        if (view == null) {
            inflater = (LayoutInflater) getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.rankitem, null);
            holder = new ViewHolder();

            holder.nameTextView = (TextView) view.findViewById(R.id.name_item);
            holder.timeTextView = (TextView) view.findViewById(R.id.result_item);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        // 特定の行のデータを取得

        TotalRankData item = getItem(position);
        holder.nameTextView.setText((position + 1)+"位 名前"+item.getName());
        holder.timeTextView.setText(String.valueOf(item.getPoint()+"ポイント")); //setTextにint型を渡すとResources$NotFoundException

        return view;

    }
}
