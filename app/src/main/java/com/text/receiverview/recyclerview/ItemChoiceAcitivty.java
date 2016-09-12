package com.text.receiverview.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/9/12.
 */
public class ItemChoiceAcitivty extends AppCompatActivity implements View.OnClickListener{
    private Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemchoice);
        //三种选择
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                Intent Intent=new Intent(ItemChoiceAcitivty.this,MainActivity.class);
                Intent.putExtra("bond","1");
                startActivity(Intent);
                break;
            case R.id.btn2:
                Intent Intent2=new Intent(ItemChoiceAcitivty.this,MainActivity.class);
                Intent2.putExtra("bond","2");
                startActivity(Intent2);
                break;
            case R.id.btn3:
                Intent Intent3=new Intent(ItemChoiceAcitivty.this,MainActivity.class);
                Intent3.putExtra("bond","3");
                startActivity(Intent3);
                break;
            case R.id.btn4:
                Intent Intent4=new Intent(ItemChoiceAcitivty.this,MainActivity.class);
                Intent4.putExtra("bond","4");
                startActivity(Intent4);
                break;
        }

    }
}
