package com.text.receiverview.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private LinearLayoutManager LayoutManager;
    private GridLayoutManager LayoutManager2;
    private StaggeredGridLayoutManager LayoutManager3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        //
        String bond=getIntent().getStringExtra("bond");
        if("1".equals(bond)){
            LayoutManager=new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(LayoutManager);
            mRecyclerView.addItemDecoration(new DividerItemDecoratio(this,DividerItemDecoratio.VERTICAL_LIST));
        }else if("2".equals(bond)){
            //
            LayoutManager2=new GridLayoutManager(this,4);
            mRecyclerView.setLayoutManager(LayoutManager2);
            mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        }else if ("3".equals(bond)){
            LayoutManager3=new StaggeredGridLayoutManager(10,StaggeredGridLayoutManager.HORIZONTAL);
            mRecyclerView.setLayoutManager(LayoutManager3);
            mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        }else if ("4".equals(bond)){
            LayoutManager3=new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(LayoutManager3);
            mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        }

        mRecyclerView.setHasFixedSize(true);
        ArrayList<String> data=new ArrayList<String>();
        for (int i=0;i<=40;i++){
            data.add("条目"+i);
        }

        mRecyclerViewAdapter=new RecyclerViewAdapter(data);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        //设置监听
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.i("aa","单击的"+position);
                Toast.makeText(MainActivity.this,"单击的是"+position,Toast.LENGTH_LONG).show();

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));

    }
}
