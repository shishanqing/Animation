package com.shishanqing.property_animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

/**
 * Created by shishanqing on 16-7-19.
 * 视图动画仅仅是对View进行操作,只是改变了View的显示效果
 * 例如：当你点击位移动画效果时，再次点击按钮空白地方，还是出现效果,触发效果还是停留在原来地方
 */
public class ViewAnimaActivity extends Activity{

    private Button alphaButton;
    private Button rotateButton;
    private Button translateButton;
    private Button scaleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_anim);

        alphaButton = (Button) findViewById(R.id.alpha_button);
        rotateButton = (Button) findViewById(R.id.rotate_button);
        translateButton = (Button) findViewById(R.id.translate_button);
        scaleButton = (Button) findViewById(R.id.scale_button);

        alphaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alpha_Animation(v);
            }
        });

        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rotate_Animation(v);
            }
        });

        translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Translate_Animation(v);
            }
        });

        scaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scale_Animation(v);
            }
        });
    }

    //透明度动画
    private void Alpha_Animation(View view){
        AlphaAnimation aa = new AlphaAnimation(1, 0);
        aa.setDuration(1000);
        view.startAnimation(aa);
    }

    //旋转动画
    private void Rotate_Animation(View view){
        RotateAnimation ra = new RotateAnimation(0, 360, 0, 0);
        ra.setDuration(1000);
        view.startAnimation(ra);
    }

    //位移动画
    private void Translate_Animation(View view){
        TranslateAnimation ta = new TranslateAnimation(0, 200 ,0 ,300);
        ta.setDuration(1000);
        view.startAnimation(ta);
    }

    //缩放动画
    private void Scale_Animation(View view){
        ScaleAnimation sa = new ScaleAnimation(1 , 0, 1, 0);
        sa.setDuration(1000);
        view.startAnimation(sa);
    }
}
