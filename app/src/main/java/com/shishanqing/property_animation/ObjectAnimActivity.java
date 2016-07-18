package com.shishanqing.property_animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

/**
 *ValueAnimator和ObjectAnimator实现动画,二者区别:
 *如何利用部分API，自己更新属性实现效果；自定义TypeEvaluator实现我们的需求
 */


public class ObjectAnimActivity extends Activity {

    ImageView mBlueBall;
    float mScreenHeight;
    public static String TAG = "ObjectAnimActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_object_anim);
        //setContentView(R.layout.anim_one);
        setContentView(R.layout.anim_set);

        WindowManager wm = this.getWindowManager();

        mBlueBall = (ImageView) findViewById(R.id.id_ball);
        mScreenHeight = wm.getDefaultDisplay().getHeight();
    }

    //图片X轴旋转
    /*public void AnimRun(View view) {
        ObjectAnimator
                .ofFloat(view, "rotationX", 0.0F, 360.0F)
                .setDuration(500)
                .start();
    }*/

    //图片Y轴旋转
    /*public void AnimRun(View view) {
        ObjectAnimator
                .ofFloat(view, "rotationY", 0.0F, 360.0F)
                .setDuration(500)
                .start();
    }*/

    //图片旋转
    /*public void AnimRun(View view) {
        ObjectAnimator
                .ofFloat(view, "rotation", 0.0F, 360.0F)
                .setDuration(500)
                .start();
    }*/

    //图片X轴平移
    /*public void AnimRun(View view) {
        ObjectAnimator
                .ofFloat(view, "translationX",0.0F, 400.0F)
                .setDuration(500)
                .start();
    }*/

    //图片Y轴平移
    /*public void AnimRun(View view) {
        ObjectAnimator
                .ofFloat(view, "translationY",0.0F, 400.0F)
                .setDuration(500)
                .start();
    }*/

    //图片Y轴平移
    /*public void AnimRun(View view) {
        ObjectAnimator
                .ofFloat(view, "translationY",0.0F, 400.0F)
                .setDuration(500)
                .start();
    }*/

    //图片X轴缩放
    /*public void AnimRun(View view) {
        ObjectAnimator
                .ofFloat(view, "scaleX",1.0F, 0.0F)
                .setDuration(500)
                .start();
    }*/

    //图片Y轴缩放
    /*public void AnimRun(View view) {
        ObjectAnimator
                .ofFloat(view, "scaleY",1.0F, 0.0F)
                .setDuration(500)
                .start();
    }*/

    //图片淡出（透明）
    /*public void AnimRun(View view) {
        ObjectAnimator
                .ofFloat(view, "alpha", 0.0F)
                .setDuration(500)
                .start();
    }*/

    //既淡出又缩小
    /*public void AnimRun(final View view) {
        ObjectAnimator anim = ObjectAnimator//
                .ofFloat(view, "ssq", 1.0F, 0.0F)//
                .setDuration(500);//设置动画时长
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                view.setAlpha(cVal);
                view.setScaleX(cVal);
                view.setScaleY(cVal);
            }
        });
    }*/

    //使用PropertyValueHolder方法实现多属性动画的共同作用
    /*public void AnimRun(View view) {
        PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f ,1.0f);
        PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.0f , 1.0f);
        PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.0f, 1.0f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvh1, pvh2, pvh3)
                .setDuration(1000)
                .start();
    }*/

    /**
     * ValueAnimator本身不提供任何动画效果,更像一个数值发生器，用来产生具有一定规律的数字，
     * 从而让调用者来控制动画的实现过程，ValueAnimator的一般使用方法，通常情况下，
     * 在ValueAnimator的AnimatorUpdateListener中监听数值的变换，从而完成动画的变换
     * 自由落体
     * @param view
     */
    /*public void verticalRun( View view) {
        ValueAnimator animator = ValueAnimator.ofFloat(0, mScreenHeight
                - mBlueBall.getHeight());
        animator.setTarget(mBlueBall);
        animator.setDuration(1000).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                mBlueBall.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
    }*/

    /**
     * 抛物线
     * @param view
     */
    /*public void parabola(View view) {

        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());//插值器,可以定义动画变换速率
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
            // fraction = t / duration
            @Override
            public PointF evaluate(float fraction, PointF startValue,
                                   PointF endValue) {
                Log.e("ssq", fraction * 3 + "");
                // x方向200px/s ，则y方向0.5 * 10 * t
                PointF point = new PointF();
                point.x = 200 * fraction * 2;
                point.y = 0.5f * 170 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF point = (PointF) animation.getAnimatedValue();
                mBlueBall.setX(point.x);
                mBlueBall.setY(point.y);

            }
        });
    }*/

    /*
     * 监听动画的开始，重复，结束，被取消事件
     */
    /*public void fadeOut(View view) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(mBlueBall, "alpha", 0.5f);

        anim.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                Log.e(TAG, "onAnimationStart");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                // TODO Auto-generated method stub
                Log.e(TAG, "onAnimationRepeat");
            }

            //大部分的时候，只关心onAnimationEnd事件
            @Override
            public void onAnimationEnd(Animator animation) {
                Log.e(TAG, "onAnimationEnd");
                ViewGroup parent = (ViewGroup) mBlueBall.getParent();
                if (parent != null)
                    parent.removeView(mBlueBall);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                // TODO Auto-generated method stub
                Log.e(TAG, "onAnimationCancel");
            }
        });
        anim.start();
    }*/

    /*
     * AnimatorSet不仅能实现对于一个属性同时作用多个属性动画效果，同时也能实现更为精确的顺序控制。
     * 在属性动画中，AnimatorSet正是通过playTogether(),playSequentially(),animSet.play().with(),
     * before(),after()这些方法控制多个动画的协同工作方式，从而做动对动画顺序的精确控制
     * */
    public void togetherRun(View view) {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(mBlueBall, "scaleX",
                1.0f, 2f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(mBlueBall, "scaleY",
                1.0f, 2f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(2000);
        animSet.setInterpolator(new LinearInterpolator());
        //两个动画同时执行
        animSet.playTogether(anim1, anim2);
        animSet.start();
    }

    public void playWithAfter(View view) {
        float cx = mBlueBall.getX();

        ObjectAnimator anim1 = ObjectAnimator.ofFloat(mBlueBall, "scaleX",
                1.0f, 2f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(mBlueBall, "scaleY",
                1.0f, 2f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(mBlueBall,
                "x",  cx ,  0f);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(mBlueBall,
                "x", cx);

        /**
         * anim1，anim2,anim3同时执行
         * anim4接着执行
         */
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim1).with(anim2);
        animSet.play(anim2).with(anim3);
        animSet.play(anim4).after(anim3);
        animSet.setDuration(1000);
        animSet.start();
    }
}
