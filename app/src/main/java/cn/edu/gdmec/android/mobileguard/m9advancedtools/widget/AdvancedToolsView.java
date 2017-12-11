package cn.edu.gdmec.android.mobileguard.m9advancedtools.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.edu.gdmec.android.mobileguard.R;

/**
 * Created by Administrator on 2017/12/7/007.
 */

public class AdvancedToolsView extends RelativeLayout {
    private TextView mDesriptionTV;
    private String desc = "";
    private Drawable drawable;
    private ImageView mLeftImgv;

    public AdvancedToolsView(Context context) {
        super(context);
        init(context);
    }

    public AdvancedToolsView(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
        init(context);
    }

    public AdvancedToolsView(Context context, AttributeSet attrs){
        super(context,attrs);
        //拿到对象属性的值
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs,
                R.styleable.AdvancedToolsView);
        desc = mTypedArray.getString(R.styleable.AdvancedToolsView_desc);
        drawable = mTypedArray.getDrawable(R.styleable.AdvancedToolsView_android_src);
        mTypedArray.recycle();
        init(context);
    }

    /*初始化控件
    @param contex*/
    private void init(Context context){
        //将资源转化为view对象显示在自己身上
        View view = View.inflate(context,R.layout.ui_advancedtools_view,null);
        this.addView(view);
        mDesriptionTV = (TextView) findViewById(R.id.tv_decription);
        mDesriptionTV.setText(desc);
        mLeftImgv = (ImageView) findViewById(R.id.imgv_left);
        if (drawable != null)mLeftImgv.setImageDrawable(drawable);
    }
}
