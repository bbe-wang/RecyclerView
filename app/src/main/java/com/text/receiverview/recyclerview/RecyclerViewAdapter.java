package com.text.receiverview.recyclerview;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2016/9/9.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private ArrayList<String> data;

    public  RecyclerViewAdapter(ArrayList<String> data){
        this.data=data;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //ViewGroup必须设置  不然item的高度设置match_parent无效
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        ViewHolder Vh=new ViewHolder(view);
        return Vh;
    }


    //数据绑定的地方
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (data.size()>0){
            holder.tv.setText(data.get(position));
            holder.root.setBackgroundColor(generateBeautifulColor());

        }
    }


    /**
     * 获取十六进制的颜色代码.例如  "#6E36B4" , For HTML ,
     * @return String
     */
    public static String getRandColorCode(){
        String r,g,b;
        Random random = new Random();
        r = Integer.toHexString(random.nextInt(256)).toUpperCase();
        g = Integer.toHexString(random.nextInt(256)).toUpperCase();
        b = Integer.toHexString(random.nextInt(256)).toUpperCase();

        r = r.length()==1 ? "0" + r : r ;
        g = g.length()==1 ? "0" + g : g ;
        b = b.length()==1 ? "0" + b : b ;

        return r+g+b;
    }


    /** 生成漂亮的颜色 */
    public static int generateBeautifulColor() {
        Random random = new Random();
        //为了让生成的颜色不至于太黑或者太白，所以对3个颜色的值进行限定
        int red = random.nextInt(150) + 50;//50-200
        int green = random.nextInt(150) + 50;//50-200
        int blue = random.nextInt(150) + 50;//50-200
        return Color.rgb(red, green, blue);//使用r,g,b混合生成一种新的颜色
    }


    @Override
    public int getItemCount() {
        return data.size();
    }



    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private RelativeLayout root;

        public ViewHolder(View view){
            super(view);
            tv = (TextView) view.findViewById(R.id.tv);
            root=(RelativeLayout)view.findViewById(R.id.root);
        }
    }



    //定义一个接口
}
