package com.winning.rims.tabtest.tst;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.winning.rims.tabtest.R;

import java.util.ArrayList;

/**
 * https://blog.csdn.net/jiangtea/article/details/54897831
 * 描述: 底部弹框样式adapter
 * 作者|时间: djj on 2018/9/10 16:33
 * 博客地址: http://www.jianshu.com/u/dfbde65a03fc
 */

public class StyleAdapter extends BaseAdapter {

    private Context mContext;

    private ArrayList<StyleItem> mList;

    public StyleAdapter(Context context, ArrayList<StyleItem> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public StyleItem getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_dialog_style, null);
            holder = new ViewHolder();
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_item_dialog_name);
            holder.tvCount = (TextView) convertView.findViewById(R.id.tv_count);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        StyleItem item = getItem(position);
        holder.tvName.setText(item.getName());
        holder.tvCount.setText("已预约数量：6");

        return convertView;
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvCount;
    }
}
