package com.gzd.trainingcutomview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ViewGroup.LayoutParams params = getLayoutParams();
        int width = params.width;
        int height = params.height;
        int mW = MeasureSpec.getMode(widthMeasureSpec);
        switch (mW) {
            case MeasureSpec.AT_MOST:
                width = 400;
                break;
                case MeasureSpec.UNSPECIFIED:
                    width = 400;
        }
    }
}
