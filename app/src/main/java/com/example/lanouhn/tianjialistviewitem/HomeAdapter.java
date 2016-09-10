package com.example.lanouhn.tianjialistviewitem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by lanouhn on 2016/9/10.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> list;

    public HomeAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_home, parent,
                false));

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv.setText(list.get(position));
        holder.shanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeData(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

   private String pos;
    //  添加数据
    public void addData(int position) {
//      在list中添加数据，并通知条目加入一条
         pos= String.valueOf((position+1));
        list.add(position, "添加的"+pos);
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        if (position>0){
            list.remove(position);
            notifyItemRemoved(position);
        }else {
            Toast.makeText(context, "这是第一条数据，不可删除呦", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * ViewHolder的类，用于缓存控件
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        TextView shanchu;
        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
            shanchu= (TextView) view.findViewById(R.id.shanchu);
        }


    }

}