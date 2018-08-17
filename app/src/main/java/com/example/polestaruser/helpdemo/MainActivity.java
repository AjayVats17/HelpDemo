package com.example.polestaruser.helpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import me.toptas.fancyshowcase.FancyShowCaseView;
import me.toptas.fancyshowcase.OnViewInflateListener;

public class MainActivity extends AppCompatActivity {

    Button btn;
    FancyShowCaseView fancyShowCaseView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);

      /*  Animation enter= AnimationUtils.loadAnimation(this,R.anim.slide_in_top);
        Animation exit= AnimationUtils.loadAnimation(this,R.anim.slide_out_bottom);
*/
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showWithCustom(v);
            }
        });
       /* exit.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });*/
    }

    private void showWithCustom(View v){
        fancyShowCaseView=new FancyShowCaseView.Builder(this).focusOn(v)
                .customView(R.layout.custom_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        view.findViewById(R.id.close_btn).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                fancyShowCaseView.hide();
                            }
                        });
                    }
                }).closeOnTouch(false).build();
        fancyShowCaseView.show();
    }
}
