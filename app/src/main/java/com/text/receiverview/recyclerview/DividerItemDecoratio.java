package com.text.receiverview.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2016/9/12.
 */
public class DividerItemDecoratio extends RecyclerView.ItemDecoration{
    public static final int HORIZONTAL_LIST= LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST=LinearLayoutManager.VERTICAL;
    private Context Context;
    private int oretitation;
    private Drawable mDivider;


    private static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };

    DividerItemDecoratio(Context Context,int oretitation){
        this.Context=Context;
        final TypedArray a = Context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(oretitation);


    }

    public void setOrientation(int oretitation) {
        if (oretitation != HORIZONTAL_LIST && oretitation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        this.oretitation = oretitation;
    }



    //重写OnDraw方法


    @Override
    public void onDraw(Canvas c, RecyclerView parent) {
      c.drawColor(Color.parseColor("#e5e5e5"));
  /*      if (oretitation == HORIZONTAL_LIST){
            drawHorizontal(c,parent);
        }else if (oretitation == VERTICAL_LIST){
            ondrawVertical(c,parent);
        }*/

    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        if (oretitation == VERTICAL_LIST) {
            //设置分割线的高度为5
            outRect.set(0, 0, 0, 1);
        } else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }

    }
}
