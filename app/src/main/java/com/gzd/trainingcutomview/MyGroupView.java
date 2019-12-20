package com.gzd.trainingcutomview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class MyGroupView extends ViewGroup {

    public MyGroupView(Context context) {
        super(context);
    }

    public MyGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int hasUsed = 0;
        for (int i = 0; i < getChildCount(); i++) {
            //一个个子view排队来测量
            View childView = getChildAt(i);
            //要给子View的最后测量数据
            int childWCS = 0;
            //子view告诉它想要的结果
            LayoutParams lp = childView.getLayoutParams();
            //已经被前面子view使用的空间
            hasUsed += lp.width;
            //我的父view实际上给我预留的空间
            int wMode = MeasureSpec.getMode(widthMeasureSpec);
            int wSize = MeasureSpec.getSize(widthMeasureSpec);
            switch (lp.width) { //以子view的要求排前面，后面根据我的能力来满足
                default:
                case LayoutParams.WRAP_CONTENT:  //如果子view想适配大小
                    if (wMode == MeasureSpec.EXACTLY) { //假如我的父view把我的大小写死了
                        childWCS = MeasureSpec.makeMeasureSpec(wSize - hasUsed, MeasureSpec.AT_MOST); //你们不要超过我剩余的上限就好
                    } else if (wMode == MeasureSpec.AT_MOST) { //假如我的父view不让我超过它的上限就好
                        childWCS = MeasureSpec.makeMeasureSpec(wSize - hasUsed, MeasureSpec.AT_MOST); //那你们也不要超过我剩余的上限就好
                    } else {//假如我的父view给我无限空间
                        childWCS = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED); //你们爱怎么大就怎么大吧
                    }
                    break;
                case LayoutParams.MATCH_PARENT: //如果子View想填满我
                        if (wMode == MeasureSpec.EXACTLY) { //假如我的父view把我写死了
                            childWCS = MeasureSpec.makeMeasureSpec(wSize - hasUsed, MeasureSpec.EXACTLY); //那你们也只能写死这么大了
                        }else if (wMode == MeasureSpec.AT_MOST) { //假如我的父view不让我超过它的上限
                            childWCS = MeasureSpec.makeMeasureSpec(wSize - hasUsed, MeasureSpec.EXACTLY); //那你们就填满我的上限就行了
                        }
            }
            childView.measure(childWCS, 0);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {  //实际上，真正的摆布是通过xml进行操作的，那里已经指定了位置，而大小上面已经算出来了
        for (int i = 0; i < getChildCount(); i ++) {
            View child = getChildAt(i);
            child.layout(child.getLeft(), child.getTop(), child.getRight(), child.getBottom());
        }
        //这里也可能我自己进行摆布
    }
}
