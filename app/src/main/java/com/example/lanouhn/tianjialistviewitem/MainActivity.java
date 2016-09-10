package com.example.lanouhn.tianjialistviewitem;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * 改添加删除条目设置动画
 */
public class MainActivity extends Activity {

    private RecyclerView mRecyclerView;
    private Button btnAddItem;
    private Button btnDeleteItem;
    HomeAdapter honmeAdapter=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddItem = (Button) findViewById(R.id.btnAddItem);
        btnDeleteItem = (Button) findViewById(R.id.btnDeleteItem);
//      初始化RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
//        listView纵向滑动样子,纵向滑动
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
//      获取数据，向适配器传数据，绑定适配器
        ArrayList<String> datas = initData();
        honmeAdapter= new HomeAdapter(MainActivity.this, datas);
        mRecyclerView.setAdapter(honmeAdapter);
//      添加动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        myOnClick();


    }
     private int pos=2;
     private void myOnClick() {
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              添加自带默认动画
                if (pos>0){
                    honmeAdapter.addData(pos);
                }
              pos++;

            }
        });
//        btnDeleteItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////               删除自带默认动画
//                honmeAdapter.removeData(1);
//
//            }
//        });

    }

    /**
     * 编写一套假数据
     */
    protected ArrayList<String> initData() {
        ArrayList<String> mDatas = new ArrayList<String>();
        for (int i = 1; i <3; i++) {
            mDatas.add("我是条目" + i);
        }
        return mDatas;
    }

}
