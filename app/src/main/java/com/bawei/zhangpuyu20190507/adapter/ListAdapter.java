package com.bawei.zhangpuyu20190507.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.zhangpuyu20190507.R;
import com.bawei.zhangpuyu20190507.bean.Bean;
import com.bumptech.glide.Glide;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<Bean.ResultBean> list;

    public ListAdapter(Context context, List<Bean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.list_layout,null);
            viewHolder.imageViews = convertView.findViewById(R.id.images);
            viewHolder.textViews = convertView.findViewById(R.id.texts);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getImageUrl()).into(viewHolder.imageViews);
        viewHolder.textViews.setText(list.get(position).getSummary());
        return convertView;
    }

    class ViewHolder{
        ImageView imageViews;
        TextView textViews;
    }

}
