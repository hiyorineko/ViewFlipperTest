package com.example.hiyoriaya.viewflippertest;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnClickListener{

    ViewFlipper vf;
    GestureDetector gd;
    Animation inFromRight;
    Animation inFromLeft;
    Animation outToRight;
    Animation outToLeft;

    Button red;
    Button blue;
    Button yellow;
    Button purple;
    Button orange;
    Button cyan;
    Button green;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setAnimations();
    }

    public void findViews(){
        vf = (ViewFlipper)findViewById(R.id.flipper);
        gd = new GestureDetector(this,mOnGestureListener);
        red = (Button)findViewById(R.id.red);
        blue = (Button)findViewById(R.id.blue);
        yellow = (Button)findViewById(R.id.yellow);
        orange = (Button)findViewById(R.id.orange);
        purple = (Button)findViewById(R.id.purple);
        cyan = (Button)findViewById(R.id.cyan);
        green = (Button)findViewById(R.id.green);
        red.setOnClickListener(this);
        blue.setOnClickListener(this);
        yellow.setOnClickListener(this);
        orange.setOnClickListener(this);
        purple.setOnClickListener(this);
        cyan.setOnClickListener(this);
        green.setOnClickListener(this);
        tv = (TextView)findViewById(R.id.tv);
    }

    public void setAnimations(){
        inFromRight = AnimationUtils.loadAnimation(this,R.anim.right_in);
        inFromLeft = AnimationUtils.loadAnimation(this,R.anim.left_in);
        outToRight = AnimationUtils.loadAnimation(this,R.anim.right_out);
        outToLeft = AnimationUtils.loadAnimation(this,R.anim.left_out);
    }

    private final GestureDetector.SimpleOnGestureListener mOnGestureListener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onFling(MotionEvent e1,MotionEvent e2,float velocityX,float velocityY){
            float dx = Math.abs(velocityX);
            float dy = Math.abs(velocityY);
            if(dx>dy && dx>300){
                if(e1.getX()<e2.getX()){
                    vf.setInAnimation(inFromLeft);
                    vf.setOutAnimation(outToRight);
                    vf.showPrevious();
                }else{
                    vf.setInAnimation(inFromRight);
                    vf.setOutAnimation(outToLeft);
                    vf.showNext();
                }
                return true;
            }
            return false;
        }
    };

    public boolean onTouchEvent(MotionEvent event) {
        return gd.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.red:
                tv.setText("あか");
                tv.setBackgroundColor(0xFFFF0000);
                break;
            case R.id.blue:
                tv.setText("あお");
                tv.setBackgroundColor(0xFF002FFF);
                break;
            case R.id.yellow:
                tv.setText("きいろ");
                tv.setBackgroundColor(0xFFFFEA00);
                break;
            case R.id.cyan:
                tv.setText("みずいろ");
                tv.setBackgroundColor(0xFF00FFEE);
                break;
            case R.id.orange:
                tv.setText("だいだい");
                tv.setBackgroundColor(0xFFFF5E00);
                break;
            case R.id.purple:
                tv.setText("むらさき");
                tv.setBackgroundColor(0xFFD900FF);
                break;
            case R.id.green:
                tv.setText("みどり");
                tv.setBackgroundColor(0xFF26FF00);
                break;
        }
    }
}