package com.wjs.dialogutils2;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.IntDef;
import android.view.View;
import android.widget.TextView;

public class ConfirmDialog extends Dialog implements View.OnClickListener {
    private TextView title;
    private View titleBar;
    private View titleline;
    private View contentGroup;
    private View contentLine;
    private TextView content;
    private TextView sureButton;
    private TextView cancleButton;
    private View sureorcancle;
    public static final int MODE_SURE_OR_CANCLE=100001;
    public static final int MODE_SURE=100002;
    public static final int MODE_NO_TIELE=100003;
    public static final int MODE_HAS_TIELE=100004;
    public static final int MODE_NO_CONTENT=100005;
    public static final int MODE_HAS_CONTENT=100006;
    public @DialogMode int CURRENTMODE=MODE_SURE;
    @IntDef({MODE_SURE_OR_CANCLE,MODE_SURE,MODE_NO_TIELE,MODE_HAS_TIELE,MODE_NO_CONTENT,MODE_HAS_CONTENT})
    public @interface DialogMode{

    }
    public ConfirmDialog(Context context) {
        super(context,R.style.MyDialog);
        init(context);
    }
    public ConfirmDialog(Context context, int themeResId) {
        super(context, themeResId);
        init(context);
    }
    public void init(Context context){
        setContentView(R.layout.confirmlayout);
        title=findViewById(R.id.title);
        content=findViewById(R.id.content);
        sureButton=findViewById(R.id.sureButton);
        sureorcancle=findViewById(R.id.sureorcancle);
        sureButton.setOnClickListener(this);
        cancleButton=findViewById(R.id.cancleButton);
        titleBar=findViewById(R.id.titleBar);
        titleline=findViewById(R.id.titleline);
        contentGroup=findViewById(R.id.contentGroup);
        contentLine=findViewById(R.id.contentline);
        cancleButton.setOnClickListener(this);
        setCanceledOnTouchOutside(false);
    }
    public void setDialogMode(@DialogMode int dialogMode){
        this.CURRENTMODE=dialogMode;
        switch (dialogMode){
            case MODE_SURE:
                sureButton.setVisibility(View.VISIBLE);
                sureorcancle.setVisibility(View.GONE);
                cancleButton.setVisibility(View.GONE);
                break;
            case MODE_SURE_OR_CANCLE:
                sureButton.setVisibility(View.VISIBLE);
                sureorcancle.setVisibility(View.VISIBLE);
                cancleButton.setVisibility(View.VISIBLE);
                break;
            case MODE_NO_TIELE:
                titleBar.setVisibility(View.GONE);
                title.setVisibility(View.GONE);
                titleline.setVisibility(View.GONE);
                break;
            case MODE_HAS_TIELE:
                titleBar.setVisibility(View.VISIBLE);
                title.setVisibility(View.VISIBLE);
                titleline.setVisibility(View.VISIBLE);
                break;
            case MODE_NO_CONTENT:
                contentGroup.setVisibility(View.GONE);
                content.setVisibility(View.GONE);
                contentLine.setVisibility(View.GONE);
                break;
            case MODE_HAS_CONTENT:
                contentGroup.setVisibility(View.VISIBLE);
                content.setVisibility(View.VISIBLE);
                contentLine.setVisibility(View.VISIBLE);
                break;
        }
    }
    public void setSureButtonColor(@ColorInt int color){
        sureButton.setTextColor(color);
    }
    public void setCancleButtonColor(@ColorInt int color){
        cancleButton.setTextColor(color);
    }
    public void setContentText(String content){
        this.content.setText(content);
    }
    public void setTitleText(String title){
        this.title.setText(title);
    }
    public void setSureButtonText(String sureButtonText){
        sureButton.setText(sureButtonText);
    }
    public void setCancleButtonText(String cancleButtonText) {
       cancleButton.setText(cancleButtonText);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.sureButton){
            cancel();
        }else if(v.getId()==R.id.cancleButton){
            cancel();
        }
    }
}
